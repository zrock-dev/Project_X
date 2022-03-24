package Salas_de_video;

import Valores_Constantes.Constants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import static Console_interaction.Utils.*;

public class RoomsManager implements Constants{

    Map<String, Sala> roomsMap = new HashMap<>();

    public RoomsManager(){
        generateRooms();
        setRoomsCapacity();
        populateRooms();
    }

    public Map<String, Sala> getRoomsMap() {
        return roomsMap;
    }

    public Sala getSala(String roomCode){
        return roomsMap.get(roomCode);
    }

    private void generateRooms(){
        String[] roomsCodes = Utils.generarAbc(NUMERO_SALAS);
        for (String letterCode:
             roomsCodes) {
            Sala sala = new Sala(letterCode);
            // Sala con asientos.
            roomsMap.put(letterCode, sala);
        }
    }

    private void populateRooms(){
        Collection<Sala> listRooms =  roomsMap.values();
        SeatManager seatManager = new SeatManager();
        seatManager.fillRooms(listRooms);
    }

    private void setRoomsCapacity(){
        roomsMap.get("A").setCapacidadAsientos(GRANDE);
        roomsMap.get("B").setCapacidadAsientos(GRANDE);
        roomsMap.get("C").setCapacidadAsientos(GRANDE);
        roomsMap.get("D").setCapacidadAsientos(MEDIANO);
        roomsMap.get("E").setCapacidadAsientos(MEDIANO);
        roomsMap.get("F").setCapacidadAsientos(PEQUENO);
        roomsMap.get("G").setCapacidadAsientos(PEQUENO);
    }

    public void showRoomSeatsAvailable(String codeRoom){
        subheader("Available seats for Sala - " + codeRoom);
        for (int i = 1; i <= 10; i++) {
            System.out.print("\t" + i + " ");
        }
        System.out.print("\n");

        Sala sala = roomsMap.get(codeRoom);
        Map<String, ArrayList<Seat>> seatsRoom = sala.getButacasMap();
        int letter = 0;
        for (ArrayList<Seat> seatsColumn:
             seatsRoom.values()) {
            System.out.print((char) (65 + letter) + " |");
            for (Seat seat:
                 seatsColumn) {
                if (!seat.isOccupied()){
                    String codeSeat = seat.getCode();
                    System.out.print(" _ " + " ");
                }else {
                    System.out.print(" R " + " ");
                }
            }
            letter++;
            System.out.println("|" + "\t|##########|");
        }
        showSimpleLine();
    }

    public ArrayList<String> getClientSeatsCodes(String salaCode){
        showRoomSeatsAvailable(salaCode);
        showSimpleLine();
        ArrayList<String> seatsClient = new ArrayList<>();
        showSimpleLine();
        System.out.println("How many seats do you want: "); int option = getOption();
        System.out.println("Please insert the code of your Seat: ");
        System.out.print("Seats: ");
        for (int addedSeat = 0; addedSeat < option; addedSeat++) {
            // seatsClient = A2
            seatsClient.add(sn.next());

            /*
 Needs work
            String lastAddedSeat  = seatsClient.get(addedSeat);
            if (seatsClient.contains(lastAddedSeat)){ // To prevent repeated items.
                System.out.println("Seat already added, try again.");
                seatsClient.remove(lastAddedSeat);
                // remove printed text
                continue;
            }
*/
            System.out.print(seatsClient + ", ");
        }
        return seatsClient;
    }

    public int buySeats(String roomCode){
        //   A         1
        //letter ; number

        Sala sala = roomsMap.get(roomCode);
        ArrayList<String> seatCodes = getClientSeatsCodes(sala.codigoSala);  // Obtain user seats
        Map<String, ArrayList<Seat>> seatsInRoom = sala.getButacasMap();
        for (String seatCodeClient:
                seatCodes) {
            String columCode = String.valueOf(seatCodeClient.charAt(0)); // also seatCodeClient
            String aux = String.valueOf(seatCodeClient.split(columCode)[1]);
            int numberCode  = Integer.parseInt(aux) - 1;

            ArrayList<Seat> columSeats = seatsInRoom.get(columCode);
            Seat seatUnit = columSeats.get(numberCode);
            if (seatUnit.getCode().equals(seatCodeClient) && !seatUnit.isOccupied()){
                seatUnit.reserve();
            }else if (seatUnit.isOccupied()){
                System.out.println("Seat: " + seatCodeClient + " already reserved");
            }
        }
        sala.setAsientosVendidos(seatCodes.size());
        return seatCodes.size();
    }
}
