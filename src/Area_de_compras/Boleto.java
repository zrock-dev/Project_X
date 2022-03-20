package Area_de_compras;

import Registro.Cliente;
import Salas_de_video.Sala;

public class Boleto {
    public double precioPelicula;
    int cantidadAsientos;
    int puntosBoleto = 50;
    Cliente cliente;
    Sala salaAsignada;
    String generoPelicula;

    public Boleto(Cliente cliente, int precioPelicula, Sala salaAsignada){
        this.cliente = cliente;
        this.precioPelicula = precioPelicula;
        this.salaAsignada = salaAsignada;
    }

    public Boleto(Sala salaAsignada){
        this.salaAsignada = salaAsignada;
    }

    public void setGeneroPelicula(String generoPelicula) {
        this.generoPelicula = generoPelicula;
    }

    public void aplicarDescuento(MetodoPago metodo, Semana dia){
        int edadCliente = cliente.getEdad();
        double precio = 0;
        int puntos = 0;

        if (metodo.equals(MetodoPago.TARJETA) && dia.equals(Semana.JUEVES)) {
            precio = precioPelicula - (precioPelicula * .12);
            puntos = (int) (puntosBoleto - (puntosBoleto * .12));
        }
        if (edadCliente <= 10 && generoPelicula.equals("Animacion")) {
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
        // agrego esto solo para casos en los que no halla ningun descuento
        if (precio == 0){
            precio = precioPelicula;
        }
        precioPelicula = precio;
        cliente.sumarPuntos(puntos);
    }
}
