/*
 * Usamos el patron de diseño Singletron para que nuestra clase se unica
 */
package model.consulta;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import model.persistencia.DataBaseManager;

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
      
    public List<List<Vuelo>> consultarVuelos(String origen, String destino, Calendar fecha){
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
        //generamos la consulta SQL
        String sql="SELECT * from origen,destino where ";
        
        //obtenemos una matriz
        List<List<String>> consulta=dataBase.consultar(sql);
        String strOrigen, strDestino="";//..
        for(List<String> item: consulta){  
            //falta agregar los campos
            strOrigen=item.get(0);
            strDestino=item.get(1);
            resultado.add(new Vuelo(strOrigen, strDestino, null, null, null));
        }  
        
        
        
        return null;
    }
    
  
    
}

