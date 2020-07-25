package com.example.mymascota;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class AcercaDe extends AppCompatActivity {
    private RecyclerView rvMascotasFavoritas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca_de);

        Toolbar miActionBarFavoritos = (Toolbar) findViewById(R.id.miActionBarFavoritos);

        setSupportActionBar(miActionBarFavoritos);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}