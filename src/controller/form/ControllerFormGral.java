/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.form;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

/**
 *
 * @author wally86
 */
public class ControllerFormGral {

    public void deshabilitarMenu(JMenu menu) {
        menu.setEnabled(false);
    }

    public void deshabilitarMenuItem(JMenuItem menuItem) {
        menuItem.setEnabled(false);
    }

    public void habilitarMenu(JMenu menu) {
        menu.setEnabled(true);
    }

    public void habilitarMenuItem(JMenuItem menuItem) {
        menuItem.setEnabled(true);
    }

    public void habilitarJTextFiel(JTextField textField) {
        textField.setEnabled(true);
    }

    public void deshabilitarJTextFiel(JTextField textField) {
        textField.setEnabled(false);
    }
}
