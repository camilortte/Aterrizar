/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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
    
    /*public ConexionDB(){
        try{
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:DataBase.db";
            //conexion = DriverManager.getConnection(url);
            conexion = DriverManager.getConnection("jdbc:sqlite:DataBase2.db");
        }catch(Exception e){
            System.out.println(e);
            e.printStackTrace();
        }
    }*/
    
     public ConexionDB() throws SQLException {
        String url="jdbc:postgresql://localhost:5432/DataBase";
        try {
            Class.forName("org.postgresql.Driver");
            conexion = DriverManager.getConnection(url, "postgres", "123456");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
