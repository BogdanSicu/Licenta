package com.example.doza_de_sanatate.Classes;

public class Mancare {
    private String denumire;
    private String poza;
    private int kcal;
    private int carbs;
    private int protein;

    public Mancare(String denumire, String poza, int kcal, int carbs, int protein) {
        this.denumire = denumire;
        this.poza = poza;
        this.kcal = kcal;
        this.carbs = carbs;
        this.protein = protein;
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Mancare{");
        sb.append("denumire='").append(denumire).append('\'');
        sb.append(", poza='").append(poza).append('\'');
        sb.append(", kcal=").append(kcal);
        sb.append(", carbs=").append(carbs);
        sb.append(", protein=").append(protein);
        sb.append('}');
        return sb.toString();
    }
}
