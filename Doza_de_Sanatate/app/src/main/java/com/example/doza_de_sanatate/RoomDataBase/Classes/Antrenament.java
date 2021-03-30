package com.example.doza_de_sanatate.RoomDataBase.Classes;

import java.io.Serializable;
import java.util.ArrayList;

public class Antrenament implements Serializable {
    private String denumire;
    private int dificultate;
    private String grupaDeMuschi;
    private ArrayList<Exercitiu> listaExercitii;
    private int repetari;
    private int serii;
    private String locatie;
    private String pozaFemeie;
    private String pozaBarbat;

    public Antrenament(String denumire, int dificultate, String grupaDeMuschi, ArrayList<Exercitiu> listaExercitii, int repetari, int serii, String locatie, String pozaFemeie, String pozaBarbat) {
        this.denumire = denumire;
        this.dificultate = dificultate;
        this.grupaDeMuschi = grupaDeMuschi;
        this.listaExercitii = listaExercitii;
        this.repetari = repetari;
        this.serii = serii;
        this.locatie = locatie;
        this.pozaFemeie = pozaFemeie;
        this.pozaBarbat = pozaBarbat;
    }

    public Antrenament() {
    }

    public int getDificultate() {
        return dificultate;
    }

    public void setDificultate(int dificultate) {
        this.dificultate = dificultate;
    }

    public String getGrupaDeMuschi() {
        return grupaDeMuschi;
    }

    public void setGrupaDeMuschi(String grupaDeMuschi) {
        this.grupaDeMuschi = grupaDeMuschi;
    }

    public ArrayList<Exercitiu> getListaExercitii() {
        return listaExercitii;
    }

    public void setListaExercitii(ArrayList<Exercitiu> listaExercitii) {
        this.listaExercitii = listaExercitii;
    }

    public int getRepetari() {
        return repetari;
    }

    public void setRepetari(int repetari) {
        this.repetari = repetari;
    }

    public int getSerii() {
        return serii;
    }

    public void setSerii(int serii) {
        this.serii = serii;
    }

    public String getLocatie() {
        return locatie;
    }

    public void setLocatie(String locatie) {
        this.locatie = locatie;
    }

    public String getPozaFemeie() {
        return pozaFemeie;
    }

    public void setPozaFemeie(String pozaFemeie) {
        this.pozaFemeie = pozaFemeie;
    }

    public String getPozaBarbat() {
        return pozaBarbat;
    }

    public void setPozaBarbat(String pozaBarbat) {
        this.pozaBarbat = pozaBarbat;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    @Override
    public String toString() {
        return "Antrenament{" +
                "denumire='" + denumire + '\'' +
                ", dificultate=" + dificultate +
                ", grupaDeMuschi='" + grupaDeMuschi + '\'' +
                ", listaExercitii=" + listaExercitii +
                ", repetari=" + repetari +
                ", serii=" + serii +
                ", locatie='" + locatie + '\'' +
                ", pozaFemeie='" + pozaFemeie + '\'' +
                ", pozaBarbat='" + pozaBarbat + '\'' +
                '}';
    }
}
