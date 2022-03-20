package Salas_de_video;

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
}
