package Salas_de_video;
import java.util.*;

public class Sala {
    int capacidadAsientos;
    int asientosVendidos;
    public String codigoSala;
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

    public int getCapacidad() {
        return capacidadAsientos;
    }

    public ArrayList<Pelicula> getCarteleraSala() {
        return carteleraSala;
    }

    public void setCapacidad ( int capacidadAsientos){
        this.capacidadAsientos = capacidadAsientos;
    }

    public Map<String, ArrayList<Seat>> getButacasMap () {
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
            InsertarPelicula(BaseDeDatos.listaPeliculas().get(index));
        }
    }

    public ArrayList<String> getListaPeliculas(){
        ArrayList<String> listaPelicula = new ArrayList<>();
        for (Pelicula pelicula : carteleraSala){
            listaPelicula.add(pelicula.nombre);
        }
        return listaPelicula;
    }
}

