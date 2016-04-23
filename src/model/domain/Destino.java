package model.domain;
// Generated 14/08/2014 10:07:55 by Hibernate Tools 3.6.0




/**
 * Destino generated by hbm2java
 */
public class Destino  implements java.io.Serializable {


     private short idDestino;
     private Persona persona;
     private Establecimiento establecimiento;
     private boolean  estado;

    public Destino() {
    }

    public Destino(short idDestino, Persona persona, Establecimiento establecimiento, boolean estado) {
       this.idDestino = idDestino;
       this.persona = persona;
       this.establecimiento = establecimiento;
       this.estado = estado;
    }
   
    public short getIdDestino() {
        return this.idDestino;
    }
    
    public void setIdDestino(short idDestino) {
        this.idDestino = idDestino;
    }
    public Persona getPersona() {
        return this.persona;
    }
    
    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    public Establecimiento getEstablecimiento() {
        return this.establecimiento;
    }
    
    public void setEstablecimiento(Establecimiento establecimiento) {
        this.establecimiento = establecimiento;
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


