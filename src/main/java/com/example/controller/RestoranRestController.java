package com.example.controller;

import com.example.dto.RestoranDto;
import com.example.entity.Restoran;
import com.example.repository.RestoranRepository;
import com.example.service.RestoranService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestoranRestController {
    @Autowired
    RestoranRepository restoranRepository;

    @Autowired
    RestoranService restoranService;


    @GetMapping("/")
    public List<RestoranDto> welcome(){
        List<RestoranDto> restorani = restoranService.restorani();
        return  restorani;
    }

}
