package com.company.entity;

import java.util.ArrayList;

public class Main {
    public static void main(String args[]){
        Artikal ar = new Artikal();
        Artikal ar1 = new Artikal("Naziv", 23, "tip", 30, "Test");
        ArrayList<Artikal> lista = new ArrayList<>();
        lista.add(ar);
        lista.add(ar1);
        Lokacija lok = new Lokacija(23, 4, "Foc 22");
        Restoran restoran = new Restoran("siki", "susi",lista , lok);

        Porudzbina porudzbina = new Porudzbina(22334,lista, restoran, 234, "Iju");
        System.out.println(porudzbina.getDatum());

    }
}
