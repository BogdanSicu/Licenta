package com.example.doza_de_sanatate.RoomDataBase.Dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.doza_de_sanatate.RoomDataBase.Classes.Mancare;

import java.util.List;

@Dao
public interface MancareDao {

    @Query("SELECT * FROM mancare")
    List<Mancare> getAllMancare();

    @Insert
    void insertAllMancare(Mancare[] mancare);
}
