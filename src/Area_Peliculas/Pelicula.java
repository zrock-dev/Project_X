package Area_Peliculas;
import Salas_de_video.Utils;
import Valores_Constantes.Constants;

import java.util.ArrayList;

public class Pelicula implements Constants {
    String nombre;
    String duracion;
    String descripcion;
    int calificacion;
    ArrayList<String> generos;

    public Pelicula(String nombre, String duracion, String descripcion, int calificacion){
        generos = new ArrayList<>();
        this.nombre = nombre;
        this.calificacion = calificacion;
        this.duracion = duracion;
        this.descripcion = descripcion;
    }

    public void setGeneros(String genero){
        for (int i = 0; i< GENEROS_PELICULA.length; i++){
            if (genero.equals(GENEROS_PELICULA[i])){
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