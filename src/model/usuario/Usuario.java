/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.usuario;

/**
 *
 * @author camilortte
 */
public class Usuario {
    private String clave;
    private String nombre;
    private String apellido;
    private String email;
    private String cedula;

    public Usuario(String nombre, String apellido, String clave) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.clave=clave;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    
    
     public Usuario() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
     
    

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
        
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
