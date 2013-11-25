/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.persistencia;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.usuario.Usuario;
import org.postgresql.util.PSQLException;

/**
 *
 * @author camilortte
 */
public class DataBaseManager {

    private static DataBaseManager instance = null;

    private DataBaseManager() {
    }

    public static synchronized DataBaseManager getInstance() {
        if (instance == null) {
            instance = new DataBaseManager();
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
        this.conexion = conexion__.getConexion();
    }

    public List<List<String>> consultar(String sql, String campos[]) {

        boolean consulta_bandera = false;
        try {
            ArrayList<String> fila = new ArrayList<String>();
            List<List<String>> consulta = new ArrayList<List<String>>();
            fila.clear();
            Statement stat = conexion.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {
                fila.clear();
                for (String campo : campos) {
                    fila.add((String) rs.getObject(campo));
                    consulta_bandera = true;
                }
                if (consulta_bandera != false) {
                    return consulta;
                } else {
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

    public List<List<String>> consultar(String sql) {
        try {
            boolean consulta_bandera = false;            
            List<List<String>> consulta = new ArrayList<List<String>>();
            
            Statement stat = conexion.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            ResultSetMetaData meta = rs.getMetaData();
            System.out.println("Antes del cliclo");
            System.out.println("EL sql="+sql);
            while (rs.next()) {
                System.out.println("Dentro del cilo");
                ArrayList<String> fila = new ArrayList<String>();
                fila.clear();
                for (int i = 0; i < meta.getColumnCount(); i++) {
                    consulta_bandera = true;
                    fila.add(rs.getString(i + 1));
                    System.out.println("Se anade="+fila.get(i));
                }
                consulta.add(fila);
            }
            if (consulta_bandera != false) {
                return consulta;
            } else {
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

    public boolean insertar_usuairo(Usuario usuario, String pass) {
        try {
            String sql = "insert into usuario values ('"
                    + usuario.getCedula() + "','" + pass + "','" + usuario.getNombre() + "','" + usuario.getApellido()
                    + "','" + usuario.getEmail() + "')";


            PreparedStatement stmt = conexion.prepareStatement("INSERT INTO usuario(USUA_cedula, "
                    + "USUA_clave, USUA_nombre, USUA_apellido, USUA_correo) VALUES (?, ?, ?,?,?)");

            stmt.setString(1, usuario.getCedula());
            stmt.setString(2, pass);
            stmt.setString(3, usuario.getNombre());
            stmt.setString(4, usuario.getApellido());
            stmt.setString(5, usuario.getEmail());

            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

    public Double  getCostoVuelo(String aerolinea){
        try {
            String costo = "";
            String sql = "select aerol_tarifa from aerolinea where aerol_nombre like('%"+aerolinea+"%')";
            Statement stat = conexion.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            ResultSetMetaData meta = rs.getMetaData();
            while (rs.next()) {
                //(String)rs.getObject(i+1);            
                costo =  rs.getString("aerol_tarifa");
            }
            return Double.parseDouble(costo);
        }catch(Exception e){
            return null;
        }
    }
    
    public void insertarVuelo(String origen, String destino, String fecha, String aerolinea,String costo) {
       try{
            String sql = "insert into vuelo (\"vuel_aerol_id\", \"vuel_ruta_id\", \"vuel_fecha\", \"vuel_precio\") "
                    + "values ("
                    + "(select aerol_id from aerolinea where aerol_nombre like('" + aerolinea + "')),"
                    + "(select ruta_id from ruta, origen, destino where ruta_orig_id=orig_id and ruta_dest_id=dest_id and orig_id="
                    + " (select ciud_id from ciudad where ciud_nombre like('" + origen + "')) and dest_id=(select ciud_id from ciudad "
                    + " where ciud_nombre like('" + destino + "'))),"
                    + "'" + fecha + "',"
                    + "'" + costo + "');";
            System.out.println(sql);
            PreparedStatement stmt = conexion.prepareStatement(sql);
            stmt.executeQuery();

        } catch (PSQLException ex){
            System.out.println("Insertado Satisfactoriamente");
        } catch (SQLException ex) {            
            Logger.getLogger(DataBaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
