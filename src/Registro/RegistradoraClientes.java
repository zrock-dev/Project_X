package Registro;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RegistradoraClientes {
    static Map<String, Cliente> registroClientes = new HashMap<>();

    public static void registerCustomer(List<String> customerData){
        if (registroClientes.containsKey(customerData.get(0))){
            System.out.println("Customer already registered");
        }else {
            registroClientes.put(customerData.get(0), new Cliente(customerData));
            System.out.println("Successfully Registered");
        }
    }

    public static Cliente getCliente(String ci) {
        return registroClientes.get(ci);
    }

    public static boolean isCliente(String ci){
        return registroClientes.containsKey(ci);
    }
}
