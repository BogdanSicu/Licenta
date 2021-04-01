package com.example.doza_de_sanatate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.doza_de_sanatate.Fragments.Nutrition_Fragment;
import com.example.doza_de_sanatate.Fragments.Settings_Fragment;
import com.example.doza_de_sanatate.Fragments.Workout_Fragment;
import com.example.doza_de_sanatate.RoomDataBase.Classes.Mancare;
import com.example.doza_de_sanatate.RoomDataBase.Services.MancareService;
import com.example.doza_de_sanatate.asyncTask.Callback;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private View decorView;

    private BottomNavigationView bottomNavigationMenu;
    private Workout_Fragment workout_fragment = new Workout_Fragment();
    private Nutrition_Fragment nutrition_fragment = new Nutrition_Fragment();
    private Settings_Fragment settings_fragment = new Settings_Fragment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //pentru a scoate action bar
        decorView = getWindow().getDecorView();
        decorView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener(){
            @Override
            public void onSystemUiVisibilityChange(int visibility) {
                if(visibility == 0)
                    decorView.setSystemUiVisibility(hideSystemBars());
            }
        });

        initComponents();
        DefaultFragment();

        bottomNavigationMenu.setOnNavigationItemSelectedListener(navigationListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navigationListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @SuppressLint("NonConstantResourceId")
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                     Fragment selectedFragment = null;

                    switch(item.getItemId()){
                        case R.id.fragment_workout_menu:
                            selectedFragment = workout_fragment;
                            break;
                        case R.id.menu_nutrition:
                            selectedFragment = nutrition_fragment;
                            break;
                        case R.id.menu_settings:
                            selectedFragment = settings_fragment;
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.main_frame_container,
                            selectedFragment).commit();

                    return true;
                }
            };

    void DefaultFragment(){
        Fragment selectedFragment = new Workout_Fragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame_container,
                selectedFragment).commit();
    }

    void initComponents(){
        bottomNavigationMenu = findViewById(R.id.main_bottom_navigation);
    }

    //pentru a scoate action bar
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if(hasFocus){
            decorView.setSystemUiVisibility(hideSystemBars());
        }
    }
    //pentru a scoate action bar
    private int hideSystemBars() {
        return View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
    }

    @Override
    public void onBackPressed() {
        if(bottomNavigationMenu.getSelectedItemId() == R.id.menu_nutrition || bottomNavigationMenu.getSelectedItemId() == R.id.menu_settings){
            bottomNavigationMenu.setSelectedItemId(R.id.fragment_workout_menu);
            getSupportFragmentManager().beginTransaction().replace(R.id.main_frame_container, workout_fragment).commit();
        }else{
            super.onBackPressed();
        }
    }
}