package Salas_de_video;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SeatManagerTest {
    Sala sala = new Sala("A");
    SeatManager seatManager = new SeatManager();

    @Test
    public void populateRoom100(){
        sala.setCapacidadAsientos(100);
        seatManager.populateRoom(sala);
        assertEquals(10, sala.getButacasMap().size());
    }

    @Test
    public void populateRoom80(){
        sala.setCapacidadAsientos(80);
        seatManager.populateRoom(sala);
        assertEquals(8, sala.getButacasMap().size());
    }

    @Test
    public void populateRoom50(){
        sala.setCapacidadAsientos(50);
        seatManager.populateRoom(sala);
        assertEquals(5, sala.getButacasMap().size());
    }
}