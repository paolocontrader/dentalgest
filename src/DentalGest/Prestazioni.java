/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DentalGest;

import java.awt.HeadlessException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Paolo
 */
public class Prestazioni extends javax.swing.JFrame {

    Connection conn=null;
    Connection connc=null;
    Connection connd=null;
    Connection conne=null;
    Connection connel=null;

    Connection connf=null;
        Connection conng=null;
        ResultSet rscd=null;
    ResultSet rs=null;
    PreparedStatement pst=null;
    PreparedStatement pstc=null;
   Statement pstcheck=null;
   PreparedStatement pstd=null;
    ResultSet rsc=null;
    /**
     * Creates new form services
     */
    private Prestazioni() {
        initComponents();
        conn=Db.db();
        connc=Db.db();
        connd=Db.db();
        conne=Db.db();
        connf=Db.db();
        conng=Db.db();
        connel=Db.db();
        AnimationStation();
        
    }
    
    private static Prestazioni obj=null;
    
    public static Prestazioni getObj(){
        if(obj==null){
            obj=new Prestazioni();
        }return obj;
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
    void Refresh(){
        combo_ser.removeAllItems();
        combo_ser.setSelectedItem("");
        try {
        String sql = "SELECT * FROM  servizi";
       pstd = connel.prepareStatement(sql);
        rscd = pstd.executeQuery();
       
        while(rscd.next())

{      
combo_ser.addItem(rscd.getString("nome_s"));


}

        }
        catch (SQLException e){
                
        } finally{
            
                try{
                    rscd.close();
                    pstd.close();
                 //onnel.close();
                    
                }
                catch(SQLException e)
                {

                }
}
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
        jLabel6 = new javax.swing.JLabel();
        btn_mod = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        combo_ser = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        txt_prezzo = new javax.swing.JTextField();
        bnt_agg = new javax.swing.JButton();
        txt_nome = new javax.swing.JTextField();
        bt_elim1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        bnt_agg1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DentalGest/images/chiudi.png"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(388, 10, 20, 20));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DentalGest/images/minimizza.png"))); // NOI18N
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, 20, 20));

        btn_mod.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_mod.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DentalGest/images/modifica.png"))); // NOI18N
        btn_mod.setToolTipText("");
        btn_mod.setBorder(null);
        btn_mod.setBorderPainted(false);
        btn_mod.setContentAreaFilled(false);
        btn_mod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modActionPerformed(evt);
            }
        });
        getContentPane().add(btn_mod, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, 75, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Servizio:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));

        combo_ser.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        combo_ser.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));
        combo_ser.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(52, 147, 81)));
        combo_ser.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                combo_serPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                combo_serPopupMenuWillBecomeVisible(evt);
            }
        });
        getContentPane().add(combo_ser, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 260, 25));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Prezzo:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, -1));

        txt_prezzo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_prezzo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(52, 147, 81)));
        txt_prezzo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_prezzoActionPerformed(evt);
            }
        });
        getContentPane().add(txt_prezzo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, 260, 25));

        bnt_agg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DentalGest/images/aggiungi.png"))); // NOI18N
        bnt_agg.setBorder(null);
        bnt_agg.setBorderPainted(false);
        bnt_agg.setContentAreaFilled(false);
        bnt_agg.setFocusPainted(false);
        bnt_agg.setFocusable(false);
        bnt_agg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnt_aggActionPerformed(evt);
            }
        });
        getContentPane().add(bnt_agg, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, -1, 30));

        txt_nome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_nome.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(52, 147, 81)));
        txt_nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nomeActionPerformed(evt);
            }
        });
        getContentPane().add(txt_nome, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, 260, 25));

        bt_elim1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        bt_elim1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DentalGest/images/elimina.png"))); // NOI18N
        bt_elim1.setBorderPainted(false);
        bt_elim1.setContentAreaFilled(false);
        bt_elim1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_elim1ActionPerformed(evt);
            }
        });
        getContentPane().add(bt_elim1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 230, -1, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Nome");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, -1));

        bnt_agg1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DentalGest/images/cancella.png"))); // NOI18N
        bnt_agg1.setBorder(null);
        bnt_agg1.setBorderPainted(false);
        bnt_agg1.setContentAreaFilled(false);
        bnt_agg1.setFocusPainted(false);
        bnt_agg1.setFocusable(false);
        bnt_agg1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnt_agg1ActionPerformed(evt);
            }
        });
        getContentPane().add(bnt_agg1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 230, -1, 30));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // TODO add your handling code here:
        setExtendedState(JFrame.ICONIFIED );
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:

        dispose();
    }//GEN-LAST:event_jLabel5MouseClicked

    private void txt_prezzoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_prezzoActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txt_prezzoActionPerformed

    private void bnt_aggActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnt_aggActionPerformed
        // TODO add your handling code here:
        int x = JOptionPane.showConfirmDialog(null,"Sei sicuro di voler creare il seguente servizio","Crea Servizio",JOptionPane.YES_NO_OPTION);
        if(x==0){
            try{
                String servizio = txt_nome.getText();

                pstcheck = conn.createStatement();
                rsc = pstcheck.executeQuery("select nome_s from servizi where nome_s='"+servizio+"'");
                if(rsc.next()){
                    JOptionPane.showMessageDialog(null,"Servizio già esistente");
                    
                }
                else{ String sql="insert into servizi (nome_s,prezzo) values (?,?)";
                    pst=conn.prepareStatement(sql);
                    pst.setString(1,txt_nome.getText().toLowerCase());
                    pst.setString(2,txt_prezzo.getText());
                    pst.execute();
                    JOptionPane.showMessageDialog(null,"Servizio creato correttamente" );
                 
               combo_ser.removeAllItems();
          txt_nome.setText("");
        txt_prezzo.setText("");
            }
            }

                

            catch(SQLException | HeadlessException e)
            {
                JOptionPane.showMessageDialog(null,"Errore Creazione Servizio");
            }

            finally{
                try{
                    rs.close();
                    pst.close();
                   
                }
                catch(SQLException e)
                {

                }
            }    }
        }

        private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
             
            
    }//GEN-LAST:event_bnt_aggActionPerformed

    private void txt_nomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nomeActionPerformed

    private void bt_elim1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_elim1ActionPerformed
        // TODO add your handling code here:
      
        String servizio =combo_ser.getSelectedItem().toString();
        int x = JOptionPane.showConfirmDialog(null,"Sei sicuro di voler rimuovere la seguente prestazione?","Elimina Prestazione",JOptionPane.YES_NO_OPTION);
        if(x==0){

            try{
                String sql = "delete from prestazioni where nome_s='"+servizio+"'";

                pst=conn.prepareStatement(sql);
                pst.execute();
                Refresh();
                JOptionPane.showMessageDialog(null,"Prestazione eliminata correttamente" );
               
                 
                combo_ser.setSelectedItem("");
                txt_prezzo.setText("");
                txt_nome.setText("");
               
            }catch(SQLException | HeadlessException e)
            {
                JOptionPane.showMessageDialog(null,"Errore eliminazione Prestazione " );
            }}
    }//GEN-LAST:event_bt_elim1ActionPerformed

    private void btn_modActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modActionPerformed
        // TODO add your handling code here:
        
        int x = JOptionPane.showConfirmDialog(null,"Sei sicuro di voler aggiornare la seguente prestazione?","Aggiorna Prestazione",JOptionPane.YES_NO_OPTION);
        if(x==0){
            
           
            try{
        String val1 = combo_ser.getSelectedItem().toString();
        String nome = txt_nome.getText().toLowerCase();
        String prezzo = txt_prezzo.getText();
               
                  String sql="update servizi set nome_s='"+nome+"',prezzo='"+prezzo+"' where nome_s='"+val1+"'"; 
            pst=connd.prepareStatement(sql);                 
            pst.execute();
                
            JOptionPane.showMessageDialog(null,"Servizio aggiornato Correttamente" );
            combo_ser.removeAllItems();
          txt_nome.setText("");
        txt_prezzo.setText("");
              
            
        }
    catch(SQLException | HeadlessException e)
        {
            JOptionPane.showMessageDialog(null,"Errore modifica servizio");
      }
       
        finally{
            try{
                rs.close();
                pst.close();
            }
            catch(SQLException e)
        {
            
      }
        } }   
    }//GEN-LAST:event_btn_modActionPerformed

    private void combo_serPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_combo_serPopupMenuWillBecomeVisible
        // TODO add your handling code here:
       combo_ser.removeAllItems();
        String sql="select * from prestazioni ORDER BY nome_s  ASC ";
        try {
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
        if(!rs.next()){
             JOptionPane.showMessageDialog(null,"Nessun servizio inserito");
            combo_ser.removeAllItems();        }
        else{
            while(rs.next()){
            combo_ser.addItem(rs.getString("nome_s"));
            
        }
        }} catch (SQLException ex) {
            Logger.getLogger(Prestazioni.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }//GEN-LAST:event_combo_serPopupMenuWillBecomeVisible

    private void combo_serPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_combo_serPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        
        String scelta=combo_ser.getSelectedItem().toString();
        try{
            String sql = "select * from servizi where nome_s='"+scelta+"'";
        pst=conn.prepareStatement(sql);
        rs=pst.executeQuery();
        while(rs.next()){
        txt_nome.setText(rs.getString("nome_s"));
        txt_prezzo.setText(rs.getString("prezzo"));
        }
        
        }catch(SQLException e){
            }
        
        
        
    }//GEN-LAST:event_combo_serPopupMenuWillBecomeInvisible

    private void bnt_agg1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnt_agg1ActionPerformed
        // TODO add your handling code here:
        
        combo_ser.removeAllItems();
        txt_nome.setText("");
        txt_prezzo.setText("");
        
    }//GEN-LAST:event_bnt_agg1ActionPerformed

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
            java.util.logging.Logger.getLogger(Prestazioni.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Prestazioni.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Prestazioni.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Prestazioni.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Prestazioni().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bnt_agg;
    private javax.swing.JButton bnt_agg1;
    private javax.swing.JButton bt_elim1;
    private javax.swing.JButton btn_mod;
    private javax.swing.JComboBox combo_ser;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField txt_nome;
    private javax.swing.JTextField txt_prezzo;
    // End of variables declaration//GEN-END:variables
}
