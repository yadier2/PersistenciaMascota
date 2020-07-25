package com.example.mymascota.fragment;

import com.example.mymascota.adapter.MascotaAdaptador;
import com.example.mymascota.pojo.Mascota;

import java.util.ArrayList;

public interface IMascotasFragmentView {
    public void generarLinearLayoutVertical();
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador);
}
