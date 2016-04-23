/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.domain;



/**
 *
 * @author walter
 */
public class ContratoAlumno{
   
    private  int idContrato;
    private String path;
    private Alumno alumno;

    public ContratoAlumno(int idContrato, String path, Alumno alumno) {
        this.idContrato = idContrato;
        this.path = path;
        this.alumno = alumno;
    }

    public ContratoAlumno() {
    }

    /**
     * @return the idContrato
     */
    public int getIdContrato() {
        return idContrato;
    }

    /**
     * @param idContrato the idContrato to set
     */
    public void setIdContrato(int idContrato) {
        this.idContrato = idContrato;
    }

    /**
     * @return the path
     */
    public String getPath() {
        return path;
    }

    /**
     * @param path the path to set
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * @return the alumno
     */
    public Alumno getAlumno() {
        return alumno;
    }

    /**
     * @param alumno the alumno to set
     */
    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }



    

    

 
}
