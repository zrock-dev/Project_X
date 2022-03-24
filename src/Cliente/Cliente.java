package Cliente;

import Clases_Padre.Persona;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Persona {
    int puntosTotales;
    int cantidadTicketsGratis;
    ArrayList<String> premioCandyBar;

    public Cliente(List<String> customerData){ // customerData = [ci, fullName, nationality, birthDate]
        super(customerData.get(0),customerData.get(1),customerData.get(2),customerData.get(3));
    }

    public Cliente(String ci, String fullName, String nacionalidad, String fechaNacimiento) {
        super(ci,fullName,nacionalidad,fechaNacimiento);
    }

    public Cliente( String fullName, String fechaNacimiento) {

        super(fullName,fechaNacimiento);
    }


    public void sumarPuntos(int cantidadSumar){
        puntosTotales = cantidadSumar + puntosTotales;
    }

    public int getPuntosTotales() {
        return puntosTotales;
    }

    public void setPuntosTotales(int puntos){this.puntosTotales=puntos;} //ESTA FUNCION LA USO PARA HACER UN TEST RAPIDO EN PromocionTest

    public void setCantidadTicketsGratis(int cantidadTicketsGratis) {
        this.cantidadTicketsGratis = cantidadTicketsGratis;
    }

    public void canjearPuntos(int puntosCanjeados){
        puntosTotales -= puntosCanjeados;
    }

    public void sumarTicketGratis(int cantidadTickets) {
        this.cantidadTicketsGratis += cantidadTickets;
    }

    public int getCantidadTicketsGratis() {
        return cantidadTicketsGratis;
    }

    public void usarTicketGratis(){
        cantidadTicketsGratis -= 1;
    }

    //ESTAS DOS FUNCIONES LAS USO PARA AGREGAR UN PREMIO DEL TIPO LITERAL (LAS DEL CANDYBAR) AL CLIENTE
    public void setPremioCandyBar(String premio){
        premioCandyBar.add(premio);
    }
    public ArrayList<String> getPremioCandyBar(){
        return premioCandyBar;
    }
}
