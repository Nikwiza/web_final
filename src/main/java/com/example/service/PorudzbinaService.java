package com.example.service;

import com.example.dto.PorudzbinaDto;
import com.example.dto.RestoranDto;
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

    public String purchaseMade(Set<Stavka> stavke, RestoranDto restoranDto, Date datum, float cena, Korisnik kupac ){
        Kupac kupacl = kupacService.findKupac(kupac);
        Restoran restoran = restoranService.findByName(restoranDto.getNaziv());
        if(kupacl == null || restoran == null){
            return "Doslo je do greske!";
        }
        Porudzbina porudzbina = new Porudzbina(stavke, restoran, datum , cena, kupacl);
        porudzbinaRepository.save(porudzbina);
        return "Uspesno odradjeno!";
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
