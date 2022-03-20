import Salas_de_video.Pelicula;
import Salas_de_video.Sala;
import Salas_de_video.Utils;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SalaTest {
    Sala sala = new Sala("A");

    @Test
    void llenarCarteleraSalaTest() {
        Pelicula pelicula = new Pelicula("THE BATMAN","3 horas","Un perro vestido de negro q golpea a los malos", 10);
        sala.setCapacidad(100);
        sala.llenarCarteleraSala(pelicula);
        int carteleraSize = sala.getCarteleraSala().size();
        assertEquals(1, carteleraSize);
    }
    @Test
    void LlenarSalaconPeliculaIncorrecta(){
        //QUE PASA SI QUEREMOS PONER UNA PELICULA DE CALIFICACION 10 A UNA SALA DE 50? NO DEBERIA INSERTARSE LA PELICULA
        Pelicula pelicula = new Pelicula("THE BATMAN","3 horas","Un perro vestido de negro q golpea a los malos", 10);
        sala.setCapacidad(50);
        sala.llenarCarteleraSala(pelicula);
        int carteleraSize = sala.getCarteleraSala().size();
        assertEquals(0, carteleraSize);
    }
    @Test
    void mostrarListaPeliculas(){
        Pelicula pelicula = new Pelicula("THE BATMAN","3 horas","Un perro vestido de negro q golpea a los malos", 10);
        Pelicula pelicula2 = new Pelicula("PEPPA PIG","3 horas","Un perro vestido de negro q golpea a los malos", 10);
        Pelicula pelicula3 = new Pelicula("SPIDERMAN","3 horas","Un perro vestido de negro q golpea a los malos", 10);
        Pelicula pelicula4 = new Pelicula("DIEGO XD","3 horas","Un perro vestido de negro q golpea a los malos", 10);
        Pelicula pelicula5 = new Pelicula("ENCANTO","3 horas","Un perro vestido de negro q golpea a los malos", 10);
        Sala sala = new Sala("X");
        sala.setCapacidad(100);
        sala.llenarCarteleraSala(pelicula);
        sala.llenarCarteleraSala(pelicula2);
        sala.llenarCarteleraSala(pelicula3);
        sala.llenarCarteleraSala(pelicula4);
        sala.llenarCarteleraSala(pelicula5);

        ArrayList<String> respuesta = new ArrayList<>();
        respuesta.add("THE BATMAN");
        respuesta.add("PEPPA PIG");
        respuesta.add("SPIDERMAN");
        respuesta.add("DIEGO XD");
        respuesta.add("ENCANTO");

        assertEquals(Utils.listaPeliculas(sala),respuesta);
    }
}