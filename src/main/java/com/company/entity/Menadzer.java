package com.company.entity;

import java.util.Date;

public class Menadzer extends Korisnik{
    private String Restoran;

    public Menadzer(String korisnicko_ime, String lozinka, String ime, String prezime, pol p, Date datum_rodjenja) {
        super(korisnicko_ime, lozinka, ime, prezime, p, datum_rodjenja);
    }

    public void setRestoran(String restoran) {
        Restoran = restoran;
    }

    @Override
    public String toString() {
        return "Menadzer je zaduzen za restoran: " + Restoran + ".\n";
    }
}
