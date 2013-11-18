/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author camilortte
 */
public class ConexionDB {
    
    private Connection conexion;

    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }
    
    public ConexionDB(){
        try{
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:DataBase.db";
            //conexion = DriverManager.getConnection(url);
            conexion = DriverManager.getConnection("jdbc:sqlite:/home/camilortte/NetBeansProjects/Aterrizar/DataBase.db");
        }catch(Exception e){
            System.out.println(e);
            e.printStackTrace();
        }
    }
    
}
