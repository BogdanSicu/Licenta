package com.example.doza_de_sanatate.RoomDataBase.Classes;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity (tableName = "mancare")
public class Mancare {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "mancareID")
    private long mancareID;

    @ColumnInfo(name = "denumire")
    private String denumire;

    @ColumnInfo(name = "poza")
    private String poza;

    @ColumnInfo(name = "kcal")
    private int kcal;

    @ColumnInfo(name = "carbs")
    private int carbs;

    @ColumnInfo(name = "protein")
    private int protein;

    public Mancare(long mancareID, String denumire, String poza, int kcal, int carbs, int protein) {
        this.mancareID = mancareID;
        this.denumire = denumire;
        this.poza = poza;
        this.kcal = kcal;
        this.carbs = carbs;
        this.protein = protein;
    }

    @Ignore
    public Mancare(String denumire, String poza, int kcal, int carbs, int protein) {
        this.denumire = denumire;
        this.poza = poza;
        this.kcal = kcal;
        this.carbs = carbs;
        this.protein = protein;
    }

    public long getMancareID() {
        return mancareID;
    }

    public void setMancareID(long mancareID) {
        this.mancareID = mancareID;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public String getPoza() {
        return poza;
    }

    public void setPoza(String poza) {
        this.poza = poza;
    }

    public int getKcal() {
        return kcal;
    }

    public void setKcal(int kcal) {
        this.kcal = kcal;
    }

    public int getCarbs() {
        return carbs;
    }

    public void setCarbs(int carbs) {
        this.carbs = carbs;
    }

    public int getProtein() {
        return protein;
    }

    public void setProtein(int protein) {
        this.protein = protein;
    }
}
