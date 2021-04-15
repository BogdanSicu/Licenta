package com.example.doza_de_sanatate.RoomDataBase.PrePopulare;

import com.example.doza_de_sanatate.RoomDataBase.Classes.Mancare;

public class ListaMancare {
    public static Mancare[] populateMancareData(){
        return new Mancare[]{

//                meat
                new Mancare("Beef", "picture_adapter_mancare_beef", 217, 0, 26.1),
                new Mancare("Chicken Breast", "picture_adapter_mancare_chicken_breast", 284, 0, 53.4),
                new Mancare("Chicken Wings", "picture_adapter_mancare_chicken_wings", 43, 0, 6.4),
                new Mancare("Chicken Drumstick", "picture_adapter_mancare_chicken_legs", 76, 0, 12.4),
                new Mancare("Turkey Breast", "picture_adapter_mancare_turkey_breast", 177, 0, 23.7),
                new Mancare("Roasted Pork Tenderloin", "picture_adapter_mancare_roasted_pork_tenderloin", 164, 0, 28.1),
                new Mancare("Roasted Pork Neck", "picture_adapter_mancare_roasted_pork_neck", 320, 0.09, 19),

//                fruits
                new Mancare("Apple", "picture_adapter_mancare_apple", 52, 13.8, 0.3),
                new Mancare("Banana", "picture_adapter_mancare_banana", 89, 22.8, 1.1),
                new Mancare("Watermelon", "picture_adapter_mancare_water_melon", 30, 7.6, 0.6),
                new Mancare("Strawberries", "picture_adapter_mancare_strawberry", 32, 7.7, 0.7),
                new Mancare("Blueberries", "picture_adapter_mancare_blueberry", 57, 14.5, 0.7),
                new Mancare("Damson Plum", "picture_adapter_mancare_damson_plum", 76, 18, 1),
                new Mancare("Kiwi", "picture_adapter_mancare_kiwi", 42, 10.1, 0.8),
                new Mancare("Orange", "picture_adapter_mancare_orange", 47, 12, 0.9),
                new Mancare("Grapes", "picture_adapter_mancare_grapes", 69, 18, 0.72),

//                vegetables
                new Mancare("Potatoes", "picture_adapter_mancare_potato", 93, 20.1, 1.9),
                new Mancare("Carrot", "picture_adapter_mancare_carrot", 41, 9.6, 0.9),
                new Mancare("Pepper", "picture_adapter_mancare_pepper", 31, 6, 1),
                new Mancare("Tomato", "picture_adapter_mancare_tomato", 16, 3.5, 0.8),
                new Mancare("Cucumber", "picture_adapter_mancare_cucumber", 8,1.9,0.3),
                new Mancare("Lettuce", "picture_adapter_mancare_lettuce", 8, 1.5, 0.6),
                new Mancare("Onion", "picture_adapter_mancare_onion", 40, 9.3, 1.1),
                new Mancare("Chickpeas", "picture_adapter_mancare_chickpeas", 364, 61, 19),

//                other
                new Mancare("Boiled Egg", "picture_adapter_mancare_boiled_eggs", 155, 1.1, 13),
                new Mancare("Stuffed Cabbage", "picture_adapter_mancare_cabbage", 289, 14.3, 11.5),
                new Mancare("Cheese", "picture_adapter_mancare_cheese", 402, 1.3, 25),
                new Mancare("Multigrain Bread", "picture_adapter_mancare_multigrain_bread", 265, 43, 13),
                new Mancare("Pilau Rice", "picture_adapter_mancare_pilau", 359, 76, 10),
                new Mancare("Shawarma", "picture_adapter_mancare_shawarma", 238, 18.9, 8.2)

        };
    }
}
