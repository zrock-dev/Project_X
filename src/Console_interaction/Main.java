package Console_interaction;
import Area_de_compras.Boleteria;
import Registro.RegistradoraClientes;
import Valores_Constantes.Constants;

import static Console_interaction.Utils.getCustomerInfo;
import static Console_interaction.Utils.subheader;

public class Main {

    public static void main(String[] args) {
        Boleteria boleteria = new Boleteria(Constants.NOMBRE_BOLETERIA);
        Utils.header("Welcome to: " + boleteria.name + " movie theater");
        Menu m = new Menu();

        // Menu
        m.showGeneralMenu();

        switch (Utils.getOption()){
            case 1:
                m.getMovie(boleteria);
                m.buy(boleteria);
                break;
            case 2:
                subheader("Registration Menu");
                RegistradoraClientes.registerCustomer(getCustomerInfo());
                break;
            default:
                System.out.println("do");
        }

    }
}
