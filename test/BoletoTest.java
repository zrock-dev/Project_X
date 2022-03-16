import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoletoTest {
        @Test
        public void testDescuentos(){
            Cliente cliente = new Cliente(10101001, "DIEGO FIGUEROA", "Boliviano", "03/01/2001");
            Sala sala = new Sala("5");
            Boleto boleto = new Boleto(cliente, 40, sala, "2D");

            //1
            boleto.aplicarDescuento(Boleteria.MetodoPago.TARJETA,Semana.JUEVES,boleto.tipoPelicula);
            assertEquals(35.2,boleto.precioPelicula);
            assertEquals(35,cliente.getPuntosTotales());


            //2
            Cliente cliente1 = new Cliente(10101001, "DIEGO FIGUEROA", "Boliviano", "03/01/2018");
            Sala sala1 = new Sala("6");
            Boleto boleto1 = new Boleto(cliente1, 40, sala1, "3D");
            boleto1.setGeneroPelicula("Animacion");

            boleto1.aplicarDescuento(Boleteria.MetodoPago.EFECTIVO,Semana.DOMINGO,boleto1.tipoPelicula);
            assertEquals(51,boleto1.precioPelicula);
            assertEquals(51,cliente1.getPuntosTotales());



        }
    }

