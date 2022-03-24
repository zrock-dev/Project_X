import Area_Cliente.Cliente;
import org.junit.jupiter.api.Test;

class ClienteTest {
    @Test
    public void testClient(){
        Cliente cliente = new Cliente("13120697", "Juan perez", "Peruano",
                "04/02/2001");
        System.out.println(cliente.getEdad());
        System.out.println(cliente.getCi());
    }

}