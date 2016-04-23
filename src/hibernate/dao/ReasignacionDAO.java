/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hibernate.dao;

import java.util.List;
import model.domain.Netbook;
import model.domain.Reasignacion;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author wally86
 */
public class ReasignacionDAO {

    public ReasignacionDAO() {
    }
    
    public void altaReasignacion(Reasignacion reasignacion){
        Session session = hibernate.configuration.HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(reasignacion);
        session.getTransaction().commit();
        session.close();
        
    } 
    
    public void modificarReasignacion(Reasignacion reasignacion){
        Session session = hibernate.configuration.HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(reasignacion);
        session.getTransaction().commit();
        session.close();
    }
    
    public Reasignacion obtenerReasignacionSegunNetbook(Netbook netbook){
       Session session = hibernate.configuration.HibernateUtil.getSessionFactory().openSession();
       Criteria criteria = session.createCriteria(Reasignacion.class);
       criteria.add(Restrictions.like("netbook", netbook));
       Reasignacion encontrada = null;
       try{
           encontrada = (Reasignacion)criteria.list().get(0);
       }catch(Exception ex){
           
       }
       session.close();
       return encontrada;
   }
    public List<Reasignacion> obtenerTodasReasignaciones(){
        Session session = hibernate.configuration.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Reasignacion.class);
        criteria.addOrder(Order.asc("idReasignacion"));
        List<Reasignacion> lista = criteria.list();
        session.close();
        return lista;
    }
    public List<Reasignacion> obtenerTodasReasignacionesRealizadas(){
        Session session = hibernate.configuration.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Reasignacion.class);
        criteria.add(Restrictions.like("estado", true));
        List<Reasignacion> lista = criteria.list();
        session.close();
        return lista;
    }
    public List<Reasignacion> obtenerTodasReasignacionesPendientes(){
        Session session = hibernate.configuration.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Reasignacion.class);
        criteria.add(Restrictions.like("estado", false));
        List<Reasignacion> lista = criteria.list();
        session.close();
        return lista;
    }
    public short obtenerId(){
        int numeroTotalFilas = 0;
        short id =1;
        Reasignacion reasignacion = new Reasignacion();
        Session session = hibernate.configuration.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Reasignacion.class);
        criteria.addOrder(Order.asc("idReasignacion"));     
        try{
            numeroTotalFilas=criteria.list().size();
            reasignacion = (Reasignacion)criteria.list().get(--numeroTotalFilas);
            id = reasignacion.getIdReasignacion();
            id++;
        }catch(Exception ex){
            return 1;
        }
        session.close();
        return id;
    }
    
    public boolean verificarExistencia(Netbook netbook){
        boolean existe = Boolean.FALSE;
        Reasignacion reasignacion = new Reasignacion();
        Session session = hibernate.configuration.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Reasignacion.class);
        criteria.add(Restrictions.like("netbook", netbook));
        try{
            reasignacion = (Reasignacion)criteria.list().get(0);
            existe=Boolean.TRUE;
            
        }catch(IndexOutOfBoundsException ex){
           return false;
        }
        session.close();
        return existe;
    }
}
