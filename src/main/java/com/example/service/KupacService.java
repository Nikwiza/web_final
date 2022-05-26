package com.example.service;

import com.example.entity.Korisnik;
import com.example.entity.Kupac;
import com.example.repository.KupacRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KupacService {
    @Autowired
    KupacRepository kupacRepository;

    public Kupac findKupac(Korisnik korisni){
        Kupac kupac = kupacRepository.findByKorisnicko(korisni.getKorisnicko());
        return kupac;
    }

    public void saveKupc(Kupac kupac){
        kupacRepository.save(kupac);
    }
}
