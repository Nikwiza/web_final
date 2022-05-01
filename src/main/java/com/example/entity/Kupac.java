package com.example.entity;

import java.util.Date;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.*;

/**
 *
 * This is a class that describes the customer
 *
 * */

@Entity

public class Kupac extends Korisnik implements Serializable{

    @OneToMany(mappedBy = "kupac", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Porudzbina> porudzbine = new HashSet<>();

    @Column
    private int broj_skupljenih_bodova;

    @ManyToOne
    @JoinColumn(name = "TipKupcaId")
    private Tipkupca tip_kupca;

    public Kupac() {
        this.uloga = Uloga.KUPAC;
    }

    //Registracija
    public Kupac(Korisnik korisnik){
        this.broj_skupljenih_bodova = 0;
        this.uloga = Uloga.KUPAC;
        this.ime = korisnik.ime;
        this.prezime = korisnik.prezime;
        this.korisnicko = korisnik.korisnicko;
        this.lozinka = korisnik.lozinka;
        this.pol = korisnik.pol;
    }

    public Kupac(String korisnicko_ime, String lozinka, String ime, String prezime, Pol pol, Date datum_rodjenja, Set<Porudzbina> porudzbine, int broj_skupljenih_bodova) {
        super(korisnicko_ime, lozinka, ime, prezime, pol, datum_rodjenja);
        this.porudzbine = porudzbine;
        this.broj_skupljenih_bodova = broj_skupljenih_bodova;
        this.tip_kupca = tip_kupca;
    }

    public Set<Porudzbina> getPorudzbine() {
        return porudzbine;
    }

    public void setPorudzbine(Set<Porudzbina> porudzbine) {
        this.porudzbine = porudzbine;
    }

    public int getBroj_skupljenih_bodova() {
        return broj_skupljenih_bodova;
    }

    public void setBroj_skupljenih_bodova(int broj_skupljenih_bodova) {
        this.broj_skupljenih_bodova = broj_skupljenih_bodova;
    }

    public void setTip_kupca(Tipkupca tip_kupca) {
        this.tip_kupca = tip_kupca;
    }

    public Tipkupca getTip_kupca() {
        return tip_kupca;
    }
}