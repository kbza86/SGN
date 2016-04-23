/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test.informe;

import antlr.Utils;
import java.io.File;
import java.sql.SQLException;
import model.report.Informe;

/**
 *
 * @author tisan
 */
public class TestInformeReport {
    public static void main(String[] args) throws SQLException {
        
        
        String path = System.getProperty("user.dir")+"\\src\\modelo\\informe\\informeNetbook.jrxml";
        File file = new File(path);
        if(file.isFile()){
        System.out.println(file.getAbsolutePath());
        }
        
    }
}
