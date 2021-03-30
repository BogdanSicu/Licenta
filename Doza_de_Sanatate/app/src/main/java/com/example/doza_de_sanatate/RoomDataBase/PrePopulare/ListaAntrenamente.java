package com.example.doza_de_sanatate.RoomDataBase.PrePopulare;

import androidx.annotation.NonNull;

import com.example.doza_de_sanatate.RoomDataBase.Classes.Antrenament;
import com.example.doza_de_sanatate.RoomDataBase.Classes.Mancare;

public class ListaAntrenamente {
    public static Antrenament[] populatieAntrenamenteData(){
        return new Antrenament[]{
                new Antrenament("Strong Legs1", 2, "picioare", "acasa", "workout_man_legs", "workout_man_legs"),
                new Antrenament("Strong Legs2", 2, "picioare", "acasa", "workout_man_legs", "workout_man_legs"),
                new Antrenament("Strong Legs3", 2, "picioare", "acasa", "workout_man_legs", "workout_man_legs"),
                new Antrenament("Strong Legs4", 2, "picioare", "acasa", "workout_man_legs", "workout_man_legs"),
        };
    }
}
