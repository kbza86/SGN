/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.pupil;

import controller.data.ControllerNetbook;
import controller.data.ControladorTutor;
import controller.form.ControladorFrmAltaAlumno;
import controller.data.ControllerPupil;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.constant.ListaCaracteresNoValidos;

import model.image.ImagenPanelUsuario;
import view.netbook.FrmNetbookCRUD;
import view.main.FrmPrincipal;
import vista.tutor.FrmTutorCRUD;

/**
 *
 * @author wally86
 */
public class FrmAlumnoCRUD extends javax.swing.JInternalFrame {

    private ControladorFrmAltaAlumno controladorFrmAltaAlumno;
    private ControllerNetbook controladorNetbook;
    private ControladorTutor controladorTutor;
    private ControllerPupil controladorAlumno;
    private FrmPrincipal frmPrincipal;
    private char tipoTransaccion;

    /**
     * Creates new form FrmAlumnoAlta
     *
     * @param frmPrincipal
     * @param tipoTransaccion
     */
    public FrmAlumnoCRUD(FrmPrincipal frmPrincipal, char tipoTransaccion) {
        initComponents();
        this.controladorFrmAltaAlumno = new ControladorFrmAltaAlumno();
        this.controladorNetbook = new ControllerNetbook();
        this.controladorTutor = new ControladorTutor();
        this.controladorAlumno = new ControllerPupil();
        this.frmPrincipal = frmPrincipal;
        this.tipoTransaccion = tipoTransaccion;
        pnlFotoUsuario.setBorder(new ImagenPanelUsuario());
        controladorFrmAltaAlumno.deshabilitarCampoTxt(txtNombresTutor);
        controladorFrmAltaAlumno.deshabilitarCampoTxt(txtApellidoTutor);
        controladorFrmAltaAlumno.deshabilitarCampoTxt(txtIdHardware);
        controladorFrmAltaAlumno.deshabilitarCampoTxt(txtIdHardware);
        controladorFrmAltaAlumno.ocultarLabelInformativos(this);
        cargarDatosParaActualizar();

    }

    private void cargarDatosParaActualizar() {
        switch (tipoTransaccion) {
            case 'a':
                break;
            case 'v':
                this.title="Alumno";
                controladorFrmAltaAlumno.deshabilitarCamposTxt(this);
                controladorFrmAltaAlumno.deshabilitarComboBoxes(this);
                btnAgregar.setVisible(false);
                btnSalir.setVisible(true);
                btnSalir.setText("Salir");
                cargarDatosParaVista();
                break;
            case 'm':
                controladorFrmAltaAlumno.deshabilitarCamposNetbook(this);
                btnAgregar.setText("Modificar");
                cargarDatosParaModificar();
                break;
        }
    }

    private void cargarDatosParaModificar() {
        //Datos Alumno
        txtDniAlumno.setText(String.valueOf(frmPrincipal.getControladorFrmPrincipal().getFrmUsuario(frmPrincipal).getControladorAlumno().getPersonaAlumno().getDni()));
        txtApellidoAlumno.setText(frmPrincipal.getControladorFrmPrincipal().getFrmUsuario(frmPrincipal).getControladorAlumno().getPersonaAlumno().getApellido());
        txtNombreAlumno.setText(frmPrincipal.getControladorFrmPrincipal().getFrmUsuario(frmPrincipal).getControladorAlumno().getPersonaAlumno().getNombre());
        cmbCursoAlumno.setSelectedItem(frmPrincipal.getControladorFrmPrincipal().getFrmUsuario(frmPrincipal).getControladorAlumno().getAlumno().getCurso());
        cmbDivisionAlumno.setSelectedItem(frmPrincipal.getControladorFrmPrincipal().getFrmUsuario(frmPrincipal).getControladorAlumno().getAlumno().getDivision());
        cmbEstado.setSelectedItem(frmPrincipal.getControladorFrmPrincipal().getFrmUsuario(frmPrincipal).getControladorAlumno().getAlumno().getEstado()); 
        //Datos Tutor
        txtTutorAlumno.setText(String.valueOf(frmPrincipal.getControladorFrmPrincipal().getFrmUsuario(frmPrincipal).getControladorAlumno().getPersonaTutor().getDni()));
        txtApellidoTutor.setText(frmPrincipal.getControladorFrmPrincipal().getFrmUsuario(frmPrincipal).getControladorAlumno().getPersonaTutor().getApellido());
        txtNombresTutor.setText(frmPrincipal.getControladorFrmPrincipal().getFrmUsuario(frmPrincipal).getControladorAlumno().getPersonaTutor().getNombre());
        //Datos Netbook
        txtNetAlumno.setText(frmPrincipal.getControladorFrmPrincipal().getFrmUsuario(frmPrincipal).getControladorAlumno().getNetbook().getIdNetbook());
        txtIdHardware.setText(frmPrincipal.getControladorFrmPrincipal().getFrmUsuario(frmPrincipal).getControladorAlumno().getNetbook().getIdHardware());
    }

    private void cargarDatosParaVista() {
        //Datos Alumno
        txtDniAlumno.setText(String.valueOf(frmPrincipal.getControladorFrmPrincipal().getFrmUsuario(frmPrincipal).getControladorAlumno().getPersonaAlumno().getDni()));
        txtApellidoAlumno.setText(frmPrincipal.getControladorFrmPrincipal().getFrmUsuario(frmPrincipal).getControladorAlumno().getPersonaAlumno().getApellido());
        txtNombreAlumno.setText(frmPrincipal.getControladorFrmPrincipal().getFrmUsuario(frmPrincipal).getControladorAlumno().getPersonaAlumno().getNombre());
        cmbCursoAlumno.setSelectedItem(frmPrincipal.getControladorFrmPrincipal().getFrmUsuario(frmPrincipal).getControladorAlumno().getAlumno().getCurso());
        cmbDivisionAlumno.setSelectedItem(frmPrincipal.getControladorFrmPrincipal().getFrmUsuario(frmPrincipal).getControladorAlumno().getAlumno().getDivision());     
        cmbEstado.setSelectedItem(frmPrincipal.getControladorFrmPrincipal().getFrmUsuario(frmPrincipal).getControladorAlumno().getAlumno().getEstado());     
        //Datos Tutor
        controladorFrmAltaAlumno.deshabilitarBoton(btnBuscarTutor);
        txtTutorAlumno.setText(String.valueOf(frmPrincipal.getControladorFrmPrincipal().getFrmUsuario(frmPrincipal).getControladorAlumno().getPersonaTutor().getDni()));
        txtApellidoTutor.setText(frmPrincipal.getControladorFrmPrincipal().getFrmUsuario(frmPrincipal).getControladorAlumno().getPersonaTutor().getApellido());
        txtNombresTutor.setText(frmPrincipal.getControladorFrmPrincipal().getFrmUsuario(frmPrincipal).getControladorAlumno().getPersonaTutor().getNombre());
        //Datos Netbook
        controladorFrmAltaAlumno.deshabilitarBoton(btnBuscarNet);
        txtNetAlumno.setText(frmPrincipal.getControladorFrmPrincipal().getFrmUsuario(frmPrincipal).getControladorAlumno().getNetbook().getIdNetbook());
        txtIdHardware.setText(frmPrincipal.getControladorFrmPrincipal().getFrmUsuario(frmPrincipal).getControladorAlumno().getNetbook().getIdHardware());
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
        lblApellidoAlumno = new javax.swing.JLabel();
        lblNombreAlumno = new javax.swing.JLabel();
        txtNombreAlumno = new javax.swing.JTextField();
        lblInfoNombre = new javax.swing.JLabel();
        txtApellidoAlumno = new javax.swing.JTextField();
        lblDniAlumno = new javax.swing.JLabel();
        txtDniAlumno = new javax.swing.JTextField();
        lblInfoApellido = new javax.swing.JLabel();
        lblCursoAlumno = new javax.swing.JLabel();
        lblInfoDni = new javax.swing.JLabel();
        cmbCursoAlumno = new javax.swing.JComboBox();
        lblDivisionAlumno = new javax.swing.JLabel();
        cmbDivisionAlumno = new javax.swing.JComboBox();
        btnBuscarFoto = new javax.swing.JButton();
        lblFotoAlumno = new javax.swing.JLabel();
        pnlFotoUsuario = new javax.swing.JDesktopPane();
        lblEstadoNombre = new javax.swing.JLabel();
        lblEstadoApellido = new javax.swing.JLabel();
        lblEstadoDni = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cmbEstado = new javax.swing.JComboBox();
        pnlTutor = new javax.swing.JPanel();
        txtTutorAlumno = new javax.swing.JTextField();
        lblInfoDniTutor = new javax.swing.JLabel();
        btnBuscarTutor = new javax.swing.JButton();
        lblTutorAlumno = new javax.swing.JLabel();
        lblEstadoTutor = new javax.swing.JLabel();
        txtApellidoTutor = new javax.swing.JTextField();
        lblApellidoTutor = new javax.swing.JLabel();
        lblNombreTutor = new javax.swing.JLabel();
        txtNombresTutor = new javax.swing.JTextField();
        lblInfoApellidoTutor = new javax.swing.JLabel();
        lblInfoNombreTutor = new javax.swing.JLabel();
        lblEstadoApeTutor = new javax.swing.JLabel();
        lblEstadoNomTutor = new javax.swing.JLabel();
        lblEstadoDniTutor = new javax.swing.JLabel();
        pntNetbook = new javax.swing.JPanel();
        lblInfoNumSerie = new javax.swing.JLabel();
        lblNetAlumno = new javax.swing.JLabel();
        txtNetAlumno = new javax.swing.JTextField();
        btnBuscarNet = new javax.swing.JButton();
        lblEstadoNet = new javax.swing.JLabel();
        lblIdHardware = new javax.swing.JLabel();
        txtIdHardware = new javax.swing.JTextField();
        lblEstadoIDHard = new javax.swing.JLabel();
        lblInfoIdHardware = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Alumno Nuevo");
        setFrameIcon(null);
        setMinimumSize(new java.awt.Dimension(560, 580));
        setPreferredSize(new java.awt.Dimension(560, 600));
        getContentPane().setLayout(null);

        btnAgregar.setText("Guardar");
        btnAgregar.setMaximumSize(new java.awt.Dimension(120, 32));
        btnAgregar.setMinimumSize(new java.awt.Dimension(120, 32));
        btnAgregar.setPreferredSize(new java.awt.Dimension(120, 32));
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregar);
        btnAgregar.setBounds(100, 490, 120, 32);

        btnSalir.setText("Cancelar");
        btnSalir.setMaximumSize(new java.awt.Dimension(120, 32));
        btnSalir.setMinimumSize(new java.awt.Dimension(120, 32));
        btnSalir.setPreferredSize(new java.awt.Dimension(120, 32));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir);
        btnSalir.setBounds(360, 490, 120, 32);

        pnlTitularNetbook.setBorder(javax.swing.BorderFactory.createTitledBorder("Titular Netbook"));
        pnlTitularNetbook.setLayout(null);

        lblApellidoAlumno.setText("Apellido");
        pnlTitularNetbook.add(lblApellidoAlumno);
        lblApellidoAlumno.setBounds(10, 76, 70, 14);

        lblNombreAlumno.setText("Nombre");
        pnlTitularNetbook.add(lblNombreAlumno);
        lblNombreAlumno.setBounds(10, 23, 70, 14);

        txtNombreAlumno.setMinimumSize(new java.awt.Dimension(200, 26));
        txtNombreAlumno.setPreferredSize(new java.awt.Dimension(200, 26));
        txtNombreAlumno.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNombreAlumnoFocusGained(evt);
            }
        });
        txtNombreAlumno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreAlumnoKeyTyped(evt);
            }
        });
        pnlTitularNetbook.add(txtNombreAlumno);
        txtNombreAlumno.setBounds(90, 20, 200, 26);

        lblInfoNombre.setFont(new java.awt.Font("Cantarell", 2, 10)); // NOI18N
        lblInfoNombre.setForeground(new java.awt.Color(244, 11, 11));
        lblInfoNombre.setText("Longitud max. de 45 caracteres y solo letras");
        pnlTitularNetbook.add(lblInfoNombre);
        lblInfoNombre.setBounds(90, 40, 207, 20);

        txtApellidoAlumno.setMinimumSize(new java.awt.Dimension(200, 26));
        txtApellidoAlumno.setPreferredSize(new java.awt.Dimension(200, 26));
        txtApellidoAlumno.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtApellidoAlumnoFocusGained(evt);
            }
        });
        txtApellidoAlumno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidoAlumnoKeyTyped(evt);
            }
        });
        pnlTitularNetbook.add(txtApellidoAlumno);
        txtApellidoAlumno.setBounds(90, 70, 200, 26);

        lblDniAlumno.setText("Dni");
        pnlTitularNetbook.add(lblDniAlumno);
        lblDniAlumno.setBounds(10, 123, 55, 14);

        txtDniAlumno.setMinimumSize(new java.awt.Dimension(200, 26));
        txtDniAlumno.setPreferredSize(new java.awt.Dimension(200, 26));
        txtDniAlumno.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDniAlumnoFocusGained(evt);
            }
        });
        txtDniAlumno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDniAlumnoKeyTyped(evt);
            }
        });
        pnlTitularNetbook.add(txtDniAlumno);
        txtDniAlumno.setBounds(90, 120, 200, 26);

        lblInfoApellido.setFont(new java.awt.Font("Cantarell", 2, 10)); // NOI18N
        lblInfoApellido.setForeground(new java.awt.Color(244, 11, 11));
        lblInfoApellido.setText("Longitud max. de 45 caracteres y solo letras");
        pnlTitularNetbook.add(lblInfoApellido);
        lblInfoApellido.setBounds(90, 90, 207, 20);

        lblCursoAlumno.setText("Curso");
        pnlTitularNetbook.add(lblCursoAlumno);
        lblCursoAlumno.setBounds(10, 170, 70, 14);

        lblInfoDni.setFont(new java.awt.Font("Cantarell", 2, 10)); // NOI18N
        lblInfoDni.setForeground(new java.awt.Color(244, 11, 11));
        lblInfoDni.setText("Longitud max. de 8 caracteres numericos");
        pnlTitularNetbook.add(lblInfoDni);
        lblInfoDni.setBounds(90, 140, 191, 20);

        cmbCursoAlumno.setFont(new java.awt.Font("Cantarell", 0, 10)); // NOI18N
        cmbCursoAlumno.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione Curso", "1", "2", "3", "4", "5" }));
        cmbCursoAlumno.setName(""); // NOI18N
        pnlTitularNetbook.add(cmbCursoAlumno);
        cmbCursoAlumno.setBounds(90, 170, 130, 20);

        lblDivisionAlumno.setText("Division");
        pnlTitularNetbook.add(lblDivisionAlumno);
        lblDivisionAlumno.setBounds(230, 170, 60, 14);

        cmbDivisionAlumno.setFont(new java.awt.Font("Cantarell", 0, 10)); // NOI18N
        cmbDivisionAlumno.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione Division", "1", "2", "3", "4", "5" }));
        pnlTitularNetbook.add(cmbDivisionAlumno);
        cmbDivisionAlumno.setBounds(285, 170, 130, 20);

        btnBuscarFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/model/image/magnifier12.png"))); // NOI18N
        btnBuscarFoto.setToolTipText("BUSCAR FOTO");
        btnBuscarFoto.setMaximumSize(new java.awt.Dimension(40, 35));
        btnBuscarFoto.setMinimumSize(new java.awt.Dimension(40, 35));
        btnBuscarFoto.setPreferredSize(new java.awt.Dimension(40, 35));
        btnBuscarFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarFotoActionPerformed(evt);
            }
        });
        pnlTitularNetbook.add(btnBuscarFoto);
        btnBuscarFoto.setBounds(450, 160, 50, 50);

        lblFotoAlumno.setText("Foto");
        lblFotoAlumno.setMaximumSize(new java.awt.Dimension(40, 14));
        lblFotoAlumno.setMinimumSize(new java.awt.Dimension(40, 14));
        lblFotoAlumno.setPreferredSize(new java.awt.Dimension(40, 14));
        pnlTitularNetbook.add(lblFotoAlumno);
        lblFotoAlumno.setBounds(440, 20, 40, 14);
        pnlTitularNetbook.add(pnlFotoUsuario);
        pnlFotoUsuario.setBounds(420, 50, 100, 100);

        lblEstadoNombre.setMaximumSize(new java.awt.Dimension(20, 20));
        lblEstadoNombre.setMinimumSize(new java.awt.Dimension(20, 20));
        lblEstadoNombre.setPreferredSize(new java.awt.Dimension(20, 20));
        pnlTitularNetbook.add(lblEstadoNombre);
        lblEstadoNombre.setBounds(290, 20, 20, 20);

        lblEstadoApellido.setMaximumSize(new java.awt.Dimension(20, 20));
        lblEstadoApellido.setMinimumSize(new java.awt.Dimension(20, 20));
        lblEstadoApellido.setPreferredSize(new java.awt.Dimension(20, 20));
        pnlTitularNetbook.add(lblEstadoApellido);
        lblEstadoApellido.setBounds(290, 70, 20, 20);

        lblEstadoDni.setMaximumSize(new java.awt.Dimension(20, 20));
        lblEstadoDni.setMinimumSize(new java.awt.Dimension(20, 20));
        lblEstadoDni.setPreferredSize(new java.awt.Dimension(20, 20));
        pnlTitularNetbook.add(lblEstadoDni);
        lblEstadoDni.setBounds(290, 120, 20, 20);

        jLabel4.setText("Estado");
        pnlTitularNetbook.add(jLabel4);
        jLabel4.setBounds(10, 210, 70, 14);

        cmbEstado.setFont(new java.awt.Font("Cantarell", 0, 10)); // NOI18N
        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione Estado", "REGULAR", "REPITENTE", "ABANDONA SIN EQUIPO", "EGRESADO A RECIBIR", "EGRESADO CON EQUIPO", "ABANDONA CON EQUIPO", "EGRESADO NO CORRESPONDE EQUIPO" }));
        cmbEstado.setPreferredSize(new java.awt.Dimension(114, 21));
        pnlTitularNetbook.add(cmbEstado);
        cmbEstado.setBounds(90, 210, 130, 21);

        getContentPane().add(pnlTitularNetbook);
        pnlTitularNetbook.setBounds(0, 120, 550, 250);

        pnlTutor.setBorder(javax.swing.BorderFactory.createTitledBorder("Tutor"));
        pnlTutor.setLayout(null);

        txtTutorAlumno.setFont(new java.awt.Font("Cantarell", 2, 10)); // NOI18N
        txtTutorAlumno.setText("Ingrese DNI");
        txtTutorAlumno.setPreferredSize(new java.awt.Dimension(150, 21));
        txtTutorAlumno.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTutorAlumnoFocusGained(evt);
            }
        });
        txtTutorAlumno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTutorAlumnoKeyTyped(evt);
            }
        });
        pnlTutor.add(txtTutorAlumno);
        txtTutorAlumno.setBounds(90, 20, 150, 21);

        lblInfoDniTutor.setFont(new java.awt.Font("Cantarell", 2, 10)); // NOI18N
        lblInfoDniTutor.setForeground(new java.awt.Color(244, 11, 11));
        lblInfoDniTutor.setText("Longitud max. de 8 caracteres numericos");
        pnlTutor.add(lblInfoDniTutor);
        lblInfoDniTutor.setBounds(90, 35, 191, 20);

        btnBuscarTutor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/model/image/magnifier12.png"))); // NOI18N
        btnBuscarTutor.setToolTipText("BUSCAR TUTOR");
        btnBuscarTutor.setMaximumSize(new java.awt.Dimension(40, 35));
        btnBuscarTutor.setMinimumSize(new java.awt.Dimension(40, 35));
        btnBuscarTutor.setPreferredSize(new java.awt.Dimension(40, 35));
        btnBuscarTutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarTutorActionPerformed(evt);
            }
        });
        pnlTutor.add(btnBuscarTutor);
        btnBuscarTutor.setBounds(300, 15, 50, 50);

        lblTutorAlumno.setText("Dni");
        pnlTutor.add(lblTutorAlumno);
        lblTutorAlumno.setBounds(10, 25, 70, 14);

        lblEstadoTutor.setText("    ");
        lblEstadoTutor.setMaximumSize(new java.awt.Dimension(20, 20));
        lblEstadoTutor.setMinimumSize(new java.awt.Dimension(20, 20));
        lblEstadoTutor.setPreferredSize(new java.awt.Dimension(20, 20));
        pnlTutor.add(lblEstadoTutor);
        lblEstadoTutor.setBounds(240, 20, 22, 20);
        pnlTutor.add(txtApellidoTutor);
        txtApellidoTutor.setBounds(90, 60, 150, 20);

        lblApellidoTutor.setText("Apellido");
        pnlTutor.add(lblApellidoTutor);
        lblApellidoTutor.setBounds(10, 65, 80, 14);

        lblNombreTutor.setText("Nombres");
        pnlTutor.add(lblNombreTutor);
        lblNombreTutor.setBounds(295, 65, 70, 14);
        pnlTutor.add(txtNombresTutor);
        txtNombresTutor.setBounds(350, 60, 150, 20);

        lblInfoApellidoTutor.setFont(new java.awt.Font("Cantarell", 2, 10)); // NOI18N
        lblInfoApellidoTutor.setForeground(new java.awt.Color(240, 15, 15));
        lblInfoApellidoTutor.setText("Longitud max. de 45 caracteres y solo letras");
        pnlTutor.add(lblInfoApellidoTutor);
        lblInfoApellidoTutor.setBounds(90, 80, 220, 20);

        lblInfoNombreTutor.setFont(new java.awt.Font("Cantarell", 2, 10)); // NOI18N
        lblInfoNombreTutor.setForeground(new java.awt.Color(243, 12, 12));
        lblInfoNombreTutor.setText("Longitud max. de 45 caracteres y solo letras");
        pnlTutor.add(lblInfoNombreTutor);
        lblInfoNombreTutor.setBounds(330, 80, 220, 20);
        pnlTutor.add(lblEstadoApeTutor);
        lblEstadoApeTutor.setBounds(240, 61, 20, 20);
        pnlTutor.add(lblEstadoNomTutor);
        lblEstadoNomTutor.setBounds(500, 61, 20, 20);
        pnlTutor.add(lblEstadoDniTutor);
        lblEstadoDniTutor.setBounds(233, 20, 20, 20);

        getContentPane().add(pnlTutor);
        pnlTutor.setBounds(0, 0, 550, 120);

        pntNetbook.setBorder(javax.swing.BorderFactory.createTitledBorder("Netbook"));
        pntNetbook.setMinimumSize(new java.awt.Dimension(550, 120));
        pntNetbook.setPreferredSize(new java.awt.Dimension(550, 110));
        pntNetbook.setLayout(null);

        lblInfoNumSerie.setFont(new java.awt.Font("Cantarell", 2, 10)); // NOI18N
        lblInfoNumSerie.setForeground(new java.awt.Color(244, 11, 11));
        lblInfoNumSerie.setText("Longitud max. de 15 caracteres");
        pntNetbook.add(lblInfoNumSerie);
        lblInfoNumSerie.setBounds(110, 35, 147, 20);

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
        txtNetAlumno.setBounds(110, 20, 150, 20);

        btnBuscarNet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/model/image/magnifier12.png"))); // NOI18N
        btnBuscarNet.setToolTipText("BUSCAR NETBOOK");
        btnBuscarNet.setMaximumSize(new java.awt.Dimension(40, 35));
        btnBuscarNet.setMinimumSize(new java.awt.Dimension(40, 35));
        btnBuscarNet.setPreferredSize(new java.awt.Dimension(40, 35));
        btnBuscarNet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarNetActionPerformed(evt);
            }
        });
        pntNetbook.add(btnBuscarNet);
        btnBuscarNet.setBounds(300, 15, 50, 50);

        lblEstadoNet.setText("     ");
        lblEstadoNet.setMaximumSize(new java.awt.Dimension(20, 20));
        lblEstadoNet.setMinimumSize(new java.awt.Dimension(20, 20));
        lblEstadoNet.setPreferredSize(new java.awt.Dimension(20, 20));
        pntNetbook.add(lblEstadoNet);
        lblEstadoNet.setBounds(260, 20, 20, 20);

        lblIdHardware.setText("ID Hardware");
        pntNetbook.add(lblIdHardware);
        lblIdHardware.setBounds(10, 65, 70, 14);
        pntNetbook.add(txtIdHardware);
        txtIdHardware.setBounds(110, 60, 150, 20);
        pntNetbook.add(lblEstadoIDHard);
        lblEstadoIDHard.setBounds(260, 60, 20, 20);

        lblInfoIdHardware.setFont(new java.awt.Font("Cantarell", 2, 10)); // NOI18N
        lblInfoIdHardware.setForeground(new java.awt.Color(241, 14, 14));
        lblInfoIdHardware.setText("Longitud max. de 20 caracteres");
        pntNetbook.add(lblInfoIdHardware);
        lblInfoIdHardware.setBounds(110, 75, 170, 20);

        getContentPane().add(pntNetbook);
        pntNetbook.setBounds(0, 370, 550, 110);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        int respuesta = JOptionPane.showConfirmDialog(this, "¿Desea Salir?", "Salir", JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION) {
            dispose();
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    private void txtNombreAlumnoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreAlumnoKeyTyped
        // TODO add your handling code here:
        String nombre = txtNombreAlumno.getText();
        String pathImagen = "/model/image/";
        if (nombre.length() >= 45) {
            evt.consume();
        }
        if (Character.isDigit(evt.getKeyChar()) && evt.getKeyChar() != KeyEvent.VK_BACK_SPACE) {
            evt.consume();
            controladorFrmAltaAlumno.mostrarLabellInformativo(lblInfoNombre);
        } else {
            controladorFrmAltaAlumno.ocultarLabellInformativo(lblInfoNombre);
        }
        for (Character c : ListaCaracteresNoValidos.LISTA) {
            if (evt.getKeyChar() == c) {
                evt.consume();
                controladorFrmAltaAlumno.mostrarLabellInformativo(lblInfoNombre);
            }
        }
        if ((nombre.length() <= 45) && (!nombre.isEmpty()) && (!Character.isDigit(evt.getKeyChar()))) {
            pathImagen += "si.png";
            controladorFrmAltaAlumno.setCampoNombreEsValido(true);

        } else {
            pathImagen += "no.png";
            controladorFrmAltaAlumno.setCampoNombreEsValido(false);
        }
        controladorFrmAltaAlumno.agregarImagenEstadoLabel(lblEstadoNombre, pathImagen);
        controladorFrmAltaAlumno.mostrarLabellInformativo(lblEstadoNombre);
    }//GEN-LAST:event_txtNombreAlumnoKeyTyped

    private void txtApellidoAlumnoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoAlumnoKeyTyped
        // TODO add your handling code here:
        String apellido = txtApellidoAlumno.getText();
        String pathImagen = "/model/image/";
        if (apellido.length() >= 45) {
            evt.consume();
            controladorFrmAltaAlumno.mostrarLabellInformativo(lblInfoApellido);
        }
        if (Character.isDigit(evt.getKeyChar()) && evt.getKeyChar() != KeyEvent.VK_BACK_SPACE) {
            evt.consume();
            controladorFrmAltaAlumno.mostrarLabellInformativo(lblInfoApellido);
        } else {
            controladorFrmAltaAlumno.ocultarLabellInformativo(lblInfoApellido);
        }
        for (Character c : ListaCaracteresNoValidos.LISTA) {
            if (evt.getKeyChar() == c) {
                evt.consume();
                controladorFrmAltaAlumno.mostrarLabellInformativo(lblInfoApellido);
            }
        }
        if ((apellido.length() <= 45) && (!apellido.isEmpty()) && (!Character.isDigit(evt.getKeyChar()))) {
            pathImagen += "si.png";
            controladorFrmAltaAlumno.setCampoApellidoEsValido(true);
        } else {
            controladorFrmAltaAlumno.setCampoApellidoEsValido(false);
            pathImagen += "no.png";
        }
        controladorFrmAltaAlumno.agregarImagenEstadoLabel(lblEstadoApellido, pathImagen);
        controladorFrmAltaAlumno.mostrarLabellInformativo(lblEstadoApellido);
    }//GEN-LAST:event_txtApellidoAlumnoKeyTyped

    private void txtDniAlumnoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniAlumnoKeyTyped
        // TODO add your handling code here:
        String dni = txtDniAlumno.getText();
        String pathImagen = "/model/image/";
        if (dni.length() >= 8) {
            evt.consume();
        }
        if (!Character.isDigit(evt.getKeyChar()) && evt.getKeyChar() != KeyEvent.VK_BACK_SPACE) {
            evt.consume();
            controladorFrmAltaAlumno.mostrarLabellInformativo(lblInfoDni);
        } else {
            controladorFrmAltaAlumno.ocultarLabellInformativo(lblInfoDni);
        }
        for (Character c : ListaCaracteresNoValidos.LISTA) {
            if (evt.getKeyChar() == c) {
                evt.consume();
                controladorFrmAltaAlumno.mostrarLabellInformativo(lblInfoDni);
            }
        }
        if (((dni.length() == 7) || (dni.length() == 8)) && (!dni.isEmpty()) && (Character.isDigit(evt.getKeyChar()))) {
            pathImagen += "si.png";
            controladorFrmAltaAlumno.setCampoDniEsValido(true);
        } else {
            controladorFrmAltaAlumno.setCampoDniEsValido(false);
            pathImagen += "no.png";
        }
        controladorFrmAltaAlumno.agregarImagenEstadoLabel(lblEstadoDni, pathImagen);
        controladorFrmAltaAlumno.mostrarLabellInformativo(lblEstadoDni);
    }//GEN-LAST:event_txtDniAlumnoKeyTyped

    private void txtTutorAlumnoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTutorAlumnoKeyTyped
        // TODO add your handling code here:
        String dniTutor = txtTutorAlumno.getText();
        if (dniTutor.length() >= 8) {
            evt.consume();
        }
        if (!Character.isDigit(evt.getKeyChar()) && evt.getKeyChar() != KeyEvent.VK_BACK_SPACE) {
            evt.consume();
            controladorFrmAltaAlumno.mostrarLabellInformativo(lblInfoDniTutor);
        } else {
            controladorFrmAltaAlumno.ocultarLabellInformativo(lblInfoDniTutor);
        }
        for (Character c : ListaCaracteresNoValidos.LISTA) {
            if (evt.getKeyChar() == c) {
                evt.consume();
                controladorFrmAltaAlumno.mostrarLabellInformativo(lblInfoDniTutor);
            }
        }


    }//GEN-LAST:event_txtTutorAlumnoKeyTyped

    private void txtNetAlumnoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNetAlumnoKeyTyped
        // TODO add your handling code here:
        String serie = txtNetAlumno.getText();
        for (Character c : ListaCaracteresNoValidos.LISTA) {
            if ((evt.getKeyChar() != KeyEvent.VK_BACK_SPACE) && (evt.getKeyChar() == c)) {
                evt.consume();
                controladorFrmAltaAlumno.mostrarLabellInformativo(lblInfoNumSerie);
            } else {
                controladorFrmAltaAlumno.ocultarLabellInformativo(lblInfoNumSerie);
            }
        }

        if ((serie.length() >= 15) && (evt.getKeyChar() != KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtNetAlumnoKeyTyped

    private void btnBuscarTutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarTutorActionPerformed
        // TODO add your handling code here:
        String pathImagen = "/model/image/";
        int respuesta = 0;
        if (!txtTutorAlumno.getText().equals("Ingrese DNI")) {
            if (!txtTutorAlumno.getText().isEmpty()) {
                if (controladorTutor.verificarExistencia(txtTutorAlumno)) {
                    pathImagen += "si.png";
                    controladorFrmAltaAlumno.setCampoTutorEsValido(true);
                    controladorTutor.setPersona(controladorTutor.obtenerDatosTutor(Integer.parseInt(txtTutorAlumno.getText())));
                    txtNombresTutor.setText(controladorTutor.getPersona().getNombre());
                    txtApellidoTutor.setText(controladorTutor.getPersona().getApellido());
                    controladorFrmAltaAlumno.agregarImagenEstadoLabel(lblEstadoTutor, pathImagen);
                } else {
                    txtNombresTutor.setText("");
                    txtApellidoTutor.setText("");
                    respuesta = JOptionPane.showConfirmDialog(this, "¿Desea Ingresar Tutor Nuevo?", "Tutor ingresado no existe", JOptionPane.YES_NO_OPTION);
                    if (respuesta == JOptionPane.YES_OPTION) {
                        FrmTutorCRUD frmTutorAlta = new FrmTutorCRUD(frmPrincipal.getControladorFrmPrincipal().getFrmUsuario(frmPrincipal), 'a');
                        frmPrincipal.getDesktopPane().add(frmTutorAlta);
                        frmTutorAlta.setVisible(true);
                    } else {
                        pathImagen += "no.png";
                        controladorFrmAltaAlumno.setCampoTutorEsValido(false);
                        controladorFrmAltaAlumno.agregarImagenEstadoLabel(lblEstadoTutor, pathImagen);
                    }

                }
            } else {
                JOptionPane.showMessageDialog(this, "Debe ingresar un numero de DNI valido");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debe ingresar un numero de DNI valido");
        }
    }//GEN-LAST:event_btnBuscarTutorActionPerformed

    private void btnBuscarNetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarNetActionPerformed
        // TODO add your handling code here:
        String pathImagen = "/model/image/";
        int respuesta = 0;
        if (!txtNetAlumno.getText().equals("Ingrese Nº Serie")) {
            if (!txtNetAlumno.getText().isEmpty()) {
                if (controladorNetbook.verificarExistencia(txtNetAlumno)) {
                    controladorNetbook.setNetbook(controladorNetbook.buscarNetbookSerie(txtNetAlumno.getText()));
                    txtIdHardware.setText(controladorNetbook.getNetbook().getIdHardware());
                    if (!controladorNetbook.verificarEstadoNetbook(txtNetAlumno)) {
                        pathImagen += "si.png";
                        controladorFrmAltaAlumno.setCampoNetbookEsValido(true);
                        controladorFrmAltaAlumno.agregarImagenEstadoLabel(lblEstadoNet, pathImagen);
                    } else {
                        JOptionPane.showMessageDialog(this, "Debe reasignar la netbook");
                    }
                } else {
                    txtIdHardware.setText("");
                    respuesta = JOptionPane.showConfirmDialog(this, "¿Desea Ingresar Netbook nueva?", "Netbook ingresada no existe", JOptionPane.YES_NO_OPTION);
                    if (respuesta == JOptionPane.YES_OPTION) {
                        FrmNetbookCRUD frmNetbookAlta = new FrmNetbookCRUD(frmPrincipal, 'a');
                        frmPrincipal.getDesktopPane().add(frmNetbookAlta);
                        frmNetbookAlta.setVisible(true);
                        try {
                            txtIdHardware.setText(controladorNetbook.getNetbook().getIdHardware());
                                pathImagen += "si.png";
                                controladorFrmAltaAlumno.setCampoNetbookEsValido(true);
                                controladorFrmAltaAlumno.agregarImagenEstadoLabel(lblEstadoNet, pathImagen);
                            
                        } catch (NullPointerException ex) {
                        }
                    } else {
                        pathImagen += "no.png";
                        controladorFrmAltaAlumno.setCampoNetbookEsValido(false);
                        controladorFrmAltaAlumno.agregarImagenEstadoLabel(lblEstadoNet, pathImagen);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Debe ingresar un Numero de Serie valido");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debe ingresar un Numero de Serie valido");
        }
    }//GEN-LAST:event_btnBuscarNetActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        switch (tipoTransaccion) {
            case 'a':
                if (controladorFrmAltaAlumno.verificarCampos(this)) {
                    controladorAlumno.alumnoNuevo(this);
                    controladorAlumno.actualizarTblAlumno(frmPrincipal, tipoTransaccion);
                    JOptionPane.showMessageDialog(this, "Se guardo el registro correctamente");
                    frmPrincipal.getControladorFrmPrincipal().getFrmUsuario(frmPrincipal).getControladorFormularioUsuario().actualizarCantidadNetbookOsciosas(frmPrincipal.getControladorFrmPrincipal().getFrmUsuario(frmPrincipal));
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Verifique que los datos ingresados sean correctos");
                }
                break;
            case 'v':
                dispose();
                break;
            case 'm':

                if (controladorFrmAltaAlumno.isCampoTutorEsValido()) {
                    int respuesta = JOptionPane.showConfirmDialog(this, "¿Esta seguro de modificar el registro?", "Modificar Datos", JOptionPane.YES_NO_OPTION);
                    if (respuesta == JOptionPane.YES_OPTION) {
                        controladorAlumno.modificarAlumno(this);
                        JOptionPane.showMessageDialog(this, "Se modifico el regitro correctamente");
                        dispose();
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Verifique que seleccionó un tutor válido");
                }

        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void txtNombreAlumnoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreAlumnoFocusGained
        // TODO add your handling code here:
        controladorFrmAltaAlumno.verificarFocoObtenido(txtNombreAlumno, lblEstadoNombre);
    }//GEN-LAST:event_txtNombreAlumnoFocusGained

    private void txtApellidoAlumnoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtApellidoAlumnoFocusGained
        // TODO add your handling code here:
        controladorFrmAltaAlumno.verificarFocoObtenido(txtApellidoAlumno, lblEstadoApellido);
    }//GEN-LAST:event_txtApellidoAlumnoFocusGained

    private void txtDniAlumnoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDniAlumnoFocusGained
        // TODO add your handling code here:
        controladorFrmAltaAlumno.verificarFocoObtenido(txtDniAlumno, lblEstadoDni);
    }//GEN-LAST:event_txtDniAlumnoFocusGained

    private void btnBuscarFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarFotoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarFotoActionPerformed

    private void txtTutorAlumnoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTutorAlumnoFocusGained
        // TODO add your handling code here:
        txtTutorAlumno.setText("");
    }//GEN-LAST:event_txtTutorAlumnoFocusGained

    private void txtNetAlumnoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNetAlumnoFocusGained
        // TODO add your handling code here:
        txtNetAlumno.setText("");
    }//GEN-LAST:event_txtNetAlumnoFocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscarFoto;
    private javax.swing.JButton btnBuscarNet;
    private javax.swing.JButton btnBuscarTutor;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox cmbCursoAlumno;
    private javax.swing.JComboBox cmbDivisionAlumno;
    private javax.swing.JComboBox cmbEstado;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblApellidoAlumno;
    private javax.swing.JLabel lblApellidoTutor;
    private javax.swing.JLabel lblCursoAlumno;
    private javax.swing.JLabel lblDivisionAlumno;
    private javax.swing.JLabel lblDniAlumno;
    private javax.swing.JLabel lblEstadoApeTutor;
    private javax.swing.JLabel lblEstadoApellido;
    private javax.swing.JLabel lblEstadoDni;
    private javax.swing.JLabel lblEstadoDniTutor;
    private javax.swing.JLabel lblEstadoIDHard;
    private javax.swing.JLabel lblEstadoNet;
    private javax.swing.JLabel lblEstadoNomTutor;
    private javax.swing.JLabel lblEstadoNombre;
    private javax.swing.JLabel lblEstadoTutor;
    private javax.swing.JLabel lblFotoAlumno;
    private javax.swing.JLabel lblIdHardware;
    private javax.swing.JLabel lblInfoApellido;
    private javax.swing.JLabel lblInfoApellidoTutor;
    private javax.swing.JLabel lblInfoDni;
    private javax.swing.JLabel lblInfoDniTutor;
    private javax.swing.JLabel lblInfoIdHardware;
    private javax.swing.JLabel lblInfoNombre;
    private javax.swing.JLabel lblInfoNombreTutor;
    private javax.swing.JLabel lblInfoNumSerie;
    private javax.swing.JLabel lblNetAlumno;
    private javax.swing.JLabel lblNombreAlumno;
    private javax.swing.JLabel lblNombreTutor;
    private javax.swing.JLabel lblTutorAlumno;
    private javax.swing.JDesktopPane pnlFotoUsuario;
    private javax.swing.JPanel pnlTitularNetbook;
    private javax.swing.JPanel pnlTutor;
    private javax.swing.JPanel pntNetbook;
    private javax.swing.JTextField txtApellidoAlumno;
    private javax.swing.JTextField txtApellidoTutor;
    private javax.swing.JTextField txtDniAlumno;
    private javax.swing.JTextField txtIdHardware;
    private javax.swing.JTextField txtNetAlumno;
    private javax.swing.JTextField txtNombreAlumno;
    private javax.swing.JTextField txtNombresTutor;
    private javax.swing.JTextField txtTutorAlumno;
    // End of variables declaration//GEN-END:variables

    public JTextField getTxtNombreAlumno() {
        return txtNombreAlumno;
    }

    public ControladorFrmAltaAlumno getControladorFrmAltaAlumno() {
        return this.controladorFrmAltaAlumno;
    }

    public JButton getBotonBuscarNetbook() {
        return btnBuscarNet;
    }
    
    public  JButton getBotonBuscarFoto(){
        return btnBuscarFoto;
    }

    public JTextField getTxtApellidoAlumno() {
        return txtApellidoAlumno;
    }

    public JTextField getTxtDniAlumno() {
        return txtDniAlumno;
    }

    public JTextField getTxtTutor() {
        return txtTutorAlumno;
    }

    public JTextField getTxtApellidoTutor() {
        return txtApellidoTutor;
    }

    public JTextField getTxtNombresTutor() {
        return txtNombresTutor;
    }

    public JTextField getTxtNetbook() {
        return txtNetAlumno;
    }

    

    public JTextField getTxtIdHardNetbook() {
        return txtIdHardware;
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

    public JLabel getLabelEstadoTutor() {
        return lblEstadoTutor;
    }

    public JLabel getLabelEstadoNetbook() {
        return lblEstadoNet;
    }

    public JLabel getLabelInfoSerieNetbook() {
        return lblInfoNumSerie;
    }

    public JLabel getLabelInfoMarcaNetbook() {
        return lblInfoIdHardware;
    }


    public JLabel getLabelInfoApellidoTutor() {
        return lblInfoApellidoTutor;
    }

    public JLabel getLabelInfoNombresTutor() {
        return lblInfoNombreTutor;
    }

    public JLabel getLabelInfoDniTutor() {
        return lblInfoDniTutor;
    }

    public JLabel getLabelInfoDniAlumno() {
        return lblInfoDni;
    }

    public JLabel getLabelInfoApellidoAlumno() {
        return lblInfoApellido;
    }

    public JLabel getLabelInfoNombresAlumno() {
        return lblInfoNombre;
    }

    public JComboBox getCmbCurso() {
        return cmbCursoAlumno;
    }

    public JComboBox getCmbDivision() {
        return cmbDivisionAlumno;
    }

    public JComboBox getCmbEstado() {
        return cmbEstado;
    }

    public FrmPrincipal getFrmPrincipal() {
        return frmPrincipal;
    }
}
