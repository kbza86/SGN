/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller.data;

import hibernate.dao.PersonaDAO;
import model.domain.Persona;

/**
 *
 * @author wally86
 */
public class ControllerPeople {
    private Persona persona;
    private PersonaDAO personaDAO;

    public ControllerPeople() {
    this.persona= new Persona();
    this.personaDAO=new PersonaDAO();
    }
    /**
     * 
     * @param persona 
     */
    public void guardarPersona(Persona persona){
        getPersonaDAO().altaPersona(persona);
    }
    /**
     * 
     * @param persona 
     */
    public void modificarDatosPersona(Persona persona){
        getPersonaDAO().modificarPersona(persona);
    }
    /**
     * 
     * @param id
     * @return 
     */
    public Persona buscarPersonaPorId(int id){
        return getPersonaDAO().obtenerPersonaPorId(id);
    }
    /**
     * 
     * @param dni
     * @return 
     */
    public Persona buscarPersonaPorDni(int dni){
        return getPersonaDAO().obtenerPersonaPorDni(dni);
    }
    /**
     * 
     * @param dni
     * @return 
     */
    public boolean verificarExistenciaDePersona(int dni){
        return getPersonaDAO().verificarExistencia(dni);
    }
    /**
     * 
     * @return 
     */
    public int obtenerIdParaGuardar(){
        return getPersonaDAO().obtenerUltimoId();
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

    /**
     * @return the personaDAO
     */
    public PersonaDAO getPersonaDAO() {
        return personaDAO;
    }

    /**
     * @param personaDAO the personaDAO to set
     */
    public void setPersonaDAO(PersonaDAO personaDAO) {
        this.personaDAO = personaDAO;
    }
    
}
