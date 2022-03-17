import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoleteriaTest {
    Boleteria boleteria = new Boleteria("ElCine");
    @Test
    public void showCarteleraTest(){
        boleteria.crearSalas(7);
        boleteria.setCapacidadSalas();
        boleteria.showCartelera();
    }

    @Test
    public void registrarClienteTest(){
        boleteria.registrarCliente(1312, "Pepe Ano", "Peru Ano", "23/12/2001");
        int mapClientesSize = boleteria.registroClientes.size();
        assertEquals(1, mapClientesSize);
    }

    @Test
    public void comprarBoletoNormal(){
        Cliente cliente = new Cliente(1312, "Pepe Ano", "Peru Ano", "23/12/2001");
        boleteria.elegirModoPresentacion(Boleteria.ModoPresentacion.BIDIMENSIONAL);
        assertEquals(40, boleteria.getPrecioPelicula());

        //Tarjeta
        assertEquals(40, boleteria.getPrecioPelicula());
    }

    @Test
    public void testComprarBoletoSinCI() {
        Sala sala = new Sala("5");
        boleteria.comprarBoletoSinCI(Boleteria.MetodoPago.TARJETA,3, "B", sala.codigoSala, Semana.JUEVES,"Victor Cespedes","16/06/2004", Boleteria.ModoPresentacion.BIDIMENSIONAL);
        assertEquals(105,boleteria.getPrecioPelicula());
    }
}