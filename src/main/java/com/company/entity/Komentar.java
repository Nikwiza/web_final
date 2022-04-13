package com.company.entity;

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

    @OneToOne(mappedBy = "tip_kupca") //many to one
    private Kupac kupac;

    @OneToOne(cascade = CascadeType.ALL) //many to one
    @JoinColumn(name = "restaurant_comments", referencedColumnName = "idRestorana")
    private Restoran restoran;

    @Column
    private String text;

    @Column
    private int ocena;

    public Komentar(){}

    public Komentar(Long idKomentar, Kupac kupac, Restoran restoran, String text, int ocena) {
        this.idKomentar = idKomentar;
        this.kupac = kupac;
        this.restoran = restoran;
        this.text = text;
        this.ocena = ocena;
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
