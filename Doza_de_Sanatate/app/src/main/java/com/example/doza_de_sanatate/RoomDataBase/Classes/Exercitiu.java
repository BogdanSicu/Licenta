package com.example.doza_de_sanatate.RoomDataBase.Classes;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "exercitiu")
public class Exercitiu implements Serializable {

    @NonNull
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "denumireExercitiuID")
    private String denumireExercitiuID;

    @ColumnInfo(name = "grupaDeMuschi")
    private String grupaDeMuschi;

    @ColumnInfo(name = "pozeFemeie1")
    private String pozeFemeie1;

    @ColumnInfo(name = "pozeFemeie2")
    private String pozeFemeie2;

    @ColumnInfo(name = "pozeBarbat1")
    private String pozeBarbat1;

    @ColumnInfo(name = "pozeBarbat2")
    private String pozeBarbat2;

    @ColumnInfo(name = "iconitaFemeie")
    private String iconitaFemeie;

    @ColumnInfo(name = "iconitaBarbat")
    private String iconitaBarbat;

    public Exercitiu(String denumireExercitiuID, String grupaDeMuschi, String pozeFemeie1, String pozeFemeie2, String pozeBarbat1, String pozeBarbat2, String iconitaFemeie, String iconitaBarbat) {
        this.denumireExercitiuID = denumireExercitiuID;
        this.grupaDeMuschi = grupaDeMuschi;
        this.pozeFemeie1 = pozeFemeie1;
        this.pozeFemeie2 = pozeFemeie2;
        this.pozeBarbat1 = pozeBarbat1;
        this.pozeBarbat2 = pozeBarbat2;
        this.iconitaFemeie = iconitaFemeie;
        this.iconitaBarbat = iconitaBarbat;
    }

    public String getDenumireExercitiuID() {
        return denumireExercitiuID;
    }

    public String getGrupaDeMuschi() {
        return grupaDeMuschi;
    }

    public String getPozeFemeie1() {
        return pozeFemeie1;
    }

    public String getPozeFemeie2() {
        return pozeFemeie2;
    }

    public String getPozeBarbat1() {
        return pozeBarbat1;
    }

    public String getPozeBarbat2() {
        return pozeBarbat2;
    }

    public String getIconitaFemeie() {
        return iconitaFemeie;
    }

    public String getIconitaBarbat() {
        return iconitaBarbat;
    }


}
