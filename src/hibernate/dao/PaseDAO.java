/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hibernate.dao;

import java.util.List;
import model.domain.Netbook;
import model.domain.Pase;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author wally86
 */
public class PaseDAO {
    
    /**
     * 
     * @param pase 
     */
    public void altaPase(Pase pase){
        Session session = hibernate.configuration.HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(pase);
        session.getTransaction().commit();
        session.close();
        
    }
    /**
     * 
     * @param pase 
     */
    public void modificarPase(Pase pase){
        Session session = hibernate.configuration.HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(pase);
        session.getTransaction().commit();
        session.close();
    }
    public List<Pase> obtenerTodosPases() {
        Session session = hibernate.configuration.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Pase.class);
        criteria.addOrder(Order.asc("idPase"));
        List<Pase> lista = criteria.list();
        session.close();
        return lista;
    }
    public List<Pase> obtenerPasesPendientes() {
        Session session = hibernate.configuration.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Pase.class);
        criteria.add(Restrictions.like("estado", false));
        List<Pase> lista = criteria.list();
        session.close();
        return lista;
    }
    public List<Pase> obtenerPasesEfectuados() {
        Session session = hibernate.configuration.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Pase.class);
        criteria.add(Restrictions.like("estado", true));
        List<Pase> lista = criteria.list();
        session.close();
        return lista;
    }
    public int obtenerTotalPasesPendientes() {
        return obtenerPasesPendientes().size();
    }
    public int obtenerTotalPasesEfctuados() {
        return obtenerPasesEfectuados().size();
    }
    
   public int obtenerUltimoId(){
        int numeroTotalFilas = 0;
        int id =1;
       Pase pase = new Pase();
        Session session = hibernate.configuration.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Pase.class);
        criteria.addOrder(Order.asc("idPase"));     
        try{
            numeroTotalFilas=criteria.list().size();
            pase = (Pase)criteria.list().get(--numeroTotalFilas);
            id = pase.getIdPase();
            id++;
        }catch(Exception ex){
            return 1;
        }
        session.close();
        return id;
    }
   public boolean verificarExistencia(Netbook netbook){
       boolean existe = Boolean.FALSE;
       Session session = hibernate.configuration.HibernateUtil.getSessionFactory().openSession();
       Criteria criteria = session.createCriteria(Pase.class);
       criteria.add(Restrictions.like("netbook", netbook));
       try{
           if(((Pase)criteria.list().get(0)).getIdPase()!=0){
               existe = Boolean.TRUE;
           }
       }catch(IndexOutOfBoundsException ex){
           return false;
       }
       session.close();
       return existe;
   }
   
   public Pase obtenerPaseSegunNetbook(Netbook netbook){
       Session session = hibernate.configuration.HibernateUtil.getSessionFactory().openSession();
       Criteria criteria = session.createCriteria(Pase.class);
       criteria.add(Restrictions.like("netbook", netbook));
       Pase encontrada = null;
       try{
           encontrada = (Pase)criteria.list().get(0);
       }catch(Exception ex){
           
       }
       return encontrada;
   }
}
