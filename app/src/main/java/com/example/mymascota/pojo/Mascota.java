package com.example.mymascota.pojo;

public class Mascota {
    private int id ;
    private String nombre ;
    private  int rating;
    private int foto;



    public Mascota(int foto, String nombre, int rating) {
        this.nombre = nombre;
        this.rating = rating;
        this.foto = foto;
    }

    public Mascota(){

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }
}
