package Peliculas;
import Salas_de_video.Utils;

import java.util.ArrayList;

public class Pelicula {
    public final String NOMBRE;
    private final String DURACION;
    private final String DESCRIPCION;
    private int calificacion;
    private ArrayList<String> generos;
    //LE DI PRIVATE A TODAS LAS VARIABLES Y CONSTANTES PARA QUE ESTAS SOLO PUEDAN SER MANEJADAS POR EL PAQUETE PELICULAS.

    public Pelicula(String nombre, String duracion, String descripcion, int calificacion){
        generos = new ArrayList<>();
        this.NOMBRE=nombre;
        this.calificacion=calificacion;
        this.DURACION=duracion;
        this.DESCRIPCION=descripcion;
    }

    private static String[] generosPelicula = {
            "Accion", "Animacion", "Ciencia Ficcion",
            "Comedia", "Drama", "Fantasia",
            "Musical", "Romance", "Suspenso",
            "Terror", "Documental"};


    public void setGeneros(String genero){
        for (int i = 0; i< generosPelicula.length; i++){
            if (genero.equals(generosPelicula[i])){
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
}