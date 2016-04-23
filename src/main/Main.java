/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import view.main.FrmPrincipal;

/**
 * Clase principal de SiGeNet donde se llama al formulari principal
 * @author walter saldia
 * @version 1.0
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Instancia el formulario princial
        FrmPrincipal frmPrincipal = new FrmPrincipal();
        frmPrincipal.setExtendedState(frmPrincipal.MAXIMIZED_BOTH);
        frmPrincipal.setVisible(true);
    }

}
