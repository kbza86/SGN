/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test.profesor;

import hibernate.dao.NetbookDAO;
import hibernate.dao.PersonaDAO;
import hibernate.dao.ProfesorDAO;
import model.domain.Netbook;
import model.domain.Persona;
import model.domain.Profesor;

/**
 *
 * @author tisan
 */
public class TestProfesorAlta {
    public static void main(String[] args) {
        ProfesorDAO profesorDAO = new ProfesorDAO();
        NetbookDAO netbookDAO = new NetbookDAO();
        Netbook netbook = netbookDAO.obtenerNetbook("1234567890");
        PersonaDAO personaDAO = new PersonaDAO();
        Persona persona = new Persona(personaDAO.obtenerUltimoId(), "jose", "alvarez", 14123456, true);
        personaDAO.altaPersona(persona);
        Profesor profesor = new Profesor(profesorDAO.obtenerUltimoId()
                , netbook
                ,persona
                , true);
        profesorDAO.altaProfesor(profesor);
    }
    
}
