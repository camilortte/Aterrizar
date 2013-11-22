/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.sesion;

import javax.swing.JOptionPane;
import model.consulta.Consulta;
import model.persistencia.DataBaseManager;
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
    
    public boolean iniciarSesion(String username,String password){
        //realizamos la consulta para confirmar que el usuario existe
        usuario=Consulta.getInstance().consultarUsuario(username, password);
//        System.out.println("EL usuario es "+usuario.getNombre());
        if(usuario==null){
            return false;
        }else{
            return true;            
        }        
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
    
}
