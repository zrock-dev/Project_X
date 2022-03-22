package ServicioAlCliente;

import Registro.Cliente;

public class CanjearPromo {

    public static void canjear(Premios premio,Cliente cliente){

        int  puntosPremio = premio.PUNTOS;
        int clientePuntosTotales = cliente.getPuntosTotales();

        switch (premio.TIPO) {
            case ("boleto"):

                if (clientePuntosTotales >= puntosPremio && premio.equals(Premios.PRIMERAOPCION)) {
                    cliente.setCantidadTicketsGratis(1);
                    cliente.canjearPuntos(premio.PUNTOS);
                }
                if (clientePuntosTotales >= puntosPremio && premio.equals(Premios.SEGUNDAOPCION)) {
                    cliente.setCantidadTicketsGratis(2);
                    cliente.canjearPuntos(premio.PUNTOS);
                }
                if (clientePuntosTotales >= puntosPremio && premio.equals(Premios.TERCERAOPCION)) {
                    cliente.setCantidadTicketsGratis(3);
                    cliente.canjearPuntos(premio.PUNTOS);
                }

            case ("candybar"):
            if (clientePuntosTotales >= puntosPremio && premio.equals(Premios.CUARTAOPCION)) {
                cliente.setPremioCandyBar(premio.DESCRIPCION);
            }
            if (clientePuntosTotales >= puntosPremio && premio.equals(Premios.QUINTAOPCION)) {
                cliente.setPremioCandyBar(premio.DESCRIPCION);
            }
            if (clientePuntosTotales >= puntosPremio && premio.equals(Premios.SEXTAOPCION)) {
                cliente.setPremioCandyBar(premio.DESCRIPCION);
            }
        }
    }
}
