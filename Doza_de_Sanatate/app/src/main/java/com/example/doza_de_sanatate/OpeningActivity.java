package com.example.doza_de_sanatate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.doza_de_sanatate.Preferences.Preferinte;
import com.example.doza_de_sanatate.RoomDataBase.Classes.Mancare;
import com.example.doza_de_sanatate.RoomDataBase.Services.MancareService;
import com.example.doza_de_sanatate.asyncTask.Callback;

import java.util.ArrayList;
import java.util.List;

public class OpeningActivity extends AppCompatActivity {
    private View decorView;

//    componente vizuale
    private EditText input_varsta;
    private EditText input_inaltime;
    private EditText input_greutate;
    private RadioGroup input_genul;
    private RadioGroup input_sport_saptamana;
    private RadioGroup input_obiectiv;
    private Button button_salveaza;


//    fisier preferinte
    private Preferinte instancePreferinte = Preferinte.getInstance();

    private int preferinte_varsta;
    private int preferinte_inaltime;
    private int preferinte_greutate;
    private String preferinte_gen;
    private String preferinte_sport;
    private String preferinte_obiectiv;
    private String preferinte_exercitii;

//  initializare baza de date
    private MancareService mancareService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opening);

        SharedPreferences preferinte = getSharedPreferences(instancePreferinte.getaSmallPriceToPayForSalvation(), MODE_PRIVATE);
        initPreferences(preferinte);

        mancareService = new MancareService(getApplicationContext());
        mancareService.getAllMancare(getAllMancareCallBack());

        //pentru a scoate action bar
        decorView = getWindow().getDecorView();
        decorView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener(){
            @Override
            public void onSystemUiVisibilityChange(int visibility) {
                if(visibility == 0)
                    decorView.setSystemUiVisibility(hideSystemBars());
            }
        });

        initComponents();
        closeKeyboardsOnRadioButtons();

        button_salveaza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkInput()){
                    writePreferences(preferinte);
                    Intent main = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(main);
                    finish();
                }

//                Intent main = new Intent(getApplicationContext(), MainActivity.class);
//                startActivity(main);
//                finish();
            }
        });

    }

    void initComponents(){
        input_varsta = findViewById(R.id.input_varsta);
        input_inaltime = findViewById(R.id.input_inaltime);
        input_greutate = findViewById(R.id.input_greutate);
        input_genul = findViewById(R.id.sex_radio_group);
        input_sport_saptamana = findViewById(R.id.sport_radio_group);
        input_obiectiv = findViewById(R.id.obiectiv_radio_group);
        button_salveaza = findViewById(R.id.button_chestionar_save);
    }

    void initPreferences(SharedPreferences preferinte){
        preferinte_varsta = preferinte.getInt(instancePreferinte.getPreferedAge(), -1);
        preferinte_inaltime = preferinte.getInt(instancePreferinte.getPreferedHeight(), -1);
        preferinte_greutate = preferinte.getInt(instancePreferinte.getPreferedWeight(), -1);
        preferinte_gen = preferinte.getString(instancePreferinte.getPreferedGender(), "");
        preferinte_sport = preferinte.getString(instancePreferinte.getPreferedSport(), "");
        preferinte_obiectiv = preferinte.getString(instancePreferinte.getPreferedGoal(), "");
        preferinte_exercitii = preferinte.getString(instancePreferinte.getPreferedExercises(), "");

        if(preferinte_varsta != -1 && preferinte_inaltime != -1
                && preferinte_greutate!=-1 && !(preferinte_gen.equals(""))
                    && !(preferinte_sport.equals("")) && !(preferinte_obiectiv.equals(""))
                        && !(preferinte_exercitii.equals(""))) {

            Intent main = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(main);
            finish();
        }
    }

    boolean checkInput(){
        int varsta;
        int inaltime;
        int greutate;
        String gen;
        String sport;
        String obiectiv;
        String exercitii;

        try{
            if(input_varsta.toString().equals("")){
                Toast.makeText(getApplicationContext(), "The age must be a number" + input_varsta.toString(), Toast.LENGTH_SHORT).show();
                return false;
            }
            varsta = Integer.parseInt(String.valueOf(input_varsta.getText()));
        }catch (Exception e){
            Toast.makeText(getApplicationContext(), "The age must be a number" , Toast.LENGTH_SHORT).show();
            return false;
        }

        try{
            if(input_inaltime.toString().equals("")){
                Toast.makeText(getApplicationContext(), "The height must be a number", Toast.LENGTH_SHORT).show();
                return false;
            }
            inaltime = Integer.parseInt(String.valueOf(input_inaltime.getText()));
        }catch (Exception e){
            Toast.makeText(getApplicationContext(), "The height must be a number", Toast.LENGTH_SHORT).show();
            return false;
        }

        try{
            if(input_greutate.toString().equals("")){
                Toast.makeText(getApplicationContext(), "The weight must be a number", Toast.LENGTH_SHORT).show();
                return false;
            }
            greutate = Integer.parseInt(String.valueOf(input_greutate.getText()));
        }catch (Exception e){
            Toast.makeText(getApplicationContext(), "The weight must be a number", Toast.LENGTH_SHORT).show();
            return false;
        }

        int idGenul = input_genul.getCheckedRadioButtonId();
        if(idGenul == -1){
            Toast.makeText(getApplicationContext(), "Select your gender", Toast.LENGTH_SHORT).show();
            return false;
        }else {
            if(idGenul == R.id.sex_radio_barbat){
                gen = "Barbat";
                exercitii = "Barbat";
            }else{
                gen = "Femeie";
                exercitii = "Femeie";
            }
        }

        int idSport = input_sport_saptamana.getCheckedRadioButtonId();
        if(idSport == -1){
            Toast.makeText(getApplicationContext(), "Select how many days you workout every week", Toast.LENGTH_SHORT).show();
            return false;
        }else{
            if(idGenul == R.id.sport_rar_radio){
                sport = "rar";
            }else if (idSport == R.id.sport_moderat_radio){
                sport = "moderat";
            }else{
                sport = "des";
            }
        }

        int idObiectiv = input_obiectiv.getCheckedRadioButtonId();
        if(idObiectiv == -1){
            Toast.makeText(getApplicationContext(), "Select your objective", Toast.LENGTH_SHORT).show();
            return false;
        }else{
            if(idObiectiv == R.id.obiectiv_slabire){
                obiectiv = "slabire";
            }else if(idObiectiv == R.id.obiectiv_mentinere){
                obiectiv = "mentinere";
            }else{
                obiectiv = "musculatura";
            }
        }

        preferinte_varsta = varsta;
        preferinte_inaltime = inaltime;
        preferinte_greutate = greutate;
        preferinte_gen = gen;
        preferinte_sport = sport;
        preferinte_obiectiv = obiectiv;
        preferinte_exercitii = exercitii;

        return true;
    }

    void writePreferences(SharedPreferences preferinte){
        SharedPreferences.Editor editor = preferinte.edit();

        editor.putInt(instancePreferinte.getPreferedAge(), preferinte_varsta);
        editor.putInt(instancePreferinte.getPreferedHeight(), preferinte_inaltime);
        editor.putInt(instancePreferinte.getPreferedWeight(), preferinte_greutate);
        editor.putString(instancePreferinte.getPreferedGender(), preferinte_gen);
        editor.putString(instancePreferinte.getPreferedSport(), preferinte_sport);
        editor.putString(instancePreferinte.getPreferedGoal(), preferinte_obiectiv);
        editor.putString(instancePreferinte.getPreferedExercises(), preferinte_exercitii);

        //aplicam schimbarile
        editor.apply();
    }

    //pentru a scoate action bar
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if(hasFocus){
            decorView.setSystemUiVisibility(hideSystemBars());
        }
    }
    //pentru a scoate action bar
    private int hideSystemBars() {
        return View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
    }

    void closeKeyboardsOnRadioButtons(){
        input_genul.setOnCheckedChangeListener((group, checkedId) -> closeKeyboards());
        input_obiectiv.setOnCheckedChangeListener((group, checkedId) -> closeKeyboards());
        input_sport_saptamana.setOnCheckedChangeListener((group, checkedId) -> closeKeyboards());
    }

    void closeKeyboards(){
        input_varsta.onEditorAction(EditorInfo.IME_ACTION_DONE);
        input_greutate.onEditorAction(EditorInfo.IME_ACTION_DONE);
        input_inaltime.onEditorAction(EditorInfo.IME_ACTION_DONE);
    }


    private Callback<List<Mancare>> getAllMancareCallBack(){
        return new Callback<List<Mancare>>() {
            @Override
            public void runResultOnUiThread(List<Mancare> result) {
                if(result != null){

                }
            }
        };
    }

}