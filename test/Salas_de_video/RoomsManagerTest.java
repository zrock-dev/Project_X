package Salas_de_video;

import Registro.Cliente;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomsManagerTest {
    RoomsManager manager = new RoomsManager();
    Cliente cliente = new Cliente("10101001", "DIEGO FIGUEROA", "Boliviano",
            "03/01/2018");

    public void fillData(){
        manager.generateRooms(7);
        assertEquals(7, manager.roomsMap.size());
        manager.setRoomsCapacity();
    }

    @Test
    public void showSeatsSala(){
        fillData();
        Sala sala = manager.getSala("G");
        manager.showRoomSeatsAvailable(sala.codigoSala);
        assertEquals(5, sala.getButacasMap().size());
    }

    @Test
    public void buySeatTest(){
        String[] seats = {"A1", "B1", "E10"};
        Sala sala = manager.getSala("G");
        String fullName = cliente.getFullName();
        //Available seats
        manager.showRoomSeatsAvailable(sala.codigoSala);

        System.out.println("\n");
        manager.buySeats("G", seats, fullName);

        //Available seats
        manager.showRoomSeatsAvailable(sala.codigoSala);

        System.out.println("\n");
        manager.buySeats("G", seats, fullName);
    }

}
