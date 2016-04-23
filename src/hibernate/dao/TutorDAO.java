/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hibernate.dao;

import model.domain.Persona;
import model.domain.Tutor;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author wally86
 */
public class TutorDAO {
    private PersonaDAO personaDAO;

    public TutorDAO() {
        personaDAO=new PersonaDAO();
    }
    
    
    public void altaTutor(Tutor tutor){
      Session session = hibernate.configuration.HibernateUtil.getSessionFactory().openSession();
      session.beginTransaction();
      session.save(tutor);
      session.getTransaction().commit();
      session.close();
    }
    
    public void modificarTutor(Tutor tutor){
      Session session = hibernate.configuration.HibernateUtil.getSessionFactory().openSession();
      session.beginTransaction();
      session.update(tutor);
      session.getTransaction().commit();
      session.close();  
    }
    public Tutor obteneTutorPorDni(int dni){
        Persona persona = personaDAO.obtenerPersonaPorDni(dni);
        Session session = hibernate.configuration.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Tutor.class);
        criteria.add(Restrictions.like("persona", persona));
        Tutor tutor = null;
        try{
            tutor=(Tutor)criteria.list().get(0);
        }catch(IndexOutOfBoundsException ex){
            session.close();
            return null;
        }
        session.close();
        return tutor;
    }
    public Tutor obtenerTutorPorId(short id){
        Session session = hibernate.configuration.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Tutor.class);
        criteria.add(Restrictions.like("idTutor", id));
        Tutor tutor = null;
        try{
            tutor=(Tutor)criteria.list().get(0);
        }catch(IndexOutOfBoundsException ex){
            session.close();
            return null;
        }
        session.close();
        return tutor;
    }
    public boolean verificarExistencia(int dni){
        boolean existePersona = personaDAO.verificarExistencia(dni);
        boolean existeTutor = false;
        if(existePersona){
        Persona persona = personaDAO.obtenerPersonaPorDni(dni);
        Session session = hibernate.configuration.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Tutor.class);
        criteria.add(Restrictions.like("persona", persona));
        if(!criteria.list().isEmpty()){
            existeTutor = true;
        }
        session.close();
        }
        return existeTutor;
    }
    public short obtenerUltimoId(){
        Tutor tutor = new Tutor();
        short id = 1;
        int numeroFilas=0;
        Session session = hibernate.configuration.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Tutor.class);
        criteria.addOrder(Order.asc("idTutor"));
        try{
        numeroFilas=criteria.list().size();
        tutor = (Tutor) criteria.list().get(--numeroFilas);
        id = tutor.getIdTutor();
        id++;
        }catch(Exception ex){
            
        }
        return id;
    }
}
