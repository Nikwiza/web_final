package com.example.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.rmi.UnexpectedException;
import java.util.List;

/**
 *
 * This is a class that describes a comment
 *
 * */

@Entity

public class Komentar implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idKomentar;

    @ManyToOne(cascade = CascadeType.ALL)//TODO: Test
    @JoinColumn(name = "Kupac_comment", referencedColumnName = "idKorisnika")
    private Kupac kupac;

    @ManyToOne(cascade = CascadeType.ALL) //todo: Test
    @JoinColumn(name = "restaurant_comments", referencedColumnName = "idRestorana")
    private Restoran restoran;

    @Column
    private String text;

    @Column
    private int ocena;

    public Komentar(){}

    public Komentar(Kupac kupac, Restoran restoran, String text, int ocena) {
        this.kupac = kupac;
        this.restoran = restoran;
        this.text = text;
        this.ocena = ocena;
    }

    public Long getIdKomentar() {
        return idKomentar;
    }

    public void setIdKomentar(Long idKomentar) {
        this.idKomentar = idKomentar;
    }

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

    public void setOcena(int ocena) {
        this.ocena = ocena;
    }
}
