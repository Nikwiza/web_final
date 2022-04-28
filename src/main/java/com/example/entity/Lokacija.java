package com.example.entity;
//Funckija koja predstavlja lokaciju
import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * This is a class that describes a location
 *
 * */

@Entity
public class Lokacija implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLokacija;

    @Column
    protected double geografska_duzina;

    @Column
    protected double geografska_sirina;

    @Column
    protected String adresa;

    public Lokacija() {}

    public Lokacija(double geografska_duzina, double geografska_sirina, String adresa) {
        this.geografska_duzina = geografska_duzina;
        this.geografska_sirina = geografska_sirina;
        this.adresa = adresa;
    }

    public Long getIdLokacija(){
        return this.idLokacija;
    }

    public void setIdLokacija(Long idLokacija){
        this.idLokacija = idLokacija;
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
