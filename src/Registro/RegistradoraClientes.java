package Registro;

import java.util.HashMap;
import java.util.Map;

public class RegistradoraClientes {
    private static Map<Integer, Cliente> registroClientes = new HashMap<>();


    public static void registrarCliente(int ci, String fullName, String nacionalidad, String fechaNacimiento){
        Cliente cliente = new Cliente(ci, fullName, nacionalidad, fechaNacimiento);
        registroClientes.put(ci, cliente);
    }

    public static Cliente getCliente(int ci) {
        return registroClientes.get(ci);
    }
}
