package com.example.doza_de_sanatate.RoomDataBase.Classes;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import java.io.Serializable;
import java.util.List;

public class AntrenamentCuExercitii implements Serializable {
    @Embedded
    public Antrenament antrenament;
    @Relation(
            parentColumn = "denumireAntrenamentID",
            entityColumn = "denumireExercitiuID",
            associateBy = @Junction(AntrenamentExercitiuCrossRef.class)
    )
    public List<Exercitiu> exercitii;
}
