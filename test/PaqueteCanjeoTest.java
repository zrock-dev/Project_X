import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PaqueteCanjeoTest {
    @Test
    public void BoletoPremioTest(){
        Cliente cliente = new Cliente(10101010,"Diego Figueroa", "Europeo xd", "19/01/2002");
        cliente.setPuntosTotales(500);

        assertEquals(cliente.canjear(cliente, Cliente.Premio.BOLETO,1),"+1 boleto");

    }
    @Test
    public void PipocasPremioTest(){
        Cliente cliente = new Cliente(10101010,"Diego Figueroa", "Europeo xd", "19/01/2002");
        cliente.setPuntosTotales(100000);


        assertEquals(cliente.canjear(cliente, Cliente.Premio.PREMIOS,3),"Pipocas grande" + "1 refresco grande" + "Polera oficial");
    }
}
