package com.example.controller;

import com.example.dto.*;
import com.example.entity.*;
import com.example.repository.RestoranRepository;
import com.example.service.RestoranService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Set;

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

    @GetMapping("/restoran/{ime}")
    public ResponseEntity<RestoranStranicaDto> restoran(@PathVariable (value = "ime") String ime){
        Restoran restoran = restoranRepository.findByNaziv(ime);
        if(restoran == null){
            return new ResponseEntity("Restoran nije pronadjzen", HttpStatus.NOT_FOUND);
        }

        Set<KomentarDto> komentari = restoranService.komentari(restoran);
        Set<Artikal> artikli = restoranService.artikli(restoran);
        float ocena = restoranService.ocena(restoran);
        RestoranDto restoranDto = new RestoranDto(restoran);
        RestoranStranicaDto restoranStranicaDto = new RestoranStranicaDto(restoranDto, ocena, komentari, artikli); //Todo: dodati nacin da se menja status
        return ResponseEntity.ok(restoranStranicaDto);
    }

    @GetMapping("/search/{ime}")
    public ResponseEntity<RestoranDto> findbyime(@PathVariable(value = "ime") String ime){ //todo: lista sa contains
        Restoran restoran = restoranRepository.findByNaziv(ime);
        if(restoran == null){
            return new ResponseEntity("Nije pronadjen ovaj restoran", HttpStatus.NOT_FOUND);
        }
        RestoranDto restoranDto = new RestoranDto(restoran);
        return ResponseEntity.ok(restoranDto);
    }

    @GetMapping("/search/tip/{tip}")
    public ResponseEntity<List<RestoranDto>> findbytiprestorana(@PathVariable(value = "tip") String tip){
        List<RestoranDto>restorani = restoranService.restorani_tip(tip);
        return ResponseEntity.ok(restorani);
    }

    @GetMapping("/search/lokacija")
    public ResponseEntity<RestoranDto> findbylokacija(@RequestBody String lokacija){
        RestoranDto restoranDto = restoranService.restorani_lokacija(lokacija);
        if(restoranDto == null){
            return new ResponseEntity("Nije validna lokacija", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(restoranDto);
    }

    @PostMapping("/add/artikal")
    public ResponseEntity<String> addArtikal (@RequestBody Artikal artikal, HttpSession session){
        Korisnik logovaniKorisnik = (Korisnik) session.getAttribute("korisnik");
        if(logovaniKorisnik == null || logovaniKorisnik.getUloga() != Uloga.MENADZER) {
            return new ResponseEntity("You are not permmitet to do that!", HttpStatus.FORBIDDEN);
        }
        String response = restoranService.addArtikal(artikal, logovaniKorisnik);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/artikal/{id}")
    public ResponseEntity<Artikal> getartikal(@PathVariable(value = "id")Long id, HttpSession session)
    {
        Korisnik logovaniKorisnik = (Korisnik)session.getAttribute("korisnik");
        if(logovaniKorisnik == null || logovaniKorisnik.getUloga() != Uloga.MENADZER) {
            return new ResponseEntity("You are not permmitet to do that!", HttpStatus.FORBIDDEN);
        }
        Artikal artikal = restoranService.findArtikal(id, logovaniKorisnik);
        if(artikal == null){
            return new ResponseEntity("Nemate taj artikal u restoranu", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(artikal);
    }
    @PostMapping("/artikal/{id}")
    public ResponseEntity<String> change (@RequestBody Artikal artikal, HttpSession session){
        Korisnik logovaniKorisnik = (Korisnik) session.getAttribute("korisnik");
        if(logovaniKorisnik == null || logovaniKorisnik.getUloga() != Uloga.MENADZER) {
            return new ResponseEntity("You are not permmitet to do that!", HttpStatus.FORBIDDEN);
        }
        String response = restoranService.changeArtikal(artikal, logovaniKorisnik);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/artikal/{id}/remove")
    public ResponseEntity<String> remove (@PathVariable(value = "id")Long id, HttpSession session) {
        Korisnik logovaniKorisnik = (Korisnik) session.getAttribute("korisnik");
        if (logovaniKorisnik == null || logovaniKorisnik.getUloga() != Uloga.MENADZER) {
            return new ResponseEntity("You are not permmitet to do that!", HttpStatus.FORBIDDEN);
        }
        String response = restoranService.removeArtikal(id, logovaniKorisnik);
        return ResponseEntity.ok(response);
    }

}
