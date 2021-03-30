package com.example.doza_de_sanatate.asyncTask;

import android.os.Handler;
import android.os.Looper;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class AppExecutor {
    private static final Object LOCK = new Object();
    private static AppExecutor instace;
    private final Executor diskIO;
    private final Executor mainThread;
    private final Executor networkIO;

    private AppExecutor(Executor diskIO, Executor mainThread, Executor networkIO) {
        this.diskIO = diskIO;
        this.mainThread = mainThread;
        this.networkIO = networkIO;
    }

    public static AppExecutor getInstance(){
        if(instace == null){
            synchronized (LOCK){
                instace = new AppExecutor(Executors.newSingleThreadExecutor(),
                        Executors.newFixedThreadPool(4),
                        new MainThreadExecutor());
            }
        }
        return instace;
    }

    public Executor getDiskIO() {
        return diskIO;
    }

    public Executor getMainThread() {
        return mainThread;
    }

    public Executor getNetworkIO() {
        return networkIO;
    }

    private static class MainThreadExecutor implements Executor{
        private Handler mainTheadHandler = new Handler(Looper.getMainLooper());

        @Override
        public void execute(Runnable command) {
            mainTheadHandler.post(command);
        }
    }
}
