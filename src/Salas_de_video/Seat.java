package Salas_de_video;

public class Seat {
    String code;
    boolean occupied; // true = occupied

    public Seat(String code) {
        this.code = code;
        occupied = false;
    }

    public void reserve() {
        this.occupied = !occupied;
    }

    public String getCode() {
        return code;
    }

    public boolean isOccupied() {
        return occupied;
    }
}
