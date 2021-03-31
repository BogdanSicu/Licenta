package com.example.doza_de_sanatate.RoomDataBase.PrePopulare;

import androidx.annotation.NonNull;

import com.example.doza_de_sanatate.RoomDataBase.Classes.Antrenament;
import com.example.doza_de_sanatate.RoomDataBase.Classes.Mancare;

public class ListaAntrenamente {
    public static Antrenament[] populatieAntrenamenteData(){
        return new Antrenament[]{
//                Arms
                new Antrenament("Arms at Home", 2, "arms", "acasa", "img_adapter_antrenament_arms_at_home_woman", "img_adapter_antrenament_arms_at_home_man"),
                new Antrenament("Arms Day", 2, "arms", "gym", "img_adapter_antrenament_arms_woman", "img_adapter_antrenament_arms_man"),
                new Antrenament("Strong Arms", 3, "arms", "gym", "img_adapter_antrenament_strong_arms_woman", "img_adapter_antrenament_strong_arms_man"),

//                Back
                new Antrenament("Back Day", 2, "back", "gym", "img_adapter_antrenament_back_and_biceps_woman", "img_adapter_antrenament_back_and_biceps_man"),
                new Antrenament("Strong Back",3, "back","acasa","img_adapter_antrenament_strong_back_woman", "img_adapter_antrenament_strong_back_man"),

//                Chest
                new Antrenament("Chest at Home", 2, "chest", "acasa", "img_adapter_antrenament_chest_at_home_woman", "img_adapter_antrenament_chest_at_home_man"),
                new Antrenament("Chest and abs", 2, "chest", "gym", "img_adapter_antrenament_chest_and_abs_woman", "img_adapter_antrenament_chest_and_abs_man"),
                new Antrenament("Strong Chest", 3, "chest", "gym", "img_adapter_antrenament_strong_chest_woman", "img_adapter_antrenament_strong_chest_man"),

//                Legs
                new Antrenament("Legs and Abs", 2, "legs", "gym", "img_adapter_antrenament_legs_and_abs_woman", "img_adapter_antrenament_legs_and_abs_man"),
                new Antrenament("Legs at Home", 1, "legs", "acasa", "img_adapter_antrenament_legs_at_home_woman", "img_adapter_antrenament_legs_at_home_man"),
                new Antrenament("Strong Legs", 3, "legs", "gym", "img_adapter_antrenament_strong_legs_woman", "img_adapter_antrenament_strong_legs_man"),

//                Full Body
                new Antrenament("Full Body at Home", 1, "full body", "acasa", "img_adapter_antrenament_full_body_home_woman", "img_adapter_antrenament_full_body_home_man"),
                new Antrenament("Full Body", 1, "full body", "gym", "img_adapter_antrenament_full_body_gym_woman", "img_adapter_antrenament_full_body_gym_man")
        };
    }
}
