/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aterrizar;

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
    public static void main(String[] args) {
        //Creamos tan solo una instancia de consulta        
        ConexionDB con = new ConexionDB();
        DataBaseManager.getInstance().setConexionDB(con);
        Consulta a=Consulta.getInstance();          
        Autenticacion autenticacion=Autenticacion.getInstance();
        autenticacion.iniciarSesion("1031144412", "{DES}WkY8Mz7y4vM=");
        (new VentanaPrincipal()).setVisible(true);
         //(new Login()).setVisible(true);
        
    }
}

