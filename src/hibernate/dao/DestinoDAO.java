/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate.dao;

import java.util.List;
import model.domain.Destino;
import model.domain.Persona;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author wally86
 */
public class DestinoDAO {

    public void altaDestino(Destino destinoNuevo) {
        Session session = hibernate.configuration.HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(destinoNuevo);
        session.getTransaction().commit();
        session.close();
    }

    public void modificarDestino(Destino destinoModificado) {
        Session session = hibernate.configuration.HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(destinoModificado);
        session.getTransaction().commit();
        session.close();
    }

    public short obtenerUltimoId() {
        int numeroTotalFilas = 0;
        short id = 1;
        Destino destino = new Destino();
        Session session = hibernate.configuration.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Destino.class);
        criteria.addOrder(Order.asc("idDestino"));
        try {
            numeroTotalFilas = criteria.list().size();
            destino = (Destino) criteria.list().get(--numeroTotalFilas);
            id = destino.getIdDestino();
            id++;
        } catch (Exception ex) {
            return 1;
        }
        session.close();
        return id;
    }

    public List<Destino> obtenerTodasMigraciones() {
        Session session = hibernate.configuration.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Destino.class);
        criteria.addOrder(Order.asc("idDestino"));
        List<Destino> lista = criteria.list();
        session.close();
        return lista;
    }

    public List<Destino> obtenerTodasMigracionesPendientes() {
        Session session = hibernate.configuration.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Destino.class);
        criteria.add(Restrictions.like("estado", false));
        List<Destino> lista = criteria.list();
        session.close();
        return lista;
    }

    public List<Destino> obtenerTodasMigracionesConcretadas() {
        Session session = hibernate.configuration.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Destino.class);
        criteria.add(Restrictions.like("estado", true));
        List<Destino> lista = criteria.list();
        session.close();
        return lista;
    }

    public int obtenerTotalMigracionesPendientes() {
        return obtenerTodasMigracionesPendientes().size();
    }

    public int obtenerTotalMigracionesEfectuadas() {
        return obtenerTodasMigracionesConcretadas().size();
    }

    public boolean verificarExistencia(Persona persona) {
        boolean existe = Boolean.FALSE;
        Session session = hibernate.configuration.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Destino.class);
        criteria.add(Restrictions.like("persona", persona));
        try {
            if (criteria.list().get(0) != null) {
                existe = Boolean.TRUE;
            }
        } catch (Exception ex) {

        }
        return existe;
    }

    public Destino obtenerDestinoPorPersona(Persona persona) {
        Session session = hibernate.configuration.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Destino.class);
        criteria.add(Restrictions.like("persona", persona));
        Destino destino = null;
        try {
            destino = (Destino) criteria.list().get(0);

        } catch (Exception ex) {

        }
        return destino;
    }
}
