package com.example.service;


import com.example.dto.KorisnikDto;
import com.example.entity.Korisnik;
import com.example.repository.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminService {
    @Autowired
    KorisnikRepository korisnikRepository;

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
}
