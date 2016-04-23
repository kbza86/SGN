package model.domain;
// Generated 14/08/2014 10:07:55 by Hibernate Tools 3.6.0





/**
 * Profesor generated by hbm2java
 */
public class Profesor  implements java.io.Serializable {


     private int idProfesor;
     private Netbook netbook;
     private Persona persona;
     private boolean estado;

    public Profesor() {
    }

    public Profesor(int idProfesor, Netbook netbook, Persona persona, boolean estado) {
       this.idProfesor = idProfesor;
       this.netbook = netbook;
       this.persona = persona;
       this.estado = estado;
    }
   
    public int getIdProfesor() {
        return this.idProfesor;
    }
    
    public void setIdProfesor(int idProfesor) {
        this.idProfesor = idProfesor;
    }
    public Netbook getNetbook() {
        return this.netbook;
    }
    
    public void setNetbook(Netbook netbook) {
        this.netbook = netbook;
    }
    public Persona getPersona() {
        return this.persona;
    }
    
    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    public boolean isEstado() {
        return this.estado;
    }
    
    public void setEstado(boolean estado) {
        this.estado = estado;
    }




}


