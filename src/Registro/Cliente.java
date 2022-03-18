package Registro;

public class Cliente {
    int ci, puntosTotales;
    String fullName, nacionalidad, fechaNacimiento;
    int cantidadTicketsGratis;
    // Fecha de nacimiento : 03/01/2001


    public Cliente(int ci, String fullName, String nacionalidad, String fechaNacimiento) {
        this.ci = ci;
        this.fullName = fullName;
        this.nacionalidad = nacionalidad;
        this.fechaNacimiento = fechaNacimiento;
    }

    public void sumarPuntos(int cantidadSumar){
        puntosTotales = cantidadSumar + puntosTotales;
    }

    public int getCi() {
        return ci; // para la llave
    }

    public int getEdad() {  // edad del cliente
        return 2022 - Integer.parseInt(fechaNacimiento.split("/")[2]);
    }

    public int getPuntosTotales() {
        return puntosTotales;
    }

    public void setCantidadTicketsGratis(int cantidadTicketsGratis) {
        this.cantidadTicketsGratis = cantidadTicketsGratis;
    }

    public void canjearPuntos(int puntosCanjeados){
        puntosTotales -= puntosCanjeados;
    }

    public void sumarTicketGratis(int cantidadTickets) {
        this.cantidadTicketsGratis += cantidadTickets;
    }

    public int getCantidadTicketsGratis() {
        return cantidadTicketsGratis;
    }

    public void usarTicketGratis(){
        cantidadTicketsGratis -= 1;
    }
}
