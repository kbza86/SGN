/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller.form;


import javax.swing.JRadioButton;
import javax.swing.JTextField;
import view.user.FrmUser;


/**
 *
 * @author wally86
 */

/**
 * 
 * @author tisan
 */
public class ControllerFormUser {
    /**
     * 
     * @param rbtnDni
     * @param txtBusqueda
     * @return 
     */
    public boolean validarBuscar(JRadioButton rbtnDni, JTextField txtBusqueda){
        String cadena = txtBusqueda.getText();
        boolean esValido=false;
        if(rbtnDni.isSelected()){
            if(cadena.length()==8){
                esValido=true;
            }
        }else{
            if((cadena.length()>=10)){
                esValido=true;
            }
        }
        return esValido;
    }
    /**
     * 
     * @param frmUsuario 
     */
    public void actualizarCantidadNetbookOsciosas(FrmUser frmUsuario){
        int netbookOsciosas=0;
        netbookOsciosas = frmUsuario.getControladorNetbook().obtenerNumeroNetbookOsciosas();
        frmUsuario.getLblNetbookOsciosa().setText("Total de : "+String.valueOf(netbookOsciosas));
        frmUsuario.SetContadorNetbooksOsciosas(netbookOsciosas);
    }
    public void actualizarCantidadMigraciones(FrmUser frmUsuario){
        int migracionPendiente =0;
        migracionPendiente=frmUsuario.getControladorDestino().contarMigracionesPendientes();
        frmUsuario.getLblMigracionesPendientes().setText("Total de : "+String.valueOf(migracionPendiente));
        frmUsuario.setContadorMigracionesPenientes(migracionPendiente);
    }
    public void actualizarCantidadPases(FrmUser frmUsuario){
        int pasePendientes = 0;
        pasePendientes=frmUsuario.getControladorPase().obtenerTotalPasesPendentes();
        frmUsuario.getLblPasesPendientes().setText("Total de : "+String.valueOf(pasePendientes));
        frmUsuario.setContadorPasesPendientes(pasePendientes);
    }
    public void actualizarCantidadReasignaciones(FrmUser frmUsuario){
        int reasignacionesPendientes=0;
        reasignacionesPendientes=frmUsuario.getControladorReasignacion().obtenerTotalReasignacionesPendientes();
        frmUsuario.getLblReasignaciones().setText("Total de : " +String.valueOf(reasignacionesPendientes));
        frmUsuario.setContadorReasignacion(reasignacionesPendientes);
    }
    public void actualizarCantidadServicioTecnico(FrmUser frmUsuario){
        int netbookSTPendientes = 0;
        netbookSTPendientes = frmUsuario.getControladorST().obtenerNumeroSTPendientes();
        frmUsuario.getLblMaquinasST().setText("Total de : "+String.valueOf(netbookSTPendientes));
        frmUsuario.setContadorNetbooksST(netbookSTPendientes);
    }
    
}
