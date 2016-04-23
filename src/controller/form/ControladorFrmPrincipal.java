/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller.form;

import vista.migrar.FrmMigrarCRUD;
import view.netbook.FrmNetbookMain;
import view.main.FrmPrincipal;
import view.teacher.FrmProfesorPrincipal;
import view.user.FrmUser;

/**
 *
 * @author wally86
 */
public class ControladorFrmPrincipal {
    
    public FrmUser getFrmUsuario(FrmPrincipal principal){
        FrmUser frmUsuario = null;
        boolean encontrado = false;
            for(int i=0 ;i< principal.getJDesktopPane().getComponentCount() && encontrado!=true;i++ ){
                try{
                frmUsuario = (FrmUser) principal.getJDesktopPane().getComponent(i);
                encontrado=true;
                }catch(Exception ex){
                    
                }
                
                
            }
        return frmUsuario;
        
    }
    public FrmMigrarCRUD getFrmMigrarPrincipal(FrmPrincipal principal){
        FrmMigrarCRUD frmMigrarPrincipal = null;
        boolean encontrado = false;
            for(int i=0 ;i< principal.getJDesktopPane().getComponentCount() && encontrado!=true;i++ ){
                try{
                frmMigrarPrincipal = (FrmMigrarCRUD) principal.getJDesktopPane().getComponent(i);
                encontrado=true;
                }catch(Exception ex){
                    
                }
                
                
            }
        return frmMigrarPrincipal;
        
    }
    
    public FrmNetbookMain getFrmNetbookPrincipal(FrmPrincipal principal){
        FrmNetbookMain frmNetbookPrincipal = null;
        boolean encontrado = false;
            for(int i=0 ;i< principal.getJDesktopPane().getComponentCount() && encontrado!=true;i++ ){
                try{
                frmNetbookPrincipal = (FrmNetbookMain) principal.getJDesktopPane().getComponent(i);
                encontrado=true;
                }catch(Exception ex){
                    
                }
                
                
            }
        return frmNetbookPrincipal;
        
    }
    
    public FrmProfesorPrincipal getFrmProfesorPrincipal(FrmPrincipal principal){
        FrmProfesorPrincipal frmProfesorPrincipal = null;
        boolean encontrado = false;
            for(int i=0 ;i< principal.getJDesktopPane().getComponentCount() && encontrado!=true;i++ ){
                try{
                frmProfesorPrincipal = (FrmProfesorPrincipal) principal.getJDesktopPane().getComponent(i);
                encontrado=true;
                }catch(Exception ex){
                    
                }               
            }
        return frmProfesorPrincipal;
    }
    

}
