package com.example.lab1_mob201;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.lab1_mob201.Fragment.fragment_bai1;
import com.example.lab1_mob201.Fragment.fragment_bai2;
import com.example.lab1_mob201.Fragment.fragment_bai3;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    private BottomNavigationView bottomNavigationView;
    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.actionBar = getSupportActionBar();

        this.initViewById();

        this.initBottomNav();

    }

    private void initViewById() {
        this.bottomNavigationView = findViewById(R.id.nav_bottomView);
    }

    private void initBottomNav() {
        this.bottomNavigationView.setOnNavigationItemSelectedListener(MainActivity.this);
        // mặc định chọn navigation bài 1
        this.bottomNavigationView.getMenu().findItem(R.id.bai1).setChecked(true);
        loadFragment(new fragment_bai1());
        this.actionBar.setTitle("Bài 1");
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.bai1:
                fragment_bai1 fragment_bai1 = new fragment_bai1();
                loadFragment(fragment_bai1);
                checkIdItemNav(R.id.bai1);
                this.actionBar.setTitle("Bài 1");
                break;
            case R.id.bai2:
                fragment_bai2 fragment_bai2 = new fragment_bai2();
                loadFragment(fragment_bai2);
                checkIdItemNav(R.id.bai2);
                this.actionBar.setTitle("Bài 2");
                break;
            case R.id.bai3:
                fragment_bai3 fragment_bai3 = new fragment_bai3();
                loadFragment(fragment_bai3);
                checkIdItemNav(R.id.bai3);
                this.actionBar.setTitle("Bài 3");
                break;
        }
        return true;
    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    private void checkIdItemNav(int idItem) {
        this.bottomNavigationView.getMenu().findItem(idItem).setChecked(true);
    }
}