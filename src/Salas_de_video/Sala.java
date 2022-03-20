package Salas_de_video;

import java.util.*;

public class Sala {
    int capacidadAsientos;
    String codigoSala;
    Map<String, ArrayList<Seat>> butacasMap;
    ArrayList<String> carteleraSala;

    public Sala(String codigoSala) {
        butacasMap = new Hashtable<>();
        this.codigoSala = codigoSala;
        carteleraSala = new ArrayList<>();
    }

    public void setButacasMap(Map<String, ArrayList<Seat>> butacasMap) {
        this.butacasMap = butacasMap;
    }

    public int getCapacidad() {
        return capacidadAsientos;
    }

    public ArrayList<String> getCarteleraSala() {
        return carteleraSala;
    }
    public void setCapacidad ( int capacidadAsientos){
        this.capacidadAsientos = capacidadAsientos;
    }

    public Map<String, ArrayList<Seat>> getButacasMap () {
        return butacasMap;
    }

    public void llenarCarteleraSala (Pelicula pelicula){
        int cantidadPeliculas = carteleraSala.size();
        int calificacionPelicula = pelicula.getCalificacion();
        switch (capacidadAsientos) {
            case 50:
                if (cantidadPeliculas < 5 && calificacionPelicula <= 5) {
                    carteleraSala.add(pelicula.nombre);
                }
            case 80:
                if (cantidadPeliculas < 5 && calificacionPelicula > 5 && calificacionPelicula < 9) {
                    carteleraSala.add(pelicula.nombre);
                }
                break;
            case 100:
                if (cantidadPeliculas < 5 && calificacionPelicula > 8) {
                    carteleraSala.add(pelicula.nombre);
                }
                break;
            }
    }
}

