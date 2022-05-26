package com.example.service;

import com.example.entity.Lokacija;
import com.example.repository.LokacijaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LokacijaService {
    @Autowired
    LokacijaRepository lokacijaRepository;


    public Lokacija findByAdress(String adress){
        Lokacija lokacija = lokacijaRepository.findByAdresa(adress);
        return lokacija;
    }
}
