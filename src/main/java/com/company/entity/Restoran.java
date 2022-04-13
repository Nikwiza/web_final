package com.company.entity;
import java.util.ArrayList;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

/**
 *
 * This is a class that describes the restaurant
 *
 * */

@Entity
public class Restoran implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRestorana;

    @Column
    private String naziv;

    @Column
    private String tip_restorana;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="Artikli_u_restoranima",
    joinColumns = {@JoinColumn(name="idRestorana")},
    inverseJoinColumns = {@JoinColumn(name = "idArtikla")})
    private Set<Artikal> artikli = new HashSet<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idLokacija")
    private Lokacija lokacija;

    public Restoran(){}

    public Restoran(String naziv, String tip_restorana, Set<Artikal> artikli, Lokacija lokacija) {
        this.naziv = naziv;
        this.tip_restorana = tip_restorana;
        this.artikli = artikli;
        this.lokacija = lokacija;
    }

    public Long getIdLokacija() {
        return this.idRestorana;
    }

    public void setIdLokacija(Long idRestorana) {
        this.idRestorana = idRestorana;
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

    public Set<Artikal> getArtikli() {
        return artikli;
    }

    public void setArtikli(Set<Artikal> artikli) {
        this.artikli = artikli;
    }

    public Lokacija getLokacija() {
        return lokacija;
    }

    public void setLokacija(Lokacija lokacija) {
        this.lokacija = lokacija;
    }
}
