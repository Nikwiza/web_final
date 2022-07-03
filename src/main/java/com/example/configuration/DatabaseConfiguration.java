package com.example.configuration;
import com.example.dto.StatusRestorana;
import com.example.entity.*;
import com.example.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sound.sampled.FloatControl;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * This is a class that offers seed data for
 * the H2 database
 *
 * */

@Configuration
public class DatabaseConfiguration {
    @Autowired
    private ArtikalRepository artikalRepository;

    @Autowired
    private DostavljacRepository dostavljacRepository;

    @Autowired
    private KomentarRepository komentarRepository;

    @Autowired
    private KorisnikRepository korisnikRepository;

    @Autowired
    private KupacRepository kupacRepository;

    @Autowired
    private LokacijaRepository lokacijaRepository;

    @Autowired
    private MenadzerRepository menadzerRepository;

    @Autowired
    private PorudzbinaRepository porudzbinaRepository;

    @Autowired
    private RestoranRepository restoranRepository;

    @Autowired
    private StavkaRepository stavkaRepository;

    @Autowired
    private TipkupcaRepository tipkupcaRepository;

    @Bean
    public boolean instantiate() {
        // Dates of birth
        Date datum1 = new GregorianCalendar(2020, 10, 2).getTime();

        //Articles for sale
        Artikal krofna = new Artikal("Krofna", 80, "Hrana", 100, "Klasicna krofna");
        Artikal sok_jabuka = new Artikal ("Sok od jabuke", 50, "Pice", 300, "Next sok od jabuke");
        Artikal jelen_pivo = new Artikal ("Jelen pivo", 80, "Pice", 250, "Svetlo pivo marke jelen");

        //Users
        Korisnik jole = new Korisnik("Jole", "ovojesifra", "Jovke", "Jovanovic", Pol.MUSKI, datum1);
        Korisnik zika = new Korisnik("Zikle", "ovojesifra", "Zile", "Zivanovic", Pol.MUSKI, datum1);
        Korisnik paki = new Korisnik("Pakson", "ovojesifra", "Paki", "Pakianovic", Pol.MUSKI, datum1);
        paki.setUloga(Uloga.ADMIN);
        korisnikRepository.save(paki);

        //Logging a customer
        Kupac dunja = new Kupac();
        dunja.setIme("Dunja");
        dunja.setLozinka("Lozinkus");
        dunja.setKorisnicko("Dundarino");
        dunja.setPrezime("Kerleta");
        dunja.setDatum_rodjenja(datum1);
        dunja.setPol(Pol.ZENSKI);
        dunja.setUloga(Uloga.KUPAC);
        kupacRepository.save(dunja);
//        korisnikRepository.saveAll(List.of(jole, zika, paki));

        //Locations
        Lokacija siki_lokacija= new Lokacija(32.12, 342.2, "Mornara Popaja 2");
        Set<Artikal> artikli = new HashSet<>();

        artikli.add(krofna);
        artikli.add(sok_jabuka);
        artikli.add(jelen_pivo);

        //Restaurant
        Restoran siki = new Restoran();
        siki.setTip_restorana("Rostiljdzarnica");
        siki.setLokacija(Set.of(siki_lokacija));
        siki.setNaziv("Siki");
        siki.getArtikli().add(krofna);
        siki.getArtikli().add(sok_jabuka);
        siki.getArtikli().add(jelen_pivo);
        siki.setStatus(StatusRestorana.RADI);
        restoranRepository.save(siki);

        //Stavke
        Stavka stavka = new Stavka();
        stavka.setArtikal(krofna);
        stavka.setBroj(2);

        //Porudzbine
        Porudzbina porudzbina = new Porudzbina();
        porudzbina.setRestoran(siki);
        porudzbina.setDatum(datum1);
        porudzbina.setCena(222);
        porudzbina.setStatus(Status.DOSTAVLJENA);
        porudzbina.setStavke(Set.of(stavka));
        porudzbina.setKupac((Kupac) dunja);
        porudzbinaRepository.save(porudzbina);

        //Menager

        Menadzer menadzer_1 = new Menadzer(zika);
        menadzer_1.setRestoran(siki);
        menadzerRepository.save(menadzer_1);

        //Dodavanje komentara
        Komentar komentar = new Komentar(dunja, siki, "Nije lose, samo ima puno soje u pljeskavicama", 4);
        komentarRepository.save(komentar);

        //Dostavljac
//        String korisnicko_ime, String lozinka, String ime, String prezime, Pol pol, Date datum_rodjenja, Set<Porudzbina> porudzbine
        Set<Porudzbina> p = new HashSet<>();
        Dostavljac marko = new Dostavljac("marko", "Lozinkus", "Marko", "Skavic", Pol.MUSKI, datum1, p);
        dostavljacRepository.save(marko);

        return true;
    }


}
