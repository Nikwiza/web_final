package com.example.service;


import com.example.dto.RestoranDto;
import com.example.entity.Restoran;
import com.example.repository.MenadzerRepository;
import com.example.repository.RestoranRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RestoranService {
    @Autowired
    RestoranRepository restoranRepository;

    @Autowired
    MenadzerRepository menadzerRepository;

    //Finds all the restaurants in the DB, turns them into restaurantsDTO and sends them back.

    public List<RestoranDto> restorani(){
        List<Restoran> restorani = restoranRepository.findAll();
        List<RestoranDto> restoraniDto = new ArrayList<>();
        RestoranDto temp;
        for(Restoran restoran : restorani){
            temp = new RestoranDto(restoran);
            restoraniDto.add(temp);
        }
        return restoraniDto;
    }

    public List<RestoranDto> restorani_tip(String tip_restorana){
        List<Restoran> restorani = restoranRepository.findByTip(tip_restorana);
        List<RestoranDto> restoranDtos = new ArrayList<>();
        RestoranDto temp;
        for(Restoran r : restorani) {
        temp = new RestoranDto(r);
        restoranDtos.add(temp);
        }
        return restoranDtos;
    }

}
