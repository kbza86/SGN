/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller.form;

import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import view.netbook.FrmReassignrCRUD;

/**
 *
 * @author wally86
 */
public class ControladorFrmReasignarCRUD {

    private boolean estadoDniAlumno;
    public ControladorFrmReasignarCRUD() {
        this.estadoDniAlumno=false;
    }
    
    /**
     * 
     * @param label
     * @param pathImagen 
     */
    public void agregarImagenEstadoLabel(JLabel label, String pathImagen) {
        URL url = this.getClass().getResource(pathImagen);
        ImageIcon icon = new ImageIcon(url);
        label.setIcon(icon);
    }
    /**
     * 
     * @param label 
     */
    public void ocultarLabelInformativo(JLabel label) {
        label.setVisible(false);
    }
    /**
     * 
     * @param label 
     */
    public void mostrarLabelInformativo(JLabel label) {
        label.setVisible(true);
    }
    
    public void desactivarCamposParaAlta(FrmReassignrCRUD frmReasignarCRUD){
        frmReasignarCRUD.getTxtCursoNuevoTitular().setEditable(false);
        frmReasignarCRUD.getTxtCursoTitular().setEditable(false);
        frmReasignarCRUD.getTxtDniAlumnoTitular().setEditable(false);
        frmReasignarCRUD.getTxtIdHardware().setEditable(false);
        frmReasignarCRUD.getTxtNombreApellidoNuevoTitular().setEditable(false);
        frmReasignarCRUD.getTxtNombreApellidoTitular().setEditable(false);
        frmReasignarCRUD.getTxtNumeroSerie().setEditable(false);
    }


    /**
     * @return the estadoDniAlumno
     */
    public boolean isEstadoDniAlumno() {
        return estadoDniAlumno;
    }

    /**
     * @param estadoDniAlumno the estadoDniAlumno to set
     */
    public void setEstadoDniAlumno(boolean estadoDniAlumno) {
        this.estadoDniAlumno = estadoDniAlumno;
    }
    
    
}
