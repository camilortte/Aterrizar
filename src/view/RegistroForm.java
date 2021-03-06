/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * RegistroForm.java
 *
 * Created on Nov 22, 2013, 3:35:04 AM
 */
package view;

import Cifrado.Seguridad;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.persistencia.DataBaseManager;
import model.usuario.Usuario;

/**
 *
 * @author camilortte
 */
public class RegistroForm extends javax.swing.JFrame {

    /** Creates new form RegistroForm */
    public RegistroForm() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton_volver = new javax.swing.JButton();
        jButton_registrar = new javax.swing.JButton();
        jTextField_cedula = new javax.swing.JTextField();
        jTextField_apellido = new javax.swing.JTextField();
        jTextField_email = new javax.swing.JTextField();
        jTextField_nombre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jPasswordField2 = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Registro");

        jButton_volver.setText("volver");
        jButton_volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_volverActionPerformed(evt);
            }
        });

        jButton_registrar.setText("Registrar");
        jButton_registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_registrarActionPerformed(evt);
            }
        });

        jLabel1.setText("Cedula");

        jLabel2.setText("Nombre");

        jLabel3.setText("Apellido");

        jLabel4.setText("Email");

        jLabel5.setText("Pass");

        jLabel6.setText("Pass otra vez");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField_cedula, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                            .addComponent(jTextField_nombre, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                            .addComponent(jTextField_apellido, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                            .addComponent(jTextField_email, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                            .addComponent(jPasswordField1, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                            .addComponent(jPasswordField2, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton_volver)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 273, Short.MAX_VALUE)
                        .addComponent(jButton_registrar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField_cedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jTextField_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jTextField_apellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_registrar)
                    .addComponent(jButton_volver))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void jButton_volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_volverActionPerformed
    this.dispose();
    (new Login()).setVisible(true);
}//GEN-LAST:event_jButton_volverActionPerformed

private void jButton_registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_registrarActionPerformed
    if (this.jPasswordField1.getText() != "" || this.jPasswordField2.getText() != ""
            || this.jTextField_nombre.getText() != "" || this.jTextField_apellido.getText() != ""
            && this.jTextField_cedula.getText() != "" || this.jTextField_email.getText() != "") {

        if (jPasswordField1.getText().compareTo(jPasswordField2.getText())!=0) {
            JOptionPane.showMessageDialog(this, "Error las contraseñas no coinciden", "Erro", JOptionPane.ERROR_MESSAGE);
        } else {
            Usuario usuario = new Usuario();
            usuario.setCedula(this.jTextField_cedula.getText());
            usuario.setNombre(this.jTextField_nombre.getText());
            usuario.setApellido(this.jTextField_apellido.getText());
            usuario.setEmail(this.jTextField_email.getText());

            String pass;
            try {
                pass = Seguridad.getInstance().encriptar(this.jPasswordField1.getText());
                boolean bine=DataBaseManager.getInstance().insertar_usuairo(usuario, pass);
                
                if(bine){
                    System.out.println("Se insert");
                    this.dispose();
                    (new Login()).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(this, "Debe ingresar los datos solicitados","Error",JOptionPane.ERROR_MESSAGE);
                    System.out.println("Mpo se inserto");
                }
                
            } catch (Exception ex) {
                Logger.getLogger(RegistroForm.class.getName()).log(Level.SEVERE, null, ex);
            }

            
            
        }
    } else {
        JOptionPane.showMessageDialog(this, "Error no pueden haber datos vacios", "Erro", JOptionPane.ERROR_MESSAGE);
    }
}//GEN-LAST:event_jButton_registrarActionPerformed

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
            java.util.logging.Logger.getLogger(RegistroForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new RegistroForm().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_registrar;
    private javax.swing.JButton jButton_volver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JTextField jTextField_apellido;
    private javax.swing.JTextField jTextField_cedula;
    private javax.swing.JTextField jTextField_email;
    private javax.swing.JTextField jTextField_nombre;
    // End of variables declaration//GEN-END:variables
}
