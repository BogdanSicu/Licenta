package com.example.doza_de_sanatate.RoomDataBase.Dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.doza_de_sanatate.RoomDataBase.Classes.AntrenamentExercitiuCrossRef;
import com.example.doza_de_sanatate.RoomDataBase.Classes.AntrenamentCuExercitii;

import java.util.List;

@Dao
public interface AntrenamentExercitiuCrossRefDao {
    @Insert
    void insertAllAntremanenteCuExercitii(AntrenamentExercitiuCrossRef[] antrenamentExercitiuCrossRefs);

    @Query("SELECT * FROM antrenament")
    List<AntrenamentCuExercitii> getAllAntrenamenteCuExercitii();
}
