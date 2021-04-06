package com.example.doza_de_sanatate.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doza_de_sanatate.R;
import com.example.doza_de_sanatate.RoomDataBase.Classes.Antrenament;
import com.example.doza_de_sanatate.RoomDataBase.Classes.AntrenamentCuExercitii;
import com.example.doza_de_sanatate.RoomDataBase.Services.AntrenamenteCuExercitiiService;

import java.util.ArrayList;
import java.util.List;

public class AdapterRecyclerWorkout extends RecyclerView.Adapter<AdapterRecyclerWorkout.WorkoutHolder> {

    private ArrayList<AntrenamentCuExercitii> workoutList;
    private Context myContext;
    private OnItemClickListener mListener;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }

    public class WorkoutHolder extends RecyclerView.ViewHolder{
        private TextView adapterWorkoutTextView;
        private ImageView adapterWorkoutImageView;
        private RatingBar adapterWorkoutDificultate;
        private ConstraintLayout adapterWorkoutLayout;


        public WorkoutHolder(@NonNull View itemView) {
            super(itemView);
            adapterWorkoutImageView = (ImageView) itemView.findViewById(R.id.adapter_workout_imageview);
            adapterWorkoutTextView = (TextView) itemView.findViewById(R.id.adapter_workout_textview);
            adapterWorkoutDificultate = (RatingBar) itemView.findViewById(R.id.adapter_workout_ratingbar);
            adapterWorkoutLayout =  (ConstraintLayout) itemView.findViewById(R.id.adapter_workout_layout);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mListener != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            mListener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

    public AdapterRecyclerWorkout(ArrayList<AntrenamentCuExercitii> workoutList, Context myContext) {
        this.workoutList = workoutList;
        this.myContext = myContext;
    }

    @NonNull
    @Override
    public WorkoutHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_workout_view, parent, false);
       WorkoutHolder workoutHolder = new WorkoutHolder(view);
        return workoutHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull WorkoutHolder holder, int position) {

        AntrenamentCuExercitii antrenamentItem = workoutList.get(position);

        if(antrenamentItem != null){
            String denumire =antrenamentItem.antrenament.getDenumireAntrenamentID();
            String poza = antrenamentItem.antrenament.getPoza();
            int dificultate = antrenamentItem.antrenament.getDificultate();

            holder.adapterWorkoutTextView.setText(denumire.toString());
            int pozaGasita = myContext.getResources().getIdentifier(poza, "drawable", myContext.getPackageName());
            holder.adapterWorkoutImageView.setImageResource(pozaGasita);
            holder.adapterWorkoutDificultate.setRating(dificultate);
        }
        else{
            holder.adapterWorkoutDificultate.setVisibility(View.INVISIBLE);
            holder.adapterWorkoutImageView.setVisibility(View.INVISIBLE);
            holder.adapterWorkoutTextView.setVisibility(View.INVISIBLE);
            holder.adapterWorkoutLayout.setMaxHeight(160);
        }

    }

    @Override
    public int getItemCount() {
        return workoutList.size();
    }
}
