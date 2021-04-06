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

    @ColumnInfo(name = "gen")
    private String gen;

    @ColumnInfo(name = "poza")
    private String poza;

    public Antrenament(@NonNull String denumireAntrenamentID, int dificultate, String grupaDeMuschi, String locatie, String gen, String poza) {
        this.denumireAntrenamentID = denumireAntrenamentID;
        this.dificultate = dificultate;
        this.grupaDeMuschi = grupaDeMuschi;
        this.locatie = locatie;
        this.gen = gen;
        this.poza = poza;
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

    public String getGen() {
        return gen;
    }

    public String getPoza() {
        return poza;
    }
}
