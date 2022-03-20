package Salas_de_video;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class RoomsManager {
    int largeRoomSize = 100;
    int mediumRoomSize = 80;
    int smallRoomSize = 50;

    Map<String, Sala> roomsMap = new HashMap<>();

    public Sala getSala(String roomCode){
        return roomsMap.get(roomCode);
    }

    public void generateRooms(int roomsAmount){
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

    public void populateRooms(){
        Collection<Sala> listRooms =  roomsMap.values();
        SeatManager seatManager = new SeatManager();
        seatManager.fillRooms(listRooms);
    }

    public void setRoomsCapacity(){
        roomsMap.get("A").setCapacidad(largeRoomSize);
        roomsMap.get("B").setCapacidad(largeRoomSize);
        roomsMap.get("C").setCapacidad(largeRoomSize);
        roomsMap.get("D").setCapacidad(mediumRoomSize);
        roomsMap.get("E").setCapacidad(mediumRoomSize);
        roomsMap.get("F").setCapacidad(smallRoomSize);
        roomsMap.get("G").setCapacidad(smallRoomSize);
    }

    public void showRoomSeats(String codeRoom){
        Sala sala = roomsMap.get(codeRoom);
        Map<String, ArrayList<String>> seatsRoom = sala.getButacasMap();
        for (ArrayList<String> columnSeats:
             seatsRoom.values()) {
            System.out.println(columnSeats);
        }
    }
}
