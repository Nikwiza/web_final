package com.example.service;

import com.example.dto.PorudzbinaDto;
import com.example.entity.*;
import com.example.repository.KupacRepository;
import com.example.repository.PorudzbinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PorudzbinaService {
    @Autowired
    PorudzbinaRepository porudzbinaRepository;

    @Autowired
    KupacService kupacService;

    @Autowired
    DostavljacService dostavljacService;

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
}
