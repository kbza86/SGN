/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import model.constant.Usuario;
import model.domain.Alumno;
import model.domain.Netbook;
import model.domain.Persona;
import model.domain.Profesor;
import vista.login.FrmLogin;
import view.user.FrmUser;

/**
 *
 * @author wally86
 */
public class ControllerUser {

    public boolean validarUsuario(FrmLogin frmLogin) {
        String nombreUsuaio = frmLogin.getJTextFieldUsuario().getText();
        String passwordUsuario = String.valueOf(frmLogin.getJPasswordFieldUsuario().getPassword());
        boolean esValido = false;
        if (nombreUsuaio.equals(Usuario.NOMBRE) && passwordUsuario.equals(Usuario.PASSWORD)) {
            esValido = true;
        }
        return esValido;
    }

    public void buscarTitularNetbook(FrmUser frmUsuario) {
        //validar que se seleccione radio botton 
        //validar que se ingrese un texto en txt
        if (frmUsuario.getControladorFormularioUsuario().validarBuscar(frmUsuario.getRbtnDniAlumno(), frmUsuario.getTxtBusqueda())) {
            //verifica que se selecciono metodo de busqueda por usuario
            if (frmUsuario.getRbtnDniAlumno().isSelected()) {
                buscarEnGrillaTitular(frmUsuario);

            } else {
                //Se selecciono metodo de budqueda por netbook
                //verifica que se selecciono netbook esta osciosa
                ControllerNetbook controllerNetbook = new ControllerNetbook();
                boolean status = controllerNetbook.verificarEstadoNetbook(frmUsuario.getTxtBusqueda());
                
                    buscarEnGrillaNetbook(frmUsuario,status);
                
            }
        } else {
            JOptionPane.showMessageDialog(frmUsuario, "Verifique los campos de busqueda");

        }
    }
    
    private void buscarEnGrillaNetbook(FrmUser frmUsuario,boolean status) {
        boolean titularEncontrado = false;
        boolean netbookEncontrada = false;
        String numeroSerie = frmUsuario.getTxtBusqueda().getText();
        Persona personaTitular = null;
        JTable tblTitular = frmUsuario.getTblAlumno();
        JTable tblNetbook = frmUsuario.getTblNetbook();
        Alumno alumno = null;
        Profesor profesor = null;
        
        //Busqueda por numero Id Netbook
        for (int j = 0; j < tblNetbook.getRowCount() && netbookEncontrada != true; j++) {
            if (String.valueOf(tblNetbook.getValueAt(j, 0)).equals(numeroSerie)) {
                Object[] netbookUbicada = new Object[4];

                netbookUbicada[0] = tblNetbook.getValueAt(j, 0);
                netbookUbicada[1] = tblNetbook.getValueAt(j, 1);
                netbookUbicada[2] = tblNetbook.getValueAt(j, 2);
                netbookUbicada[3] = tblNetbook.getValueAt(j, 3);

                DefaultTableModel tableModelNetbook = (DefaultTableModel) tblNetbook.getModel();
                tableModelNetbook.insertRow(0, netbookUbicada);
                tableModelNetbook.removeRow(j + 1);

                tblNetbook.getSelectionModel().setSelectionInterval(0, 0);
                if(status){
                try {
                    profesor = (Profesor) frmUsuario.getControladorProfesor().buscarProfesorNetbook(numeroSerie);
                    personaTitular = frmUsuario.getControladorPersona().buscarPersonaPorId(profesor.getPersona().getIdPersona());
                    frmUsuario.getControladorProfesor().setProfesor(profesor);
                    frmUsuario.getControladorProfesor().setPersonaProfesor(personaTitular);
                    frmUsuario.getControladorProfesor().setNetbook(frmUsuario.getControladorNetbook().buscarNetbookSerie(numeroSerie));
                } catch (Exception e) {
                    alumno = (Alumno) frmUsuario.getControladorAlumno().buscarAlumnoPorNetbook(numeroSerie);
                    personaTitular = frmUsuario.getControladorPersona().buscarPersonaPorId(alumno.getPersona().getIdPersona());
                    frmUsuario.getControladorAlumno().setAlumno(alumno);
                    frmUsuario.getControladorAlumno().setPersonaAlumno(personaTitular);
                    frmUsuario.getControladorAlumno().setNetbook(frmUsuario.getControladorNetbook().buscarNetbookSerie(numeroSerie));
                    frmUsuario.getControladorAlumno().setTutor(frmUsuario.getControladorTutor().buscarTutorPorId(alumno.getTutor().getIdTutor()));
                    frmUsuario.getControladorAlumno().setPersonaTutor(frmUsuario.getControladorPersona().buscarPersonaPorId(frmUsuario.getControladorAlumno().getTutor().getPersona().getIdPersona()));
                }
                for (int i = 0; i < tblTitular.getRowCount() && titularEncontrado != true; i++) {
                    if (String.valueOf(tblTitular.getValueAt(i, 2)).equals(String.valueOf(personaTitular.getDni()))) {
                        DefaultTableModel tableModelAlumno = (DefaultTableModel) tblTitular.getModel();

                        Object[] filaEncontrada = new Object[3];
                        filaEncontrada[0] = tblTitular.getValueAt(i, 0);
                        filaEncontrada[1] = tblTitular.getValueAt(i, 1);
                        filaEncontrada[2] = tblTitular.getValueAt(i, 2);

                        tableModelAlumno.insertRow(0, filaEncontrada);
                        tableModelAlumno.removeRow(i + 1);

                        tblTitular.getSelectionModel().setSelectionInterval(0, 0);

                        titularEncontrado = true;
                    }
                }
                netbookEncontrada = true;
                }
            }
        }
        if (!netbookEncontrada) {
            JOptionPane.showMessageDialog(null, "Netbook no encontrada");
        }
    }

    private void buscarEnGrillaTitular(FrmUser frmUsuario) {
        boolean titularEncontrado = false;
        boolean netbookEncontrada = false;
        String dniTitular = frmUsuario.getTxtBusqueda().getText();
        JTable tblTitular = frmUsuario.getTblAlumno();
        JTable tblNetbook = frmUsuario.getTblNetbook();
        Alumno alumno = null;
        Netbook netbook = null;
        Profesor profesor = null;
        for (int i = 0; i < tblTitular.getRowCount() && titularEncontrado != true; i++) {
            if (String.valueOf(tblTitular.getValueAt(i, 2)).equals(dniTitular)) {
                DefaultTableModel tableModelAlumno = (DefaultTableModel) tblTitular.getModel();

                Object[] filaEncontrada = new Object[3];
                filaEncontrada[0] = tblTitular.getValueAt(i, 0);
                filaEncontrada[1] = tblTitular.getValueAt(i, 1);
                filaEncontrada[2] = tblTitular.getValueAt(i, 2);

                tableModelAlumno.insertRow(0, filaEncontrada);
                tableModelAlumno.removeRow(i + 1);

                tblTitular.getSelectionModel().setSelectionInterval(0, 0);

                try {
                    profesor = (Profesor) frmUsuario.getControladorProfesor().buscarProfesorPorDni(Integer.parseInt(dniTitular));
                    netbook = frmUsuario.getControladorNetbook().buscarNetbookSerie(profesor.getNetbook().getIdNetbook());
                    frmUsuario.getControladorProfesor().setProfesor(profesor);
                    frmUsuario.getControladorProfesor().setPersonaProfesor(frmUsuario.getControladorPersona().buscarPersonaPorId(profesor.getPersona().getIdPersona()));
                    frmUsuario.getControladorProfesor().setNetbook(netbook);
                } catch (Exception e) {
                    alumno = (Alumno) frmUsuario.getControladorAlumno().buscarAlumnoPorDni(Integer.parseInt(dniTitular));
                    netbook = frmUsuario.getControladorNetbook().buscarNetbookSerie(alumno.getNetbook().getIdNetbook());
                     frmUsuario.getControladorAlumno().setAlumno(alumno);
                    frmUsuario.getControladorAlumno().setPersonaAlumno(frmUsuario.getControladorPersona().buscarPersonaPorId(alumno.getPersona().getIdPersona()));
                    frmUsuario.getControladorAlumno().setNetbook(netbook);
                    frmUsuario.getControladorAlumno().setTutor(alumno.getTutor());
                    frmUsuario.getControladorAlumno().setPersonaTutor(frmUsuario.getControladorTutor().obtenerDatosTutor(alumno.getTutor().getIdTutor()));
                }
                for (int j = 0; j < tblNetbook.getRowCount() && netbookEncontrada != true; j++) {
                    if (String.valueOf(tblNetbook.getValueAt(j, 0)).equals(netbook.getIdNetbook())) {
                        Object[] netbookUbicada = new Object[4];

                        netbookUbicada[0] = tblNetbook.getValueAt(j, 0);
                        netbookUbicada[1] = tblNetbook.getValueAt(j, 1);
                        netbookUbicada[2] = tblNetbook.getValueAt(j, 2);
                        netbookUbicada[3] = tblNetbook.getValueAt(j, 3);

                        DefaultTableModel tableModelNetbook = (DefaultTableModel) tblNetbook.getModel();
                        tableModelNetbook.insertRow(0, netbookUbicada);
                        tableModelNetbook.removeRow(j + 1);

                        tblNetbook.getSelectionModel().setSelectionInterval(0, 0);

                        netbookEncontrada = true;
                    }
                }
                titularEncontrado = true;
            }
        }
        if (!titularEncontrado) {
            JOptionPane.showMessageDialog(null, "No se encontró al titular");
        }
    }
    public void ordenarGrillaTitular(JTable table){
        DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
        TableRowSorter<DefaultTableModel> tableRowSorter = new TableRowSorter<>(tableModel);
        table.setRowSorter(tableRowSorter);
    }
            
}
