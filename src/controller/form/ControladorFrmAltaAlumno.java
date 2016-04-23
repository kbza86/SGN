/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.form;

import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import view.pupil.FrmAlumnoCRUD;


/**
 *
 * @author wally86
 */
public class ControladorFrmAltaAlumno {

    private boolean campoNombreEsValido;
    private boolean campoApellidoEsValido;
    private boolean campoDniEsValido;
    private boolean campoTutorEsValido;
    private boolean campoNetbookEsValido;
    private boolean campoDivisionValido;
    private boolean campoCursoValido;

    public ControladorFrmAltaAlumno() {
        this.campoApellidoEsValido = false;
        this.campoDniEsValido = false;
        this.campoNetbookEsValido = false;
        this.campoNombreEsValido = false;
        this.campoTutorEsValido = false;
        this.campoCursoValido=false;
        this.campoDivisionValido=false;
    }

    public void ocultarLabellInformativo(JLabel label) {
        label.setVisible(false);
    }

    public void mostrarLabellInformativo(JLabel label) {
        label.setVisible(true);
    }

    public void agregarImagenEstadoLabel(JLabel label, String pathImagen) {
        URL url = this.getClass().getResource(pathImagen);
        ImageIcon icon = new ImageIcon(url);
        label.setIcon(icon);
    }
    public void ocultarLabelInformativos(FrmAlumnoCRUD frmAlumnoAlta){
        ocultarLabellInformativo(frmAlumnoAlta.getLabelInfoApellidoAlumno());
        ocultarLabellInformativo(frmAlumnoAlta.getLabelInfoNombresAlumno());
        ocultarLabellInformativo(frmAlumnoAlta.getLabelInfoDniAlumno());
        ocultarLabellInformativo(frmAlumnoAlta.getLabelInfoDniTutor());
        ocultarLabellInformativo(frmAlumnoAlta.getLabelInfoSerieNetbook());
        ocultarLabellInformativo(frmAlumnoAlta.getLabelInfoApellidoTutor());
        ocultarLabellInformativo(frmAlumnoAlta.getLabelInfoNombresTutor());
        ocultarLabellInformativo(frmAlumnoAlta.getLabelInfoMarcaNetbook());
    }
    public boolean verificarCampos(FrmAlumnoCRUD frmAlumnoAlta) {

        String imagenCorrecta = "/model/image/si.png";
        String imagenIncorrecta = "/model/image/no.png";
        if (campoNombreEsValido) {
            setCampoNombreEsValido(true);
            agregarImagenEstadoLabel(frmAlumnoAlta.getLabelEstadoNombre(), imagenCorrecta);
        } else {
            agregarImagenEstadoLabel(frmAlumnoAlta.getLabelEstadoNombre(), imagenIncorrecta);
        }
        if (campoApellidoEsValido) {
            setCampoApellidoEsValido(true);
            agregarImagenEstadoLabel(frmAlumnoAlta.getLabelEstadoApellido(), imagenCorrecta);
        } else {
            agregarImagenEstadoLabel(frmAlumnoAlta.getLabelEstadoApellido(), imagenIncorrecta);
        }
        if (campoDniEsValido) {
            setCampoDniEsValido(true);
            agregarImagenEstadoLabel(frmAlumnoAlta.getLabelEstadoDni(), imagenCorrecta);
        } else {
            agregarImagenEstadoLabel(frmAlumnoAlta.getLabelEstadoDni(), imagenIncorrecta);
        }
        if (campoTutorEsValido) {
            setCampoTutorEsValido(campoTutorEsValido);
            agregarImagenEstadoLabel(frmAlumnoAlta.getLabelEstadoTutor(), imagenCorrecta);
        } else {
            agregarImagenEstadoLabel(frmAlumnoAlta.getLabelEstadoTutor(), imagenIncorrecta);
        }
        if (campoNetbookEsValido) {
            setCampoNetbookEsValido(true);
            agregarImagenEstadoLabel(frmAlumnoAlta.getLabelEstadoNetbook(), imagenCorrecta);
        } else {
            agregarImagenEstadoLabel(frmAlumnoAlta.getLabelEstadoNetbook(), imagenIncorrecta);
        }
        validarCmbCurso(frmAlumnoAlta.getCmbCurso());
        validarCmbDivision(frmAlumnoAlta.getCmbDivision());
        return (isCampoApellidoEsValido() 
                && isCampoDniEsValido() 
                && isCampoNetbookEsValido() 
                && isCampoNombreEsValido() 
                && isCampoTutorEsValido()
                && isCampoDivisionValido()
                && isCampoCursoValido());
    }
    public void validarCmbCurso(JComboBox cmbCurso){
        if(!String.valueOf(cmbCurso.getSelectedItem()).equals("Seleccione Curso")){
            setCampoCursoValido(true);
        }
    }
    public void validarCmbDivision(JComboBox cmbDivision){
        if(!String.valueOf(cmbDivision.getSelectedItem()).equals("Seleccione Division")){
            setCampoDivisionValido(true);
        }
    }
    public void verificarFocoObtenido(JTextField txtField, JLabel label){
        if(txtField.getText().isEmpty()){
            label.setIcon(null);
        }
    }
    public void deshabilitarBoton(JButton jButton){
        jButton.setEnabled(false);
    }
    public void habilitarBoton(JButton jButton){
        jButton.setEnabled(true);
    }
    public void deshabilitarComboBox(JComboBox comboBox){
        comboBox.setEnabled(false);
    }
        public void habilitarComboBox(JComboBox comboBox){
        comboBox.setEnabled(true);
    }
    public void ocultarBoton(JButton button){
        button.setVisible(false);
    }
    public void mostrarBoton(JButton button){
        button.setVisible(false);
    }
    public void deshabilitarCamposTxt(FrmAlumnoCRUD frmAlumnoAlta){
        deshabilitarCampoTxt(frmAlumnoAlta.getTxtDniAlumno());
        deshabilitarCampoTxt(frmAlumnoAlta.getTxtApellidoAlumno());
        deshabilitarCampoTxt(frmAlumnoAlta.getTxtNombreAlumno());
        deshabilitarCampoTxt(frmAlumnoAlta.getTxtTutor());
        deshabilitarCampoTxt(frmAlumnoAlta.getTxtApellidoTutor());
        deshabilitarCampoTxt(frmAlumnoAlta.getTxtNombresTutor());
        deshabilitarCampoTxt(frmAlumnoAlta.getTxtNetbook());
        deshabilitarCampoTxt(frmAlumnoAlta.getTxtIdHardNetbook());
        
    }
    public void deshabilitarComboBoxes(FrmAlumnoCRUD frmAlumnoCRUD){
        deshabilitarComboBox(frmAlumnoCRUD.getCmbCurso());
        deshabilitarComboBox(frmAlumnoCRUD.getCmbDivision());
        deshabilitarComboBox(frmAlumnoCRUD.getCmbEstado());
    }
    
    public void deshabilitarCamposNetbook(FrmAlumnoCRUD frmAlumnoAlta){
        deshabilitarBoton(frmAlumnoAlta.getBotonBuscarNetbook());
        deshabilitarCampoTxt(frmAlumnoAlta.getTxtNetbook());
        deshabilitarCampoTxt(frmAlumnoAlta.getTxtIdHardNetbook());
    }
    public void deshabilitarCampoTxt(JTextField textField){
        
        textField.setEditable(false);
    }
    public void habilitarCampoTxt(JTextField textField){
        
        textField.setEditable(true);
    }

    /**
     * @return the campoNombreEsValido
     */
    public boolean isCampoNombreEsValido() {
        return campoNombreEsValido;
    }

    /**
     * @param campoNombreEsValido the campoNombreEsValido to set
     */
    public void setCampoNombreEsValido(boolean campoNombreEsValido) {
        this.campoNombreEsValido = campoNombreEsValido;
    }

    /**
     * @return the campoApellidoEsValido
     */
    public boolean isCampoApellidoEsValido() {
        return campoApellidoEsValido;
    }

    /**
     * @param campoApellidoEsValido the campoApellidoEsValido to set
     */
    public void setCampoApellidoEsValido(boolean campoApellidoEsValido) {
        this.campoApellidoEsValido = campoApellidoEsValido;
    }

    /**
     * @return the campoDniEsValido
     */
    public boolean isCampoDniEsValido() {
        return campoDniEsValido;
    }

    /**
     * @param campoDniEsValido the campoDniEsValido to set
     */
    public void setCampoDniEsValido(boolean campoDniEsValido) {
        this.campoDniEsValido = campoDniEsValido;
    }

    /**
     * @return the campoTutorEsValido
     */
    public boolean isCampoTutorEsValido() {
        return campoTutorEsValido;
    }

    /**
     * @param campoTutorEsValido the campoTutorEsValido to set
     */
    public void setCampoTutorEsValido(boolean campoTutorEsValido) {
        this.campoTutorEsValido = campoTutorEsValido;
    }

    /**
     * @return the campoNetbookEsValido
     */
    public boolean isCampoNetbookEsValido() {
        return campoNetbookEsValido;
    }

    /**
     * @param campoNetbookEsValido the campoNetbookEsValido to set
     */
    public void setCampoNetbookEsValido(boolean campoNetbookEsValido) {
        this.campoNetbookEsValido = campoNetbookEsValido;
    }

    /**
     * @return the campoDivisionValido
     */
    public boolean isCampoDivisionValido() {
        return campoDivisionValido;
    }

    /**
     * @param campoDivisionValido the campoDivisionValido to set
     */
    public void setCampoDivisionValido(boolean campoDivisionValido) {
        this.campoDivisionValido = campoDivisionValido;
    }

    /**
     * @return the campoCursoValido
     */
    public boolean isCampoCursoValido() {
        return campoCursoValido;
    }

    /**
     * @param campoCursoValido the campoCursoValido to set
     */
    public void setCampoCursoValido(boolean campoCursoValido) {
        this.campoCursoValido = campoCursoValido;
    }
    
}
