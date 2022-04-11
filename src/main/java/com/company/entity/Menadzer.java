package com.company.entity;

import java.util.Date;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@NamedQuery(name = "Menadzer.findALL", query = "SELECT u FROM Menadzer m")

public class Menadzer implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMenadzer;

    public Menadzer(){}

    @Column
    private String Restoran;

    public int getIdMenadzer() {
        return idMenadzer;
    }

    public void setIdMenadzer(int idMenadzer) {
        this.idMenadzer = idMenadzer;
    }

    @OneToOne
    @JoinColumn(name = "idKorisnik")
    private Korisnik korisnik;

    public Menadzer(String korisnicko_ime, String lozinka, String ime, String prezime, Pol p, Date datum_rodjenja) {
        super(korisnicko_ime, lozinka, ime, prezime, p, datum_rodjenja);
    }

    public void setRestoran(String restoran) {
        Restoran = restoran;
    }

    @Override
    public String toString() {
        return "Menadzer je zaduzen za restoran: " + Restoran + ".\n";
    }
}