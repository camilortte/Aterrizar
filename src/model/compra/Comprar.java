package model.compra;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.consulta.Vuelo;
import model.persistencia.DataBaseManager;
import model.sesion.Autenticacion;
import model.usuario.Usuario;

/**
 * @author camilortte
 */
public class Comprar extends Reservar{
    
    
    private String tipo_pago;
    
    public Comprar(Usuario usuario, double precio, Calendar fecha, String tipo_pago, Vuelo vuelo){
        super(usuario, precio, fecha, vuelo);
        this.tipo_pago=tipo_pago;
    }
    
    public String getTipo_pago() {
        return tipo_pago;
    }

    public void setTipo_pago(String tipo_pago) {
        this.tipo_pago = tipo_pago;
    }
    
    public boolean realziarCompra(){
        //Una insercion a la base de datos donde se realice a compra        
        Calendar now = Calendar.getInstance();
        int year = now.get(Calendar.YEAR);
        int month = now.get(Calendar.MONTH)+1; // Note: zero based!
        int day = now.get(Calendar.DAY_OF_MONTH);
        
        System.out.println(year+" "+month+day+" ");
        Date date=new Date(year, month, day);
        
        boolean insetado=DataBaseManager.getInstance().insertarComprador(this.vuelo.getId()
                , Autenticacion.getInstance().getUsuario().getCedula()
                ,true
                ,year,month,day); 
       
        
        return insetado;
    }
    
}
