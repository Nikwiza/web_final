package com.example.service;

import com.example.dto.KorisnikDto;
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

    public String setaccount(KorisnikDto korisnikDto, Korisnik logovanKorisnik){
        logovanKorisnik.setPol(korisnikDto.getPol());
        logovanKorisnik.setPrezime(korisnikDto.getPrezime());
        logovanKorisnik.setIme(korisnikDto.getIme());
        logovanKorisnik.setDatum_rodjenja(korisnikDto.getDatum_rodjenja());
        Korisnik temp = korisnikRepository.getByKorisnicko(korisnikDto.getKorisnicko_ime());

        if(temp == null || korisnikDto.getKorisnicko_ime().equals(logovanKorisnik.getKorisnicko())){
            logovanKorisnik.setKorisnicko(korisnikDto.getKorisnicko_ime());
            korisnikRepository.save(logovanKorisnik);
            return "Uspesno promenjeni podatci";
        }
        return "Korisnicko ime vec postoji";


    }



}
