package Salas_de_video;

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
            roomsMap.put(letterCode, sala);
        }
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

    public void showRoomSeats(){

    }
}
