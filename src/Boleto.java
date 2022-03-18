public class Boleto {
    double precioPelicula;
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

    public void aplicarDescuento(Boleteria.MetodoPago metodo, Semana dia){
        int edadCliente = cliente.getEdad();
        double precio = 0;
        int puntos = 0;

        if (metodo.equals(Boleteria.MetodoPago.TARJETA) && dia.equals(Semana.JUEVES)) {
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
            puntos = (int) (50 - (50 * .5));
        }
        precioPelicula = precio;
        cliente.sumarPuntos(puntos);
    }

    public void comprarAsientos(String columnaSala, int cantidadAsientos){
        this.cantidadAsientos = cantidadAsientos;
        salaAsignada.reservarButacas(columnaSala, cantidadAsientos);
    }

}
