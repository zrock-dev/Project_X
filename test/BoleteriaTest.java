import Area_de_compras.Boleteria;
import Area_de_compras.ModoPresentacion;
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

}