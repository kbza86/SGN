/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate.dao;

import java.util.List;
import model.domain.Alumno;
import model.domain.ContratoAlumno;
import model.domain.ContratoProfesor;
import model.domain.Profesor;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author walter
 */
public class ContratoDAO {

    public ContratoDAO() {
    }

    public static void altaContratoAlumno(ContratoAlumno contrato) {
        Session session = hibernate.configuration.HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(contrato);
        session.getTransaction().commit();
        session.close();
    }

    public static void altaContratoProfesor(ContratoProfesor contrato) {
        Session session = hibernate.configuration.HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(contrato);
        session.getTransaction().commit();
        session.close();
    }

    public static List<ContratoAlumno> obtenerTodosContratosAlumno(Alumno student) {
        Session session = hibernate.configuration.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(ContratoAlumno.class);
        criteria.add(Restrictions.like("alumno", student));
        List<ContratoAlumno> lista = criteria.list();
        session.close();
        return lista;
    }
     public static List<ContratoProfesor> obtenerTodosContratosProfesor(Profesor teacher) {
        Session session = hibernate.configuration.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(ContratoProfesor.class);
        criteria.add(Restrictions.like("profesor", teacher));
        List<ContratoProfesor> lista = criteria.list();
        session.close();
        return lista;
    }

    public static ContratoAlumno obtenerContratoAlumno(Alumno student) {
        Session session = hibernate.configuration.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(ContratoAlumno.class);
        criteria.add(Restrictions.like("alumno", student));
        ContratoAlumno contarctFound = null;
        try {
            contarctFound = (ContratoAlumno) criteria.list().get(0);
        } catch (IndexOutOfBoundsException ex) {
            session.close();
            return null;
        }
        session.close();
        return contarctFound;
    }
     public static ContratoProfesor obtenerContratoProfesor(Profesor teacher) {
        Session session = hibernate.configuration.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(ContratoProfesor.class);
        criteria.add(Restrictions.like("profesor", teacher));
        ContratoProfesor contarctFound = null;
        try {
            contarctFound = (ContratoProfesor) criteria.list().get(0);
        } catch (IndexOutOfBoundsException ex) {
            session.close();
            return null;
        }
        session.close();
        return contarctFound;
    }

    public static int getCantidaContratoAlumno (Alumno student){
        int amountContract = 0;
        try {
            amountContract = obtenerTodosContratosAlumno(student).size();
        } catch (Exception ex) {

        }
        return amountContract;
    }
        public static int getCantidaContratoProfesor (Profesor teacher){
        int amountContract = 0;
        try {
            amountContract = obtenerTodosContratosProfesor(teacher).size();
        } catch (Exception ex) {

        }
        return amountContract;
    }

    public static int obtenerUltimoIdAlumno() {
        int numeroTotalFilas = 0;
        int id = 1;
        ContratoAlumno contrato = new ContratoAlumno();
        Session session = hibernate.configuration.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(ContratoAlumno.class);
        criteria.addOrder(Order.asc("idContrato"));
        try {
            numeroTotalFilas = criteria.list().size();
            contrato = (ContratoAlumno) criteria.list().get(--numeroTotalFilas);
            id = contrato.getIdContrato();
            id++;
        } catch (Exception ex) {
            return 1;
        }
        session.close();
        return id;
    }

    public static int obtenerUltimoIdProfesor() {
        int numeroTotalFilas = 0;
        int id = 1;
        ContratoProfesor contrato = new ContratoProfesor();
        Session session = hibernate.configuration.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(ContratoProfesor.class);
        criteria.addOrder(Order.asc("idContrato"));
        try {
            numeroTotalFilas = criteria.list().size();
            contrato = (ContratoProfesor) criteria.list().get(--numeroTotalFilas);
            id = contrato.getIdContrato();
            id++;
        } catch (Exception ex) {
            return 1;
        }
        session.close();
        return id;
    }

    public static boolean VerifyContractExistingByStudent(Alumno student) {
        boolean existe = false;
        Session session = hibernate.configuration.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(ContratoAlumno.class);
        criteria.add(Restrictions.like("alumno", student));
        try {
            if (!criteria.list().isEmpty()) {
                existe = true;
            }
        } catch (Exception ex) {
            System.out.printf(ex.toString());
        }
        session.close();
        return existe;
    }

    public static boolean VerifyContractExistingByTeacher(Profesor teacher) {
        boolean existe = false;
        Session session = hibernate.configuration.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(ContratoProfesor.class);
        criteria.add(Restrictions.like("profesor", teacher));
        try {
            if (!criteria.list().isEmpty()) {
                existe = true;
            }
        } catch (Exception ex) {
            System.out.printf(ex.toString());
        }
        session.close();
        return existe;
    }
}
