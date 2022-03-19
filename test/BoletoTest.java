import Area_de_compras.Boleteria;
import Area_de_compras.Boleto;
import Area_de_compras.MetodoPago;
import Area_de_compras.Semana;
import Registro.Cliente;
import Registro.RegistradoraClientes;
import Salas_de_video.Sala;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoletoTest {
    @Test
    public void testDescuentosJuevesconTarjeta() {
        Cliente cliente = new Cliente(10101001, "DIEGO FIGUEROA", "Boliviano",
                "03/01/2001");
        Sala sala = new Sala("5");
        Boleto boleto = new Boleto(cliente, 40, sala);


        boleto.aplicarDescuento(MetodoPago.TARJETA, Semana.JUEVES);
        assertEquals(35.2, boleto.precioPelicula);
        assertEquals(44, cliente.getPuntosTotales());

    }
    @Test
    public void testDescuentoAnimacionMenores(){
        Cliente cliente1 = new Cliente(10101001, "DIEGO FIGUEROA", "Boliviano",
                "03/01/2018");
        Sala sala1 = new Sala("6");
        Boleto boleto1 = new Boleto(cliente1, 60, sala1);
        boleto1.setGeneroPelicula("Animacion");

        boleto1.aplicarDescuento(MetodoPago.EFECTIVO, Semana.DOMINGO);
        assertEquals(51, boleto1.precioPelicula);
        assertEquals(42, cliente1.getPuntosTotales());
    }

    @Test
    public void testChoqueDescuento() {
        Cliente cliente2 = new Cliente(10101001, "DIEGO FIGUEROA", "Boliviano",
                "03/01/2018");
        Sala sala2 = new Sala("6");
        Boleto boleto2 = new Boleto(cliente2, 60, sala2);
        boleto2.setGeneroPelicula("Animacion");

        boleto2.aplicarDescuento(MetodoPago.EFECTIVO, Semana.MIERCOLES);
        assertEquals(30, boleto2.precioPelicula);
        assertEquals(25, cliente2.getPuntosTotales());
    }

    @Test
    public void clienteConTicketGratis(){
        Boleteria boleteria = new Boleteria("Los Santos");
        RegistradoraClientes.registrarCliente(10101001, "DIEGO FIGUEROA", "Boliviano",
                "03/01/2018");
        Cliente cliente = RegistradoraClientes.getCliente(10101001);
        cliente.setCantidadTicketsGratis(3);
        boleteria.comprarBoleto(10101001, MetodoPago.TARJETA , "A", 4,
                "A", Semana.DOMINGO);

        assertEquals(2, cliente.getCantidadTicketsGratis());
    }

    @Test
    public void testDescuentoSinCI(){
        Boleto boleto = new Boleto(40);
        boleto.aplicarDescuentoSinCI(MetodoPago.TARJETA,Semana.JUEVES,"16/08/1999","Accion");
        assertEquals(35.2,boleto.precioPelicula);

        Boleto boleto2 = new Boleto(50);
        boleto2.aplicarDescuentoSinCI(MetodoPago.TARJETA,Semana.MIERCOLES,"12/03/2009","Animacion");
        assertEquals(25,boleto2.precioPelicula);
    }

}