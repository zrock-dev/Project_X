package Area_de_compras;

import Registro.Cliente;
import Informacion_de_peliculas.Pelicula;

public class Boleto {
    public double precioPelicula;
    int puntosBoleto = 50;
    Cliente cliente;
    Pelicula pelicula;

    public Boleto(Cliente cliente, int precioPelicula, Pelicula pelicula){
        this.cliente = cliente;
        this.precioPelicula = precioPelicula;
        this.pelicula = pelicula;
    }

     public void aplicarDescuento(MetodoPago metodo, Semana dia){
        int edadCliente = cliente.getEdad();
        double precio = precioPelicula;
        int puntos = puntosBoleto;

        if (metodo.equals(MetodoPago.TARJETA) && dia.equals(Semana.JUEVES)) {
            precio = precioPelicula - (precioPelicula * .12);
            puntos = (int) (puntosBoleto - (puntosBoleto * .12));
        }
        if (edadCliente <= 10 && pelicula.getAnimacion()){
            precio = precioPelicula - (precioPelicula * .15);
            puntos = (int) (puntosBoleto - (puntosBoleto * .15));
        }
        if (dia.equals(Semana.MIERCOLES)) {
            precio = precioPelicula - (precioPelicula * .5);
            puntos = (int) (puntosBoleto - (puntosBoleto * .5));
        }
        if (edadCliente >= 60) {
            precio = precioPelicula - (precioPelicula * .5);
            puntos = (int) (puntosBoleto - (puntosBoleto * .5));
        }
        precioPelicula = precio;
        cliente.sumarPuntos(puntos);
    }
}
