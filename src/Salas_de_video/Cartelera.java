package Salas_de_video;

import java.util.ArrayList;

public class Cartelera {
    ArrayList<Pelicula> peliculas;

    public void eliminarPelicula(Pelicula pelicula){
        peliculas.remove(pelicula);
    }

    public void añadirPelicula(String nombre,String duracion,ArrayList<String> generos){
        Pelicula peli = new Pelicula(nombre,duracion,generos);
        peliculas.add(peli);
    }

}
