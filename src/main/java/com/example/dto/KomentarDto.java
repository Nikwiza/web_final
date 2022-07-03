package com.example.dto;


import com.example.entity.Komentar;
import com.example.entity.Korisnik;
import com.example.entity.Kupac;

public class KomentarDto {
    private String user;
    private String text;
    private int ocena;

    private String uuid;

    public KomentarDto() {
    }

    public KomentarDto(String text, int ocena, String uuid){
        this.text = text;
        this.ocena = ocena;
        this.uuid = uuid;
    }
    public KomentarDto(Komentar komentar) {
        Kupac kupac = komentar.getKupac();
        this.user = kupac.getKorisnicko();
        this.ocena = komentar.getOcena();
        this.text = komentar.getText();
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getOcena() {
        return ocena;
    }

    public void setOcena(int ocena) {
        this.ocena = ocena;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
