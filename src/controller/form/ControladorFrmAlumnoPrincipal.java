/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller.form;

import javax.swing.JComboBox;

/**
 *
 * @author tisan
 */
public class ControladorFrmAlumnoPrincipal {

    public ControladorFrmAlumnoPrincipal() {
    }
     public String tipoVistaSeleccionado(JComboBox comboBox){
        String tipo ="";
        switch(String.valueOf(comboBox.getSelectedItem())){
            case "Todos":
                tipo="informeAlumnosConNet.jrxml";
                break;
            case "Regulares":
                tipo="informeAlumnosRegulares.jrxml";
                break;
            case "Abandonan con Equipo":
                tipo="informeAlumnosAbandonanConNet.jrxml";
                break;
            case "Abandonan sin Equipo":
                tipo="informeAlumnosAbandonanSinNet.jrxml";
                break;
            case "Egresados a Recibir":
                tipo="infoAluEgresadosARecibir.jrxml";
                break;
            case "Egresados con Equipo":
                tipo="infoAluEgresadosConEquipo.jrxml";
                break;
            case "Egresados no corresponde Equipo":
                tipo="infoAluEgresadosNoCorrespNet.jrxml";
                break;
        }
        return tipo;
    }
}
