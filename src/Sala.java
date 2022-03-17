import java.util.*;

public class Sala {
    int capacidad;
    String codigoSala;
    Map<String, Integer> butacas;
    String[] carteleraSala = new String[5];

    public Sala(String codigoSala){
        butacas = new Hashtable<>();
        this.codigoSala = codigoSala;
        llenarCarteleraSala();
    }

    public String[] getCarteleraSala() {
        return carteleraSala;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad/10;
        generarButacas();
    }

    public void llenarCarteleraSala(){
        for (int index = 0; index < carteleraSala.length; index++) {
            int rndIndex = new Random().nextInt(Utils.generosPelicula.length);
            carteleraSala[index] = Utils.generosPelicula[rndIndex];
        }
    }

    public void generarButacas(){

        int cantidadFilas = 10;
        int columnas = capacidad/cantidadFilas;
        char[] columnasCodigos = Utils.generarAbc(columnas);
        for (int indexColumn = 0; indexColumn < columnas; indexColumn++) {
            String[] codigosAsientoColumna = new String[cantidadFilas];
            String columnaLetra = String.valueOf(columnasCodigos[indexColumn]);
            for (int indexFila = 0; indexFila < codigosAsientoColumna.length; indexFila++) {
                codigosAsientoColumna[indexFila] = columnaLetra + (indexFila + 1);
            }

        }

    }

    public void reservarButacas(String columna, int cantidadAsientosReservados){
        int oldValue = butacas.get(columna);
        if (cantidadAsientosReservados <= 10 && (oldValue + cantidadAsientosReservados) <= 10 ){
            butacas.put(columna, oldValue + cantidadAsientosReservados);
        }
    }
}
