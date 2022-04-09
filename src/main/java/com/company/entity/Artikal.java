package com.company.entity;

// Klasa koja predstavlja artikal

public class Artikal {
    protected String naziv;
    protected float cena;
    protected String tip;
    protected float kolicina;
    protected String opis;

    public Artikal() {
        this.naziv = "Undefined";
        this.cena = 0;
        this.tip = "Undefined";
        this.kolicina = 0;
        this.opis = "Undefined";
    }

    public Artikal(String naziv, float cena, String tip, float kolicina, String opis) {
        this.naziv = naziv;
        this.cena = cena;
        this.tip = tip;
        this.kolicina = kolicina;
        this.opis = opis;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public float getCena() {
        return cena;
    }

    public void setCena(float cena) {
        this.cena = cena;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public float getKolicina() {
        return kolicina;
    }

    public void setKolicina(float kolicina) {
        this.kolicina = kolicina;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }
}
