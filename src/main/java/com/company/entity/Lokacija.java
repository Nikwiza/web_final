package com.company.entity;
//Funckija koja predstavlja lokaciju
import java.io.Serializable;
import javax.persistence.*;

@Entity
@NamedQuery(name = "Lokacija.findALL", query = "SELECT u FROM Lokacija l")
public class Lokacija implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLokacija;

    @Column
    protected double geografska_duzina;

    @Column
    protected double geografska_sirina;

    @Column
    protected String adresa;

    public Lokacija() {}

    @OneToOne(mappedBy = "lokacija")
    private Restoran restoran;

    public Restoran getRestoran() {
        return this.restoran;
    }

    public void setRestoran(Restoran restoran) {
        this.restoran = restoran;
    }

    public Lokacija(double geografska_duzina, double geografska_sirina, String adresa) {
        this.geografska_duzina = geografska_duzina;
        this.geografska_sirina = geografska_sirina;
        this.adresa = adresa;
    }

    public int getIdLokacija(){
        return this.idLokacija;
    }

    public void setIdLokacija(int idLokacija){
        this.idLokacija = idLokacija;
    }

    public double getGeografska_duzina() {
        return geografska_duzina;
    }

    public void setGeografska_duzina(double geografska_duzina) {
        this.geografska_duzina = geografska_duzina;
    }

    public double getGeografska_sirina() {
        return geografska_sirina;
    }

    public void setGeografska_sirina(double geografska_sirina) {
        this.geografska_sirina = geografska_sirina;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }
}
