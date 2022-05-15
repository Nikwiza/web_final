package com.example.controller;


import com.example.dto.RestoranDto;
import com.example.entity.*;
import com.example.service.MenadzerService;
import com.example.service.RestoranService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Set;

import static org.springframework.http.ResponseEntity.ok;

@RestController
public class MenadzerRestoController {
    @Autowired
    MenadzerService menadzerService;

    @GetMapping("/menadzer/restoran")
    public ResponseEntity<Restoran> mojrestoran(HttpSession session){
        Korisnik logovaniKorisnik = (Menadzer)session.getAttribute("korisnik");
        if(logovaniKorisnik == null || logovaniKorisnik.getUloga() != Uloga.MENADZER) {
            return new ResponseEntity("You are not permmitet to do that!", HttpStatus.FORBIDDEN);
        }
        Restoran restoran = menadzerService.findrestoran(logovaniKorisnik);
        return ok(restoran);
    }

    @GetMapping("/menadzer/restoran/porudzbine")
    public ResponseEntity<Set<Porudzbina>> mojeporudzbiine(HttpSession session) {
        Korisnik logovaniKorisnik = (Menadzer) session.getAttribute("korisnik");
        if (logovaniKorisnik == null || logovaniKorisnik.getUloga() != Uloga.MENADZER) {
            return new ResponseEntity("You are not permmitet to do that!", HttpStatus.FORBIDDEN);
        }
        Set<Porudzbina> porudzbine = menadzerService.findporudzbine(logovaniKorisnik);
        return new ResponseEntity<Set<Porudzbina>>(porudzbine, HttpStatus.OK);
    }
}
