package Console_interaction;

import Area_de_compras.Boleteria;
import Salas_de_video.Sala;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Utils {
    static int characters = 60;
    static Scanner sn  = new Scanner(System.in);
    static List<String> todayMovies;

    static public void header(String title) {
        System.out.println("=".repeat(characters));
        System.out.println("\t\t\t" + title);
        System.out.print("=".repeat(characters));
    }

    static public void subheader(String title) {
        System.out.println("\n");
        System.out.println("-".repeat(characters));
        System.out.println("\t\t\t" + title);
        System.out.println("-".repeat(characters));
    }

    static public void showGeneralMenu(){
        subheader("General Menu");
        System.out.println("\t1. Buy ticket for movie");
        System.out.println("\t2. Registration");
    }

    static public int getOption(){
        System.out.print("Option: ");
        return Utils.sn.nextInt();
    }

    static public void showSimpleLine(){
        System.out.println("-".repeat(characters));
    }

    public static List<String> getCustomerData(){
        List<String> customerData = new ArrayList<>(4); // only 4 items!!!
        System.out.println("Please enter the following information");
        showSimpleLine();
        System.out.print("CI: "); customerData.add(sn.next());
        System.out.print("Full Name: "); customerData.add(sn.next());
        System.out.print("Nationality: "); customerData.add(sn.next());
        System.out.print("Birth Date: "); customerData.add(sn.next()); // Specify date format
        return customerData;
    }

    public static void showSala(Sala sala){
        subheader("Movies for Room-" + sala.codigoSala);
        System.out.println(" ".repeat(characters - "OCCUPANCY".length()) + "OCCUPANCY");
        ArrayList<String> moviesList = sala.getListaPeliculas();
        for (int i = 0; i < moviesList.size(); i++) {
            String movie = moviesList.get(i);
            int reservedSeats = sala.getAsientosVendidos();
            int roomCapacity = sala.getCapacidadAsientos();
            String occupancy = "[" + reservedSeats+ "/" + roomCapacity + "]";
            int spaceFix = characters - 1 - movie.length() - occupancy.length() * 2;
            System.out.println("\t" + (i + 1) + ". " + movie + " ".repeat(spaceFix)
                    + occupancy);
        }
    }

    public static void getMovie(Boleteria boleteria){
        subheader("Movies for today");
        todayMovies = boleteria.showMoviesForToday();
        String movieSelected = todayMovies.get(getOption() - 1);
    }

}
