/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DentalGest;

import java.io.IOException;

/**
 *
 * @author Paolo
 */
public class DentalGest {

    /*
    
     * @param args the command line arguments
     */
    
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        try {
			
			Runtime.getRuntime().exec("cmd /C /MIN start C:/Database/bin/startNetworkServer.bat");
		} catch (Exception ex) {
		}
       
         controlPanel loa = new controlPanel();
        loa.setVisible(true);
        
        
        
       
    }
    
}
