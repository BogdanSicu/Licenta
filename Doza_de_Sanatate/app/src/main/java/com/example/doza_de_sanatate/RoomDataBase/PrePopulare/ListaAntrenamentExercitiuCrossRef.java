package com.example.doza_de_sanatate.RoomDataBase.PrePopulare;

import com.example.doza_de_sanatate.RoomDataBase.Classes.Antrenament;
import com.example.doza_de_sanatate.RoomDataBase.Classes.AntrenamentExercitiuCrossRef;

public class ListaAntrenamentExercitiuCrossRef {
    public static AntrenamentExercitiuCrossRef[] populatieAntrenamentExercitiuCrossRefData(){
        return new AntrenamentExercitiuCrossRef[]{
                 new AntrenamentExercitiuCrossRef("Strong Legs1","flotari1" ),
                 new AntrenamentExercitiuCrossRef("Strong Legs1","flotari2" ),
                 new AntrenamentExercitiuCrossRef("Strong Legs1","flotari3" ),
                 new AntrenamentExercitiuCrossRef("Strong Legs2","flotari1" )
        };
    }
}
