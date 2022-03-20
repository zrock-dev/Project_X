package Salas_de_video;

public class Seat {
    String code;
    String reservedUserName;
    boolean occupied; // true = occupied

    public Seat(String code) {
        this.code = code;
        occupied = false;
    }

    public void setReservedUserName(String reservedUserName) {
        this.reservedUserName = reservedUserName;
    }

    public void reserve() {
        this.occupied = true;
    }

    public String getCode() {
        return code;
    }

    public boolean isOccupied() {
        return occupied;
    }
}
