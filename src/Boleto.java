public class Boleto {
    double precioPelicula;
    int cantidadAsientos;
    int puntosCliente = 50;
    Cliente cliente;
    Sala salaAsignada;
    String generoPelicula;

    String tipoPelicula;

    public Boleto(Cliente cliente, double precioPelicula, Sala salaAsignada, String tipoPelicula){
        this.cliente = cliente;
        this.precioPelicula = precioPelicula;
        this.salaAsignada = salaAsignada;
        this.tipoPelicula=tipoPelicula;
    }

    public void setGeneroPelicula(String generoPelicula) {
        this.generoPelicula = generoPelicula;
    }

    public void aplicarDescuento(Boleteria.MetodoPago metodo,Semana dia,String tipoPelicula){
        int edadCliente = cliente.getEdad();
        double precio = 0;
        int puntos = 0;
            if (tipoPelicula.equals("2D")) {
                precio = 40;
                puntos = (40);
                if (metodo.equals(Boleteria.MetodoPago.TARJETA) && dia.equals(Semana.JUEVES)) {
                    precio = 40-(40 * .12);
                    puntos = (int) (40-(40 * .12));
                }
                if (edadCliente <= 10 && generoPelicula.equals("Animacion")) {
                    precio = 40-(40 * .15);
                    puntos = (int) (40-(40 * .15));
                }
                if (dia.equals(Semana.MIERCOLES)) {
                    precio = 40-(40 * .5);
                    puntos = (int) (40-(40 * .5));
                }
                if (edadCliente >= 60) {
                    precio = 40-(40 * .5);
                    puntos = (int) (40-(40 * .5));
                }
            }
            if(tipoPelicula.equals("3D")) {
                precio = 60;
                puntos = (60);
                if (metodo.equals(Boleteria.MetodoPago.TARJETA) && dia.equals(Semana.JUEVES)) {
                    precio = 60-(60 * .12);
                    puntos = (int) (60-(60 * .12));
                }
                if (edadCliente <= 10 && generoPelicula.equals("Animacion")) {
                    precio = 60-(60 * .15);
                    puntos = (int) (60-(60 * .15));
                }
                if (dia.equals(Semana.MIERCOLES)) {
                    precio = 60-(60 * .5);
                    puntos = (int) (60-(60 * .5));

                }
                if (edadCliente >= 60) {
                    precio = 60-(60 * .5);
                    puntos = (int) (60-(60 * .5));
                }

            }
            setPrecioPelicula(precio);
            setPuntosCliente(puntos);
    }


    public void comprarAsientos(String columnaSala, int cantidadAsientos){
        this.cantidadAsientos = cantidadAsientos;
        salaAsignada.reservarButacas(columnaSala, cantidadAsientos);
    }

    public void setPuntosCliente(int puntos){
        cliente.sumarPuntos(puntos);
    }
    public void setPrecioPelicula(double precio){
        this.precioPelicula=precio;
    }

}
