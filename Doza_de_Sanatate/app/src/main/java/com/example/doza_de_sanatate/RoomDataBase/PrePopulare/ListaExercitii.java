package com.example.doza_de_sanatate.RoomDataBase.PrePopulare;

import com.example.doza_de_sanatate.RoomDataBase.Classes.Exercitiu;

public class ListaExercitii {
    public static Exercitiu[] populatieExercitiiData(){
        return new Exercitiu[]{
//                legs
                new Exercitiu("Dumbbell Lunges", "picioare", "",  "", "img_adapter_exercise_dumbbell_lunges_female","img_adapter_exercise_legs_dumbbell_lunges"),
                new Exercitiu("Leg Extensions", "picioare", "","","img_adapter_exercise_legs_extensions_female","img_adapter_exercise_legs_extensions"),
                new Exercitiu("Goblet Squat", "picioare", "","","img_adapter_exercise_legs_goblin_squat_female","img_adapter_exercise_legs_goblet_squat"),
                new Exercitiu("Leg Curl", "picioare", "","","img_adapter_exercise_legs_curl_female","img_adapter_exercise_legs_hamstring_curl"),
                new Exercitiu("Kettlebell Pistol Squat", "picioare", "","","img_adapter_exercise_kettlebbell_pistol_squat_female","img_adapter_exercise_legs_kettlebell_pistol_squat"),
                new Exercitiu("Legs Press", "picioare", "","","img_adapter_exercise_legs_press_female","img_adapter_exercise_legs_press"),
                new Exercitiu("Squats", "picioare", "","","img_adapter_exercise_legs_squat_female","img_adapter_exercise_legs_squat"),
                new Exercitiu("Bulgarian Split Squat", "picioare", "", "", "img_adapter_exercise_legs_bulgarian_split_squat_female", ""),
                new Exercitiu("Dumbbell Deadlift", "picioare", "", "", "img_adapter_exercise_legs_dumbbell_deadlift_female", ""),
                new Exercitiu("Adduction Inner Thigh", "picioare", "", "", "img_adapter_exercise_legs_adduction_inner_thigh_female", ""),

//                chest
                new Exercitiu("Bench Press", "chest", "","","","img_adapter_exercise_chest_bench_press"),
                new Exercitiu("Bench Press Inclined", "chest", "","","","img_adapter_exercise_chest_bench_press_inclined"),
                new Exercitiu("Dumbbell Bench Press", "chest", "","","img_adapter_exercise_chest_dumbbell_bench_press_female","img_adapter_exercise_chest_dumbbell_bench_press"),
                new Exercitiu("Dumbbell Bench Press Declined", "chest", "","","","img_adapter_exercise_chest_dumbbell_bench_press_declined"),
                new Exercitiu("Dumbbell Bench Press Inclined", "chest", "","","img_adapter_exercise_chest_dumbbell_bench_press_inclined_female","img_adapter_exercise_chest_dumbbell_bench_press_inclined"),
                new Exercitiu("Dumbbell Fly Inclined", "chest", "","","img_adapter_exercise_chest_dumbbell_fly_inclined_female","img_adapter_exercise_chest_dumbbell_fly_inclined"),
                new Exercitiu("Dumbbell Fly", "chest", "","","img_adapter_exercise_chest_dumbbell_fly_female","img_adapter_exercise_chest_dumbbell_fly"),
                new Exercitiu("Close Grip Push-Up", "chest", "","","","img_adapter_exercise_chest_close_grip_push_up"),
                new Exercitiu("Declined Push-Up", "chest", "","","img_adapter_exercise_chest_decline_push_up_female","img_adapter_exercise_chest_declined_push_up"),
                new Exercitiu("Push-Up", "chest", "","","img_adapter_exercise_chest_push_up_female","img_adapter_exercise_chest_push_up"),
                new Exercitiu("Butterfly", "chest", "", "", "img_adapter_exercise_chest_butterfly_female", ""),
                new Exercitiu("Diamond Push-Up", "chest", "" ,"", "img_adapter_exercise_chest_diamond_push_up_female", ""),
                new Exercitiu("Knee Push-Up", "chest", "", "", "img_adapter_exercise_chest_knee_push_up_female", ""),
                new Exercitiu("Hammer Strength Machine - Chest Press", "chest", "", "", "img_adapter_exercise_chest_hammer_strength_female", ""),

//                back
                new Exercitiu("Bent Over Dumbbell Row", "back", "","","img_adapter_exercise_back_one_arm_dumbbell_row_female","img_adapter_exercise_back_bent_over_dumbbell_row"),
                new Exercitiu("Lat Pull Down", "back", "","","img_adapter_exercise_back_wide_grip_lat_pull_down_female","img_adapter_exercise_back_lat_pull_down"),
                new Exercitiu("Lat Pull Up", "back", "","","","img_adapter_exercise_back_lat_pull_up"),
                new Exercitiu("Seated Row", "back", "","","img_adapter_exercise_back_low_cable_back_female","img_adapter_exercise_back_seated_row"),
                new Exercitiu("T-Bar Row", "back", "","","img_adapter_exercise_back_t_bar_row_female","img_adapter_exercise_back_t_bar_row"),
                new Exercitiu("Underhand Lat Pull Down", "back", "","","","img_adapter_exercise_back_underhand_lat_pull_down"),
                new Exercitiu("Hyperextension", "back", "","","img_adapter_exercise_back_extensions_female","img_adapter_exercise_back_hyperextension"),
                new Exercitiu("Dumbbell Incline Bench Row", "bacl", "", "", "img_adapter_exercise_back_dumbbell_incline_bench_row_female", ""),
                new Exercitiu("Reverse Fly", "back", "", "", "img_adapter_exercise_back_reverse_fly_female", ""),
                new Exercitiu("Bent Over Barbell Row", "back", "", "", "img_adapter_exercise_back_bent_over_barbell_row_female", ""),


//                arms
                new Exercitiu("Barbell Triceps Extension", "arms", "","","","img_adapter_exercise_arms_barbell_triceps_extension"),
                new Exercitiu("Dumbbell Biceps Curl", "arms", "","","img_adapter_exercise_arms_adumbbell_curl_female","img_adapter_exercise_arms_dumbbell_biceps_curl"),
                new Exercitiu("Dumbbell Lateral Raise", "arms", "","","img_adapter_exercise_arms_dumbbell_lateral_raise_female","img_adapter_exercise_arms_dumbbell_lateral_raise"),
                new Exercitiu("Dumbbell Overhead Press", "arms", "","","img_adapter_exercise_arms_overhead_shoulder_press_female","img_adapter_exercise_arms_dumbbell_overhead_press"),
                new Exercitiu("Palm Up Barbell Wrist Curl", "arms", "","","","img_adapter_exercise_arms_palm_up_barbell_wrist_curl"),
                new Exercitiu("Prone Dumbbell Spider Curl", "arms", "","","","img_adapter_exercise_arms_prone_dumbbell_spider_curl"),
                new Exercitiu("Reverse Curls Bar", "arms", "","","","img_adapter_exercise_arms_reverse_curls_bar"),
                new Exercitiu("Triceps Dip", "arms", "","","","img_adapter_exercise_arms_triceps_dip"),
                new Exercitiu("Barbell Biceps Curl", "arms", "", "", "img_adapter_exercise_arms_barbell_biceps_curl_female", ""),
                new Exercitiu("Dumbbell Front Raise", "arms", "", "","img_adapter_exercise_arms_dumbbell_front_raise_female", ""),
                new Exercitiu("Dumbbell Kickback", "arms", "", "", "img_adapter_exercise_arms_dumbbell_kickback_female", ""),
                new Exercitiu("Lying Dumbbell Triceps Extension", "arms", "", "", "img_adapter_exercise_arms_lying_dumbbell_triceps_extension_female", ""),
                new Exercitiu("Upright Dumbbell Row", "arms", "", "", "img_adapter_exercise_arms_upright_dumbbell_row_female", ""),
                new Exercitiu("Alternating Incline Bench Dumbbell Curls", "arms", "", "", "img_adapter_exercise_arms_alternating_incline_bench_dumbbell_curls_female", ""),
                new Exercitiu("One Arm Dumbbell Preacher Curl", "arms", "", "", "img_adapter_exercise_arms_one_arm_dumbbell_preacher_curl_female", ""),
                new Exercitiu("Seated Triceps Press", "arms", "", "", "img_adapter_exercise_arms_seated_triceps_press_female", ""),
                new Exercitiu("Hammer Curl","arms", "", "", "img_adapter_exercise_arms_hammer_curl_female", ""),

//                abs
                new Exercitiu("Jackknife Crunch", "abs", "","","","img_adapter_exercise_abs_bench_jackknife_crunches"),
                new Exercitiu("Declined Crunch", "abs", "","","","img_adapter_exercise_abs_declined_crunch"),
                new Exercitiu("Reverse Crunch", "abs", "","","img_adapter_exercise_abs_reverse_crunch_female","img_adapter_exercise_abs_reverse_crunch"),
                new Exercitiu("Sit Up", "abs", "","","img_adapter_exercise_abs_sit_up_female","img_adapter_exercise_abs_sit_up"),
                new Exercitiu("Tuck and Crunch", "abs", "","","","img_adapter_exercise_tuck_and_crunch"),
                new Exercitiu("Lying Leg Lift", "abs", "", "", "img_adapter_exercise_abs_lying_leg_lift_female", ""),
                new Exercitiu("Seated Bench Leg Pull", "abs", "", "", "img_adapter_exercise_abs_seated_bench_leg_pull_in_female", "")
        };
    }
}
