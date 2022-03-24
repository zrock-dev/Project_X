package Salas_de_video;

import java.util.ArrayList;

public class Utils {

    public static String[] generarAbc(int cantidadLetras){
        String[] abecedario = new String[cantidadLetras];
        for (int index = 0; index < cantidadLetras; index++) {
            abecedario[index] = String.valueOf((char) (65 + index));
        }
        return abecedario;
    }
}
