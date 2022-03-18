package ServicioAlCliente;

import java.util.ArrayList;

public enum Premios {
    PRIMERAOPCION (500, "1 BOLETO DE REGALO"),
    SEGUNDAOPCION (950,"2 BOLETOS DE REGALO"),
    TERCERAOPCION(1350,"3 BOLETOS DE REGALO"),
    CUARTAOPCION (500,"UNA PORCION GRANDE DE PIPOCAS"),
    QUINTAOPCION(950,"UN COMBO GRANDE DE PIPOCAS Y DOS REFRESCOS MEDIANOS MAS UNA GORRA DEL CINE"),
    SEXTAOPCION(1350,"UN COMBO GRANDE DE PIPOCAS Y DOS REFRESCOS MEDIANOS MAS UNA POLERA DEL CINE");

    private final int puntos;
    private  final String descripcion;


    private Premios(int puntos, String descripcion){
        this.puntos = puntos;
        this.descripcion=descripcion;

    }



    public int getPuntosPremio(){
        return puntos;
    }
    public String getDescripcion(){return descripcion;}


}
