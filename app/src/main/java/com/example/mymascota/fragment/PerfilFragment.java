package com.example.mymascota.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mymascota.pojo.Mascota;
import com.example.mymascota.R;
import com.example.mymascota.adapter.AdaptadorFoto;

import java.util.ArrayList;

public class PerfilFragment extends Fragment {
    //private RecyclerView recyclerView;
   RecyclerView.LayoutManager layoutManager;
  //  private AdaptadorFoto adaptadorMascota;

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    public AdaptadorFoto adaptador;

    public PerfilFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_perfil,container,false);
        listaMascotas = v.findViewById(R.id.recyclerView);
        layoutManager = new GridLayoutManager(getActivity(),2);

        listaMascotas.setLayoutManager(layoutManager);

        inicializarFotosPerfilMascotas();
        inicializarAdaptador();

        return v;
    }
    public void inicializarAdaptador(){
        adaptador = new AdaptadorFoto(mascotas, getActivity());
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarFotosPerfilMascotas(){

        mascotas = new ArrayList<>();

        mascotas.add(new Mascota(R.drawable.perro,"Perro",2));
        mascotas.add(new Mascota(R.drawable.perro,"Perro",2));
        mascotas.add(new Mascota(R.drawable.perro,"Perro",2));
        mascotas.add(new Mascota(R.drawable.perro,"Perro",2));
        mascotas.add(new Mascota(R.drawable.perro,"Perro",2));
        mascotas.add(new Mascota(R.drawable.perro,"Perro",2));
    }

}
