package com.example.doza_de_sanatate.Fragments;

import android.Manifest;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.doza_de_sanatate.Adapters.AdapterFood;
import com.example.doza_de_sanatate.Adapters.AdapterWorkout;
import com.example.doza_de_sanatate.Classes.Mancare;
import com.example.doza_de_sanatate.R;

import java.util.ArrayList;
import java.util.List;

public class Nutrition_Fragment extends Fragment {

    private ArrayList<Mancare> listaMancare = new ArrayList<>();

    private TextView nutritionKcal;
    private TextView nutritionCarb;
    private TextView nutritionProtein;
    private ListView nutritionListView;

    private AdapterFood adapterFood;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_nutrition_, container, false);

        initComponents(view);

        Mancare mancare1 = new Mancare("banana", "test_food_apple", 100, 40, 50);
        Mancare mancare2 = new Mancare("banana", "test_food_img", 100, 40, 50);
        listaMancare.add(mancare1);
        listaMancare.add(mancare2);
        listaMancare.add(mancare1);
        listaMancare.add(mancare2);
        listaMancare.add(mancare1);

        Mancare yes = null;
        listaMancare.add(yes);

        adapterFood = new AdapterFood(getContext().getApplicationContext(), R.layout.adapter_food_view, listaMancare, inflater);
        nutritionListView.setAdapter(adapterFood);

        return view;
    }

    void initComponents(View view){
        nutritionKcal = view.findViewById(R.id.fragment_nutrition_kcal);
        nutritionCarb = view.findViewById(R.id.fragment_nutrition_carb);
        nutritionProtein = view.findViewById(R.id.fragment_nutrition_protein);
        nutritionListView = view.findViewById(R.id.fragment_nutrition_list);
    }
}