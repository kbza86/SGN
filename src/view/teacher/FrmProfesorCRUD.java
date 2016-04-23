/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.teacher;

import controller.data.ControllerNetbook;
import controller.data.ControllerTeacher;
import controller.form.ControllerFormTeacherCRUD;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.constant.ListaCaracteresNoValidos;
import model.image.ImagenPanelUsuario;
import view.netbook.FrmNetbookCRUD;
import view.main.FrmPrincipal;

/**
 *
 * @author wally86
 */
public class FrmProfesorCRUD extends javax.swing.JInternalFrame {

    private ControllerNetbook controladorNetbook;
    private FrmPrincipal frmPrincipal;
    private char tipoTransaccion;
    private ControllerFormTeacherCRUD controladorFrmProfesorCRUD;
    private ControllerTeacher controladorProfesor;

    /**
     * Creates new form FrmAlumnoAlta
     *
     * @param frmPrincipal
     * @param tipoTransaccion
     */
    public FrmProfesorCRUD(FrmPrincipal frmPrincipal, char tipoTransaccion) {
        initComponents();
        this.controladorNetbook = new ControllerNetbook();
        this.controladorProfesor = new ControllerTeacher();
        this.tipoTransaccion = tipoTransaccion;
        this.frmPrincipal = frmPrincipal;
        this.controladorFrmProfesorCRUD = new ControllerFormTeacherCRUD();
        pnlFotoUsuario.setBorder(new ImagenPanelUsuario());
        controladorFrmProfesorCRUD.ocultarLabelsInformativos(this);
        cargarDatosParaActualizar();
    }

    private void cargarDatosParaActualizar() {
        switch (tipoTransaccion) {
            case 'a':
                break;
            case 'v':
                btnAgregar.setVisible(false);
                btnBuscarFoto.setVisible(false);
                btnBuscarNet.setVisible(false);
                this.setTitle("PROFESOR");
                btnSalir.setText("Salir");
                cargarDatosParaVista();
                break;
            case 'm':
                btnBuscarNet.setEnabled(false);
                txtNetAlumno.setEditable(false);
                this.setTitle("MODIFICAR DATOS");
                cargarDatosParaModificar();
                break;
        }
    }

    private void cargarDatosParaModificar() {
        txtApellidoTitular.setText(this.frmPrincipal.getControladorFrmPrincipal().getFrmUsuario(frmPrincipal).getControladorProfesor().getPersonaProfesor().getApellido());
        txtDniTitular.setText(String.valueOf(this.frmPrincipal.getControladorFrmPrincipal().getFrmUsuario(frmPrincipal).getControladorProfesor().getPersonaProfesor().getDni()));
        txtNombreTitular.setText(this.frmPrincipal.getControladorFrmPrincipal().getFrmUsuario(frmPrincipal).getControladorProfesor().getPersonaProfesor().getNombre());
        txtNetAlumno.setText(this.frmPrincipal.getControladorFrmPrincipal().getFrmUsuario(frmPrincipal).getControladorProfesor().getNetbook().getIdNetbook());
        txtMarcaNet.setText(this.frmPrincipal.getControladorFrmPrincipal().getFrmUsuario(frmPrincipal).getControladorProfesor().getNetbook().getMarca());
        txtModeloNet.setText(this.frmPrincipal.getControladorFrmPrincipal().getFrmUsuario(frmPrincipal).getControladorProfesor().getNetbook().getModelo());
        txtOfficeKey.setText(this.frmPrincipal.getControladorFrmPrincipal().getFrmUsuario(frmPrincipal).getControladorProfesor().getNetbook().getOfficeKey());
        txtWinKey.setText(this.frmPrincipal.getControladorFrmPrincipal().getFrmUsuario(frmPrincipal).getControladorProfesor().getNetbook().getWindowsKey());

    }

    private void cargarDatosParaVista() {
        //Datos del Profesor
        controladorFrmProfesorCRUD.evitarEdicionTodosTxt(this);
        txtApellidoTitular.setText(this.frmPrincipal.getControladorFrmPrincipal().getFrmUsuario(frmPrincipal).getControladorProfesor().getPersonaProfesor().getApellido());
        txtDniTitular.setText(String.valueOf(this.frmPrincipal.getControladorFrmPrincipal().getFrmUsuario(frmPrincipal).getControladorProfesor().getPersonaProfesor().getDni()));
        txtNombreTitular.setText(this.frmPrincipal.getControladorFrmPrincipal().getFrmUsuario(frmPrincipal).getControladorProfesor().getPersonaProfesor().getNombre());
        txtNetAlumno.setText(this.frmPrincipal.getControladorFrmPrincipal().getFrmUsuario(frmPrincipal).getControladorProfesor().getNetbook().getIdNetbook());
        txtMarcaNet.setText(this.frmPrincipal.getControladorFrmPrincipal().getFrmUsuario(frmPrincipal).getControladorProfesor().getNetbook().getMarca());
        txtModeloNet.setText(this.frmPrincipal.getControladorFrmPrincipal().getFrmUsuario(frmPrincipal).getControladorProfesor().getNetbook().getModelo());
        txtOfficeKey.setText(this.frmPrincipal.getControladorFrmPrincipal().getFrmUsuario(frmPrincipal).getControladorProfesor().getNetbook().getOfficeKey());
        txtWinKey.setText(this.frmPrincipal.getControladorFrmPrincipal().getFrmUsuario(frmPrincipal).getControladorProfesor().getNetbook().getWindowsKey());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAgregar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        pnlTitularNetbook = new javax.swing.JPanel();
        lblApellidoTitular = new javax.swing.JLabel();
        lblNombreTitular = new javax.swing.JLabel();
        txtNombreTitular = new javax.swing.JTextField();
        lblInfoNombre = new javax.swing.JLabel();
        txtApellidoTitular = new javax.swing.JTextField();
        lblDniTitular = new javax.swing.JLabel();
        txtDniTitular = new javax.swing.JTextField();
        lblInfoApellido = new javax.swing.JLabel();
        lblInfoDni = new javax.swing.JLabel();
        btnBuscarFoto = new javax.swing.JButton();
        lblFotoAlumno = new javax.swing.JLabel();
        pnlFotoUsuario = new javax.swing.JDesktopPane();
        lblEstadoNombre = new javax.swing.JLabel();
        lblEstadoApellido = new javax.swing.JLabel();
        lblEstadoDni = new javax.swing.JLabel();
        pntNetbook = new javax.swing.JPanel();
        lblInfoNumSerie = new javax.swing.JLabel();
        lblNetAlumno = new javax.swing.JLabel();
        txtNetAlumno = new javax.swing.JTextField();
        btnBuscarNet = new javax.swing.JButton();
        lblEstadoNet = new javax.swing.JLabel();
        lblModeloNet = new javax.swing.JLabel();
        txtModeloNet = new javax.swing.JTextField();
        lblMarcaNetbook = new javax.swing.JLabel();
        txtMarcaNet = new javax.swing.JTextField();
        lblWindowsKeyNet = new javax.swing.JLabel();
        txtWinKey = new javax.swing.JTextField();
        lblOfficeKeyNet = new javax.swing.JLabel();
        txtOfficeKey = new javax.swing.JTextField();
        lblEstadoModelo = new javax.swing.JLabel();
        lblEstadoMarca = new javax.swing.JLabel();
        lblEstadoWindows = new javax.swing.JLabel();
        lblEstadoOffice = new javax.swing.JLabel();

        setTitle("PROFESOR NUEVO");
        setFrameIcon(null);
        setMinimumSize(new java.awt.Dimension(560, 400));
        setPreferredSize(new java.awt.Dimension(560, 400));
        getContentPane().setLayout(null);

        btnAgregar.setText("Guardar");
        btnAgregar.setMaximumSize(new java.awt.Dimension(120, 26));
        btnAgregar.setMinimumSize(new java.awt.Dimension(120, 26));
        btnAgregar.setPreferredSize(new java.awt.Dimension(120, 26));
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregar);
        btnAgregar.setBounds(110, 335, 120, 26);

        btnSalir.setText("Cancelar");
        btnSalir.setMaximumSize(new java.awt.Dimension(120, 26));
        btnSalir.setMinimumSize(new java.awt.Dimension(120, 26));
        btnSalir.setPreferredSize(new java.awt.Dimension(120, 26));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir);
        btnSalir.setBounds(360, 335, 120, 26);

        pnlTitularNetbook.setBorder(javax.swing.BorderFactory.createTitledBorder("Titular Netbook"));
        pnlTitularNetbook.setLayout(null);

        lblApellidoTitular.setText("Apellido");
        pnlTitularNetbook.add(lblApellidoTitular);
        lblApellidoTitular.setBounds(10, 76, 70, 14);

        lblNombreTitular.setText("Nombre");
        pnlTitularNetbook.add(lblNombreTitular);
        lblNombreTitular.setBounds(10, 23, 70, 14);

        txtNombreTitular.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        txtNombreTitular.setMinimumSize(new java.awt.Dimension(200, 26));
        txtNombreTitular.setPreferredSize(new java.awt.Dimension(200, 26));
        txtNombreTitular.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNombreTitularFocusGained(evt);
            }
        });
        txtNombreTitular.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreTitularKeyTyped(evt);
            }
        });
        pnlTitularNetbook.add(txtNombreTitular);
        txtNombreTitular.setBounds(90, 20, 200, 26);

        lblInfoNombre.setFont(new java.awt.Font("Cantarell", 2, 10)); // NOI18N
        lblInfoNombre.setForeground(new java.awt.Color(244, 11, 11));
        lblInfoNombre.setText("Longitud max. de 45 caracteres y solo letras");
        pnlTitularNetbook.add(lblInfoNombre);
        lblInfoNombre.setBounds(90, 40, 207, 20);

        txtApellidoTitular.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        txtApellidoTitular.setMinimumSize(new java.awt.Dimension(200, 26));
        txtApellidoTitular.setPreferredSize(new java.awt.Dimension(200, 26));
        txtApellidoTitular.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtApellidoTitularFocusGained(evt);
            }
        });
        txtApellidoTitular.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidoTitularKeyTyped(evt);
            }
        });
        pnlTitularNetbook.add(txtApellidoTitular);
        txtApellidoTitular.setBounds(90, 70, 200, 26);

        lblDniTitular.setText("Dni");
        pnlTitularNetbook.add(lblDniTitular);
        lblDniTitular.setBounds(10, 123, 55, 14);

        txtDniTitular.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        txtDniTitular.setMinimumSize(new java.awt.Dimension(200, 26));
        txtDniTitular.setPreferredSize(new java.awt.Dimension(200, 26));
        txtDniTitular.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDniTitularFocusGained(evt);
            }
        });
        txtDniTitular.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDniTitularKeyTyped(evt);
            }
        });
        pnlTitularNetbook.add(txtDniTitular);
        txtDniTitular.setBounds(90, 120, 200, 26);

        lblInfoApellido.setFont(new java.awt.Font("Cantarell", 2, 10)); // NOI18N
        lblInfoApellido.setForeground(new java.awt.Color(244, 11, 11));
        lblInfoApellido.setText("Longitud max. de 45 caracteres y solo letras");
        pnlTitularNetbook.add(lblInfoApellido);
        lblInfoApellido.setBounds(90, 90, 207, 20);

        lblInfoDni.setFont(new java.awt.Font("Cantarell", 2, 10)); // NOI18N
        lblInfoDni.setForeground(new java.awt.Color(244, 11, 11));
        lblInfoDni.setText("Longitud max. de 8 caracteres numericos");
        pnlTitularNetbook.add(lblInfoDni);
        lblInfoDni.setBounds(90, 140, 191, 20);

        btnBuscarFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/model/image/magnifier12.png"))); // NOI18N
        btnBuscarFoto.setToolTipText("Buscar Imagen");
        btnBuscarFoto.setMaximumSize(new java.awt.Dimension(40, 35));
        btnBuscarFoto.setMinimumSize(new java.awt.Dimension(40, 35));
        btnBuscarFoto.setPreferredSize(new java.awt.Dimension(40, 35));
        btnBuscarFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarFotoActionPerformed(evt);
            }
        });
        pnlTitularNetbook.add(btnBuscarFoto);
        btnBuscarFoto.setBounds(450, 145, 40, 35);

        lblFotoAlumno.setText("Foto");
        pnlTitularNetbook.add(lblFotoAlumno);
        lblFotoAlumno.setBounds(440, 20, 22, 14);
        pnlTitularNetbook.add(pnlFotoUsuario);
        pnlFotoUsuario.setBounds(420, 40, 100, 100);

        lblEstadoNombre.setMaximumSize(new java.awt.Dimension(20, 20));
        lblEstadoNombre.setMinimumSize(new java.awt.Dimension(20, 20));
        lblEstadoNombre.setPreferredSize(new java.awt.Dimension(20, 20));
        pnlTitularNetbook.add(lblEstadoNombre);
        lblEstadoNombre.setBounds(293, 23, 20, 20);

        lblEstadoApellido.setMaximumSize(new java.awt.Dimension(20, 20));
        lblEstadoApellido.setMinimumSize(new java.awt.Dimension(20, 20));
        lblEstadoApellido.setPreferredSize(new java.awt.Dimension(20, 20));
        pnlTitularNetbook.add(lblEstadoApellido);
        lblEstadoApellido.setBounds(293, 73, 20, 20);

        lblEstadoDni.setMaximumSize(new java.awt.Dimension(20, 20));
        lblEstadoDni.setMinimumSize(new java.awt.Dimension(20, 20));
        lblEstadoDni.setPreferredSize(new java.awt.Dimension(20, 20));
        pnlTitularNetbook.add(lblEstadoDni);
        lblEstadoDni.setBounds(293, 123, 20, 20);

        getContentPane().add(pnlTitularNetbook);
        pnlTitularNetbook.setBounds(0, 0, 550, 190);

        pntNetbook.setBorder(javax.swing.BorderFactory.createTitledBorder("Netbook"));
        pntNetbook.setLayout(null);

        lblInfoNumSerie.setFont(new java.awt.Font("Cantarell", 2, 10)); // NOI18N
        lblInfoNumSerie.setForeground(new java.awt.Color(244, 11, 11));
        lblInfoNumSerie.setText("Longitud max. de 15 caracteres");
        pntNetbook.add(lblInfoNumSerie);
        lblInfoNumSerie.setBounds(130, 35, 147, 20);

        lblNetAlumno.setText("Numero de Serie");
        pntNetbook.add(lblNetAlumno);
        lblNetAlumno.setBounds(10, 20, 120, 14);

        txtNetAlumno.setFont(new java.awt.Font("Cantarell", 2, 10)); // NOI18N
        txtNetAlumno.setText("Ingrese Nº Serie");
        txtNetAlumno.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNetAlumnoFocusGained(evt);
            }
        });
        txtNetAlumno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNetAlumnoKeyTyped(evt);
            }
        });
        pntNetbook.add(txtNetAlumno);
        txtNetAlumno.setBounds(130, 20, 143, 20);

        btnBuscarNet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/model/image/magnifier12.png"))); // NOI18N
        btnBuscarNet.setToolTipText("Buscar Netbook");
        btnBuscarNet.setMaximumSize(new java.awt.Dimension(40, 35));
        btnBuscarNet.setMinimumSize(new java.awt.Dimension(40, 35));
        btnBuscarNet.setPreferredSize(new java.awt.Dimension(40, 35));
        btnBuscarNet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarNetActionPerformed(evt);
            }
        });
        pntNetbook.add(btnBuscarNet);
        btnBuscarNet.setBounds(320, 15, 40, 35);

        lblEstadoNet.setText("     ");
        lblEstadoNet.setMaximumSize(new java.awt.Dimension(20, 20));
        lblEstadoNet.setMinimumSize(new java.awt.Dimension(20, 20));
        lblEstadoNet.setPreferredSize(new java.awt.Dimension(20, 20));
        pntNetbook.add(lblEstadoNet);
        lblEstadoNet.setBounds(275, 20, 20, 20);

        lblModeloNet.setText("Modelo");
        pntNetbook.add(lblModeloNet);
        lblModeloNet.setBounds(10, 62, 60, 14);

        txtModeloNet.setEditable(false);
        txtModeloNet.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        pntNetbook.add(txtModeloNet);
        txtModeloNet.setBounds(110, 60, 150, 20);

        lblMarcaNetbook.setText("Marca");
        pntNetbook.add(lblMarcaNetbook);
        lblMarcaNetbook.setBounds(300, 65, 50, 14);

        txtMarcaNet.setEditable(false);
        txtMarcaNet.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        pntNetbook.add(txtMarcaNet);
        txtMarcaNet.setBounds(360, 60, 150, 20);

        lblWindowsKeyNet.setText("Windows Key");
        pntNetbook.add(lblWindowsKeyNet);
        lblWindowsKeyNet.setBounds(10, 100, 100, 30);

        txtWinKey.setEditable(false);
        txtWinKey.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        pntNetbook.add(txtWinKey);
        txtWinKey.setBounds(110, 105, 150, 20);

        lblOfficeKeyNet.setText("Office Key");
        pntNetbook.add(lblOfficeKeyNet);
        lblOfficeKeyNet.setBounds(300, 100, 60, 30);

        txtOfficeKey.setEditable(false);
        txtOfficeKey.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        pntNetbook.add(txtOfficeKey);
        txtOfficeKey.setBounds(360, 105, 150, 20);
        pntNetbook.add(lblEstadoModelo);
        lblEstadoModelo.setBounds(260, 60, 20, 20);
        pntNetbook.add(lblEstadoMarca);
        lblEstadoMarca.setBounds(510, 60, 20, 20);
        pntNetbook.add(lblEstadoWindows);
        lblEstadoWindows.setBounds(260, 105, 20, 20);
        pntNetbook.add(lblEstadoOffice);
        lblEstadoOffice.setBounds(510, 105, 20, 20);

        getContentPane().add(pntNetbook);
        pntNetbook.setBounds(0, 190, 550, 140);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        int respuesta = JOptionPane.showConfirmDialog(this, "¿Desea Salir?", "Salir", JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION) {
            dispose();
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    private void txtNombreTitularKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreTitularKeyTyped
        // TODO add your handling code here:
        String nombre = txtNombreTitular.getText();
        String pathImagen = "/model/image/";
        if (nombre.length() >= 45) {
            evt.consume();
            controladorFrmProfesorCRUD.mostrarLabellInformativo(lblInfoNombre);
        }
        if (Character.isDigit(evt.getKeyChar()) && evt.getKeyChar() != KeyEvent.VK_BACK_SPACE) {
            evt.consume();
            controladorFrmProfesorCRUD.mostrarLabellInformativo(lblInfoNombre);
        }
        for (Character c : ListaCaracteresNoValidos.LISTA) {
            if (evt.getKeyChar() == c) {
                evt.consume();
                controladorFrmProfesorCRUD.mostrarLabellInformativo(lblInfoNombre);
            }
        }
        controladorFrmProfesorCRUD.ocultarLabellInformativo(lblInfoNombre);
        if ((nombre.length() <= 45) && (!nombre.isEmpty()) && (!Character.isDigit(evt.getKeyChar()))) {
            pathImagen += "si.png";
            controladorFrmProfesorCRUD.setEstadoNombre(true);
        } else {
            pathImagen += "no.png";
            controladorFrmProfesorCRUD.setEstadoNombre(false);
        }
        controladorFrmProfesorCRUD.agregarImagenEstadoLabel(lblEstadoNombre, pathImagen);
        controladorFrmProfesorCRUD.mostrarLabellInformativo(lblEstadoNombre);
    }//GEN-LAST:event_txtNombreTitularKeyTyped

    private void txtApellidoTitularKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoTitularKeyTyped
        // TODO add your handling code here:
        String apellido = txtApellidoTitular.getText();
        String pathImagen = "/model/image/";
        if (apellido.length() >= 45) {
            evt.consume();
            controladorFrmProfesorCRUD.mostrarLabellInformativo(lblInfoApellido);
        }
        if (Character.isDigit(evt.getKeyChar()) && evt.getKeyChar() != KeyEvent.VK_BACK_SPACE) {
            evt.consume();
            controladorFrmProfesorCRUD.mostrarLabellInformativo(lblInfoApellido);
        }
        for (Character c : ListaCaracteresNoValidos.LISTA) {
            if (evt.getKeyChar() == c) {
                evt.consume();
                controladorFrmProfesorCRUD.mostrarLabellInformativo(lblInfoApellido);
            }
        }
        controladorFrmProfesorCRUD.ocultarLabellInformativo(lblInfoApellido);
        if ((apellido.length() <= 45) && (!apellido.isEmpty()) && (!Character.isDigit(evt.getKeyChar()))) {
            pathImagen += "si.png";
            controladorFrmProfesorCRUD.setEstadoApellido(true);
        } else {
            pathImagen += "no.png";
            controladorFrmProfesorCRUD.setEstadoApellido(false);
        }
        controladorFrmProfesorCRUD.agregarImagenEstadoLabel(lblEstadoApellido, pathImagen);
        controladorFrmProfesorCRUD.mostrarLabellInformativo(lblEstadoApellido);
    }//GEN-LAST:event_txtApellidoTitularKeyTyped

    private void txtDniTitularKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniTitularKeyTyped
        // TODO add your handling code here:
        String dni = txtDniTitular.getText();
        String pathImagen = "/model/image/";
        if (dni.length() >= 8) {
            evt.consume();
            controladorFrmProfesorCRUD.mostrarLabellInformativo(lblInfoDni);
        }
        if (!Character.isDigit(evt.getKeyChar()) && evt.getKeyChar() != KeyEvent.VK_BACK_SPACE) {
            evt.consume();
            controladorFrmProfesorCRUD.mostrarLabellInformativo(lblInfoDni);
        } else {
        }
        for (Character c : ListaCaracteresNoValidos.LISTA) {
            if (evt.getKeyChar() == c) {
                evt.consume();
                controladorFrmProfesorCRUD.mostrarLabellInformativo(lblInfoDni);
            }
        }
        controladorFrmProfesorCRUD.ocultarLabellInformativo(lblInfoDni);
        if (((dni.length() == 7) || (dni.length() == 8)) && (!dni.isEmpty()) && (Character.isDigit(evt.getKeyChar()))) {
            pathImagen += "si.png";
            controladorFrmProfesorCRUD.setEstadoDni(true);
        } else {
            pathImagen += "no.png";
            controladorFrmProfesorCRUD.setEstadoDni(false);
        }
        controladorFrmProfesorCRUD.agregarImagenEstadoLabel(lblEstadoDni, pathImagen);
        controladorFrmProfesorCRUD.mostrarLabellInformativo(lblEstadoDni);
    }//GEN-LAST:event_txtDniTitularKeyTyped

    private void txtNetAlumnoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNetAlumnoFocusGained
        // TODO add your handling code here:
        txtNetAlumno.setText("");

    }//GEN-LAST:event_txtNetAlumnoFocusGained

    private void txtNetAlumnoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNetAlumnoKeyTyped
        // TODO add your handling code here:
        String serie = txtNetAlumno.getText();
        for (Character c : ListaCaracteresNoValidos.LISTA) {
            if ((evt.getKeyChar() != KeyEvent.VK_BACK_SPACE) && (evt.getKeyChar() == c)) {
                evt.consume();
                controladorFrmProfesorCRUD.mostrarLabellInformativo(lblInfoNumSerie);
            }
        }
        if (serie.length() > 15 && (evt.getKeyChar() != KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
            controladorFrmProfesorCRUD.mostrarLabellInformativo(lblInfoNumSerie);
        }

    }//GEN-LAST:event_txtNetAlumnoKeyTyped

    private void btnBuscarNetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarNetActionPerformed
        // TODO add your handling code here:
        String pathImagen = "/model/image/";
        int respuesta = 0;
        if (controladorNetbook.verificarExistencia(txtNetAlumno)) {
            controladorNetbook.setNetbook(controladorNetbook.buscarNetbookSerie(txtNetAlumno.getText()));
            frmPrincipal.getControladorFrmPrincipal().getFrmUsuario(frmPrincipal).getControladorAlumno().setNetbook(controladorNetbook.getNetbook());
            txtMarcaNet.setText(controladorNetbook.getNetbook().getMarca());
            txtModeloNet.setText(controladorNetbook.getNetbook().getModelo());
            txtOfficeKey.setText(controladorNetbook.getNetbook().getOfficeKey());
            txtWinKey.setText(controladorNetbook.getNetbook().getWindowsKey());
            if (!controladorNetbook.verificarEstadoNetbook(txtNetAlumno)) {
                pathImagen += "si.png";
                controladorFrmProfesorCRUD.setEstadoNetbook(true);
                controladorFrmProfesorCRUD.agregarImagenEstadoLabel(lblEstadoNet, pathImagen);
            } else {
                JOptionPane.showMessageDialog(this, "Debe reasignar la netbook");
                controladorFrmProfesorCRUD.setEstadoNetbook(false);
            }
        } else {
            txtMarcaNet.setText("");
            txtModeloNet.setText("");
            txtOfficeKey.setText("");
            txtWinKey.setText("");
            respuesta = JOptionPane.showConfirmDialog(this, "¿Desea Ingresar Netbook nueva?", "Netbook ingresada no existe", JOptionPane.YES_NO_OPTION);
            if (respuesta == JOptionPane.YES_OPTION) {
                FrmNetbookCRUD frmNetbookAlta = new FrmNetbookCRUD(frmPrincipal, tipoTransaccion);
                frmPrincipal.getDesktopPane().add(frmNetbookAlta);
                frmNetbookAlta.setVisible(true);
            } else {
                pathImagen += "no.png";
                controladorFrmProfesorCRUD.setEstadoNetbook(false);
                controladorFrmProfesorCRUD.agregarImagenEstadoLabel(lblEstadoNet, pathImagen);
            }
        }
    }//GEN-LAST:event_btnBuscarNetActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        switch (tipoTransaccion) {
            case 'a':
                if (controladorFrmProfesorCRUD.verificarCampos()) {
                    if (!controladorProfesor.verificarExistencia(txtDniTitular)) {
                        controladorProfesor.altaProfesor(this);
                        controladorProfesor.actualizaTblProfesores(this, tipoTransaccion);

                        JOptionPane.showMessageDialog(this, "Se guardo el registro correctamente");
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(this, "Ya existe este Profesor en la Base de Datos");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Verifique que los datos ingresados sean correctos");
                }
                break;
            case 'v':

                break;
            case 'm':
                
                
                if (controladorFrmProfesorCRUD.validarCamposModificar(this)) {
                    int respuesta = JOptionPane.showConfirmDialog(this, "¿Esta seguro de modificar el registro?", "Modificar Datos", JOptionPane.YES_NO_OPTION);
                    if (respuesta == JOptionPane.YES_OPTION) {
                        controladorProfesor.modificarProfesor(this);
                        
                        JOptionPane.showMessageDialog(this, "Se modifico el regitro correctamente");
                        dispose();
                    } 
                }else {
                        JOptionPane.showMessageDialog(this, "Verifique los datos ingresados");
                    }
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void txtNombreTitularFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreTitularFocusGained
        // TODO add your handling code here:

    }//GEN-LAST:event_txtNombreTitularFocusGained

    private void txtApellidoTitularFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtApellidoTitularFocusGained
        // TODO add your handling code here:

    }//GEN-LAST:event_txtApellidoTitularFocusGained

    private void txtDniTitularFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDniTitularFocusGained
        // TODO add your handling code here:

    }//GEN-LAST:event_txtDniTitularFocusGained

    private void btnBuscarFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarFotoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarFotoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscarFoto;
    private javax.swing.JButton btnBuscarNet;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel lblApellidoTitular;
    private javax.swing.JLabel lblDniTitular;
    private javax.swing.JLabel lblEstadoApellido;
    private javax.swing.JLabel lblEstadoDni;
    private javax.swing.JLabel lblEstadoMarca;
    private javax.swing.JLabel lblEstadoModelo;
    private javax.swing.JLabel lblEstadoNet;
    private javax.swing.JLabel lblEstadoNombre;
    private javax.swing.JLabel lblEstadoOffice;
    private javax.swing.JLabel lblEstadoWindows;
    private javax.swing.JLabel lblFotoAlumno;
    private javax.swing.JLabel lblInfoApellido;
    private javax.swing.JLabel lblInfoDni;
    private javax.swing.JLabel lblInfoNombre;
    private javax.swing.JLabel lblInfoNumSerie;
    private javax.swing.JLabel lblMarcaNetbook;
    private javax.swing.JLabel lblModeloNet;
    private javax.swing.JLabel lblNetAlumno;
    private javax.swing.JLabel lblNombreTitular;
    private javax.swing.JLabel lblOfficeKeyNet;
    private javax.swing.JLabel lblWindowsKeyNet;
    private javax.swing.JDesktopPane pnlFotoUsuario;
    private javax.swing.JPanel pnlTitularNetbook;
    private javax.swing.JPanel pntNetbook;
    private javax.swing.JTextField txtApellidoTitular;
    private javax.swing.JTextField txtDniTitular;
    private javax.swing.JTextField txtMarcaNet;
    private javax.swing.JTextField txtModeloNet;
    private javax.swing.JTextField txtNetAlumno;
    private javax.swing.JTextField txtNombreTitular;
    private javax.swing.JTextField txtOfficeKey;
    private javax.swing.JTextField txtWinKey;
    // End of variables declaration//GEN-END:variables

    public JTextField getTxtNombreTitular() {
        return txtNombreTitular;
    }

    public JButton getBotonBuscarNetbook() {
        return btnBuscarNet;
    }

    public JTextField getTxtApellidoTitular() {
        return txtApellidoTitular;
    }

    public JTextField getTxtDniTitular() {
        return txtDniTitular;
    }

    public JTextField getTxtNetbook() {
        return txtNetAlumno;
    }

    public JTextField getTxtModeloNetbook() {
        return txtModeloNet;
    }

    public JTextField getTxtMarcaNetbook() {
        return txtMarcaNet;
    }

    public JTextField getTxtWinkeyNetbook() {
        return txtWinKey;
    }

    public JTextField getTxtOfficeKeyNetbook() {
        return txtOfficeKey;
    }

    public JLabel getLabelEstadoNombre() {
        return lblEstadoNombre;
    }

    public JLabel getLabelEstadoApellido() {
        return lblEstadoApellido;
    }

    public JLabel getLabelEstadoDni() {
        return lblEstadoDni;
    }

    public JLabel getLabelEstadoNetbook() {
        return lblEstadoNet;
    }

    public JLabel getLabelInfoSerieNetbook() {
        return lblInfoNumSerie;
    }

    public JLabel getLabelInfoDniTitular() {
        return lblInfoDni;
    }

    public JLabel getLabelInfoApellidoTitular() {
        return lblInfoApellido;
    }

    public JLabel getLabelInfoNombresTitular() {
        return lblInfoNombre;
    }

    public FrmPrincipal getFrmPrincipal() {
        return frmPrincipal;
    }
}
