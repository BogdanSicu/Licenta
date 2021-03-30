package com.example.doza_de_sanatate.RoomDataBase.Services;

import android.content.Context;

import com.example.doza_de_sanatate.RoomDataBase.Classes.AntrenamentCuExercitii;
import com.example.doza_de_sanatate.RoomDataBase.Dao.AntrenamentExercitiuCrossRefDao;
import com.example.doza_de_sanatate.RoomDataBase.LocalDataBaseManager;
import com.example.doza_de_sanatate.asyncTask.AsyncTaskRunner;
import com.example.doza_de_sanatate.asyncTask.Callback;

import java.util.List;
import java.util.concurrent.Callable;

public class AntrenamenteCuExercitiiService {
    private final AntrenamentExercitiuCrossRefDao antrenamentExercitiuCrossRefDao;
    private final AsyncTaskRunner asyncTaskRunner;

    public AntrenamenteCuExercitiiService(Context applicationContext) {
        this.antrenamentExercitiuCrossRefDao = LocalDataBaseManager.getDataBaseInstance(applicationContext).getAntrenamentExercitiuCorssRefDao();
        this.asyncTaskRunner = new AsyncTaskRunner();
    }

    public void getAllAntrenamenteCuExercitii(Callback<List<AntrenamentCuExercitii>> callback){
        Callable<List<AntrenamentCuExercitii>> callable = new Callable<List<AntrenamentCuExercitii>>() {
            @Override
            public List<AntrenamentCuExercitii> call() throws Exception {
                return antrenamentExercitiuCrossRefDao.getAllAntrenamenteCuExercitii();
            }
        };
        asyncTaskRunner.executeAsync(callable, callback);
    }
}

