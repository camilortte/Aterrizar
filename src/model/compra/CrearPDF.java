package model.compra;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import javax.swing.JFileChooser;
import model.consulta.Vuelo;


public class CrearPDF {
    Document documento ;
    GregorianCalendar horaActual;
    double total;
    
    public CrearPDF() {
        this.documento = new Document();
        this.horaActual = new GregorianCalendar();
        this.total=0.0;
    }
    
    private Image obtenerLogo(String aerolinea_nombre) throws BadElementException, MalformedURLException, IOException{
        Image logoAerolinea=null;
        
        if(aerolinea_nombre.compareTo("Avianca")==0){
            logoAerolinea = Image.getInstance("src/imagenes/avianca.png");
        }else if(aerolinea_nombre.compareTo("Satena")==0){
            logoAerolinea = Image.getInstance("src/imagenes/satena.png");
        }else if(aerolinea_nombre.compareTo("EasyFly")==0){
            logoAerolinea = Image.getInstance("src/imagenes/easyfly.png");
        }else if(aerolinea_nombre.compareTo("Delta")==0){
            logoAerolinea = Image.getInstance("src/imagenes/aeroRepublica.png");
        }else if(aerolinea_nombre.compareTo("Aires")==0){
            logoAerolinea = Image.getInstance("src/imagenes/aires.png");
        }
        
        return  logoAerolinea;
    }
    
    public void crearPDF(String aerolinea[],String usuario[],String factura[],ArrayList vuelos,String tipoFactura) throws DocumentException, FileNotFoundException, BadElementException, MalformedURLException, IOException{
        //aerolinea;//nombre de la aerolinea y telefono
        //usuario; //cedula,nombre, apellido, 
        //factura; //nombreFactura, numeroFactura, total costo
        //vuelo;//idVuelo, origen y destino.
        String factura_nombre = factura[0];
        String factura_numero = factura[1];
        String aerolinea_nombre=aerolinea[0];
        String aeroliena_telefono = aerolinea[1];
        String cliente_id = usuario[0];
        String cliente_nombreCompleto = usuario[1]+" "+usuario[2];
        String saltoLinea ="\n";
        String columnas[] = new String[4];
        
        columnas[0] = "id de vuelo";
        columnas[1] = "Origen";
        columnas[2] = "Destino";
        columnas[3] = "Costo";
        
        Image logoAerolinea=obtenerLogo(aerolinea_nombre); 
        Image barraAzul = Image.getInstance("src/imagenes/barra.png");
        Image firma = Image.getInstance("src/imagenes/firma.png");
        
        JFileChooser theFileChooser=new JFileChooser();
        System.out.println("FILEEEEEEEEEEEEEEE");
        int result = theFileChooser.showOpenDialog(null); 
        if (result == JFileChooser.APPROVE_OPTION) {
            factura_nombre=theFileChooser.getSelectedFile().toString();
        }
        
               
        PdfWriter.getInstance(documento,new FileOutputStream(factura_nombre+".pdf"));
        this.documento.open();
        this.documento.add(logoAerolinea);
        this.documento.add(barraAzul); 
        this.documento.add(new Paragraph("CONTACTO:"+saltoLinea));
        this.documento.add(new Paragraph("Telefono :"+aeroliena_telefono+saltoLinea));
        this.documento.add(barraAzul); 
        this.documento.add(new Paragraph("Factura # :"+factura_numero+saltoLinea));
        this.documento.add(barraAzul);        
        this.documento.add(new Paragraph("DATOS CLIENTE:"+saltoLinea+"CC:: "+cliente_id+saltoLinea+"Nombres y Apellidos : "+cliente_nombreCompleto));
        this.documento.add(barraAzul);
        this.documento.add(new Paragraph("DATOS VUELO"+saltoLinea+saltoLinea));
        this.documento.add(crearTabla(columnas,vuelos));
        this.documento.add(new Paragraph(saltoLinea));
        this.documento.add(barraAzul);
        this.documento.add(new Paragraph("COSTOS"));
        this.documento.add(new Paragraph("Total Factura : $"+total));
        this.documento.add(new Paragraph("Total a pagar : $"+total));
        this.documento.add(new Paragraph("Fecha de "+tipoFactura+":"+this.horaActual.getTime()));
        this.documento.add(barraAzul);
        this.documento.add(firma);
        this.documento.close();
        System.out.println("SE HA GENERADO SU FACTURA");
    }
    
    public void crearPDF(String aerolinea[],String usuario[],String factura[],ArrayList vuelos,String tipoFactura, String tipoPago) throws DocumentException, FileNotFoundException, BadElementException, MalformedURLException, IOException{
        //aerolinea;//nombre de la aerolinea y telefono
        //usuario; //cedula,nombre, apellido, 
        //factura; //nombreFactura, numeroFactura, total costo
        //vuelo;//idVuelo, origen y destino.
        String factura_nombre = factura[0];
        String factura_numero = factura[1];
        String aerolinea_nombre=aerolinea[0];
        String aeroliena_telefono = aerolinea[1];
        String cliente_id = usuario[0];
        String cliente_nombreCompleto = usuario[1]+" "+usuario[2];
        String saltoLinea ="\n";
        String columnas[] = new String[4];
        
        columnas[0] = "id de vuelo";
        columnas[1] = "Origen";
        columnas[2] = "Destino";
        columnas[3] = "Costo";
        
        Image logoAerolinea=obtenerLogo(aerolinea_nombre); 
        Image barraAzul = Image.getInstance("src/imagenes/barra.png");
        Image firma = Image.getInstance("src/imagenes/firma.png");
        
        JFileChooser theFileChooser=new JFileChooser();
        int result = theFileChooser.showOpenDialog(null); 
        if (result == JFileChooser.APPROVE_OPTION) {
            factura_nombre=theFileChooser.getSelectedFile().toString();
        }
               
        PdfWriter.getInstance(documento,new FileOutputStream(factura_nombre+".pdf"));
        this.documento.open();
        this.documento.add(logoAerolinea);
        this.documento.add(barraAzul); 
        this.documento.add(new Paragraph("CONTACTO:"+saltoLinea));
        this.documento.add(new Paragraph("Telefono :"+aeroliena_telefono+saltoLinea));
        this.documento.add(barraAzul); 
        this.documento.add(new Paragraph("Factura # :"+factura_numero+saltoLinea));
        this.documento.add(barraAzul);        
        this.documento.add(new Paragraph("DATOS CLIENTE:"+saltoLinea+"CC:: "+cliente_id+saltoLinea+"Nombres y Apellidos : "+cliente_nombreCompleto));
        this.documento.add(barraAzul);
        this.documento.add(new Paragraph("DATOS VUELO"+saltoLinea+saltoLinea));
        this.documento.add(crearTabla(columnas,vuelos));
        this.documento.add(new Paragraph(saltoLinea));
        this.documento.add(barraAzul);
        this.documento.add(new Paragraph("COSTOS"));
        this.documento.add(new Paragraph("Tipo de Pago : "+tipoPago));
        this.documento.add(new Paragraph("Total Factura : $"+total));
        this.documento.add(new Paragraph("Total a pagar : $"+total));
        this.documento.add(new Paragraph("Fecha de "+tipoFactura+":"+this.horaActual.getTime()));
        this.documento.add(barraAzul);
        this.documento.add(firma);
        this.documento.close();
        System.out.println("SE HA GENERADO SU FACTURA");
    }
    
    private PdfPTable crearTabla(String nombresColumnas[],ArrayList<Vuelo> vuelos){
        PdfPTable tabla = new PdfPTable(nombresColumnas.length);
        
        for(int i=0;i<nombresColumnas.length;i++){
            tabla.addCell(nombresColumnas[i]);
        }
        for(int i=0;i<vuelos.size();i++){
            tabla.addCell(vuelos.get(i).getId());
            tabla.addCell(vuelos.get(i).getOrigen());
            tabla.addCell(vuelos.get(i).getDestino());
            tabla.addCell(String.valueOf(vuelos.get(i).getPrecio()));
            total=total+Double.parseDouble(String.valueOf(vuelos.get(i).getPrecio()));
        }
        return tabla;
    }
    
}
    
