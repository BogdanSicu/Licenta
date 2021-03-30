package com.example.doza_de_sanatate.RoomDataBase.Dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.doza_de_sanatate.RoomDataBase.Classes.Antrenament;
import com.example.doza_de_sanatate.RoomDataBase.Classes.Exercitiu;

import java.util.List;

@Dao
public interface ExercitiuDao {
    @Query("SELECT * FROM exercitiu")
    List<Exercitiu> getAllExercitii();

    @Insert
    void insertAllExercitii(Exercitiu[] exercitii);
}
