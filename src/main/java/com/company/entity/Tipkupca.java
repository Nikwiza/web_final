package com.company.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 *
 * This is a class that describes the type of customer
 *
 * */

enum Znacka {GOLD, SILVER, BRONZE};
//todo: Delete the setter for the id-s

@Entity
public class Tipkupca implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long idTipa_kupca;

    @Enumerated(EnumType.ORDINAL)
    @Column
    protected Znacka tip;

    @Column
    protected float popust;

    @Column
    protected int trazeni_broj_bodova;

    public Tipkupca() {
    }

    public Long getIdTipa_kupca() {
        return idTipa_kupca;
    }

    public void setIdTipa_kupca(Long idTipa_kupca) {
        this.idTipa_kupca = idTipa_kupca;
    }

    public Znacka getTip() {
        return tip;
    }

    public void setTip(Znacka tip) {
        this.tip = tip;
    }

    public float getPopust() {
        return popust;
    }

    public void setPopust(float popust) {
        this.popust = popust;
    }

    public int getTrazeni_broj_bodova() {
        return trazeni_broj_bodova;
    }

    public void setTrazeni_broj_bodova(int trazeni_broj_bodova) {
        this.trazeni_broj_bodova = trazeni_broj_bodova;
    }
}
