/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller.data;

import hibernate.dao.DestinoDAO;
import model.domain.Destino;
import model.domain.Establecimiento;
import model.domain.Persona;
import vista.migrar.FrmMigrarCRUD;

/**
 *
 * @author wally86
 * controlador de migracion
 */
public class ControladorDestino {
    private DestinoDAO destinoDAO;

    public ControladorDestino() {
     destinoDAO=new DestinoDAO();
    }
    /**
     * 
     * @param frmMigrarPrincipal
     * alta a una migracion
     */
    public void altaMigracion(FrmMigrarCRUD frmMigrarPrincipal){
        Persona persona = frmMigrarPrincipal.getFrmUsuario().getControladorAlumno().getPersonaAlumno();
        Establecimiento establecimiento = frmMigrarPrincipal.getControladorEstablecimiento().obtenerEstablecimientoPorNombre(String.valueOf(frmMigrarPrincipal.getCmbBoxEstablecimiento().getSelectedItem()));
        Destino destinoNuevo = new Destino(
                destinoDAO.obtenerUltimoId()
                ,persona
                ,establecimiento
                ,Boolean.FALSE);
    
        destinoDAO.altaDestino(destinoNuevo);
    }
    /**
     * 
     * @return id del ultimo lugar para guardar
     */
    public int obtenerId(){
        return destinoDAO.obtenerUltimoId();
    }
    /**
     * 
     * @return cantidad de migraciones pendientes 
     * 
     */
    public int contarMigracionesPendientes(){
        return destinoDAO.obtenerTotalMigracionesPendientes();
    }
    /**
     * 
     * @param frmMigrarPrincipal
     * verifica la existencia de una migracion
     * @return 
     */
    public boolean verificarExistencia(FrmMigrarCRUD frmMigrarPrincipal){
        Persona personaAlumno = frmMigrarPrincipal.getFrmUsuario().getControladorAlumno().getPersonaAlumno();
        return destinoDAO.verificarExistencia(personaAlumno);
    }
    /**
     * 
     * @param persona
     * @return migracion
     * Devuelve una migracion segun la persona
     */
    public Destino obtenerDestinoSegunPersona(Persona persona){
        return destinoDAO.obtenerDestinoPorPersona(persona);
    }
    /**
     * 
     * @param destino 
     * modifica una migracion existente
     */
    public void modificarMigracion(Destino destino){
        destinoDAO.modificarDestino(destino);
    }
}
