package com.example.doza_de_sanatate;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RadioGroup;

import com.example.doza_de_sanatate.Adapters.AdapterWorkout;
import com.example.doza_de_sanatate.Classes.Antrenament;
import com.example.doza_de_sanatate.Classes.Exercitiu;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;


public class Workout_Fragment extends Fragment {
    private ArrayList<Antrenament> listaAntrenamente = new ArrayList<>();
    private ArrayList<Antrenament> listaAntrenamenteAcasa = new ArrayList<>();
    private ArrayList<Antrenament> listaAntrenamenteSala = new ArrayList<>();

    private ListView workout_list;
    private AdapterWorkout adapterWorkout;
    private TabLayout workout_menu;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_workout_, container, false);

        initList();
        initComponents(view);

        adapterWorkout = new AdapterWorkout(getContext().getApplicationContext(), R.layout.adapter_workout_view, listaAntrenamenteSala, inflater);
        workout_list.setAdapter(adapterWorkout);

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



        return view;
    }

    void initList(){
        Exercitiu piept = new Exercitiu("piept", "push", "acasa", null, null);
        Exercitiu spate = new Exercitiu("spate", "push", "acasa", null, null);
        Exercitiu picioare = new Exercitiu("picioare", "push", "acasa", null, null);

        ArrayList<Exercitiu> listaExercitii = new ArrayList<>();
        listaExercitii.add(piept);
        listaExercitii.add(spate);
        listaExercitii.add(picioare);

        Antrenament antrenament1 = new Antrenament("Strong Chest",1, "piept", listaExercitii, 10, 5 , "acasa", "", "workout_man_chest");
        Antrenament antrenament2 = new Antrenament("Strong Legs",1, "picioare", listaExercitii, 10, 5 , "sala", "", "workout_man_legs");
        Antrenament antrenament3 = new Antrenament("Strong Legs",1, "picioare", listaExercitii, 10, 5 , "acasa", "", "workout_man_legs");
        Antrenament yes = null;
        listaAntrenamente.add(antrenament1);
        listaAntrenamente.add(antrenament1);
        listaAntrenamente.add(antrenament2);
        listaAntrenamente.add(antrenament2);
        listaAntrenamente.add(antrenament2);
        listaAntrenamente.add(antrenament1);
        listaAntrenamente.add(antrenament3);
        listaAntrenamente.add(antrenament3);
        listaAntrenamente.add(antrenament1);


        for (Antrenament antrenament: listaAntrenamente) {
            if(antrenament.getLocatie().equals("acasa")){
                listaAntrenamenteAcasa.add(antrenament);
            }else{
                listaAntrenamenteSala.add(antrenament);
            }
        }
        listaAntrenamenteSala.add(yes);
        listaAntrenamenteAcasa.add(yes);



    }

    void initComponents(View view){
        workout_list = view.findViewById(R.id.workout_list_fragment);
        workout_menu = view.findViewById(R.id.fragment_workout_menu);
    }

}