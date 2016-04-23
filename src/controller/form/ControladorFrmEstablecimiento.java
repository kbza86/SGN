/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller.form;

import javax.swing.JLabel;
import view.school.FrmEstablecimientoCRUD;

/**
 *
 * @author wally86
 */
public class ControladorFrmEstablecimiento {
    
    public void ocultarLblInformativos(FrmEstablecimientoCRUD frmEstablecimientoAlta){
        frmEstablecimientoAlta.getLabelInfoLocalidad().setVisible(false);
        frmEstablecimientoAlta.getLabelInfoNombre().setVisible(false);
    }
    public void mostrarLblInformativo(JLabel label){
        label.setVisible(true);
    }
    public void ocultarLblInformativo(JLabel label){
        label.setVisible(false);
    }
}
