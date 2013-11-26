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
        
         Calendar now = Calendar.getInstance();
        int year = now.get(Calendar.YEAR);
        int month = now.get(Calendar.MONTH); // Note: zero based!
        int day = now.get(Calendar.DAY_OF_MONTH);
        
        System.out.println(year+" "+month+day+" ");
         
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
        autenticacion.iniciarSesion("1031144412", "{DES}WkY8Mz7y4vM=");
        autenticacion.iniciarSesion("1031144412", "{DES}WkY8Mz7y4vM=");
        (new VentanaPrincipal()).setVisible(true);
        //(new Login()).setVisible(true);
        //(new AgregarVuelos()).setVisible(true);
        
    }
}

