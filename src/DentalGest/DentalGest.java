/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DentalGest;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author Paolo
 */
public class DentalGest {

    /*
    
     * @param args the command line arguments
     */
    
    public static void main(String[] args) throws IOException, SQLException {
        // TODO code application logic here
        try {
			
			Runtime.getRuntime().exec("cmd /C /MIN start C:/Database/bin/startNetworkServer.bat");
		} catch (IOException ex) {
		}
       
         controlPanel loa = new controlPanel();
         //Image image = new ImageIcon("/dentalgest/icona.ico").getImage();

        loa.setIconImage(Toolkit.getDefaultToolkit().getImage("/dentalgest/icona.png")); 
        loa.setVisible(true);
       
        
        
       
    }
    
}
