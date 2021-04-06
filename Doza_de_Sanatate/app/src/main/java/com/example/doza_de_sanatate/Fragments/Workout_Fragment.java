package com.example.doza_de_sanatate.Fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.doza_de_sanatate.Adapters.AdapterWorkout;
import com.example.doza_de_sanatate.RoomDataBase.Classes.AntrenamentCuExercitii;
import com.example.doza_de_sanatate.ExercicesActivity;
import com.example.doza_de_sanatate.R;
import com.example.doza_de_sanatate.RoomDataBase.Classes.Exercitiu;
import com.example.doza_de_sanatate.RoomDataBase.Services.AntrenamenteCuExercitiiService;
import com.example.doza_de_sanatate.asyncTask.Callback;
import com.google.android.material.tabs.TabLayout;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Workout_Fragment extends Fragment {
    private ArrayList<AntrenamentCuExercitii> listaAntrenamente = new ArrayList<>();
    private ArrayList<AntrenamentCuExercitii> listaAntrenamenteAcasa = new ArrayList<>();
    private ArrayList<AntrenamentCuExercitii> listaAntrenamenteSala = new ArrayList<>();

    private ListView workout_list;
    private AdapterWorkout adapterWorkout;
    private TabLayout workout_menu;

    private AntrenamenteCuExercitiiService antrenamenteCuExercitiiService;
    private LayoutInflater layoutInflater;

//    fisier preferinte
    private SharedPreferences preferinte;
    private SharedPreferences.Editor editor;

    private static final String aSmallPriceToPayForSalvation = "doza_de_sanatate_preferinte";
    private static final String preferedExercises = "doza_de_sanatate_exercitii";

    private String preferinte_exercitii;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_workout_, container, false);
        layoutInflater = inflater;

        initComponents(view);
        antrenamenteCuExercitiiService.getAllAntrenamenteCuExercitii(getAllAntrenamenteCuExercitiiCallBack());


        workout_menu.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if(workout_menu.getTabAt(0).isSelected()){
                    adapterWorkout = new AdapterWorkout(getContext().getApplicationContext(), R.layout.adapter_workout_view, listaAntrenamenteSala, inflater);
                    workout_list.setAdapter(adapterWorkout);
                }else{
                    adapterWorkout = new AdapterWorkout(getContext().getApplicationContext(), R.layout.adapter_workout_view, listaAntrenamenteAcasa, inflater);
                    workout_list.setAdapter(adapterWorkout);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        workout_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent inentExercitii = new Intent(getContext(), ExercicesActivity.class);
                Bundle bundle = new Bundle();
                List<Exercitiu> listaExercitii = new ArrayList<>();

                if(workout_menu.getTabAt(0).isSelected()){
                    if(listaAntrenamenteSala.get(position) == null) {
                        return;
                    }

                    listaExercitii.addAll(listaAntrenamenteSala.get(position).exercitii);
                    bundle.putSerializable("listaExercitiiAntrenament", (Serializable) listaExercitii);
                    bundle.putString("antrenament_gen", listaAntrenamenteSala.get(position).antrenament.getGen());

                }else{
                    if(listaAntrenamenteAcasa.get(position) == null) {
                        return;
                    }

                    listaExercitii.addAll(listaAntrenamenteAcasa.get(position).exercitii);
                    bundle.putSerializable("listaExercitiiAntrenament", (Serializable) listaExercitii);
                    bundle.putString("antrenament_gen", listaAntrenamenteAcasa.get(position).antrenament.getGen());
                }

                inentExercitii.putExtras(bundle);
                startActivity(inentExercitii);
            }
        });

        return view;
    }



    void initComponents(View view){
        workout_list = view.findViewById(R.id.workout_list_fragment);
        workout_menu = view.findViewById(R.id.fragment_workout_menu);
        antrenamenteCuExercitiiService = new AntrenamenteCuExercitiiService(getContext());

        preferinte = getContext().getSharedPreferences(aSmallPriceToPayForSalvation, Context.MODE_PRIVATE);
        editor = preferinte.edit();
        preferinte_exercitii = preferinte.getString(preferedExercises, "");
    }

    private Callback<List<AntrenamentCuExercitii>> getAllAntrenamenteCuExercitiiCallBack(){
        return new Callback<List<AntrenamentCuExercitii>>() {
            @Override
            public void runResultOnUiThread(List<AntrenamentCuExercitii> result) {
                if(result != null){
                    listaAntrenamente.clear();
                    listaAntrenamenteAcasa.clear();
                    listaAntrenamenteSala.clear();
                    listaAntrenamente.addAll(result);



                    for (AntrenamentCuExercitii element: listaAntrenamente) {
                        if(preferinte_exercitii.equals("Barbat") || preferinte_exercitii.equals("Femeie")){
                            if(element.antrenament.getGen().equals(preferinte_exercitii)){
                                if(element.antrenament.getLocatie().equals("acasa")){
                                    listaAntrenamenteAcasa.add(element);
                                }
                                else{
                                    listaAntrenamenteSala.add(element);
                                }
                            }
                        }
                        else{
                            if(element.antrenament.getLocatie().equals("acasa")){
                                listaAntrenamenteAcasa.add(element);
                            }
                            else{
                                listaAntrenamenteSala.add(element);
                            }
                        }

                    }
                    listaAntrenamenteAcasa.add(null);
                    listaAntrenamenteSala.add(null);
                    resetAdapterMancare();
                }
            }
        };
    }

    private void resetAdapterMancare(){
        adapterWorkout = new AdapterWorkout(getContext().getApplicationContext(), R.layout.adapter_workout_view, listaAntrenamenteSala, layoutInflater);
        workout_list.setAdapter(adapterWorkout);
    }

}