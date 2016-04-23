/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hibernate.dao;

import java.util.List;
import model.domain.Netbook;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author wally86
 */
public class NetbookDAO {
  
    public void altaNetbook(Netbook netbook){
      Session session = hibernate.configuration.HibernateUtil.getSessionFactory().openSession();
      session.beginTransaction();
      session.save(netbook);
      session.getTransaction().commit();
      session.close();
    }
    public void modificarNetbook(Netbook netbook){
      Session session = hibernate.configuration.HibernateUtil.getSessionFactory().openSession();
      session.beginTransaction();
      session.update(netbook);
      session.getTransaction().commit();
      session.close();  
    }
    public List<Netbook> obtenerTodasNetbookValidas(){
        Session session = hibernate.configuration.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Netbook.class);
        criteria.add(Restrictions.like("estado", true));
        List<Netbook> lista = criteria.list();
        session.close();
        return lista;
    }
     public List<Netbook> obtenerTodasNetbookNoValidas(){
        Session session = hibernate.configuration.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Netbook.class);
        criteria.add(Restrictions.like("estado", false));
        List<Netbook> lista = criteria.list();
        session.close();
        return lista;
    }
    public int obtenerNumeroNetbookNoValidas(){
        int numero = 0;
        try{
        numero = obtenerTodasNetbookNoValidas().size();
        
        }catch(Exception ex){
            
          
        }
        return numero;
    } 
    public List<Netbook> obtenerTodasNetbook(){
        Session session = hibernate.configuration.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Netbook.class);
        criteria.addOrder(Order.asc("idNetbook"));
        List<Netbook> lista = criteria.list();
        session.close();
        return lista;
    }
    public Netbook obtenerNetbook(String serie){
        Session session = hibernate.configuration.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Netbook.class);
        criteria.add(Restrictions.like("idNetbook", serie));
        Netbook netbook = null;
        try{
        netbook= (Netbook)criteria.list().get(0);
        }catch(IndexOutOfBoundsException ex){
            session.close();
            return null;
        }
        session.close();
        return netbook;
    }
    public boolean verificarExistencia(String serie){
        boolean existe = false;
        Session session = hibernate.configuration.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Netbook.class);
        criteria.add(Restrictions.like("idNetbook", serie));
        if(!criteria.list().isEmpty()){
            existe=true;
        }
        session.close();
        return existe;
    }
}
