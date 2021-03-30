package com.example.doza_de_sanatate.asyncTask;

public interface Callback<R> {

    void runResultOnUiThread(R result);
}
