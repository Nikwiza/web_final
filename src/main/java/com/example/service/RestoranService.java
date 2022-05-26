package com.example.service;


import com.example.dto.KomentarDto;
import com.example.dto.RestoranDto;
import com.example.entity.Artikal;
import com.example.entity.Lokacija;
import com.example.entity.Restoran;
import com.example.repository.MenadzerRepository;
import com.example.repository.RestoranRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    KomentarService komentarService;

    @Autowired
    ArtikalService artikalService;

    @Autowired
    LokacijaService lokacijaService;

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

    public List<RestoranDto> restorani_tip(String tip_restorana){
        List<Restoran> restorani = restoranRepository.findByTip(tip_restorana);
        List<RestoranDto> restoranDtos = new ArrayList<>();
        RestoranDto temp;
        for(Restoran r : restorani) {
        temp = new RestoranDto(r);
        restoranDtos.add(temp);
        }
        return restoranDtos;
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


    public RestoranDto restorani_lokacija(String adresa){
        Lokacija lokacija = lokacijaService.findByAdress(adresa);
        if(lokacija == null){
            return null;
        }
        //todo: find better implementation
        //Svestan sam da ovo nije najbolja implementacija, posebno ako skejlujemo, ali nemam trenutno vremena da smisljam drugu
        List<Restoran> restorani = restoranRepository.findAll();
        for(Restoran r : restorani){
            for(Lokacija l : r.getLokacija()){
                if(l.equals(lokacija)){
                    return new RestoranDto(r);
                }
            }
        }
        return null;
    }

}
