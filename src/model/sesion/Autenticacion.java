/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.sesion;

import model.usuario.Usuario;

/**
 *
 * @author camilortte
 */
public class Autenticacion {
    private static Autenticacion instance=null;
        
    private Autenticacion() {    }

    public static synchronized Autenticacion getInstance(){
        if (instance==null){
            instance=new  Autenticacion();
        }
        return instance;
    }
    //----------------------------
    
    private Usuario usuario;
    
    public void iniciarSesion(String username,String password){
        //realizamos la consulta para confirmar que el usuario existe
        
        //rellenamos los campos de usuario
        
        //Si existe entonces devolvemos True de lo contrario False
    }
    
}
