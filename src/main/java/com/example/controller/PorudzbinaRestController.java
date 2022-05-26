package com.example.controller;

import com.example.dto.PorudzbinaDto;
import com.example.entity.*;
import com.example.repository.PorudzbinaRepository;
import com.example.service.PorudzbinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Set;

@RestController
public class PorudzbinaRestController {
    @Autowired
    PorudzbinaService porudzbinaService;

    @GetMapping("/porudzbine")
    public ResponseEntity<Set<PorudzbinaDto>> getPorudzbine(HttpSession session){
        Korisnik logovaniKorisnik = (Kupac)session.getAttribute("korisnik");
        if(logovaniKorisnik == null || logovaniKorisnik.getUloga() != Uloga.KUPAC) {
            return new ResponseEntity("You are not permmitet to do that!", HttpStatus.FORBIDDEN);
        }
        Set<PorudzbinaDto> porudzbinas = porudzbinaService.poruzbineKorisnik(logovaniKorisnik);
        return ResponseEntity.ok(porudzbinas);
    }

    @GetMapping("/delivery")
    public ResponseEntity<Set<PorudzbinaDto>> getPorudzbineDelivery(HttpSession session){
        Korisnik logovaniKorisnik = (Dostavljac)session.getAttribute("korisnik");
        if(logovaniKorisnik == null || logovaniKorisnik.getUloga() != Uloga.DOSTAVLJAC) {
            return new ResponseEntity("You are not permmitet to do that!", HttpStatus.FORBIDDEN);
        }
        Set<PorudzbinaDto> porudzbinas = porudzbinaService.PorudzbineDostavljaca(logovaniKorisnik);
        return ResponseEntity.ok(porudzbinas);
    }
}
