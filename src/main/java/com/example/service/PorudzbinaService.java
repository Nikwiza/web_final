package com.example.service;

import com.example.dto.PorudzbinaDto;
import com.example.dto.RestoranDto;
import com.example.dto.StavkaDto;
import com.example.entity.*;
import com.example.repository.KupacRepository;
import com.example.repository.PorudzbinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PorudzbinaService {
    @Autowired
    PorudzbinaRepository porudzbinaRepository;

    @Autowired
    KupacService kupacService;

    @Autowired
    DostavljacService dostavljacService;

    @Autowired
    RestoranService restoranService;

    @Autowired
    ArtikalService artikalService;

    public Set<PorudzbinaDto> poruzbineKorisnik (Korisnik korisnik){
        Kupac kupac = kupacService.findKupac(korisnik);
        if(kupac == null){
            return null;
        }
        Set<Porudzbina> porudzbinas = porudzbinaRepository.getByKupac(kupac);
        Set<PorudzbinaDto> porudzbinaDtos = new HashSet<>();
        for(Porudzbina p : porudzbinas){
            PorudzbinaDto temp = new PorudzbinaDto(p);
            porudzbinaDtos.add(temp);
        }
        return porudzbinaDtos;
    }

    public Set<PorudzbinaDto> PorudzbineDostavljaca (Korisnik korisnik){
        List<Porudzbina> porudzbinas= porudzbinaRepository.findAll();
        Set<PorudzbinaDto> porudzbinaDtos = new HashSet<>();
        for(Porudzbina p : porudzbinas){
            if(p.getStatus() == Status.CEKA_DOSTAVLJACA){
                PorudzbinaDto temp = new PorudzbinaDto(p);
                porudzbinaDtos.add(temp);
            }
        }
        return porudzbinaDtos;
    }

    //todo: wathc out
    public String addToCart(Korisnik kupac, Long artikal, int kolicina){
        Kupac kupacl = kupacService.findKupac(kupac);
        Artikal artikall = artikalService.findById(artikal);
        if(kupacl == null || artikall == null){
            return "Imamo problem!";
        }
        List<Porudzbina> porudzbine = kupacl.getPorudzbine();

        Porudzbina temp = porudzbine.get(porudzbine.size() - 1);
        float cena = temp.getCena();
        cena +=(artikall.getCena()*kolicina);
        temp.setCena(cena);

        Set<Stavka> stavke = temp.getStavke();
        for(Stavka s : stavke){
            if(s.getArtikal().getIdArtikla() == artikall.getIdArtikla()){
                int broj = s.getBroj();
                broj += kolicina;
                s.setBroj(broj);
                temp.setStavke(stavke);
                porudzbinaRepository.save(temp);
                return "Uspesno dodato!!";
            }
        }

        Stavka stavka = new Stavka(artikall, kolicina);
        stavke.add(stavka);
        temp.setStavke(stavke);
        porudzbinaRepository.save(temp);
        return "Uspesno dodato!";
    }
    public String purchaseMade(Korisnik kupac, String restoranDto){
        Kupac kupacl = kupacService.findKupac(kupac);
        Restoran restoran = restoranService.findByName(restoranDto);
        List<Porudzbina> porudbine = kupacl.getPorudzbine();
        if(kupacl == null || restoran == null || kupacl.getPorudzbine().get(porudbine.size()-1).getCena() == 0){
            return "Nije validna porudzbina";
        }
        Porudzbina porudzbina = new Porudzbina();
        Porudzbina temp = porudbine.get(porudbine.size() - 1);
        temp.setStatus(Status.OBRADA);
        temp.setRestoran(restoran);
        Date date = new Date();
        temp.setDatum(date);
        temp.setKupac(kupacl);
        porudzbina.setKupac(kupacl);
        porudzbinaRepository.save(temp);
        porudbine.add(porudzbina);
        kupacl.setPorudzbine(porudbine);
        kupacService.saveKupc(kupacl);
        return "Uspesno dodato! " + porudbine.size();
    }

    public String removeFromCart(Korisnik kupac, StavkaDto stavkaDto){
        Long artikal = stavkaDto.getArtikal();
        int kolicina = stavkaDto.getBroj();

        Kupac kupacl = kupacService.findKupac(kupac);
        Artikal artikall = artikalService.findById(artikal);
        if(kupacl == null || artikall == null){
            return "Imamo problem!";
        }

        List<Porudzbina> porudzbine = kupacl.getPorudzbine();
        Porudzbina temp = porudzbine.get(porudzbine.size() - 1);

        Set<Stavka> stavke = temp.getStavke();
        for(Stavka s : stavke){
           // return "test " + s.getArtikal().getIdArtikla() + "Compared to ? " + artikall.getIdArtikla();
            if(s.getArtikal().getIdArtikla() == artikall.getIdArtikla() && s.getBroj()>=kolicina){
                // Smanjujemo broj artikala ako mozemo
                int broj = s.getBroj();
                broj -= kolicina;
                s.setBroj(broj);
                // Smanjujemo cenu
                float cena = temp.getCena();
                cena -=(artikall.getCena()*kolicina);
                temp.setCena(cena);
                //Cuvamo pomene
                temp.setStavke(stavke);
                porudzbinaRepository.save(temp);
                return "Uspesno uklonjeno" + s.getBroj();
            }
        }

        return "Nije moguce smanjiti" ;
    }

    public String odobriPorudzbinu(UUID uuid){
        Porudzbina porudzbina = porudzbinaRepository.getById(uuid);
        if(porudzbina == null){
            return "Nije validna porudzbina";
        }
        porudzbina.setStatus(Status.U_PRIPREMI);
        porudzbinaRepository.save(porudzbina);
        return "Uspesno izvrseno!";
    }

    public String posaljiPorudzbinu(UUID uuid){
        Porudzbina porudzbina = porudzbinaRepository.getById(uuid);
        if(porudzbina == null){
            return "Nije validna porudzbina";
        }
        porudzbina.setStatus(Status.CEKA_DOSTAVLJACA);
        porudzbinaRepository.save(porudzbina);
        return "Uspesno izvrseno!";
    }

    public String preuzmi(UUID uuid){
        Porudzbina porudzbina = porudzbinaRepository.getById(uuid);
        if(porudzbina == null){
            return "Nije validna porudzbina";
        }
        porudzbina.setStatus(Status.U_TRANSPORTU);
        porudzbinaRepository.save(porudzbina);
        return "Uspesno izvrseno!";
    }

    public String dostavi(UUID uuid){
        Porudzbina porudzbina = porudzbinaRepository.getById(uuid);
        if(porudzbina == null){
            return "Nije validna porudzbina";
        }
        porudzbina.setStatus(Status.DOSTAVLJENA);
        Kupac kupac = porudzbina.getKupac();
        int bodovi = kupac.getBroj_skupljenih_bodova();
        bodovi += (porudzbina.getCena()/1000)*133;
        kupac.setBroj_skupljenih_bodova(bodovi);
        kupacService.saveKupc(kupac);
        porudzbinaRepository.save(porudzbina);
        return "Uspesno izvrseno!";
    }

}
