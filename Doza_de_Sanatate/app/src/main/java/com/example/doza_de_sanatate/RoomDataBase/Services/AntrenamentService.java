package com.example.doza_de_sanatate.RoomDataBase.Services;

import android.content.Context;

import com.example.doza_de_sanatate.RoomDataBase.Classes.Antrenament;
import com.example.doza_de_sanatate.RoomDataBase.Classes.Mancare;
import com.example.doza_de_sanatate.RoomDataBase.Dao.AntrenamentDao;
import com.example.doza_de_sanatate.RoomDataBase.Dao.MancareDao;
import com.example.doza_de_sanatate.RoomDataBase.LocalDataBaseManager;
import com.example.doza_de_sanatate.asyncTask.AsyncTaskRunner;
import com.example.doza_de_sanatate.asyncTask.Callback;

import java.util.List;
import java.util.concurrent.Callable;

public class AntrenamentService {
    private final AntrenamentDao antrenamentDao;
    private final AsyncTaskRunner asyncTaskRunner;

    public AntrenamentService(Context applicationContext) {
        this.antrenamentDao = LocalDataBaseManager.getDataBaseInstance(applicationContext).getAntrenamentDao();
        this.asyncTaskRunner = new AsyncTaskRunner();
    }

    public void getAllMancare(Callback<List<Antrenament>> callback){
        Callable<List<Antrenament>> callable = new Callable<List<Antrenament>>() {
            @Override
            public List<Antrenament> call() throws Exception {
                return antrenamentDao.getAllAntrenamente();
            }
        };
        asyncTaskRunner.executeAsync(callable, callback);
    }
}
