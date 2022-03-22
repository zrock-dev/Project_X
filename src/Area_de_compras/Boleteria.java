package Area_de_compras;
import Registro.Cliente;
import Registro.RegistradoraClientes;
import Salas_de_video.Pelicula;
import Salas_de_video.RoomsManager;
import Salas_de_video.Sala;

import java.util.*;

import static Console_interaction.Utils.*;

public class Boleteria {
    public String name;
    Map<Sala,String[]> peliculasDia;

    int precioPelicula;
    int precio2D = 40;
    int precio3D = 50;
    int precioTotal;

    MetodoPago paymentType;

    // La boleteria se comunica con las salas por medio del RoomsManager
    public RoomsManager manager = new RoomsManager();

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

    void getData(){
        showSimpleLine();
        System.out.print("Select display mode: ");
        ModoPresentacion modo;
        switch (getOption()){
            case 1:
                modo = ModoPresentacion.BIDIMENSIONAL;
                break;
            default:
                modo = ModoPresentacion.TRIDIMENSIONAL;
        }
        elegirModoPresentacion(modo);

        System.out.print("Select paymentType method: ");

        switch (getOption()){
            case 1:
                paymentType = MetodoPago.TARJETA;
                break;
            case 2:
                paymentType = MetodoPago.QR;
                break;
            default:
                paymentType = MetodoPago.EFECTIVO;
        }
    }

    public void comprarBoleto(String ci, String codigoSala, Pelicula pelicula){
        getData();
        Cliente cliente = RegistradoraClientes.getCliente(ci);
        String fullNameClient = cliente.getFullName();

        if (cliente.getCantidadTicketsGratis() == 0){
            Boleto boleto = new Boleto(cliente, precioPelicula, pelicula);
            boleto.aplicarDescuento(paymentType, Semana.whatDayIsToday());
            manager.buySeats(codigoSala, fullNameClient);
        }else {
            // Este ticket ganado por premio no te permite ganar mas puntos.
            Boleto boleto = new Boleto();
            manager.buySeats(codigoSala, fullNameClient);
            System.out.println("Su ticket ha sido utilizado.");
            cliente.usarTicketGratis();
        }
    }

    // Comprar boleto sin CI
    public void comprarBoleto(MetodoPago metodo,String codigoSala, ArrayList<String> seatsToBuy,
                                   Semana dia, ModoPresentacion modo, String fullname,String fechaNacimiento,
                              Pelicula pelicula) {

        Cliente cliente = new Cliente(fullname, fechaNacimiento);
        elegirModoPresentacion(modo);
        Boleto boleto = new Boleto(cliente, precioPelicula, pelicula);
        boleto.aplicarDescuento(metodo, dia);
        precioTotal = (int) (boleto.precioPelicula) * seatsToBuy.size();
        manager.buySeats(codigoSala, fullname);
    }

    // agregue esto para hacer el test
    public int getPrecioTotal(){
        return precioTotal;
    }

    public List<String> showMoviesForToday(){
        int index = 1;
        List<String> todayMovies = new ArrayList<>();
        todayMovies.add(""); // to make the first comparison.

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
        todayMovies.remove("");
        return todayMovies;
    }

    public List<Sala> availableMovie(String movie){
        List<Sala> movieOnSalas = new ArrayList<>();
        for (Sala sala:
             manager.getRoomsMap().values()) {
            if (sala.getListaPeliculas().contains(movie)){
                movieOnSalas.add(sala);
            }
        }
        return movieOnSalas;
    }

}
