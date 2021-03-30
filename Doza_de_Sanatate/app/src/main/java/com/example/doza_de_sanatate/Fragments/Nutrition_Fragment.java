package com.example.doza_de_sanatate.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.doza_de_sanatate.Adapters.AdapterFood;
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
    private ListView nutritionListView;

    private AdapterFood adapterFood;

    private MancareService mancareService;
    private LayoutInflater layoutInflater;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_nutrition_, container, false);
        layoutInflater = inflater;

        initComponents(view);
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
}