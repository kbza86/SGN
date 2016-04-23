/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.data;

import hibernate.dao.ContratoDAO;
import hibernate.dao.PersonaDAO;
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.domain.Alumno;
import model.domain.ContratoAlumno;
import model.domain.ContratoProfesor;
import model.domain.Persona;
import model.domain.Profesor;
import view.pupil.FrmAlumnoPrincipal;

/**
 *
 * @author walter
 */
public class ControllerContract {

    /**
     *
     * @param idNetbook
     * @param pathContract
     */
    public static void AddContract(String idNetbook, String pathContract) {

        ControllerPupil controladorAlumno = new ControllerPupil();
        ControllerTeacher controladorPresesor = new ControllerTeacher();
        //GET STUDENT SELECTED BY SERIE NUMBER OF THE NETBOOK 
        String numberSerie = idNetbook;

        Alumno studentSelected = null;//
        PersonaDAO personaDAO = new PersonaDAO();
        Profesor teacherSelected = null;
        //NAME CONTRACT
        String contractName = "";

        File fileDestiny = null;

        try {
            studentSelected = controladorAlumno.buscarAlumnoPorNetbook(numberSerie);
            studentSelected.setPersona(personaDAO.obtenerPersonaPorId(studentSelected.getPersona().getIdPersona()));
            contractName = studentSelected.getPersona().getApellido().replace(" ", "") + studentSelected.getPersona().getNombre().replace(" ", "") + "_" + studentSelected.getPersona().getDni() + ".pdf";
            fileDestiny = new File(System.getProperty("user.dir") + "\\src\\model\\util\\contract\\students\\" + contractName.trim().toLowerCase());
        } catch (Exception ex) {
            teacherSelected = controladorPresesor.buscarProfesorNetbook(numberSerie);
            teacherSelected.setPersona(personaDAO.obtenerPersonaPorId(teacherSelected.getPersona().getIdPersona()));
            contractName = teacherSelected.getPersona().getApellido().replace(" ", "") + teacherSelected.getPersona().getNombre().replace(" ", "") + "_" + teacherSelected.getPersona().getDni() + ".pdf";
            fileDestiny = new File(System.getProperty("user.dir") + "\\src\\model\\util\\contract\\teacher\\" + contractName.trim().toLowerCase());
        }
        File fileOrigen = new File(pathContract);
        //CONTRACT FILE
        if (!fileDestiny.exists()) {
            try {
                fileDestiny.createNewFile();
            } catch (IOException ex) {
                System.out.printf(ex.toString());
            }
        }
        FileChannel origen = null;
        FileChannel destiny = null;
        try {
            origen = new FileInputStream(fileOrigen).getChannel();
            destiny = new FileOutputStream(fileDestiny).getChannel();
            long count = 0;
            long size = origen.size();

            //SAVE CONTRACT IN DB
            try {
                if (!ControllerContract.VerifyExistenceOfContractStudent(studentSelected)) {

                    ContratoDAO.altaContratoAlumno(new ContratoAlumno(ContratoDAO.obtenerUltimoIdAlumno(), fileDestiny.getAbsolutePath(), studentSelected));
                    //COPY CONTRACT FILE 
                    while ((count += destiny.transferFrom(origen, count, size - count)) < size);
                    JOptionPane.showMessageDialog(null, "CONTRATO AÑADIDO EXITOSAMENTE.");
                } else {
                    ControllerPeople peopleController = new ControllerPeople();
                    Persona person = peopleController.buscarPersonaPorId(studentSelected.getPersona().getIdPersona());

                    if (JOptionPane.showConfirmDialog(null, "EL ALUMNO:\n" + person.getNombre() + " " + person.getApellido() + " YA POSEE UN CONTRATO\n¿DESEA AGREGAR OTRO?", "CONTRATO EXISTENTE", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE) == JOptionPane.YES_OPTION) {
                        ContratoDAO.altaContratoAlumno(new ContratoAlumno(ContratoDAO.obtenerUltimoIdAlumno(), fileDestiny.getAbsolutePath().trim(), studentSelected));
                        //COPY CONTRACT FILE 
                        while ((count += destiny.transferFrom(origen, count, size - count)) < size);
                        JOptionPane.showMessageDialog(null, "CONTRATO AÑADIDO EXITOSAMENTE.");
                    }

                }
            } catch (Exception ex) {
                System.out.printf(ex.toString());
                if (!ControllerContract.VerifyExistenceOfContractTeacher(teacherSelected)) {

                    ContratoDAO.altaContratoProfesor(new ContratoProfesor(teacherSelected, ContratoDAO.obtenerUltimoIdProfesor(), fileDestiny.getAbsolutePath()));
                    //COPY CONTRACT FILE 
                    while ((count += destiny.transferFrom(origen, count, size - count)) < size);
                    JOptionPane.showMessageDialog(null, "CONTRATO AÑADIDO EXITOSAMENTE.");
                } else {
                    ControllerPeople peopleController = new ControllerPeople();
                    Persona person = peopleController.buscarPersonaPorId(studentSelected.getPersona().getIdPersona());

                    if (JOptionPane.showConfirmDialog(null, "EL PROFESOR:\n" + person.getNombre() + " " + person.getApellido() + " YA POSEE UN CONTRATO\n¿DESEA AGREGAR OTRO?", "CONTRATO EXISTENTE", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE) == JOptionPane.YES_OPTION) {
                        ContratoDAO.altaContratoProfesor(new ContratoProfesor(teacherSelected, ContratoDAO.obtenerUltimoIdProfesor(), fileDestiny.getAbsolutePath()));
                        //COPY CONTRACT FILE 
                        while ((count += destiny.transferFrom(origen, count, size - count)) < size);
                        JOptionPane.showMessageDialog(null, "CONTRATO AÑADIDO EXITOSAMENTE.");
                    }

                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FrmAlumnoPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FrmAlumnoPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (origen != null) {
                try {
                    origen.close();
                } catch (IOException ex) {
                    Logger.getLogger(FrmAlumnoPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (destiny != null) {
                try {
                    destiny.close();
                } catch (IOException ex) {
                    Logger.getLogger(FrmAlumnoPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

    }

    /**
     *
     * @param student
     * @return
     */
    public static boolean VerifyExistenceOfContractStudent(Alumno student) {
        return ContratoDAO.VerifyContractExistingByStudent(student);
    }

    /**
     *
     * @param teacher
     * @return
     */
    public static boolean VerifyExistenceOfContractTeacher(Profesor teacher) {
        return ContratoDAO.VerifyContractExistingByTeacher(teacher);
    }

    /**
     *
     * @param contractType
     * @param student
     * @param teacher
     * @throws java.io.IOException
     */
    public static void ViewContract(String contractType, Alumno student, Profesor teacher) throws IOException {
        int amountContract = 0;
        switch (contractType) {
            case "students":
                amountContract = ContratoDAO.getCantidaContratoAlumno(student);
                if (amountContract == 0) {
                    JOptionPane.showMessageDialog(null, "EL ALUMNO NO POSEE CARGADO CONTRATO/S");
                } else {
                    if (amountContract == 1) {
                        ContratoAlumno contratoAlumno = ContratoDAO.obtenerContratoAlumno(student);
                        View(contratoAlumno.getPath());
                    } else {
                        //CODE NEEDING FOR VIEW MORE CONTRACTS
                    }
                }

                break;
            case "teacher":
                amountContract = ContratoDAO.getCantidaContratoProfesor(teacher);
                if (amountContract == 0) {
                    JOptionPane.showMessageDialog(null, "EL DOCENTE NO POSEE CARGADO CONTRATO/S");
                } else {
                    if (amountContract == 1) {
                        ContratoProfesor contratoProfesor = ContratoDAO.obtenerContratoProfesor(teacher);
                        View(contratoProfesor.getPath());
                    } else {
                        //CODE NEEDING FOR VIEW MORE CONTRACTS
                    }
                }
                break;
        }
    }

    public static void View(String path) throws IOException {
        String pdfFile = path;
        File file = new File(pdfFile);
        if (pdfFile.endsWith(".pdf")) {
            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + pdfFile);
        } else {
            //For cross platform use
            Desktop desktop = Desktop.getDesktop();
            desktop.open(file);
        }
    }
}
