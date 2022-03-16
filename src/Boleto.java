public class Boleto {
    int precioPelicula;
    int cantidadAsientos;
    int puntosCliente = 50;
    Cliente cliente;
    Sala salaAsignada;
    String generoPelicula;

    String tipoPelicula;

    public Boleto(Cliente cliente, int precioPelicula, Sala sala, String tipoPelicula){
        this.cliente = cliente;
        this.precioPelicula = precioPelicula;
        this.salaAsignada = sala;

        this.tipoPelicula=tipoPelicula;
    }

    public void setGeneroPelicula(String generoPelicula) {
        this.generoPelicula = generoPelicula;
    }

    public void aplicarDescuento(Boleteria.MetodoPago metodo,Semana dia,String tipoPelicula){
        int edadCliente = cliente.getEdad();
        switch(tipoPelicula){
            case "2D":
                if (metodo.equals(Boleteria.MetodoPago.TARJETA) && dia.equals(Semana.JUEVES)){
                    precioPelicula -= 40 * .12;
                    puntosCliente -= 40 * .12;
                }
                if (edadCliente <= 10 && generoPelicula.equals("Animacion")){
                    precioPelicula -= (40 * .15);
                    puntosCliente -= (40 *.15);
                }
                if (dia.equals(Semana.MIERCOLES)){
                    precioPelicula -= (40*.5);
                    puntosCliente -= (40*.5);
                    break;
                }
                if (edadCliente >= 60){
                    precioPelicula -= (40 * .5);
                    puntosCliente -= (40 *.5);
                    break;
                }

            case "3D":
                if (metodo.equals(Boleteria.MetodoPago.TARJETA) && dia.equals(Semana.JUEVES)){
                    precioPelicula -= 60 * .12;
                    puntosCliente -= 60 * .12;
                }
                if (edadCliente <= 10 && generoPelicula.equals("Animacion")){
                    precioPelicula -= (60 * .15);
                    puntosCliente -= (60 *.15);
                }
                if (dia.equals(Semana.MIERCOLES)){
                    precioPelicula -= (60*.5);
                    puntosCliente -= (60*.5);
                    break;
                }
                if (edadCliente >= 60){
                    precioPelicula -= (60 * .5);
                    puntosCliente -= (60 *.5);
                    break;
                }
                
        }
        setPuntosCliente();
        setPrecioPelicula(precioPelicula);
    }

    public void comprarAsientos(String columnaSala, int cantidadAsientos){
        this.cantidadAsientos = cantidadAsientos;
        salaAsignada.reservarButacas(columnaSala, cantidadAsientos);
    }

    public void setPuntosCliente(){
        cliente.sumarPuntos(puntosCliente);
    }
    public void setPrecioPelicula(int precio){
        this.precioPelicula=precio;
    }

}
