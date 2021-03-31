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
    private double carbs;

    @ColumnInfo(name = "protein")
    private double protein;

    public Mancare(long mancareID, String denumire, String poza, int kcal, double carbs, double protein) {
        this.mancareID = mancareID;
        this.denumire = denumire;
        this.poza = poza;
        this.kcal = kcal;
        this.carbs = carbs;
        this.protein = protein;
    }

    @Ignore
    public Mancare(String denumire, String poza, int kcal, double carbs, double protein) {
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

    public double getCarbs() {
        return carbs;
    }

    public void setCarbs(double carbs) {
        this.carbs = carbs;
    }

    public double getProtein() {
        return protein;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }
}
