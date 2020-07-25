package com.example.mymascota;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.mymascota.adapter.PageAdapter;

import com.example.mymascota.db.ConstructorMascota;
import com.example.mymascota.fragment.PerfilFragment;
import com.example.mymascota.fragment.MascotasFragment;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

  //  private Toolbar toolbar;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.vPager);

        setUpViewPager();
        if(miActionBar!=null)
        {
            setSupportActionBar(miActionBar);
        }
    }

    public void irMascotasFavoritas(View v) {
        Intent intent = new Intent(this, MascotasFavoritas.class);
        startActivity(intent);
    }

    private ArrayList<Fragment>agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new MascotasFragment());
        fragments.add(new PerfilFragment());
        return fragments;
    }
    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_mascotas);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_lista);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones,menu);
        return  true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menuContacto:
                Intent c = new Intent(this, Contacto1.class);
                startActivity(c);
                break;
            case R.id.menuAcercaDe:
                Intent i = new Intent(this, AcercaDe.class);
                startActivity(i);
                break;
        }
        return super.onOptionsItemSelected(item);
    }


}