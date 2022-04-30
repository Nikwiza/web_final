package com.example.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * This is a class that describes the delivery person
 *
 * */

@Entity
public class Dostavljac extends Korisnik implements Serializable {

    @OneToMany
    @JoinColumn(name = "dostavljacId")
    private Set<Porudzbina> porudzbine = new HashSet<>();

    public Dostavljac() {
        super(Uloga.DOSTAVLJAC);
    }

    public Dostavljac(String korisnicko_ime, String lozinka, String ime, String prezime, Pol pol, Date datum_rodjenja, Set<Porudzbina> porudzbine) {
        super(korisnicko_ime, lozinka, ime, prezime, pol, datum_rodjenja, Uloga.DOSTAVLJAC);
        this.porudzbine = porudzbine;
    }

    public Set<Porudzbina> getPorudzbine() {
        return porudzbine;
    }

    public void setPorudzbine(Set<Porudzbina> porudzbine) {
        this.porudzbine = porudzbine;
    }
}
