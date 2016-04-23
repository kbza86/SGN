/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.domain;

import java.io.FileOutputStream;
import java.io.InputStream;
import javax.swing.JOptionPane;
import view.database.FrmExportBD;

/**
 *
 * @author tisan
 */
public class ExportarBaseDatos {
private String direccion;
private String host;
private String usuario;
private String password;
private String baseDato;
private String formato;
private String puerto;
private FrmExportBD frmExportarBD;    
    public ExportarBaseDatos(FrmExportBD frmExportarBD){
        this.frmExportarBD=frmExportarBD;
        this.host="localhost";
        this.usuario="waltersaldia";
        this.password="walter";
        this.baseDato="conectarigualdad";
        this.formato="custom";
        this.puerto="3306";
        this.direccion=frmExportarBD.getTxtRutaExportacion().getText();
                
    }
    public void ExportarBaseDatos(){
        String comando = "C:\\Archivos de programa\\MySQL\\MySQL Server 5.6\\bin\\mysqldump.exe";
        String command2 = "C:\\Program Files\\MySQL\\MySQL Server 5.6\\bin\\mysqldump.exe";
        Process process;
       try {
           process = null;
           try{
     process = Runtime
            .getRuntime()
            .exec(comando+ " -u"+usuario+ " -p"+password +" "+baseDato);
           }catch(Exception e2)
           {
                process = Runtime
            .getRuntime()
            .exec(command2+ " -u"+usuario+ " -p"+password +" "+baseDato);
           }
      InputStream is = process.getInputStream();
      FileOutputStream fos = new FileOutputStream(direccion);
      byte[] buffer = new byte[1000];
 
      int leido = is.read(buffer);
      while (leido > 0) {
         fos.write(buffer, 0, leido);
         leido = is.read(buffer);
      }
 
      fos.close();
 
   } catch (Exception e) {
           System.out.println(e);
   }
    }
}
