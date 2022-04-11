package com.company.entity;
import java.util.ArrayList;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@NamedQuery(name = "Restoran.findALL", query = "SELECT r FROM Restoran r")
public class Restoran implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLokacija;

    @Column
    private String naziv;

    @Column
    private String tip_restorana;

    @Column
    private ArrayList<Artikal> artikli;

    public Lokacija(){}

    @OneToOne
    @JoinColumn(name = "idLokacija")
    private Lokacija lokacija;

    public Restoran(String naziv, String tip_restorana, ArrayList<Artikal> artikli, Lokacija lokacija) {
        this.naziv = naziv;
        this.tip_restorana = tip_restorana;
        this.artikli = artikli;
        this.lokacija = lokacija;
    }

    public int getIdLokacija() {
        return this.idLokacija;
    }

    public void setIdLokacija(int idLokacija) {
        this.idLokacija = idLokacija;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getTip_restorana() {
        return tip_restorana;
    }

    public void setTip_restorana(String tip_restorana) {
        this.tip_restorana = tip_restorana;
    }

    public ArrayList<Artikal> getArtikli() {
        return artikli;
    }

    public void setArtikli(ArrayList<Artikal> artikli) {
        this.artikli = artikli;
    }

    public Lokacija getLokacija() {
        return lokacija;
    }

    public void setLokacija(Lokacija lokacija) {
        this.lokacija = lokacija;
    }
}
