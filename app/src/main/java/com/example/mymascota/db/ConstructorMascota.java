package com.example.mymascota.db;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Toast;

import com.example.mymascota.MainActivity;
import com.example.mymascota.R;
import com.example.mymascota.pojo.Mascota;

import java.util.ArrayList;

  // este es el interactor el intermediario ue consulta la fuente de datos
    public class ConstructorMascota extends MainActivity {

        private static final int LIKE = 1;
        private Context context;

        public ConstructorMascota(Context context) {
            this.context = context;
        }
        public ArrayList<Mascota> obtenerDatos(){
            BaseDatos db = new BaseDatos(context);
            return db.obtenerTodasMascotas();
        }

        public void darLikeMascota(Mascota mascota){
            BaseDatos db = new BaseDatos(context);
            ContentValues contentValues = new ContentValues();
            contentValues.put(ConstanteBaseDatos.TABLE_LIKE_MASCOTA_ID_MASCOTA, mascota.getId());
            contentValues.put(ConstanteBaseDatos.TABLE_LIKE_MASCOTA_NO_LIKES, LIKE);
            db.insertarLikeMascota(contentValues);
        }

        public int obtenerLikesMascota(Mascota mascota){
            BaseDatos db = new BaseDatos(context);
            return db.obtenerLikesMascota(mascota);
        }

        public void eliminarTablasDB(){
            BaseDatos db = new BaseDatos(context);
            db.eliminarTablasDB();
        }

        public ArrayList<Mascota> obtenerRankingMacotas(){

            BaseDatos db = new BaseDatos(context);
            return db.obtenerRankingMascotas();
        }


}
