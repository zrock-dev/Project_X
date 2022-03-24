package Console_interaction;

import Area_de_compras.Boleteria;
import Registro.RegistradoraClientes;
import Salas_de_video.Pelicula;
import Salas_de_video.Sala;
import java.util.List;

import static Console_interaction.Utils.*;

public class Menu {
    public List<String> todayMovies;
    public Pelicula peliculaClient;
    public String clientSalaCode;
    public List<Sala> availableMovieInSalas;
    String clientMovieChoice;

    public void showGeneralMenu(){
        subheader("General Menu");
        showOptions(new String[]{"Buy a ticket", "Registration", "Exit"});
    }

    public void getMovieChoice(Boleteria boleteria){
        // Cartelera
        todayMovies = boleteria.showMoviesForToday();
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
        int amountSeats = boleteria.manager.buySeats(clientSalaCode, "besos"); // needs fix
        boleteria.manager.showRoomSeatsAvailable(clientSalaCode);

        System.out.print("Please enter your CI: "); String clientCI = sn.next();
        if (RegistradoraClientes.isCliente(clientCI)){
            boleteria.comprarBoleto(clientCI, clientSalaCode, peliculaClient, amountSeats);
        }else{
            boleteria.comprarBoleto(clientSalaCode, peliculaClient, amountSeats);
        }
    }
}
