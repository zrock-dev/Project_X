package Area_de_compras;

import Registro.Cliente;

public class CandyBar {

    enum Paquete{
        BOLETO, PREMIOS
    }

    public CandyBar(Cliente cliente, Paquete tipoPaquete){
        switch (tipoPaquete){
            case BOLETO:
                paqueteBoletos(cliente);
                break;
            case PREMIOS:
                paquetePremios(cliente);
        }
    }

    public void paqueteBoletos(Cliente cliente){
        switch (cliente.getPuntosTotales()){
            case 500:
                cliente.canjearPuntos(500);
                System.out.println("+1 boleto");
                cliente.sumarTicketGratis(1);
                break;
            case 950:
                System.out.println("+2 boleto");
                cliente.sumarTicketGratis(2);
                cliente.canjearPuntos(950);
                break;

            case 1350:
                System.out.println("+3 boleto");
                cliente.canjearPuntos(1350);
                cliente.sumarTicketGratis(3);
                break;
        }
    }

    public void paquetePremios(Cliente cliente){
        switch (cliente.getPuntosTotales()){
            case 500:
                cliente.canjearPuntos(500);
                System.out.println("Pipocas grande");
                break;
            case 950:
                cliente.canjearPuntos(950);
                System.out.println("Pipocas grande" + "2 refrescos medianos" + "gorra");
                break;
            case 1350:
                cliente.canjearPuntos(1350);
                System.out.println("Pipocas grande" + "1 refresco grande" + "Polera oficial");
        }
    }
}