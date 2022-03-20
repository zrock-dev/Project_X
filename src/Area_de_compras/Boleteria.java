package Area_de_compras;

import Registro.Cliente;
import Registro.RegistradoraClientes;
import Salas_de_video.RoomsManager;
import Salas_de_video.Sala;
import Salas_de_video.Utils;

import java.util.*;

public class Boleteria {
    String name;
    Map<Sala,String[]> peliculasDia;
    int precioPelicula;
    int precio2D = 40;
    int precio3D = 50;

    // La boleteria se comunica con las salas por medio del RoomsManager
    RoomsManager manager = new RoomsManager();

    public Boleteria(String name) {
        peliculasDia = new Hashtable<>();
        this.name = name;
    }

    public double getPrecioPelicula() {
        return precioPelicula;
    }

    public void elegirModoPresentacion(ModoPresentacion modo){
        switch (modo){
            case BIDIMENSIONAL:
                precioPelicula = precio2D;
                break;
            case TRIDIMENSIONAL:
                precioPelicula = precio3D;
                break;
        }
    }

    public void modificarPrecios(ModoPresentacion modo, int nuevoPrecio){
        switch (modo){
            case BIDIMENSIONAL:
                precio2D = nuevoPrecio;
                break;
            case TRIDIMENSIONAL:
                precio3D = nuevoPrecio;
                break;
        }
    }

    public void comprarBoleto(int ci, MetodoPago metodo, String columnaAsiento, int cantidadAsientos,
                              String codigoSala, Semana dia){
        Cliente cliente = RegistradoraClientes.getCliente(ci);
        Sala salaCliente = manager.getSala(codigoSala);
        if (cliente.getCantidadTicketsGratis() == 0){
            Boleto boleto = new Boleto(cliente, precioPelicula, salaCliente);
            boleto.aplicarDescuento(metodo, dia);
            // boleto.comprarAsientos(columnaAsiento, cantidadAsientos);
        }else {
            // Este ticket ganado por premio no te permite ganar mas puntos.
            Boleto boleto = new Boleto(salaCliente);
            // boleto.comprarAsientos(codigoSala, cantidadAsientos); el metodo no sirve
            System.out.println("Su ticket ha sido utilizado.");
            cliente.usarTicketGratis();
        }
    }

    // Metodos necesita ser renovado
//    public void tomarCartelerasSalas(){
//        for (Sala sala:
//             salaMap.values()) {
//            peliculasDia.put(sala, sala.getCarteleraSala());
//        }
//    }

//    public void showCartelera(){
//        tomarCartelerasSalas();
//        for (String[] carteleraSala:
//             peliculasDia.values()) {
//            System.out.println(Arrays.toString(carteleraSala));
//        }
//    }

}
