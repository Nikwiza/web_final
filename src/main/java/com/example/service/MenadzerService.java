package com.example.service;

import com.example.entity.Korisnik;
import com.example.entity.Menadzer;
import com.example.repository.KorisnikRepository;
import com.example.repository.MenadzerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenadzerService {
    @Autowired
    private MenadzerRepository menadzerRepository;

    @Autowired
    private KorisnikRepository korisnikRepository;

    public String addmanager(Korisnik korisnik){
        Menadzer menadzer = new Menadzer(korisnik);
        menadzerRepository.save(menadzer);
        return "Successfully saved manager!";
    }

}
