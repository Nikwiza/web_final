package com.example.dto;

import com.example.entity.Artikal;
import com.example.entity.Lokacija;
import com.example.entity.Restoran;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

public class RestoranDto {

    private String naziv;

    private String tip_restorana;

    private Set<Lokacija> lokacije;

    private StatusRestorana status;

    public RestoranDto() {
    }

    public RestoranDto(Restoran restoran){
        this.naziv = restoran.getNaziv();
        this.tip_restorana = restoran.getTip_restorana();
        this.lokacije = restoran.getLokacija();
        this.status = restoran.getStatus();
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

    public Set<Lokacija> getLokacije() {
        return lokacije;
    }

    public void setLokacije(Set<Lokacija> lokacije) {
        this.lokacije = lokacije;
    }

    public StatusRestorana getStatus() {
        return status;
    }

    public void setStatus(StatusRestorana status) {
        this.status = status;
    }
}
