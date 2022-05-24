package com.example.controller;

import com.example.dto.RestoranDto;
import com.example.entity.Restoran;
import com.example.repository.RestoranRepository;
import com.example.service.RestoranService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
    //todo: Napraviti jos jedan restoran dto, ili samo prepraviti onaj postojeci, pa cemo da menjamo prikaz
    public ResponseEntity<RestoranDto> restoran(@PathVariable (value = "ime") String ime){
        Restoran restoran = restoranRepository.findByNaziv(ime);
        if(restoran == null){
            return new ResponseEntity("Restoran nije pronadjzen", HttpStatus.NOT_FOUND);
        }
        RestoranDto restoranDto = new RestoranDto(restoran);
        return ResponseEntity.ok(restoranDto);

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


}
