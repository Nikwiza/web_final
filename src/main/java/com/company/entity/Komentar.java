package com.company.entity;


import java.rmi.UnexpectedException;

// Klasa koja predstavlja Komentare

public class Komentar{
    private Kupac kupac;
    private Restoran restoran;
    private String text;
    private int ocena;


    public Kupac getKupac() {
        return kupac;
    }

    public void setKupac(Kupac kupac) {
        this.kupac = kupac;
    }

    public Restoran getRestoran() {
        return restoran;
    }

    public void setRestoran(Restoran restoran) {
        this.restoran = restoran;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getOcena() {
        return ocena;
    }

    public void setOcena(int ocena) throws UnexpectedException {
        if(ocena > 5 || ocena < 1){
            throw new UnexpectedException("Nije validna ocena");
        }
        this.ocena = ocena;
    }
}
