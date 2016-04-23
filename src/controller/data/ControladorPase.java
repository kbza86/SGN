/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller.data;

import hibernate.dao.PaseDAO;
import model.domain.Netbook;
import model.domain.Pase;
import vista.pase.FrmPaseCRUD;

/**
 *
 * @author wally86
 */
public class ControladorPase {
    private PaseDAO paseDAO;

    public ControladorPase() {
    this.paseDAO = new PaseDAO();
    }
    
    
   /**
    * 
    * @param frmPasePrincipal 
    */
    public void agregarPase(FrmPaseCRUD frmPasePrincipal){
        int id= paseDAO.obtenerUltimoId();
        boolean estado = false;
        String  sn = frmPasePrincipal.getTxtSn().getText();
        String bitArranque = frmPasePrincipal.getTxtBitArranque().getText();
        String servidor = frmPasePrincipal.getTxtSercidor().getText();
        Netbook netbook = frmPasePrincipal.getFrmUsuario().getControladorAlumno().getNetbook();
        Pase pase = new Pase(id
                , netbook
                , estado  
                , sn
                , bitArranque
                , servidor);
        paseDAO.altaPase(pase);
    }
    
    /**
     * 
     * @param frmPasePrincipal
     */
    public void modificarPase(FrmPaseCRUD frmPasePrincipal){
        int id= paseDAO.obtenerUltimoId();
        boolean estado = false;
        String  sn = frmPasePrincipal.getTxtSn().getText();
        String bitArranque = frmPasePrincipal.getTxtBitArranque().getText();
        String servidor = frmPasePrincipal.getTxtSercidor().getText();
        Netbook netbook = frmPasePrincipal.getFrmUsuario().getControladorAlumno().getNetbook();
        Pase pase = new Pase(id
                , netbook
                , estado  
                , sn
                , bitArranque
                , servidor);
        paseDAO.modificarPase(pase);
    }
    /**
     * 
     * @return int
     */
    public int obtenerTotalPasesPendentes(){
        return paseDAO.obtenerTotalPasesPendientes();
    }
    /**
     * @return int 
     */
    public int obtenerTotalPasesEfectuados(){
        return paseDAO.obtenerTotalPasesEfctuados();
    }
    public boolean verificarExistencia(Netbook netbook){        
        return paseDAO.verificarExistencia(netbook);
    }
    public Pase obtenerPaseSegunNetbook(Netbook netbook){
        return paseDAO.obtenerPaseSegunNetbook(netbook);
    }
}
