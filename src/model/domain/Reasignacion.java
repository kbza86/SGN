/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.domain;

/**
 *
 * @author wally86
 */
public class Reasignacion {
    
   private short idReasignacion;
   private Persona persona;
   private Netbook netbook;
   private boolean estado;

    public Reasignacion() {
    }

    public Reasignacion(short idReasignacion, Persona persona, Netbook netbook, boolean estado) {
        this.idReasignacion = idReasignacion;
        this.persona = persona;
        this.netbook = netbook;
        this.estado=estado;
    }

    /**
     * @return the idReasignacion
     */
    public short getIdReasignacion() {
        return idReasignacion;
    }

    /**
     * @param idReasignacion the idReasignacion to set
     */
    public void setIdReasignacion(short idReasignacion) {
        this.idReasignacion = idReasignacion;
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
     * @return the estado
     */
    public boolean isEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
   
   
   
   
}
