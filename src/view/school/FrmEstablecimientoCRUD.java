/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view.school;

import controller.data.ControladorEstablecimiento;
import controller.form.ControladorFrmEstablecimiento;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.constant.ListaCaracteresNoValidos;
import view.main.FrmPrincipal;


/**
 *
 * @author wally86
 */
public class FrmEstablecimientoCRUD extends javax.swing.JInternalFrame {

    private ControladorEstablecimiento controladorEstablecimiento;
    private ControladorFrmEstablecimiento controladorFrmEstablecimiento;
    /**
     * Creates new form FrmEstablecimientoAlta
     */
    public FrmEstablecimientoCRUD() {
        initComponents();
        this.controladorEstablecimiento=new ControladorEstablecimiento();
        this.controladorFrmEstablecimiento=new ControladorFrmEstablecimiento();
        this.controladorFrmEstablecimiento.ocultarLblInformativos(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblLocalidad = new javax.swing.JLabel();
        txtLocalidad = new javax.swing.JTextField();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lblInfoNombre = new javax.swing.JLabel();
        lblInfoLocalidad = new javax.swing.JLabel();

        setTitle("ALTA ESTABLECIMIENTO");
        setFrameIcon(null);
        setMinimumSize(new java.awt.Dimension(300, 200));
        setPreferredSize(new java.awt.Dimension(300, 200));
        getContentPane().setLayout(null);

        lblNombre.setText("Nombre");
        getContentPane().add(lblNombre);
        lblNombre.setBounds(15, 15, 70, 14);

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });
        getContentPane().add(txtNombre);
        txtNombre.setBounds(90, 10, 190, 20);

        lblLocalidad.setText("Localidad");
        getContentPane().add(lblLocalidad);
        lblLocalidad.setBounds(15, 65, 70, 14);

        txtLocalidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtLocalidadKeyTyped(evt);
            }
        });
        getContentPane().add(txtLocalidad);
        txtLocalidad.setBounds(90, 60, 190, 20);

        btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/model/image/checked21.png"))); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAceptar);
        btnAceptar.setBounds(10, 120, 110, 40);

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/model/image/cancel19.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelar);
        btnCancelar.setBounds(160, 120, 110, 40);

        lblInfoNombre.setFont(new java.awt.Font("Cantarell", 2, 10)); // NOI18N
        lblInfoNombre.setForeground(new java.awt.Color(246, 13, 13));
        lblInfoNombre.setText("Longitud max. de 100 caracteres");
        getContentPane().add(lblInfoNombre);
        lblInfoNombre.setBounds(90, 30, 190, 20);

        lblInfoLocalidad.setFont(new java.awt.Font("Cantarell", 2, 10)); // NOI18N
        lblInfoLocalidad.setForeground(new java.awt.Color(246, 13, 13));
        lblInfoLocalidad.setText("Longitud max. de 100 caracteres");
        getContentPane().add(lblInfoLocalidad);
        lblInfoLocalidad.setBounds(90, 80, 190, 20);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        int respuesta= JOptionPane.showConfirmDialog(this, "¿Esta seguro de Salir?","Salir",JOptionPane.YES_NO_OPTION);
        if(respuesta==JOptionPane.YES_OPTION){
            dispose();
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // TODO add your handling code here:
        int respuesta= JOptionPane.showConfirmDialog(this, "¿Esta seguro de Guardar Registro?","Guardar",JOptionPane.YES_NO_OPTION);
        if(respuesta==JOptionPane.YES_OPTION){
            this.controladorEstablecimiento.agregarEstablecimiento(this);
            JOptionPane.showMessageDialog(this, "Se guardo el Registro correctamente");
            dispose();
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        // TODO add your handling code here:
        String nombre = txtNombre.getText();
        if(nombre.length()>=100){
            evt.consume();
            controladorFrmEstablecimiento.mostrarLblInformativo(lblInfoNombre);
        }else{
            controladorFrmEstablecimiento.ocultarLblInformativo(lblInfoNombre);
        }
        for(char c : ListaCaracteresNoValidos.LISTA){
            if(evt.getKeyChar()==c){
                evt.consume();
                controladorFrmEstablecimiento.mostrarLblInformativo(lblInfoNombre);
            }
        }
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtLocalidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLocalidadKeyTyped
        // TODO add your handling code here:
        String localidad = txtNombre.getText();
        if(localidad.length()>=60){
            evt.consume();
            controladorFrmEstablecimiento.mostrarLblInformativo(lblInfoLocalidad);
        }else{
            controladorFrmEstablecimiento.ocultarLblInformativo(lblInfoLocalidad);
        }
        for(char c : ListaCaracteresNoValidos.LISTA){
            if(evt.getKeyChar()==c){
                evt.consume();
                controladorFrmEstablecimiento.mostrarLblInformativo(lblInfoLocalidad);
            }
        }
    }//GEN-LAST:event_txtLocalidadKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel lblInfoLocalidad;
    private javax.swing.JLabel lblInfoNombre;
    private javax.swing.JLabel lblLocalidad;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JTextField txtLocalidad;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
    public JTextField getTxtNombre(){
        return txtNombre;
    }
    public JTextField getTxtLocalidad(){
        return txtLocalidad;
    }
    public JLabel getLabelInfoNombre(){
        return lblInfoNombre;
    }
    public JLabel getLabelInfoLocalidad(){
        return lblInfoLocalidad;
    }
}
