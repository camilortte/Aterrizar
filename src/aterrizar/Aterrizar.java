/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aterrizar;

import java.sql.SQLException;
import java.util.Calendar;
import javax.swing.UIManager;
import model.consulta.Consulta;
import model.persistencia.ConexionDB;
import model.persistencia.DataBaseManager;
import model.sesion.Autenticacion;
import org.joda.time.Instant;
import org.joda.time.Interval;
import org.joda.time.MutableDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import view.Login;
import view.VentanaPrincipal;

/**
 *
 * @author camilortte
 */
public class Aterrizar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
         try 
        { 
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"); 
        } 
        catch(Exception e){ 
        }
        
         
        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
        String todo="2014-1-29 06:00:00";
        MutableDateTime dateTime = formatter.parseMutableDateTime(todo);
        System.out.println(dateTime.toString());
        
         //System.out.println("");
        Interval interval = new Interval(new Instant(),dateTime);
        System.out.println(interval.toDuration().toPeriod().getHours()+" "+interval.toDuration().toPeriod().getMinutes());
        
        System.out.println("La diferencia es"+interval);
         
        //Creamos tan solo una instancia de consulta   
        String datos[][]=new String[6][6];
    	datos[0][0]="1";
    	datos[0][1]="Java";
    	datos[0][2]="1000";
        datos[0][3]="1000";
        datos[0][4]="1000";
        datos[0][5]="1000";
    	datos[1][0]="2";
        datos[1][1]="Java";
    	datos[1][2]="1000";
        datos[1][3]="1000";
        datos[1][4]="1000";
        datos[1][5]="1000";
        //new Factura (datos,"Camilo ramirez");
        ConexionDB con = new ConexionDB();
        DataBaseManager.getInstance().setConexionDB(con);
        Consulta a=Consulta.getInstance();          
        Autenticacion autenticacion=Autenticacion.getInstance();
        autenticacion.iniciarSesion("1013636654", "{DES}WkY8Mz7y4vM=");
        //autenticacion.iniciarSesion("1031144412", "{DES}WkY8Mz7y4vM=");
        (new VentanaPrincipal()).setVisible(true);
        //(new Login()).setVisible(true);
        //(new AgregarVuelos()).setVisible(true);
        
    }
}

