import Salas_de_video.Sala;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SalaTest {
    Sala sala = new Sala("A");

    @Test
    void llenarCarteleraSalaTest() {
        sala.llenarCarteleraSala();
        int carteleraSize = sala.getCarteleraSala().length;
        assertEquals(5, carteleraSize);
    }
}