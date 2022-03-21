import Area_de_compras.Boleteria;
import Area_de_compras.Boleto;
import Area_de_compras.MetodoPago;
import Area_de_compras.Semana;
import Registro.Cliente;
import Registro.RegistradoraClientes;
import Salas_de_video.Pelicula;
import Salas_de_video.Sala;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoletoTest {
    
    @Test
    public void testDescuentosJuevesconTarjeta() {
        Cliente cliente = new Cliente("10101001", "DIEGO FIGUEROA", "Boliviano",
                "03/01/2001");
        Sala sala = new Sala("5");
        Pelicula pelicula = new Pelicula("THE BATMAN","3 horas","Un perro vestido de negro q golpea a los malos", 10);
        Boleto boleto = new Boleto(cliente, 40, sala,pelicula);


        boleto.aplicarDescuento(MetodoPago.TARJETA, Semana.JUEVES);
        assertEquals(35.2, boleto.precioPelicula);
        assertEquals(44, cliente.getPuntosTotales());

    }
    @Test
    public void testDescuentoAnimacionMenores(){
        Cliente cliente1 = new Cliente("10101001", "DIEGO FIGUEROA", "Boliviano",
                "03/01/2018");
        Sala sala1 = new Sala("6");
        Pelicula pelicula = new Pelicula("PEPPA PIG","2 horas","Un cerdo que habla", 10);
        pelicula.setGeneros("Animacion");
        Boleto boleto1 = new Boleto(cliente1, 60, sala1,pelicula);

        boleto1.aplicarDescuento(MetodoPago.EFECTIVO, Semana.DOMINGO);
        assertEquals(51, boleto1.precioPelicula);
        assertEquals(42, cliente1.getPuntosTotales());
    }

    @Test
    public void testChoqueDescuento() {
        Cliente cliente2 = new Cliente("10101001", "DIEGO FIGUEROA", "Boliviano",
                "03/01/2018");
        Sala sala2 = new Sala("6");
        Pelicula pelicula = new Pelicula("THE BATMAN","3 horas","Un perro vestido de negro q golpea a los malos", 10);
        Boleto boleto2 = new Boleto(cliente2, 60, sala2,pelicula);

        boleto2.aplicarDescuento(MetodoPago.EFECTIVO, Semana.MIERCOLES);
        assertEquals(30, boleto2.precioPelicula);
        assertEquals(25, cliente2.getPuntosTotales());
    }

//    @Test
//    public void clienteConTicketGratis(){
//        Boleteria boleteria = new Boleteria("Los Santos");
//       registradoraClientes.registrarCliente("10101001", "DIEGO FIGUEROA", "Boliviano",
//                "03/01/2018");
//        Pelicula pelicula = new Pelicula("THE BATMAN","3 horas","Un perro vestido de negro q golpea a los malos", 10);
//        Cliente cliente = registradoraClientes.getCliente(10101001);
//        String[] seats = {"D5", "H9", "A4"};
//        cliente.setCantidadTicketsGratis(3);
//        boleteria.comprarBoleto(10101001, MetodoPago.TARJETA , "A", seats,
//                Semana.DOMINGO,pelicula);
//
//        assertEquals(2, cliente.getCantidadTicketsGratis());
//    }



}