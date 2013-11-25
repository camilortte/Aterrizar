package model.compra;

import java.util.Calendar;
import model.consulta.Vuelo;
import model.usuario.Usuario;

/**
 * @author camilortte
 */
public class Comprar extends Reservar{
    
    public Comprar(Usuario usuario, double precio, Calendar fecha, String tipo_pago, Vuelo vuelo){
        super(usuario, precio, fecha, tipo_pago, vuelo);
    }
    
    
    
}
