/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller.data;

import hibernate.dao.EstablecimientoDAO;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.domain.Establecimiento;
import view.school.FrmEstablecimientoCRUD;

/**
 *
 * @author wally86
 */
public class ControladorEstablecimiento {
    private EstablecimientoDAO establecimientoDAO;
    
    public ControladorEstablecimiento() {
    this.establecimientoDAO= new EstablecimientoDAO();
    }
    /**
     * 
     * @param frmEstablecimientoAlta 
     */
    public void agregarEstablecimiento(FrmEstablecimientoCRUD frmEstablecimientoAlta){
        String nombre = frmEstablecimientoAlta.getTxtNombre().getText().toUpperCase();
        String localidad = frmEstablecimientoAlta.getTxtLocalidad().getText().toUpperCase();
        short id = this.establecimientoDAO.obtenerUltimoId();
        Establecimiento establecimiento = new Establecimiento(id, nombre, localidad);
        this.establecimientoDAO.altaEstablecimiento(establecimiento);
    }
    
    public List<Establecimiento> obtenerTodosEstablecimientos(){
        return establecimientoDAO.obtenerTodosEstablecimentos();
    }
    
    public Establecimiento obtenerEstablecimientoPorNombre(String nombre){
        return establecimientoDAO.obtenerEstablecimiento(nombre);
    }
    
    public void cargarGrilla(JTable grillaEstablecimiento){
        grillaEstablecimiento.removeAll();
        Object []obj = new Object[2];
        DefaultTableModel tableModel = (DefaultTableModel) grillaEstablecimiento.getModel();
        tableModel.setRowCount(0);
        for(Establecimiento est : obtenerTodosEstablecimientos()){
            obj[0]=est.getNombre();
            obj[1]=est.getLocalidad();
            tableModel.addRow(obj);
        }
        
    }
    public void actualizarGrillaEstablecimiento(char tipoOperacion, JTable grillaEstablecimiento){
        Object []obj = new Object[2];
        DefaultTableModel tableModel =(DefaultTableModel) grillaEstablecimiento.getModel();
        if(tipoOperacion=='a'){
            
        }else{
            int posision = grillaEstablecimiento.getSelectedRow();
            
        }
    }
}
