package Area_Trabajador;

import Clases_Padre.Persona;

public class Trabajador extends Persona {

    SectorLaboral sectorLaboral;

    public Trabajador(String ci, String fullName, String nacionalidad, String fechaNacimiento
            ,SectorLaboral sectorLaboral) {
        super(ci, fullName, nacionalidad, fechaNacimiento);
        this.sectorLaboral = sectorLaboral;
    }

    public SectorLaboral getSectorLaboral() {
        return sectorLaboral;
    }

    public void setSectorLaboral(SectorLaboral sectorLaboral) {
        this.sectorLaboral = sectorLaboral;
    }

    public String informacionRapidarabajador (Trabajador trabajador){
        return trabajador.getFullName() + trabajador.sectorLaboral;
    }
}
