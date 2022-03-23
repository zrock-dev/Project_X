package Salas_de_video;

public class Seat {
    final String CODE;
    private String reservedUserName;
    private boolean occupied; // true = occupied

    public Seat(String code) {
        this.CODE = code;
        occupied = false;
    }

    void setReservedUserName(String reservedUserName) {
        this.reservedUserName = reservedUserName;
    }

    void reserve() {
        this.occupied = true;
    }

    boolean isOccupied() {
        return occupied;
    }
}
