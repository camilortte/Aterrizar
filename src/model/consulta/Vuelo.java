/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.consulta;

import java.util.Date;
import model.aerolinea.Aerolinea;

/**
 *
 * @author camilortte
 */
public class Vuelo {
    private String origen;
    private String destino;
    private String escala;
    private Date fecha;
    private Aerolinea aerolinea;

    public Vuelo(String origen, String destino, String escala, Date fecha, Aerolinea aerolinea) {
        this.origen = origen;
        this.destino = destino;
        this.escala = escala;
        this.fecha = fecha;
        this.aerolinea = aerolinea;
    }

    public Aerolinea getAerolinea() {
        return aerolinea;
    }

    public void setAerolinea(Aerolinea aerolinea) {
        this.aerolinea = aerolinea;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getEscala() {
        return escala;
    }

    public void setEscala(String escala) {
        this.escala = escala;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }
    
}
