/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller.form;

import javax.swing.JLabel;
import javax.swing.JTextField;
import vista.pase.FrmPaseCRUD;

/**
 *
 * @author wally86
 */
public class ControladorFrmPasePrincipal {
    private boolean estadoNumeroServidor;
    private boolean estadoSN;
    private boolean estadoMarcaArranque;

    public ControladorFrmPasePrincipal() {
    this.estadoMarcaArranque=false;
    this.estadoNumeroServidor=false;
    this.estadoSN=false;
    }
    
    
    public void ocultarLabelsInformativos(FrmPaseCRUD frmPasePrincipal){
        ocultarLabel(frmPasePrincipal.getLabelInfoIdHardware());
        ocultarLabel(frmPasePrincipal.getLabelInfoMarcaArranque());
        ocultarLabel(frmPasePrincipal.getLabelInfoServidor());
        ocultarLabel(frmPasePrincipal.getLabelInfoSn());
    }
    public void ocultarLabel(JLabel label){
        label.setVisible(false);
    }
    public void mostrarLabel(JLabel label){
        label.setVisible(true);
    }
    public void deshabilitarTxtField(JTextField textField){
        textField.setEditable(false);
        
    }
    
    public boolean validarCampos(){
        return (estadoMarcaArranque&&estadoNumeroServidor&&estadoSN);
    }

    /**
     * @return the estadoNumeroServidor
     */
    public boolean isEstadoNumeroServidor() {
        return estadoNumeroServidor;
    }

    /**
     * @param estadoNumeroServidor the estadoNumeroServidor to set
     */
    public void setEstadoNumeroServidor(boolean estadoNumeroServidor) {
        this.estadoNumeroServidor = estadoNumeroServidor;
    }

    /**
     * @return the estadoSN
     */
    public boolean isEstadoSN() {
        return estadoSN;
    }

    /**
     * @param estadoSN the estadoSN to set
     */
    public void setEstadoSN(boolean estadoSN) {
        this.estadoSN = estadoSN;
    }

    /**
     * @return the estadoMarcaArranque
     */
    public boolean isEstadoMarcaArranque() {
        return estadoMarcaArranque;
    }

    /**
     * @param estadoMarcaArranque the estadoMarcaArranque to set
     */
    public void setEstadoMarcaArranque(boolean estadoMarcaArranque) {
        this.estadoMarcaArranque = estadoMarcaArranque;
    }
}
