import Salas_de_video.Pelicula;
import Salas_de_video.Sala;
import org.junit.jupiter.api.Test;

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
}