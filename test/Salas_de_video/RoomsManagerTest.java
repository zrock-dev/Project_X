package Salas_de_video;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomsManagerTest {

    @Test
    public void roomsTest(){
        RoomsManager manager = new RoomsManager();
        manager.generateRooms(7);
        assertEquals(7, manager.roomsMap.size());
        manager.setRoomsCapacity();
    }

}