/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller.data;
import hibernate.dao.PersonaDAO;
import hibernate.dao.TutorDAO;
import javax.swing.JTextField;
import model.domain.Persona;
import model.domain.Tutor;
import vista.tutor.FrmTutorCRUD;
/**
 *
 * @author wally86
 */
public class ControladorTutor {
    private TutorDAO tutorDAO; 
    private PersonaDAO personaDAO; 
    private Persona persona;

    public ControladorTutor() {
        tutorDAO =  new TutorDAO();
        personaDAO = new PersonaDAO();
        persona = new Persona();
    }
    
    
     public void agregarTutor(FrmTutorCRUD frmTutorAlta){
         String nombre = frmTutorAlta.getTxtNombre().getText().toUpperCase();
         String apellido = frmTutorAlta.getTxtApellido().getText().toUpperCase();
         int dni =0;
         try{
         dni = Integer.parseInt(frmTutorAlta.getTxtDni().getText());
         }catch(NumberFormatException ex){
             
         }
         Persona personaNueva = new Persona(personaDAO
                .obtenerUltimoId()
                ,nombre 
                ,apellido
                ,dni
                ,true);
         personaDAO.altaPersona(personaNueva);
        Tutor tutorNuevo = new Tutor(tutorDAO.obtenerUltimoId(), personaNueva);
        tutorDAO.altaTutor(tutorNuevo);
    }
     
    public boolean verificarExistencia(JTextField txtDni){
        int dni = 0;
        try{
        dni = (Integer.parseInt(txtDni.getText()));
        }catch(NumberFormatException ex){
            
        }
        return tutorDAO.verificarExistencia(dni);
    }
    public Tutor buscarTutorPorId(short id){
        return tutorDAO.obtenerTutorPorId(id);
    }
    public Persona obtenerDatosTutor(int dni){
        return personaDAO.obtenerPersonaPorDni(dni);
    }

    /**
     * @return the persona
     */
    public Persona getPersona() {
        return persona;
    }

    /**
     * @param persona the persona to set
     */
    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
}
