package com.example.doza_de_sanatate.Fragments;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.doza_de_sanatate.MainActivity;
import com.example.doza_de_sanatate.Notifications.NotificationWorkout;
import com.example.doza_de_sanatate.Preferences.Preferinte;
import com.example.doza_de_sanatate.R;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Calendar;

public class Settings_Fragment extends Fragment {

    private TextInputEditText settings_weight;
    private TextInputEditText settings_height;
    private RadioGroup settings_workout;
    private RadioGroup settings_objective;
    private RadioGroup settings_exercises;
    private Switch settings_hide_avigation_bar;
    private RadioGroup settings_alarm;
    private RadioButton settings_alarm_button;


    //    fisier preferinte
    private SharedPreferences preferinte;
    private SharedPreferences.Editor editor;
    private Preferinte instancePreferinte = Preferinte.getInstance();


    private int preferinte_inaltime;
    private int preferinte_greutate;
    private String preferinte_sport;
    private String preferinte_obiectiv;
    private int preferinte_navigation_bar;
    private String preferinte_exercitii;
    private int preferinte_ora;
    private int preferinte_minut;
    private int preferinte_alarma;

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

    private void initComponents(View view){
        settings_weight = view.findViewById(R.id.fragment_settings_weight_input);
        settings_height = view.findViewById(R.id.fragment_settings_height_input);
        settings_workout= view.findViewById(R.id.fragment_settings_radio_group_days_of_workout);
        settings_objective = view.findViewById(R.id.fragment_settings_objective_radio_group);
        settings_exercises = view.findViewById(R.id.fragment_settings_gender_exercises);
        settings_hide_avigation_bar = view.findViewById(R.id.fragment_settings_nagivation_bar_switch);
        settings_alarm = view.findViewById(R.id.fragment_settings_alarm_radio);
        settings_alarm_button = view.findViewById(R.id.fragment_settings_alarm_enable);
    }

    @SuppressLint("CommitPrefEdits")
    private void initPreferences(){
         preferinte = getContext().getSharedPreferences(instancePreferinte.getaSmallPriceToPayForSalvation(), Context.MODE_PRIVATE);
         editor = preferinte.edit();

        preferinte_inaltime = preferinte.getInt(instancePreferinte.getPreferedHeight(), -1);
        preferinte_greutate = preferinte.getInt(instancePreferinte.getPreferedWeight(), -1);
        preferinte_sport = preferinte.getString(instancePreferinte.getPreferedSport(), "");
        preferinte_obiectiv = preferinte.getString(instancePreferinte.getPreferedGoal(), "");
        preferinte_navigation_bar = preferinte.getInt(instancePreferinte.getPreferedNavigationBar(), 1);
        preferinte_exercitii = preferinte.getString(instancePreferinte.getPreferedExercises(), "");

        preferinte_ora =  preferinte.getInt(instancePreferinte.getPreferedHour(), -1);
        preferinte_minut =  preferinte.getInt(instancePreferinte.getPreferedMinute(), -1);
        preferinte_alarma =  preferinte.getInt(instancePreferinte.getPreferedAlarm(), -1);
    }

    @SuppressLint("SetTextI18n")
    private void initSettings(){
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

        if(preferinte_alarma == 1){
            settings_alarm.check(R.id.fragment_settings_alarm_enable);
        }else if(preferinte_alarma == 0){
            settings_alarm.check(R.id.fragment_settings_alarm_disable);
        }

        if(preferinte_ora == -1){
            settings_alarm_button.setText("You did never set your workout alarm");
        }else{

            Intent intent = new Intent(getContext(), NotificationWorkout.class);
            intent.putExtra("notificationID", 1);
            PendingIntent alarmIntent = PendingIntent.getBroadcast(getContext(),
                    0, intent, PendingIntent.FLAG_CANCEL_CURRENT);
            AlarmManager alarmManager = (AlarmManager) getContext().getSystemService(Context.ALARM_SERVICE);

            Calendar startTime = Calendar.getInstance();
            startTime.set(Calendar.HOUR_OF_DAY, preferinte_ora);
            startTime.set(Calendar.MINUTE, preferinte_minut);
            startTime.set(Calendar.SECOND, 0);

            long alarmStartTime = startTime.getTimeInMillis();

            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
                    alarmStartTime, AlarmManager.INTERVAL_DAY,alarmIntent);

            if(preferinte_minut<10){
                settings_alarm_button.setText("Workout alarm set at " + Integer.toString(preferinte_ora) + ":" + "0" + Integer.toString(preferinte_minut));
            }else{
                settings_alarm_button.setText("Workout alarm set at " + Integer.toString(preferinte_ora) + ":" + Integer.toString(preferinte_minut));
            }
        }


    }

    private void initFunctions(){

        settings_weight.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                try{
                    if(settings_weight.toString().equals("")){
                        Toast.makeText(getContext(), "The weight must be a number", Toast.LENGTH_SHORT).show();
                    }
                    preferinte_greutate = Integer.parseInt(String.valueOf(settings_weight.getText()));

                    editor.putInt(instancePreferinte.getPreferedWeight(), preferinte_greutate);

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

                    editor.putInt(instancePreferinte.getPreferedHeight(), preferinte_inaltime);

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

                editor.putString(instancePreferinte.getPreferedSport(), preferinte_sport);
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

                editor.putString(instancePreferinte.getPreferedGoal(), preferinte_obiectiv);
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

                editor.putString(instancePreferinte.getPreferedExercises(), preferinte_exercitii);
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
                editor.putInt(instancePreferinte.getPreferedNavigationBar(), preferinte_navigation_bar);
                editor.apply();

                Toast.makeText(getContext(), "Saved Changes", Toast.LENGTH_SHORT).show();

                Intent main = new Intent(getContext(), MainActivity.class);
                main.putExtra("setari?", 1);
                startActivity(main);
                getActivity().finish();
            }
        });


        settings_alarm.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                Intent intent = new Intent(getContext(), NotificationWorkout.class);
                intent.putExtra("notificationID", 1);
                PendingIntent alarmIntent = PendingIntent.getBroadcast(getContext(),
                        0, intent, PendingIntent.FLAG_CANCEL_CURRENT);
                AlarmManager alarmManager = (AlarmManager) getContext().getSystemService(Context.ALARM_SERVICE);

                if(checkedId == R.id.fragment_settings_alarm_enable){

                    TimePickerDialog timePickerDialog =  new TimePickerDialog(getContext(),
                            new TimePickerDialog.OnTimeSetListener() {
                                @SuppressLint("SetTextI18n")
                                @Override
                                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                    preferinte_ora = hourOfDay;
                                    preferinte_minut = minute;

                                    Calendar startTime = Calendar.getInstance();
                                    startTime.set(Calendar.HOUR_OF_DAY, preferinte_ora);
                                    startTime.set(Calendar.MINUTE, preferinte_minut);
                                    startTime.set(Calendar.SECOND, 0);

                                    long alarmStartTime = startTime.getTimeInMillis();

                                    alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
                                            alarmStartTime, AlarmManager.INTERVAL_DAY,alarmIntent);

                                    preferinte_alarma = 1;

                                    editor.putInt(instancePreferinte.getPreferedAlarm(), preferinte_alarma);
                                    editor.putInt(instancePreferinte.getPreferedHour(), preferinte_ora);
                                    editor.putInt(instancePreferinte.getPreferedMinute(), preferinte_minut);
                                    editor.apply();

                                    if(preferinte_minut<10){
                                        settings_alarm_button.setText("Workout alarm set at " + Integer.toString(preferinte_ora) + ":" + "0" + Integer.toString(preferinte_minut));
                                    }else{
                                        settings_alarm_button.setText("Workout alarm set at " + Integer.toString(preferinte_ora) + ":" + Integer.toString(preferinte_minut));
                                    }

                                    Toast.makeText(getContext(), "Saved Changes", Toast.LENGTH_SHORT).show();

                                }
                            },12,0,false);

                    timePickerDialog.updateTime(preferinte_ora, preferinte_minut);
                    timePickerDialog.show();

                }else if(checkedId == R.id.fragment_settings_alarm_disable){
                    alarmManager.cancel(alarmIntent);
                    preferinte_alarma = 0;
                    editor.putInt(instancePreferinte.getPreferedAlarm(), preferinte_alarma);
                    editor.apply();
                    Toast.makeText(getContext(), "Saved Changes", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void closeKeyboards(){
        settings_weight.onEditorAction(EditorInfo.IME_ACTION_DONE);
        settings_height.onEditorAction(EditorInfo.IME_ACTION_DONE);
    }

}