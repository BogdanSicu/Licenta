package com.example.doza_de_sanatate.RoomDataBase;

import android.content.Context;
import android.telecom.Call;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.doza_de_sanatate.RoomDataBase.Classes.Mancare;
import com.example.doza_de_sanatate.RoomDataBase.Dao.MancareDao;
import com.example.doza_de_sanatate.RoomDataBase.PrePopulare.ListaMancare;
import com.example.doza_de_sanatate.asyncTask.AppExecutor;

import java.util.concurrent.Executor;

@Database(entities = {Mancare.class}, exportSchema = false, version = 1)
public abstract class LocalDataBaseManager extends RoomDatabase {

    private static final String denumireBD = "Fitness at home DB";

    private static LocalDataBaseManager dataBaseManager;

    public static LocalDataBaseManager getDataBaseInstance(Context applicationContext){
        if(dataBaseManager == null){
            synchronized (LocalDataBaseManager.class) {
                if(dataBaseManager == null){
                    dataBaseManager = Room.databaseBuilder(applicationContext, LocalDataBaseManager.class, denumireBD)
                            .addCallback(new Callback() {
                                @Override
                                public void onCreate(@NonNull SupportSQLiteDatabase db) {
                                    super.onCreate(db);
                                    AppExecutor.getInstance().getDiskIO()
                                            .execute(new Runnable() {
                                                @Override
                                                public void run() {
                                                    getDataBaseInstance(applicationContext)
                                                            .getMancareDao()
                                                            .insertAllMancare(ListaMancare.populateMancareData());
                                                }
                                            });
                                }
                            }).build();
                }
            }
        }

        return dataBaseManager;
    }

    public abstract MancareDao getMancareDao();
}
