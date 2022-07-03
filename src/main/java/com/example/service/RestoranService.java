package com.example.service;


import com.example.dto.KomentarDto;
import com.example.dto.RestoranDto;
import com.example.dto.SearchDto;
import com.example.dto.StatusRestorana;
import com.example.entity.*;
import com.example.repository.ArtikalRepository;
import com.example.repository.MenadzerRepository;
import com.example.repository.RestoranRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class RestoranService {
    @Autowired
    RestoranRepository restoranRepository;

    @Autowired
    MenadzerRepository menadzerRepository;

    @Autowired
    ArtikalRepository artikalRepository;

    @Autowired
    KomentarService komentarService;

    @Autowired
    ArtikalService artikalService;

    @Autowired
    LokacijaService lokacijaService;

    @Autowired
    MenadzerService menadzerService;


    //Finds all the restaurants in the DB, turns them into restaurantsDTO and sends them back.

    public List<RestoranDto> restorani(){
        List<Restoran> restorani = restoranRepository.findAll();
        List<RestoranDto> restoraniDto = new ArrayList<>();
        RestoranDto temp;
        for(Restoran restoran : restorani){
            temp = new RestoranDto(restoran);
            restoraniDto.add(temp);
        }
        return restoraniDto;
    }

    public String toggle(Korisnik korisnik) {
        Restoran restoran = menadzerService.findrestoran(korisnik);
        if(restoran == null){
            return "Nemate restoran!";
        }

        StatusRestorana status = restoran.getStatus();
        if(status.equals(StatusRestorana.RADI)){
            restoran.setStatus(StatusRestorana.NE_RADI);
        }
        else {
            restoran.setStatus(StatusRestorana.RADI);
        }
        restoranRepository.save(restoran);
        return "Uspesno promenjen status";
    }

    public List<Restoran> restorani_tip(String tip){
        if(tip.isEmpty()){
            List<Restoran> restorans = restoranRepository.findAll();
            return restorans;
        }
        List<Restoran> restorani = restoranRepository.findByTip(tip);
        return restorani;
    }

    public Set<KomentarDto> komentari(Restoran restoran){
        Set<KomentarDto> komentari = komentarService.dtoKomentariPoRestoranu(restoran);
        return komentari;
    }

    public Set<Artikal> artikli(Restoran restoran){
        return artikalService.dtoArtikliPoRestoranu(restoran);
    }

    public float ocena(Restoran restoran)
    {
        float prosekOcena = komentarService.getProsekOcena(restoran);
        return prosekOcena;
    }


    public List<RestoranDto> search(SearchDto s){
        //todo: find better implementation
        //Svestan sam da ovo nije najbolja implementacija, posebno ako skejlujemo, ali nemam trenutno vremena da smisljam drugu
        List<Restoran> restorani = new ArrayList<>();
        List<RestoranDto> restoraniDto = new ArrayList<>();
        if(s.getTip().isEmpty()){
            restorani = restoranRepository.findAll();
        }else{
            restorani = restoranRepository.findByTip(s.getTip());
        }

        if(restorani.isEmpty()){
            return restoraniDto;
        }

        if(s.getLokacija().isEmpty() && s.getNaziv().isEmpty()){
            for(Restoran r : restorani){
                RestoranDto restoranDto = new RestoranDto(r);
                restoraniDto.add(restoranDto);
            }
            return restoraniDto;
        }

        for(Restoran r : restorani){
            if(r.getNaziv().contains(s.getNaziv()) && !s.getNaziv().isEmpty()) {
                RestoranDto restoranDto = new RestoranDto(r);
                restoraniDto.add(restoranDto);
            }
            else {
                for (Lokacija l : r.getLokacija()) {
                    String adr = l.getAdresa();
                    if (adr.contains(s.getLokacija()) && !s.getLokacija().isEmpty()) {
                        RestoranDto restoranDto = new RestoranDto(r);
                        restoraniDto.add(restoranDto);
                        break;
                    }
                }
            }

        }
            return restoraniDto;
    }

    public String addArtikal(Artikal artikal, Korisnik menadzer){
        Restoran restoran = menadzerService.findrestoran(menadzer);

        if(restoran == null){
            return "Vi ne posedujete restoran";
        }
        Set<Artikal> artikli = restoran.getArtikli();
        //Nisam koristio repository jer mi je ovako lakse da postavljam svoje kriterijume za "Artikal postoji"
        for(Artikal a : artikli){
            if (a.getNaziv().equals(artikal.getNaziv()) &&
                a.getKolicina() == artikal.getKolicina() &&
                a.getTip().equals(artikal.getTip())) {

                return "Ovaj artikal postoji";
            }
            if(a.getIdArtikla() == artikal.getIdArtikla()){
                return "Ovaj ID vec postoji";
            }
        }
        artikli.add(artikal);
        restoran.setArtikli(artikli);
        restoranRepository.save(restoran);
        return "Uspesno dodat artikal";

    }

    public String changeArtikal(Artikal artikal, Korisnik menadzer){
        Restoran restoran = menadzerService.findrestoran(menadzer);

        if(restoran == null){
            return "Vi ne posedujete restoran";
        }
        Set<Artikal> artikli = restoran.getArtikli();
        for(Artikal a : artikli){
            if(a.getIdArtikla().equals(artikal.getIdArtikla())){
                a.setCena(artikal.getCena());
                a.setKolicina(artikal.getKolicina());
                a.setNaziv(artikal.getNaziv());
                a.setOpis(artikal.getOpis());
                a.setTip(artikal.getTip());

                restoran.setArtikli(artikli);
                restoranRepository.save(restoran);

                return "Uspesno promenjen artikal!";
            }
        }
        return "Artikal sa tim ID nije pronadjen u Vasem restoranu";

    }

    public Artikal findArtikal(Long id, Korisnik menadzer){

        Restoran restoran = menadzerService.findrestoran(menadzer);
        Set<Artikal> artikli = restoran.getArtikli();
        for(Artikal a : artikli){
            if(a.getIdArtikla().equals(id)){
                return a;
            }
        }
        return null;
    }

    public String removeArtikal(Long id, Korisnik menadzer){
        Restoran restoran = menadzerService.findrestoran(menadzer);
        Set<Artikal> artikli = restoran.getArtikli();
        for(Artikal a : artikli){
            if(a.getIdArtikla().equals(id)){
                artikalRepository.delete(a);
                artikli.remove(a);
                restoran.setArtikli(artikli);
                restoranRepository.save(restoran);
                return "Uspesno uklonjen!";
            }
        }
        return "Nije Pronadzen!";
    }

    public Restoran findByName(String name){
        Restoran restoran = restoranRepository.findByNaziv(name);
        return restoran;
    }


}
