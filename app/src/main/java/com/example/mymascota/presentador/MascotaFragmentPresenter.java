package com.example.mymascota.presentador;

import android.content.Context;

import com.example.mymascota.db.ConstructorMascota;

import com.example.mymascota.fragment.IMascotasFragmentView;

import com.example.mymascota.pojo.Mascota;

import java.util.ArrayList;

public class MascotaFragmentPresenter implements IMascotasFragmentPresenter {


    private IMascotasFragmentView iMascotasFragmentView;
    private Context context;
    private ConstructorMascota constructorMascotas;
    private ArrayList<Mascota> mascotas;

   public MascotaFragmentPresenter(IMascotasFragmentView iMascotasFragmentView , Context context){
       this.iMascotasFragmentView = iMascotasFragmentView;
       this.context = context;
       obtenerMascotasBaseDatos();
   }


    @Override
    public void obtenerMascotasBaseDatos() {
        constructorMascotas = new ConstructorMascota(context);
        mascotas = constructorMascotas.obtenerDatos();
        mostrarMascotasRV();
    }

    @Override
    public void mostrarMascotasRV() {
        iMascotasFragmentView.inicializarAdaptadorRV(iMascotasFragmentView.crearAdaptador(mascotas));
        iMascotasFragmentView.generarLinearLayoutVertical();
    }

    @Override
    public void eliminarDatos() {
        constructorMascotas.eliminarTablasDB();
    }
}
