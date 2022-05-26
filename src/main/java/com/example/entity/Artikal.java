package com.example.entity;


import javax.persistence.*;
import java.io.Serializable;

/**
 *
 * This is a class that describes an article
 *
 * */

@Entity
public class Artikal implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long idArtikla;

    @Column
    protected String naziv;

    @Column
    protected float cena;

    @Column
    protected String tip;

    @Column
    protected float kolicina;

    @Column
    protected String opis;


    public Artikal() {}

    public Artikal(String naziv, float cena, String tip, float kolicina, String opis) {
        this.naziv = naziv;
        this.cena = cena;
        this.tip = tip;
        this.kolicina = kolicina;
        this.opis = opis;
    }

    public Artikal(String naziv, float cena, String tip){
        this.naziv = naziv;
        this.cena = cena;
        this.tip = tip;
    }
    public Artikal(String naziv, float cena, String tip, String opis){
        this.naziv = naziv;
        this.cena = cena;
        this.tip = tip;
        this.opis = opis;
    }
    public Artikal(String naziv, float cena, String tip, float kolicina){
        this.naziv = naziv;
        this.cena = cena;
        this.tip = tip;
        this.kolicina = kolicina;
    }

    public Long getIdArtikla() {
        return idArtikla;
    }

    public void setIdArtikla(long idArtikla) {
        this.idArtikla = idArtikla;
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
