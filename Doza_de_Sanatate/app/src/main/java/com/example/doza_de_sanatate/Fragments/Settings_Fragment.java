package com.example.doza_de_sanatate.Fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.doza_de_sanatate.MainActivity;
import com.example.doza_de_sanatate.RoomDataBase.Classes.Antrenament;
import com.example.doza_de_sanatate.RoomDataBase.Classes.Exercitiu;
import com.example.doza_de_sanatate.R;
import com.google.android.material.textfield.TextInputEditText;

public class Settings_Fragment extends Fragment {

    private TextInputEditText settings_weight;
    private TextInputEditText settings_height;
    private RadioGroup settings_workout;
    private RadioGroup settings_objective;
    private RadioGroup settings_exercises;
    private Switch settings_hide_avigation_bar;

    //    fisier preferinte
    private SharedPreferences preferinte;
    private SharedPreferences.Editor editor;

    private static final String aSmallPriceToPayForSalvation = "doza_de_sanatate_preferinte";
    private static final String preferedHeight = "doza_de_sanatate_inaltime";
    private static final String preferedWeight = "doza_de_sanatate_greutate";
    private static final String preferedSport = "doza_de_sanatate_sport";
    private static final String preferedGoal = "doza_de_sanatate_obiectiv";
    private static final String preferedNavigationBar = "doza_de_sanatate_navigation_bar";
    private static final String preferedExercises = "doza_de_sanatate_exercitii";

    private int preferinte_inaltime;
    private int preferinte_greutate;
    private String preferinte_sport;
    private String preferinte_obiectiv;
    private int preferinte_navigation_bar;
    private String preferinte_exercitii;

    @Override
    public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container,
                            @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings_, container, false);

        initComponents(view);
        initPreferences();
        initSettings();
        initFunctions();

        return view;
    }

    void initComponents(View view){
        settings_weight = view.findViewById(R.id.fragment_settings_weight_input);
        settings_height = view.findViewById(R.id.fragment_settings_height_input);
        settings_workout= view.findViewById(R.id.fragment_settings_radio_group_days_of_workout);
        settings_objective = view.findViewById(R.id.fragment_settings_objective_radio_group);
        settings_exercises = view.findViewById(R.id.fragment_settings_gender_exercises);
        settings_hide_avigation_bar = view.findViewById(R.id.fragment_settings_nagivation_bar_switch);
    }

    @SuppressLint("CommitPrefEdits")
    void initPreferences(){
         preferinte = getContext().getSharedPreferences(aSmallPriceToPayForSalvation, Context.MODE_PRIVATE);
         editor = preferinte.edit();

        preferinte_inaltime = preferinte.getInt(preferedHeight, -1);
        preferinte_greutate = preferinte.getInt(preferedWeight, -1);
        preferinte_sport = preferinte.getString(preferedSport, "");
        preferinte_obiectiv = preferinte.getString(preferedGoal, "");
        preferinte_navigation_bar = preferinte.getInt(preferedNavigationBar, 1);
        preferinte_exercitii = preferinte.getString(preferedExercises, "");

    }

    @SuppressLint("SetTextI18n")
    void initSettings(){
        settings_weight.setText(Integer.toString(preferinte_greutate));
        settings_height.setText(Integer.toString(preferinte_inaltime));

        switch (preferinte_sport) {
            case "rar":
                settings_workout.check(R.id.fragment_settings_radio_rar);
                break;
            case "moderat":
                settings_workout.check(R.id.fragment_settings_radio_moderat);
                break;
            case "des":
                settings_workout.check(R.id.fragment_settings_radio_des);
                break;
        }

        switch (preferinte_obiectiv) {
            case "slabire":
                settings_objective.check(R.id.fragment_settings_objective_slabire);
                break;
            case "mentinere":
                settings_objective.check(R.id.fragment_settings_objective_balance);
                break;
            case "musculatura":
                settings_objective.check(R.id.fragment_settings_objective_muscle);
                break;
        }

        switch (preferinte_exercitii) {
            case "Femeie":
                settings_exercises.check(R.id.fragment_settings_female);
                break;
            case "Barbat":
                settings_exercises.check(R.id.fragment_settings_male);
                break;
            case "Both":
                settings_exercises.check(R.id.fragment_settings_both);
                break;
        }

        if(preferinte_navigation_bar == 1){
            settings_hide_avigation_bar.setChecked(true);
        }else if(preferinte_navigation_bar == 0){
            settings_hide_avigation_bar.setChecked(false);
        }

    }

    void initFunctions(){

        settings_weight.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                try{
                    if(settings_weight.toString().equals("")){
                        Toast.makeText(getContext(), "The weight must be a number", Toast.LENGTH_SHORT).show();
                    }
                    preferinte_greutate = Integer.parseInt(String.valueOf(settings_weight.getText()));

                    editor.putInt(preferedWeight, preferinte_greutate);

                    editor.apply();
                    if(!hasFocus){
                        Toast.makeText(getContext(), "Saved Changes", Toast.LENGTH_SHORT).show();
                    }

                }catch (Exception e){
                    Toast.makeText(getContext(), "The weight must be a number", Toast.LENGTH_SHORT).show();
                }
            }
        });

        settings_height.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                try{
                    if(settings_height.toString().equals("")){
                        Toast.makeText(getContext(), "The height must be a number", Toast.LENGTH_SHORT).show();
                    }
                    preferinte_inaltime = Integer.parseInt(String.valueOf(settings_height.getText()));

                    editor.putInt(preferedHeight, preferinte_inaltime);

                    editor.apply();

                    if(!hasFocus){
                        Toast.makeText(getContext(), "Saved Changes", Toast.LENGTH_SHORT).show();
                    }

                }catch (Exception e){
                    Toast.makeText(getContext(), "The height must be a number", Toast.LENGTH_SHORT).show();
                }
            }
        });

        settings_workout.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                closeKeyboards();

                if(checkedId == R.id.fragment_settings_radio_rar){
                    preferinte_sport = "rar";
                }else if(checkedId == R.id.fragment_settings_radio_moderat){
                    preferinte_sport = "moderat";
                }else if(checkedId == R.id.fragment_settings_radio_des){
                    preferinte_sport = "des";
                }

                editor.putString(preferedSport, preferinte_sport);
                editor.apply();

                Toast.makeText(getContext(), "Saved Changes", Toast.LENGTH_SHORT).show();
            }
        });

        settings_objective.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                closeKeyboards();

                if(checkedId == R.id.fragment_settings_objective_slabire){
                    preferinte_obiectiv = "slabire";
                }else if(checkedId == R.id.fragment_settings_objective_balance){
                    preferinte_obiectiv = "mentinere";
                }else if(checkedId == R.id.fragment_settings_objective_muscle){
                    preferinte_obiectiv = "musculatura";
                }

                editor.putString(preferedGoal, preferinte_obiectiv);
                editor.apply();

                Toast.makeText(getContext(), "Saved Changes", Toast.LENGTH_SHORT).show();
            }
        });

        settings_exercises.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                closeKeyboards();

                if(checkedId == R.id.fragment_settings_female){
                    preferinte_exercitii = "Femeie";
                }else if(checkedId == R.id.fragment_settings_male){
                    preferinte_exercitii = "Barbat";
                }else if (checkedId == R.id.fragment_settings_both){
                    preferinte_exercitii = "Both";
                }

                editor.putString(preferedExercises, preferinte_exercitii);
                editor.apply();

                Toast.makeText(getContext(), "Saved Changes", Toast.LENGTH_SHORT).show();
            }
        });

        settings_hide_avigation_bar.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                closeKeyboards();
                if(isChecked){
                    preferinte_navigation_bar = 1;
                }else {
                    preferinte_navigation_bar = 0;
                }
                editor.putInt(preferedNavigationBar, preferinte_navigation_bar);
                editor.apply();

                Toast.makeText(getContext(), "Saved Changes", Toast.LENGTH_SHORT).show();

                Intent main = new Intent(getContext(), MainActivity.class);
                main.putExtra("setari?", 1);
                startActivity(main);
                getActivity().finish();
            }
        });

    }

    void closeKeyboards(){
        settings_weight.onEditorAction(EditorInfo.IME_ACTION_DONE);
        settings_height.onEditorAction(EditorInfo.IME_ACTION_DONE);
    }

}