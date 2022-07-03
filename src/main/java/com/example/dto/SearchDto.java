package com.example.dto;

public class SearchDto {
    public String naziv;
    public String lokacija;
    public String tip;

    public SearchDto() {
    }

    public SearchDto(String naziv, String lokacija, String tip) {
        this.naziv = naziv;
        this.lokacija = lokacija;
        this.tip = tip;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getLokacija() {
        return lokacija;
    }

    public void setLokacija(String lokacija) {
        this.lokacija = lokacija;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }
}
