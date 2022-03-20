package Salas_de_video;

import org.junit.jupiter.api.Test;

class SeatManagerTest {
    Sala sala = new Sala("A");
    SeatManager seatManager = new SeatManager(sala);

    @Test
    public void populateRoom100(){
        sala.setCapacidad(100);
        seatManager.populateRoom();
    }

    @Test
    public void populateRoom80(){
        sala.setCapacidad(80);
        seatManager.populateRoom();
    }

    @Test
    public void populateRoom50(){
        sala.setCapacidad(50);
        seatManager.populateRoom();
    }
}