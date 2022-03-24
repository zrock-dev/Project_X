package Valores_Constantes;

import Area_de_compras.Semana;

public interface Constants {
    /// Capacidad para las salas.
    int GRANDE = 100;
    int MEDIANO = 80;
    int PEQUENO = 50;


    // Nombre de la boleteria
    String NOMBRE_BOLETERIA = "Cine Center";

    // Cantidad de salas en el cine
    int NUMERO_SALAS = 7;

    // Dia de descuento
    Semana PROMO_DAY = Semana.MIERCOLES;

    //Dia nceseario para la promo de tarjeta
    Semana PROMO_DAY_TARJETA = Semana.JUEVES;

    //Cantidad de puntos por boleto comprado
    int PUNTOS_POR_BOLETO = 50;

    //Generos para las peliculas
    String[] GENEROS_PELICULA = {
            "Accion", "Animacion", "Ciencia Ficcion",
            "Comedia", "Drama", "Fantasia",
            "Musical", "Romance", "Suspenso",
            "Terror", "Documental"};

}
