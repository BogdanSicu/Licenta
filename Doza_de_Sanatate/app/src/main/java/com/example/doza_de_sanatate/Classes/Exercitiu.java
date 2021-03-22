package com.example.doza_de_sanatate.Classes;

import java.util.ArrayList;

public class Exercitiu {
    private String grupaDeMuschi;
    private String denumire;
    private String locatie;
    private ArrayList<String> pozeFemeie;
    private ArrayList<String> pozeBarbat;

    public Exercitiu() {
    }

    public Exercitiu(String grupaDeMuschi, String denumire, String locatie, ArrayList<String> pozeFemeie, ArrayList<String> pozeBarbat) {
        this.grupaDeMuschi = grupaDeMuschi;
        this.denumire = denumire;
        this.locatie = locatie;
        this.pozeFemeie = pozeFemeie;
        this.pozeBarbat = pozeBarbat;
    }

    public String getGrupaDeMuschi() {
        return grupaDeMuschi;
    }

    public void setGrupaDeMuschi(String grupaDeMuschi) {
        this.grupaDeMuschi = grupaDeMuschi;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public String getLocatie() {
        return locatie;
    }

    public void setLocatie(String locatie) {
        this.locatie = locatie;
    }

    public ArrayList<String> getPozeFemeie() {
        return pozeFemeie;
    }

    public void setPozeFemeie(ArrayList<String> pozeFemeie) {
        this.pozeFemeie = pozeFemeie;
    }

    public ArrayList<String> getPozeBarbat() {
        return pozeBarbat;
    }

    public void setPozeBarbat(ArrayList<String> pozeBarbat) {
        this.pozeBarbat = pozeBarbat;
    }

    @Override
    public String toString() {
        return "Exercitiu{" +
                "grupaDeMuschi='" + grupaDeMuschi + '\'' +
                ", denumire='" + denumire + '\'' +
                ", locatie='" + locatie + '\'' +
                ", pozeFemeie=" + pozeFemeie +
                ", pozeBarbat=" + pozeBarbat +
                '}';
    }
}
