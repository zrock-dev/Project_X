package Area_de_compras;

import Console_interaction.Utils;
import Registro.Cliente;
import Registro.RegistradoraClientes;
import Peliculas.Pelicula;
import Salas_de_video.RoomsManager;
import Salas_de_video.Sala;

import java.util.*;

public class Boleteria {
    public String name;
    Map<Sala,String[]> peliculasDia;
    int precioPelicula;
    int precio2D = 40;
    int precio3D = 50;
    int precioTotal;

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


    public void comprarBoleto(String ci, MetodoPago metodo, String codigoSala,
                              String[] seatsToBuy , Semana dia, Pelicula pelicula){
        Cliente cliente = RegistradoraClientes.getCliente(ci);
        Sala salaCliente = manager.getSala(codigoSala);
        String fullNameClient = cliente.getFullName();

        if (cliente.getCantidadTicketsGratis() == 0){

            Boleto boleto = new Boleto(cliente, precioPelicula, salaCliente,pelicula);
            boleto.aplicarDescuento(metodo, dia);
            manager.buySeats(codigoSala, seatsToBuy, fullNameClient);
            precioTotal=((int)boleto.precioPelicula*seatsToBuy.length);
        }

        else {
            // Este ticket ganado por premio no te permite ganar mas puntos.
            Boleto boleto = new Boleto(salaCliente);
            manager.buySeats(codigoSala, seatsToBuy, fullNameClient);
            System.out.println("Su ticket ha sido utilizado.");
            cliente.usarTicketGratis();
            precioTotal=((int)boleto.precioPelicula*seatsToBuy.length);

        }
    }

    // Comprar boleto sin CI
    public void comprarBoleto(MetodoPago metodo,String codigoSala,String[] seatsToBuy,
                                   Semana dia, ModoPresentacion modo ,String fullname,String fechaNacimiento,
                              Pelicula pelicula) {

        Sala salaCliente = manager.getSala(codigoSala);
        Cliente cliente = new Cliente(fullname, fechaNacimiento);
        elegirModoPresentacion(modo);
        Boleto boleto = new Boleto(cliente, precioPelicula, salaCliente, pelicula);
        boleto.aplicarDescuento(metodo, dia);
        precioTotal = (int) (boleto.precioPelicula) * seatsToBuy.length;
        manager.buySeats(codigoSala, seatsToBuy, fullname);
    }

    // agregue esto para hacer el test
    public int getPrecioTotal(){
        return precioTotal;
    }

    public List<String> showMoviesForToday(){
        int index = 1;
        List<String> todayMovies = new ArrayList<>();
        todayMovies.add("");

        for (Sala sala:
             manager.getRoomsMap().values()) {
            for (String movie:
                 sala.getListaPeliculas()) {
                if (!todayMovies.contains(movie)){
                    todayMovies.add(movie);
                    System.out.println("\t" + index + ". " + movie);
                    index++;
                }
            }
        }
        return todayMovies;
    }

}
