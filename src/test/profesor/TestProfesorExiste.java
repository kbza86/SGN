/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test.profesor;

import hibernate.dao.ProfesorDAO;

/**
 *
 * @author tisan
 */
public class TestProfesorExiste {
    public static void main(String[] args) {
        ProfesorDAO profesorDAO = new ProfesorDAO();
        if(profesorDAO.verificarExistenciaProfesor(profesorDAO.obtenerProfesorPorDni(14123456).getPersona())){
            System.out.println("Existe");
        }else{
            System.out.println("No existe");
        }
    }
   
}
