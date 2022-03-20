package Salas_de_video;
import java.util.ArrayList;

public class Pelicula {
    String nombre;
    String duracion;
    String descripcion;
    int calificacion;
    ArrayList<String> generos;

    public Pelicula(String nombre, String duracion, String descripcion, int calificacion){
        generos = new ArrayList<>();
        this.nombre=nombre;
        this.calificacion=calificacion;
        this.duracion=duracion;
        this.descripcion=descripcion;
    }

    public void setGeneros(String genero){
        for (int i=0;i<Utils.generosPelicula.length;i++){
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
}