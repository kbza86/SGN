/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hibernate.dao;

import java.util.List;
import model.domain.Establecimiento;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author wally86
 */
public class EstablecimientoDAO {
    /**
     * 
     * @param colegio 
     */
    public void altaEstablecimiento(Establecimiento colegio){
      Session session = hibernate.configuration.HibernateUtil.getSessionFactory().openSession();
      session.beginTransaction();
      session.save(colegio);
      session.getTransaction().commit();
      session.close();
    }
    /**
     * 
     * @param colegio 
     */
    public void modificarEstablecimiento(Establecimiento colegio){
      Session session = hibernate.configuration.HibernateUtil.getSessionFactory().openSession();
      session.beginTransaction();
      session.update(colegio);
      session.getTransaction().commit();
      session.close();  
    }
    /**
     * 
     * @return 
     */
    public List<Establecimiento> obtenerTodosEstablecimentos(){
        Session session = hibernate.configuration.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Establecimiento.class);
        criteria.addOrder(Order.asc("idEstablecimiento"));
        List<Establecimiento> lista = criteria.list();
        session.close();
        return lista;
    }
    /**
     * 
     * @param nombre
     * @return 
     */
    public Establecimiento obtenerEstablecimiento(String nombre){
        Session session = hibernate.configuration.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Establecimiento.class);
        criteria.add(Restrictions.like("nombre", nombre));
        Establecimiento netbook=null;
        try{
           netbook  = (Establecimiento)criteria.list().get(0);
        }catch(IndexOutOfBoundsException ex){
            session.close();
            return null;
        }
        session.close();
        return netbook;
    }
    
   public short obtenerUltimoId(){
        short id = 1;
        short numeroRegistros = (short)obtenerTodosEstablecimentos().size();
        if(numeroRegistros!=0){
            id=numeroRegistros++;
        }
        return id;
    }
}
