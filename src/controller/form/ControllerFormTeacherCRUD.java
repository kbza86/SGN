/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller.form;

import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import view.teacher.FrmProfesorCRUD;

/**
 *
 * @author tisan
 */
public class ControllerFormTeacherCRUD {
    private boolean estadoNombre;
    private boolean estadoApellido;
    private boolean estadoDni;
    private boolean estadoNetbook;

    public ControllerFormTeacherCRUD() {
    this.estadoApellido=false;
    this.estadoDni=false;
    this.estadoNetbook=false;
    this.estadoNombre=false;
    }

     public void ocultarLabellInformativo(JLabel label) {
        label.setVisible(false);
    }

    public void mostrarLabellInformativo(JLabel label) {
        label.setVisible(true);
    }
    
    public void evitarEdicionTxt(JTextField textField){
        textField.setEditable(false);
    }
    public void evitarEdicionTodosTxt(FrmProfesorCRUD frmProfesorCRUD) {
        evitarEdicionTxt(frmProfesorCRUD.getTxtApellidoTitular());
        evitarEdicionTxt(frmProfesorCRUD.getTxtDniTitular());
        evitarEdicionTxt(frmProfesorCRUD.getTxtMarcaNetbook());
        evitarEdicionTxt(frmProfesorCRUD.getTxtModeloNetbook());
        evitarEdicionTxt(frmProfesorCRUD.getTxtNetbook());
        evitarEdicionTxt(frmProfesorCRUD.getTxtNombreTitular());
        evitarEdicionTxt(frmProfesorCRUD.getTxtOfficeKeyNetbook());
        evitarEdicionTxt(frmProfesorCRUD.getTxtWinkeyNetbook());
    }
    
    public void agregarImagenEstadoLabel(JLabel label, String pathImagen) {
        URL url = this.getClass().getResource(pathImagen);
        ImageIcon icon = new ImageIcon(url);
        label.setIcon(icon);
    }
    public void ocultarLabelsInformativos(FrmProfesorCRUD frmProfesorCRUD){
        ocultarLabellInformativo(frmProfesorCRUD.getLabelInfoApellidoTitular());
        ocultarLabellInformativo(frmProfesorCRUD.getLabelInfoDniTitular());
        ocultarLabellInformativo(frmProfesorCRUD.getLabelInfoSerieNetbook());
        ocultarLabellInformativo(frmProfesorCRUD.getLabelInfoNombresTitular());
    }
    public boolean verificarCampos(){
        return (estadoApellido&&estadoDni&&estadoNetbook&&estadoNombre);
    }
    public boolean validarCamposModificar(FrmProfesorCRUD frmProfesorCRUD){
        return (validarDni(frmProfesorCRUD.getTxtDniTitular(), frmProfesorCRUD.getLabelEstadoDni()) &&
                validarCadena(frmProfesorCRUD.getTxtApellidoTitular(), frmProfesorCRUD.getLabelEstadoApellido()) &&
                validarCadena(frmProfesorCRUD.getTxtNombreTitular(), frmProfesorCRUD.getLabelEstadoNombre()));
    }
    public boolean validarDni(JTextField txtDni,JLabel estadoDni){
        String pathImagen="/modelo/imagen/";
        String dni = txtDni.getText();
        if (((dni.length() == 7) || (dni.length() == 8)) ) {
            pathImagen += "si.png";
            setEstadoDni(true);
        } else {
            pathImagen += "no.png";
            setEstadoDni(false);
        }
        agregarImagenEstadoLabel(estadoDni, pathImagen);
        mostrarLabellInformativo(estadoDni);
        return this.estadoDni;
    }
    public boolean validarCadena(JTextField txtApellido, JLabel estadoCadena){
        String apellido = txtApellido.getText();
        String pathImagen="/modelo/imagen/";
        if ((apellido.length() <= 45) && (!apellido.isEmpty())) {
            pathImagen += "si.png";
            setEstadoApellido(true);
        } else {
            pathImagen += "no.png";
            setEstadoApellido(false);
        }
        agregarImagenEstadoLabel(estadoCadena, pathImagen);
        mostrarLabellInformativo(estadoCadena);
        return this.estadoApellido;
    }
   
    /**
     * @return the estadoNombre
     */
    public boolean isEstadoNombre() {
        return estadoNombre;
    }

    /**
     * @param estadoNombre the estadoNombre to set
     */
    public void setEstadoNombre(boolean estadoNombre) {
        this.estadoNombre = estadoNombre;
    }

    /**
     * @return the estadoApellido
     */
    public boolean isEstadoApellido() {
        return estadoApellido;
    }

    /**
     * @param estadoApellido the estadoApellido to set
     */
    public void setEstadoApellido(boolean estadoApellido) {
        this.estadoApellido = estadoApellido;
    }

    /**
     * @return the estadoDni
     */
    public boolean isEstadoDni() {
        return estadoDni;
    }

    /**
     * @param estadoDni the estadoDni to set
     */
    public void setEstadoDni(boolean estadoDni) {
        this.estadoDni = estadoDni;
    }

    /**
     * @return the estadoNetbook
     */
    public boolean isEstadoNetbook() {
        return estadoNetbook;
    }

    /**
     * @param estadoNetbook the estadoNetbook to set
     */
    public void setEstadoNetbook(boolean estadoNetbook) {
        this.estadoNetbook = estadoNetbook;
    }
    
    
}
