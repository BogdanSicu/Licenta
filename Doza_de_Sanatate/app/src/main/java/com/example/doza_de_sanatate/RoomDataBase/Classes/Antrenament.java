package com.example.doza_de_sanatate.RoomDataBase.Classes;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "antrenament")
public class Antrenament implements Serializable {

    @NonNull
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "denumireAntrenamentID")
    private String denumireAntrenamentID;

    @ColumnInfo(name = "dificultate")
    private int dificultate;

    @ColumnInfo(name = "grupaDeMuschi")
    private String grupaDeMuschi;

    @ColumnInfo(name = "locatie")
    private String locatie;

    @ColumnInfo(name = "pozaFemeie")
    private String pozaFemeie;

    @ColumnInfo(name = "pozaBarbat")
    private String pozaBarbat;

    public Antrenament(@NonNull String denumireAntrenamentID, int dificultate, String grupaDeMuschi, String locatie, String pozaFemeie, String pozaBarbat) {
        this.denumireAntrenamentID = denumireAntrenamentID;
        this.dificultate = dificultate;
        this.grupaDeMuschi = grupaDeMuschi;
        this.locatie = locatie;
        this.pozaFemeie = pozaFemeie;
        this.pozaBarbat = pozaBarbat;
    }

    public String getDenumireAntrenamentID() {
        return denumireAntrenamentID;
    }

    public int getDificultate() {
        return dificultate;
    }

    public String getGrupaDeMuschi() {
        return grupaDeMuschi;
    }

    public String getLocatie() {
        return locatie;
    }

    public String getPozaFemeie() {
        return pozaFemeie;
    }

    public String getPozaBarbat() {
        return pozaBarbat;
    }
}
