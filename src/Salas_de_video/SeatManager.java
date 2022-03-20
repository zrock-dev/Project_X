package Salas_de_video;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SeatManager {
    // key = "A", value: ArrayList<"A1", "A2", "A3",....,"A10">
    Map<String, ArrayList<String>> seatsTemp;
    Sala sala;
    int rowQuantity = 10;

    public SeatManager(Sala sala) {
        seatsTemp = new HashMap<>();
        this.sala = sala;
    }

    // fill room with unreserved seats.
    public void populateRoom(){
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
            System.out.println(rowSeats);
        }
        sala.setButacasMap(seatsTemp);
    }
}
