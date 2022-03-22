package Informacion_de_peliculas;

import java.util.ArrayList;

public class Pelicula {
    public final String NOMBRE;
    private final String DURACION;
    private final String DESCRIPCION;
    private int calificacion;
    private ArrayList<String> generos;
    final String[] GENEROS_ACEPTADOS = new String[] {
            "Accion", "Animacion", "Ciencia Ficcion",
            "Comedia", "Drama", "Fantasia",
            "Musical", "Romance", "Suspenso",
            "Terror", "Documental"};
    //LE DI PRIVATE A TODAS LAS VARIABLES Y CONSTANTES PARA QUE ESTAS SOLO PUEDAN SER MANEJADAS POR EL PAQUETE PELICULAS.

    public Pelicula(String nombre, String duracion, String descripcion, int calificacion){
        generos = new ArrayList<>();
        this.NOMBRE=nombre;
        this.calificacion=calificacion;
        this.DURACION=duracion;
        this.DESCRIPCION=descripcion;
    }

    public void setGeneros(String generoNuevo){
        for (String s : GENEROS_ACEPTADOS) {
            if (generoNuevo.equals(s)) {
                generos.add(generoNuevo);
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