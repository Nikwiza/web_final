package com.company.entity;


import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;


// Klasa koja predstavlja porudzbine
public class Porudzbina {
    private int uuid;
    private ArrayList<Artikal> artikli;
    private Restoran restoran;
    private Date datum;
    private float cena;
    private String korisnicko_ime;
    private String status;

    public Porudzbina(int uuid, ArrayList<Artikal> artikli, Restoran restoran, float cena, String korisnicko_ime) {
        this.uuid = uuid;
        this.artikli = artikli;
        this.restoran = restoran;
        this.cena = cena;
        this.korisnicko_ime = korisnicko_ime;
        this.status = "Obrada";
        this.datum = new Date();

    }

    public int getUuid() {
        return uuid;
    }

    public void setUuid(int uuid) {
        this.uuid = uuid;
    }

    public ArrayList<Artikal> getArtikli() {
        return artikli;
    }

    public void setArtikli(ArrayList<Artikal> artikli) {
        this.artikli = artikli;
    }

    public Restoran getRestoran() {
        return restoran;
    }

    public void setRestoran(Restoran restoran) {
        this.restoran = restoran;
    }

    public String getDatum() {
        SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        formater.format(this.datum);
        return formater.format(this.datum);
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public float getCena() {
        return cena;
    }

    public void setCena(float cena) {
        this.cena = cena;
    }

    public String getKorisnicko_ime() {
        return korisnicko_ime;
    }

    public void setKorisnicko_ime(String korisnicko_ime) {
        this.korisnicko_ime = korisnicko_ime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
