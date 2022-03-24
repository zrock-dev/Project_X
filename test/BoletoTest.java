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
        Pelicula pelicula = new Pelicula("THE BATMAN","3 horas","Un perro vestido de negro q golpea a los malos", 10);
        Boleto boleto = new Boleto(cliente, 40, pelicula);

        int points = boleto.aplicarDescuento(MetodoPago.TARJETA, Semana.JUEVES);
        cliente.sumarPuntos(points);
        assertEquals(35.2, boleto.precioPelicula);
        assertEquals(44, cliente.getPuntosTotales());

    }
    @Test
    public void testDescuentoAnimacionMenores(){
        Cliente cliente1 = new Cliente("10101001", "DIEGO FIGUEROA", "Boliviano",
                "03/01/2018");
        Pelicula pelicula = new Pelicula("PEPPA PIG","2 horas","Un cerdo que habla", 10);
        pelicula.setGeneros("Animacion");
        Boleto boleto1 = new Boleto(cliente1, 60, pelicula);

        int puntos = boleto1.aplicarDescuento(MetodoPago.EFECTIVO, Semana.DOMINGO);
        cliente1.sumarPuntos(puntos);
        assertEquals(51, boleto1.precioPelicula);
        assertEquals(42, cliente1.getPuntosTotales());
    }

    @Test
    public void testChoqueDescuento() {
        Cliente cliente2 = new Cliente("10101001", "DIEGO FIGUEROA", "Boliviano",
                "03/01/2018");
        Pelicula pelicula = new Pelicula("THE BATMAN","3 horas","Un perro vestido de negro q golpea a los malos", 10);
        Boleto boleto2 = new Boleto(cliente2, 60, pelicula);

        int puntos2 = boleto2.aplicarDescuento(MetodoPago.EFECTIVO, Semana.MIERCOLES);
        cliente2.sumarPuntos(puntos2);
        assertEquals(30, boleto2.precioPelicula);
        int puntos = cliente2.getPuntosTotales();
        assertEquals(25, puntos);
    }
}