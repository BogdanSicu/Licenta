package com.example.doza_de_sanatate;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RadioGroup;

import com.example.doza_de_sanatate.Classes.Antrenament;
import com.example.doza_de_sanatate.Classes.Exercitiu;

import java.util.ArrayList;

public class Settings_Fragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container,
                            @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_settings_, container, false);
    }



}