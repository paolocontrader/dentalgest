/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DentalGest;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author niuzz
 */
public class Dentiera extends javax.swing.JFrame {
    String dataora = null;
    Connection conn = null;
    PreparedStatement pst = null;
    private static Dentiera obj=null;
    int dente_check = 0;
    public static Dentiera getObj(){
        if(obj==null){
            obj=new Dentiera();
            
          
        }return obj;
    }

    
    /**
     * Creates new form dentiera
     */
    public Dentiera() {
        initComponents();
        AnimationStation();
        conn = Db.db();
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

        check11 = new javax.swing.JCheckBox();
        check12 = new javax.swing.JCheckBox();
        check13 = new javax.swing.JCheckBox();
        check14 = new javax.swing.JCheckBox();
        check15 = new javax.swing.JCheckBox();
        check16 = new javax.swing.JCheckBox();
        check17 = new javax.swing.JCheckBox();
        check18 = new javax.swing.JCheckBox();
        check21 = new javax.swing.JCheckBox();
        check22 = new javax.swing.JCheckBox();
        check23 = new javax.swing.JCheckBox();
        check24 = new javax.swing.JCheckBox();
        check25 = new javax.swing.JCheckBox();
        check26 = new javax.swing.JCheckBox();
        check27 = new javax.swing.JCheckBox();
        check28 = new javax.swing.JCheckBox();
        check38 = new javax.swing.JCheckBox();
        check37 = new javax.swing.JCheckBox();
        check36 = new javax.swing.JCheckBox();
        check35 = new javax.swing.JCheckBox();
        check34 = new javax.swing.JCheckBox();
        check33 = new javax.swing.JCheckBox();
        check32 = new javax.swing.JCheckBox();
        check31 = new javax.swing.JCheckBox();
        check41 = new javax.swing.JCheckBox();
        check42 = new javax.swing.JCheckBox();
        check43 = new javax.swing.JCheckBox();
        check44 = new javax.swing.JCheckBox();
        check45 = new javax.swing.JCheckBox();
        check46 = new javax.swing.JCheckBox();
        check47 = new javax.swing.JCheckBox();
        check48 = new javax.swing.JCheckBox();
        sceltabnt = new javax.swing.JButton();
        sfondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(check11, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, -1, -1));
        getContentPane().add(check12, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, -1, -1));

        check13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check13ActionPerformed(evt);
            }
        });
        getContentPane().add(check13, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, -1, -1));
        getContentPane().add(check14, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, -1, -1));
        getContentPane().add(check15, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, -1, -1));
        getContentPane().add(check16, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, -1, -1));
        getContentPane().add(check17, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, -1, -1));
        getContentPane().add(check18, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, -1, -1));

        check21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check21ActionPerformed(evt);
            }
        });
        getContentPane().add(check21, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 30, -1, -1));
        getContentPane().add(check22, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 60, -1, -1));
        getContentPane().add(check23, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 80, -1, -1));
        getContentPane().add(check24, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 110, -1, -1));
        getContentPane().add(check25, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 150, -1, -1));
        getContentPane().add(check26, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 200, -1, -1));
        getContentPane().add(check27, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 250, -1, -1));

        check28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check28ActionPerformed(evt);
            }
        });
        getContentPane().add(check28, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 300, -1, -1));
        getContentPane().add(check38, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 360, -1, -1));
        getContentPane().add(check37, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 410, -1, -1));

        check36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check36ActionPerformed(evt);
            }
        });
        getContentPane().add(check36, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 460, -1, -1));
        getContentPane().add(check35, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 510, -1, -1));
        getContentPane().add(check34, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 550, -1, -1));
        getContentPane().add(check33, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 580, -1, -1));
        getContentPane().add(check32, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 600, -1, -1));
        getContentPane().add(check31, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 630, -1, -1));
        getContentPane().add(check41, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 630, -1, -1));
        getContentPane().add(check42, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 600, -1, -1));
        getContentPane().add(check43, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 580, -1, -1));
        getContentPane().add(check44, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 550, -1, -1));
        getContentPane().add(check45, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 510, -1, -1));
        getContentPane().add(check46, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 460, -1, -1));
        getContentPane().add(check47, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 410, -1, -1));
        getContentPane().add(check48, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 360, -1, -1));

        sceltabnt.setText("Scegli");
        sceltabnt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sceltabntActionPerformed(evt);
            }
        });
        getContentPane().add(sceltabnt, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 670, -1, -1));

        sfondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DentalGest/images/schema-denti_440_630.png"))); // NOI18N
        getContentPane().add(sfondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 560, 620));

        setSize(new java.awt.Dimension(598, 723));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void check36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check36ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_check36ActionPerformed

    private void check28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check28ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_check28ActionPerformed

    private void sceltabntActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sceltabntActionPerformed
                                                 
            // TODO add your handling code here:
            
            if (check11.isSelected()) {
                dente_check = 11;
            }
            if (check12.isSelected()) {
                dente_check = 12;
            }
            if (check13.isSelected()) {
                dente_check = 13;
            }
            if (check14.isSelected()) {
                dente_check = 14;
            }
            if (check15.isSelected()) {
                dente_check = 15;
            }
            if (check16.isSelected()) {
                dente_check = 16;
            }
            if (check17.isSelected()) {
                dente_check = 17;
            }
            if (check18.isSelected()) {
                dente_check = 18;
            }
            if (check21.isSelected()) {
                dente_check = 21;
            }
            if (check22.isSelected()) {
                dente_check = 22;
            }
            if (check23.isSelected()) {
                dente_check = 23;
            }
            if (check24.isSelected()) {
                dente_check = 24;
            }
            if (check25.isSelected()) {
                dente_check = 25;
            }
            if (check26.isSelected()) {
                dente_check = 26;
            }
            if (check27.isSelected()) {
                dente_check = 27;
            }
            if (check28.isSelected()) {
                dente_check = 28;
            }
            if (check31.isSelected()) {
                dente_check = 31;
            }
            if (check32.isSelected()) {
                dente_check = 32;
            }
            if (check33.isSelected()) {
                dente_check = 33;
            }
            if (check34.isSelected()) {
                dente_check = 34;
            }
            if (check35.isSelected()) {
                dente_check = 35;
            }
            if (check36.isSelected()) {
                dente_check = 36;
            }
            if (check37.isSelected()) {
                dente_check = 37;
            }
            if (check38.isSelected()) {
                dente_check = 38;
            }
            if (check41.isSelected()) {
                dente_check = 41;
            }
            if (check42.isSelected()) {
                dente_check = 42;
            }
            if (check43.isSelected()) {
                dente_check = 43;
            }
            if (check44.isSelected()) {
                dente_check = 44;
            }
            if (check45.isSelected()) {
                dente_check = 45;
            }
            if (check46.isSelected()) {
                dente_check = 46;
            }
            if (check47.isSelected()) {
                dente_check = 47;
            }
            if (check48.isSelected()) {
                dente_check = 48;
            }
             System.out.println("Dente scelto: "+dente_check);
            try {
           
            String sql="insert into prestazione_cliente (id,nome,cliente,acconto,resto,prezzo,dente,dataora,tipo) values (?,?,?,?,?,?,?,?,?)";
            try {
                pst=conn.prepareStatement(sql);
            } catch (SQLException ex) {
                Logger.getLogger(Dentiera.class.getName()).log(Level.SEVERE, null, ex);
            }
            Random rand = new Random(); //instance of random class
            dataora =  DateTimeFormatter.ofPattern("dd-MM-yyyy").format(LocalDateTime.now());
            int upperbound = 9999;
            int int_random = rand.nextInt(upperbound);
            String id = String.valueOf(int_random);
           
                pst.setString(1,id);
           
            pst.setString(2,Clients.getObj().servizio);
            pst.setString(3,Clients.getObj().cliente);
            pst.setString(4,"0.0");
            pst.setString(5,Clients.getObj().costoIns);
            pst.setString(6,Clients.getObj().costoIns);
            pst.setInt(7, dente_check);
             pst.setString(8, dataora);
              pst.setString(9, "inserimento");
            System.out.println("valori dentiera: "+sql);
            pst.execute();
            
            String sqlfurb = "insert into storico_acc (cliente,nome,dataora,acconto,dente) values(?,?,?,?,?)";
                   Connection furb = Db.db();
                   PreparedStatement psfurb = furb.prepareStatement(sqlfurb);
                   psfurb.setString(1, Clients.getObj().cliente);
                   psfurb.setString(2, Clients.getObj().servizio);
                   psfurb.setString(3, dataora);
                   psfurb.setString(4, "0.0");
                   psfurb.setString(5, String.valueOf(dente_check));
                   psfurb.execute();
            JOptionPane.showMessageDialog(null,"Prestazione salvata correttamente" );
            check11.setSelected(false);
            check12.setSelected(false);
            check13.setSelected(false);
            check14.setSelected(false);
            check15.setSelected(false);
            check16.setSelected(false);
            check17.setSelected(false);
            check18.setSelected(false);
            check21.setSelected(false);
            check22.setSelected(false);
            check23.setSelected(false);
            check24.setSelected(false);
            check25.setSelected(false);
            check26.setSelected(false);
            check27.setSelected(false);
            check28.setSelected(false);
            check31.setSelected(false);
            check32.setSelected(false);
            check33.setSelected(false);
            check34.setSelected(false);
            check35.setSelected(false);
            check36.setSelected(false);
            check37.setSelected(false);
            check38.setSelected(false);
            check41.setSelected(false);
            check42.setSelected(false);
            check43.setSelected(false);
            check44.setSelected(false);
            check45.setSelected(false);
            check46.setSelected(false);
            check47.setSelected(false);
            check48.setSelected(false);
            
             Clients.getObj().Update_table();
                Clients.getObj().PopulatePrest();
            setVisible(false);
            Clients.getObj().setVisible(true);
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Dentiera.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            
        
    }//GEN-LAST:event_sceltabntActionPerformed

    private void check21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check21ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_check21ActionPerformed

    private void check13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_check13ActionPerformed

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
            java.util.logging.Logger.getLogger(Dentiera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dentiera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dentiera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dentiera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dentiera().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox check11;
    private javax.swing.JCheckBox check12;
    private javax.swing.JCheckBox check13;
    private javax.swing.JCheckBox check14;
    private javax.swing.JCheckBox check15;
    private javax.swing.JCheckBox check16;
    private javax.swing.JCheckBox check17;
    private javax.swing.JCheckBox check18;
    private javax.swing.JCheckBox check21;
    private javax.swing.JCheckBox check22;
    private javax.swing.JCheckBox check23;
    private javax.swing.JCheckBox check24;
    private javax.swing.JCheckBox check25;
    private javax.swing.JCheckBox check26;
    private javax.swing.JCheckBox check27;
    private javax.swing.JCheckBox check28;
    private javax.swing.JCheckBox check31;
    private javax.swing.JCheckBox check32;
    private javax.swing.JCheckBox check33;
    private javax.swing.JCheckBox check34;
    private javax.swing.JCheckBox check35;
    private javax.swing.JCheckBox check36;
    private javax.swing.JCheckBox check37;
    private javax.swing.JCheckBox check38;
    private javax.swing.JCheckBox check41;
    private javax.swing.JCheckBox check42;
    private javax.swing.JCheckBox check43;
    private javax.swing.JCheckBox check44;
    private javax.swing.JCheckBox check45;
    private javax.swing.JCheckBox check46;
    private javax.swing.JCheckBox check47;
    private javax.swing.JCheckBox check48;
    private javax.swing.JButton sceltabnt;
    private javax.swing.JLabel sfondo;
    // End of variables declaration//GEN-END:variables
}
