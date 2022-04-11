package com.company.entity;

import java.util.Date;
import java.io.Serializable;
import javax.persistence.*;


@Entity
@NamedQuery(name = "Kupac.findALL", query = "SELECT u FROM Kupac k")
public class Kupac implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idKupac;

    @Column
    private String porudzbine;

    @Column
    private int Broj_sakupljenih_bodova;

    @Column
    private String tip;

    public Kupac(){}

    public int getIdKupac(){
        return this.idKupac;
    }

    public void setIdKupac(int idKupac){
        this.idKupac = idKupac;
    }

    @OneToOne
    @JoinColumn(name = "idKorisnik")
    private Korisnik korisnik;

    public Kupac(String korisnicko_ime, String lozinka, String ime, String prezime, Pol p, Date datum_rodjenja) {
        super(korisnicko_ime, lozinka, ime, prezime, p, datum_rodjenja);
    }

    public void setPorudzbine(String porudzbine) {
        this.porudzbine = porudzbine;
    }

    public void setBroj_sakupljenih_bodova(int broj_sakupljenih_bodova) {
        Broj_sakupljenih_bodova = broj_sakupljenih_bodova;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    @Override
    public String toString() {
        return "Kupac je: " +
                "tipa; " + tip +
                "porudzbine su mu: " + porudzbine + '\'' +
                ", a broj sakupljenih poena mu je: " + Broj_sakupljenih_bodova + ".\n";
    }
}