package com.example.service;

import com.example.entity.Korisnik;
import com.example.entity.Kupac;
import com.example.repository.KorisnikRepository;
import com.example.repository.KupacRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.Optional;

@Service
public class KorisnikService {
    @Autowired
    private KorisnikRepository korisnikRepository;
    @Autowired
    private KupacRepository kupacRepository;

    public String register(Korisnik korisnik){
        Kupac novi_korisnik = new Kupac(korisnik);
        kupacRepository.save(novi_korisnik);
        return "Registered successfully!!";
    }

    public Korisnik login(String korisnicko, String lozinka) {
        Korisnik korisnik = korisnikRepository.getByKorisnicko(korisnicko);
        if(korisnik == null || !korisnik.getLozinka().equals(lozinka)){
        return null;}
        return korisnik;
    }

}
