package com.example.doza_de_sanatate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.doza_de_sanatate.Adapters.AdapterExercice;
import com.example.doza_de_sanatate.RoomDataBase.Classes.Antrenament;
import com.example.doza_de_sanatate.RoomDataBase.Classes.Exercitiu;

import java.util.List;

public class ExercicesActivity extends AppCompatActivity {
    private View decorView;

    private TextView seriesPerExerciceOutput;
    private TextView repsPerSeriesOutput;
    private TextView totalExercicesOutput;
    private ListView listViewExercices;
    private AdapterExercice adapterExercice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercices);

        //pentru a scoate action bar
        decorView = getWindow().getDecorView();
        decorView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener(){
            @Override
            public void onSystemUiVisibilityChange(int visibility) {
                if(visibility == 0)
                    decorView.setSystemUiVisibility(hideSystemBars());
            }
        });


        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        List<Exercitiu> listaExercitii = (List<Exercitiu>) bundle.getSerializable("listaExercitiiAntrenament");

        initComponents();
        setTextInformation();

        adapterExercice = new AdapterExercice(this, R.layout.adapter_exercice_view, listaExercitii, this.getLayoutInflater());
        listViewExercices.setAdapter(adapterExercice);

    }

    void initComponents(){
        seriesPerExerciceOutput = findViewById(R.id.exercices_series);
        repsPerSeriesOutput = findViewById(R.id.exercices_reps);
        totalExercicesOutput = findViewById(R.id.exercices_total);
        listViewExercices = findViewById(R.id.exercices_list);
    }


    void setTextInformation(){
        seriesPerExerciceOutput.append(" ");
        repsPerSeriesOutput.append(" ");
        totalExercicesOutput.append(" ");
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

}