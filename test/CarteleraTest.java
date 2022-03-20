import Salas_de_video.Cartelera;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CarteleraTest {
    Cartelera car = new Cartelera();
    @Test
    public void testCartelara(){
        car.añadirPelicula("Spider Man","2 H");
        car.añadirPelicula("Your Name","1 : 30 min");
        car.getPeliculas("Your Name").añadirGenero("Animacion");
        car.añadirPelicula("Peli random","1 H");

        assertEquals(3,car.getCantidadPelis());
        assertEquals(1,car.getPeliculas("Your Name").getGeneros().size());
        assertEquals(null,car.getPeliculas("Avatar"));
        car.eliminarPelicula("Peli random");
        assertEquals(2,car.getCantidadPelis());
    }
}

