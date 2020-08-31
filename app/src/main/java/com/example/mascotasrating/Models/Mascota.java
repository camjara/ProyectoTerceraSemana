package com.example.mascotasrating.Models;

public class Mascota {
    private String nombre;
    private int rating;
    private int foto;
    private int color;

    public Mascota() {
    }

    public Mascota(String nombre, int rating, int foto, int color) {
        this.nombre = nombre;
        this.rating = rating;
        this.foto = foto;
        this.color = color;
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


    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
