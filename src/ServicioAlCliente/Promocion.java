package ServicioAlCliente;

import Registro.Cliente;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Promocion {

    public static void canjearPremio(Premios premio,Cliente cliente){

        switch (premio.getTipo()) {
            case ("boleto"):

                if (cliente.getPuntosTotales() >= premio.getPuntosPremio() && premio.equals(Premios.PRIMERAOPCION)) {
                    cliente.setCantidadTicketsGratis(1);
                    cliente.canjearPuntos(premio.getPuntosPremio());
                }
                if (cliente.getPuntosTotales() >= premio.getPuntosPremio() && premio.equals(Premios.SEGUNDAOPCION)) {
                    cliente.setCantidadTicketsGratis(2);
                    cliente.canjearPuntos(premio.getPuntosPremio());
                }
                if (cliente.getPuntosTotales() >= premio.getPuntosPremio() && premio.equals(Premios.TERCERAOPCION)) {
                    cliente.setCantidadTicketsGratis(3);
                    cliente.canjearPuntos(premio.getPuntosPremio());
                }

            case ("candybar"):
            if (cliente.getPuntosTotales() >= premio.getPuntosPremio() && premio.equals(Premios.CUARTAOPCION)) {
                cliente.setPremioCandyBar(premio.getDescripcion());
            }
            if (cliente.getPuntosTotales() >= premio.getPuntosPremio() && premio.equals(Premios.QUINTAOPCION)) {
                cliente.setPremioCandyBar(premio.getDescripcion());
            }
            if (cliente.getPuntosTotales() >= premio.getPuntosPremio() && premio.equals(Premios.SEXTAOPCION)) {
                cliente.setPremioCandyBar(premio.getDescripcion());
            }
        }
    }


    /*public static Map<Integer, String>  listaPremios(){
        Map<Integer, String> premios = new ;
        premios.put(Premios.PRIMERAOPCION.getPuntosPremio(),Premios.PRIMERAOPCION.getDescripcion());
        premios.put(Premios.SEGUNDAOPCION.getPuntosPremio(),Premios.SEGUNDAOPCION.getDescripcion());
        premios.put(Premios.TERCERAOPCION.getPuntosPremio(),Premios.TERCERAOPCION.getDescripcion());
        premios.put(Premios.CUARTAOPCION.getPuntosPremio(),Premios.CUARTAOPCION.getDescripcion());
        premios.put(Premios.QUINTAOPCION.getPuntosPremio(),Premios.QUINTAOPCION.getDescripcion());
        premios.put(Premios.SEXTAOPCION.getPuntosPremio(),Premios.SEXTAOPCION.getDescripcion());

        return premios;*/





}
