package Salas_de_video;

import java.util.ArrayList;

public class Pelicula {
    String nombre,duracion,descripcion;
    ArrayList<String> generos = new ArrayList<>();

    public Pelicula(String nombre,String duracion){
        this.nombre = nombre;
        this.duracion = duracion;
    }

    public String getNombre(){
        return nombre;
    }

    public ArrayList<String> getGeneros(){
        return generos;
    }

    public String getDuracion(){
        return duracion;
    }

    public String getDescripcion(){
        return descripcion;
    }

    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }

    public void quitarGenero(String genero){
        generos.remove(genero);
    }

    public void añadirGenero(String genero){
        generos.add(genero);
    }

    public void modificarNombre(String nuevoNombre){
        nombre = nuevoNombre;
    }

    public void modificarDuracion(String nuevaDuracion){
        duracion = nuevaDuracion;
    }

    public void modificarDescripcion(String nuevaDescripcion){
        descripcion = nuevaDescripcion;
    }
}
