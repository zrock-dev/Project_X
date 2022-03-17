public class Cliente {
    int ci, puntosTotales;
    String fullName, nacionalidad, fechaNacimiento;
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

    public void canjearPuntos(int puntosCanjeados){
        puntosTotales -= puntosCanjeados;
    }

    public void setPuntosTotales(int puntos){this.puntosTotales=puntos;}



    enum Premio {
        BOLETO,PREMIOS
    }
    public String canjear(Cliente cliente, Cliente.Premio tipoPaquete, int promocion){
        switch (tipoPaquete){
            case BOLETO:
                return paqueteBoletos(cliente, promocion);
            case PREMIOS:
                return paquetePremios(cliente, promocion);
        }
        return null;
    }

    public String paqueteBoletos(Cliente cliente, int promocion){
        if (cliente.getPuntosTotales() >= 500 && promocion==1) {
            cliente.canjearPuntos(500);
            return ("+1 boleto");

        }
        if (cliente.getPuntosTotales()>=950 && promocion==2) {
            cliente.canjearPuntos(950);
            return ("+2 boleto");

        }
        if (cliente.getPuntosTotales()>=1350 && promocion==3) {
            cliente.canjearPuntos(1350);
            return ("+3 boleto");
        }
        return null;
    }

    public String paquetePremios(Cliente cliente, int promocion){
        if (cliente.getPuntosTotales() >= 500 && promocion==1) {
            cliente.canjearPuntos(500);
            return("Pipocas grande");
        }
        if (cliente.getPuntosTotales() >= 950 && promocion==2) {
            cliente.canjearPuntos(950);
            return("Pipocas grande" + "2 refrescos medianos" + "gorra");
        }
        if (cliente.getPuntosTotales() >= 1350 && promocion==3) {
            cliente.canjearPuntos(1350);
            return("Pipocas grande" + "1 refresco grande" + "Polera oficial");
        }
        return null;
    }
}
