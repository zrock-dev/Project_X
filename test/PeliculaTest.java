import Salas_de_video.Pelicula;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class PeliculaTest {

    Pelicula peli =new Pelicula("Los vengadores","1:30 min");

    @Test
    public void testGeneros(){
        peli.añadirGenero("Accion");
        assertEquals(1,peli.getGeneros().size());
        assertEquals("Accion",peli.getGeneros().get(0));

        peli.quitarGenero("Accion");
        assertEquals(0,peli.getGeneros().size());
    }

    @Test
    public void testDescripcion(){
        String descripcion="super heroes salvando New York de una invasion alienigena";
        peli.setDescripcion(descripcion);
        assertEquals(descripcion,peli.getDescripcion());
        assertEquals("super heroes salvando New York de una invasion alienigena",peli.getDescripcion());

        peli.modificarDescripcion("super heroes salvan al mundo de extraterrestres");
        assertFalse(descripcion.equals(peli.getDescripcion()));
        assertEquals("super heroes salvan al mundo de extraterrestres",peli.getDescripcion());
    }

    @Test
    public void testNombre(){
        peli.modificarNombre("The Avergers");
        assertEquals("The Avergers",peli.getNombre());
    }

    @Test
    public void testDuracion(){
        peli.modificarDuracion("2 H");
        assertEquals("2 H",peli.getDuracion());
    }
}

