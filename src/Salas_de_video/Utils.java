package Salas_de_video;

import java.util.ArrayList;

public class Utils {
    static String[] generosPelicula = {
                                "Accion", "Animacion", "Ciencia Ficcion",
                                "Comedia", "Drama", "Fantasia",
                                "Musical", "Romance", "Suspenso",
                                "Terror", "Documental"};

    public static String[] generarAbc(int cantidadLetras){
        String[] abecedario = new String[cantidadLetras];
        for (int index = 0; index < cantidadLetras; index++) {
            abecedario[index] = String.valueOf((char) (65 + index));
        }
        return abecedario;
    }

    public static ArrayList<String> listaPeliculas(Sala sala){
        ArrayList<String> listaPelicula = new ArrayList<>();
        for (Pelicula pelicula : sala.carteleraSala){
            listaPelicula.add(pelicula.nombre);
        }
        return listaPelicula;
    }
}
