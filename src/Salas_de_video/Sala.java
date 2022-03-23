package Salas_de_video;
import Peliculas.BASE_DE_DATOS;
import Peliculas.Pelicula;

import java.util.*;

public class Sala {
    static int capacidadAsientos;
    static String codigoSala;
    Map<String, ArrayList<Seat>> butacasMap;
    ArrayList<Pelicula> carteleraSala;

    public Sala(String codigoSala) {
        butacasMap = new Hashtable<>();
        this.codigoSala = codigoSala;
        carteleraSala = new ArrayList<>();
    }

    public void setButacasMap(Map<String, ArrayList<Seat>> butacasMap) {
        this.butacasMap = butacasMap;
    }

    public ArrayList<Pelicula> getCarteleraSala() {
        return carteleraSala;
    }
    public void setCapacidad ( int capacidadAsientos){
        this.capacidadAsientos = capacidadAsientos;
    }

    private Map<String, ArrayList<Seat>> getButacasMap () {
        return butacasMap;
    }

    public void InsertarPelicula (Pelicula pelicula){
        int cantidadPeliculas = carteleraSala.size();
        int calificacionPelicula = pelicula.getCalificacion();
        switch (capacidadAsientos) {
            case 50:
                if (cantidadPeliculas < 5 && calificacionPelicula <= 5) {
                    carteleraSala.add(pelicula);
                }
            case 80:
                if (cantidadPeliculas < 5 && calificacionPelicula > 5 && calificacionPelicula < 9) {
                    carteleraSala.add(pelicula);
                }
                break;
            case 100:
                if (cantidadPeliculas < 5 && calificacionPelicula > 8) {
                    carteleraSala.add(pelicula);
                }
                break;
            }
    }

    public void llenarCarteleraRandom(){
        int max = 16;
        while (carteleraSala.size()!=5){
            int index = (int) (Math.random() * max);
            InsertarPelicula(BASE_DE_DATOS.LISTA_DE_PELICULAS().get(index));
        }
    }

    public ArrayList<String> getListaPeliculas(){
        ArrayList<String> listaPelicula = new ArrayList<>();
        for (Pelicula pelicula : carteleraSala){
            listaPelicula.add(pelicula.NOMBRE);
        }
        return listaPelicula;
    }
}

