/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DentalGest;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

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
  
    
    public controlPanel()
    {
        super("controlPanel");
        initComponents();
        conn= Db.db();
        AnimationStation();//movimento jframe undecorate
        
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

        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btn9 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        sfondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MascGest - Pannello di Controllo");
        setBackground(new java.awt.Color(0, 153, 255));
        setFont(new java.awt.Font("Arial Narrow", 0, 10)); // NOI18N
        setForeground(new java.awt.Color(0, 153, 255));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DentalGest/images/pulsanti/icona_chiudi_20x20.png"))); // NOI18N
        jLabel5.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel5.setAlignmentY(1.0F);
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 6, 20, 20));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DentalGest/images/pulsanti/icona_minimizza_20x20.png"))); // NOI18N
        jLabel3.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 6, 20, 20));

        btn9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DentalGest/images/pulsanti/icona_exit_130x130.png"))); // NOI18N
        btn9.setBorder(null);
        btn9.setContentAreaFilled(false);
        btn9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn9ActionPerformed(evt);
            }
        });
        getContentPane().add(btn9, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 240, -1, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DentalGest/images/pulsanti/icona_prestazioni_130x130.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 240, -1, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DentalGest/images/pulsanti/icona_appuntamenti_130x130.png"))); // NOI18N
        jButton2.setBorder(null);
        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 240, -1, -1));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DentalGest/images/pulsanti/icona_anagrafica_130x130.png"))); // NOI18N
        jButton5.setBorder(null);
        jButton5.setContentAreaFilled(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 240, -1, -1));

        sfondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DentalGest/images/main_700x400.png"))); // NOI18N
        sfondo.setText("jLabel1");
        getContentPane().add(sfondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -4, 700, 410));

        setSize(new java.awt.Dimension(699, 402));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        setExtendedState( JFrame.ICONIFIED );
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        try {
			
			Runtime.getRuntime().exec("cmd /C /MIN start C:/Database/bin/stopNetworkServer.bat");
                         Runtime.getRuntime().exec("taskkill /f /im cmd.exe") ;
		} catch (IOException ex) {
		}
        System.exit(1);

    }//GEN-LAST:event_jLabel5MouseClicked

    private void btn9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn9ActionPerformed
        // TODO add your handling code here:
         int x = JOptionPane.showConfirmDialog(null,"Sei sicuro di voler uscire dal programma?","Esci da DentalGest",JOptionPane.YES_NO_OPTION);
        if(x==0){
            
            System.exit(0);
            modifica_adesione.getObj().setVisible(false);
            Prestazioni.getObj().setVisible(false);
            Clients.getObj().setVisible(false);
            report.getObj().setVisible(false);
            dispose();
            
      }
        
    }//GEN-LAST:event_btn9ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         Prestazioni.getObj().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         AppList.getObj().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
      
       ClientiList.getObj().setVisible(true);
       
    }//GEN-LAST:event_jButton5ActionPerformed

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
    private javax.swing.JButton btn9;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel sfondo;
    // End of variables declaration//GEN-END:variables
}
