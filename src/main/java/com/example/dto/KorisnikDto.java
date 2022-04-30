package com.example.dto;

import com.example.entity.Pol;
import com.example.entity.Uloga;

import javax.persistence.*;
import java.util.Date;

public class KorisnikDto {

    protected Long idKorisnika;

    protected String korisnicko_ime;

    protected String ime;

    protected String prezime;

    protected Pol pol;

    protected Date datum_rodjenja;

    protected Uloga uloga;


}
