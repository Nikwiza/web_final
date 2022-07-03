package com.example.service;

import com.example.dto.KomentarDto;
import com.example.entity.Komentar;
import com.example.entity.Restoran;
import com.example.repository.KomentarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class KomentarService {
    @Autowired
    KomentarRepository komentarRepository;

    public Set<KomentarDto> dtoKomentariPoRestoranu(Restoran restoran){
        Set<Komentar> komentari = komentarRepository.getByRestoran(restoran);
        Set<KomentarDto> komentarDtos = new HashSet<>();
        for(Komentar k : komentari){
            KomentarDto temp = new KomentarDto(k);
            komentarDtos.add(temp);
        }
        return komentarDtos;
    }

    public float getProsekOcena (Restoran restoran){
        int brKom = 0;
        int zbirOcena = 0;
        float prosekOcena = 0;
        Set<Komentar> komentari = komentarRepository.getByRestoran(restoran);
        for(Komentar k : komentari){
            brKom++;
            zbirOcena += k.getOcena();
        }
        if(brKom == 0){
            return 0;
        }
        prosekOcena = zbirOcena/brKom;
        return prosekOcena;
    }

    public boolean saveKomentar (Komentar komentar){
        komentarRepository.save(komentar);
        return true;
    }

}
