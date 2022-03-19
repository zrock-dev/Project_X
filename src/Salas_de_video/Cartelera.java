package Salas_de_video;

import java.util.ArrayList;

public class Cartelera {
    ArrayList<Pelicula> peliculas = new ArrayList<>();

    public void eliminarPelicula(String nombre){
        for(int i=0;i< peliculas.size();i++){
            if(nombre.equals(peliculas.get(i).getNombre()))
                peliculas.remove(i);
        }
    }

    public void añadirPelicula(String nombre,String duracion){
        Pelicula peli = new Pelicula(nombre,duracion);
        peliculas.add(peli);
    }

    public Pelicula getPeliculas(String nombre) {
        for (int i = 0; i < peliculas.size(); i++) {
            if (peliculas.get(i).getNombre().equals(nombre)) {
                return peliculas.get(i);
            }
        }
        return null;
    }

    public int getCantidadPelis(){
        return peliculas.size();
    }
}
