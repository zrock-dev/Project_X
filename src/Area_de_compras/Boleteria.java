package Area_de_compras;
import Console_interaction.Utils;
import Area_Cliente.Cliente;
import Area_Cliente.RegistradoraClientes;
import Area_Peliculas.Pelicula;
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

    void getInfoCompra(){
        showSimpleLine();
        // Set Prize
        System.out.println("Select display mode: ");
        Utils.showOptions(new String[]{"2D", "3D"});
        if (getOption() == 1){
            precioPelicula = precio2D;
        }else {
            precioPelicula = precio3D;
        }

        // Set Payment mode
        showSimpleLine();
        System.out.println("Select paymentType method");
        Utils.showOptions(new String[]{"Tarjeta", "QR", "Efectivo"});
        switch (getOption()){
            case 1:
                paymentType = MetodoPago.TARJETA;
                break;
            case 2:
                paymentType = MetodoPago.QR;
                break;
            case 3:
                paymentType = MetodoPago.EFECTIVO;
        }
    }

    public void comprarBoleto(String ci, String codigoSala, Pelicula pelicula, int seatsQuantity){

        Cliente cliente = RegistradoraClientes.getCliente(ci);
        String fullNameClient = cliente.getFullName();
        subheader("Welcome " + fullNameClient);
        getInfoCompra();

        if (cliente.getCantidadTicketsGratis() == 0){
            Boleto boleto = new Boleto(cliente, precioPelicula, pelicula);
            int puntosCliente = boleto.aplicarDescuento(paymentType, Semana.whatDayIsToday());
            cliente.sumarPuntos(puntosCliente);
            precioTotal = (int) (boleto.precioPelicula) * seatsQuantity;
        }else {
            // Este ticket ganado por premio no te permite ganar mas puntos.
            // Y no aplica a descuentos.
            precioTotal = precioPelicula * seatsQuantity;
            cliente.usarTicketGratis();
            System.out.println("Su ticket ha sido utilizado.");
        }
    }

    // Comprar boleto sin CI
    public void comprarBoleto(Pelicula pelicula, int seatsQuantity) {
        subheader("Receipt Infomation");
        System.out.print("Please insert your age: ");
        int edadCliente = sn.nextInt();
        getInfoCompra();
        Boleto boletoSinCi = new Boleto(edadCliente, precioPelicula, pelicula);
        boletoSinCi.aplicarDescuento(paymentType, Semana.whatDayIsToday());
        precioTotal = (int) (boletoSinCi.precioPelicula) * seatsQuantity;
    }

    // agregue esto para hacer el test
    public int getPrecioTotal(){
        return precioTotal;
    }

    public List<String> showMoviesForToday(){
        subheader("Movies for today");
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

    // To check who is playing the movie
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
