import Salas_de_video.Cartelera;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CarteleraTest {
    Cartelera car = new Cartelera();
    @Test
    public void testCartelara(){
        car.añadirPelicula("Spider Man","2 H");
        car.añadirPelicula("Your Name","1 : 30 min");
        car.añadirPelicula("Peli random","1 H");

        assertEquals(3,car.getPeliculas().size());
        assertEquals("Your Name",car.getPeliculas().get(1).getNombre());

        car.eliminarPelicula("Peli random");
        assertEquals(2,car.getPeliculas().size());
    }
}

