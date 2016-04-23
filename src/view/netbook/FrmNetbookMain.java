/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.netbook;

import controller.data.ControllerNetbook;
import controller.form.ControladorFrmNetPrincipal;
import hibernate.dao.AlumnoDAO;
import hibernate.dao.DestinoDAO;
import hibernate.dao.NetbookDAO;
import hibernate.dao.PaseDAO;
import hibernate.dao.PersonaDAO;
import hibernate.dao.ProfesorDAO;
import hibernate.dao.ReasignacionDAO;
import hibernate.dao.ServicioTecnicoDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.domain.Alumno;
import model.domain.Destino;
import model.domain.Netbook;
import model.domain.Pase;
import model.domain.Persona;
import model.domain.Profesor;
import model.domain.Reasignacion;
import model.domain.ServicioTecnico;
import model.report.Informe;
import view.main.FrmPrincipal;

/**
 *
 * @author wally86
 */
public class FrmNetbookMain extends javax.swing.JInternalFrame {

    private ControllerNetbook controladorNetbook;
    private ControladorFrmNetPrincipal controladorFrmNetPrincipal;

    private FrmPrincipal frmPrincipal;

    /**
     * Creates new form FrmNetbookPrincipal
     */
    public FrmNetbookMain(FrmPrincipal frmPrincipal) {
        initComponents();
        this.frmPrincipal = frmPrincipal;
        this.controladorFrmNetPrincipal = new ControladorFrmNetPrincipal();
        controladorNetbook = new ControllerNetbook();
        controladorFrmNetPrincipal.ocultarBoton(btnAceptar);
        controladorNetbook.cargaGrillaNetbook(tblNetbook, "Todas");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        controladorFrmNetPrincipal1 = new controller.form.ControladorFrmNetPrincipal();
        jLabel1 = new javax.swing.JLabel();
        cmbSeleccionNetbook = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNetbook = new javax.swing.JTable();
        btnNetbookNueva = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();
        btnVerPdf = new javax.swing.JButton();

        setTitle("ADMINISTRACIÓN DE NETBOOK'S");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/model/image/laptop112.png"))); // NOI18N
        setMinimumSize(new java.awt.Dimension(500, 300));
        setPreferredSize(new java.awt.Dimension(500, 300));
        getContentPane().setLayout(null);

        jLabel1.setText("Ver Netbook segun");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(12, 12, 160, 30);

        cmbSeleccionNetbook.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todas", "Osciosas", "En Servicio Tecnico", "Pase", "Migracion", "Reasignadas" }));
        cmbSeleccionNetbook.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbSeleccionNetbookItemStateChanged(evt);
            }
        });
        getContentPane().add(cmbSeleccionNetbook);
        cmbSeleccionNetbook.setBounds(150, 12, 230, 20);

        tblNetbook.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nº Serie", "Id Hardware", "Modelo", "Marca", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblNetbook);
        if (tblNetbook.getColumnModel().getColumnCount() > 0) {
            tblNetbook.getColumnModel().getColumn(1).setResizable(false);
            tblNetbook.getColumnModel().getColumn(2).setResizable(false);
            tblNetbook.getColumnModel().getColumn(3).setResizable(false);
            tblNetbook.getColumnModel().getColumn(4).setResizable(false);
        }

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 50, 360, 180);

        btnNetbookNueva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/model/image/add204.png"))); // NOI18N
        btnNetbookNueva.setToolTipText("Netbook Nueva");
        btnNetbookNueva.setMaximumSize(new java.awt.Dimension(40, 35));
        btnNetbookNueva.setMinimumSize(new java.awt.Dimension(40, 35));
        btnNetbookNueva.setPreferredSize(new java.awt.Dimension(40, 35));
        btnNetbookNueva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNetbookNuevaActionPerformed(evt);
            }
        });
        getContentPane().add(btnNetbookNueva);
        btnNetbookNueva.setBounds(380, 60, 40, 35);

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/model/image/door13.png"))); // NOI18N
        btnSalir.setToolTipText("Salir");
        btnSalir.setMaximumSize(new java.awt.Dimension(40, 35));
        btnSalir.setMinimumSize(new java.awt.Dimension(40, 35));
        btnSalir.setPreferredSize(new java.awt.Dimension(40, 35));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir);
        btnSalir.setBounds(430, 220, 40, 35);

        btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/model/image/checked21.png"))); // NOI18N
        btnAceptar.setToolTipText("Realizar Operacion");
        btnAceptar.setMaximumSize(new java.awt.Dimension(40, 35));
        btnAceptar.setMinimumSize(new java.awt.Dimension(40, 35));
        btnAceptar.setPreferredSize(new java.awt.Dimension(40, 35));
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAceptar);
        btnAceptar.setBounds(380, 160, 40, 35);

        btnVerPdf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/model/image/file-format.png"))); // NOI18N
        btnVerPdf.setToolTipText("Ver PDF");
        btnVerPdf.setMaximumSize(new java.awt.Dimension(40, 35));
        btnVerPdf.setMinimumSize(new java.awt.Dimension(40, 35));
        btnVerPdf.setPreferredSize(new java.awt.Dimension(40, 35));
        btnVerPdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerPdfActionPerformed(evt);
            }
        });
        getContentPane().add(btnVerPdf);
        btnVerPdf.setBounds(380, 110, 40, 35);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbSeleccionNetbookItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbSeleccionNetbookItemStateChanged
        // TODO add your handling code here:
        String seleccion = String.valueOf(cmbSeleccionNetbook.getSelectedItem());
        controladorNetbook.cargaGrillaNetbook(tblNetbook, seleccion);
        controladorFrmNetPrincipal.ocultarBotonRealizarOperacion(btnAceptar, seleccion);
    }//GEN-LAST:event_cmbSeleccionNetbookItemStateChanged

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        int respuesta = JOptionPane.showConfirmDialog(this, "¿Esa seguro de salir?", "Salir", JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION) {
            dispose();
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnNetbookNuevaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNetbookNuevaActionPerformed
        // TODO add your handling code here:
        FrmNetbookCRUD frmNetbookCRUD = new FrmNetbookCRUD(frmPrincipal, 'a');
        frmPrincipal.getDesktopPane().add(frmNetbookCRUD);
        frmNetbookCRUD.setVisible(true);
    }//GEN-LAST:event_btnNetbookNuevaActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // TODO add your handling code here:
        try {
            int posFilaElemSelecionado = tblNetbook.getSelectedRow();
            Object[] filaModificada = new Object[5];
            NetbookDAO netbookDAO = new NetbookDAO();
            Netbook netbook = new Netbook();
            DefaultTableModel tableModel = (DefaultTableModel) tblNetbook.getModel();
            boolean estado = (Boolean) tblNetbook.getValueAt(posFilaElemSelecionado, 4);
            if (!estado) {
                String tipoVista = String.valueOf(cmbSeleccionNetbook.getSelectedItem());
                switch (tipoVista) {
                    case "Pase":
                        PaseDAO paseDAO = new PaseDAO();
                        netbook = netbookDAO.obtenerNetbook(String.valueOf(tblNetbook.getValueAt(posFilaElemSelecionado, 0)));
                        Pase paseSeleccionado = paseDAO.obtenerPaseSegunNetbook(netbook);
                        paseSeleccionado.setEstado(true);
                        paseDAO.modificarPase(paseSeleccionado);
                        filaModificada[0] = netbook.getIdNetbook();
                        filaModificada[1] = netbook.getIdHardware();
                        filaModificada[2] = netbook.getModelo();
                        filaModificada[3] = netbook.getMarca();
                        filaModificada[4] = paseSeleccionado.isEstado();
                        tableModel.insertRow(posFilaElemSelecionado, filaModificada);
                        tableModel.removeRow(posFilaElemSelecionado + 1);
                        frmPrincipal.getControladorFrmPrincipal().getFrmUsuario(frmPrincipal).getControladorFormularioUsuario().actualizarCantidadPases(frmPrincipal.getControladorFrmPrincipal().getFrmUsuario(frmPrincipal));
                        break;
                    case "Reasignadas":
                        ReasignacionDAO reasignacionDAO = new ReasignacionDAO();
                        netbook = netbookDAO.obtenerNetbook(String.valueOf(tblNetbook.getValueAt(posFilaElemSelecionado, 0)));
                        Reasignacion reasignacionSeleccionada = reasignacionDAO.obtenerReasignacionSegunNetbook(netbook);
                        reasignacionSeleccionada.setEstado(true);
                        reasignacionDAO.modificarReasignacion(reasignacionSeleccionada);
                        filaModificada[0] = netbook.getIdNetbook();
                        filaModificada[1] = netbook.getIdHardware();
                        filaModificada[2] = netbook.getModelo();
                        filaModificada[3] = netbook.getMarca();
                        filaModificada[4] = reasignacionSeleccionada.isEstado();
                        tableModel.insertRow(posFilaElemSelecionado, filaModificada);
                        tableModel.removeRow(posFilaElemSelecionado + 1);
                        frmPrincipal.getControladorFrmPrincipal().getFrmUsuario(frmPrincipal).getControladorFormularioUsuario().actualizarCantidadReasignaciones(frmPrincipal.getControladorFrmPrincipal().getFrmUsuario(frmPrincipal));
                        break;
                    case "Migracion":
                        DestinoDAO  destinoDAO = new DestinoDAO();
                        netbook = netbookDAO.obtenerNetbook(String.valueOf(tblNetbook.getValueAt(posFilaElemSelecionado, 0)));
                        PersonaDAO personaDAO = new PersonaDAO();
                        Persona persona = new Persona();
                        AlumnoDAO alumnoDAO = new AlumnoDAO();
                        Alumno alumno = new Alumno();
                        ProfesorDAO profesorDAO = new ProfesorDAO();
                        Profesor profesor = new Profesor();
                        try{
                            alumno = alumnoDAO.buscarAlumnoNetbook(netbook.getIdNetbook());
                            persona = personaDAO.obtenerPersonaPorId(alumno.getPersona().getIdPersona());
                        }catch(NullPointerException e){
                            profesor = profesorDAO.buscarProfesorNetbook(netbook.getIdNetbook());
                            persona = personaDAO.obtenerPersonaPorId(profesor.getPersona().getIdPersona());
                        }
                        Destino migracionSeleccionada = destinoDAO.obtenerDestinoPorPersona(persona);
                        migracionSeleccionada.setEstado(true);
                        destinoDAO.modificarDestino(migracionSeleccionada);
                        tableModel.setValueAt(migracionSeleccionada.isEstado(),posFilaElemSelecionado,4);
                        frmPrincipal.getControladorFrmPrincipal().getFrmUsuario(frmPrincipal).getControladorFormularioUsuario().actualizarCantidadMigraciones(frmPrincipal.getControladorFrmPrincipal().getFrmUsuario(frmPrincipal));
                        break;
                    case "En Servicio Tecnico":
                        ServicioTecnicoDAO tecnicoDAO = new ServicioTecnicoDAO();
                        netbook = netbookDAO.obtenerNetbook(String.valueOf(tblNetbook.getValueAt(posFilaElemSelecionado, 0)));
                        ServicioTecnico tecnico = tecnicoDAO.obtenerServicioTecnicoSegunNet(netbook);
                        tecnico.setEstado(true);
                        tecnicoDAO.modificarServicioTecnico(tecnico);
                        boolean fila = tecnico.isEstado();
                        tableModel.setValueAt(fila,posFilaElemSelecionado , 4);
                        frmPrincipal.getControladorFrmPrincipal().getFrmUsuario(frmPrincipal).getControladorFormularioUsuario().actualizarCantidadServicioTecnico(frmPrincipal.getControladorFrmPrincipal().getFrmUsuario(frmPrincipal));
                        break;

                }
                    
            } else {
                JOptionPane.showMessageDialog(this, "Esta Operacion ya se realizo");
            }

        } catch (Exception e) {
            //escribir archivo log
            JOptionPane.showMessageDialog(this, "No Se puede realizar la operación "+ "Error :"+e);
        }

    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnVerPdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerPdfActionPerformed
        try {
            // TODO add your handling code here: 
            controladorNetbook.verInforme(controladorFrmNetPrincipal.tipoVistaSeleccionado(cmbSeleccionNetbook));
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_btnVerPdfActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnNetbookNueva;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnVerPdf;
    private javax.swing.JComboBox cmbSeleccionNetbook;
    private controller.form.ControladorFrmNetPrincipal controladorFrmNetPrincipal1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblNetbook;
    // End of variables declaration//GEN-END:variables

    public JTable getTblNetbook() {
        return tblNetbook;
    }
}