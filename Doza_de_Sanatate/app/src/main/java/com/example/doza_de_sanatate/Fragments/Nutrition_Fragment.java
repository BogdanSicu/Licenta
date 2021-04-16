package com.example.doza_de_sanatate.Fragments;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.icu.text.DecimalFormat;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.doza_de_sanatate.Adapters.AdapterFood;
import com.example.doza_de_sanatate.Preferences.Preferinte;
import com.example.doza_de_sanatate.RoomDataBase.Classes.Mancare;
import com.example.doza_de_sanatate.R;
import com.example.doza_de_sanatate.RoomDataBase.Services.MancareService;
import com.example.doza_de_sanatate.asyncTask.Callback;

import java.util.ArrayList;
import java.util.List;

public class Nutrition_Fragment extends Fragment {

    private List<Mancare> listaMancare = new ArrayList<>();

    private TextView nutritionKcal;
    private TextView nutritionCarb;
    private TextView nutritionProtein;
    private ListView nutritionListView;

    private AdapterFood adapterFood;

    private MancareService mancareService;
    private LayoutInflater layoutInflater;

//    preferinte
        private Preferinte instancePreferinte = Preferinte.getInstance();

        private int preferinte_varsta;
        private int preferinte_inaltime;
        private int preferinte_greutate;
        private String preferinte_gen;
        private String preferinte_sport;
        private String preferinte_obiectiv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_nutrition_, container, false);
        layoutInflater = inflater;

        SharedPreferences preferinte = getContext().getSharedPreferences(instancePreferinte.getaSmallPriceToPayForSalvation(), getContext().MODE_PRIVATE);
        initPreferences(preferinte);
        initComponents(view);
        initText();

        mancareService.getAllMancare(getAllMancareCallBack());

        return view;
    }

    void initComponents(View view){
        nutritionKcal = view.findViewById(R.id.fragment_nutrition_kcal);
        nutritionCarb = view.findViewById(R.id.fragment_nutrition_carb);
        nutritionProtein = view.findViewById(R.id.fragment_nutrition_protein);
        nutritionListView = view.findViewById(R.id.fragment_nutrition_list);
        mancareService = new MancareService(getContext());
    }

    private Callback<List<Mancare>> getAllMancareCallBack(){
        return new Callback<List<Mancare>>() {
            @Override
            public void runResultOnUiThread(List<Mancare> result) {
                if(result != null){
                    listaMancare.clear();
                    listaMancare.addAll(result);
                    listaMancare.add(null);
                    resetAdapterMancare();
                }
            }
        };
    }

    private void resetAdapterMancare(){
        adapterFood = new AdapterFood(getContext().getApplicationContext(), R.layout.adapter_food_view, listaMancare, layoutInflater);
        nutritionListView.setAdapter(adapterFood);
    }

    void initPreferences(SharedPreferences preferinte){
        preferinte_varsta = preferinte.getInt(instancePreferinte.getPreferedAge(), -1);
        preferinte_inaltime = preferinte.getInt(instancePreferinte.getPreferedHeight(), -1);
        preferinte_greutate = preferinte.getInt(instancePreferinte.getPreferedWeight(), -1);
        preferinte_gen = preferinte.getString(instancePreferinte.getPreferedGender(), "");
        preferinte_sport = preferinte.getString(instancePreferinte.getPreferedSport(), "");
        preferinte_obiectiv = preferinte.getString(instancePreferinte.getPreferedGoal(), "");
    }

    @SuppressLint("SetTextI18n")
    void initText(){
        double LBM = 0;
        double kgToPound = preferinte_greutate * 2.2;
        double cmToInch = preferinte_inaltime * 0.393;
        double metabolicRate = 0;
        double carbsNeeded = 0;

        if(preferinte_gen.equals("Barbat")){
            LBM = (preferinte_greutate * 0.407) + (preferinte_inaltime * 0.267) - 19.2;
            kgToPound *= 6.23;
            cmToInch *= 12.7;
            metabolicRate = kgToPound + cmToInch - (preferinte_varsta * 6.8) + 66;

        }else if(preferinte_gen.equals("Femeie")){
            LBM = (preferinte_greutate * 0.252) + (preferinte_inaltime * 0.473) - 48.3;
            kgToPound *= 4.35;
            cmToInch *= 4.7;
            metabolicRate = kgToPound + cmToInch - (preferinte_varsta * 4.7) + 655;
        }

        switch (preferinte_sport) {
            case "rar":
                LBM = LBM * 0.5;
                metabolicRate *= 1.2;
                break;
            case "moderat":
                LBM = LBM * 0.7;
                metabolicRate *= 1.55;
                break;
            case "des":
                LBM = LBM * 0.8;
                metabolicRate *= 1.7;
                break;
        }

        if(preferinte_obiectiv.equals("slabire")){
            metabolicRate -= 500;
        }else if(preferinte_obiectiv.equals("musculatura")){
            metabolicRate += 500;
        }
        carbsNeeded = (metabolicRate / 2) / 4;

        DecimalFormat form = new DecimalFormat("0.00");

        nutritionKcal.setText("You need around " + form.format(metabolicRate) +" kilocalories everyday");
        nutritionCarb.setText("You need around " + form.format(carbsNeeded) +" grams of carbohydrates everyday");
        nutritionProtein.setText("You need around " + form.format(LBM)  +" grams of protein everyday");
    }


}