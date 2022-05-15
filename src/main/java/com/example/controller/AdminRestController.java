package com.example.controller;


import com.example.dto.KorisnikDto;
import com.example.entity.Korisnik;
import com.example.entity.Uloga;
import com.example.repository.DostavljacRepository;
import com.example.repository.KorisnikRepository;
import com.example.repository.MenadzerRepository;
import com.example.service.AdminService;
import com.example.service.DostavljacService;
import com.example.service.KorisnikService;
import com.example.service.MenadzerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.net.http.HttpResponse;
import java.util.List;

@RestController
public class AdminRestController {

    @Autowired
    private KorisnikService korisnikService;

    @Autowired
    private MenadzerService menadzerService;

    @Autowired
    private DostavljacService dostavljacService;

    @Autowired
    private AdminService adminService;

    @PostMapping("/add/menadzer")
    public ResponseEntity add_menadzer(@RequestBody Korisnik korisnik, HttpSession session){ //todo: We set menager restaurants when we make a new restaurant
        Korisnik logovaniKorisnik = (Korisnik) session.getAttribute("korisnik");
        if(logovaniKorisnik == null || logovaniKorisnik.getUloga() != Uloga.ADMIN) {
            return new ResponseEntity("You are not permmitet to do that!", HttpStatus.FORBIDDEN);
        }
        String response = menadzerService.addmanager(korisnik);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/add/dostavljac")
    public ResponseEntity add_dostavljac(@RequestBody Korisnik korisnik, HttpSession session){
        Korisnik logovaniKorisnik = (Korisnik) session.getAttribute("korisnik");
        if(logovaniKorisnik == null || logovaniKorisnik.getUloga() != Uloga.ADMIN) {
            return new ResponseEntity("You are not permmitet to do that!", HttpStatus.FORBIDDEN);
        }
        String response = dostavljacService.adddelivery(korisnik);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/korisnici")
    public ResponseEntity<List<KorisnikDto>> korisnici(HttpSession session){
        Korisnik logovaniKorisnik = (Korisnik) session.getAttribute("korisnik");
        if(logovaniKorisnik == null || logovaniKorisnik.getUloga() != Uloga.ADMIN) {
            return new ResponseEntity("You are not permmitet to do that!", HttpStatus.FORBIDDEN);
        }
        List<KorisnikDto> korisnici = adminService.uvid_u_korisnike();
        return new ResponseEntity<List<KorisnikDto>>(korisnici, HttpStatus.OK);
    }

    ////////////////////////////////////ADMIN REQUEST TEMPLATE//////////////////////////////////
//    @PostMapping("/add/menadzer")
//    public ResponseEntity add_menadzer(@RequestBody Korisnik korisnik, HttpSession session){
//        Korisnik logovaniKorisnik = (Korisnik) session.getAttribute("korisnik");
//        if(logovaniKorisnik == null || logovaniKorisnik.getUloga() != Uloga.ADMIN) {
//            return new ResponseEntity("You are not permmitet to do that!", HttpStatus.FORBIDDEN);
//        }
//          //Action
//    }

}
