package Salas_de_video;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class RoomsManager {
    int largeRoomSize = 100;
    int mediumRoomSize = 80;
    int smallRoomSize = 50;
    int roomsQuantity = 7;

    Map<String, Sala> roomsMap = new HashMap<>();

    public RoomsManager(){ // Todos los metodos que estan aqui necesitan encapsulacion.
        generateRooms(roomsQuantity);
        setRoomsCapacity();
        populateRooms();
    }

    public Map<String, Sala> getRoomsMap() {
        return roomsMap;
    }

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
        roomsMap.get("A").setCapacidadAsientos(largeRoomSize);
        roomsMap.get("B").setCapacidadAsientos(largeRoomSize);
        roomsMap.get("C").setCapacidadAsientos(largeRoomSize);
        roomsMap.get("D").setCapacidadAsientos(mediumRoomSize);
        roomsMap.get("E").setCapacidadAsientos(mediumRoomSize);
        roomsMap.get("F").setCapacidadAsientos(smallRoomSize);
        roomsMap.get("G").setCapacidadAsientos(smallRoomSize);
    }

    public void showRoomSeatsAvailable(String codeRoom){
        Sala sala = roomsMap.get(codeRoom);
        Map<String, ArrayList<Seat>> seatsRoom = sala.getButacasMap();

        for (ArrayList<Seat> seatsColumn:
             seatsRoom.values()) {
            for (Seat seat:
                 seatsColumn) {
                if (!seat.isOccupied()){
                    String codeSeat = seat.getCode();
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
        int seatsAmount = 0;
        Map<String, ArrayList<Seat>> seatsInRoom = sala.getButacasMap();
        for (String seatCode:
                seatCodes) {
            seatsAmount++;
            String columCode = String.valueOf(seatCode.charAt(0)); // also seatCode
            String aux = String.valueOf(seatCode.split(columCode)[1]);
            int numberCode  = Integer.parseInt(aux) - 1;

            ArrayList<Seat> columSeats = seatsInRoom.get(columCode);
            Seat seatUnit = columSeats.get(numberCode);
            if (seatUnit.getCode().equals(seatCode) && !seatUnit.isOccupied()){
                seatUnit.setReservedUserName(fullNameClient);
                seatUnit.reserve();
            }else if (seatUnit.isOccupied()){
                System.out.println("Seat: " + seatCode + " already reserved");
            }
        }
        sala.setAsientosVendidos(seatsAmount);
    }
}
