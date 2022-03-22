package ServicioAlCliente;

import java.util.ArrayList;

public enum Premios {

    //PAQUETES DE BOLETOS
    PRIMERAOPCION (500, "1 BOLETO DE REGALO","boleto"),
    SEGUNDAOPCION (950,"2 BOLETOS DE REGALO","boleto"),
    TERCERAOPCION(1350,"3 BOLETOS DE REGALO","boleto"),

    //PAQUETES DEL CANDYBAR
    CUARTAOPCION (500,"UNA PORCION GRANDE DE PIPOCAS","candybar"),
    QUINTAOPCION(950,"UN COMBO GRANDE DE PIPOCAS Y DOS REFRESCOS MEDIANOS MAS UNA GORRA DEL CINE",
            "candybar"),
    SEXTAOPCION(1350,"UN COMBO GRANDE DE PIPOCAS Y DOS REFRESCOS MEDIANOS MAS UNA POLERA DEL CINE",
            "candybar");

    private final int puntos;
    private  final String descripcion;
    private final String tipo;

    Premios(int puntos, String descripcion, String tipo){
        this.puntos = puntos;
        this.descripcion=descripcion;
        this.tipo=tipo;
    }
}
