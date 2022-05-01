package com.example.controller;

import com.example.dto.KorisnikDto;
import com.example.dto.LoginDto;
import com.example.entity.Korisnik;
import com.example.repository.KorisnikRepository;
import com.example.service.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class KorisnikRestController {

    @Autowired
    private KorisnikService korisnikService;

    @GetMapping("/")
    public String welcome(){
        return "Hello from api!";
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Korisnik korisnik){
        String response = korisnikService.register(korisnik);
        return ResponseEntity.ok(response);
    } //todo: finish registration

    //Logging endpoint
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto, HttpSession session){
        //Validating data
        if(loginDto.getKorisnicko().isEmpty() || loginDto.getLozinka().isEmpty()){
            return new ResponseEntity("Invalid login data", HttpStatus.BAD_REQUEST);
        }

        Korisnik logovan_korisnik = korisnikService.login(loginDto.getKorisnicko(), loginDto.getLozinka());
        if(logovan_korisnik == null){
            return new ResponseEntity("User does not exist!", HttpStatus.NOT_FOUND);
        }
        session.setAttribute("korisnik", logovan_korisnik);
        return ResponseEntity.ok("Successfully logged in!");

    }

    @PostMapping("/logout")
    public ResponseEntity logout(HttpSession session){
        Korisnik logovanKorisnik = (Korisnik) session.getAttribute("korisnik");

        if(logovanKorisnik == null){
            return new ResponseEntity("Forbidden", HttpStatus.FORBIDDEN);
        }
        session.invalidate();
        return ResponseEntity.ok("Successfully logged out !");
    }
}
