package Area_de_compras;

import Registro.Cliente;
import Registro.RegistradoraClientes;
import Salas_de_video.Sala;
import Salas_de_video.Utils;

import java.util.*;

public class Boleteria {
    String name;
    Map<String, Sala> salaMap;
    Map<Sala,String[]> peliculasDia;
    int precioPelicula;
    int precio2D = 40;
    int precio3D = 50;
    int precioTotal;

    public Boleteria(String name) {
        salaMap = new HashMap<>();
        peliculasDia = new Hashtable<>();
        this.name = name;
    }

    public double getPrecioPelicula() {
        return precioPelicula;
    }

    public void elegirModoPresentacion(ModoPresentacion modo){
        switch (modo){
            case BIDIMENSIONAL:
                precioPelicula = precio2D;
                break;
            case TRIDIMENSIONAL:
                precioPelicula = precio3D;
                break;
        }
    }

    public void modificarPrecios(ModoPresentacion modo, int nuevoPrecio){
        switch (modo){
            case BIDIMENSIONAL:
                precio2D = nuevoPrecio;
                break;
            case TRIDIMENSIONAL:
                precio3D = nuevoPrecio;
                break;
        }
    }

    public void comprarBoleto(int ci, MetodoPago metodo, String columnaAsiento, int cantidadAsientos,
                              String codigoSala, Semana dia){
        Cliente cliente = RegistradoraClientes.getCliente(ci);
        if (cliente.getCantidadTicketsGratis() == 0){
            Boleto boleto = new Boleto(cliente, precioPelicula, salaMap.get(codigoSala));
            boleto.aplicarDescuento(metodo, dia);
            boleto.comprarAsientos(columnaAsiento, cantidadAsientos);
        }else {
            // Este ticket ganado por premio no te permite ganar mas puntos.
            Boleto boleto = new Boleto(salaMap.get(codigoSala));
            // boleto.comprarAsientos(codigoSala, cantidadAsientos); el metodo no sirve
            System.out.println("Su ticket ha sido utilizado.");
            cliente.usarTicketGratis();
        }
    }

    public void tomarCartelerasSalas(){
        for (Sala sala:
             salaMap.values()) {
            peliculasDia.put(sala, sala.getCarteleraSala());
        }
    }

    public void showCartelera(){
        tomarCartelerasSalas();
        for (String[] carteleraSala:
             peliculasDia.values()) {
            System.out.println(Arrays.toString(carteleraSala));
        }
    }

    public void crearSalas(int cantidad){
        char[] letras = Utils.generarAbc(cantidad);
        for (int i = 0; i < cantidad; i++){
            String letra = String.valueOf(letras[i]);
            Sala sala = new Sala(letra);
            sala.llenarCarteleraSala();
            salaMap.put(letra, sala);
        }
    }

    public void setCapacidadSalas(){
        salaMap.get("A").setCapacidad(100);
        salaMap.get("B").setCapacidad(100);
        salaMap.get("C").setCapacidad(100);
        salaMap.get("D").setCapacidad(80);
        salaMap.get("E").setCapacidad(80);
        salaMap.get("F").setCapacidad(50);
        salaMap.get("G").setCapacidad(50);
    }

    public void comprarBoletoSinCI(MetodoPago metodo,String codigoSala,  String columnaAsiento, int cantidadAsientos,
                                   Semana dia,ModoPresentacion modo,String nombre,String fechaNacimiento,String genero) {
        elegirModoPresentacion(modo);
        Cliente cliente = new Cliente(nombre,fechaNacimiento);
        Boleto boleto = new Boleto(cliente,precioPelicula,salaMap.get(codigoSala));
        boleto.setGeneroPelicula(genero);
        boleto.aplicarDescuento(metodo, dia);
        precioTotal = (int) (boleto.precioPelicula) * cantidadAsientos;
        //boleto.comprarAsientos(columnaAsiento, cantidadAsientos);
    }

    public int getPrecioTotal(){
        return precioTotal;
    }
}
