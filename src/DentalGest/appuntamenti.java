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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Paolo
 */
public class Appuntamenti extends javax.swing.JFrame {

    Connection connApp;
    Connection connUpdStato;
    Connection connAppDel;
    Connection conn;

    
    /**
     * Creates new form services
     */
    private Appuntamenti() {
        initComponents();
       connApp = Db.db();
       connUpdStato = Db.db();
       connAppDel = Db.db();
       conn = Db.db();
        AnimationStation();
        PopulateData();
    }
    
     void DeleteData(String data,String ora,String cliente,String servizio,String operatore) {

        String sql = "DELETE FROM appuntamenti  WHERE data = '" + data + "' AND ora = '" + ora + "' AND cliente = '" + cliente + "' AND descrizionev = '" + servizio + "' and operatore = '"+operatore+"'";
        try {
            Statement pstsDel = connAppDel.createStatement();
            System.out.println("QUERY DI ELIMINAZIONE: "+data+" "+ora+" "+servizio);
            pstsDel.execute(sql);

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e.getMessage());

        }

                   
        

    }
    public  void PopulateData() {
          String cliente = Clients.getObj().combo_cliente.getText();
// Clear table
        tb2.setModel(new DefaultTableModel());
// Model for Table
        DefaultTableModel model2 = new DefaultTableModel() {

            @Override
            public Class<?> getColumnClass(int column) {

                switch (column) {

                    case 0:

                        return Boolean.class;

                    case 1:

                        return String.class;

                    case 2:

                        return String.class;

                    case 3:

                        return String.class;

                    case 4:

                        return String.class;
                    case 5:

                        return String.class;
                     case 6:

                        return String.class;
                     case 7:

                        return String.class;

                    default:

                        return String.class;

                }

            }

        };

        tb2.setModel(model2);
        
// Add Column
        model2.addColumn("");

        model2.addColumn("Operatore");
        
        model2.addColumn("Data");

        model2.addColumn("Ora");

        model2.addColumn("Descrizione");
        
        model2.addColumn("Stato");
        
       // tb2.getColumnModel().removeColumn(tb2.getColumnModel().getColumn(4));

        
    String sql = "SELECT * FROM  appuntamenti where cliente ='"+cliente+"' ORDER BY data,ora ASC";
        try {

              PreparedStatement pstApp = connApp.prepareStatement(sql);

            

            ResultSet recApp = pstApp.executeQuery();

            int row = 0;
            
                while ((recApp != null) && (recApp.next())) {
                   
                model2.addRow(new Object[0]);

                model2.setValueAt(false, row, 0); // Checkbox

                model2.setValueAt(recApp.getString("operatore"), row, 1);
                
                model2.setValueAt(recApp.getString("data"), row, 2);

                model2.setValueAt(recApp.getString("ora"), row, 3);

                model2.setValueAt(recApp.getString("descrizionev"), row, 4);

                model2.setValueAt(recApp.getString("stato"), row,5);
                                
                row++;

            }
                   System.out.println("Numero righe tabella appuntamenti: "+row);
               
            
            
           tb2.getColumnModel().getColumn(0).setPreferredWidth(5);
            tb2.getColumnModel().getColumn(1).setPreferredWidth(180);
            tb2.getColumnModel().getColumn(2).setPreferredWidth(80);
            tb2.getColumnModel().getColumn(3).setPreferredWidth(40);

tb2.getColumnModel().getColumn(4).setPreferredWidth(270);
            

        } catch (SQLException e) {

// TODO Auto-generated catch block
            JOptionPane.showMessageDialog(null, e.getMessage());


// TODO Auto-generated catch block

        }

    }
    
    
    private static Appuntamenti obj=null;
    
    public static Appuntamenti getObj(){
        if(obj==null){
            obj=new Appuntamenti();
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel3 = new javax.swing.JLabel();
        calendar = new com.toedter.calendar.JDateChooser();
        jLabel12 = new javax.swing.JLabel();
        time_txt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        combo_stato = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb2 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        txt_prest = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        operacombo = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(850, 650));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Data: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(70, 30, 0, 0);
        getContentPane().add(jLabel3, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 113;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(70, 6, 0, 0);
        getContentPane().add(calendar, gridBagConstraints);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Ora: (HH:MM)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 12;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.ipadx = 16;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(70, 20, 0, 0);
        getContentPane().add(jLabel12, gridBagConstraints);

        time_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 19;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipadx = 94;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(70, 0, 0, 0);
        getContentPane().add(time_txt, gridBagConstraints);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Prestazione:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 30, 0, 0);
        getContentPane().add(jLabel8, gridBagConstraints);

        jButton6.setText("Modifica stato");
        jButton6.setToolTipText("Selezionare gli appuntamenti da modificare");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 49;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 10, 0, 0);
        getContentPane().add(jButton6, gridBagConstraints);

        combo_stato.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "In essere", "Sospeso", "Annullato", "Terminato" }));
        combo_stato.setSelectedIndex(-1);
        combo_stato.setToolTipText("");
        combo_stato.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.ipadx = 44;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 10, 0, 0);
        getContentPane().add(combo_stato, gridBagConstraints);

        tb2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tb2);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 26;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 763;
        gridBagConstraints.ipady = 369;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(15, 10, 40, 0);
        getContentPane().add(jScrollPane1, gridBagConstraints);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DentalGest/images/pulsanti/icona_cestino_cancella_20x20.png"))); // NOI18N
        jButton2.setToolTipText("Selezionare gli appuntamenti da eliminare");
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setFocusPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 26;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(15, 10, 0, 15);
        getContentPane().add(jButton2, gridBagConstraints);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DentalGest/images/pulsanti/nuovo_150x40.png"))); // NOI18N
        jButton5.setText("Nuovo appuntamento");
        jButton5.setBorder(null);
        jButton5.setBorderPainted(false);
        jButton5.setContentAreaFilled(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 21;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 4;
        gridBagConstraints.ipadx = -185;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(70, 20, 0, 0);
        getContentPane().add(jButton5, gridBagConstraints);

        txt_prest.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt_prest.setMinimumSize(new java.awt.Dimension(2, 22));
        txt_prest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_prestActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 18;
        gridBagConstraints.gridheight = 6;
        gridBagConstraints.ipadx = 404;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 6, 0, 0);
        getContentPane().add(txt_prest, gridBagConstraints);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Operatore:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 30, 0, 0);
        getContentPane().add(jLabel1, gridBagConstraints);

        operacombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dott Pagliarulo", "Dott.ssa Calabrese", "Dott. Donnarumma", "Dott. Famiglietti" }));
        operacombo.setSelectedIndex(-1);
        operacombo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 18;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 275;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 6, 0, 0);
        getContentPane().add(operacombo, gridBagConstraints);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        try{

            String val1 = Clients.getObj().combo_cliente.getText();
            if(val1.isEmpty()){JOptionPane.showMessageDialog(null, "Nessuno Stato selezionato");}
            else{
                int x = JOptionPane.showConfirmDialog(null,"Sei sicuro di voler aggiornare il seguente stato?","Aggiorna Stato",JOptionPane.YES_NO_OPTION);
                if(x==0){
                    for(int i=0;i < tb2.getRowCount();i++){
                        Boolean chkDel = Boolean.valueOf(tb2.getValueAt(i, 0).toString()); // Checked

                        if(chkDel) // Checked to Delete
                        {

                            String data = tb2.getValueAt(i, 2).toString();
                            String stato = combo_stato.getSelectedItem().toString();
                            String descr = tb2.getValueAt(i, 4).toString();
                            
                            String ora =tb2.getValueAt(i, 3).toString();
                            String operatore = tb2.getValueAt(i, 1).toString();
                            System.out.println("data "+data);
                            System.out.println("ora "+ora);
                            System.out.println("stato "+stato);
                            System.out.print("qui arrivo");
                            String sql="update appuntamenti set stato='"+stato+"' where cliente='"+val1+"' and data='"+data+"' and ora='"+ora+"' and descrizionev='"+descr+"'";
                            PreparedStatement pstUpdStato = connUpdStato.prepareStatement(sql);
                            pstUpdStato.execute();
                            System.out.print("anche qui arrivo");
                            //tb1.removeColumn(tb1.getColumnModel().getColumn(1));
                            //tb1.removeColumn(tb1.getColumnModel().getColumn(5));

                            //tb1.removeColumn(tb1.getColumnModel().getColumn(5));

                            JOptionPane.showMessageDialog(null,"Stato modificato correttamente per l'appuntamento del "+data+" delle ore "+ora );
                            PopulateData();
                            AppList.getObj().PopulateData();
                            //AppList.getObj().PopulateDataAll();
                            
                        }

                    }}
                }
                PopulateData(); // Reload Table
                combo_stato.setSelectedIndex(-1);
            }
            catch(SQLException | HeadlessException e)
            {
                JOptionPane.showMessageDialog(null,"Errore modifica stato");
            }
            // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Object[] options = {"Si", "No"};

        int n = JOptionPane
        .showOptionDialog(null, "Sei sicuro di voler cancellare gli appuntamenti selezionati?",
            "Conferma cancellazione?",
            JOptionPane.YES_NO_CANCEL_OPTION,
            JOptionPane.QUESTION_MESSAGE, null, options,
            options[1]);

        if (n == 0) // Confirm Delete = Yes
        {

            for (int i = 0; i < tb2.getRowCount(); i++) {

                Boolean chkDel = Boolean.valueOf(tb2.getValueAt(i, 0).toString()); // Checked

                if(chkDel) // Checked to Delete
                {

                    String data = tb2.getValueAt(i, 2).toString();
                    String servizio = tb2.getValueAt(i,4 ).toString();
                    String cliente = Clients.getObj().combo_cliente.getText();
                    String ora = tb2.getValueAt(i, 3).toString();
                    String operatore = tb2.getValueAt(i, 1).toString();
                    DeleteData(data,ora,cliente,servizio,operatore);
                    AppList.getObj().PopulateData();
                    AppList.getObj().PopulateDataAll();
                }

            }

            JOptionPane.showMessageDialog(null, "Appuntamento/i cancallati correttamente");

            PopulateData(); // Reload Table
            PopulateData(); // Reload Table
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:

        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date newDate = calendar.getDate();
  String data = dateFormat.format(newDate);
     //String cerca = calendar.getDate().toString();
     System.out.println("Data da cercare: "+data);
        String ora = time_txt.getText();
        String cliente = Clients.getObj().combo_cliente.getText();
        String stato = "in essere";
        String descrizionev = txt_prest.getText();
        String operatore = operacombo.getSelectedItem().toString();
       
        System.out.println("Cliens cliente: "+cliente);
        int x = JOptionPane.showConfirmDialog(null, "Sei sicuro di voler aggiugere il seguente appuntamento?", "Aggiungi appuntamento", JOptionPane.YES_NO_OPTION);
        if (x == 0) {
            try {

                    String sql = "insert into appuntamenti (data,ora,descrizionev,cliente,stato,operatore) values (?,?,?,?,?,?)";
                PreparedStatement pst = conn.prepareStatement(sql);

                    pst.setString(1, data);
                    pst.setString(2, ora);
                    pst.setString(3,  descrizionev);
                    pst.setString(4, cliente);
                    pst.setString(5, stato);
                    pst.setString(6, operatore);
                   
                   
                        pst.execute();
                        System.out.println("VALORI INSERIMENT PAZIENTE: " + data + " | " + ora + " | " + cliente + " | " + descrizionev + " | " + stato + "| " + operatore + " ");

                        JOptionPane.showMessageDialog(null, "Appuntamento aggiunto correttamente");
                                       PopulateData();

                        AppList.getObj().PopulateData();
                       // AppList.getObj().PopulateDataAll();
                        
                        calendar.setDate(null);
                        txt_prest.setText("");
                        time_txt.setText("");
                        operacombo.setSelectedIndex(-1);

                } catch (SQLException ex) {
                Logger.getLogger(Clients.class.getName()).log(Level.SEVERE, null, ex);
            }

                
               
                
                
            }

    }//GEN-LAST:event_jButton5ActionPerformed

    private void txt_prestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_prestActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_prestActionPerformed

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
            java.util.logging.Logger.getLogger(Appuntamenti.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Appuntamenti.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Appuntamenti.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Appuntamenti.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new Appuntamenti().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser calendar;
    private javax.swing.JComboBox<String> combo_stato;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> operacombo;
    private javax.swing.JTable tb2;
    private javax.swing.JTextField time_txt;
    private javax.swing.JTextField txt_prest;
    // End of variables declaration//GEN-END:variables
}
