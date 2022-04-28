package com.example.entity;

import java.util.Date;
import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * This is a class that describes the manager
 *
 * */

@Entity

public class Menadzer extends Korisnik implements Serializable {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "restoran_id", referencedColumnName = "idRestorana")
    private Restoran restoran;

    public Menadzer() {
        super(Uloga.MENADZER);
    }

    public Menadzer(String korisnicko_ime, String lozinka, String ime, String prezime, Pol pol, Date datum_rodjenja, Restoran restoran) {
        super(korisnicko_ime, lozinka, ime, prezime, pol, datum_rodjenja, Uloga.MENADZER);
        this.restoran = restoran;
    }

    public Restoran getRestoran() {
        return restoran;
    }

    public void setRestoran(Restoran restoran) {
        this.restoran = restoran;
    }
}
