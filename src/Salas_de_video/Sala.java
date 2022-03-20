package Salas_de_video;

import java.util.*;

public class Sala {
    int capacidadAsientos;
    String codigoSala;
    Map<String, ArrayList<String>> butacasMap;
    String[] carteleraSala = new String[5];

    public Sala(String codigoSala){
        butacasMap = new Hashtable<>();
        this.codigoSala = codigoSala;
        llenarCarteleraSala();
    }

    public void setButacasMap(Map<String, ArrayList<String>> butacasMap) {
        this.butacasMap = butacasMap;
    }

    public int getCapacidad() {
        return capacidadAsientos;
    }

    public String[] getCarteleraSala() {
        return carteleraSala;
    }

    public void setCapacidad(int capacidadAsientos) {
        this.capacidadAsientos = capacidadAsientos;
    }

    public void llenarCarteleraSala(){
        for (int index = 0; index < carteleraSala.length; index++) {
            int rndIndex = new Random().nextInt(Utils.generosPelicula.length);
            carteleraSala[index] = Utils.generosPelicula[rndIndex];
        }
    }
}
