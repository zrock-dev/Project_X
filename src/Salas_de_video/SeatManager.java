package Salas_de_video;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class SeatManager {
    // key = "A", value: ArrayList<"A1", "A2", "A3",....,"A10">
    Collection<Sala> roomsAvailable;
    int rowQuantity = 10;

    public SeatManager() {
        roomsAvailable = new ArrayList<>();
    }

    public void fillRooms(Collection<Sala> roomsAvailable){
        for (Sala sala:
             roomsAvailable) {
            populateRoom(sala);
        }
    }

    // fill room with unreserved seats.
    public void populateRoom(Sala sala){
        Map<String, ArrayList<String>> seatsTemp = new HashMap<>();
        int seatsCapacity = sala.getCapacidad();
        int columnsQuantity = seatsCapacity / rowQuantity;
        String[] columnCodes = Utils.generarAbc(columnsQuantity);

        for (String columCode:
             columnCodes) {
            ArrayList<String> rowSeats = new ArrayList<>();

            // Populate rows of a column
            for (int numCodeSeat = 0; numCodeSeat < rowQuantity ; numCodeSeat++) {
                rowSeats.add(columCode + (numCodeSeat +1));
            }

            seatsTemp.put(columCode, rowSeats);
        }
        sala.setButacasMap(seatsTemp);
    }
}
