/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.compra;

import java.util.Calendar;
import model.consulta.Vuelo;
import model.usuario.Usuario;

/** *
 * @author camilortte
 */
public class Reservar {//extends Comprar {
    
    private Usuario usuario;
    private double precio;
    private Calendar fecha;
    private String tipo_pago;
    private Vuelo vuelo;

    public Reservar(Usuario usuario, double precio, Calendar fecha, String tipo_pago, Vuelo vuelo) {
        this.usuario = usuario;
        this.precio = precio;
        this.fecha = fecha;
        this.tipo_pago = tipo_pago;
        this.vuelo=vuelo;
    }

    public void realziarCompra(){
        //Una insercion a la base de datos donde se realice a compra
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

    public String getTipo_pago() {
        return tipo_pago;
    }

    public void setTipo_pago(String tipo_pago) {
        this.tipo_pago = tipo_pago;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }    
    
}
