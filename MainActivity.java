package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.SeekBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.example.myapplication.databinding.ActivityMainBinding;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                // 1. Hangi fragmentin açılacağına TEK SATIRDA karar veriyoruz (Ternary If)
                // Soru: Pozisyon 0 mı? Evetse FirstFragment, değilse SecondFragment koy.
                Fragment secilen = (tab.getPosition() == 0) ? new FirstFragment() : new SecondFragment();

                // 2. Değiştirme işlemini yapıyoruz
                getSupportFragmentManager().beginTransaction()
                        .replace(binding.frameContainer.getId(), secilen)
                        .commit();
            }
            // Java kuralı gereği bu iki boş metod mecburen burada durmalı
            @Override public void onTabUnselected(TabLayout.Tab tab) {}
            @Override public void onTabReselected(TabLayout.Tab tab) {}
        });
    }
}



