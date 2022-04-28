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
public class Stavka extends Artikal implements Serializable {

    @Column
    private int broj;

    public Stavka() {
        this.broj = 1;
    }

    public Stavka(String naziv, float cena, String tip, float kolicina, String opis, int broj) {
        super(naziv, cena, tip, kolicina, opis);
        this.broj = broj;
    }

    public int getBroj() {
        return broj;
    }

    public void setBroj(int broj) {
        this.broj = broj;
    }
}
