/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DentalGest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Paolo
 */
public class Db {
    public static Connection db(){
    
  
//Connessione di test    

  String dburl = "jdbc:derby://localhost:1527/dentalsoft";
//Connessione al server locale
  // String dburl = "jdbc:derby:/Database/bin/dentalsoft";
    String userName = "dentalsoft";
    String passWord = "5y*Ym0HsbWyO";
     
   
      try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection conn =null;
            conn = DriverManager.getConnection(dburl, userName, passWord);
            
            return conn;
        }
    
    catch(ClassNotFoundException | SQLException e)
    {
        JOptionPane.showMessageDialog(null,e);
        return null;
    }
    
}
}
