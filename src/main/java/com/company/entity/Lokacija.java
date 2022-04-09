package com.company.entity;
//Funckija koja predstavlja lokaciju

public class Lokacija {
    protected double geografska_duzina;
    protected double geografska_sirina;
    protected String adresa;

    public Lokacija(double geografska_duzina, double geografska_sirina, String adresa) {
        this.geografska_duzina = geografska_duzina;
        this.geografska_sirina = geografska_sirina;
        this.adresa = adresa;
    }

    public double getGeografska_duzina() {
        return geografska_duzina;
    }

    public void setGeografska_duzina(double geografska_duzina) {
        this.geografska_duzina = geografska_duzina;
    }

    public double getGeografska_sirina() {
        return geografska_sirina;
    }

    public void setGeografska_sirina(double geografska_sirina) {
        this.geografska_sirina = geografska_sirina;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }
}
