package com.company.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import java.io.Serializable;

enum uloga{Admin, Menadzer, Dostavljac, Kupac};
enum pol{MUSKI, ZENSKI};
@Entity
@NamedQuery(name = "Korisnik.findALL", query = "SELECT u FROM Korisnik k")
public class Korisnik implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerrationType.IDENTITY)
    private Long idKorisnika;

    @Column
    protected String korisnicko_ime;

    @Column
    protected String lozinka;

    @Column
    protected String ime;

    @Column
    protected String prezime;

    @Column
    protected pol p;
    @Enumerated(EnumType.ORDINAL)

    @Column
    protected Date datum_rodjenja;

    public Korisnik(){}

    @OneToMany(mappedBy = "korisnik")
    private List<Kupac> kupci;

    @OneToMany(mappedBy = "korisnik")
    private List<Dostavljac> dostavljaci;

    @OneToMany(mappedBy = "korisnik")
    private List<Menadzer> menadzeri;

    //dodatak za dostavljaca(get, set, add, remove)
    public List<Dostavljac> getDostavljaci() {
        return this.dostavljaci;
    }

    public void setDostavljaci(List<Dostavljac> dostavljaci) {
        this.dostavljaci = dostavljaci;
    }

    public Dostavljac addDostavljac(Dostavljac dostavljac){
        getDostavljaci().add(dostavljac);
        dostavljac.setKorisnik(this);
        return dostavljac;
    }

    public Dostavljac removeDostavljac(Dostavljac dostavljac){
        getDostavljaci().remove(dostavljac);
        dostavljac.setKorisnik(null);
        return dostavljac;
    }

    //dodatak za kupca(get, set, add, remove)


    public List<Kupac> getKupci() {
        return this.kupci;
    }

    public void setKupci(List<Kupac> kupci) {
        this.kupci = kupci;
    }

    public Kupac addKupac(Kupac kupac){
        getKupci().add(kupac);
        kupac.setKorisnik(this);
        return kupac;
    }

    public Kupac removeKupac(Kupac kupac){
        getKupci().remove(kupac);
        kupac.setKupac(null);
        return kupac;
    }

    //dodatak za menadzera(get, set, add, remove)
    public List<Menadzer> getMenadzeri() {
        return this.menadzeri;
    }

    public void setMenadzeri(List<Menadzer> menadzeri) {
        this.menadzeri = menadzeri;
    }

    public Menadzer addMenadzer(Menadzer menadzer){
        getMenadzeri().add(menadzer);
        menadzer.setKorisnik(this);
        return menadzer;
    }

    public Menadzer removeMenadzer(Menadzer menadzer){
        getMenadzeri().remove(menadzer);
        menadzer.setKorisnik(null);
        return menadzer;
    }

    public Korisnik(String korisnicko_ime, String lozinka, String ime, String prezime, Pol p, Date datum_rodjenja) {
        this.korisnicko_ime = korisnicko_ime;
        this.lozinka = lozinka;
        this.ime = ime;
        this.prezime = prezime;
        this.pol = p;
        this.datum_rodjenja = datum_rodjenja;
    }

    public Long getIdKorisnika() {
        return idKorisnika;
    }

    public void setIdKorisnika(Long idKorisnika) {
        this.idKorisnika = idKorisnika;
    }

    public String getKorisnicko_ime() {
        return korisnicko_ime;
    }

    public void setKorisnicko_ime(String korisnicko_ime) {
        this.korisnicko_ime = korisnicko_ime;
    }


    public String getLozinka() {
        return lozinka;
    }

    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public Pol getPol() {
        return pol;
    }

    public Date getDatum_rodjenja() {
        return datum_rodjenja;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public void setPol(Pol pol) {
        this.pol = pol;
    }

    public void setDatum_rodjenja(Date datum_rodjenja) {
        this.datum_rodjenja = datum_rodjenja;
    }

    @Override
    public String toString() {
        return "Korisnik{" +
                "Korisnicko_ime='" + korisnicko_ime + '\'' +
                ", lozinka='" + lozinka + '\'' +
                ", ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", p=" + pol +
                ", Datum_rodjenja=" + datum_rodjenja +
                '}';
    }
}

