/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hibernate.dao;

import java.util.List;
import model.domain.Netbook;
import model.domain.ServicioTecnico;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author wally86
 */
public class ServicioTecnicoDAO {
   
    
    public void altaServicioTecnico(ServicioTecnico servicioTecnicoNuevo){
        Session session = hibernate.configuration.HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(servicioTecnicoNuevo);
        session.getTransaction().commit();
        session.close();
    } 
    
    public void modificarServicioTecnico(ServicioTecnico servicioTecnico){
        Session session = hibernate.configuration.HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(servicioTecnico);
        session.getTransaction().commit();
        session.close();
    }
    
    public List<ServicioTecnico> obtenerTodosST(){
        Session session = hibernate.configuration.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(ServicioTecnico.class);
        criteria.addOrder(Order.asc("idServicioTecnico"));
        List<ServicioTecnico> lista = criteria.list();
        session.close();
        return lista;
    }
    
    public List<ServicioTecnico> obtenerServicioTecnicosPendientes(){
        Session session = hibernate.configuration.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(ServicioTecnico.class);
        criteria.add(Restrictions.like("estado", false));
        List<ServicioTecnico> lista = criteria.list();
        session.close();
        return lista;
    }
    
    public List<ServicioTecnico> obtenerServicioTecnicosCargados(){
        Session session = hibernate.configuration.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(ServicioTecnico.class);
        criteria.add(Restrictions.like("estado", true));
        List<ServicioTecnico> lista = criteria.list();
        session.close();
        return lista;
    }
    
    public int obtenerTotalSTPendientes(){
        return obtenerServicioTecnicosPendientes().size();
    }
    
    public int obtenerId(){
        int numeroTotalFilas = 0;
        int id =1;
        ServicioTecnico servicioTecnico = new ServicioTecnico();
        Session session = hibernate.configuration.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(ServicioTecnico.class);
        criteria.addOrder(Order.asc("idServicioTecnico"));     
        try{
            numeroTotalFilas=criteria.list().size();
            servicioTecnico = (ServicioTecnico)criteria.list().get(--numeroTotalFilas);
            id = servicioTecnico.getIdServicioTecnico();
            id++;
        }catch(Exception ex){
            return 1;
        }
        session.close();
        return id;
    }
   public boolean verificarExistencia(Netbook netbook){
       boolean existe = false;
       Session session = hibernate.configuration.HibernateUtil.getSessionFactory().openSession();
       Criteria criteria = session.createCriteria(ServicioTecnico.class);
       criteria.add(Restrictions.like("netbook", netbook));
       if(criteria.list().size()!=0){
           existe=true;
       }
       session.close();
       return existe;
   }
   public ServicioTecnico obtenerServicioTecnicoSegunNet(Netbook netbook){
       Session session = hibernate.configuration.HibernateUtil.getSessionFactory().openSession();
       Criteria criteria = session.createCriteria(ServicioTecnico.class);
       criteria.add(Restrictions.like("netbook", netbook));
       ServicioTecnico st;
        try{
        st = (ServicioTecnico)criteria.list().get(0);
        }catch(IndexOutOfBoundsException ex){
            session.close();
            return null;
        }
        session.close();
        return st;
   }
           
}
