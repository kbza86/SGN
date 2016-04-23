/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hibernate.dao;
import java.util.List;
import model.domain.Alumno;
import model.domain.Netbook;
import model.domain.Persona;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author wally86
 */
public class AlumnoDAO {
    private PersonaDAO personaDAO;
    private NetbookDAO netbookDAO;

    public AlumnoDAO() {
    this.netbookDAO= new NetbookDAO();
    this.personaDAO= new PersonaDAO();
    }
    
    /**
     * 
     * @param alumno 
     */
    public void altaAlumno(Alumno alumno){
     Session session = hibernate.configuration.HibernateUtil.getSessionFactory().openSession();
     session.beginTransaction();
     session.save(alumno);
     session.getTransaction().commit();
     session.close();
    }
    /**
     * 
     * @param alumno 
     */
    public void modificarAlumno(Alumno alumno){
     Session session = hibernate.configuration.HibernateUtil.getSessionFactory().openSession();
     session.beginTransaction();
     session.update(alumno);
     session.getTransaction().commit();
     session.close();   
    }
    /**
     * 
     * @return 
     */
    public List<Alumno> obtenerTodosAlumnos() {
        Session session = hibernate.configuration.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Alumno.class);
        criteria.addOrder(Order.asc("idAlumno"));
        List<Alumno> lista = criteria.list();        
        session.close();
        return lista;
    }
    public List<Alumno> obtenerAlumnosPorEstado(String estado){
        Session session = hibernate.configuration.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Alumno.class);
        criteria.add(Restrictions.like("estado", estado));
        List<Alumno> lista = criteria.list();
        session.close();
        return lista;
    }
    /**
     * 
     * @param dni
     * @return 
     */
    public Alumno buscarAlumnoDni(int dni){
        Persona persona = personaDAO.obtenerPersonaPorDni(dni);
        Session session = hibernate.configuration.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Alumno.class);
        criteria.add(Restrictions.like("persona",persona));
        Alumno alumno;
        try{
        alumno = (Alumno)criteria.list().get(0);
        }catch(IndexOutOfBoundsException ex){
            session.close();
            return null;
        }
        session.close();
        return alumno;
    }
    /**
     * 
     * @param numeroSerie
     * @return 
     */
    public Alumno buscarAlumnoNetbook(String numeroSerie){
        Netbook netbook = netbookDAO.obtenerNetbook(numeroSerie);
        Session session = hibernate.configuration.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Alumno.class);
        criteria.add(Restrictions.like("netbook",netbook ));
        Alumno alumno;
        try{
        alumno = (Alumno)criteria.list().get(0);
        }catch(IndexOutOfBoundsException ex){
            session.close();
            return null;
        }
        session.close();
        return alumno;
    }
    /**
     * 
     * @param dni
     * @return 
     */
    public boolean verificarExistenciaAlumno(int dni){
        boolean existe= false;
        Persona persona = personaDAO.obtenerPersonaPorDni(dni);
        Session session = hibernate.configuration.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Alumno.class);
        criteria.add(Restrictions.like("persona",persona.getIdPersona()));
        if(!criteria.list().isEmpty()){
            existe = true;
        }
        session.close();
        return existe;
    }
    /**
     * 
     * @return 
     */
    public int obtenerUltimoId(){
        int numeroTotalFilas = 0;
        int id =1;
        Alumno alumno = new Alumno();
        Session session = hibernate.configuration.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Alumno.class);
        criteria.addOrder(Order.asc("idAlumno"));     
        try{
            numeroTotalFilas=criteria.list().size();
            alumno = (Alumno)criteria.list().get(--numeroTotalFilas);
            id = alumno.getIdAlumno();
            id++;
        }catch(Exception ex){
            return 1;
        }
        session.close();
        return id;
    }
    
}
