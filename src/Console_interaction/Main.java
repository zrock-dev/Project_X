package Console_interaction;
import Area_de_compras.Boleteria;
import Area_Cliente.RegistradoraClientes;
import Valores_Constantes.Constants;

import static Console_interaction.Utils.getCustomerInfo;
import static Console_interaction.Utils.subheader;

public class Main implements Constants {

    public static void main(String[] args) {
        Boleteria boleteria = new Boleteria(NOMBRE_BOLETERIA);
        Utils.header("Welcome to: " + boleteria.name + " movie theater");
        Menu m = new Menu();

        boolean condition = true;
        while (condition){
            boleteria.showMoviesForToday();
            m.showGeneralMenu();
            switch (Utils.getOption()){
                case 1:
                    m.getMovieChoice(boleteria);
                    m.getSalaClient();
                    m.buy(boleteria);
                    m.showTotal(boleteria);
                    break;
                case 2:
                    subheader("Registration Menu");
                    RegistradoraClientes.registerCustomer(getCustomerInfo());
                    break;
                case 3:
                    condition = false;
                    break;
            }
        }
        subheader("We hope see you again");
    }
}
