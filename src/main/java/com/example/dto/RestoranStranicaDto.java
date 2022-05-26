package com.example.dto;

import com.example.entity.Komentar;
import com.example.entity.Lokacija;
import com.example.entity.Restoran;

import java.util.List;
import java.util.Set;

enum Status{RADI, NE_RADI};
//todo: Finish

public class RestoranStranicaDto {
    private String naziv;
    private String tip;
    private Set<Lokacija> lokacije;
    private float ocena;
    private Status status;
    private Set<KomentarDto> komentari;
    private Set<ArtikalDto> artikli;

    public RestoranStranicaDto() {
    }

    public RestoranStranicaDto(RestoranDto restoran, float ocena, Set<KomentarDto> komentari, Set<ArtikalDto> artikli, Status status) {
        this.naziv = restoran.getNaziv();
        this.tip = restoran.getTip_restorana();
        this.lokacije = restoran.getLokacije();
        this.ocena = ocena;
        this.komentari = komentari;
        this.artikli = artikli;
        this.status = status;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public Set<Lokacija> getLokacije() {
        return lokacije;
    }

    public void setLokacije(Set<Lokacija> lokacije) {
        this.lokacije = lokacije;
    }

    public float getOcena() {
        return ocena;
    }

    public void setOcena(float ocena) {
        this.ocena = ocena;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Set<KomentarDto> getKomentari() {
        return komentari;
    }

    public void setKomentari(Set<KomentarDto> komentari) {
        this.komentari = komentari;
    }

    public Set<ArtikalDto> getArtikli() {
        return artikli;
    }

    public void setArtikli(Set<ArtikalDto> artikli) {
        this.artikli = artikli;
    }
}
