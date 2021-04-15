package com.example.doza_de_sanatate.Dialogs;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.example.doza_de_sanatate.R;
import com.example.doza_de_sanatate.RoomDataBase.Classes.Exercitiu;

import java.util.Objects;

public class DialogWorkout extends AppCompatDialogFragment {

    private Exercitiu exercitiu = null;
    private String gen;
    private ImageView imageView;

    public DialogWorkout(Exercitiu exercitiu, String genul) {
        this.exercitiu = exercitiu;
        this.gen= genul;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        @SuppressLint("InflateParams") View view = inflater.inflate(R.layout.dialog_workout, null);

        this.imageView = view.findViewById(R.id.dialog_image_view);
        int pozaGasita = 0;

        if(this.gen.equals("Barbat")){
            pozaGasita = requireContext().getResources().getIdentifier(this.exercitiu.getPozeBarbat(), "drawable", requireContext().getPackageName());
        }else if(this.gen.equals("Femeie")){
            view.setBackgroundColor(Color.WHITE);
            pozaGasita = requireContext().getResources().getIdentifier(this.exercitiu.getPozeFemeie(), "drawable", requireContext().getPackageName());
        }

        this.imageView.setImageResource(pozaGasita);

        builder.setView(view)
                .setNegativeButton("back", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });


        return builder.create();

    }
}
