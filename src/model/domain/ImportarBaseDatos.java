/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.domain;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import view.database.FrmImportBD;

/**
 *
 * @author tisan
 */
public class ImportarBaseDatos {
 private String direccion;
private String host;
private String usuario;
private String password;
private String baseDato;
//private String formato;
private String puerto;
private FrmImportBD frmImportarBD;

    public ImportarBaseDatos(FrmImportBD frmImportarBD) {
        this.frmImportarBD=frmImportarBD;
        this.host="localhost";
        this.usuario="waltersaldia";
        this.password="walter";
        this.baseDato="conectarigualdad";
        //this.formato="custom";
        this.puerto="3306";
        this.direccion=frmImportarBD.getTxtRutaImportar().getText();
    }
    public void importarBaseDatos(){
         String comando = "C:\\Archivos de programa\\MySQL\\MySQL Server 5.6\\bin\\mysql.exe";
          Process process;
          try {
     process = Runtime
            .getRuntime()
            .exec(comando+ " -u"+usuario+ " -p"+password +" "+baseDato);
      OutputStream os =process.getOutputStream();
      
      FileInputStream fis = new FileInputStream(direccion);
      byte[] buffer = new byte[1000];
 
      int leido = fis.read(buffer);
      while (leido > 0) {
         os.write(buffer, 0, leido);
         leido = fis.read(buffer);
      }
      os.flush();
      os.close();
      fis.close();
 
   } catch (Exception e) {
           System.out.println(e);
   }
    }


}
