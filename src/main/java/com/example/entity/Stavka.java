package com.example.entity;

/**
 *
 * This is a class that describes both single
 *  and multiple orders of one item
 *
 *  */

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Stavka implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id_stavke;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "article")
    private Artikal artikal;

    @Column
    private int broj;

    public Stavka() {}

    public Stavka(Artikal artikal, int broj, Long id_stavke) {
        this.artikal = artikal;
        this.broj = broj;
        this.id_stavke = id_stavke;
    }

    public Stavka(Artikal artikal, int broj) {
        this.artikal = artikal;
        this.broj = broj;
    }

    public int getBroj() {
        return broj;
    }

    public void setBroj(int broj) {
        this.broj = broj;
    }

    public Artikal getArtikal() {
        return artikal;
    }

    public void setArtikal(Artikal artikal) {
        this.artikal = artikal;
    }

    public Long getId_stavke() {
        return id_stavke;
    }

    public void setId_stavke(Long id_stavke) {
        this.id_stavke = id_stavke;
    }
}
