/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DentalGest;

import GUI.CalendarGUI;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.swing.JFrame;
import org.apache.commons.io.FileUtils;
/**
 *
 * @author Paolo
 */
public class controlPanel extends javax.swing.JFrame {

    /**
     * Creates new form controlPanel
     */
    Connection conn=null;
ResultSet rs=null;
PreparedStatement pst=null;
String value=oper.userN; 
String lettera = null;
  
    
    public controlPanel()
    {
        super("controlPanel");
        initComponents();
        conn= Db.db();
        AnimationStation();//movimento jframe undecorate
        String directory = System.getProperty("user.dir");
        String[] pathDir = directory.split(":");
         lettera= pathDir[0];
        System.out.println("Working Directory = " + lettera);
        lettera_txt.setText(lettera);
        System.out.println(lettera+":/dentalgest/cartelle/");
        System.out.println("Lettera: "+lettera_txt.getText());
    }
    
  
    
    private void AnimationStation() {
    MouseAdapter ma = new MouseAdapter() {
        int lastX, lastY;
   
        @Override
        public void mousePressed(MouseEvent e) {
            lastX = e.getXOnScreen();
            lastY = e.getYOnScreen();
        }
        
        @Override
        public void mouseDragged(MouseEvent e) {
            int x = e.getXOnScreen();
            int y = e.getYOnScreen();
            // Move frame by the mouse delta
            setLocation(getLocationOnScreen().x + x - lastX,
                    getLocationOnScreen().y + y - lastY);
            lastX = x;
            lastY = y;
        }
    };
    addMouseListener(ma);
    addMouseMotionListener(ma);
}
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        lettera_txt = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        sfondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dentalgest - Pannello di Controllo");
        setBackground(new java.awt.Color(0, 153, 255));
        setFont(new java.awt.Font("Arial Narrow", 0, 10)); // NOI18N
        setForeground(new java.awt.Color(0, 153, 255));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DentalGest/images/pulsanti/icona_prestazioni_130x130.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 240, -1, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DentalGest/images/pulsanti/icona_appuntamenti_130x130.png"))); // NOI18N
        jButton2.setBorder(null);
        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 240, -1, -1));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DentalGest/images/pulsanti/icona_anagrafica_130x130.png"))); // NOI18N
        jButton5.setBorder(null);
        jButton5.setContentAreaFilled(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, -1, -1));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DentalGest/images/pulsanti/richiamo_130x130.png"))); // NOI18N
        jButton3.setBorder(null);
        jButton3.setContentAreaFilled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 240, -1, -1));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DentalGest/images/pulsanti/cementazione_130x130.png"))); // NOI18N
        jButton4.setBorder(null);
        jButton4.setContentAreaFilled(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 240, -1, -1));

        lettera_txt.setEditable(false);
        lettera_txt.setBorder(null);
        lettera_txt.setEnabled(false);
        lettera_txt.setOpaque(false);
        getContentPane().add(lettera_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 0, -1));

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DentalGest/images/pulsanti/contabilità_130x130.png"))); // NOI18N
        jButton6.setBorder(null);
        jButton6.setContentAreaFilled(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, -1, -1));

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DentalGest/images/pulsanti/icona_chiudi_20x20.png"))); // NOI18N
        jButton7.setBorder(null);
        jButton7.setBorderPainted(false);
        jButton7.setContentAreaFilled(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 0, 20, -1));

        sfondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DentalGest/images/main_800x400.png"))); // NOI18N
        getContentPane().add(sfondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 800, 420));

        setSize(new java.awt.Dimension(800, 402));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
  
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Prestazioni.getObj().setIconImage(Toolkit.getDefaultToolkit().getImage("/dentalgest/icona.png")); 
         Prestazioni.getObj().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
//        AppList.getObj().setIconImage(Toolkit.getDefaultToolkit().getImage("/dentalgest/icona.png")); 
//         AppList.getObj().setVisible(true);
        
    new CalendarGUI();
    
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
     ClientiList.getObj().setIconImage(Toolkit.getDefaultToolkit().getImage("/dentalgest/icona.png")); 
       ClientiList.getObj().setVisible(true);
       
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        Richiami.getObj().setIconImage(Toolkit.getDefaultToolkit().getImage("/dentalgest/icona.png")); 
        Richiami.getObj().PopulateData();
        Richiami.getObj().setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        Cenentazione.getObj().setIconImage(Toolkit.getDefaultToolkit().getImage("/dentalgest/icona.png")); 
        Cenentazione.getObj().setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        
        Saldi.getObj().setIconImage(Toolkit.getDefaultToolkit().getImage("/dentalgest/icona.png")); 
        Saldi.getObj().PopulateData();
        Saldi.getObj().setVisible(true);
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        
         DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");  
   LocalDateTime now = LocalDateTime.now();  
   System.out.println(dtf.format(now));  
   long millis=System.currentTimeMillis();  
Date date=new Date(millis);  
 
           String adesso = dtf.format(now);
        
        try {
           File f = new File("c:/BackupDG");
  
        // check if the directory can be created
        // using the abstract path name
        if (f.mkdir()) {
  
            // display that the directory is created
            // as the function returned true
            System.out.println("Directory creata");
        }
        else {
            // display that the directory cannot be created
            // as the function returned false
            System.out.println("Directory non creata");
        }   
                                  File sourceDirectory = new File(lettera+":/Database/bin/dentalsoft");
        File destinationDirectory = new File("c:/BackupDG/dentalsoftdb-"+adesso);
        
//        File sourceDirectoryD = new File(lettera+":/Dentalgest");
//        File destinationDirectoryD = new File("c:/BackupDG/dentalgest");

//        FileUtils.copyDirectory(sourceDirectoryD, destinationDirectoryD);  
         FileUtils.copyDirectory(sourceDirectory, destinationDirectory);  
                         Runtime.getRuntime().exec("taskkill /f /im cmd.exe") ;
                          
		} catch (IOException ex) {
		}
        System.exit(0);

    }//GEN-LAST:event_jButton7ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(controlPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(controlPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(controlPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(controlPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new controlPanel().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    public javax.swing.JTextField lettera_txt;
    private javax.swing.JLabel sfondo;
    // End of variables declaration//GEN-END:variables
}
