package com.example.mymascota.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mymascota.pojo.Mascota;
import com.example.mymascota.adapter.MascotaAdaptador;
import com.example.mymascota.R;
import com.example.mymascota.presentador.IMascotasFragmentPresenter;
import com.example.mymascota.presentador.MascotaFragmentPresenter;

import java.util.ArrayList;

public class MascotasFragment extends Fragment implements IMascotasFragmentView{

    ArrayList<Mascota> mascotas;
    private RecyclerView rvMascotas;
    private IMascotasFragmentPresenter presenter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_reciclerview,container,false);
        rvMascotas=(RecyclerView)v.findViewById(R.id.recyclerMascota);
        presenter = new MascotaFragmentPresenter( this , getContext());
        return v;
    }


    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvMascotas.setLayoutManager(llm);
    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador) {
        rvMascotas.setAdapter(adaptador);
    }
}

