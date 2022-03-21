package Registro;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    int puntosTotales;
    String ci, fullName, nacionalidad, fechaNacimiento;
    int cantidadTicketsGratis;
    ArrayList<String> premioCandyBar;
    // Fecha de nacimiento : 03/01/2001

    public Cliente(List<String> customerData){ // customerData = [ci, fullName, nationality, birthDate]
        this.ci = customerData.get(0);
        this.fullName = customerData.get(1);
        this.nacionalidad = customerData.get(2);
        this.fechaNacimiento = customerData.get(3);
    }


    public Cliente(String ci, String fullName, String nacionalidad, String fechaNacimiento) {
        this.ci = ci;
        this.fullName = fullName;
        this.nacionalidad = nacionalidad;
        this.fechaNacimiento = fechaNacimiento;
        premioCandyBar = new ArrayList<>();
    }

    public Cliente( String fullName,String fechaNacimiento) {
        this.fullName = fullName;
        this.fechaNacimiento = fechaNacimiento;
    }

    public void sumarPuntos(int cantidadSumar){
        puntosTotales = cantidadSumar + puntosTotales;
    }

    public String getCi() {
        return ci; // para la llave
    }

    public int getEdad() {  // edad del cliente
        return 2022 - Integer.parseInt(fechaNacimiento.split("/")[2]);
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

    public String getFullName() {
        return fullName;
    }

    //ESTAS DOS FUNCIONES LAS USO PARA AGREGAR UN PREMIO DEL TIPO LITERAL (LAS DEL CANDYBAR) AL CLIENTE
    public void setPremioCandyBar(String premio){
        premioCandyBar.add(premio);
    }
    public ArrayList<String> getPremioCandyBar(){
        return premioCandyBar;
    }
}
