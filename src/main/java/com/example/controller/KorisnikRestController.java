package com.example.controller;

import com.example.dto.KorisnikDto;
import com.example.dto.LoginDto;
import com.example.entity.Korisnik;
import com.example.entity.Pol;
import com.example.repository.KorisnikRepository;
import com.example.service.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/profil")
    public ResponseEntity setup(HttpSession session){
        Korisnik logovanKorisnik = (Korisnik) session.getAttribute("korisnik");
        if(logovanKorisnik == null){
            return new ResponseEntity("Forbidden", HttpStatus.FORBIDDEN);
        }
        return ResponseEntity.ok(logovanKorisnik.toString());
    }

    @PostMapping("/profil/setusername")
    public ResponseEntity setusername(@RequestBody String name, HttpSession session){
        Korisnik logovanKorisnik = (Korisnik) session.getAttribute("korisnik");
        if(logovanKorisnik == null){
            return new ResponseEntity("Forbidden", HttpStatus.FORBIDDEN);
        }
        String response = korisnikService.setUsername(name, logovanKorisnik);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/profil/setpassword")
    public ResponseEntity setpassword(@RequestBody String sifra, HttpSession session){
        Korisnik logovanKorisnik = (Korisnik) session.getAttribute("korisnik");
        if(logovanKorisnik == null){
            return new ResponseEntity("Forbidden", HttpStatus.FORBIDDEN);
        }
        String response = korisnikService.setPassword(sifra, logovanKorisnik);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/profil/setime")
    public ResponseEntity setime(@RequestBody String ime, HttpSession session){
        Korisnik logovanKorisnik = (Korisnik) session.getAttribute("korisnik");
        if(logovanKorisnik == null){
            return new ResponseEntity("Forbidden", HttpStatus.FORBIDDEN);
        }
        String response = korisnikService.setIme(ime, logovanKorisnik);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/profil/setprezime")
    public ResponseEntity setprezime(@RequestBody String prezime, HttpSession session){
        Korisnik logovanKorisnik = (Korisnik) session.getAttribute("korisnik");
        if(logovanKorisnik == null){
            return new ResponseEntity("Forbidden", HttpStatus.FORBIDDEN);
        }
        String response = korisnikService.setPrezime(prezime, logovanKorisnik);
        return ResponseEntity.ok(response);
    }

//    @PostMapping("/profil/setpol")
//    public ResponseEntity setpassword(@RequestBody Pol pol, HttpSession session){
//        Korisnik logovanKorisnik = (Korisnik) session.getAttribute("korisnik");
//        if(logovanKorisnik == null){
//            return new ResponseEntity("Forbidden", HttpStatus.FORBIDDEN);
//        }
//        String response = korisnikService.setPol(pol, logovanKorisnik);
//        return ResponseEntity.ok(response);
//    }
}
