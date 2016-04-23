/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test.compararPersonaDni;


import hibernate.dao.AlumnoDAO;
import java.util.Collections;
import java.util.List;
import model.domain.Alumno;
import model.domain.Persona;
import modelo.util.ItemComparable;
import modelo.util.Sort;

/**
 *
 * @author tisan
 */
public class TestCompararPersonaDni {
    public static void main(String[] args) {
       AlumnoDAO alumnoDAO = new AlumnoDAO();
       List<Alumno> lista = alumnoDAO.obtenerTodosAlumnos();
        System.out.println("Lista sin ordenar");
        for(Alumno alu : lista){
            System.out.println(alu.toString());
        }
       Collections.sort(lista);
        System.out.println("Lista ordenada");
        for(Alumno alu : lista){
            System.out.println(alu.toString());
        }
        
    }
   
}
