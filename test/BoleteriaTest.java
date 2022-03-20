import Area_de_compras.Boleteria;
import Area_de_compras.MetodoPago;
import Area_de_compras.ModoPresentacion;
import Area_de_compras.Semana;
import Registro.Cliente;
import Registro.RegistradoraClientes;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoleteriaTest {
    Boleteria boleteria = new Boleteria("ElCine");

    @Test
    public void comprarBoletoNormal(){
        Cliente cliente = new Cliente(1312, "Pepe Ano", "Peru Ano", "23/12/2001");
        boleteria.elegirModoPresentacion(ModoPresentacion.BIDIMENSIONAL);
        assertEquals(40, boleteria.getPrecioPelicula());

        //Tarjeta
        assertEquals(40, boleteria.getPrecioPelicula());
    }

    @Test
    public void testComprarBoletoSinCI(){
        boleteria.comprarBoletoSinCI(MetodoPago.TARJETA,"B","A", 2, Semana.MIERCOLES,ModoPresentacion.BIDIMENSIONAL,"Paco","16/06/2000","Accion");
        assertEquals(40,boleteria.getPrecioTotal());

        boleteria.comprarBoletoSinCI(MetodoPago.TARJETA,"B","A", 3,Semana.JUEVES,ModoPresentacion.TRIDIMENSIONAL,"Paco","16/06/2000","Accion");
        assertEquals(132,boleteria.getPrecioTotal());

        boleteria.comprarBoletoSinCI(MetodoPago.EFECTIVO,"B","A", 4,Semana.LUNES,ModoPresentacion.BIDIMENSIONAL,"Paco","16/06/2000","Accion");
        assertEquals(160,boleteria.getPrecioTotal());
    }
}