import Area_de_compras.Boleteria;
import Area_de_compras.MetodoPago;
import Area_de_compras.ModoPresentacion;
import Area_de_compras.Semana;
import Registro.Cliente;
import Registro.RegistradoraClientes;
import Salas_de_video.Pelicula;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

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
    public void testComprarBoletoSinCI() {
        Pelicula pelicula = new Pelicula("PEPPA PIG", "2 horas", "Un cerdo que habla", 10);
        pelicula.setGeneros("Animacion");
        String[] seats = {"A2","C3","A4"};
        boleteria.comprarBoleto(MetodoPago.TARJETA,"A",seats,Semana.JUEVES,ModoPresentacion.BIDIMENSIONAL,"Paco","16/06/2018",pelicula);

        assertEquals(102,boleteria.getPrecioTotal());
    }

    @Test
    public void testComprarBoleto(){
        Pelicula pelicula = new Pelicula("PEPPA PIG", "2 horas", "Un cerdo que habla", 10);
        pelicula.setGeneros("Accion");
        String[] seats = {"A2","C3","A4"};
        boleteria.comprarBoleto(MetodoPago.TARJETA,"A",seats,Semana.JUEVES,ModoPresentacion.BIDIMENSIONAL,"Paco","16/06/2018",pelicula);
        assertEquals(105, boleteria.getPrecioTotal());
    }


}