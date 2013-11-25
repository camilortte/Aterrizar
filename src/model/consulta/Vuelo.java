/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.consulta;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
    private String aerolinea;
    private double precio;

    public Vuelo(String origen, String destino, String escala, Date fecha, String aerolinea, double precio) {
        this.origen = origen;
        this.destino = destino;
        this.escala = escala;
        this.fecha = fecha;
        this.aerolinea = aerolinea;
        this.precio=precio;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    
    
    public String getAerolinea() {
        return aerolinea;
    }

    public void setAerolinea(String aerolinea) {
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

    /*
     * @param 
     * Fehca debe contener el mes es o es lo que nos interesa
     */
    public ArrayList<String> agregarVuelo(Calendar fecha, String origen, String destino) {
        ArrayList<String> fechas=new ArrayList<String>();
        fechas.clear();
        if (origen.contains("bogota")|| destino.contains("bogota")) {
            //Estos vuelos se realizan todos los dias , uno en la manana y uno en la
            //tarde
            fechas=getDiasBogota(fecha.get(Calendar.YEAR), fecha.get(Calendar.MONTH));
        } else {
            int suma = origen.length() + destino.length();            
            fechas.clear();
            if (suma % 2 == 0) {
                /*su suma es un numero par por lo tanto los vuelos se realizan los 
                 * dias   lunes , miercoles y domingos */
                 fechas=getFechasPermitidas(fecha.get(Calendar.YEAR),fecha.get(Calendar.MONTH),true);
            } else {
                /*Su suma es impar los vuelos se realizan los martes jueves y sabados*/
                fechas=getFechasPermitidas(fecha.get(Calendar.YEAR),fecha.get(Calendar.MONTH),false);
            }
            //si el vuelo es realizado el sabado o el domingo vale 10% mas 
        }
        return fechas;
    }

    public String getDiaSemana(Calendar fecha) {
        int dayOfWeek = fecha.get(Calendar.DAY_OF_WEEK);
        String dia = "";
        if (Calendar.MONDAY == dayOfWeek) {
            dia = "Lunes";
        } else if (Calendar.TUESDAY == dayOfWeek) {
            dia = "Martes";
        } else if (Calendar.WEDNESDAY == dayOfWeek) {
            dia = "Miercoles";
        } else if (Calendar.THURSDAY == dayOfWeek) {
            dia = "Jueves";
        } else if (Calendar.FRIDAY == dayOfWeek) {
            dia = "Viernes";
        } else if (Calendar.SATURDAY == dayOfWeek) {
            dia = "Sabado";
        } else if (Calendar.SUNDAY == dayOfWeek) {
            dia = "Domingo";
        }
        return dia;
    }
    
    public ArrayList<String> getDiasBogota(int year, int mes){
        ArrayList<String> fechas=new ArrayList<String>();
        fechas.clear();
        Calendar currentCalendar=Calendar.getInstance();
        Calendar mycal = new GregorianCalendar(year
                , mes, 1);
        int cantidadDeDias = mycal.getActualMaximum(Calendar.DAY_OF_MONTH); // 28
        for(int i=1;i<=cantidadDeDias;i++){
            fechas.add(year+"-"+(mes+1)+"-"+i); 
        }
        return fechas;
    }
    
    public ArrayList<String> getFechasPermitidas(int year,int mes, boolean par){
        //mes=mes-1;
        ArrayList<String> fechas=new ArrayList<String>();
        fechas.clear();
        if(par){            
            Calendar currentCalendar=Calendar.getInstance();
            Calendar mycal = new GregorianCalendar(year
                    , mes, 1);
            int cantidadDeDias = mycal.getActualMaximum(Calendar.DAY_OF_MONTH); // 28
                    
            for(int i=1;i<=cantidadDeDias;i++){
                mycal.set(year, mes, i);
                String dia=getDiaSemana(mycal);
                if (dia.compareTo("Lunes")==0 || dia.compareTo("Miercoles")==0 || 
                        dia.compareTo("Domingo")==0){
                    //agregamos las fechas permitidas
                    fechas.add(year+"-"+(mes+1)+"-"+i); 
                    System.out.println("Agregamos el dia "+i+" Que es un "+dia);
                }                        
            }            
            
        }else{
            Calendar currentCalendar=Calendar.getInstance();
            Calendar mycal = new GregorianCalendar(year
                    , mes, 1);
            int cantidadDeDias = mycal.getActualMaximum(Calendar.DAY_OF_MONTH);                     
            for(int i=1;i<=cantidadDeDias;i++){
                mycal.set(year, mes, i);
                String dia=getDiaSemana(mycal);
                if (dia.compareTo("Martes")==0 || dia.compareTo("Jueves")==0 || 
                        dia.compareTo("Sabado")==0){
                    //agregamos las fechas permitidas
                    fechas.add(year+"-"+(mes+1)+"-"+i); 
                }                        
            }
        }
        
        
        
        return fechas;
    }
}
