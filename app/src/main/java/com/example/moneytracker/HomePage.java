package com.example.moneytracker;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomePage extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationV);
        FrameLayout frameLayout = findViewById(R.id.frame_layout);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int itemId = item.getItemId();

                if(itemId == R.id.home){
                    replaceFragment(new HomeFragment(), false);
                } else if (itemId == R.id.profile) {
                    replaceFragment(new ProfileFragment(), false);
                } else if (itemId == R.id.setting) {
                    replaceFragment(new SettingFragment(), false);
                }
                return true;
            }
        });
        replaceFragment(new HomeFragment(), true);
    }
    private void replaceFragment(Fragment fragment, boolean isInitialize){

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if(isInitialize){
            fragmentTransaction.add(R.id.frame_layout,fragment);
        }else {
            fragmentTransaction.replace(R.id.frame_layout, fragment);
        }

        fragmentTransaction.commit();
    }
}