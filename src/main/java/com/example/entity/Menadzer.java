package com.example.entity;

import java.util.Date;
import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * This is a class that describes the manager
 *
 * */

@Entity

public class Menadzer extends Korisnik implements Serializable {

    @OneToOne
    @JoinColumn(name = "restoran_id", referencedColumnName = "idRestorana")
    private Restoran restoran;

    public Menadzer() {
        this.uloga = Uloga.MENADZER;
    }

    public Menadzer(Korisnik korisnik){
        this.uloga = Uloga.MENADZER;
        this.korisnicko = korisnik.korisnicko;
        this.datum_rodjenja = korisnik.datum_rodjenja;
        this.ime = korisnik.ime;
        this.prezime = korisnik.prezime;
        this.lozinka = korisnik.lozinka;
        this.pol = korisnik.pol;
    }

    public Menadzer(String korisnicko_ime, String lozinka, String ime, String prezime, Pol pol, Date datum_rodjenja, Restoran restoran) {
        super(korisnicko_ime, lozinka, ime, prezime, pol, datum_rodjenja);
        this.restoran = restoran;
        this.uloga = Uloga.MENADZER;
    }

    public Restoran getRestoran() {
        return restoran;
    }

    public void setRestoran(Restoran restoran) {
        this.restoran = restoran;
    }
}
