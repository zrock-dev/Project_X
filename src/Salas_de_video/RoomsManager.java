package Salas_de_video;

import Registro.Cliente;
import Valores_Constantes.Constants;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static Console_interaction.Utils.*;

public class RoomsManager {

    Map<String, Sala> roomsMap = new HashMap<>();

    public RoomsManager(){ // Todos los metodos que estan aqui necesitan encapsulacion.
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
        String[] roomsCodes = Utils.generarAbc(Constants.NUMERO_SALAS);
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
        roomsMap.get("A").setCapacidadAsientos(Constants.GRANDE);
        roomsMap.get("B").setCapacidadAsientos(Constants.GRANDE);
        roomsMap.get("C").setCapacidadAsientos(Constants.GRANDE);
        roomsMap.get("D").setCapacidadAsientos(Constants.MEDIANO);
        roomsMap.get("E").setCapacidadAsientos(Constants.MEDIANO);
        roomsMap.get("F").setCapacidadAsientos(Constants.PEQUENO);
        roomsMap.get("G").setCapacidadAsientos(Constants.PEQUENO);
    }

    public void showRoomSeatsAvailable(String codeRoom){
        subheader("Available seats for Sala" + codeRoom);
        for (int i = 1; i <= 10; i++) {
            System.out.print("\t" + i + " ");
        }
        System.out.print("\n");

        Sala sala = roomsMap.get(codeRoom);
        Map<String, ArrayList<Seat>> seatsRoom = sala.getButacasMap();
        int letter = 0;
        for (ArrayList<Seat> seatsColumn:
             seatsRoom.values()) {
            System.out.print((char) (65 + letter) + "|");
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
            System.out.println("|" + "\t|-------|");
        }
    }

    public ArrayList<String> getSeatsCodes(String salaCode){
        showRoomSeatsAvailable(salaCode);
        showSimpleLine();
        String option = "Y";
        ArrayList<String> seatsClient = new ArrayList<>();
        while (option.equals("Y")){
            System.out.print("Please insert the code of your Seat: ");
            seatsClient.add(sn.next());
            System.out.print("Do you want to buy another seat: Y/N: "); option = sn.next();
        }
        return seatsClient;
    }

    public int buySeats(String roomCode, String fullNameClient){
        //   A         1
        //letter ; number

        Sala sala = roomsMap.get(roomCode);
        ArrayList<String> seatCodes = getSeatsCodes(sala.codigoSala);  // Obtain user seats
        Map<String, ArrayList<Seat>> seatsInRoom = sala.getButacasMap();
        for (String seatCodeClient:
                seatCodes) {
            String columCode = String.valueOf(seatCodeClient.charAt(0)); // also seatCodeClient
            String aux = String.valueOf(seatCodeClient.split(columCode)[1]);
            int numberCode  = Integer.parseInt(aux) - 1;

            ArrayList<Seat> columSeats = seatsInRoom.get(columCode);
            Seat seatUnit = columSeats.get(numberCode);
            if (seatUnit.getCode().equals(seatCodeClient) && !seatUnit.isOccupied()){
                seatUnit.setReservedUserName(fullNameClient);
                seatUnit.reserve();
            }else if (seatUnit.isOccupied()){
                System.out.println("Seat: " + seatCodeClient + " already reserved");
            }
        }
        sala.setAsientosVendidos(seatCodes.size());
        return seatCodes.size();
    }
}
