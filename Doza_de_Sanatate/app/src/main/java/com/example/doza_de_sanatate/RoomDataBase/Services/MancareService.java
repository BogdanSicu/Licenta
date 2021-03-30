package com.example.doza_de_sanatate.RoomDataBase.Services;

import android.content.Context;

import com.example.doza_de_sanatate.RoomDataBase.Classes.Mancare;
import com.example.doza_de_sanatate.RoomDataBase.Dao.MancareDao;
import com.example.doza_de_sanatate.RoomDataBase.LocalDataBaseManager;
import com.example.doza_de_sanatate.asyncTask.AsyncTaskRunner;
import com.example.doza_de_sanatate.asyncTask.Callback;

import java.util.List;
import java.util.concurrent.Callable;

public class MancareService {

    private final MancareDao mancareDao;
    private final AsyncTaskRunner asyncTaskRunner;

    public MancareService(Context applicationContext) {
        this.mancareDao = LocalDataBaseManager.getDataBaseInstance(applicationContext).getMancareDao();
        this.asyncTaskRunner = new AsyncTaskRunner();
    }

    public void getAllMancare(Callback<List<Mancare>> callback){
        Callable<List<Mancare>> callable = new Callable<List<Mancare>>() {
            @Override
            public List<Mancare> call() throws Exception {
                return mancareDao.getAllMancare();
            }
        };
        asyncTaskRunner.executeAsync(callable, callback);
    }

}
