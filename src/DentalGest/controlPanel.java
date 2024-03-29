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
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author Paolo
 */
public class controlPanel extends javax.swing.JFrame {

    /**
     * Creates new form controlPanel
     */
   Connection conn;
    ResultSet rs;
    PreparedStatement pst;
    String value;
    String lettera;
    Connection conn1;
    

    public controlPanel() throws SQLException {
        super("controlPanel");
        this.conn = null;
        this.rs = null;
        this.pst = null;
        this.value = oper.userN;
        this.lettera = null;
        this.conn1 = null;
        this.initComponents();
        this.conn = Db.db();
        this.conn1 = Db.db();
        this.AnimationStation();
        final String directory = System.getProperty("user.dir");
        final String[] pathDir = directory.split(":");
        this.lettera = pathDir[0];
        System.out.println("Working Directory = " + this.lettera);
        this.lettera_txt.setText(this.lettera);
        System.out.println(this.lettera + ":/dentalgest/cartelle/");
        System.out.println("Lettera: " + this.lettera_txt.getText());
        this.setupDb();
    }
    
    private void setupDb() {
        final String tb1 = "CREATE TABLE  CARTELLA (PAZIENTE VARCHAR(255) NOT NULL, PATH VARCHAR(255) NOT NULL, NOME VARCHAR(255) NOT NULL, CELL VARCHAR(255) NOT NULL)";
        final String tb2 = "CREATE TABLE  CEMENTAZIONE (CLIENTE VARCHAR(255) NOT NULL, DATANASCITA VARCHAR(255) NOT NULL, TIPOLOGIA VARCHAR(255) NOT NULL, \"DATA\" DATE NOT NULL, NOTA LONG VARCHAR DEFAULT ''  NOT NULL)";
        final String tb3 = "CREATE TABLE  OPERATORI (NOME VARCHAR(255) NOT NULL)";
        final String tb4 = "CREATE TABLE  PAZIENTI (NOME VARCHAR(255) NOT NULL, COGNOME VARCHAR(255) NOT NULL, CODICE_FISCALE VARCHAR(255) NOT NULL, CELL VARCHAR(255) NOT NULL, DATANASCITA VARCHAR(25) DEFAULT ''  NOT NULL, STATO VARCHAR(25) DEFAULT ''  NOT NULL, ID VARCHAR(255) NOT NULL, TAG VARCHAR(6))";
        final String tb5 = "CREATE TABLE  PRESTAZIONE_CLIENTE (ID VARCHAR(255) NOT NULL, NOME VARCHAR(255) NOT NULL, CLIENTE VARCHAR(255) NOT NULL, ACCONTO VARCHAR(255) NOT NULL, RESTO VARCHAR(255) NOT NULL, PREZZO VARCHAR(255) NOT NULL, DENTE INTEGER NOT NULL, DATAORA VARCHAR(255) NOT NULL, TIPO VARCHAR(255) NOT NULL, NOTA LONG VARCHAR NOT NULL, CELL VARCHAR(255) NOT NULL)";
        final String tb6 = "CREATE TABLE  PRESTAZIONI (NOME VARCHAR(255) NOT NULL, PREZZO VARCHAR(10) NOT NULL, DENTE BOOLEAN NOT NULL)";
        final String tb7 = "CREATE TABLE  RICHIAMI (CLIENTE VARCHAR(255) NOT NULL, DATANASCITA VARCHAR(255) NOT NULL, INTERVENTO VARCHAR(255) NOT NULL, \"DATA\" DATE NOT NULL)";
        final String tb8 = "CREATE TABLE  STORICO_ACC (CLIENTE VARCHAR(255) NOT NULL, NOME VARCHAR(255) NOT NULL, DATAORA VARCHAR(255) NOT NULL, ACCONTO VARCHAR(255) NOT NULL, DENTE VARCHAR(255) NOT NULL, ID VARCHAR(255) NOT NULL, CELL VARCHAR(255) NOT NULL)";
        try {
            final Statement s = this.conn1.createStatement();
            try {
                s.execute(tb1);
                System.out.println("Colonna CARTELLA aggiunta");
            }
            catch (SQLException ex) {
                System.out.println("Colonne CARTELLA gi\u00e0 presente");
            }
            try {
                s.execute(tb2);
                System.out.println("Colonna CEMENTAZIONE aggiunta");
            }
            catch (SQLException ex) {
                System.out.println("Colonne CEMENTAZIONE gi\u00e0 presente");
            }
            try {
                s.execute(tb3);
                System.out.println("Colonna OPERATORI aggiunta");
            }
            catch (SQLException ex) {
                System.out.println("Colonne OPERATORI gi\u00e0 presente");
            }
            try {
                s.execute(tb4);
                System.out.println("Colonna PAZIENTI aggiunta");
            }
            catch (SQLException ex) {
                System.out.println("Colonne PAZIENTI gi\u00e0 presente");
            }
            try {
                s.execute(tb5);
                System.out.println("Colonna PRESTAZIONE_CLIENTE aggiunta");
            }
            catch (SQLException ex) {
                System.out.println("Colonne PRESTAZIONE_CLIENTE gi\u00e0 presente");
            }
            try {
                s.execute(tb6);
                System.out.println("Colonna PRESTAZIONI aggiunta");
            }
            catch (SQLException ex) {
                System.out.println("Colonne PRESTAZIONI gi\u00e0 presente");
            }
            try {
                s.execute(tb7);
                System.out.println("Colonna RICHIAMI aggiunta");
            }
            catch (SQLException ex) {
                System.out.println("Colonne RICHIAMI gi\u00e0 presente");
            }
            try {
                s.execute(tb8);
                System.out.println("Colonna STORICO_ACC aggiunta");
            }
            catch (SQLException ex) {
                System.out.println("Colonne STORICO_ACC gi\u00e0 presente");
            }
        }
        catch (SQLException ex) {
            System.out.println("Colonne gi\u00e0 presente");
        }
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
        jButton9 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

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
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 240, -1, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DentalGest/images/pulsanti/icona_appuntamenti_130x130.png"))); // NOI18N
        jButton2.setBorder(null);
        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 240, -1, -1));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DentalGest/images/pulsanti/icona_anagrafica_130x130.png"))); // NOI18N
        jButton5.setBorder(null);
        jButton5.setContentAreaFilled(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DentalGest/images/pulsanti/richiamo_130x130.png"))); // NOI18N
        jButton3.setBorder(null);
        jButton3.setContentAreaFilled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 240, -1, -1));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DentalGest/images/pulsanti/cementazione_130x130.png"))); // NOI18N
        jButton4.setBorder(null);
        jButton4.setContentAreaFilled(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 240, -1, -1));

        lettera_txt.setEditable(false);
        lettera_txt.setBorder(null);
        lettera_txt.setEnabled(false);
        getContentPane().add(lettera_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 0, -1));

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DentalGest/images/pulsanti/contabilità_130x130.png"))); // NOI18N
        jButton6.setBorder(null);
        jButton6.setContentAreaFilled(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, -1, -1));

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DentalGest/images/pulsanti/icona_chiudi_20x20.png"))); // NOI18N
        jButton7.setBorder(null);
        jButton7.setBorderPainted(false);
        jButton7.setContentAreaFilled(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 5, 20, 20));

        jButton9.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DentalGest/images/pulsanti/backup-40x40.png"))); // NOI18N
        jButton9.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton9.setBorderPainted(false);
        jButton9.setContentAreaFilled(false);
        jButton9.setFocusPainted(false);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 40, 40));

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DentalGest/images/pulsanti/operatori_130x130.png"))); // NOI18N
        jButton8.setBorder(null);
        jButton8.setContentAreaFilled(false);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 110, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DentalGest/images/main_800x400.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, -1));

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
        CalendarGUI calendarGUI = new CalendarGUI();
        /*datelook199.DateLook dl = new datelook199.DateLook();
        dl.setIconImage(Toolkit.getDefaultToolkit().getImage("/dentalgest/icona.png"));
        dl.setVisible(true);*/
        
         

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

        System.exit(0);

    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:

        JFileChooser chooser = new JFileChooser();
        //chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle("Salva Database");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        //
        // disable the "All files" option.
        //
        chooser.setAcceptAllFileFilterUsed(false);
        //    
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            System.out.println("getCurrentDirectory(): "
                    + chooser.getCurrentDirectory());
            System.out.println("getSelectedFile() : "
                    + chooser.getSelectedFile());
            
             DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                LocalDateTime now = LocalDateTime.now();
                System.out.println(dtf.format(now));
                long millis = System.currentTimeMillis();
                Date date = new Date(millis);

                String adesso = dtf.format(now);

            try {
                File f = new File(chooser.getSelectedFile()+"/BackUpDG-"+adesso);

                // check if the directory can be created
                // using the abstract path name
                if (f.mkdir()) {

                    // display that the directory is created
                    // as the function returned true
                    System.out.println("Directory creata");
                } else {
                    // display that the directory cannot be created
                    // as the function returned false
                    System.out.println("Directory non creata");
                }

                File sourceDirectory = new File(lettera + ":/Database/bin/dentalsoft");
                File sourceDirectoryD = new File(lettera + ":/Dentalgest");
                File destinationDirectory = new File( f + "/Database/bin/dentalsoft");
                File destinationDirectoryD = new File( f + "/dentalgest");

                FileUtils.copyDirectory(sourceDirectoryD, destinationDirectoryD);
                FileUtils.copyDirectory(sourceDirectory, destinationDirectory);
                Runtime.getRuntime().exec("taskkill /f /im cmd.exe");

            } catch (IOException ex) {
            }
        } else {
            System.out.println("Directory non selezionata ");
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
         Operatori.getObj().setIconImage(Toolkit.getDefaultToolkit().getImage("/dentalgest/icona.png"));
        Operatori.getObj().setVisible(true);
    }//GEN-LAST:event_jButton8ActionPerformed

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
                try {
                    new controlPanel().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(controlPanel.class.getName()).log(Level.SEVERE, null, ex);
                }

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
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    public javax.swing.JTextField lettera_txt;
    // End of variables declaration//GEN-END:variables
}
