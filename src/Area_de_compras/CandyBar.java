package Area_de_compras;

import Registro.Cliente;

import java.util.Scanner;

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

    public void menu(Cliente cliente){
        Scanner scan = new Scanner(System.in);
        System.out.println("Menu \n 1.-Pipocas \n 2.-Refresco \n 3.-nachos");
        System.out.println("¿Que desea comprar? Marque 1 para Pipocas 2 para Refresco 3 para nachos");
        int indice = Integer.parseInt(scan.nextLine());
        switch (indice){
            case 1:
                System.out.println("1.-Pequeño_____15Bs \n 2.-Mediano_____25Bs \n 3.-Grande_____35Bs");
                System.out.println("¿Cual desea comprar? Marque 1 para Pequeño 2 para Mediano 3 para Grande");
                int indice1 = Integer.parseInt(scan.nextLine());
            case 2:
                System.out.println("1.-Pequeño_____10Bs \n 2.-Mediano_____25Bs \n 3.-Grande_____20Bs");
                System.out.println("¿Cual desea comprar? Marque 1 para Pequeño 2 para Mediano 3 para Grande");
                int indice2 = Integer.parseInt(scan.nextLine());
                System.out.println("Que sabor quiere: 1.-CocaCola \n 2.-Fanta \n 3.- Sprite");
                int indiceA = Integer.parseInt(scan.nextLine());
            case 3:
                System.out.println("1.-Pequeño_____10Bs \n 2.-Mediano_____20Bs \n 3.-Grande_____30Bs");
                System.out.println("¿Cual desea comprar? Marque 1 para Pequeño 2 para Mediano 3 para Grande");
                int indice3 = Integer.parseInt(scan.nextLine());
        }
    }
}
