package com.example.doza_de_sanatate.RoomDataBase.PrePopulare;

import androidx.annotation.NonNull;

import com.example.doza_de_sanatate.RoomDataBase.Classes.Antrenament;
import com.example.doza_de_sanatate.RoomDataBase.Classes.Mancare;

public class ListaAntrenamente {
    public static Antrenament[] populatieAntrenamenteData(){
        return new Antrenament[]{
//                Barbat --------------------------------------------------------------

//                Arms
                new Antrenament("Arms at Home", 2, "arms", "acasa", "Barbat", "img_adapter_antrenament_arms_at_home_man"),
                new Antrenament("Arms Day", 2, "arms", "gym", "Barbat", "img_adapter_antrenament_arms_man"),
                new Antrenament("Strong Arms", 3, "arms", "gym", "Barbat", "img_adapter_antrenament_strong_arms_man"),

//                Chest
                new Antrenament("Chest at Home", 2, "chest", "acasa", "Barbat", "img_adapter_antrenament_chest_at_home_man"),
                new Antrenament("Chest Day", 2, "chest", "gym", "Barbat", "img_adapter_antrenament_chest_and_abs_man"),
                new Antrenament("Strong Chest", 3, "chest", "gym", "Barbat", "img_adapter_antrenament_strong_chest_man"),

//                Back
                new Antrenament("Back Day", 2, "back", "gym", "Barbat", "img_adapter_antrenament_back_and_biceps_man"),
                new Antrenament("Strong Back",3, "back","gym","Barbat", "img_adapter_antrenament_strong_back_man"),

//                Legs
                new Antrenament("Legs Day", 2, "legs", "gym", "Barbat", "img_adapter_antrenament_legs_and_abs_man"),
                new Antrenament("Legs at Home", 1, "legs", "acasa", "Barbat", "img_adapter_antrenament_legs_at_home_man"),
                new Antrenament("Strong Legs", 3, "legs", "gym", "Barbat", "img_adapter_antrenament_strong_legs_man"),

//                Full Body
                new Antrenament("Full Body at Home", 1, "full body", "acasa", "Barbat", "img_adapter_antrenament_full_body_home_man"),
                new Antrenament("Full Body", 1, "full body", "gym", "Barbat", "img_adapter_antrenament_full_body_gym_man"),

//                Femeie --------------------------------------------------------------

//                Legs
                new Antrenament("Fit Legs", 2, "legs", "acasa", "Femeie", "img_adapter_antrenament_legs_at_home_woman"),
                new Antrenament("Legs Workout", 2, "legs", "gym", "Femeie", "img_adapter_antrenament_legs_and_abs_woman"),

//                Chest
                new Antrenament("Fit Chest", 3, "legs", "acasa", "Femeie", "img_adapter_antrenament_chest_at_home_woman"),
                new Antrenament("Chest Workout", 3, "legs", "gym", "Femeie", "img_adapter_antrenament_strong_chest_woman"),

//                Back
                new Antrenament("Fit Back Muscles", 2, "legs", "acasa", "Femeie", "img_adapter_antrenament_back_and_biceps_woman"),
                new Antrenament("Back Workout", 2, "legs", "gym", "Femeie", "img_adapter_antrenament_strong_back_woman"),

//                Arms
                new Antrenament("Fit Arms", 3, "legs", "acasa", "Femeie", "img_adapter_antrenament_arms_at_home_woman"),
                new Antrenament("Arms Workout", 3, "legs", "gym", "Femeie", "img_adapter_antrenament_arms_woman"),

//                Full Body
                new Antrenament("Fit Body", 1, "legs", "acasa", "Femeie", "img_adapter_antrenament_full_body_home_woman"),
                new Antrenament("Body Workout", 1, "legs", "gym", "Femeie", "img_adapter_antrenament_full_body_gym_woman"),
        };
    }
}
