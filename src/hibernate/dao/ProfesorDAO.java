/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hibernate.dao;

import java.util.List;
import model.domain.Netbook;
import model.domain.Persona;
import model.domain.Profesor;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author wally86
 */
public class ProfesorDAO {
    private PersonaDAO personaDAO;  
    private NetbookDAO netbookDAO;

    public ProfesorDAO() {
        this.personaDAO=new PersonaDAO();
        this.netbookDAO= new NetbookDAO();
    }
public void altaProfesor(Profesor profesor){
    Session session = hibernate.configuration.HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    session.save(profesor);
    session.getTransaction().commit();
    session.close();
}
public void modificarProfesor(Profesor profesor){
    Session session = hibernate.configuration.HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    session.update(profesor);
    session.getTransaction().commit();
    session.close();
}
public List<Profesor> obtenerProfesores(){
    Session session = hibernate.configuration.HibernateUtil.getSessionFactory().openSession();
    Criteria criteria = session.createCriteria(Profesor.class);
    criteria.addOrder(Order.asc("idProfesor"));
    List<Profesor> lista = criteria.list();
    session.close();
    return lista;
    
}
public Profesor obtenerProfesorPorDni(int dni){
    Persona persona = this.personaDAO.obtenerPersonaPorDni(dni);
    Session session = hibernate.configuration.HibernateUtil.getSessionFactory().openSession();
    Criteria criteria = session.createCriteria(Profesor.class);
    criteria.add(Restrictions.like("persona", persona));
    Profesor encontrado;
    try{
        encontrado = (Profesor)criteria.list().get(0);
    }catch(Exception ex){
        session.close();
        return null;
    }
    session.close();
    return encontrado;
}
 public Profesor buscarProfesorNetbook(String numeroSerie){
        Netbook netbook = netbookDAO.obtenerNetbook(numeroSerie);
        Session session = hibernate.configuration.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Profesor.class);
        criteria.add(Restrictions.like("netbook",netbook ));
        Profesor profesor;
        try{
        profesor = (Profesor)criteria.list().get(0);
        }catch(IndexOutOfBoundsException ex){
            session.close();
            return null;
        }
        session.close();
        return profesor;
    }
 public int obtenerUltimoId(){
        int numeroTotalFilas = 0;
        int id =1;
        Profesor profesor = new Profesor();
        Session session = hibernate.configuration.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Profesor.class);
        criteria.addOrder(Order.asc("idProfesor"));     
        try{
            numeroTotalFilas=criteria.list().size();
            profesor = (Profesor)criteria.list().get(--numeroTotalFilas);
            id = profesor.getIdProfesor();
            id++;
        }catch(Exception ex){
            return 1;
        }
        session.close();
        return id;
    }
  public boolean verificarExistenciaProfesor(Persona persona){
        boolean existe= false;
        Session session = hibernate.configuration.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Profesor.class);
        criteria.add(Restrictions.like("persona",persona));
        if(!criteria.list().isEmpty()){
            existe = true;
        }
        session.close();
        return existe;
    }
 
}
