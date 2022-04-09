package com.company.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

enum uloga{Admin, Menadzer, Dostavljac, Kupac};
enum pol{MUSKI, ZENSKI};
public class Korisnik {
    private String naziv;
    protected String korisnicko_ime;
    protected String lozinka;
    protected String ime;
    protected String prezime;
    protected pol p;
    protected Date datum_rodjenja;

    public Korisnik(String korisnicko_ime, String lozinka, String ime, String prezime, pol p, Date datum_rodjenja) {
        this.korisnicko_ime = korisnicko_ime;
        this.lozinka = lozinka;
        this.ime = ime;
        this.prezime = prezime;
        this.p = p;
        this.datum_rodjenja = datum_rodjenja;
    }

    public String getKorisnicko_ime() {
        return korisnicko_ime;
    }

    public void setKorisnicko_ime(String korisnicko_ime) {
        this.korisnicko_ime = korisnicko_ime;
    }

    public String getNaziv() {
        return naziv;
    }

    public String getLozinka() {
        return lozinka;
    }

    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public pol getP() {
        return p;
    }

    public Date getDatum_rodjenja() {
        return datum_rodjenja;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public void setP(pol p) {
        this.p = p;
    }

    public void setDatum_rodjenja(Date datum_rodjenja) {
        datum_rodjenja = datum_rodjenja;
    }

    @Override
    public String toString() {
        return "Korisnik{" +
                "Korisnicko_ime='" + korisnicko_ime + '\'' +
                ", lozinka='" + lozinka + '\'' +
                ", ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", p=" + p +
                ", Datum_rodjenja=" + datum_rodjenja +
                '}';
    }
}

