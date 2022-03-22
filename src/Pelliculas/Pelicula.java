package Pelliculas;
import Salas_de_video.Utils;

import java.util.ArrayList;

public class Pelicula {
    private final String nombre;
    private final String duracion;
    private final String descripcion;
    private int calificacion;
    private ArrayList<String> generos;
    //LE DI PRIVATE A TODAS LAS VARIABLES Y CONSTANTES PARA QUE ESTAS SOLO PUEDAN SER MANEJADAS POR EL PAQUETE PELICULAS.

    public Pelicula(String nombre, String duracion, String descripcion, int calificacion){
        generos = new ArrayList<>();
        this.nombre=nombre;
        this.calificacion=calificacion;
        this.duracion=duracion;
        this.descripcion=descripcion;
    }

    public void setGeneros(String genero){
        for (int i = 0; i< Utils.generosPelicula.length; i++){
            if (genero.equals(Utils.generosPelicula[i])){
                generos.add(genero);
                break;
            }
        }
    }

    public void setCalificacion(int calificacion){
        this.calificacion=calificacion;
    }
    public int getCalificacion(){
        return calificacion;
    }
    public boolean getAnimacion(){
        return generos.contains("Animacion");
    }
    public String getNombre() {
        return nombre;
    }
}