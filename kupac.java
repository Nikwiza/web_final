package com.company;

import java.util.Date;

public class Kupac extends Korisnik{
    private String porudzbine;
    private int Broj_sakupljenih_bodova;
    private TipKupca tip;

    public Kupac(String korisnicko_ime, String lozinka, String ime, String prezime, pol p, Date datum_rodjenja) {
        super(korisnicko_ime, lozinka, ime, prezime, p, datum_rodjenja);
    }


    public void setPorudzbine(String porudzbine) {
        this.porudzbine = porudzbine;
    }

    public void setBroj_sakupljenih_bodova(int broj_sakupljenih_bodova) {
        Broj_sakupljenih_bodova = broj_sakupljenih_bodova;
    }

    public void setTip(TipKupca tip) {
        this.tip = tip;
    }

    @Override
    public String toString() {
        return "Kupac je: " +
                "tipa; " + tip +
                "porudzbine su mu: " + porudzbine + '\'' +
                ", a broj sakupljenih poena mu je: " + Broj_sakupljenih_bodova + ".\n";
    }
}