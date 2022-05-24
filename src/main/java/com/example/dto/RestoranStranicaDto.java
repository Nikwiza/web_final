package com.example.dto;

import com.example.entity.Komentar;
import com.example.entity.Lokacija;

import java.util.List;

enum Status{RADI, NE_RADI};
//todo: Finish

public class RestoranStranicaDto {
    private String naziv;
    private String tip;
    private Lokacija lokacija;
    private float ocena;
    private Status status;
    private List<Komentar> komentari;

}
