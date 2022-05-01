package com.example.entity;

import java.util.Date;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "KORISNIK")
public class Korisnik implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long idKorisnika;

    @Column(nullable = false, unique = true, name = "korisnicko")
    protected String korisnicko;

    @Column(nullable = false)
    protected String lozinka;

    @Column(nullable = false)
    protected String ime;

    @Column(nullable = false)
    protected String prezime;

    @Enumerated(EnumType.STRING)
    @Column
    protected Pol pol;

    @Temporal(TemporalType.DATE)
    @Column
    protected Date datum_rodjenja;

    @Enumerated(EnumType.STRING)
    @Column
    protected Uloga uloga;

    public Korisnik(){}

    public Korisnik(String korisnicko, String lozinka, String ime, String prezime, Pol pol, Date datum_rodjenja) {
        this.korisnicko = korisnicko;
        this.lozinka = lozinka;
        this.ime = ime;
        this.prezime = prezime;
        this.pol = pol;
        this.datum_rodjenja = datum_rodjenja;
    }

    public Long getIdKorisnika() {
        return idKorisnika;
    }

    public void setIdKorisnika(Long idKorisnika) {
        this.idKorisnika = idKorisnika;
    }

    public String getKorisnicko() {
        return korisnicko;
    }

    public void setKorisnicko(String korisnicko) {
        this.korisnicko = korisnicko;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public Pol getPol() {
        return pol;
    }

    public void setPol(Pol pol) {
        this.pol = pol;
    }

    public Date getDatum_rodjenja() {
        return datum_rodjenja;
    }

    public void setDatum_rodjenja(Date datum_rodjenja) {
        this.datum_rodjenja = datum_rodjenja;
    }

    public Uloga getUloga() {
        return uloga;
    }

    public void setUloga(Uloga uloga) {
        this.uloga = uloga;
    }

    // ===========SIMPLER REGISTRATION==========

    public Korisnik(String korisnicko, String lozinka, String ime, String prezime) {
        this.korisnicko = korisnicko;
        this.lozinka = lozinka;
        this.ime = ime;
        this.prezime = prezime;
    }

    //===========================================

    @Override
    public String toString() {
        return "Korisnik{" +
                "idKorisnika=" + idKorisnika +
                ", korisnicko_ime='" + korisnicko + '\'' +
                ", lozinka='" + lozinka + '\'' +
                ", ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", pol=" + pol +
                ", datum_rodjenja=" + datum_rodjenja +
                ", uloga=" + uloga +
                '}';
    }
}

