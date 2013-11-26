/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.consulta.Vuelo;
import model.sesion.Autenticacion;
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
    
    
    public ArrayList<String> getHorarioAerolinea(String aerolinea){
        ArrayList<String> resultados=new ArrayList<String>();
        resultados.clear();
        try {
            
            String sql = "select hora_horario from aerolinea, aerolinea_horario, horario where"
                    + " aerol_id=aeho_aerol_id and"
                    + " hora_id= aeho_hora_id and"
                    + " aerol_nombre like('"+aerolinea+"')";
            
            Statement stat = conexion.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            ResultSetMetaData meta = rs.getMetaData();
            while (rs.next()) {                
                resultados.add(rs.getString("hora_horario"));
            }
            return resultados;
        }catch(Exception e){
            return null;
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
    
    public void insertarVuelo(String origen, String destino, String fecha, String aerolinea,String costo,String hora) {
       try{
            String sql = "insert into vuelo (\"vuel_aerol_id\", \"vuel_ruta_id\", \"vuel_fecha\", \"vuel_precio\", \"vuel_hora\") "
                    + "values ("
                    + "(select aerol_id from aerolinea where aerol_nombre like('" + aerolinea + "')),"
                    + "(select ruta_id from ruta, origen, destino where ruta_orig_id=orig_id and ruta_dest_id=dest_id and orig_id="
                    + " (select ciud_id from ciudad where ciud_nombre like('" + origen + "')) and dest_id=(select ciud_id from ciudad "
                    + " where ciud_nombre like('" + destino + "'))),"
                    + "'" + fecha + "',"
                    + "'" + costo + "',"
                    + "'"+hora+"');";
            System.out.println(sql);
            PreparedStatement stmt = conexion.prepareStatement(sql);
            stmt.executeQuery();

        } catch (PSQLException ex){
            System.out.println("Insertado Satisfactoriamente");
        } catch (SQLException ex) {            
            Logger.getLogger(DataBaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Vuelo> getVuelosComprados(boolean comprado){
        
        try {    
            
            String sql_reserva="select vuus_vuel_id, vuus_fecha, vuus_hora  from "
                    + " vuelo_usuario where vuus_is_reserva='"+comprado+"'  and "+
                                "vuus_usua_cedula='"+Autenticacion.getInstance().getUsuario().getCedula()+"'";
            Statement stat = conexion.createStatement();
            ResultSet rs = stat.executeQuery(sql_reserva);
            ResultSetMetaData meta = rs.getMetaData();
            ArrayList<Vuelo> vuelos=new ArrayList<Vuelo>();
            vuelos.clear();
            System.out.println("LA CONSULTA="+sql_reserva);
            while (rs.next()) {                   
                Vuelo vuelo=new Vuelo();
                //(String)rs.getObject(i+1);            
                vuelo.setId(rs.getString("vuus_vuel_id"));
                Date date=convertirStringEnDate(rs.getString("vuus_fecha"));
                vuelo.setFecha(date);
                vuelo.setHorario(rs.getString("vuus_hora"));
                vuelo.setOrigen(getOrigen(vuelo.getId()));
                vuelo.setDestino(getDestino(vuelo.getId()));
                vuelos.add(vuelo);
            }
            
            return vuelos;
        }catch(Exception e){
            return null;
        }
    }
    
    private Date convertirStringEnDate(String fecha){
        int year=Integer.parseInt(fecha.substring(0, fecha.indexOf("-")));
        System.out.println("Year="+year);
        fecha=fecha.substring(fecha.indexOf("-")+1, fecha.length());
        System.out.println("Fecha="+fecha);
        int month=Integer.parseInt(fecha.substring(0, fecha.indexOf("-")));
        System.out.println("Mint="+month);
        fecha=fecha.substring(fecha.indexOf("-")+1, fecha.length());
        int day=Integer.parseInt(fecha);
        return new Date(year,month,day);
    }
    
    public String getOrigen(String id_vuelo){
        String sql_origen="select distinct ciud_nombre from vuelo ,ruta, ciudad, origen"+
                    " where "+
                    " vuel_ruta_id=ruta_id and "+
                    " ruta_orig_id=orig_id and "+
                    " orig_ciud_id=ciud_id and " +
                    " vuel_id='"+id_vuelo+"'";
        
        try {                   
            Statement stat = conexion.createStatement();
            ResultSet rs = stat.executeQuery(sql_origen);
            ResultSetMetaData meta = rs.getMetaData();
            String origen="";
            while (rs.next()) {
                //(String)rs.getObject(i+1);            
                origen =  rs.getString("ciud_nombre");
            }
            
            return origen;
        }catch(Exception e){
            return null;
        }
    }
    
    public String getDestino(String id_vuelo){
        String sql_destino="select distinct ciud_nombre from vuelo ,ruta, ciudad, destino"+
                    " where "+
                    " vuel_ruta_id=ruta_id and "+
                    " ruta_dest_id=dest_id and "+
                    " dest_ciud_id=ciud_id and " +
                    " vuel_id='"+id_vuelo+"'";
        
        
        try {                   
            Statement stat = conexion.createStatement();
            ResultSet rs = stat.executeQuery(sql_destino);
            ResultSetMetaData meta = rs.getMetaData();
            String destino="";
            while (rs.next()) {
                //(String)rs.getObject(i+1);            
                destino =  rs.getString("ciud_nombre");
            }
            return destino;
        }catch(Exception e){
            return null;
        }
    }
    
    public boolean insertarComprador(String id_vuelo, String id_usuario,boolean compra,int year,int month,int day){
          try {
              String fecha=String.valueOf(year)+"-"+String.valueOf(month)+
                    "-"+String.valueOf(day);
              Calendar cal = Calendar.getInstance();
                cal.getTime();
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            PreparedStatement stmt = conexion.prepareStatement("insert into vuelo_usuario"
                    + " (\"vuus_usua_cedula\", \"vuus_vuel_id\",\"vuus_is_reserva\", \"vuus_fecha\",\"vuus_hora\") "
                    + "values (?,?,?,'"+fecha+"','"+sdf.format(cal.getTime())+"')");
            stmt.setString(1, id_usuario);
            stmt.setInt(2, Integer.parseInt(id_vuelo));
            stmt.setBoolean(3, compra);
            
            //stmt.setString(4, fecha);
            stmt.toString();
            System.out.println(fecha);
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }        
    }
    
}
