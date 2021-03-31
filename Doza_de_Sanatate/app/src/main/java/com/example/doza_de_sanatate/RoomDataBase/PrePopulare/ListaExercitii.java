package com.example.doza_de_sanatate.RoomDataBase.PrePopulare;

import com.example.doza_de_sanatate.RoomDataBase.Classes.Exercitiu;

public class ListaExercitii {
    public static Exercitiu[] populatieExercitiiData(){
        return new Exercitiu[]{
//                legs
                new Exercitiu("Dumbbell Lunges", "picioare", "", "", "", "", "","img_adapter_exercise_legs_dumbbell_lunges"),
                new Exercitiu("Leg Extension", "picioare", "","","","","","img_adapter_exercise_legs_extensions"),
                new Exercitiu("Goblet Squat", "picioare", "","","","","","img_adapter_exercise_legs_goblet_squat"),
                new Exercitiu("Hamstring Curl", "picioare", "","","","","","img_adapter_exercise_legs_hamstring_curl"),
                new Exercitiu("Kettlebbell Pistol Squat", "picioare", "","","","","","img_adapter_exercise_legs_kettlebell_pistol_squat"),
                new Exercitiu("Legs Press", "picioare", "","","","","","img_adapter_exercise_legs_press"),
                new Exercitiu("Squats", "picioare", "","","","","","img_adapter_exercise_legs_squat"),

//                chest
                new Exercitiu("Bench Press", "chest", "","","","","","img_adapter_exercise_chest_bench_press"),
                new Exercitiu("Bench Press Inclined", "chest", "","","","","","img_adapter_exercise_chest_bench_press_inclined"),
                new Exercitiu("Dumbbell Bench Press", "chest", "","","","","","img_adapter_exercise_chest_dumbbell_bench_press"),
                new Exercitiu("Dumbbell Bench Press Declined", "chest", "","","","","","img_adapter_exercise_chest_dumbbell_bench_press_declined"),
                new Exercitiu("Dumbbell Bench Press Inclined", "chest", "","","","","","img_adapter_exercise_chest_dumbbell_bench_press_inclined"),
                new Exercitiu("Dumbbell Fly Inclined", "chest", "","","","","","img_adapter_exercise_chest_dumbbell_fly_inclined"),
                new Exercitiu("Dumbbell Fly", "chest", "","","","","","img_adapter_exercise_chest_dumbbell_fly"),
                new Exercitiu("Close Grip Push-Up", "chest", "","","","","","img_adapter_exercise_chest_close_grip_push_up"),
                new Exercitiu("Declined Push-Up", "chest", "","","","","","img_adapter_exercise_chest_declined_push_up"),
                new Exercitiu("Push-Up", "chest", "","","","","","img_adapter_exercise_chest_push_up"),

//                back
                new Exercitiu("Bent Over Dumbbell Row", "back", "","","","","","img_adapter_exercise_back_bent_over_dumbbell_row"),
                new Exercitiu("Lat Pull Down", "back", "","","","","","img_adapter_exercise_back_lat_pull_down"),
                new Exercitiu("Lat Pull Up", "back", "","","","","","img_adapter_exercise_back_lat_pull_up"),
                new Exercitiu("Seated Row", "back", "","","","","","img_adapter_exercise_back_seated_row"),
                new Exercitiu("T-Bar Row", "back", "","","","","","img_adapter_exercise_back_t_bar_row"),
                new Exercitiu("Underhand Lat Pull Down", "back", "","","","","","img_adapter_exercise_back_underhand_lat_pull_down"),
                new Exercitiu("Hyperextension", "back", "","","","","","img_adapter_exercise_back_hyperextension"),

//                arms
                new Exercitiu("Barbell Triceps Extension", "arms", "","","","","","img_adapter_exercise_arms_barbell_triceps_extension"),
                new Exercitiu("Dumbbell Biceps Curl", "arms", "","","","","","img_adapter_exercise_arms_dumbbell_biceps_curl"),
                new Exercitiu("Dumbbell Lateral Raise", "arms", "","","","","","img_adapter_exercise_arms_dumbbell_lateral_raise"),
                new Exercitiu("Dumbbell Overhead Press", "arms", "","","","","","img_adapter_exercise_arms_dumbbell_overhead_press"),
                new Exercitiu("Palm Up Barbell Wrist Curl", "arms", "","","","","","img_adapter_exercise_arms_palm_up_barbell_wrist_curl"),
                new Exercitiu("Prone Dumbbell Spider Curl", "arms", "","","","","","img_adapter_exercise_arms_prone_dumbbell_spider_curl"),
                new Exercitiu("Reverse Curls Bar", "arms", "","","","","","img_adapter_exercise_arms_reverse_curls_bar"),
                new Exercitiu("Triceps Dip", "arms", "","","","","","img_adapter_exercise_arms_triceps_dip"),

//                abs
                new Exercitiu("Jackknife Crunch", "abs", "","","","","","img_adapter_exercise_abs_bench_jackknife_crunches"),
                new Exercitiu("Declined Crunch", "abs", "","","","","","img_adapter_exercise_abs_declined_crunch"),
                new Exercitiu("Reverse Crunch", "abs", "","","","","","img_adapter_exercise_abs_reverse_crunch"),
                new Exercitiu("Sit Up", "abs", "","","","","","img_adapter_exercise_abs_sit_up"),
                new Exercitiu("Tuck and Crunch", "abs", "","","","","","img_adapter_exercise_tuck_and_crunch"),
        };
    }
}
