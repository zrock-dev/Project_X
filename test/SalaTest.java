import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SalaTest {
    Sala sala = new Sala("A");

    @Test
    void llenarCarteleraSalaTest() {
        sala.llenarCarteleraSala();
        int carteleraSize = sala.getCarteleraSala().length;
        assertEquals(5, carteleraSize);
    }

    @Test
    void generarButacasTest() {

        sala.generarButacas();
        int capacidad=100;
        int cantidadFilas = 10;
        int columnas = capacidad/cantidadFilas;
        assertEquals(10,columnas);
    }

    @Test
    void reservarButacasTest() {
        sala.setCapacidad(100);
        sala.generarButacas();
        sala.reservarButacas("D", 8);
        assertEquals(8, sala.butacas.get("D"));
    }
}