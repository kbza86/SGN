/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vista.login;


import controller.data.ControllerUser;

import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import model.constant.ListaCaracteresNoValidos;
import view.main.FrmPrincipal;
import view.user.FrmUser;


/**
 *
 * @author wally86
 */
public class FrmLogin extends javax.swing.JInternalFrame {

    private ControllerUser usuarioControlador;
    private FrmPrincipal frmPrincipal;
    /**
     * Creates new form NewJInternalFrame
     * @param frmPrincipal
     */
    public FrmLogin(FrmPrincipal frmPrincipal) {
        initComponents();
        this.frmPrincipal=frmPrincipal;
        this.lblInfoNomUsu.setVisible(false);
        this.lblInfoPassUsu.setVisible(false);
        usuarioControlador=new ControllerUser();
        centrarFrame();
    }

    private void centrarFrame(){
        int x = (frmPrincipal.getDesktopPane().getWidth()/2) - this.getWidth()/2;
        int y = (frmPrincipal.getDesktopPane().getHeight()/2) -this.getHeight()/2;
        
        this.setLocation(x, y);
        
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblUsuario = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        lblPassword = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        btnIngresar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        lblInfoNomUsu = new javax.swing.JLabel();
        lblInfoPassUsu = new javax.swing.JLabel();

        setTitle("INGRESE AL SISTEMA");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/model/image/lock39.png"))); // NOI18N
        setMinimumSize(new java.awt.Dimension(310, 165));
        setPreferredSize(new java.awt.Dimension(310, 165));
        getContentPane().setLayout(null);

        lblUsuario.setText("Usuario");
        getContentPane().add(lblUsuario);
        lblUsuario.setBounds(10, 15, 90, 20);

        txtUsuario.setPreferredSize(new java.awt.Dimension(150, 26));
        txtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyTyped(evt);
            }
        });
        getContentPane().add(txtUsuario);
        txtUsuario.setBounds(100, 12, 150, 26);

        lblPassword.setText("Password");
        getContentPane().add(lblPassword);
        lblPassword.setBounds(10, 60, 110, 14);

        txtPassword.setPreferredSize(new java.awt.Dimension(150, 26));
        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPasswordKeyTyped(evt);
            }
        });
        getContentPane().add(txtPassword);
        txtPassword.setBounds(100, 55, 150, 26);

        btnIngresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/model/image/si.png"))); // NOI18N
        btnIngresar.setText("Ingresar");
        btnIngresar.setPreferredSize(new java.awt.Dimension(120, 26));
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });
        getContentPane().add(btnIngresar);
        btnIngresar.setBounds(10, 100, 120, 26);

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/model/image/no.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.setPreferredSize(new java.awt.Dimension(120, 26));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir);
        btnSalir.setBounds(170, 100, 120, 26);

        lblInfoNomUsu.setFont(new java.awt.Font("Cantarell", 2, 10)); // NOI18N
        lblInfoNomUsu.setForeground(new java.awt.Color(244, 19, 19));
        lblInfoNomUsu.setText("Longitud max. de 10 caracteres");
        getContentPane().add(lblInfoNomUsu);
        lblInfoNomUsu.setBounds(100, 33, 147, 20);

        lblInfoPassUsu.setFont(new java.awt.Font("Cantarell", 2, 10)); // NOI18N
        lblInfoPassUsu.setForeground(new java.awt.Color(244, 19, 19));
        lblInfoPassUsu.setText("Longitud max. de 10 caracteres");
        getContentPane().add(lblInfoPassUsu);
        lblInfoPassUsu.setBounds(100, 75, 147, 20);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyTyped
        // TODO add your handling code here:
        String nombre = txtUsuario.getText();
        if(nombre.length()>=10 && evt.getKeyChar()!=KeyEvent.VK_BACK_SPACE){
            evt.consume();
            this.lblInfoNomUsu.setVisible(true);
        }else{
            this.lblInfoNomUsu.setVisible(false);
        }
        for(Character c : ListaCaracteresNoValidos.LISTA){
            if(c==evt.getKeyChar()){
                evt.consume();
                JOptionPane.showMessageDialog(this, "Caracter no permitido");
            }
        }
    }//GEN-LAST:event_txtUsuarioKeyTyped

    private void txtPasswordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyTyped
        // TODO add your handling code here:
        
        String password = String.valueOf(txtPassword.getPassword());
        if(password.length()>=10 && evt.getKeyChar()!=KeyEvent.VK_BACK_SPACE){
            evt.consume();
            this.lblInfoPassUsu.setVisible(true);
        }else{
            this.lblInfoPassUsu.setVisible(false);
        }
        if(evt.getKeyChar()==KeyEvent.VK_ENTER){
            ingresar();
        }
    }//GEN-LAST:event_txtPasswordKeyTyped

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        // TODO add your handling code here:
        ingresar();
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void ingresar(){
        if(this.usuarioControlador.validarUsuario(this)){
            this.dispose();
            JOptionPane.showMessageDialog(frmPrincipal, "Bienvenido a SGN");
            FrmUser frmUsuario = new FrmUser(frmPrincipal);           
            frmUsuario.setVisible(true);           
            frmPrincipal.getControladorFormulario().habilitarMenu(frmPrincipal.getMenuRte());
            frmPrincipal.getControladorFormulario().habilitarMenu(frmPrincipal.getMenuHerramientas());
            frmPrincipal.getControladorFormulario().deshabilitarMenuItem(frmPrincipal.getMenuItemInicio());
            frmPrincipal.getControladorFormulario().habilitarMenuItem(frmPrincipal.getMenuItemCerrarSesion());
            this.frmPrincipal.getJDesktopPane().add(frmUsuario);
            

        }else{
            JOptionPane.showMessageDialog(this, "Usuario incorrecto");
        }
    }
    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel lblInfoNomUsu;
    private javax.swing.JLabel lblInfoPassUsu;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
    public JTextField getJTextFieldUsuario(){
        return this.txtUsuario;
    }
     public JPasswordField getJPasswordFieldUsuario(){
        return this.txtPassword;
    }
}
