/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.migrar;

import controller.data.ControladorEstablecimiento;
import controller.data.ControladorDestino;
import controller.form.ControladorFrmMigrarPrincipal;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import model.domain.Establecimiento;
import view.user.FrmUser;

/**
 *
 * @author wally86
 */
public class FrmMigrarCRUD extends javax.swing.JInternalFrame {

    private FrmUser frmUsuario;
    private char tipoTransaccion;
    private ControladorEstablecimiento controladorEstablecimiento;
    private ControladorDestino controladorDestino;
    private ControladorFrmMigrarPrincipal controladorFrmMigrarPrincipal;

    /**
     * Creates new form FrmMigrarPrincipal
     *
     * @param frmUsuario
     * @param tipoTransaccion
     */
    public FrmMigrarCRUD(FrmUser frmUsuario, char tipoTransaccion) {
        initComponents();
        this.frmUsuario = frmUsuario;
        this.tipoTransaccion = tipoTransaccion;
        this.controladorFrmMigrarPrincipal = new ControladorFrmMigrarPrincipal();
        this.controladorDestino = new ControladorDestino();
        this.controladorEstablecimiento = new ControladorEstablecimiento();
        cargarDatosTitular();
        cargarDatosCmb();
    }

    private void cargarDatosCmb() {
        this.cmbEstablecimientos.removeAllItems();
        this.cmbEstablecimientos.addItem("Seleccione Colegio");
        for (Establecimiento e : controladorEstablecimiento.obtenerTodosEstablecimientos()) {
            cmbEstablecimientos.addItem(e.getNombre());
        }
    }

    private void cargarDatosTitular() {
        switch (this.tipoTransaccion) {
            case 'a':
                controladorFrmMigrarPrincipal.deshabilitarCampos(this);
                 if(frmUsuario.getTblAlumno().getValueAt(frmUsuario.getTblAlumno().getSelectedRow(), 1).equals("DOCENTE")){
                    
                     txtApellidoAlumno.setText(this.frmUsuario.getControladorProfesor().getPersonaProfesor().getApellido());
                     txtNombreAlumno.setText(this.frmUsuario.getControladorProfesor().getPersonaProfesor().getNombre());
                     txtDniAlumno.setText(String.valueOf(this.frmUsuario.getControladorProfesor().getPersonaProfesor().getDni()));
                     txtCursoAlumno.setText("X");
                     txtDivisionAlumno.setText("X");
                 }else{
                txtApellidoAlumno.setText(this.frmUsuario.getControladorAlumno().getPersonaAlumno().getApellido());
                txtNombreAlumno.setText(this.frmUsuario.getControladorAlumno().getPersonaAlumno().getNombre());
                txtDniAlumno.setText(String.valueOf(this.frmUsuario.getControladorAlumno().getPersonaAlumno().getDni()));
                txtCursoAlumno.setText(this.frmUsuario.getControladorAlumno().getAlumno().getCurso());
                txtDivisionAlumno.setText(this.frmUsuario.getControladorAlumno().getAlumno().getDivision());
                 }
                break;
            case 'm':
                break;
            case 'v':
                break;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnlTitular = new javax.swing.JPanel();
        lblNombreAlumno = new javax.swing.JLabel();
        txtDniAlumno = new javax.swing.JTextField();
        lblApellidoAlumno = new javax.swing.JLabel();
        txtApellidoAlumno = new javax.swing.JTextField();
        lblDniAlumno = new javax.swing.JLabel();
        txtNombreAlumno = new javax.swing.JTextField();
        lblCursoAlumno = new javax.swing.JLabel();
        txtCursoAlumno = new javax.swing.JTextField();
        lblDivision = new javax.swing.JLabel();
        txtDivisionAlumno = new javax.swing.JTextField();
        jpnlDestino = new javax.swing.JPanel();
        lblDestino = new javax.swing.JLabel();
        cmbEstablecimientos = new javax.swing.JComboBox();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setTitle("MIGRACIÓN DE ALUMNO");
        setFrameIcon(null);
        setMinimumSize(new java.awt.Dimension(500, 350));
        setPreferredSize(new java.awt.Dimension(500, 350));
        getContentPane().setLayout(null);

        jpnlTitular.setBorder(javax.swing.BorderFactory.createTitledBorder("Alumno"));
        jpnlTitular.setLayout(null);

        lblNombreAlumno.setText("Nombre");
        jpnlTitular.add(lblNombreAlumno);
        lblNombreAlumno.setBounds(250, 65, 70, 14);
        jpnlTitular.add(txtDniAlumno);
        txtDniAlumno.setBounds(80, 25, 150, 20);

        lblApellidoAlumno.setText("Apellido");
        jpnlTitular.add(lblApellidoAlumno);
        lblApellidoAlumno.setBounds(20, 60, 70, 20);
        jpnlTitular.add(txtApellidoAlumno);
        txtApellidoAlumno.setBounds(80, 60, 150, 20);

        lblDniAlumno.setText("Dni");
        jpnlTitular.add(lblDniAlumno);
        lblDniAlumno.setBounds(20, 30, 40, 14);
        jpnlTitular.add(txtNombreAlumno);
        txtNombreAlumno.setBounds(330, 60, 150, 20);

        lblCursoAlumno.setText("Curso");
        jpnlTitular.add(lblCursoAlumno);
        lblCursoAlumno.setBounds(20, 100, 60, 14);
        jpnlTitular.add(txtCursoAlumno);
        txtCursoAlumno.setBounds(80, 95, 40, 20);

        lblDivision.setText("Division");
        jpnlTitular.add(lblDivision);
        lblDivision.setBounds(130, 100, 70, 14);
        jpnlTitular.add(txtDivisionAlumno);
        txtDivisionAlumno.setBounds(190, 95, 40, 20);

        getContentPane().add(jpnlTitular);
        jpnlTitular.setBounds(0, 0, 490, 140);

        jpnlDestino.setBorder(javax.swing.BorderFactory.createTitledBorder("Destino"));
        jpnlDestino.setLayout(null);

        lblDestino.setText("Colegio");
        jpnlDestino.add(lblDestino);
        lblDestino.setBounds(18, 37, 80, 30);

        cmbEstablecimientos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jpnlDestino.add(cmbEstablecimientos);
        cmbEstablecimientos.setBounds(80, 40, 200, 20);

        getContentPane().add(jpnlDestino);
        jpnlDestino.setBounds(0, 140, 490, 110);

        btnAceptar.setText("Guardar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAceptar);
        btnAceptar.setBounds(70, 260, 120, 23);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelar);
        btnCancelar.setBounds(350, 260, 120, 23);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        int respuesta = JOptionPane.showConfirmDialog(this, "¿Desea Salir?", "Salir", JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION) {
            dispose();
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // TODO add your handling code here:
        int respuesta = JOptionPane.showConfirmDialog(this, "¿Esta seguro de guardar el registro?", "Guardar", JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION) {
            if (!controladorDestino.verificarExistencia(this)) {
                if(frmUsuario.getControladorAlumno().getNetbook().isEstado()){
                    getControladorDestino().altaMigracion(this);
                JOptionPane.showConfirmDialog(this, "Se guardo el registro correctamente");
                frmUsuario.getControladorFormularioUsuario().actualizarCantidadMigraciones(frmUsuario);
                dispose();
                }else{
                    JOptionPane.showMessageDialog(this, "Imposible realizar la migración, La netbook está osciosa");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Esta persona ya posee una migracion");
            }
        }
    }//GEN-LAST:event_btnAceptarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JComboBox cmbEstablecimientos;
    private javax.swing.JPanel jpnlDestino;
    private javax.swing.JPanel jpnlTitular;
    private javax.swing.JLabel lblApellidoAlumno;
    private javax.swing.JLabel lblCursoAlumno;
    private javax.swing.JLabel lblDestino;
    private javax.swing.JLabel lblDivision;
    private javax.swing.JLabel lblDniAlumno;
    private javax.swing.JLabel lblNombreAlumno;
    private javax.swing.JTextField txtApellidoAlumno;
    private javax.swing.JTextField txtCursoAlumno;
    private javax.swing.JTextField txtDivisionAlumno;
    private javax.swing.JTextField txtDniAlumno;
    private javax.swing.JTextField txtNombreAlumno;
    // End of variables declaration//GEN-END:variables

    public JTextField getTxtDni() {
        return txtDniAlumno;
    }

    public JTextField getTxtApellido() {
        return txtApellidoAlumno;
    }

    public JTextField getTxtNombre() {
        return txtNombreAlumno;
    }

    public JTextField getTxtCurso() {
        return txtCursoAlumno;
    }

    public JTextField getTxtDivision() {
        return txtDivisionAlumno;
    }

    public FrmUser getFrmUsuario() {
        return frmUsuario;
    }

    public ControladorEstablecimiento getControladorEstablecimiento() {
        return this.controladorEstablecimiento;
    }

    public JComboBox getCmbBoxEstablecimiento() {
        return cmbEstablecimientos;
    }

    /**
     * @return the controladorDestino
     */
    public ControladorDestino getControladorDestino() {
        return controladorDestino;
    }
    
}