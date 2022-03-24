package Area_de_compras;

import Registro.Cliente;
import Salas_de_video.Pelicula;
import Valores_Constantes.Constants;
import static Console_interaction.Utils.*;


public class Boleto {
    public double precioPelicula;
    int puntosBoleto = Constants.PUNTOS_POR_BOLETO;
    Cliente cliente;
    Pelicula pelicula;
    int edadCliente;

    public Boleto(Cliente cliente, int precioPelicula, Pelicula pelicula){
        this.cliente = cliente;
        this.precioPelicula = precioPelicula;
        this.pelicula = pelicula;
        this.edadCliente = cliente.getEdad();
    }

    public Boleto(int edadCliente, int precioPelicula, Pelicula pelicula){
        this.edadCliente = edadCliente;
        this.precioPelicula = precioPelicula;
        this.pelicula = pelicula;
    }

    public int aplicarDescuento(MetodoPago metodo, Semana dia){

        double precio = precioPelicula;
        int puntos = puntosBoleto;

        if (metodo.equals(MetodoPago.TARJETA) && dia.equals(Constants.PROMO_DAY_TARJETA)) {
            precio = precioPelicula - (precioPelicula * .12);
            puntos = (int) (puntosBoleto - (puntosBoleto * .12));
        }
        if (edadCliente <= 10 && pelicula.getAnimacion()){
            precio = precioPelicula - (precioPelicula * .15);
            puntos = (int) (puntosBoleto - (puntosBoleto * .15));
        }
        if (dia.equals(Constants.PROMO_DAY)) {
            precio = precioPelicula - (precioPelicula * .5);
            puntos = (int) (puntosBoleto - (puntosBoleto * .5));
        }
        if (edadCliente >= 60) {
            precio = precioPelicula - (precioPelicula * .5);
            puntos = (int) (puntosBoleto - (puntosBoleto * .5));
        }
        precioPelicula = precio;
        return puntosBoleto;
    }
}
