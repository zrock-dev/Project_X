import Registro.Cliente;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {
    @Test
    public void testClient(){
        Cliente cliente = new Cliente(13120697, "Juan perez", "Peruano",
                "04/02/2001");
        System.out.println(cliente.getEdad());
        System.out.println(cliente.getCi());

        Cliente clientesinCI = new Cliente("Paco","01/01/2000");
        assertEquals(22,clientesinCI.getEdad());
    }

}