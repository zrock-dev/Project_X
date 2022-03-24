package Area_Trabajador;

import java.util.HashMap;
import java.util.Map;

public class RegistrarTrabajador {
    static Map<String, Trabajador> registroTrabajador = new HashMap<>();

    public static void registrarTrabajador(String ci, String fullName, String nacionalidad, String fechaNacimiento,SectorLaboral sectorLaboral){
        if (registroTrabajador.containsKey(ci)){
            System.out.println("Worker already registered");
        }else {
            registroTrabajador.put(ci, new Trabajador(ci, fullName, nacionalidad, fechaNacimiento, sectorLaboral));
            System.out.println("Successfully Registered");
        }
    }

    public static Trabajador getTrabajador(String ci) {
        return registroTrabajador.get(ci);
    }

    public static boolean isTrabajador(String ci){
        return registroTrabajador.containsKey(ci);
    }
}
