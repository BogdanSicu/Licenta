package com.example.doza_de_sanatate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.doza_de_sanatate.Adapters.AdapterExercise;
import com.example.doza_de_sanatate.Dialogs.DialogWorkout;
import com.example.doza_de_sanatate.Preferences.Preferinte;
import com.example.doza_de_sanatate.RoomDataBase.Classes.Exercitiu;

import java.util.List;

public class ExercicesActivity extends AppCompatActivity {
    private View decorView;

    private TextView youShouldTXT;
    private TextView seriesPerExerciceOutput;
    private TextView repsPerSeriesOutput;
    private TextView totalExercicesOutput;
    private ListView listViewExercices;
    private AdapterExercise adapterExercise;
    private ConstraintLayout exerciseLayout;

    //    preferinte
    private Preferinte instancePreferinte = Preferinte.getInstance();

    private int preferinte_navigation_bar;
    private String preferinte_obiectiv;
    private String genul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercices);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        List<Exercitiu> listaExercitii = (List<Exercitiu>) bundle.getSerializable("listaExercitiiAntrenament");
        listaExercitii.add(null);
        genul = (String) bundle.getString("antrenament_gen");

        initComponents();

        SharedPreferences preferinte = getSharedPreferences(instancePreferinte.getaSmallPriceToPayForSalvation(), MODE_PRIVATE);
        preferinte_navigation_bar = preferinte.getInt(instancePreferinte.getPreferedNavigationBar(), 1);
        setTextInformation(preferinte);

        if(preferinte_navigation_bar == 1){
            //pentru a scoate action bar
            decorView = getWindow().getDecorView();
            decorView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener(){
                @Override
                public void onSystemUiVisibilityChange(int visibility) {
                    if(visibility == 0)
                        decorView.setSystemUiVisibility(hideSystemBars());
                }
            });
        }


        adapterExercise = new AdapterExercise(this, R.layout.adapter_exercice_view, listaExercitii, this.getLayoutInflater(), genul);
        listViewExercices.setAdapter(adapterExercise);

        listViewExercices.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                openDialog(listaExercitii.get(position));
            }
        });

    }

    void initComponents(){
        youShouldTXT = findViewById(R.id.exercices_you_should);
        seriesPerExerciceOutput = findViewById(R.id.exercices_series);
        repsPerSeriesOutput = findViewById(R.id.exercices_reps);
        totalExercicesOutput = findViewById(R.id.exercices_total);
        listViewExercices = findViewById(R.id.exercices_list);
        exerciseLayout = findViewById(R.id.activity_exercise_layout);

        if(genul.equals("Femeie")){
            youShouldTXT.setTextColor(Color.BLACK);
            exerciseLayout.setBackgroundColor(Color.WHITE);
            seriesPerExerciceOutput.setTextColor(Color.BLACK);
            repsPerSeriesOutput.setTextColor(Color.BLACK);
            totalExercicesOutput.setTextColor(Color.BLACK);
        }
    }

    void openDialog(Exercitiu exercitiu){
        DialogWorkout dialogWorkout = new DialogWorkout(exercitiu, genul);
        dialogWorkout.show(getSupportFragmentManager(), "exercise details dialog");
    }

    @SuppressLint("SetTextI18n")
    void setTextInformation(SharedPreferences preferinte){

        preferinte_obiectiv = preferinte.getString(instancePreferinte.getPreferedGoal(), "");

        switch (preferinte_obiectiv) {
            case "slabire":
                seriesPerExerciceOutput.setText("Do 4 series for each exercise");
                repsPerSeriesOutput.setText("Do 15 reps with lower weight for each series");
                totalExercicesOutput.setText("Run for 30 minutes at the end of the workout ");
                break;
            case "mentinere":
                seriesPerExerciceOutput.setText("Do 4 series for each exercise");
                repsPerSeriesOutput.setText("Do 10 reps with moderate weight for each series");
                totalExercicesOutput.setText("Run for 15 minutes at the end of the workout ");
                break;
            case "musculatura":
                seriesPerExerciceOutput.setText("Do 4 series for each exercise");
                repsPerSeriesOutput.setText("Start with 12 reps with lower weight for the 1st series. Lower the number of reps by 2 for each series while increasing the weight");
                totalExercicesOutput.setText("Run for 10 minutes at the end of the workout ");
                break;
        }
    }

    //pentru a scoate action bar
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if(hasFocus && preferinte_navigation_bar == 1){
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

}