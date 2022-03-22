package Salas_de_video;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class RoomsManager {
    final int LARGEROOMSIZE = 100;
    final int MEDIUMROOMSIZE = 80;
    final int SMALLROOMSIZE = 50;
    final int ROOMSQUANTITY = 7;

    Map<String, Sala> roomsMap = new HashMap<>();

    public RoomsManager(){
        generateRooms(ROOMSQUANTITY);
        setRoomsCapacity();
        populateRooms();
    }

    public Sala getSala(String roomCode){
        return roomsMap.get(roomCode);
    }

    void generateRooms(int roomsAmount){
        String[] roomsCodes = Utils.generarAbc(roomsAmount);
        for (String letterCode:
             roomsCodes) {
            Sala sala = new Sala(letterCode);
            // Sala con asientos.
            roomsMap.put(letterCode, sala);
        }
        setRoomsCapacity();
        populateRooms();
    }

    void populateRooms(){
        Collection<Sala> listRooms =  roomsMap.values();
        SeatManager seatManager = new SeatManager();
        seatManager.fillRooms(listRooms);
    }

    void setRoomsCapacity(){
        roomsMap.get("A").setCapacidad(LARGEROOMSIZE);
        roomsMap.get("B").setCapacidad(LARGEROOMSIZE);
        roomsMap.get("C").setCapacidad(LARGEROOMSIZE);
        roomsMap.get("D").setCapacidad(MEDIUMROOMSIZE);
        roomsMap.get("E").setCapacidad(MEDIUMROOMSIZE);
        roomsMap.get("F").setCapacidad(SMALLROOMSIZE);
        roomsMap.get("G").setCapacidad(SMALLROOMSIZE);
    }

    public void showRoomSeatsAvailable(String codeRoom){
        Sala sala = roomsMap.get(codeRoom);
        Map<String, ArrayList<Seat>> seatsRoom = sala.butacasMap;

        for (ArrayList<Seat> seatsColumn:
             seatsRoom.values()) {
            for (Seat seat:
                 seatsColumn) {
                if (!seat.isOccupied()){
                    String codeSeat = seat.CODE;
                    System.out.print(codeSeat + ", ");
                }else {
                    System.out.print("XX" + ", ");
                }
            }
            System.out.println(" ");
        }
    }

    public void buySeats(String roomCode, String[] seatCodes, String fullNameClient){
        //   A         1
        //letter ; number

        Sala sala = roomsMap.get(roomCode);
        Map<String, ArrayList<Seat>> seatsInRoom = sala.butacasMap;
        for (String seatCodeClient:
                seatCodes) {
            String columCode = String.valueOf(seatCodeClient.charAt(0)); // also seatCode
            String aux = String.valueOf(seatCodeClient.split(columCode)[1]);
            int numberCode  = Integer.parseInt(aux) - 1;

            ArrayList<Seat> columSeats = seatsInRoom.get(columCode);
            Seat seatUnit = columSeats.get(numberCode);
            if (seatUnit.CODE.equals(seatCodeClient) && !seatUnit.isOccupied()){
                seatUnit.setReservedUserName(fullNameClient);
                seatUnit.reserve();
            }else if (seatUnit.isOccupied()){
                System.out.println("Seat: " + seatCodeClient + " already reserved");
            }
        }
    }
}
