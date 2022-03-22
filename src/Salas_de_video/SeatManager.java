package Salas_de_video;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class SeatManager {
    private int rowQuantity = 10;

    void fillRooms(Collection<Sala> roomsAvailable){
        for (Sala sala:
             roomsAvailable) {
            populateRoom(sala);
        }
    }

    // fill room with unreserved seats.
    void populateRoom(Sala sala){
        Map<String, ArrayList<Seat>> seatsTemp = new HashMap<>();
        int seatsCapacity = sala.capacidadAsientos;
        int columnsQuantity = seatsCapacity / rowQuantity;
        String[] columnCodes = Utils.generarAbc(columnsQuantity);
        // key = "A", value: ArrayList<"A1", "A2", "A3",....,"A10">

        for (String columCode:
             columnCodes) {
            ArrayList<Seat> rowSeats = new ArrayList<>();

            // Populate rows of a column
            for (int numCodeSeat = 0; numCodeSeat < rowQuantity ; numCodeSeat++) {
                Seat seat = new Seat(columCode + (numCodeSeat +1));
                rowSeats.add(seat);
            }

            seatsTemp.put(columCode, rowSeats);
        }
        sala.setButacasMap(seatsTemp);
    }
}
