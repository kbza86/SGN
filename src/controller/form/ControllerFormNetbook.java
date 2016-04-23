/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller.form;

import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import view.netbook.FrmNetbookCRUD;

/**
 *
 * @author wally86
 */
public class ControllerFormNetbook {
    
    public void ocultarLabelInfo(JLabel label){
        label.setVisible(false);
    }
    public void mostrarLabelInfo(JLabel label){
        label.setVisible(true);
    }
    public boolean verificarCampos(FrmNetbookCRUD frmNetbookAlta){
        boolean numeroSerieEsValido=false;
        boolean modeloEsValido=false;
        boolean marcaEsvalido=false;        
        String imagenCorrecta="/model/image/si.png";
        String imagenIncorrecta="/model/image/no.png";
        if(!frmNetbookAlta.getTxtWindowsKey().getText().isEmpty() &&
                (frmNetbookAlta.getTxtWindowsKey().getText().length()==25)){
             agregarEstadoLabel(frmNetbookAlta.getLblEstadoWinKey(), imagenCorrecta);
        }
        if(!frmNetbookAlta.getTxtOfficeKey().getText().isEmpty() &&
                (frmNetbookAlta.getTxtOfficeKey().getText().length()==25)){
             agregarEstadoLabel(frmNetbookAlta.getLblEstadoWinKey(), imagenCorrecta);
        }
        if(!frmNetbookAlta.getTxtNumeroSerie().getText().isEmpty() && 
                (frmNetbookAlta.getTxtNumeroSerie().getText().length()<=15 )){
            numeroSerieEsValido=true;
            agregarEstadoLabel(frmNetbookAlta.getLblEstadoNumeroSerie(), imagenCorrecta);
        }else{
            agregarEstadoLabel(frmNetbookAlta.getLblEstadoNumeroSerie(), imagenIncorrecta);
        }
        if(!frmNetbookAlta.getTxtModelo().getText().isEmpty()){
            modeloEsValido=true;
            agregarEstadoLabel(frmNetbookAlta.getLblEstadoModelo(), imagenCorrecta);
        }else{
            agregarEstadoLabel(frmNetbookAlta.getLblEstadoModelo(), imagenIncorrecta);
        }
        if(!frmNetbookAlta.getTxtMarca().getText().isEmpty()){
            marcaEsvalido=true;
            agregarEstadoLabel(frmNetbookAlta.getLblEstadoMarca(), imagenCorrecta);
        }else{
            agregarEstadoLabel(frmNetbookAlta.getLblEstadoMarca(), imagenIncorrecta);
        }
        return (numeroSerieEsValido&&marcaEsvalido&&modeloEsValido);
    }
    public void agregarEstadoLabel(JLabel label, String pathImagen){
        URL url = this.getClass().getResource(pathImagen);
        ImageIcon icon = new ImageIcon(url);
        label.setIcon(icon);
    }
    public boolean ingresaKeyActivador(String key){
        boolean esValido=false;
        try{
        if(key.length()==25 || key.length()==8){
            esValido=true;
        }
        }catch(NullPointerException ex){
            return esValido;
        }
        return esValido;
    }
}
