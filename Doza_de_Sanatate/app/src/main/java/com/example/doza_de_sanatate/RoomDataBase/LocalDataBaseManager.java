package com.example.doza_de_sanatate.RoomDataBase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.doza_de_sanatate.RoomDataBase.Classes.Mancare;
import com.example.doza_de_sanatate.RoomDataBase.Dao.MancareDao;

@Database(entities = {Mancare.class}, exportSchema = false, version = 1)
public abstract class LocalDataBaseManager extends RoomDatabase {

    private static final String denumireBD = "Fitness at home DB";

    private static LocalDataBaseManager dataBaseManager;

    public static LocalDataBaseManager getDataBaseInstance(Context applicationContext){
        if(dataBaseManager == null){
            synchronized (LocalDataBaseManager.class) {
                if(dataBaseManager == null){
                    dataBaseManager = Room.databaseBuilder(applicationContext, LocalDataBaseManager.class, denumireBD)
                            .fallbackToDestructiveMigration().build();
                }
            }
        }

        return dataBaseManager;
    }

    public abstract MancareDao getMancareDao();
}
