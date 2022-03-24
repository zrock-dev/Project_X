package Salas_de_video;

import Area_Cliente.Cliente;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class RoomsManagerTest {
    RoomsManager manager = new RoomsManager();
    Cliente cliente = new Cliente("10101001", "DIEGO FIGUEROA", "Boliviano",
            "03/01/2018");

    @Test
    public void showSeatsSala(){
        Sala sala = manager.getSala("G");
        manager.showRoomSeatsAvailable(sala.codigoSala);
        assertEquals(5, sala.getButacasMap().size());
    }

    @Test
    public void buySeatTest(){
        ArrayList<String> seats = new ArrayList<>();
        seats.add("A1");
        seats.add("B2");
        seats.add("C3");
        seats.add("D4");
        Sala sala = manager.getSala("G");
        String fullName = cliente.getFullName();
        //Available seats
        manager.showRoomSeatsAvailable(sala.codigoSala);

        System.out.println("\n");
//        manager.buySeats("G", seats, fullName);

        //Available seats
        manager.showRoomSeatsAvailable(sala.codigoSala);

        System.out.println("\n");
//        manager.buySeats("G", seats, fullName);
    }

}
