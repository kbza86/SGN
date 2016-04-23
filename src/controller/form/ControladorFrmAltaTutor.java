/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller.form;

import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import vista.tutor.FrmTutorCRUD;

/**
 *
 * @author wally86
 */
public class ControladorFrmAltaTutor {
    private boolean campoNombreValido;
    private boolean campoApellidoValido;
    private boolean campoDniValido;

    public ControladorFrmAltaTutor() {
    this.campoApellidoValido=false;
    this.campoDniValido=false;
    this.campoNombreValido=false;
    }
    /**
     * 
     * @param label 
     */
    public void ocultarLabellInformativo(JLabel label){
        label.setVisible(false);
    }
    /**
     * 
     * @param label 
     */
    public void mostrarLabellInformativo(JLabel label){
        label.setVisible(true);
    }
    /**
     * 
     * @param label
     * @param pathImagen 
     */
    public void agregarImagenEstadoLabel(JLabel label, String pathImagen){
        URL url = this.getClass().getResource(pathImagen);
        ImageIcon icon = new ImageIcon(url);
        label.setIcon(icon);
    }
    /**
     * 
     * @param frmTutorAlta
     * @return 
     */
    public boolean validarCamposAGrabar(FrmTutorCRUD frmTutorAlta){
        return (this.campoApellidoValido&&this.campoDniValido&&this.campoNombreValido);
    }

    /**
     * @return the campoNombreValido
     */
    public boolean isCampoNombreValido() {
        return campoNombreValido;
    }

    /**
     * @param campoNombreValido the campoNombreValido to set
     */
    public void setCampoNombreValido(boolean campoNombreValido) {
        this.campoNombreValido = campoNombreValido;
    }

    /**
     * @return the campoApellidoValido
     */
    public boolean isCampoApellidoValido() {
        return campoApellidoValido;
    }

    /**
     * @param campoApellidoValido the campoApellidoValido to set
     */
    public void setCampoApellidoValido(boolean campoApellidoValido) {
        this.campoApellidoValido = campoApellidoValido;
    }

    /**
     * @return the campoDniValido
     */
    public boolean isCampoDniValido() {
        return campoDniValido;
    }

    /**
     * @param campoDniValido the campoDniValido to set
     */
    public void setCampoDniValido(boolean campoDniValido) {
        this.campoDniValido = campoDniValido;
    }
}
