package com.example.service;


import com.example.dto.KorisnikDto;
import com.example.entity.Korisnik;
import com.example.entity.Menadzer;
import com.example.entity.Restoran;
import com.example.repository.KorisnikRepository;
import com.example.repository.MenadzerRepository;
import com.example.repository.RestoranRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminService {
    @Autowired
    KorisnikRepository korisnikRepository;

    @Autowired
    RestoranRepository restoranRepository;

    @Autowired
    MenadzerRepository menadzerRepository;

    public List<KorisnikDto> uvid_u_korisnike(){
        List<Korisnik> korisnici = korisnikRepository.findAll();
        List<KorisnikDto> korisniciDto = new ArrayList<>();
        KorisnikDto temp;
        for(Korisnik k : korisnici){
            temp = new KorisnikDto(k);
            korisniciDto.add(temp);
        }
        return korisniciDto;
    }

    public void napravi_restoran(Restoran restoran){
        restoranRepository.save(restoran);
    }

    public String set_restoran_menager (String ime, String menadzer_ime){
       Menadzer menadzer = menadzerRepository.findByKorisnicko(menadzer_ime);
       Restoran restoran = restoranRepository.findByNaziv(ime);
       if(menadzer == null || restoran == null){
           return "Doslo je do greske, nesto od ponudjenog nije validan podatak. ";
       }
       menadzer.setRestoran(restoran);
       menadzerRepository.save(menadzer);
       return "Uspesno postavljen menadzer! ";
    }
}
