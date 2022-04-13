package com.company.entity;

import java.util.*;
import java.text.SimpleDateFormat;
import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * This is a class that describes an order
 *
 * */


enum Status{OBRADA, U_PRIPREMI, CEKA_DOSTAVLJACA, U_TRANSPORTU, DOSTAVLJENA, OTKAZANA};

@Entity
public class Porudzbina implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long porudzbina_id;

    @Column(nullable = false, unique = true)
    private UUID uuid;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="Artikli_u_porudzbini",
            joinColumns = {@JoinColumn(name="porudzbina_id")},
            inverseJoinColumns = {@JoinColumn(name = "idArtikla")})
    private Set<Artikal> artikli = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "restoran_id_lokacija")
    private Restoran restoran;

    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private Date datum;

    @Column
    private float cena;

    @ManyToOne
    @JoinColumn(name = "kupacId")
    private Kupac kupac;

    @Enumerated(EnumType.ORDINAL)
    @Column
    Status status;


    public Porudzbina() {
    }

    public Porudzbina(UUID uuid, Set<Artikal> artikli, Restoran restoran, Date datum, float cena, Kupac kupac, Status status) {
        this.uuid = uuid;
        this.artikli = artikli;
        this.restoran = restoran;
        this.datum = datum;
        this.cena = cena;
        this.kupac = kupac;
        this.status = status;
    }

    public Long getPorudzbina_id() {
        return porudzbina_id;
    }

    public void setPorudzbina_id(Long porudzbina_id) {
        this.porudzbina_id = porudzbina_id;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public Set<Artikal> getArtikli() {
        return artikli;
    }

    public void setArtikli(Set<Artikal> artikli) {
        this.artikli = artikli;
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
