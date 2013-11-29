/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.compra;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.consulta.Vuelo;
import model.persistencia.DataBaseManager;
import model.sesion.Autenticacion;
import model.usuario.Usuario;
import org.joda.time.DateTime;
import org.joda.time.Instant;
import org.joda.time.Interval;
import org.joda.time.JodaTimePermission;
import org.joda.time.MutableDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/** *
 * @author camilortte
 */
public class Reservar {//extends Comprar {
    
    protected  Usuario usuario;
    protected double precio;
    protected Calendar fecha;
    protected Vuelo vuelo;
    

    public Reservar(Usuario usuario, double precio, Calendar fecha, Vuelo vuelo) {
        this.usuario = usuario;
        this.precio = precio;
        this.fecha = fecha;
        this.vuelo=vuelo;
    }

    public boolean realziarReserva(){
          //Una insercion a la base de datos donde se realice a compra
        Calendar cal=Calendar.getInstance();
        Calendar now = Calendar.getInstance();
        int year_now = now.get(Calendar.YEAR);
        int month_now = now.get(Calendar.MONTH)+1; // Note: zero based!
        int day_now = now.get(Calendar.DAY_OF_MONTH);
        
       
        boolean insertado=false;
     
        try {
           if(getCantidadDias(vuelo.getFecha(), vuelo.getHorario())>24){
                 insertado=DataBaseManager.getInstance().insertarComprador(this.vuelo.getId()
                , Autenticacion.getInstance().getUsuario().getCedula()
                ,false
                ,year_now,month_now,day_now); 
           }
        } catch (ParseException ex) {
            Logger.getLogger(Reservar.class.getName()).log(Level.SEVERE, null, ex);
        }
        return insertado;
    }
    
    
     public int getCantidadDias(String fecha,String hora) throws ParseException{        
        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");        
        MutableDateTime dateTime = formatter.parseMutableDateTime(fecha+" "+hora);
        
        Interval interval = new Interval(new Instant(),dateTime);
        int diferenciaDias=interval.toDuration().toPeriod().getHours();
        return  diferenciaDias;
        
    }
    
    
    
    
    public Vuelo getVuelo() {
        return vuelo;
    }

    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }

        
    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }    
    
}
