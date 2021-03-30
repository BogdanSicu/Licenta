package com.example.doza_de_sanatate.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.doza_de_sanatate.RoomDataBase.Classes.Antrenament;
import com.example.doza_de_sanatate.R;

import java.util.ArrayList;

public class AdapterWorkout extends ArrayAdapter<Antrenament> {

    private Context myContext;
    private int resourceID;
    private LayoutInflater inflater;

    private TextView adapterWorkoutTextView;
    private ImageView adapterWorkoutImageView;
    private RatingBar adapterWorkoutDificultate;
    private ConstraintLayout adapterWorkoutLayout;

    public AdapterWorkout(@NonNull Context context, int resource, @NonNull ArrayList<Antrenament> objects, LayoutInflater inflater) {
        super(context, resource, objects);
        this.myContext = context;
        this.resourceID = resource;
        this.inflater = inflater;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = inflater.inflate(resourceID, parent, false);

        adapterWorkoutImageView = (ImageView) view.findViewById(R.id.adapter_workout_imageview);
        adapterWorkoutTextView = (TextView) view.findViewById(R.id.adapter_workout_textview);
        adapterWorkoutDificultate = (RatingBar) view.findViewById(R.id.adapter_workout_ratingbar);


        if(getItem(position) != null){
            String denumire = getItem(position).getDenumire();
            String poza = getItem(position).getPozaBarbat();
            int dificultate = getItem(position).getDificultate();

            adapterWorkoutTextView.setText(denumire.toString());
            int pozaGasita = myContext.getResources().getIdentifier(poza, "drawable", myContext.getPackageName());
            adapterWorkoutImageView.setImageResource(pozaGasita);
            adapterWorkoutDificultate.setRating(dificultate);
        }
        else{
           adapterWorkoutDificultate.setVisibility(View.INVISIBLE);
           adapterWorkoutImageView.setVisibility(View.INVISIBLE);
           adapterWorkoutTextView.setVisibility(View.INVISIBLE);

           adapterWorkoutLayout =  (ConstraintLayout) view.findViewById(R.id.adapter_workout_layout);
           adapterWorkoutLayout.setMaxHeight(160);
        }

        return view;
    }

}
