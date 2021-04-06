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

    @ColumnInfo(name = "pozeFemeie")
    private String pozeFemeie;

    @ColumnInfo(name = "pozeBarbat")
    private String pozeBarbat;

    @ColumnInfo(name = "iconitaFemeie")
    private String iconitaFemeie;

    @ColumnInfo(name = "iconitaBarbat")
    private String iconitaBarbat;

    public Exercitiu(@NonNull String denumireExercitiuID, String grupaDeMuschi, String pozeFemeie, String pozeBarbat, String iconitaFemeie, String iconitaBarbat) {
        this.denumireExercitiuID = denumireExercitiuID;
        this.grupaDeMuschi = grupaDeMuschi;
        this.pozeFemeie = pozeFemeie;
        this.pozeBarbat = pozeBarbat;
        this.iconitaFemeie = iconitaFemeie;
        this.iconitaBarbat = iconitaBarbat;
    }

    public String getDenumireExercitiuID() {
        return denumireExercitiuID;
    }

    public String getGrupaDeMuschi() {
        return grupaDeMuschi;
    }

    public String getPozeFemeie() {
        return pozeFemeie;
    }

    public String getPozeBarbat() {
        return pozeBarbat;
    }

    public String getIconitaFemeie() {
        return iconitaFemeie;
    }

    public String getIconitaBarbat() {
        return iconitaBarbat;
    }


}
