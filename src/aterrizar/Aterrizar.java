/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aterrizar;

import model.consulta.Consulta;
import view.VentanaPrincipal;
import view.Login;

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
        Consulta a=Consulta.getInstance();          
       // (new VentanaPrincipal()).setVisible(true);
         (new Login()).setVisible(true);
        
    }
}

