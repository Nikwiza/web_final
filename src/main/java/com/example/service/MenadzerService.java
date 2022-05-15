package com.example.service;

import com.example.entity.*;
import com.example.repository.KorisnikRepository;
import com.example.repository.MenadzerRepository;
import com.example.repository.PorudzbinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class MenadzerService {
    @Autowired
    private MenadzerRepository menadzerRepository;

    @Autowired
    private KorisnikRepository korisnikRepository;

    @Autowired
    private PorudzbinaRepository porudzbinaRepository;


    public String addmanager(Korisnik korisnik){
        Menadzer menadzer = new Menadzer(korisnik);
        menadzerRepository.save(menadzer);
        return "Successfully saved manager!";
    }

    public Set<Porudzbina> getPorudzbineZaRestoran(Menadzer menadzer){
        Set<Porudzbina> porudzbine = porudzbinaRepository.getByRestoran(menadzer.getRestoran());
        return porudzbine;
    }

    public Restoran findrestoran(Korisnik korisnik){
       Menadzer temp = menadzerRepository.getById(korisnik.getIdKorisnika());
       return temp.getRestoran();
    }

    public Set<Porudzbina> findporudzbine(Korisnik korisnik){
        Menadzer temp = menadzerRepository.getById(korisnik.getIdKorisnika());
        Set<Porudzbina> porudzbine = porudzbinaRepository.getByRestoran(temp.getRestoran());
        return porudzbine;
    }

}
