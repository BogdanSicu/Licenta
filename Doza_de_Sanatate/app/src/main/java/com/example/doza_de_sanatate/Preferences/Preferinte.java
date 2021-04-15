package com.example.doza_de_sanatate.Preferences;

public class Preferinte {
    private String aSmallPriceToPayForSalvation;
    private String preferedAge;
    private String preferedHeight;
    private String preferedWeight;
    private String preferedGender;
    private String preferedSport;
    private String preferedGoal;
    private String preferedExercises;
    private String preferedHour;
    private String preferedMinute;
    private String preferedAlarm;
    private String preferedNavigationBar;

    private static Preferinte preferinte=null;

    private Preferinte() {
    }

    public static Preferinte getInstance(){
        if(preferinte==null){
            preferinte = new Preferinte();
            preferinte.aSmallPriceToPayForSalvation = "doza_de_sanatate_preferinte";
            preferinte.preferedAge = "doza_de_sanatate_varsta";
            preferinte.preferedHeight = "doza_de_sanatate_inaltime";
            preferinte.preferedWeight = "doza_de_sanatate_greutate";
            preferinte.preferedGender = "doza_de_sanatate_gen";
            preferinte.preferedSport = "doza_de_sanatate_sport";
            preferinte.preferedGoal = "doza_de_sanatate_obiectiv";
            preferinte.preferedExercises = "doza_de_sanatate_exercitii";
            preferinte.preferedHour = "doza_de_sanatate_ora";
            preferinte.preferedMinute = "doza_de_sanatate_minut";
            preferinte.preferedAlarm = "doza_de_sanatate_alarma";
            preferinte.preferedNavigationBar = "doza_de_sanatate_navigation_bar";
        }
        return preferinte;
    }

    public String getaSmallPriceToPayForSalvation() {
        return aSmallPriceToPayForSalvation;
    }

    public String getPreferedAge() {
        return preferedAge;
    }

    public String getPreferedHeight() {
        return preferedHeight;
    }

    public String getPreferedWeight() {
        return preferedWeight;
    }

    public String getPreferedGender() {
        return preferedGender;
    }

    public String getPreferedSport() {
        return preferedSport;
    }

    public String getPreferedGoal() {
        return preferedGoal;
    }

    public String getPreferedExercises() {
        return preferedExercises;
    }

    public String getPreferedHour() {
        return preferedHour;
    }

    public String getPreferedMinute() {
        return preferedMinute;
    }

    public String getPreferedAlarm() {
        return preferedAlarm;
    }

    public String getPreferedNavigationBar() {
        return preferedNavigationBar;
    }
}
