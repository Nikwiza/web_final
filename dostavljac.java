package com.company;

import java.util.Date;

public class Dostavljac extends Korisnik{
    private String porudzbina;

    public Dostavljac(String korisnicko_ime, String lozinka, String ime, String prezime, pol p, Date datum_rodjenja) {
        super(korisnicko_ime, lozinka, ime, prezime, p, datum_rodjenja);
    }


    public void setPorudzbina(String porudzbina) {
        this.porudzbina = porudzbina;
    }

    @Override
    public String toString() {
        return "Dostavljac treba da dostavi: " + porudzbina + ".\n";
    }
}
