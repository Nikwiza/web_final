package com.example.controller;

import com.example.dto.KomentarDto;
import com.example.dto.PorudzbinaDto;
import com.example.dto.RestoranDto;
import com.example.dto.StavkaDto;
import com.example.entity.*;
import com.example.repository.PorudzbinaRepository;
import com.example.service.PorudzbinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@RestController
public class PorudzbinaRestController {
    @Autowired
    PorudzbinaService porudzbinaService;


    @PostMapping("/komentar")
    public ResponseEntity<String> komentarisi(@RequestBody KomentarDto komentar, HttpSession session){
        Korisnik logovaniKorisnik = (Korisnik) session.getAttribute("korisnik");
        if(logovaniKorisnik == null || logovaniKorisnik.getUloga() != Uloga.KUPAC) {
            return new ResponseEntity("You are not permmitet to do that!", HttpStatus.FORBIDDEN);
        }
        String suuid = komentar.getUuid().replaceFirst("(\\p{XDigit}{8})(\\p{XDigit}{4})(\\p{XDigit}{4})(\\p{XDigit}{4})(\\p{XDigit}+)", "$1-$2-$3-$4-$5").toString();
        System.out.println(suuid);
        UUID uuid = UUID.fromString(suuid);
        String response = porudzbinaService.komentarisi(logovaniKorisnik, uuid, komentar);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/porudzbine")
    public ResponseEntity<Set<PorudzbinaDto>> getPorudzbine(HttpSession session){
        Korisnik logovaniKorisnik = (Korisnik) session.getAttribute("korisnik");
        if(logovaniKorisnik == null || logovaniKorisnik.getUloga() != Uloga.KUPAC) {
            return new ResponseEntity("You are not permmitet to do that!", HttpStatus.FORBIDDEN);
        }
        Set<PorudzbinaDto> porudzbinas = porudzbinaService.poruzbineKorisnik(logovaniKorisnik);
        return ResponseEntity.ok(porudzbinas);
    }

    @GetMapping("/delivery")
    public ResponseEntity<Set<PorudzbinaDto>> getPorudzbineDelivery(HttpSession session){
        Korisnik logovaniKorisnik = (Korisnik) session.getAttribute("korisnik");
        if(logovaniKorisnik == null || logovaniKorisnik.getUloga() != Uloga.DOSTAVLJAC) {
            return new ResponseEntity("You are not permmitet to do that!", HttpStatus.FORBIDDEN);
        }
        Set<PorudzbinaDto> porudzbinas = porudzbinaService.PorudzbineDostavljaca(logovaniKorisnik);
        return ResponseEntity.ok(porudzbinas);
    }

    @PostMapping("/korpa")
    //Znam da bi se cena trebala racunati da ne bi doslo do toga da je neko promeni u requestu, ali tu takodje ima posla
    public ResponseEntity<String> korpa(@RequestBody String restoranDto, HttpSession session){

        Korisnik logovaniKorisnik = (Korisnik) session.getAttribute("korisnik");
        if(logovaniKorisnik == null || logovaniKorisnik.getUloga() != Uloga.KUPAC) {
            return new ResponseEntity("You are not permmitet to do that!", HttpStatus.FORBIDDEN);
        }
        String response = porudzbinaService.purchaseMade(logovaniKorisnik, restoranDto);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/porudzbina/odobri")
    public ResponseEntity<String> odobri(@RequestBody String ssuuid, HttpSession session){
        String suuid = ssuuid.replaceFirst("(\\p{XDigit}{8})(\\p{XDigit}{4})(\\p{XDigit}{4})(\\p{XDigit}{4})(\\p{XDigit}+)", "$1-$2-$3-$4-$5").toString();
        System.out.println(suuid);
        UUID uuid = UUID.fromString(suuid);
        Korisnik logovaniKorisnik = (Korisnik) session.getAttribute("korisnik");
        if(logovaniKorisnik == null || logovaniKorisnik.getUloga() != Uloga.MENADZER) {
            return new ResponseEntity("You are not permmitet to do that!", HttpStatus.FORBIDDEN);
        }
        String response = porudzbinaService.odobriPorudzbinu(uuid);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/porudzbina/prosledi")
    public ResponseEntity<String> prosledi(@RequestBody String ssuuid, HttpSession session){
        String suuid = ssuuid.replaceFirst("(\\p{XDigit}{8})(\\p{XDigit}{4})(\\p{XDigit}{4})(\\p{XDigit}{4})(\\p{XDigit}+)", "$1-$2-$3-$4-$5").toString();
        System.out.println(suuid);
        UUID uuid = UUID.fromString(suuid);
        Korisnik logovaniKorisnik = (Korisnik) session.getAttribute("korisnik");
        if(logovaniKorisnik == null || logovaniKorisnik.getUloga() != Uloga.MENADZER) {
            return new ResponseEntity("You are not permmitet to do that!", HttpStatus.FORBIDDEN);
        }
        String response = porudzbinaService.posaljiPorudzbinu(uuid);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/porudzbina/preuzmi")
    public ResponseEntity<String> preuzmi(@RequestBody String ssuuid, HttpSession session){
        String suuid = ssuuid.replaceFirst("(\\p{XDigit}{8})(\\p{XDigit}{4})(\\p{XDigit}{4})(\\p{XDigit}{4})(\\p{XDigit}+)", "$1-$2-$3-$4-$5").toString();
        System.out.println(suuid);
        UUID uuid = UUID.fromString(suuid);
        Korisnik logovaniKorisnik = (Korisnik) session.getAttribute("korisnik");
        if(logovaniKorisnik == null || logovaniKorisnik.getUloga() != Uloga.DOSTAVLJAC) {
            return new ResponseEntity("You are not permmitet to do that!", HttpStatus.FORBIDDEN);
        }
        String response = porudzbinaService.preuzmi(uuid, logovaniKorisnik);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/porudzbina/dostavi")
    public ResponseEntity<String> dostavi(@RequestBody String ssuuid, HttpSession session){
        String suuid = ssuuid.replaceFirst("(\\p{XDigit}{8})(\\p{XDigit}{4})(\\p{XDigit}{4})(\\p{XDigit}{4})(\\p{XDigit}+)", "$1-$2-$3-$4-$5").toString();
        System.out.println(suuid);
        UUID uuid = UUID.fromString(suuid);
        Korisnik logovaniKorisnik = (Korisnik) session.getAttribute("korisnik");
        if(logovaniKorisnik == null || logovaniKorisnik.getUloga() != Uloga.DOSTAVLJAC) {
            return new ResponseEntity("You are not permmitet to do that!", HttpStatus.FORBIDDEN);
        }
        String response = porudzbinaService.dostavi(uuid);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/korpa/add")
    public ResponseEntity<String> dodaj(@RequestBody StavkaDto stavkaDto, HttpSession session){

        Korisnik logovaniKorisnik = (Korisnik) session.getAttribute("korisnik");
        if(logovaniKorisnik == null || logovaniKorisnik.getUloga() != Uloga.KUPAC) {
            return new ResponseEntity("You are not permmitet to do that!", HttpStatus.FORBIDDEN);
        }
        String response = porudzbinaService.addToCart(logovaniKorisnik, stavkaDto.getArtikal(), stavkaDto.getBroj());
        return ResponseEntity.ok(response);
    }

    @PostMapping("/korpa/remove")
    public ResponseEntity<String> ukloni(@RequestBody StavkaDto stavkaDto, HttpSession session){

        Korisnik logovaniKorisnik = (Korisnik) session.getAttribute("korisnik");
        if(logovaniKorisnik == null || logovaniKorisnik.getUloga() != Uloga.KUPAC) {
            return new ResponseEntity("You are not permmitet to do that!", HttpStatus.FORBIDDEN);
        }
        String response = porudzbinaService.removeFromCart(logovaniKorisnik, stavkaDto);
        return ResponseEntity.ok(response);
    }

}
