package com.example.doza_de_sanatate.RoomDataBase;

import android.content.Context;
import android.telecom.Call;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.doza_de_sanatate.RoomDataBase.Classes.Antrenament;
import com.example.doza_de_sanatate.RoomDataBase.Classes.AntrenamentExercitiuCrossRef;
import com.example.doza_de_sanatate.RoomDataBase.Classes.Exercitiu;
import com.example.doza_de_sanatate.RoomDataBase.Classes.Mancare;
import com.example.doza_de_sanatate.RoomDataBase.Dao.AntrenamentDao;
import com.example.doza_de_sanatate.RoomDataBase.Dao.AntrenamentExercitiuCrossRefDao;
import com.example.doza_de_sanatate.RoomDataBase.Dao.ExercitiuDao;
import com.example.doza_de_sanatate.RoomDataBase.Dao.MancareDao;
import com.example.doza_de_sanatate.RoomDataBase.PrePopulare.ListaAntrenamentExercitiuCrossRef;
import com.example.doza_de_sanatate.RoomDataBase.PrePopulare.ListaAntrenamente;
import com.example.doza_de_sanatate.RoomDataBase.PrePopulare.ListaExercitii;
import com.example.doza_de_sanatate.RoomDataBase.PrePopulare.ListaMancare;
import com.example.doza_de_sanatate.asyncTask.AppExecutor;

import java.util.concurrent.Executor;

@Database(entities = {Mancare.class, Exercitiu.class, Antrenament.class, AntrenamentExercitiuCrossRef.class},
        exportSchema = false, version = 2)
public abstract class LocalDataBaseManager extends RoomDatabase {

    private static final String denumireBD = "Fitness at home DB";

    private static LocalDataBaseManager dataBaseManager;

    public static LocalDataBaseManager getDataBaseInstance(Context applicationContext){
        if(dataBaseManager == null){
            synchronized (LocalDataBaseManager.class) {
                if(dataBaseManager == null){
                    dataBaseManager = Room.databaseBuilder(applicationContext, LocalDataBaseManager.class, denumireBD)
                            .fallbackToDestructiveMigration()
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

                                                    getDataBaseInstance(applicationContext)
                                                            .getAntrenamentDao()
                                                            .insertAllAntrenamente(ListaAntrenamente.populatieAntrenamenteData());

                                                    getDataBaseInstance(applicationContext)
                                                            .getExercitiuDao()
                                                            .insertAllExercitii(ListaExercitii.populatieExercitiiData());

                                                    getDataBaseInstance(applicationContext)
                                                            .getAntrenamentExercitiuCorssRefDao()
                                                            .insertAllAntremanenteCuExercitii(ListaAntrenamentExercitiuCrossRef.populatieAntrenamentExercitiuCrossRefData());
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
    public abstract AntrenamentDao getAntrenamentDao();
    public abstract ExercitiuDao getExercitiuDao();
    public abstract AntrenamentExercitiuCrossRefDao getAntrenamentExercitiuCorssRefDao();
}
