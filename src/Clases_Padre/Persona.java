package Clases_Padre;

import java.util.List;

public class Persona {
    String ci,fullName,nacionalidad,fechaNacimiento;
    // Fecha de nacimiento : 03/01/2001

    public Persona(String ci, String fullName, String nacionalidad, String fechaNacimiento) {
        this.ci = ci;
        this.fullName = fullName;
        this.nacionalidad = nacionalidad;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Persona(String fullName, String fechaNacimiento) {
        this.fullName=fullName;
        this.fechaNacimiento=fechaNacimiento;
    }


    public String getCi() {
        return ci;
    }

    public String getFullName() {
        return fullName;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public int getEdad() {  // edad del cliente
        return 2022 - Integer.parseInt(fechaNacimiento.split("/")[2]);
    }
}
