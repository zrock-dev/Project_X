import Registro.Cliente;
import ServicioAlCliente.Premios;
import ServicioAlCliente.CanjearPromo;
import org.junit.jupiter.api.Test;

import java.security.PublicKey;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PromocionTest {
    @Test
    public void BoletoGratis(){
        Cliente cliente = new Cliente(101010,"DIEGO FIGUEROA","BOLIVIANO","29/01/2001");
        cliente.setPuntosTotales(10000);


        CanjearPromo.canjear(Premios.SEGUNDAOPCION,cliente);
        assertEquals(cliente.getCantidadTicketsGratis(),2);
  }
  @Test
    public void PremiosCandyBarGratis(){
      Cliente cliente = new Cliente(101010,"DIEGO FIGUEROA","BOLIVIANO","29/01/2001");
      cliente.setPuntosTotales(10000);

      CanjearPromo.canjear(Premios.QUINTAOPCION,cliente);
      ArrayList<String> respuesta = new ArrayList<>();
      respuesta.add(Premios.QUINTAOPCION.getDescripcion());
      assertEquals(cliente.getPremioCandyBar(),respuesta);
  }
  @Test
    public void VariosPremiosDelCandyBar(){
      Cliente cliente = new Cliente(101010,"DIEGO FIGUEROA","BOLIVIANO","29/01/2001");
      cliente.setPuntosTotales(10000);

      CanjearPromo.canjear(Premios.QUINTAOPCION,cliente);
      CanjearPromo.canjear(Premios.CUARTAOPCION,cliente);
      ArrayList<String> respuesta = new ArrayList<>();
      respuesta.add(Premios.QUINTAOPCION.getDescripcion());
      respuesta.add(Premios.CUARTAOPCION.getDescripcion());
      assertEquals(cliente.getPremioCandyBar(),respuesta);
  }

}
