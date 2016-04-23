/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller.form;

import javax.swing.JButton;
import javax.swing.JComboBox;

/**
 *
 * @author wally86
 */
public class ControladorFrmNetPrincipal {
    
    public void ocultarBoton(JButton button) {
        button.setVisible(false);
    }
    public void mostrarBoton(JButton button) {
        button.setVisible(true);
    } 
    public void ocultarBotonRealizarOperacion(JButton button, String tipoVista){
        switch(tipoVista){
            case "Todas":
                ocultarBoton(button);
                break;
            case "Osciosas":
                ocultarBoton(button);
                break;
            case "En Servicio Tecnico":
                mostrarBoton(button);
                break;
            case "Pase":
                mostrarBoton(button);
                break;
            case "Migracion":
                mostrarBoton(button);
                break;
            case "Reasignadas":
                mostrarBoton(button);
                break;
        }
    }
    public String tipoVistaSeleccionado(JComboBox comboBox){
        String tipo ="";
        switch(String.valueOf(comboBox.getSelectedItem())){
            case "Todas":
                tipo="informeNetbook.jrxml";
                break;
            case "En Servicio Tecnico":
                tipo="informeNetbookServTec.jrxml";
                break;
            case "Reasignadas":
                tipo="informeNetReasignadas.jrxml";
                break;
            case "Osciosas":
                tipo="informeNetOsciosas.jrxml";
                break;
            case "Pase":
                tipo="informeNetPase.jrxml";
                break;
            case "Migracion":
                tipo="informeNetMifradas";
                break;
        }
        return tipo;
    }
}
