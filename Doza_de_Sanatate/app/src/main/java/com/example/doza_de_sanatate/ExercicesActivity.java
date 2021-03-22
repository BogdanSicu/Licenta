package com.example.doza_de_sanatate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.example.doza_de_sanatate.Adapters.AdapterExercice;
import com.example.doza_de_sanatate.Adapters.AdapterWorkout;
import com.example.doza_de_sanatate.Classes.Antrenament;

public class ExercicesActivity extends AppCompatActivity {

    private TextView seriesPerExerciceOutput;
    private TextView repsPerSeriesOutput;
    private TextView totalExercicesOutput;
    private ListView listViewExercices;
    private AdapterExercice adapterExercice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercices);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        Antrenament antrenament = (Antrenament) bundle.getSerializable("listaExercitiiAntrenament");

        initComponents();
        setTextInformation(antrenament);

        adapterExercice = new AdapterExercice(this, R.layout.adapter_exercice_view, antrenament.getListaExercitii(), this.getLayoutInflater());
        listViewExercices.setAdapter(adapterExercice);

    }

    void initComponents(){
        seriesPerExerciceOutput = findViewById(R.id.exercices_series);
        repsPerSeriesOutput = findViewById(R.id.exercices_reps);
        totalExercicesOutput = findViewById(R.id.exercices_total);
        listViewExercices = findViewById(R.id.exercices_list);
    }


    void setTextInformation(Antrenament antrenament){
        seriesPerExerciceOutput.append(" "+String.valueOf(antrenament.getSerii()));
        repsPerSeriesOutput.append(" "+String.valueOf(antrenament.getRepetari()));
        totalExercicesOutput.append(" "+String.valueOf(antrenament.getSerii() * antrenament.getRepetari()));
    }
}