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
    public String codeSala;

    public void showGeneralMenu(){
        subheader("General Menu");
        System.out.println("\t1. Buy ticket for movie");
        System.out.println("\t2. Registration");
    }

    public void getMovie(Boleteria boleteria){
        // Cartelera
        subheader("Movies for today");
        todayMovies = boleteria.showMoviesForToday();
        System.out.println("\n" +
                "Which movie do you want to see: ");
        String clientMovie = todayMovies.get(getOption() - 1);
        List<Sala> availableSalas = boleteria.availableMovie(clientMovie);

        // Salas para pelicula especifica
        subheader("Salas playing " + clientMovie);
        System.out.println(" ".repeat(characters - "OCCUPANCY".length()) + "OCCUPANCY");
        int index = 1;
        for (Sala sala:
                availableSalas) {
            String row1 =index + ". Sala " + sala.codigoSala;
            String occupancy = "[" + sala.getAsientosVendidos() + "/" + sala.capacidadAsientos + "]";
            int fixedSpace = characters - row1.length() - occupancy.length() * 2;
            System.out.println( "\t" + row1 + " ".repeat(fixedSpace) + occupancy);
            index++;
        }

        //Obteniendo Sala
        showSimpleLine();
        System.out.println("Which Sala do you want?");
        Sala salaClient = availableSalas.get(getOption() - 1);
        codeSala = salaClient.codigoSala;
        peliculaClient = salaClient.getPelicula(clientMovie);
    }

    public void buy(Boleteria boleteria){
        // Seat information to buy
        int amountSeats = boleteria.manager.buySeats(codeSala, "besos");
        boleteria.manager.showRoomSeatsAvailable(codeSala);

        System.out.print("Please enter your CI: "); String clientCI = sn.next();
        if (RegistradoraClientes.isCliente(clientCI)){
            boleteria.comprarBoleto(clientCI, codeSala, peliculaClient, amountSeats);
        }else{
            boleteria.comprarBoleto(codeSala, peliculaClient, amountSeats);
        }
    }
}
