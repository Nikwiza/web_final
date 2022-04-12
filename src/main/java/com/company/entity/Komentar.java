package com.company.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.rmi.UnexpectedException;
import java.util.List;

// Klasa koja predstavlja Komentare
@Entity
@NamedQuery(name = "Komentar.findALL", query = "SELECT k FROM Komentar k")
public class Komentar implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idKomentar;

    @Column
    private Kupac kupac;

    @Column
    private Restoran restoran;

    @Column
    private String text;

    @Column
    private int ocena;

    public Komentar(){}

    @OneToMany(mappedBy = "komentar")
    private List<Kupac> kupci;

    @OneToMany(mappedBy = "komentar")
    private List<Restoran> restorani;

    public int getIdKomentar() {
        return this.idKomentar;
    }

    public void setIdKomentar(int idKomentar) {
        this.idKomentar = idKomentar;
    }


    //dodatak za kupca(set, get, add, remove)
    public List<Kupac> getKupci() {
        return this.kupci;
    }

    public void setKupac(List<Kupac> kupac) {
        this.kupac = kupac;
    }

    public Kupac addKupac(Kupac kupac){
        getKupci().add(kupac);
        kupac.setKomentar(this);
        return kupac;
    }

    public Kupac removeKupac(Kupac kupac){
        getKupci().remove(kupac);
        kupac.setKomentar(null);
        return kupac;
    }

    //dodatak za restoran(set, get, add, remove)


    public List<Restoran> getRestorani() {
        return this.restorani;
    }

    public void setRestorani(List<Restoran> restorani) {
        this.restorani = restorani;
    }

    public Restoran addRestoran(Restoran restoran){
        getRestorani().add(restoran);
        restoran.setKomentar(this);
        return resstoran;
    }

    public Restoran removeRestoran(Restoran restoran){
        getRestorani().remove(restoran);
        restoran.setKomentar(null);
        return restoran;
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

    public void setOcena(int ocena) throws UnexpectedException {
        if(ocena > 5 || ocena < 1){
            throw new UnexpectedException("Nije validna ocena");
        }
        this.ocena = ocena;
    }
}
