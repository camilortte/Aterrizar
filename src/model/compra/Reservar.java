/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.compra;

import java.sql.Date;
import java.util.Calendar;
import model.consulta.Vuelo;
import model.persistencia.DataBaseManager;
import model.sesion.Autenticacion;
import model.usuario.Usuario;

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
        int year = now.get(Calendar.YEAR);
        int month = now.get(Calendar.MONTH)+1; // Note: zero based!
        int day = now.get(Calendar.DAY_OF_MONTH);
        
        boolean insetado=DataBaseManager.getInstance().insertarComprador(this.vuelo.getId()
                , Autenticacion.getInstance().getUsuario().getCedula()
                ,false
                ,year,month,day);     
        return insetado;
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
