package Area_de_compras;

import java.util.Random;

public enum Semana {
    LUNES,MARTES,MIERCOLES,JUEVES,VIERNES,SABADO,DOMINGO;

    public static Semana whatDayIsToday(){
        Semana[] values = Semana.values();
        int valuesSize = values.length;
        int randIndex = new Random().nextInt(valuesSize);
        return values[randIndex];
    }
}
