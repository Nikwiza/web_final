package com.company.entity;
import java.util.ArrayList;

public class Restoran {
    private String naziv;
    private String tip_restorana;
    private ArrayList<Artikal> artikli;
    private Lokacija lokacija;

    public Restoran(String naziv, String tip_restorana, ArrayList<Artikal> artikli, Lokacija lokacija) {
        this.naziv = naziv;
        this.tip_restorana = tip_restorana;
        this.artikli = artikli;
        this.lokacija = lokacija;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getTip_restorana() {
        return tip_restorana;
    }

    public void setTip_restorana(String tip_restorana) {
        this.tip_restorana = tip_restorana;
    }

    public ArrayList<Artikal> getArtikli() {
        return artikli;
    }

    public void setArtikli(ArrayList<Artikal> artikli) {
        this.artikli = artikli;
    }

    public Lokacija getLokacija() {
        return lokacija;
    }

    public void setLokacija(Lokacija lokacija) {
        this.lokacija = lokacija;
    }
}
