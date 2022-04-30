package com.example.entity;

import java.util.*;
import java.io.Serializable;
import javax.persistence.*;

;

@Entity
public class Porudzbina implements Serializable {
    @Id
    @GeneratedValue
    private UUID uuid;

    @ManyToMany(cascade = {CascadeType.ALL}) //klasa kao stavka porudzbine kolicina porucenog, dodavanje kolicine
    @JoinTable(name="Stavke_u_porudzbini",
            joinColumns = {@JoinColumn(name="idPorudzbine")},
            inverseJoinColumns = {@JoinColumn(name = "idStavke")})
    private Set<Stavka> stavke = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "restoran_id_lokacija")
    private Restoran restoran;

    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private Date datum;

    @Column
    private float cena;

    @ManyToOne
    @JoinColumn(name = "korisnicko_ime")
    private Kupac kupac;

    @Enumerated(EnumType.STRING)
    @Column
    Status status;


    public Porudzbina() {
    }

    public Porudzbina(UUID uuid, Set<Stavka> stavke, Restoran restoran, Date datum, float cena, Kupac kupac, Status status) {
        this.uuid = uuid;
        this.stavke = stavke;
        this.restoran = restoran;
        this.datum = datum;
        this.cena = cena;
        this.kupac = kupac;
        this.status = status;
    }


    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public Set<Stavka> getStavke() {
        return stavke;
    }

    public void setStavke(Set<Stavka> stavke) {
        this.stavke = stavke;
    }

    public Restoran getRestoran() {
        return restoran;
    }

    public void setRestoran(Restoran restoran) {
        this.restoran = restoran;
    }

    public Date getDatum() {
        return datum;
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

    public Kupac getKupac() {
        return kupac;
    }

    public void setKupac(Kupac kupac) {
        this.kupac = kupac;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
