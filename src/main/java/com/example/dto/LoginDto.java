package com.example.dto;

public class LoginDto {

    private String korisnicko;
    private String lozinka;

    public LoginDto() {
    }

    public LoginDto(String korisnicko, String lozinka) {
        this.korisnicko = korisnicko;
        this.lozinka = lozinka;
    }

    public String getKorisnicko() {
        return korisnicko;
    }

    public void setKorisnicko(String korisnicko) {
        this.korisnicko = korisnicko;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }
}
