/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.image;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.border.Border;

/**
 *
 * @author wally86
 */
public class ImagenPanelUsuario implements Border{

    public BufferedImage back;

    public ImagenPanelUsuario() {
    try{
        URL imagePath = new URL(getClass().getResource("/modelo/imagen/sinFoto.jpg").toString());
        back=ImageIO.read(imagePath);
    }catch(Exception ex){
        
    }
    }
    
    @Override
    public Insets getBorderInsets(Component c) {
      return new Insets(0, 0, 0, 0);
    }

    @Override
    public boolean isBorderOpaque() {
return  false;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.drawImage(back, 0, 0, width,height,null);
    }
    
}
