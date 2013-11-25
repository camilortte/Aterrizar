/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aterrizar;

import java.sql.SQLException;
import java.util.ArrayList;
import model.compra.Factura;
import model.consulta.Consulta;
import model.consulta.Vuelo;
import model.persistencia.ConexionDB;
import model.persistencia.DataBaseManager;
import model.sesion.Autenticacion;
import view.AgregarVuelos;
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
        //Creamos tan solo una instancia de consulta   
        
        Vuelo vuelo=new Vuelo("Hola", "Que",null, null,null,10.1);        
        ArrayList<String> fechas=vuelo.getFechasPermitidas(2013,12, true);
        
        for(String fecha : fechas){
            System.out.println(fecha);
        }
        
        
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

