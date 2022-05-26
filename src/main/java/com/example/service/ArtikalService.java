package com.example.service;

import com.example.entity.Artikal;
import com.example.entity.Restoran;
import com.example.repository.ArtikalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ArtikalService {
    @Autowired
    ArtikalRepository artikalRepository;


    public Set<Artikal> dtoArtikliPoRestoranu(Restoran restoran) {
        Set<Artikal> artikli = restoran.getArtikli();
        return artikli;
    }
}
