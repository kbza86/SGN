/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.data;

import hibernate.dao.ServicioTecnicoDAO;
import java.text.SimpleDateFormat;
import java.util.Date;
import model.domain.Netbook;
import model.domain.ServicioTecnico;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import view.technicalService.FrmServicioTecnicoCRUD;

/**
 *
 * @author wally86
 */
public class ControladorServicioTecnico {

    private ServicioTecnicoDAO servicioTecnicoDAO;

    public ControladorServicioTecnico() {
        this.servicioTecnicoDAO = new ServicioTecnicoDAO();
    }

    public void guardarServicioTecnico(FrmServicioTecnicoCRUD servicioTecnicoPrincipal) {
        String cadena = convertirDateACadena();
        Date fechaDeSolicitud = new Date();
        Date fechaDevolucion = null;
        boolean estado = false;
        Netbook netbook;
        if (servicioTecnicoPrincipal.getTipoTitular() == 'a') {
            netbook = servicioTecnicoPrincipal.getFrmPrincial().getControladorFrmPrincipal().getFrmUsuario(servicioTecnicoPrincipal.getFrmPrincial()).getControladorAlumno().getNetbook();
        } else {
            netbook = servicioTecnicoPrincipal.getFrmPrincial().getControladorFrmPrincipal().getFrmUsuario(servicioTecnicoPrincipal.getFrmPrincial()).getControladorProfesor().getNetbook();
        }
        String diagnostico = servicioTecnicoPrincipal.getTxtArea().getText();
        ServicioTecnico servicioTecnico = new ServicioTecnico(obtenerId(), netbook, diagnostico, fechaDeSolicitud, fechaDevolucion, estado, obtenerId());
        servicioTecnicoDAO.altaServicioTecnico(servicioTecnico);
    }

    public void cargarDatosAlta(FrmServicioTecnicoCRUD frmServicioTecnicoPrincipal, char tipoTitular) {
        if (tipoTitular == 'a') {
            frmServicioTecnicoPrincipal.getTxtNumeroSerie().setText(frmServicioTecnicoPrincipal.getFrmPrincial().getControladorFrmPrincipal().getFrmUsuario(frmServicioTecnicoPrincipal.getFrmPrincial()).getControladorAlumno().getNetbook().getIdNetbook());
            frmServicioTecnicoPrincipal.getTxtIdHardware().setText(frmServicioTecnicoPrincipal.getFrmPrincial().getControladorFrmPrincipal().getFrmUsuario(frmServicioTecnicoPrincipal.getFrmPrincial()).getControladorAlumno().getNetbook().getIdHardware());
            frmServicioTecnicoPrincipal.getTxtDniTitular().setText(String.valueOf(frmServicioTecnicoPrincipal.getFrmPrincial().getControladorFrmPrincipal().getFrmUsuario(frmServicioTecnicoPrincipal.getFrmPrincial()).getControladorAlumno().getPersonaAlumno().getDni()));
            frmServicioTecnicoPrincipal.getTxtFechaSolicitud().setText(String.valueOf(convertirDateACadena()));

        } else {
            frmServicioTecnicoPrincipal.getTxtNumeroSerie().setText(frmServicioTecnicoPrincipal.getFrmPrincial().getControladorFrmPrincipal().getFrmUsuario(frmServicioTecnicoPrincipal.getFrmPrincial()).getControladorProfesor().getNetbook().getIdNetbook());
            frmServicioTecnicoPrincipal.getTxtIdHardware().setText(frmServicioTecnicoPrincipal.getFrmPrincial().getControladorFrmPrincipal().getFrmUsuario(frmServicioTecnicoPrincipal.getFrmPrincial()).getControladorProfesor().getNetbook().getIdHardware());
            frmServicioTecnicoPrincipal.getTxtDniTitular().setText(String.valueOf(frmServicioTecnicoPrincipal.getFrmPrincial().getControladorFrmPrincipal().getFrmUsuario(frmServicioTecnicoPrincipal.getFrmPrincial()).getControladorProfesor().getPersonaProfesor().getDni()));
            frmServicioTecnicoPrincipal.getTxtFechaSolicitud().setText(String.valueOf(convertirDateACadena()));

        }
    }

    public ServicioTecnico obtenerServicioTecnicoPorNetbook(Netbook netbook){
        return servicioTecnicoDAO.obtenerServicioTecnicoSegunNet(netbook);
    }
    public int obtenerNumeroSTPendientes() {
        return this.servicioTecnicoDAO.obtenerTotalSTPendientes();
    }

    private String convertirDateACadena() {
        Date hoy = new Date();
        String fechaConFormato = new String();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        try {
            fechaConFormato = sdf.format(hoy);
        } catch (Exception ex) {

        }
        return fechaConFormato;
    }

    public int obtenerId() {
        int numeroTotalFilas = 0;
        int id = 1;
        ServicioTecnico servicioTecnico = new ServicioTecnico();
        Session session = hibernate.configuration.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(ServicioTecnico.class);
        criteria.addOrder(Order.asc("idServicioTecnico"));
        try {
            numeroTotalFilas = criteria.list().size();
            servicioTecnico = (ServicioTecnico) criteria.list().get(--numeroTotalFilas);
            id = servicioTecnico.getIdServicioTecnico();
            id++;
        } catch (Exception ex) {
            return 1;
        }
        session.close();
        return id;
    }

    public boolean verificarExistencia(Netbook netbook) {
        return servicioTecnicoDAO.verificarExistencia(netbook);
    }
}
