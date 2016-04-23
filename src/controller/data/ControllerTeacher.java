/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.data;

import hibernate.dao.PersonaDAO;
import hibernate.dao.ProfesorDAO;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.domain.Netbook;
import model.domain.Persona;
import model.domain.Profesor;
import view.teacher.FrmProfesorCRUD;

/**
 *
 * @author tisan
 */
public class ControllerTeacher {

    private ProfesorDAO profesorDAO;
    private Netbook netbook;
    private Persona personaProfesor;
    private Profesor profesor;

    public ControllerTeacher() {
        profesorDAO = new ProfesorDAO();
        netbook = new Netbook();
        personaProfesor = new Persona();
        profesor = new Profesor();
    }

    public void altaProfesor(FrmProfesorCRUD frmProfesorCRUD) {
        boolean estado = true;
        String nombre = frmProfesorCRUD.getTxtNombreTitular().getText().toUpperCase();
        String apellido = frmProfesorCRUD.getTxtApellidoTitular().getText().toUpperCase();
        int dni = Integer.parseInt(frmProfesorCRUD.getTxtDniTitular().getText());
        PersonaDAO personaDAO = new PersonaDAO();
        if (!personaDAO.verificarExistencia(dni)) {
            Netbook netbook = frmProfesorCRUD.getFrmPrincipal().getControladorFrmPrincipal().getFrmUsuario(frmProfesorCRUD.getFrmPrincipal()).getControladorAlumno().getNetbook();
            if (!netbook.isEstado()) {
                Persona persona = new Persona(personaDAO.obtenerUltimoId(), nombre, apellido, dni, estado);

                personaDAO.altaPersona(persona);
                frmProfesorCRUD.getFrmPrincipal().getControladorFrmPrincipal().getFrmUsuario(frmProfesorCRUD.getFrmPrincipal()).getControladorAlumno().setPersonaAlumno(persona);
                Profesor profesor = new Profesor(profesorDAO.obtenerUltimoId(), netbook, persona, estado);
                profesorDAO.altaProfesor(profesor);
                netbook.setEstado(true);
                frmProfesorCRUD.getFrmPrincipal().getControladorFrmPrincipal().getFrmUsuario(frmProfesorCRUD.getFrmPrincipal()).getControladorNetbook().actualizarDatosNetbook(netbook);
                frmProfesorCRUD.getFrmPrincipal().getControladorFrmPrincipal().getFrmUsuario(frmProfesorCRUD.getFrmPrincipal()).getControladorFormularioUsuario().actualizarCantidadNetbookOsciosas(frmProfesorCRUD.getFrmPrincipal().getControladorFrmPrincipal().getFrmUsuario(frmProfesorCRUD.getFrmPrincipal()));
                actualizarTblTitular(frmProfesorCRUD.getFrmPrincipal().getControladorFrmPrincipal().getFrmUsuario(frmProfesorCRUD.getFrmPrincipal()).getTblAlumno(), 'a', persona);
            } else {
                JOptionPane.showMessageDialog(frmProfesorCRUD, "Debe reasignar la netbook");
            }
        } else {
            JOptionPane.showMessageDialog(frmProfesorCRUD, "La persona ya existe en la Base de Datos");
        }
    }

    public boolean verificarExistencia(JTextField txtDni) {
        int dni = Integer.parseInt(txtDni.getText());
        boolean existeProfesor = false;
        try {
            existeProfesor = profesorDAO.verificarExistenciaProfesor(profesorDAO.obtenerProfesorPorDni(dni).getPersona());
        } catch (NullPointerException ex) {

        }
        return existeProfesor;
    }

    public Profesor buscarProfesorNetbook(String numeroSerie) {
        return profesorDAO.buscarProfesorNetbook(numeroSerie);
    }

    public JTable cargarGrillaProfesor(JTable tableProfesor, String estado) {
        tableProfesor.removeAll();
        DefaultTableModel tableModel = (DefaultTableModel) tableProfesor.getModel();
        tableModel.setNumRows(0);
        Object[] fila = new Object[3];
        Persona persona = new Persona();
        PersonaDAO personaDAO = new PersonaDAO();
        switch (estado) {
            case "Todos":
                for (Profesor profesor : profesorDAO.obtenerProfesores()) {
                    persona = personaDAO.obtenerPersonaPorId(profesor.getPersona().getIdPersona());
                    fila[0] = profesor.getNetbook().getIdNetbook();
                    fila[1] = persona.getApellido() + " " + persona.getNombre();
                    fila[2] = persona.getDni();
                    tableModel.addRow(fila);
                }
                break;
        }
        return tableProfesor;
    }

    public Profesor buscarProfesorPorDni(int dni) {
        return (profesorDAO.obtenerProfesorPorDni(dni));
    }

    public JTable cargarGrillaTitularNetbook(JTable tableTitular) {
        DefaultTableModel tableModel = (DefaultTableModel) tableTitular.getModel();
        if (tableModel.getRowCount() == 0) {
            tableModel.setRowCount(0);
        }
        Object[] fila = new Object[3];
        Persona persona = new Persona();
        PersonaDAO personaDAO = new PersonaDAO();

        for (Profesor profesor : profesorDAO.obtenerProfesores()) {
            persona = personaDAO.obtenerPersonaPorId(profesor.getPersona().getIdPersona());
            fila[0] = persona.getApellido() + " " + persona.getNombre();
            fila[1] = "DOCENTE";
            fila[2] = persona.getDni();
            tableModel.addRow(fila);
        }

        return tableTitular;
    }

    public void actualizarTblTitular(JTable table, char tipoOperacion, Persona profesor) {
        Object[] fila = new Object[3];
        fila[0] = profesor.getApellido() + " " + profesor.getNombre();
        fila[1] = "DOCENTE";
        fila[2] = profesor.getDni();
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        if (tipoOperacion == 'a') {
            tableModel.addRow(fila);
        } else {
            int posision = table.getSelectedRow();
            tableModel.setValueAt(fila[0], posision, 0);
            tableModel.setValueAt(fila[1], posision, 1);
            tableModel.setValueAt(fila[2], posision, 2);
        }

    }

    public void actualizaTblProfesores(FrmProfesorCRUD frmProfesorCRUD, char tipoOperacion) {
        Object[] fila = new Object[3];
        fila[0] = frmProfesorCRUD.getFrmPrincipal().getControladorFrmPrincipal().getFrmUsuario(frmProfesorCRUD.getFrmPrincipal()).getControladorAlumno().getNetbook().getIdNetbook();
        fila[1] = frmProfesorCRUD.getFrmPrincipal().getControladorFrmPrincipal().getFrmUsuario(frmProfesorCRUD.getFrmPrincipal()).getControladorAlumno().getPersonaAlumno().getApellido() + " " + frmProfesorCRUD.getFrmPrincipal().getControladorFrmPrincipal().getFrmUsuario(frmProfesorCRUD.getFrmPrincipal()).getControladorAlumno().getPersonaAlumno().getNombre();
        fila[2] = frmProfesorCRUD.getFrmPrincipal().getControladorFrmPrincipal().getFrmUsuario(frmProfesorCRUD.getFrmPrincipal()).getControladorAlumno().getPersonaAlumno().getDni();
        DefaultTableModel tableModel = (DefaultTableModel) frmProfesorCRUD.getFrmPrincipal().getControladorFrmPrincipal().getFrmProfesorPrincipal(frmProfesorCRUD.getFrmPrincipal()).getTblProfesores().getModel();
        if (tipoOperacion == 'a') {

            tableModel.addRow(fila);

        } else {

            int posision = frmProfesorCRUD.getFrmPrincipal().getControladorFrmPrincipal().getFrmProfesorPrincipal(frmProfesorCRUD.getFrmPrincipal()).getTblProfesores().getSelectedRow();
            tableModel.setValueAt(fila[0], posision, 0);
            tableModel.setValueAt(fila[1], posision, 1);
            tableModel.setValueAt(fila[2], posision, 2);
        }
    }

    public void modificarProfesor(FrmProfesorCRUD frmProfesorCRUD) {
       Profesor profesor = frmProfesorCRUD.getFrmPrincipal().getControladorFrmPrincipal().getFrmUsuario(frmProfesorCRUD.getFrmPrincipal()).getControladorProfesor().getProfesor();
       Persona personaProfesor = frmProfesorCRUD.getFrmPrincipal().getControladorFrmPrincipal().getFrmUsuario(frmProfesorCRUD.getFrmPrincipal()).getControladorProfesor().getPersonaProfesor();
       personaProfesor.setApellido(frmProfesorCRUD.getTxtApellidoTitular().getText().toUpperCase());
       personaProfesor.setNombre(frmProfesorCRUD.getTxtNombreTitular().getText().toUpperCase());
       try{
       personaProfesor.setDni(Integer.parseInt(frmProfesorCRUD.getTxtDniTitular().getText()));
       profesor.setPersona(personaProfesor);
       }catch(NumberFormatException ex){
           JOptionPane.showMessageDialog(frmProfesorCRUD, "Error al Parsear DNI "+ex);
       }
       profesorDAO.modificarProfesor(profesor);
       actualizarTblTitular(frmProfesorCRUD.getFrmPrincipal().getControladorFrmPrincipal().getFrmUsuario(frmProfesorCRUD.getFrmPrincipal()).getTblAlumno(), 'm', personaProfesor);
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
     * @return the personaProfesor
     */
    public Persona getPersonaProfesor() {
        return personaProfesor;
    }

    /**
     * @param personaProfesor the personaProfesor to set
     */
    public void setPersonaProfesor(Persona personaProfesor) {
        this.personaProfesor = personaProfesor;
    }

    /**
     * @return the profesor
     */
    public Profesor getProfesor() {
        return profesor;
    }

    /**
     * @param profesor the profesor to set
     */
    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

}
