package com.example.dto;

public class StavkaDto {
    private int broj;
    private Long artikal;

    public StavkaDto() {
    }

    public StavkaDto(int broj, Long artikal) {
        this.broj = broj;
        this.artikal = artikal;
    }

    public int getBroj() {
        return broj;
    }

    public void setBroj(int broj) {
        this.broj = broj;
    }

    public Long getArtikal() {
        return artikal;
    }

    public void setArtikal(Long artikal) {
        this.artikal = artikal;
    }
}
