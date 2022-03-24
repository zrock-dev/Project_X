package Console_interaction;

import Area_de_compras.Boleteria;
import Registro.RegistradoraClientes;
import Salas_de_video.Pelicula;
import Salas_de_video.Sala;
import java.util.List;

import static Console_interaction.Utils.*;

public class Menu {
    Pelicula peliculaClient;
    String clientSalaCode;
    List<Sala> availableMovieInSalas;
    String clientMovieChoice;
    String clientCI;

    public void showGeneralMenu(){
        subheader("General Menu");
        showOptions(new String[]{"Buy a ticket", "Registration", "Exit"});
    }

    public void getMovieChoice(Boleteria boleteria){
        // Cartelera
        List<String> todayMovies = boleteria.showMoviesForToday();
        System.out.println("\n" +
                "Which movie do you want to see: ");
        clientMovieChoice = todayMovies.get(getOption() - 1);
        availableMovieInSalas = boleteria.availableMovie(clientMovieChoice);

        // Salas para pelicula especifica
        subheader("Salas playing " + clientMovieChoice);
        System.out.println(" ".repeat(characters - "OCCUPANCY".length()) + "OCCUPANCY");
        int index = 1;
        for (Sala sala:
                availableMovieInSalas) {
            String row1 =index + ". Sala " + sala.codigoSala;
            String occupancy = "[" + sala.getAsientosVendidos() + "/" + sala.capacidadAsientos + "]";
            int fixedSpace = characters - row1.length() - occupancy.length() * 2;
            System.out.println( "\t" + row1 + " ".repeat(fixedSpace) + occupancy);
            index++;
        }
    }

    public void getSalaClient(){
        showSimpleLine();
        System.out.println("Which Sala do you want?");
        Sala salaClient = availableMovieInSalas.get(getOption() - 1);
        clientSalaCode = salaClient.codigoSala;
        peliculaClient = salaClient.getPelicula(clientMovieChoice);
    }

    public void buy(Boleteria boleteria){
        // Seat information to buy
        int amountSeats = boleteria.manager.buySeats(clientSalaCode); // needs fix
        boleteria.manager.showRoomSeatsAvailable(clientSalaCode);

        System.out.print("Please enter your CI: "); clientCI = sn.next();
        if (RegistradoraClientes.isCliente(clientCI)){
            boleteria.comprarBoleto(clientCI, clientSalaCode, peliculaClient, amountSeats);
        }else{
            boleteria.comprarBoleto(peliculaClient, amountSeats);
        }
    }

    public void showTotal(Boleteria boleteria){
        subheader("Receipt");
        System.out.println("Customer ID: " + clientCI);
        showSimpleLine();
        System.out.print("\tMovies");
        int aux = characters - "\tMovies".length() - "Sala".length()*2;
        System.out.println(" ".repeat(aux) + "Sala");
        showSimpleLine();
        int fixedSpace = characters - peliculaClient.getNombre().length() - 7;
        System.out.println("\t" + peliculaClient.getNombre() + " ".repeat(fixedSpace)
                + clientSalaCode);
        showSimpleLine();
        System.out.println("\tTotal Price: " + boleteria.getPrecioTotal());
    }
}
