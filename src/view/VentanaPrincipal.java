/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * VentanaPrincipal.java
 *
 * Created on Nov 17, 2013, 3:17:39 PM
 */
package view;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.DocumentException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import model.compra.Comprar;
import model.compra.CrearPDF;
import model.compra.Reservar;
import model.consulta.Consulta;
import model.consulta.Vuelo;
import model.persistencia.ConexionDB;
import model.persistencia.DataBaseManager;
import model.sesion.Autenticacion;

/**
 *
 * @author camilortte
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    private Consulta consulta;
    private ArrayList<Vuelo> vuelos;

    /**
     * Creates new form VentanaPrincipal
     */
    public VentanaPrincipal() {
        initComponents();
        setLocationRelativeTo(null);
        rellenarCamposOrigenDestino();
        actualizarTablaComprasReservas();
        consulta = Consulta.getInstance();
        jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jCalendar_calendario = new com.toedter.calendar.JCalendar();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox_destino = new javax.swing.JComboBox();
        jComboBox_origen = new javax.swing.JComboBox();
        jButton_consultar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton_comprar = new javax.swing.JButton();
        jButton_reservar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jComboBox_tipoVuelos = new javax.swing.JComboBox();
        jButton_comprarReserva = new javax.swing.JButton();
        jToolBar1 = new javax.swing.JToolBar();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Seleccion"));

        jLabel2.setText("Destino");

        jLabel1.setText("Origen");

        jLabel3.setText("Fecha");

        jComboBox_origen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_origenActionPerformed(evt);
            }
        });

        jButton_consultar.setText("Consultar");
        jButton_consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_consultarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(27, 27, 27)
                        .addComponent(jComboBox_origen, 0, 384, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCalendar_calendario, javax.swing.GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton_consultar)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jComboBox_destino, 0, 386, Short.MAX_VALUE))))
                .addGap(31, 31, 31))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox_origen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox_destino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jCalendar_calendario, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_consultar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Resultados"));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton_comprar.setText("Comprar vuelo seleccionado");
        jButton_comprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_comprarActionPerformed(evt);
            }
        });

        jButton_reservar.setText("Reservar vuelo");
        jButton_reservar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_reservarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton_reservar, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton_comprar)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_comprar)
                    .addComponent(jButton_reservar))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Mis vuelos"));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jComboBox_tipoVuelos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Comprados", "Reservados" }));
        jComboBox_tipoVuelos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_tipoVuelosActionPerformed(evt);
            }
        });

        jButton_comprarReserva.setText("Comprar");
        jButton_comprarReserva.setEnabled(false);
        jButton_comprarReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_comprarReservaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox_tipoVuelos, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addComponent(jButton_comprarReserva))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jComboBox_tipoVuelos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton_comprarReserva)
                .addContainerGap())
        );

        jToolBar1.setRollover(true);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logout.png"))); // NOI18N
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rellenarCamposOrigenDestino() {
        try {
            ConexionDB con = new ConexionDB();
            DataBaseManager.getInstance().setConexionDB(con);
            Connection conexion = con.getConexion();
            Statement stat = conexion.createStatement();
            ResultSet rs = stat.executeQuery("select CIUD_nombre from ciudad,origen where CIUD_id=ORIG_CIUD_id");
            String item_seleccionado_origen = "";
            while (rs.next()) {
                jComboBox_origen.addItem(rs.getString("CIUD_nombre"));
                item_seleccionado_origen = (String) jComboBox_origen.getSelectedItem();
                jComboBox_destino.addItem(rs.getString("CIUD_nombre"));
            }
            jComboBox_destino.setSelectedIndex(1);
            /*rs.close();
             stat.close();
             conexion.close();*/
        } catch (SQLException ex) {
            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

private void jButton_consultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_consultarActionPerformed

    if (jComboBox_origen.getItemCount() <= 0 || !jCalendar_calendario.isValid()) {
        JOptionPane.showMessageDialog(this, "Debe ingresar los datos");
    } else {

        if (jComboBox_origen.getSelectedItem().toString().compareTo(jComboBox_destino.getSelectedItem().toString())==0) {
                JOptionPane.showMessageDialog(this, "Debe seleccionar ciudades diferentes");
                DefaultTableModel tablemodel = new DefaultTableModel();
                    jTable1.setModel(tablemodel);
        } else {
            Calendar fecha = jCalendar_calendario.getCalendar();
            Calendar nowDate = Calendar.getInstance();

            if (!fecha.before(nowDate)) {

                vuelos = consulta.consultarVuelos(
                        (String) this.jComboBox_origen.getSelectedItem(),
                        (String) this.jComboBox_destino.getSelectedItem(),
                        fecha);
                if (vuelos != null) {
                    actualizarTabla(vuelos);
                } else {
                    JOptionPane.showMessageDialog(this, "No se encontraron vuelos",
                            "Erorr", JOptionPane.ERROR_MESSAGE);

                    DefaultTableModel tablemodel = new DefaultTableModel();
                    jTable1.setModel(tablemodel);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Debe seleccionar una fecha mayor a la de hoy");
            }
        }
    }
}//GEN-LAST:event_jButton_consultarActionPerformed

private void jButton_comprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_comprarActionPerformed
    if (jTable1.getSelectedRow() != -1) {

        int fila = jTable1.getSelectedRows()[0];

        Calendar calend = jCalendar_calendario.getCalendar();
        String date = String.valueOf(calend.get(Calendar.YEAR));

        Vuelo vuelo_a_comprar = new Vuelo(
                jTable1.getModel().getValueAt(fila, 0).toString(),
                jComboBox_origen.getSelectedItem().toString(),
                jComboBox_destino.getSelectedItem().toString(),
                jTable1.getModel().getValueAt(fila, 1).toString(),
                date,
                jTable1.getModel().getValueAt(fila, 2).toString(),
                Double.parseDouble(jTable1.getModel().getValueAt(fila, 3).toString()),
                jTable1.getModel().getValueAt(fila, 4).toString());

        Vuelo vuelo = new Vuelo();
        vuelo.setId(jTable1.getModel().getValueAt(fila, 0).toString());
        vuelo.setOrigen(jComboBox_origen.getSelectedItem().toString());
        vuelo.setDestino(jComboBox_destino.getSelectedItem().toString());
        vuelo.setEscala(jTable1.getModel().getValueAt(fila, 1).toString());
        vuelo.setAerolinea(jTable1.getModel().getValueAt(fila, 2).toString());
        vuelo.setPrecio(Double.parseDouble(jTable1.getModel().getValueAt(fila, 3).toString()));

        Calendar cal = Calendar.getInstance();
        Comprar comprar = new Comprar(Autenticacion.getInstance().getUsuario(),
                Double.parseDouble(jTable1.getModel().getValueAt(fila, 3).toString()),
                cal,
                "Tipo_pago",
                vuelo);

        boolean insertado = comprar.realziarCompra();

        if (insertado) {
            JOptionPane.showMessageDialog(this, "Se procedera con la compra", "Bien", JOptionPane.INFORMATION_MESSAGE);
            //(new Compra()).setVisible(true);
            CrearPDF pdf = new CrearPDF();
            String aerolinea[] = new String[2];
            String usuario[] = new String[3];
            String factura[] = new String[2];
            String vueloS[] = new String[4];
            int N = 10000;
            int M = 1000;
            int numeroFactura = (int) Math.floor(Math.random() * (N - M + 1) + M);  // Valor entre M y N, ambos incluidos.

            ArrayList<Vuelo> vuelosAFacturar = new ArrayList<Vuelo>();
            vuelosAFacturar.add(vuelo);

            aerolinea[0] = jTable1.getModel().getValueAt(fila, 2).toString();
            aerolinea[1] = "";
            usuario[0] = Autenticacion.getInstance().getUsuario().getCedula().toString();
            usuario[1] = Autenticacion.getInstance().getUsuario().getNombre();
            usuario[2] = "";

            vueloS[0] = jTable1.getModel().getValueAt(fila, 0).toString();//el id del vuelo
            vueloS[1] = jComboBox_origen.getSelectedItem().toString();
            vueloS[2] = jComboBox_destino.getSelectedItem().toString();//destino.
            vueloS[3] = jTable1.getModel().getValueAt(fila, 3).toString();//valor o costo

            factura[0] = "Factura De Venta";
            factura[1] = String.valueOf(numeroFactura);

            String tipoFactura = "Compra";//puede ser REserva.
            try {
                    
                pdf.crearPDF(aerolinea, usuario, factura, vuelosAFacturar, tipoFactura);
            } catch (DocumentException ex) {
                Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            } catch (MalformedURLException ex) {
                Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }

            actualizarTablaComprasReservas();

            //generar Factura :)
        } else {
            JOptionPane.showMessageDialog(this, "Lo sentimos ud no puede volver a comprar este vuelo", "Bien", JOptionPane.ERROR_MESSAGE);
        }

    } else {
        JOptionPane.showMessageDialog(this, "Debe seleccionar un vuelo", "Error", JOptionPane.ERROR_MESSAGE);
    }
}//GEN-LAST:event_jButton_comprarActionPerformed

    private void actualizarTablaComprasReservas() {
        if (jComboBox_tipoVuelos.getSelectedItem().toString().compareTo("Comprados") == 0) {
            ArrayList<Vuelo> vuelos = DataBaseManager.getInstance().getVuelosComprados(true);
            for (Vuelo vuelo : vuelos) {
                System.out.println("Esto es el vuelo= " + vuelo.getOrigen() + " "
                        + vuelo.getDestino() + " " + vuelo.getFecha() + " "
                        + vuelo.getHorario());
            }

            DefaultTableModel model = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            model.setColumnIdentifiers(new String[]{"id", "Origen ", "Destino", "Fecha-compra", "Hora"});

            for (Vuelo item : vuelos) {
                //for(Vuelo vuelo: item){
                model.addRow(new String[]{
                    item.getId(),
                    item.getOrigen(),
                    item.getDestino(),
                    item.getFecha().toString(),
                    item.getHorario(),});
                //}   
            }
            jTable2.setModel(model);

        } else {
            ArrayList<Vuelo> vuelos = DataBaseManager.getInstance().getVuelosComprados(false);
            for (Vuelo vuelo : vuelos) {
                System.out.println("Esto es el vuelo= " + vuelo.getOrigen() + " "
                        + vuelo.getDestino() + " " + vuelo.getFecha() + " "
                        + vuelo.getHorario());
            }

            DefaultTableModel model = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            model.setColumnIdentifiers(new String[]{"id", "Origen ", "Destino", "Fecha", "Hora"});

            for (Vuelo item : vuelos) {
                //for(Vuelo vuelo: item){
                model.addRow(new String[]{
                    item.getId(),
                    item.getOrigen(),
                    item.getDestino(),
                    item.getFecha().toString(),
                    item.getHorario(),});
                //}   
            }
            jTable2.setModel(model);
            jButton_comprarReserva.setEnabled(true);
            
        }
    }

private void jButton_reservarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_reservarActionPerformed
    if (jTable1.getSelectedRow() != -1) {

        int fila = jTable1.getSelectedRows()[0];

        Calendar calend = jCalendar_calendario.getCalendar();
        String date = String.valueOf(calend.get(Calendar.YEAR));
        Vuelo vuelo_a_comprar = new Vuelo(
                jTable1.getModel().getValueAt(fila, 0).toString(),
                jComboBox_origen.getSelectedItem().toString(),
                jComboBox_destino.getSelectedItem().toString(),
                jTable1.getModel().getValueAt(fila, 1).toString(),
                date,
                jTable1.getModel().getValueAt(fila, 2).toString(),
                Double.parseDouble(jTable1.getModel().getValueAt(fila, 3).toString()),
                jTable1.getModel().getValueAt(fila, 4).toString());

        Vuelo vuelo = new Vuelo();
        vuelo.setId(jTable1.getModel().getValueAt(fila, 0).toString());
        vuelo.setOrigen(jComboBox_origen.getSelectedItem().toString());
        vuelo.setDestino(jComboBox_destino.getSelectedItem().toString());
        vuelo.setEscala(jTable1.getModel().getValueAt(fila, 1).toString());
        vuelo.setAerolinea(jTable1.getModel().getValueAt(fila, 2).toString());

        Calendar cal = Calendar.getInstance();
        Reservar reservar = new Reservar(Autenticacion.getInstance().getUsuario(),
                Double.parseDouble(jTable1.getModel().getValueAt(fila, 3).toString()),
                cal,
                vuelo);

        boolean insertado = reservar.realziarReserva();

        if (insertado) {
            JOptionPane.showMessageDialog(this, "Su vuelo se reservarA por 24 horas", "Bien", JOptionPane.INFORMATION_MESSAGE);
            actualizarTablaComprasReservas();
            this.actualizarTabla(vuelos);
            //generar Factura :)
        } else {
            JOptionPane.showMessageDialog(this, "Lo sentimos ud no puede volver a comprar este vuelo", "Bien", JOptionPane.ERROR_MESSAGE);
        }

    } else {
        JOptionPane.showMessageDialog(this, "Debe seleccionar un vuelo", "Error", JOptionPane.ERROR_MESSAGE);
    }
}//GEN-LAST:event_jButton_reservarActionPerformed

private void jComboBox_tipoVuelosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_tipoVuelosActionPerformed
    actualizarTablaComprasReservas();
}//GEN-LAST:event_jComboBox_tipoVuelosActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.dispose();
        (new Login()).setVisible(true);
        Autenticacion.getInstance().setUsuario(null);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jComboBox_origenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_origenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_origenActionPerformed

    private void jButton_comprarReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_comprarReservaActionPerformed
        int row=jTable2.getSelectedRow();
        if(row<0){
            JOptionPane.showMessageDialog(this, "Debe seleccionar una fila ");            
        }else{
            if(DataBaseManager.getInstance().actualizarCompra(Autenticacion.getInstance().getUsuario().getCedula(),
                     jTable2.getModel().getValueAt(row, 0).toString())){
                JOptionPane.showMessageDialog(this, "Se procede a comprar");
                                
                actualizarTablaComprasReservas();
            }else{
                JOptionPane.showMessageDialog(this, "No puede comprar este vuelo");
            }
        }
    }//GEN-LAST:event_jButton_comprarReservaActionPerformed

//actualiza la tabla a partir de unos datos dados
    private void actualizarTabla(ArrayList<Vuelo> items) {
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        model.setColumnIdentifiers(new String[]{"id", "Ecala ", "Aerolinea", "Precio", "Horario"});

        for (Vuelo item : items) {
            //for(Vuelo vuelo: item){
            model.addRow(new String[]{
                item.getId(),
                item.getEscala(),
                item.getAerolinea(),
                String.valueOf(item.getPrecio()),
                item.getHorario()
            });
            //}   
        }
        jTable1.setModel(model);

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton_comprar;
    private javax.swing.JButton jButton_comprarReserva;
    private javax.swing.JButton jButton_consultar;
    private javax.swing.JButton jButton_reservar;
    private com.toedter.calendar.JCalendar jCalendar_calendario;
    private javax.swing.JComboBox jComboBox_destino;
    private javax.swing.JComboBox jComboBox_origen;
    private javax.swing.JComboBox jComboBox_tipoVuelos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
