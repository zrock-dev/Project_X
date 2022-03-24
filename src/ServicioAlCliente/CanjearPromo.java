package ServicioAlCliente;

import Registro.Cliente;

import java.util.Scanner;

public class CanjearPromo {

    public static void canjear(Premios premio,Cliente cliente){

        int puntosPremio = premio.getPuntosPremio();
        int clientePuntosTotales = cliente.getPuntosTotales();

        switch (premio.getTipo()) {
            case ("boleto"):

                if (clientePuntosTotales >= puntosPremio && premio.equals(Premios.PRIMERAOPCION)) {
                    cliente.setCantidadTicketsGratis(1);
                    cliente.canjearPuntos(premio.getPuntosPremio());
                }
                if (clientePuntosTotales >= puntosPremio && premio.equals(Premios.SEGUNDAOPCION)) {
                    cliente.setCantidadTicketsGratis(2);
                    cliente.canjearPuntos(premio.getPuntosPremio());
                }
                if (clientePuntosTotales >= puntosPremio && premio.equals(Premios.TERCERAOPCION)) {
                    cliente.setCantidadTicketsGratis(3);
                    cliente.canjearPuntos(premio.getPuntosPremio());
                }

            case ("candybar"):
            if (clientePuntosTotales >= puntosPremio && premio.equals(Premios.CUARTAOPCION)) {
                cliente.setPremioCandyBar(premio.getDescripcion());
            }
            if (clientePuntosTotales >= puntosPremio && premio.equals(Premios.QUINTAOPCION)) {
                cliente.setPremioCandyBar(premio.getDescripcion());
            }
            if (clientePuntosTotales >= puntosPremio && premio.equals(Premios.SEXTAOPCION)) {
                cliente.setPremioCandyBar(premio.getDescripcion());
            }
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
