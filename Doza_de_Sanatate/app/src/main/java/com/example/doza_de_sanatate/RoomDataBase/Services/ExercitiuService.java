package com.example.doza_de_sanatate.RoomDataBase.Services;

import android.content.Context;

import com.example.doza_de_sanatate.RoomDataBase.Classes.Exercitiu;
import com.example.doza_de_sanatate.RoomDataBase.Classes.Mancare;
import com.example.doza_de_sanatate.RoomDataBase.Dao.ExercitiuDao;
import com.example.doza_de_sanatate.RoomDataBase.Dao.MancareDao;
import com.example.doza_de_sanatate.RoomDataBase.LocalDataBaseManager;
import com.example.doza_de_sanatate.asyncTask.AsyncTaskRunner;
import com.example.doza_de_sanatate.asyncTask.Callback;

import java.util.List;
import java.util.concurrent.Callable;

public class ExercitiuService {
    private final ExercitiuDao exercitiuDao;
    private final AsyncTaskRunner asyncTaskRunner;

    public ExercitiuService(Context applicationContext) {
        this.exercitiuDao = LocalDataBaseManager.getDataBaseInstance(applicationContext).getExercitiuDao();
        this.asyncTaskRunner = new AsyncTaskRunner();
    }

    public void getAllExercitii(Callback<List<Exercitiu>> callback){
        Callable<List<Exercitiu>> callable = new Callable<List<Exercitiu>>() {
            @Override
            public List<Exercitiu> call() throws Exception {
                return exercitiuDao.getAllExercitii();
            }
        };
        asyncTaskRunner.executeAsync(callable, callback);
    }
}
