package com.company.entity;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.io.Serializable;
import javax.persistence.*;


// Klasa koja predstavlja porudzbine
@Entity
@NamedQuery(name = "Porudzbina.findALL", query = "SELECT p FROM Porudzbina p")
public class Porudzbina implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GenratedValue(strategy = GenerationType.IDENTITY)
    private int idPorudzbina;

    @Column
    private int uuid;

    @Column
    private ArrayList<Artikal> artikli;

    @Column
    private Restoran restoran;

    @Column
    private Date datum;

    @Column
    private float cena;

    @Column
    private String korisnicko_ime;

    @Column
    private String status;

    public Porudzbina(){}

    @OneToMany(mappedBy = "porudzbina")
    private List<Artikal> artikli;

    @OneToMany(mappedBy = "porudzbina")
    private List<Restoran> restorani;

    @OneToMany(mappedBy = "porudzbina")
    private List<Kupac> kupci;

    public Porudzbina(int uuid, ArrayList<Artikal> artikli, Restoran restoran, float cena, String korisnicko_ime) {
        this.uuid = uuid;
        this.artikli = artikli;
        this.restoran = restoran;
        this.cena = cena;
        this.korisnicko_ime = korisnicko_ime;
        this.status = "Obrada";
        this.datum = new Date();

    }

    public int getIdPorudzbina() {
        return this.idPorudzbina;
    }

    public void setIdPorudzbina(int idPorudzbina) {
        this.idPorudzbina = idPorudzbina;
    }

    //dodatak za artikal(add, remove)
    public Artikal addArtikal(Artikal artikal){
        getArtikli().add(artikal);
        artikal.setPorudzbina(this);
        return artikal;
    }

    public Artikal removeArtikal(Artikal artikal){
        getArtikli().remove(artikal);
        artikal.setPorudzbina(null);
        return artikal;
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
        restoran.setPorudzbina(this);
        return restoran;
    }

    public Restoran removeRestoran(Restoran restoran){
        getRestorani().remove(restoran);
        restoran.setPorudzbina(null);
        return restoran;
    }

    //dodatak za kupac(set, get, add, remove)


    public List<Kupac> getKupci() {
        return this.kupci;
    }

    public void setKupci(List<Kupac> kupci) {
        this.kupci = kupci;
    }

    public Kupac addKupac(Kupaca kupac){
        getKupci().add(kupac);
        kupac.setPorudzbina(this);
        return kupac;
    }

    public Kupac removeKupac(Kupac kupac){
        getKupci().remove(kupac);
        kupac.setPorudzbina(null);
        return kupac;
    }

    public int getUuid() {
        return uuid;
    }

    public void setUuid(int uuid) {
        this.uuid = uuid;
    }

    public ArrayList<Artikal> getArtikli() {
        return artikli;
    }

    public void setArtikli(ArrayList<Artikal> artikli) {
        this.artikli = artikli;
    }

    public Restoran getRestoran() {
        return restoran;
    }

    public void setRestoran(Restoran restoran) {
        this.restoran = restoran;
    }

    public String getDatum() {
        SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        formater.format(this.datum);
        return formater.format(this.datum);
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public float getCena() {
        return cena;
    }

    public void setCena(float cena) {
        this.cena = cena;
    }

    public String getKorisnicko_ime() {
        return korisnicko_ime;
    }

    public void setKorisnicko_ime(String korisnicko_ime) {
        this.korisnicko_ime = korisnicko_ime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
