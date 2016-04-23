/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller.form;

import vista.migrar.FrmMigrarCRUD;

/**
 *
 * @author wally86
 */
public class ControladorFrmMigrarPrincipal {
    
    public void deshabilitarCampos(FrmMigrarCRUD frmMigrarPrincipal){
        frmMigrarPrincipal.getTxtApellido().setEnabled(false);
        frmMigrarPrincipal.getTxtCurso().setEnabled(false);
        frmMigrarPrincipal.getTxtDivision().setEnabled(false);
        frmMigrarPrincipal.getTxtDni().setEnabled(false);
        frmMigrarPrincipal.getTxtNombre().setEnabled(false);
    }
}
