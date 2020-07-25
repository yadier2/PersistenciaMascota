package com.example.mymascota.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.mymascota.R;
import com.example.mymascota.pojo.Mascota;

import java.util.ArrayList;

public class BaseDatos extends SQLiteOpenHelper {

    private Context context;

    public BaseDatos(Context context) {
        super(context, ConstanteBaseDatos.DATA_BASE_NAME, null, ConstanteBaseDatos.DATABASE_VESION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTablaMascota = "CREATE TABLE " + ConstanteBaseDatos.TABLE_MASCOTA + " (" +
                ConstanteBaseDatos.TABLE_MASCOTA_ID       + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstanteBaseDatos.TABLE_MASCOTA_NOMBRE   + " TEXT, " +
                ConstanteBaseDatos.TABLE_MASCOTA_FOTO     + " INTEGER" +
                ")";

        String queryCrearTablaLikeMascota = "CREATE TABLE " + ConstanteBaseDatos.TABLE_LIKE_MASCOTA + " (" +
                ConstanteBaseDatos.TABLE_LIKE_MASCOTA_ID          + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstanteBaseDatos.TABLE_LIKE_MASCOTA_ID_MASCOTA + " INTEGER, " +
                ConstanteBaseDatos.TABLE_LIKE_MASCOTA_NO_LIKES    + " INTEGER, " +
                "FOREIGN KEY (" + ConstanteBaseDatos.TABLE_LIKE_MASCOTA_ID_MASCOTA + ") " +
                "REFERENCES " + ConstanteBaseDatos.TABLE_MASCOTA + " (" + ConstanteBaseDatos.TABLE_MASCOTA_ID + ")" +
                ")";

        db.execSQL(queryCrearTablaMascota);
        db.execSQL(queryCrearTablaLikeMascota);
        iniPuppies(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + ConstanteBaseDatos.TABLE_MASCOTA);
        db.execSQL("DROP TABLE IF EXISTS " + ConstanteBaseDatos.TABLE_LIKE_MASCOTA);
        onCreate(db);
    }
    public void iniPuppies(SQLiteDatabase db) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstanteBaseDatos.TABLE_MASCOTA_NOMBRE, "Conejo");
        contentValues.put(ConstanteBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.conejo);
        db.insert(ConstanteBaseDatos.TABLE_MASCOTA, null, contentValues);;

         contentValues = new ContentValues();
        contentValues.put(ConstanteBaseDatos.TABLE_MASCOTA_NOMBRE, "Perro");
        contentValues.put(ConstanteBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.perro);
        db.insert(ConstanteBaseDatos.TABLE_MASCOTA, null, contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstanteBaseDatos.TABLE_MASCOTA_NOMBRE, "Gato");
        contentValues.put(ConstanteBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.gato);
        db.insert(ConstanteBaseDatos.TABLE_MASCOTA, null, contentValues);;

        contentValues = new ContentValues();
        contentValues.put(ConstanteBaseDatos.TABLE_MASCOTA_NOMBRE, "Conejo");
        contentValues.put(ConstanteBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.conejo);
        db.insert(ConstanteBaseDatos.TABLE_MASCOTA, null, contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstanteBaseDatos.TABLE_MASCOTA_NOMBRE, "Perro");
        contentValues.put(ConstanteBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.perro2);
        db.insert(ConstanteBaseDatos.TABLE_MASCOTA, null, contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstanteBaseDatos.TABLE_MASCOTA_NOMBRE, "Hamster");
        contentValues.put(ConstanteBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.hamster);
        db.insert(ConstanteBaseDatos.TABLE_MASCOTA, null, contentValues);

    }








    public ArrayList<Mascota> obtenerTodasMascotas(){
        ArrayList<Mascota> mascotas = new ArrayList<>();

        String query = "SELECT * FROM " + ConstanteBaseDatos.TABLE_MASCOTA;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()){
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setFoto(registros.getInt(2));

            String queryLikes = "SELECT COUNT(" + ConstanteBaseDatos.TABLE_LIKE_MASCOTA_NO_LIKES + ") as likes" +
                    " FROM " + ConstanteBaseDatos.TABLE_LIKE_MASCOTA +
                    " WHERE " + ConstanteBaseDatos.TABLE_LIKE_MASCOTA_ID_MASCOTA + "=" + mascotaActual.getId();

            Cursor registrosLikes = db.rawQuery(queryLikes, null);
            if (registrosLikes.moveToNext()){
                mascotaActual.setRating(registrosLikes.getInt(0));
            }else{
                mascotaActual.setRating(0);
            }

            mascotas.add(mascotaActual);
        }
        db.close();
        return mascotas;
    }

    public void insertarMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstanteBaseDatos.TABLE_MASCOTA, null, contentValues);
        db.close();
    }

    public void insertarLikeMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstanteBaseDatos.TABLE_LIKE_MASCOTA, null, contentValues);
        db.close();
    }

    public int obtenerLikesMascota(Mascota mascota){
        int likes = 0;

        String query = "SELECT COUNT(" + ConstanteBaseDatos.TABLE_LIKE_MASCOTA_NO_LIKES + ")" +
                " FROM " + ConstanteBaseDatos.TABLE_LIKE_MASCOTA +
                " WHERE " + ConstanteBaseDatos.TABLE_LIKE_MASCOTA_ID_MASCOTA + "=" + mascota.getId();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        if (registros.moveToNext()){
            likes = registros.getInt(0);
        }

        db.close();

        return likes;
    }

    public void eliminarTablasDB(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(ConstanteBaseDatos.TABLE_LIKE_MASCOTA,null,null);
        db.delete(ConstanteBaseDatos.TABLE_MASCOTA,null,null);
    }

    public ArrayList<Mascota> obtenerRankingMascotas(){
        ArrayList<Mascota> mascotas = new ArrayList<>();

        String query = "select m."+ ConstanteBaseDatos.TABLE_MASCOTA_ID +
                ", m."+ ConstanteBaseDatos.TABLE_MASCOTA_NOMBRE +
                ", m."+ ConstanteBaseDatos.TABLE_MASCOTA_FOTO +
                ", t1.cant " +
                "from "+ ConstanteBaseDatos.TABLE_MASCOTA +" m" +
                ", (select "+ ConstanteBaseDatos.TABLE_LIKE_MASCOTA_ID_MASCOTA + ", count("+ ConstanteBaseDatos.TABLE_LIKE_MASCOTA_NO_LIKES +") as cant from "+ ConstanteBaseDatos.TABLE_LIKE_MASCOTA +" group by "+ ConstanteBaseDatos.TABLE_LIKE_MASCOTA_ID_MASCOTA +" order by 2 desc) t1 " +
                "where m."+ ConstanteBaseDatos.TABLE_MASCOTA_ID +" = t1."+ ConstanteBaseDatos.TABLE_LIKE_MASCOTA_ID_MASCOTA + " limit 5";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()){
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setFoto(registros.getInt(2));
            mascotaActual.setRating(registros.getInt(3));

            mascotas.add(mascotaActual);
        }
        db.close();
        return mascotas;
    }
}

