package com.example.service;


import com.example.entity.Dostavljac;
import com.example.entity.Korisnik;
import com.example.entity.Menadzer;
import com.example.repository.DostavljacRepository;
import com.example.repository.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DostavljacService {
    @Autowired
    private DostavljacRepository dostavljacRepository;
    @Autowired
    private KorisnikRepository korisnikRepository;

    public String adddelivery(Korisnik korisnik){
        Dostavljac dostavljac = new Dostavljac(korisnik);
        dostavljacRepository.save(dostavljac);
        return "Successfully added new delivery employee!";
    }

    public Dostavljac findDostavljac(Korisnik korisnik){
        Dostavljac dostavljac = dostavljacRepository.getById(korisnik.getIdKorisnika());
        return dostavljac;
    }
}
