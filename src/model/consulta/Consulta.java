/*
 * Usamos el patron de diseño Singletron para que nuestra clase se unica
 */
package model.consulta;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import model.aerolinea.Aerolinea;
import model.persistencia.DataBaseManager;
import model.sesion.Autenticacion;
import model.usuario.Usuario;

/**
 * @author camilortte
 */
public class Consulta {
    private static Consulta instance=null;
    private static DataBaseManager dataBase;
    private Consulta() {    }

    public static synchronized Consulta getInstance(){
        if (instance==null){
            instance=new  Consulta();
        }
        return instance;
    }
      
    public ArrayList<Vuelo> consultarVuelos(String origen, String destino, Calendar fecha){
        //todo el codigo referente para consultar todos los vuelos
        
        /*realizar la consulta de todos los vuelos en todas la aerolineas que
         * tengan como oringe y destino y fecha los datos proporcionados y si
         * tienen escala, organizarlos en un array con los atributos
         * 
         * ID_vuelo Aerolinea Origen Destino Escala Precio Distancia
         * 
         */
        dataBase=DataBaseManager.getInstance();
        ArrayList<Vuelo> resultado=new ArrayList<Vuelo>();
        resultado.clear();        
        
        int year = fecha.get(Calendar.YEAR);
        int month = fecha.get(Calendar.MONTH)+1;
        int day = fecha.get(Calendar.DAY_OF_MONTH);
        
        
        String fecha_s=String.valueOf(year)+"-"+
                String.valueOf(month)+"-"+
                String.valueOf(day);
        
        //generamos la consulta SQL
        String sql="select vuel_id, esca_id, aerol_nombre, vuel_precio, vuel_hora"+
        " from vuelo, aerolinea, ruta, origen, destino, escala where "+
        " vuel_ruta_id=ruta_id and"+
        " ruta_orig_id=orig_id and"+
        " ruta_dest_id=dest_id and"+
        " ruta_esca_id=esca_id and"+
        " vuel_aerol_id=aerol_id and"+
        " orig_id=(select ciud_id from ciudad where ciud_nombre like ('"+origen+"')) and"+
        " dest_id=(select ciud_id from ciudad where ciud_nombre like ('"+destino+"')) and"
        +" vuel_fecha= '"+fecha_s+"' and "
        + " vuel_id  not in (select vuus_vuel_id from vuelo_usuario where vuus_usua_cedula='"+
                    Autenticacion.getInstance().getUsuario().getCedula()+"')";
        System.out.println(sql);
        //obtenemos una matriz
        List<List<String>> consulta=dataBase.consultar(sql);
        if(consulta!=null){
            String escala="", aerolinea="", precio="",id="",horario= "";//..
            for(List<String> item: consulta){  
                //falta agregar los campos
                id=item.get(0);
                escala=item.get(1);
                aerolinea=item.get(2);
                precio=item.get(3);    
                horario=item.get(4);    
                Date date=new Date(fecha.get(Calendar.YEAR),fecha.get(Calendar.MONTH)+1, fecha.get(Calendar.DAY_OF_MONTH));
                resultado.add(new Vuelo(id,origen, destino,escala,date,aerolinea,Double.parseDouble(precio),horario));
                //System.out.println("Se agrega="+aerolinea);
            }              
            return resultado;
        }else{
            return null;
        }
    }
    
     public Usuario consultarUsuario(String username, String password){        
        Usuario usuario=null;
        dataBase=DataBaseManager.getInstance();
        ArrayList<Vuelo> resultado=new ArrayList<Vuelo>();
        resultado.clear();
        //generamos la consulta SQL
        String sql="Select USUA_nombre,USUA_apellido, USUA_correo,USUA_cedula from USUARIO "
                + "where USUA_cedula='"+username+"' AND USUA_clave='"+password+"'";
        
        //obtenemos una matriz
        List<List<String>> consulta=dataBase.consultar(sql);
        if(consulta==null){
            return null;
        }else{                    
            usuario=new Usuario();
            for(List<String> item: consulta){                  
                usuario.setNombre(item.get(0));
                usuario.setApellido(item.get(1));
                usuario.setEmail(item.get(2));                
                usuario.setCedula(item.get(3));   
            }  
            System.out.println("Usuario="+usuario.getNombre());
            return usuario;
        }
        
        
    }
  
    
}

