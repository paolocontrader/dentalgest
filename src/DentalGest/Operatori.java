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
public class Operatori extends javax.swing.JFrame {

    Connection conn=null;
    Connection connc=null;
    Connection connd=null;
    Connection conne=null;
    Connection connel=null;
    Connection connPrest=null;
    Connection connPrestI=null;
Connection connUpd=null;
    Connection connf=null;
        Connection conng=null;
        ResultSet rscd=null;
    ResultSet rs=null;
    PreparedStatement pst=null;
     PreparedStatement psPrest=null;
      PreparedStatement psPrestI=null;
    PreparedStatement pstc=null;
   Statement pstcheck=null;
   PreparedStatement pstd=null;
   PreparedStatement pstUpd=null;
    ResultSet rsc=null;
    ResultSet rsPrest=null;
        ResultSet rsPrestI=null;

    /**
     * Creates new form services
     */
    private Operatori() {
        initComponents();
        conn=Db.db();
        connc=Db.db();
        connd=Db.db();
        conne=Db.db();
        connf=Db.db();
        conng=Db.db();
        connel=Db.db();
         connUpd=Db.db();
         connPrest = Db.db();
         connPrestI = Db.db();
        AnimationStation();
        
    }
    
    private static Operatori obj=null;
    
    public static Operatori getObj(){
        if(obj==null){
            obj=new Operatori();
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
        try {
        String sql = "SELECT * FROM  prestazioni";
       pstd = connel.prepareStatement(sql);
        rscd = pstd.executeQuery();
       
        while(rscd.next())

{      
combo_ser.addItem(rscd.getString("nome"));


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

        jLabel2 = new javax.swing.JLabel();
        combo_ser = new javax.swing.JComboBox();
        txt_nome = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        bnt_agg = new javax.swing.JButton();
        btn_mod = new javax.swing.JButton();
        bt_elim1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Operatore:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        combo_ser.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        combo_ser.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));
        combo_ser.setSelectedIndex(-1);
        combo_ser.setSelectedItem(-1);
        combo_ser.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        combo_ser.setMinimumSize(new java.awt.Dimension(260, 23));
        combo_ser.setName(""); // NOI18N
        combo_ser.setPreferredSize(new java.awt.Dimension(332, 23));
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
        getContentPane().add(combo_ser, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 260, 25));

        txt_nome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_nome.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt_nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nomeActionPerformed(evt);
            }
        });
        getContentPane().add(txt_nome, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 260, 25));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Nome");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        bnt_agg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DentalGest/images/pulsanti/aggiungi_150x40.png"))); // NOI18N
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
        getContentPane().add(bnt_agg, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, 100, 30));

        btn_mod.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_mod.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DentalGest/images/pulsanti/modifica_150x40.png"))); // NOI18N
        btn_mod.setToolTipText("");
        btn_mod.setBorder(null);
        btn_mod.setBorderPainted(false);
        btn_mod.setContentAreaFilled(false);
        btn_mod.setFocusable(false);
        btn_mod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modActionPerformed(evt);
            }
        });
        getContentPane().add(btn_mod, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 250, 90, 30));

        bt_elim1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        bt_elim1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DentalGest/images/pulsanti/elimina_150x40.png"))); // NOI18N
        bt_elim1.setBorderPainted(false);
        bt_elim1.setContentAreaFilled(false);
        bt_elim1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_elim1ActionPerformed(evt);
            }
        });
        getContentPane().add(bt_elim1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 250, 90, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DentalGest/images/headers/operatori_220x80.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jLabel1.setMaximumSize(new java.awt.Dimension(295, 80));
        jLabel1.setMinimumSize(new java.awt.Dimension(295, 80));
        jLabel1.setPreferredSize(new java.awt.Dimension(295, 80));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 5, 218, -1));

        setSize(new java.awt.Dimension(408, 361));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_nomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nomeActionPerformed

    private void combo_serPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_combo_serPopupMenuWillBecomeVisible
        // TODO add your handling code here:
         combo_ser.removeAllItems();
        String sql="select * from operatori ORDER BY nome  ASC ";
        try {
            psPrest=connPrest.prepareStatement(sql);
            rsPrest=psPrest.executeQuery();
            while(rsPrest.next()){
            combo_ser.addItem(rsPrest.getString("nome"));
            
        }
        } catch (SQLException ex) {
            Logger.getLogger(Operatori.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            try {
                psPrest.close();
            } catch (SQLException ex) {
                Logger.getLogger(Operatori.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
       
    }//GEN-LAST:event_combo_serPopupMenuWillBecomeVisible

    private void combo_serPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_combo_serPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        
        String scelta=combo_ser.getSelectedItem().toString();
        try{
            String sql = "select * from operatori where nome='"+scelta+"'";
        psPrestI=connPrestI.prepareStatement(sql);
        rsPrestI=psPrestI.executeQuery();
        while(rsPrestI.next()){
        txt_nome.setText(rsPrestI.getString("nome"));
       
        }
        
        }catch(SQLException e){
            }
        
        
        
    }//GEN-LAST:event_combo_serPopupMenuWillBecomeInvisible

    private void bnt_aggActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnt_aggActionPerformed
        // TODO add your handling code here:
        int x = JOptionPane.showConfirmDialog(null,"Sei sicuro di voler creare il seguente servizio","Aggiungi Operatore",JOptionPane.YES_NO_OPTION);
        if(x==0){
            try{
                String oper = txt_nome.getText();

                pstcheck = conn.createStatement();
                rsc = pstcheck.executeQuery("select nome from prestazioni where nome='"+oper+"'");
                if(rsc.next()){
                    JOptionPane.showMessageDialog(null,"Operatore già esistente");
                    combo_ser.removeAllItems();
               
                txt_nome.setText("");

                }
                else{
                    
                    
                    String sql="insert into operatori (nome) values (?)";
                    pst=conn.prepareStatement(sql);
                    pst.setString(1,txt_nome.getText());
                   
                    pst.execute();
                    JOptionPane.showMessageDialog(null,"Operatore aggiunto correttamente" );

                   combo_ser.removeAllItems();
                
                    Refresh();
                    
                   
                txt_nome.setText("");
                combo_ser.setSelectedIndex(-1);
               
                        }
                
            }

            catch(SQLException | HeadlessException e)
            {
                JOptionPane.showMessageDialog(null,"Errore aggiunta Operatore");
            }

        }
        }

        private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {

    }//GEN-LAST:event_bnt_aggActionPerformed

    private void btn_modActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modActionPerformed
        // TODO add your handling code here:
                
        int x = JOptionPane.showConfirmDialog(null,"Sei sicuro di voler aggiornare li seguente operatore?","Aggiorna Operatore",JOptionPane.YES_NO_OPTION);
        if(x==0){

            try{
                String val1 = combo_ser.getSelectedItem().toString();
                String nome = txt_nome.getText();
                
               
                String sql="update operatori set nome='"+nome+"' where nome='"+val1+"'";
                pstUpd=connUpd.prepareStatement(sql);
               
                pstUpd.execute();

                JOptionPane.showMessageDialog(null,"Operatore aggiornato Correttamente" );
                combo_ser.removeAllItems();
                txt_nome.setText("");
            }   
            catch(SQLException | HeadlessException e)
            {
                JOptionPane.showMessageDialog(null,"Errore modifica operatore");
            }

            }
    }//GEN-LAST:event_btn_modActionPerformed

    private void bt_elim1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_elim1ActionPerformed
        // TODO add your handling code here:

        String oper =combo_ser.getSelectedItem().toString();
        int x = JOptionPane.showConfirmDialog(null,"Sei sicuro di voler rimuovere il seguente operatore?","Elimina Operatore",JOptionPane.YES_NO_OPTION);
        if(x==0){

            try{
                String sql = "delete from operatori where nome='"+oper+"'";

                pst=conn.prepareStatement(sql);
               
                   
                pst.execute();
                Refresh();
                combo_ser.setSelectedIndex(-1);
               
                txt_nome.setText("");
                 
                JOptionPane.showMessageDialog(null,"Operatore cancellato correttamente" );
                


                
                Refresh();
                   
                   

            }catch(SQLException | HeadlessException e)
            {
                JOptionPane.showMessageDialog(null,"Errore eliminazione operatore " );
            }}
    }//GEN-LAST:event_bt_elim1ActionPerformed

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
            java.util.logging.Logger.getLogger(Operatori.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Operatori.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Operatori.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Operatori.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                new Operatori().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bnt_agg;
    private javax.swing.JButton bt_elim1;
    private javax.swing.JButton btn_mod;
    public javax.swing.JComboBox combo_ser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField txt_nome;
    // End of variables declaration//GEN-END:variables
}
