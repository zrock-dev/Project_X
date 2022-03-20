package Salas_de_video;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomsManagerTest {
    RoomsManager manager = new RoomsManager();

    public void fillData(){
        manager.generateRooms(7);
        assertEquals(7, manager.roomsMap.size());
        manager.setRoomsCapacity();
    }

    @Test
    public void showSeatsSala(){
        fillData();
        Sala sala = manager.getSala("G");
        manager.showRoomSeats(sala.codigoSala);
        assertEquals(5, sala.getButacasMap().size());
    }

}