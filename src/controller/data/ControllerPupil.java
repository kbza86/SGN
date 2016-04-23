/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.data;

import hibernate.dao.AlumnoDAO;
import hibernate.dao.NetbookDAO;
import hibernate.dao.PersonaDAO;
import hibernate.dao.TutorDAO;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.domain.Alumno;
import model.domain.Netbook;
import model.domain.Persona;
import model.domain.Tutor;
import modelo.util.ItemComparable;
import modelo.util.Sort;
import org.hibernate.mapping.Collection;
import view.pupil.FrmAlumnoCRUD;
import view.main.FrmPrincipal;
import view.user.FrmUser;

/**
 *
 * @author wally86
 */
public class ControllerPupil {

    private AlumnoDAO alumnoDAO;
    private PersonaDAO personaDAO;
    private TutorDAO tutorDAO;
    private NetbookDAO netbookDAO;
    private Netbook netbook;
    private Tutor tutor;
    private Alumno alumno;
    private Persona personaAlumno;
    private Persona personaTutor;
    private ControllerNetbook controladorNetbook;
/**
 * Constructor
 * 
 */
    public ControllerPupil() {
        this.alumnoDAO = new AlumnoDAO();
        this.netbook = new Netbook();
        this.netbookDAO = new NetbookDAO();
        this.personaDAO = new PersonaDAO();
        this.tutor = new Tutor();
        this.tutorDAO = new TutorDAO();
        this.alumno = new Alumno();
        this.personaAlumno = new Persona();
        this.personaTutor = new Persona();
        this.controladorNetbook = new ControllerNetbook();
    }
/**
 * 
 * @param frmAlumnoAlta
 * Alta a un alumno 
 */
    public void alumnoNuevo(FrmAlumnoCRUD frmAlumnoAlta) {

        Tutor tutorEncontrado = getTutorDAO().obteneTutorPorDni(Integer.parseInt(frmAlumnoAlta.getTxtTutor().getText()));
        Netbook netbookEncontrada = getNetbookDAO().obtenerNetbook(frmAlumnoAlta.getTxtNetbook().getText());
        //Se cambia el estado de la netbook en caso de que se haya agregado por separado
        netbookEncontrada.setEstado(true);
        controladorNetbook.actualizarDatosNetbook(netbookEncontrada);
        String nombre = frmAlumnoAlta.getTxtNombreAlumno().getText();
        String apellido = frmAlumnoAlta.getTxtApellidoAlumno().getText();
        int dni = Integer.parseInt(frmAlumnoAlta.getTxtDniAlumno().getText());
        Persona persona = new Persona(
                getPersonaDAO().obtenerUltimoId(), nombre.toUpperCase(), apellido.toUpperCase(), dni, true);
        //Verifica  que no exista la persona
        if (!personaDAO.verificarExistencia(dni)) {
            //Alta a persona nueva(alumno)
            getPersonaDAO().altaPersona(persona);
            setPersonaAlumno(persona);
            String curso = String.valueOf(frmAlumnoAlta.getCmbCurso().getSelectedItem());
            String division = String.valueOf(frmAlumnoAlta.getCmbDivision().getSelectedItem());
            String estado = String.valueOf(frmAlumnoAlta.getCmbEstado().getSelectedItem()).toUpperCase();
            Alumno alumnoNuevo = new Alumno(getAlumnoDAO().obtenerUltimoId(), tutorEncontrado, netbookEncontrada, persona, curso, division, estado, null);
            this.setAlumno(alumnoNuevo);
            getAlumnoDAO().altaAlumno(alumnoNuevo);
            setAlumno(alumnoNuevo);
        } else {
            JOptionPane.showMessageDialog(frmAlumnoAlta, "Esta Persona ya existe en la Base de Datos");
        }
    }
/**
 * 
 * @param frmPrincipal
 * 
 */
    
    public void bajaAlumno(FrmPrincipal frmPrincipal) {
        frmPrincipal.getControladorFrmPrincipal().getFrmUsuario(frmPrincipal).getControladorAlumno().getAlumno().setEstado("BAJA");
        alumnoDAO.modificarAlumno(frmPrincipal.getControladorFrmPrincipal().getFrmUsuario(frmPrincipal).getControladorAlumno().getAlumno());
    }
/**
 * 
 * @param frmAlumnoAlta 
 */
    public void modificarAlumno(FrmAlumnoCRUD frmAlumnoAlta) {
        //deshabilitar sector netbook    
        frmAlumnoAlta.getControladorFrmAltaAlumno().deshabilitarBoton(frmAlumnoAlta.getBotonBuscarNetbook());
        frmAlumnoAlta.getControladorFrmAltaAlumno().deshabilitarCampoTxt(frmAlumnoAlta.getTxtNetbook());
        frmAlumnoAlta.getControladorFrmAltaAlumno().deshabilitarCampoTxt(frmAlumnoAlta.getTxtIdHardNetbook());
        
        //setea nuevos valores
        //Datos Persona Alumno
        frmAlumnoAlta.getFrmPrincipal().getControladorFrmPrincipal().getFrmUsuario(frmAlumnoAlta.getFrmPrincipal()).getControladorAlumno().getPersonaAlumno().setApellido(frmAlumnoAlta.getTxtApellidoAlumno().getText());
        frmAlumnoAlta.getFrmPrincipal().getControladorFrmPrincipal().getFrmUsuario(frmAlumnoAlta.getFrmPrincipal()).getControladorAlumno().getPersonaAlumno().setNombre(frmAlumnoAlta.getTxtNombreAlumno().getText());
        frmAlumnoAlta.getFrmPrincipal().getControladorFrmPrincipal().getFrmUsuario(frmAlumnoAlta.getFrmPrincipal()).getControladorAlumno().getPersonaAlumno().setDni(Integer.parseInt(frmAlumnoAlta.getTxtDniAlumno().getText()));
        personaDAO.modificarPersona(frmAlumnoAlta.getFrmPrincipal().getControladorFrmPrincipal().getFrmUsuario(frmAlumnoAlta.getFrmPrincipal()).getControladorAlumno().getPersonaAlumno());
        //Datos Persona Tutor
        frmAlumnoAlta.getFrmPrincipal().getControladorFrmPrincipal().getFrmUsuario(frmAlumnoAlta.getFrmPrincipal()).getControladorAlumno().getPersonaTutor().setApellido(frmAlumnoAlta.getTxtApellidoTutor().getText());
        frmAlumnoAlta.getFrmPrincipal().getControladorFrmPrincipal().getFrmUsuario(frmAlumnoAlta.getFrmPrincipal()).getControladorAlumno().getPersonaTutor().setNombre(frmAlumnoAlta.getTxtNombresTutor().getText());
        frmAlumnoAlta.getFrmPrincipal().getControladorFrmPrincipal().getFrmUsuario(frmAlumnoAlta.getFrmPrincipal()).getControladorAlumno().getPersonaTutor().setDni(Integer.parseInt(frmAlumnoAlta.getTxtTutor().getText()));
        personaDAO.modificarPersona(frmAlumnoAlta.getFrmPrincipal().getControladorFrmPrincipal().getFrmUsuario(frmAlumnoAlta.getFrmPrincipal()).getControladorAlumno().getPersonaTutor());
        //Datos Alumno        
        frmAlumnoAlta.getFrmPrincipal().getControladorFrmPrincipal().getFrmUsuario(frmAlumnoAlta.getFrmPrincipal()).getControladorAlumno().getAlumno().setCurso(String.valueOf(frmAlumnoAlta.getCmbCurso().getSelectedItem()));
        frmAlumnoAlta.getFrmPrincipal().getControladorFrmPrincipal().getFrmUsuario(frmAlumnoAlta.getFrmPrincipal()).getControladorAlumno().getAlumno().setDivision(String.valueOf(frmAlumnoAlta.getCmbDivision().getSelectedItem()));
        frmAlumnoAlta.getFrmPrincipal().getControladorFrmPrincipal().getFrmUsuario(frmAlumnoAlta.getFrmPrincipal()).getControladorAlumno().getAlumno().setEstado(String.valueOf(frmAlumnoAlta.getCmbEstado().getSelectedItem()));
        //En caso de abandono sin equipo, el mismo pasa a oscioso
        if (frmAlumnoAlta.getFrmPrincipal().getControladorFrmPrincipal().getFrmUsuario(frmAlumnoAlta.getFrmPrincipal()).getControladorAlumno().getAlumno().getEstado().equals("ABANDONA SIN EQUIPO")) {
            Netbook netbookOsciosa = controladorNetbook.buscarNetbookSerie(frmAlumnoAlta.getFrmPrincipal().getControladorFrmPrincipal().getFrmUsuario(frmAlumnoAlta.getFrmPrincipal()).getControladorAlumno().getNetbook().getIdNetbook());
            if (netbookOsciosa.isEstado()) {
                netbookOsciosa.setEstado(false);
                getNetbookDAO().modificarNetbook(netbookOsciosa);
                frmAlumnoAlta.getFrmPrincipal().getControladorFrmPrincipal().getFrmUsuario(frmAlumnoAlta.getFrmPrincipal()).getControladorFormularioUsuario().actualizarCantidadNetbookOsciosas(
                        frmAlumnoAlta.getFrmPrincipal().getControladorFrmPrincipal().getFrmUsuario(frmAlumnoAlta.getFrmPrincipal()));
            }
        }
        if (!frmAlumnoAlta.getFrmPrincipal().getControladorFrmPrincipal().getFrmUsuario(frmAlumnoAlta.getFrmPrincipal()).getControladorAlumno().getAlumno().getEstado().equals("ABANDONA SIN EQUIPO")) {
            Netbook netbookOsciosa = controladorNetbook.buscarNetbookSerie(frmAlumnoAlta.getFrmPrincipal().getControladorFrmPrincipal().getFrmUsuario(frmAlumnoAlta.getFrmPrincipal()).getControladorAlumno().getNetbook().getIdNetbook());
            if (!netbookOsciosa.isEstado()) {
                netbookOsciosa.setEstado(true);
                getNetbookDAO().modificarNetbook(netbookOsciosa);
                frmAlumnoAlta.getFrmPrincipal().getControladorFrmPrincipal().getFrmUsuario(frmAlumnoAlta.getFrmPrincipal()).getControladorFormularioUsuario().actualizarCantidadNetbookOsciosas(
                        frmAlumnoAlta.getFrmPrincipal().getControladorFrmPrincipal().getFrmUsuario(frmAlumnoAlta.getFrmPrincipal()));
            }
        }

        //realizamos la modificacion
        getAlumnoDAO().modificarAlumno(frmAlumnoAlta.getFrmPrincipal().getControladorFrmPrincipal().getFrmUsuario(frmAlumnoAlta.getFrmPrincipal()).getControladorAlumno().getAlumno());
        //actualizar la tabla alumno
        frmAlumnoAlta.getFrmPrincipal().getControladorFrmPrincipal().getFrmUsuario(frmAlumnoAlta.getFrmPrincipal()).getControladorAlumno().actualizarTblAlumno(frmAlumnoAlta.getFrmPrincipal(), 'm');

    }
/**
 * 
 * @param dni
 * @return alumno
 * 
 */
    public Alumno buscarAlumnoPorDni(int dni) {
        return (getAlumnoDAO().buscarAlumnoDni(dni));
    }
/**
 * 
 * @param numeroSerie
 * @return alumno
 */
    public Alumno buscarAlumnoPorNetbook(String numeroSerie) {
        return alumnoDAO.buscarAlumnoNetbook(numeroSerie);
    }
/**
 * 
 * @param tblAlumno
 * @return  JTable
 * Carga un jtable con todos los alumnos en la BD
 */
    public JTable cargarGrillaAlumnos(JTable tblAlumno) {
        tblAlumno.removeAll();
        DefaultTableModel tableModel = (DefaultTableModel) tblAlumno.getModel();
        tableModel.setNumRows(0);
        Object[] fila = new Object[3];
        //orden de alumnos
        List<Alumno> lista = getAlumnoDAO().obtenerTodosAlumnos();
        Collections.sort(lista);
        for (Alumno alu : lista) {
            Persona persona = getPersonaDAO().obtenerPersonaPorId(alu.getPersona().getIdPersona());
            fila[0] = persona.getApellido() + " " + persona.getNombre();
            fila[1] = alu.getCurso() + "º " + alu.getDivision() + "º";
            fila[2] = persona.getDni();
            tableModel.addRow(fila);
        }
        return tblAlumno;
    }
/**
 * 
 * @param table
 * @param tipoVista 
 * Carga los alumnos en un JTable dependiendo de la vista seleccionada 
 */
    public void cargarGrillaAlumnos(JTable table, String tipoVista) {
        Object[] fila = new Object[3];
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        tableModel.setNumRows(0);
        switch (tipoVista) {
            case "Todos":
                for (Alumno alu : this.alumnoDAO.obtenerTodosAlumnos()) {
                    Persona personaAlumno = this.personaDAO.obtenerPersonaPorId(alu.getPersona().getIdPersona());
                    fila[0] = personaAlumno.getApellido() + " " + personaAlumno.getNombre();
                    fila[1] = alu.getCurso() + "º " + alu.getDivision() + "º";
                    fila[2] = alu.getNetbook().getIdNetbook();
                    tableModel.addRow(fila);
                }
                break;
            case "Regulares":
                for (Alumno alu : this.alumnoDAO.obtenerAlumnosPorEstado("REGULAR")) {
                    Persona personaAlumno = this.personaDAO.obtenerPersonaPorId(alu.getPersona().getIdPersona());
                    fila[0] = personaAlumno.getApellido() + " " + personaAlumno.getNombre();
                    fila[1] = alu.getCurso() + "º " + alu.getDivision() + "º";
                    fila[2] = alu.getNetbook().getIdNetbook();
                    tableModel.addRow(fila);
                }
                break;
            case "Abandonan sin Equipo":
                for (Alumno alu : this.alumnoDAO.obtenerAlumnosPorEstado("ABANDONA SIN EQUIPO")) {
                    Persona personaAlumno = this.personaDAO.obtenerPersonaPorId(alu.getPersona().getIdPersona());
                    fila[0] = personaAlumno.getApellido() + " " + personaAlumno.getNombre();
                    fila[1] = alu.getCurso() + "º " + alu.getDivision() + "º";
                    fila[2] = alu.getNetbook().getIdNetbook();
                    tableModel.addRow(fila);
                }
                break;
            case "Abandonan con Equipo":
                for (Alumno alu : this.alumnoDAO.obtenerAlumnosPorEstado("ABANDONA CON EQUIPO")) {
                    Persona personaAlumno = this.personaDAO.obtenerPersonaPorId(alu.getPersona().getIdPersona());
                    fila[0] = personaAlumno.getApellido() + " " + personaAlumno.getNombre();
                    fila[1] = alu.getCurso() + "º " + alu.getDivision() + "º";
                    fila[2] = alu.getNetbook().getIdNetbook();
                    tableModel.addRow(fila);
                }
                break;
            case "Egresados a Recibir":
                for (Alumno alu : this.alumnoDAO.obtenerAlumnosPorEstado("EGRESADO A RECIBIR")) {
                    Persona personaAlumno = this.personaDAO.obtenerPersonaPorId(alu.getPersona().getIdPersona());
                    fila[0] = personaAlumno.getApellido() + " " + personaAlumno.getNombre();
                    fila[1] = alu.getCurso() + "º " + alu.getDivision() + "º";
                    fila[2] = alu.getNetbook().getIdNetbook();
                    tableModel.addRow(fila);
                }
                break;
            case "Egresados con Equipo":
                for (Alumno alu : this.alumnoDAO.obtenerAlumnosPorEstado("EGRESADO CON EQUIPO")) {
                    Persona personaAlumno = this.personaDAO.obtenerPersonaPorId(alu.getPersona().getIdPersona());
                    fila[0] = personaAlumno.getApellido() + " " + personaAlumno.getNombre();
                    fila[1] = alu.getCurso() + "º " + alu.getDivision() + "º";
                    fila[2] = alu.getNetbook().getIdNetbook();
                    tableModel.addRow(fila);
                }
                break;
            case "Egresados no corresponde Equipo":
                for (Alumno alu : this.alumnoDAO.obtenerAlumnosPorEstado("EGRESADO NO CORRESPONDE EQUIPO")) {
                    Persona personaAlumno = this.personaDAO.obtenerPersonaPorId(alu.getPersona().getIdPersona());
                    fila[0] = personaAlumno.getApellido() + " " + personaAlumno.getNombre();
                    fila[1] = alu.getCurso() + "º " + alu.getDivision() + "º";
                    fila[2] = alu.getNetbook().getIdNetbook();
                    tableModel.addRow(fila);
                }
                
                break;

        }
    }
/**
 * 
 * @param principal
 * @param tipoTransaccion 
 * Actualiza el JTable principal en caso de actualizar o modificar un registro
 */
    public void actualizarTblAlumno(FrmPrincipal principal, char tipoTransaccion) {
        FrmUser frmUsuario;
        boolean encontrado = false;
        for (int i = 0; i < principal.getJDesktopPane().getComponentCount() && encontrado != true; i++) {
            try {
                frmUsuario = (FrmUser) principal.getJDesktopPane().getComponent(i);
                encontrado = true;
                Object[] fila = new Object[3];
                fila[0] = personaAlumno.getApellido() + " " + personaAlumno.getNombre();
                fila[1] = alumno.getCurso() + "º " + alumno.getDivision() + "º";
                fila[2] = personaAlumno.getDni();
                DefaultTableModel tableModel = (DefaultTableModel) frmUsuario.getTblAlumno().getModel();
                if (tipoTransaccion == 'a') {

                    tableModel.addRow(fila);
                } else {
                    int posision = frmUsuario.getTblAlumno().getSelectedRow();
                    tableModel.setValueAt(fila[0], posision, 0);
                    tableModel.setValueAt(fila[1], posision, 1);
                    tableModel.setValueAt(fila[2], posision, 2);
                }
            } catch (Exception ex) {

            }

        }

    }

    /**
     * @return the netbook
     */
    public Netbook getNetbook() {
        return netbook;
    }

    /**
     * @param netbook the netbook to set
     */
    public void setNetbook(Netbook netbook) {
        this.netbook = netbook;
    }

    /**
     * @return the tutor
     */
    public Tutor getTutor() {
        return tutor;
    }

    /**
     * @param tutor the tutor to set
     */
    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

    /**
     * @return the alumno
     */
    public Alumno getAlumno() {
        return alumno;
    }

    /**
     * @param alumno the alumno to set
     */
    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    /**
     * @return the personaAlumno
     */
    public Persona getPersonaAlumno() {
        return personaAlumno;
    }

    /**
     * @param personaAlumno the personaAlumno to set
     */
    public void setPersonaAlumno(Persona personaAlumno) {
        this.personaAlumno = personaAlumno;
    }

    /**
     * @return the personaTutor
     */
    public Persona getPersonaTutor() {
        return personaTutor;
    }

    /**
     * @param personaTutor the personaTutor to set
     */
    public void setPersonaTutor(Persona personaTutor) {
        this.personaTutor = personaTutor;
    }

    /**
     * @return the alumnoDAO
     */
    public AlumnoDAO getAlumnoDAO() {
        return alumnoDAO;
    }

    /**
     * @return the personaDAO
     */
    public PersonaDAO getPersonaDAO() {
        return personaDAO;
    }

    /**
     * @return the tutorDAO
     */
    public TutorDAO getTutorDAO() {
        return tutorDAO;
    }

    /**
     * @return the netbookDAO
     */
    public NetbookDAO getNetbookDAO() {
        return netbookDAO;
    }

}
