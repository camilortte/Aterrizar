/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.persistencia;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.usuario.Usuario;


/**
 *
 * @author camilortte
 */
public class DataBaseManager {
    private static DataBaseManager instance=null;
        
    private DataBaseManager() {    }

    public static synchronized DataBaseManager getInstance(){
        if (instance==null){
            instance=new  DataBaseManager();
        }
        return instance;
    }
    //----------------------------
    private ConexionDB conexionDB__;
    private Connection conexion;

    public ConexionDB getConexionDB() {        
        return conexionDB__;
    }

    public void setConexionDB(ConexionDB conexion__) {
        this.conexionDB__ = conexion__;
        this.conexion=conexion__.getConexion();        
    }
    
    public List<List<String>> consultar(String sql,String campos[]){
         
        boolean consulta_bandera=false;
        try {
            ArrayList<String> fila=new ArrayList<String>();
            List<List<String>> consulta = new ArrayList<List<String>>();
            fila.clear();
            Statement stat = conexion.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()){
                fila.clear();
                for(String campo : campos){
                    fila.add((String)rs.getObject(campo));
                    consulta_bandera=true;
                }
                if(consulta_bandera!=false){
                    return consulta;
                }else{
                    return null;
                }
            }
            /*rs.close();
            stat.close();
            conexion.close();*/
            return consulta;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
         return null;
    }
    
    public List<List<String>> consultar(String sql){
         try {
            boolean consulta_bandera=false;
            ArrayList<String> fila=new ArrayList<String>();
            List<List<String>> consulta = new ArrayList<List<String>>();
            fila.clear();
            Statement stat = conexion.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            ResultSetMetaData meta=rs.getMetaData();
            while(rs.next()){
                fila.clear();
                for (int i = 0; i < meta.getColumnCount(); i++) {
                    consulta_bandera=true;
                    fila.add((String)rs.getObject(i+1));
                }
                consulta.add(fila);
            }
            if(consulta_bandera!=false){
                return consulta;
            }else{
                return null;
            }
            /*rs.close();
            stat.close();
            conexion.close();*/            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
         
    }
    
    public boolean insertar_usuairo(Usuario usuario){
        /*String sql="insert into usuario values ('"+
                +"1013636654"+','"{DES}WkY8Mz7y4vM="','"Camilo"','"+
                +"Ramirez"','+"camilortte@hotmail.com"')";*/
        return false;
    }
    
}
