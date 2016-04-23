/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hibernate.dao;
import model.domain.Persona;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
/**
 *
 * @author wally86
 */
public class PersonaDAO {
    public void altaPersona(Persona persona){
        Session session = hibernate.configuration.HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(persona);
        session.getTransaction().commit();
        session.close();
    }
    public void modificarPersona(Persona persona){
        Session session = hibernate.configuration.HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(persona);
        session.getTransaction().commit();
        session.close();
    }
    public Persona obtenerPersonaPorDni(int dni){
        Session session = hibernate.configuration.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Persona.class);
        criteria.add(Restrictions.like("dni",dni));
        Persona persona;
        try{
        persona = (Persona)criteria.list().get(0);
        }catch(IndexOutOfBoundsException ex){
            session.close();
            return null;
        }
        session.close();
        return persona;
    }
    public Persona obtenerPersonaPorId(int id){
        Session session = hibernate.configuration.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Persona.class);
        criteria.add(Restrictions.like("idPersona",id));
        Persona persona = null;
        try{
        persona = (Persona)criteria.list().get(0);
        }catch(IndexOutOfBoundsException ex){
            session.close();
            return null;
        }
        session.close();
        return persona;
    }
    public boolean verificarExistencia(int dni){
        boolean existe = false;
        Session session = hibernate.configuration.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Persona.class);
        criteria.add(Restrictions.like("dni",dni));
        if(!criteria.list().isEmpty()){
            existe=true;
        }
        session.close();
        return existe;
    } 
    public int obtenerUltimoId(){
        int numeroTotalFilas = 0;
        int id =1;
        Persona persona = new Persona();
        Session session = hibernate.configuration.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Persona.class);
        criteria.addOrder(Order.asc("idPersona"));     
        try{
            numeroTotalFilas=criteria.list().size();
            persona = (Persona)criteria.list().get(--numeroTotalFilas);
            id = persona.getIdPersona();
            id++;
        }catch(Exception ex){
            return 1;
        }
        session.close();
        return id;
    }
}
