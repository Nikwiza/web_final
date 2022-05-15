package com.example.dto;

import com.example.entity.Korisnik;
import com.example.entity.Pol;
import com.example.entity.Uloga;

import javax.persistence.*;
import java.util.Date;

public class KorisnikDto {

    protected Long idKorisnika;

    protected String korisnicko_ime;

    protected String ime;

    protected String prezime;

    protected Pol pol;

    protected Date datum_rodjenja;

    protected Uloga uloga;


    public KorisnikDto() {
    }

    public KorisnikDto(Korisnik korisnik){
        this.idKorisnika = korisnik.getIdKorisnika();
        this.korisnicko_ime = korisnik.getKorisnicko();
        this.ime = korisnik.getIme();
        this.prezime = korisnik.getPrezime();
        this.pol = korisnik.getPol();
        this.datum_rodjenja = korisnik.getDatum_rodjenja();
        this.uloga = korisnik.getUloga();
    }

    public Long getIdKorisnika() {
        return idKorisnika;
    }

    public void setIdKorisnika(Long idKorisnika) {
        this.idKorisnika = idKorisnika;
    }

    public String getKorisnicko_ime() {
        return korisnicko_ime;
    }

    public void setKorisnicko_ime(String korisnicko_ime) {
        this.korisnicko_ime = korisnicko_ime;
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
}
