/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller.data;

import hibernate.dao.NetbookDAO;
import hibernate.dao.ReasignacionDAO;
import java.util.List;
import javax.swing.JOptionPane;
import model.domain.Netbook;
import model.domain.Reasignacion;
import view.netbook.FrmReassignrCRUD;

/**
 *
 * @author wally86
 */
public class ControladorReasignacion {
    private ReasignacionDAO reasignacionDAO;

    public ControladorReasignacion() {
    reasignacionDAO= new ReasignacionDAO();
    }
    
    public void guardarReasignacion(FrmReassignrCRUD frmReasignarCRUD){
        NetbookDAO netbookDAO = new NetbookDAO();
        Netbook netbook = frmReasignarCRUD.getFrmPrincipal().getControladorFrmPrincipal().getFrmUsuario(frmReasignarCRUD.getFrmPrincipal()).getControladorAlumno().getNetbook();
        
            Reasignacion reasignacion = new Reasignacion(reasignacionDAO.obtenerId()
                    , frmReasignarCRUD.getPersonaTitularNuevo()
                    , netbook
                    , false);
            reasignacionDAO.altaReasignacion(reasignacion);
            netbook.setEstado(true);
            netbookDAO.modificarNetbook(netbook);
        
    }
    public short obtenerId(){
        return reasignacionDAO.obtenerId();
    }
    public List<Reasignacion> obtenerReasignacionesPendientes(){
        return reasignacionDAO.obtenerTodasReasignacionesPendientes();
    }
    public List<Reasignacion> obtenerReasignacionesRealizadas(){
        return reasignacionDAO.obtenerTodasReasignacionesRealizadas();
    }
    public List<Reasignacion> obtenerTodasReasignaciones(){
        return reasignacionDAO.obtenerTodasReasignaciones();
    }
    
    public int obtenerTotalReasignacionesPendientes(){
        return obtenerReasignacionesPendientes().size();
    }
    public int obtenerTotalReasignacionesRealizadas(){
        return obtenerReasignacionesRealizadas().size();
    }
    public Reasignacion obtenerReasignacionPorNet(Netbook netbook){
       return reasignacionDAO.obtenerReasignacionSegunNetbook(netbook);
    }
    public boolean verificarExistencia(FrmReassignrCRUD frmReasignarCRUD,char tipoTitular){
        Netbook netbook = null;
        switch(tipoTitular){
            case 'a':
                netbook= frmReasignarCRUD.getFrmPrincipal().getControladorFrmPrincipal().getFrmUsuario(frmReasignarCRUD.getFrmPrincipal()).getControladorAlumno().getNetbook();
                break;
            case 'd':
                netbook= frmReasignarCRUD.getFrmPrincipal().getControladorFrmPrincipal().getFrmUsuario(frmReasignarCRUD.getFrmPrincipal()).getControladorProfesor().getNetbook();
        }
        
        return reasignacionDAO.verificarExistencia(netbook);
    }
    
}
