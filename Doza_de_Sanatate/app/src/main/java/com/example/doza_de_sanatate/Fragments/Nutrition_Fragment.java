package com.example.doza_de_sanatate.Fragments;

import android.annotation.SuppressLint;
import android.content.Intent;
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
import com.example.doza_de_sanatate.Adapters.AdapterRecyclerFood;
import com.example.doza_de_sanatate.MainActivity;
import com.example.doza_de_sanatate.RoomDataBase.Classes.Mancare;
import com.example.doza_de_sanatate.R;
import com.example.doza_de_sanatate.RoomDataBase.Services.MancareService;
import com.example.doza_de_sanatate.asyncTask.Callback;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class Nutrition_Fragment extends Fragment {

    private List<Mancare> listaMancare = new ArrayList<>();

    private TextView nutritionKcal;
    private TextView nutritionCarb;
    private TextView nutritionProtein;
//    private ListView nutritionListView;
    private RecyclerView foodRecyclerView;
    private RecyclerView.Adapter foodRecyclerAdapter;
    private RecyclerView.LayoutManager foodRecyclerLayout;


    private AdapterFood adapterFood;

    private MancareService mancareService;
    private LayoutInflater layoutInflater;

//    preferinte
        private static final String aSmallPriceToPayForSalvation = "doza_de_sanatate_preferinte";
        private static final String preferedAge = "doza_de_sanatate_varsta";
        private static final String preferedHeight = "doza_de_sanatate_inaltime";
        private static final String preferedWeight = "doza_de_sanatate_greutate";
        private static final String preferedGender = "doza_de_sanatate_gen";
        private static final String preferedSport = "doza_de_sanatate_sport";
        private static final String preferedGoal = "doza_de_sanatate_obiectiv";

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

        SharedPreferences preferinte = getContext().getSharedPreferences(aSmallPriceToPayForSalvation, getContext().MODE_PRIVATE);
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
//        nutritionListView = view.findViewById(R.id.fragment_nutrition_list);
        mancareService = new MancareService(getContext());


        foodRecyclerView = view.findViewById(R.id.fragment_nutrition_list);
        foodRecyclerView.setHasFixedSize(true);
        foodRecyclerLayout = new LinearLayoutManager(getContext());
        foodRecyclerAdapter = new AdapterRecyclerFood(listaMancare, getContext());


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
//        adapterFood = new AdapterFood(getContext().getApplicationContext(), R.layout.adapter_food_view, listaMancare, layoutInflater);
//        nutritionListView.setAdapter(adapterFood);
        foodRecyclerView.setLayoutManager(foodRecyclerLayout);
        foodRecyclerView.setAdapter(foodRecyclerAdapter);
    }

    void initPreferences(SharedPreferences preferinte){
        preferinte_varsta = preferinte.getInt(preferedAge, -1);
        preferinte_inaltime = preferinte.getInt(preferedHeight, -1);
        preferinte_greutate = preferinte.getInt(preferedWeight, -1);
        preferinte_gen = preferinte.getString(preferedGender, "");
        preferinte_sport = preferinte.getString(preferedSport, "");
        preferinte_obiectiv = preferinte.getString(preferedGoal, "");
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

        nutritionKcal.setText("You need " + form.format(metabolicRate) +" kilocalories everyday");
        nutritionCarb.setText("You need " + form.format(carbsNeeded) +" grams of carbohydrates everyday");
        nutritionProtein.setText("You need " + form.format(LBM)  +" grams of protein everyday");
    }


}