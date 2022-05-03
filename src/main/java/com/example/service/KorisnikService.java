package com.example.service;

import com.example.entity.Korisnik;
import com.example.entity.Kupac;
import com.example.entity.Pol;
import com.example.repository.KorisnikRepository;
import com.example.repository.KupacRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public String setUsername(String username, Korisnik korisnik){
        Korisnik test = korisnikRepository.getByKorisnicko(username);
        if(test != null){
            return "Username already in use";
        }
            korisnik.setKorisnicko(username);
            korisnikRepository.save(korisnik);
            return "Username set successfully!!";

    }
    public String setPassword(String password, Korisnik korisnik){
        korisnik.setLozinka(password);
        korisnikRepository.save(korisnik);
        return "Password set successfully!!";
    }

    public String setIme(String ime, Korisnik korisnik){
        korisnik.setIme(ime);
        korisnikRepository.save(korisnik);
        return "First name set successfully!!";
    }

    public String setPrezime(String prezime, Korisnik korisnik){
        korisnik.setPrezime(prezime);
        korisnikRepository.save(korisnik);
        return "Last name set successfully!!";
    }
//
//    public String setPol(String pol, Korisnik korisnik){
//        korisnikRepository.save(korisnik);
//        return "First name set successfully!!";
//    }

    //set date


}
