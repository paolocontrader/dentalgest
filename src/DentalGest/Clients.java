/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DentalGest;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Element;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.HeaderFooter;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.HeadlessException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;


/**
 *
 * @author Paolo
 */
public final class Clients extends javax.swing.JFrame {

    int dente_check = 0;
    Connection connv=null;
    Connection connva=null;
    Connection conna=null;
    Connection conne=null;
    Connection conn=null;
    Connection conn1=null;
    Connection conn2=null;
    Connection conn3=null;
    Connection conns=null;
    Connection coni=null;
    Connection repo=null;
    Connection connInsTot=null;
    Connection connUpd=null;
    Connection connUpdStato=null;
    Connection connApp = null;
    Connection connAppDel = null;
    Connection connAppDelPrest = null;
    Connection connSto = null;
    ResultSet rs=null;
     ResultSet repSto=null;
    ResultSet rsc=null;
    ResultSet rscv=null;
    ResultSet rscva=null;
    ResultSet rscs=null;
    PreparedStatement pstv=null;
    PreparedStatement prepSto=null;
    PreparedStatement pstva=null;
    PreparedStatement psti=null;
    PreparedStatement pstz=null;
    PreparedStatement pstcc=null;
    PreparedStatement pst=null;
    PreparedStatement pstUpd=null;
    PreparedStatement pstUpdStato=null;
    PreparedStatement pstr=null;
    PreparedStatement prep=null;
    PreparedStatement pstApp = null;
    Statement pstcheck=null;
    ResultSet rss=null;
     ResultSet rscd=null;
     ResultSet rep=null;
    PreparedStatement psts=null;
    Statement pstsDel=null;
    Statement pstsDelPrest=null;
    PreparedStatement pstIns = null;
     ResultSet rsInsTot = null;
    String msg1 = null;
    String msg2 = null;
     String comb = null;
     String id = null;
      String dataora= null;
     String costoIns = null;
                String cliente = null;
                String servizio = null;
    /**
     * Creates new form Clients
     */
    Clients() {
      
        initComponents();
         String msg1 = txt_n.getText();
    String msg2 = txt_c.getText();;
   
         connUpd = Db.db();
        conn=Db.db();
         conne= Db.db();
         conna=Db.db();
         conn2= Db.db();
         conn3=Db.db();
         conn1=Db.db();
         conns=Db.db();
         coni=Db.db();
         repo=Db.db();
         connv=Db.db();
         connva=Db.db();
         connInsTot = Db.db();
        connSto = Db.db();
         connUpdStato = Db.db();
         connApp = Db.db();
         connAppDel = Db.db();
         connAppDelPrest = Db.db();
         combo_cliente.setText(comb);
        Update_table();
    AnimationStation();
    
    }
    
    
    public void AnimationStation() {
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
    private static Clients obj=null;
    
    public static Clients getObj(){
        if(obj==null){
            obj=new Clients();
            
          
        }return obj;
    }
    
    
    
    void DeleteData(String data,String ora,String cliente,String servizio) {

        String sql = "DELETE FROM appuntamenti  WHERE data = '" + data + "' AND ora = '" + ora + "' AND cliente = '" + cliente + "' AND descrizionev = '" + servizio + "'";
        try {
            pstsDel = connAppDel.createStatement();
            System.out.println("QUERY DI ELIMINAZIONE: "+data+" "+ora+" "+servizio);
            pstsDel.execute(sql);

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e.getMessage());

        }

                   
        

    }
    
    void DeleteDataPrest(String nome,String cliente,String id) {

        String sql = "DELETE FROM prestazione_cliente  WHERE nome = '" + nome + "' AND cliente = '" + cliente + "' AND id = '" + id + "'";
        try {
            pstsDelPrest = connAppDelPrest.createStatement();
            System.out.println("QUERY DI ELIMINAZIONE: "+nome+" "+cliente+" "+id);
            pstsDelPrest.execute(sql);

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e.getMessage());

        }

                   
        

    }
    
     void Update_table() {
    
        
         try{
        String n = txt_n.getText().toUpperCase();
         String c = txt_c.getText().toUpperCase();
          comb = n+" "+c;
        System.out.println("Nome da List: "+n+" "+c);
        combo_cliente.setText(comb);
        String sql ="select * from prestazione_cliente where cliente='"+comb+"'";
       
        pst=conn.prepareStatement(sql);
        rs=pst.executeQuery();
        
        DefaultTableModel model = (DefaultTableModel)tb1.getModel();
        tb1.setDefaultEditor(Object.class, null);
              


        // get the selected row index
       int selectedRowIndex = tb1.getSelectedRow();
       DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
       decimalFormat.setRoundingMode(RoundingMode.FLOOR);

        // set the selected row data into jtextfields
//       ric_serv.setText(model.getValueAt(selectedRowIndex, 2).toString());
       /*txt_servizio.setText(model.getValueAt(selectedRowIndex, 1).toString());
       txt_costo.setText(model.getValueAt(selectedRowIndex, 3).toString());
       txt_iva.setText(model.getValueAt(selectedRowIndex, 4).toString());
       txt_anticipo.setText(model.getValueAt(selectedRowIndex, 5).toString());
       */tb1.setModel(DbUtils.resultSetToTableModel(rs));
            Double resu=0.0;
            Double accu=0.0;
            Double ttt=0.0;
            //tb1.removeColumn(tb1.getColumnModel().getColumn(2));
       
            for(int i=0;i < tb1.getRowCount();i++){
                
                accu =  accu + Double.parseDouble(tb1.getValueAt(i, 3).toString());
               
                ttt=ttt+Double.parseDouble(tb1.getValueAt(i,5).toString());
                resu = ttt - accu;
            }
           
           
            txt_resto.setText(decimalFormat.format(resu));
            txt_tot.setText(decimalFormat.format(ttt));
        txt_ant.setText(decimalFormat.format(accu));

       
    }
    catch(SQLException | NumberFormatException e){
    JOptionPane.showMessageDialog(null, e);
    }
    finally {
            
            try{
                rs.close();
                pst.close();
                
            }
            catch(SQLException e){
                
            }
        }
    }
     

     public  void PopulatePrest() {
          String cliente = combo_cliente.getText();
// Clear table
        tb1.setModel(new DefaultTableModel());
// Model for Table
        DefaultTableModel model3 = new DefaultTableModel() {

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

                    default:

                        return String.class;

                }

            }

        };

        tb1.setModel(model3);
        
// Add Column
        model3.addColumn("");

         model3.addColumn("");
        
        model3.addColumn("Nome");
        
          model3.addColumn("Dente");

        model3.addColumn("Acconto");

        model3.addColumn("Resto");

        model3.addColumn("Prezzo");
        
       
        
       // tb2.getColumnModel().removeColumn(tb2.getColumnModel().getColumn(4));

        
    String sql = "SELECT * FROM  prestazione_cliente where cliente ='"+cliente+"' ORDER BY nome DESC";
        try {

            pstApp = connApp.prepareStatement(sql);

            

            ResultSet recApp = pstApp.executeQuery();

            int row = 0;
            
                while ((recApp != null) && (recApp.next())) {
                    
                     model3.addRow(new Object[0]);

                model3.setValueAt(false, row, 0); // Checkbox
                
                model3.setValueAt(recApp.getString("id"), row, 1);
                
                model3.setValueAt(recApp.getString("nome"), row, 2);
                
                model3.setValueAt(recApp.getString("dente"), row, 3);
                
                model3.setValueAt(recApp.getString("acconto"), row, 4);

                model3.setValueAt(recApp.getString("resto"), row, 5);

                model3.setValueAt(recApp.getString("prezzo"), row, 6);
                
                
                                
                row++;

            }
                   System.out.println("Numero righe tabella prestazione_cliente: "+row);
               
            
            
           tb1.getColumnModel().getColumn(0).setPreferredWidth(2);
            tb1.getColumnModel().getColumn(1).setPreferredWidth(2);
            tb1.getColumnModel().getColumn(2).setPreferredWidth(480);
            tb1.getColumnModel().getColumn(3).setPreferredWidth(50);

tb1.getColumnModel().getColumn(4).setPreferredWidth(50);
tb1.getColumnModel().getColumn(5).setPreferredWidth(50);
tb1.getColumnModel().getColumn(6).setPreferredWidth(50);
            

        } catch (SQLException e) {

// TODO Auto-generated catch block
            JOptionPane.showMessageDialog(null, e.getMessage());


// TODO Auto-generated catch block

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
        jLabel4 = new javax.swing.JLabel();
        txt_resto = new javax.swing.JLabel();
        minimizza = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        chiudi = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txt_tot = new javax.swing.JLabel();
        bnt_agg_sek = new javax.swing.JButton();
        txt_ant = new javax.swing.JLabel();
        txt_servizio = new javax.swing.JLabel();
        prestazioni = new javax.swing.JComboBox();
        btn8 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb1 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        bt_elim1 = new javax.swing.JButton();
        txt_costo = new javax.swing.JTextField();
        txt_anticipo = new javax.swing.JTextField();
        txt_tt = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txt_c = new javax.swing.JTextField();
        combo_cliente = new javax.swing.JTextField();
        txt_n = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("DentalGest - Gestione Clienti");
        setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Prestazione:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 80, -1));

        jLabel4.setText("Costo:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 70, -1));

        txt_resto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(52, 147, 81)));
        getContentPane().add(txt_resto, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 560, 90, 25));

        minimizza.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DentalGest/images/pulsanti/icona_minimizza_20x20.png"))); // NOI18N
        minimizza.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizzaMouseClicked(evt);
            }
        });
        getContentPane().add(minimizza, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 2, 20, 20));

        jLabel5.setText("Saldo:  €");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 560, 60, -1));

        jLabel8.setText("   Acconto:  €");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 560, 80, -1));

        jLabel7.setText("Totale: €");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 560, 80, -1));

        chiudi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DentalGest/images/pulsanti/icona_chiudi_20x20.png"))); // NOI18N
        chiudi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                chiudiMouseClicked(evt);
            }
        });
        getContentPane().add(chiudi, new org.netbeans.lib.awtextra.AbsoluteConstraints(964, 2, 20, 20));

        jLabel11.setText("Acconto:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 220, -1, -1));

        txt_tot.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(52, 147, 81)));
        getContentPane().add(txt_tot, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 560, 80, 25));

        bnt_agg_sek.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DentalGest/images/pulsanti/aggiungi_150x40.png"))); // NOI18N
        bnt_agg_sek.setBorder(null);
        bnt_agg_sek.setBorderPainted(false);
        bnt_agg_sek.setContentAreaFilled(false);
        bnt_agg_sek.setFocusPainted(false);
        bnt_agg_sek.setFocusable(false);
        bnt_agg_sek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnt_agg_sekActionPerformed(evt);
            }
        });
        getContentPane().add(bnt_agg_sek, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 250, 100, 40));

        txt_ant.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(52, 147, 81)));
        getContentPane().add(txt_ant, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 560, 80, 25));

        txt_servizio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(52, 147, 81)));
        getContentPane().add(txt_servizio, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 220, 25));

        prestazioni.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        prestazioni.setToolTipText("");
        prestazioni.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(52, 147, 81)));
        prestazioni.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                prestazioniPopupMenuWillBecomeVisible(evt);
            }
        });
        getContentPane().add(prestazioni, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 310, 25));

        btn8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DentalGest/images/pulsanti/estratto_conto_cliente_100x40.png"))); // NOI18N
        btn8.setToolTipText("");
        btn8.setBorder(null);
        btn8.setBorderPainted(false);
        btn8.setContentAreaFilled(false);
        btn8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn8ActionPerformed(evt);
            }
        });
        getContentPane().add(btn8, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 170, 150, 47));

        tb1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(52, 147, 81)));
        tb1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tb1.setFocusable(false);
        tb1.getTableHeader().setReorderingAllowed(false);
        tb1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tb1);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 930, 240));

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DentalGest/images/pulsanti/aggiorna_150x40.png"))); // NOI18N
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.setFocusPainted(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 170, 100, 47));

        bt_elim1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        bt_elim1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DentalGest/images/pulsanti/cancella_150x40.png"))); // NOI18N
        bt_elim1.setBorderPainted(false);
        bt_elim1.setContentAreaFilled(false);
        bt_elim1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_elim1ActionPerformed(evt);
            }
        });
        getContentPane().add(bt_elim1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 170, 100, 47));

        txt_costo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(52, 147, 81)));
        txt_costo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_costoActionPerformed(evt);
            }
        });
        getContentPane().add(txt_costo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 220, 70, 25));

        txt_anticipo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(52, 147, 81)));
        txt_anticipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_anticipoActionPerformed(evt);
            }
        });
        getContentPane().add(txt_anticipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 220, 72, 25));
        getContentPane().add(txt_tt, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 400, 80, 40));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DentalGest/images/pulsanti/cartella_clinica_100x40.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 170, -1, 47));

        txt_c.setEditable(false);
        txt_c.setAutoscrolls(false);
        txt_c.setBorder(null);
        txt_c.setEnabled(false);
        txt_c.setFocusable(false);
        txt_c.setOpaque(false);
        txt_c.setPreferredSize(new java.awt.Dimension(0, 0));
        txt_c.setRequestFocusEnabled(false);
        txt_c.setVerifyInputWhenFocusTarget(false);
        getContentPane().add(txt_c, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, -130, -1, -1));

        combo_cliente.setEditable(false);
        combo_cliente.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        combo_cliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        combo_cliente.setBorder(null);
        getContentPane().add(combo_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 120, 410, -1));

        txt_n.setEditable(false);
        txt_n.setAutoscrolls(false);
        txt_n.setBorder(null);
        txt_n.setEnabled(false);
        txt_n.setFocusable(false);
        txt_n.setOpaque(false);
        txt_n.setPreferredSize(new java.awt.Dimension(0, 0));
        txt_n.setRequestFocusEnabled(false);
        txt_n.setVerifyInputWhenFocusTarget(false);
        getContentPane().add(txt_n, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -130, -1, -1));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DentalGest/images/pulsanti/APPUNTAMENTI-150X40.png"))); // NOI18N
        jButton4.setBorder(null);
        jButton4.setBorderPainted(false);
        jButton4.setContentAreaFilled(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 250, -1, -1));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DentalGest/images/pulsanti/STORICO-CLIENTE-150X40.png"))); // NOI18N
        jButton5.setBorder(null);
        jButton5.setBorderPainted(false);
        jButton5.setContentAreaFilled(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 250, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DentalGest/images/window_schedapazientesingolo_1000x820.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 810));

        setSize(new java.awt.Dimension(991, 613));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void minimizzaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizzaMouseClicked
        // TODO add your handling code here:
        setExtendedState(JFrame.ICONIFIED );
    }//GEN-LAST:event_minimizzaMouseClicked

    private void chiudiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chiudiMouseClicked
        // TODO add your handling code here:

dispose();
    }//GEN-LAST:event_chiudiMouseClicked

    private void bnt_agg_sekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnt_agg_sekActionPerformed
        // TODO add your handling code here:
        
        
        
        try{
                boolean dente = false;
                 costoIns = null;
                 cliente = combo_cliente.getText();
                 servizio = prestazioni.getSelectedItem().toString();
                
                    
                    int x = JOptionPane.showConfirmDialog(null,"Sei sicuro di voler aggiungere la seguente prestazione","Aggiungi Prestazione",JOptionPane.YES_NO_OPTION);

                    if(x==0){    
   
                    
                        int dente_ins = 0;
                    String costo_insert = "select prezzo,dente from prestazioni where nome = ?";
                    pstIns = connInsTot.prepareStatement(costo_insert);
                    pstIns.setString(1,servizio);
                    rsInsTot = pstIns.executeQuery();
                    while(rsInsTot.next())
                    {
                        dente = rsInsTot.getBoolean("dente");
                    costoIns = Double.toString(rsInsTot.getDouble("prezzo"));
                    
                    }
                    if(dente == true)
                    {
                       
                        
                        //String dente_ins = JOptionPane.showInputDialog("Inserire numero dente");
                      
                        Dentiera.getObj().setVisible(true);
                       
                        //System.out.println("dente_ins: "+dente_ins);
                    
                     dente_check = Dentiera.getObj().dente_check;
                   if(Dentiera.getObj().isVisible()){
                   System.out.println("Dentiera attivo");
                   }
                    }
                    else{
                    
                        System.out.println("costo: "+costoIns);
                    String sql="insert into prestazione_cliente (id,nome,cliente,acconto,resto,prezzo,dente,dataora,tipo) values (?,?,?,?,?,?,?,?,?)";
                    pst=conn.prepareStatement(sql);
                    Random rand = new Random(); //instance of random class
     
                    int upperbound = 50;
                    int int_random = rand.nextInt(upperbound); 
                   String id = String.valueOf(int_random);
                    pst.setString(1,id);
                    pst.setString(2,servizio);
                    pst.setString(3,cliente);
                    pst.setString(4,"0.0");
                    pst.setString(5,costoIns);
                    pst.setString(6,costoIns);
                    pst.setInt(7, 0);
                    pst.setString(8,dataora);
                    pst.setString(9,"inserimento");
                    pst.execute();
                    JOptionPane.showMessageDialog(null,"Prestazione salvata correttamente" );
                }
                    }
                Update_table();
                PopulatePrest();
                
                
                txt_costo.setText("");
                txt_anticipo.setText("");
                prestazioni.setSelectedItem(-1);
            }catch(SQLException | HeadlessException e)
            {
                JOptionPane.showMessageDialog(null,"Errore Salvataggio Prestazione");
            }

            finally{
                try{
                    rs.close();
                    pst.close();
                }
                catch(SQLException e)
                {

                }
            }    
    }//GEN-LAST:event_bnt_agg_sekActionPerformed

    
    
    private void btn8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn8ActionPerformed
        // TODO add your handling code here:
    //deve stampare la prestazione in grande e acconto  e cercare di 
         txt_tot.getText();
         txt_ant.getText();
         txt_resto.getText();
         
         PopulatePrest();
        try{
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");  
   LocalDateTime now = LocalDateTime.now();  
   System.out.println(dtf.format(now));  
  DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy_HH-mm");
Calendar cal = Calendar.getInstance();
System.out.println(dateFormat.format(cal.getTime()));
            String scelta= combo_cliente.getText();
           String adesso = dateFormat.format(cal.getTime());
            String sql = "select * from prestazione_cliente where cliente='"+scelta+"'";
            prep=repo.prepareStatement(sql);
            rep=prep.executeQuery();
            Document d=new Document(PageSize.A4);
            
            File f = new File("/dentalgest/reports/"+scelta+"/");
  
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
            PdfWriter.getInstance(d, new FileOutputStream("/dentalgest/reports/"+scelta+"/saldo-"+scelta+"_"+adesso+".pdf"));
            d.open();
            
            Image image = Image.getInstance("/dentalgest/header.png");
            image.scaleToFit(1400, 150);
            image.setBorderColor(new Color(0,0,0));
            PdfPCell cell=new PdfPCell();
           // d.add(image);
            Paragraph n=new Paragraph("\n");
            cell.setColspan(2);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setPadding(8.0f);
            Font font=new Font();
            font.setColor(0,0,0);
            font.setSize(28);
            
            int indentation = 0;
           
            d.add(image);
                    /* Font Size */
            
            d.add(n);d.add(n);
            PdfPTable anagr = new PdfPTable(1);
               
               String cf = ClientiList.getObj().txt_codfisc.getText();
               String rec = ClientiList.getObj().txt_recapito.getText();
                PdfPCell cell112=new PdfPCell(new Paragraph("C.F: "+cf.toUpperCase()));
               cell112.setBorderColor(new Color(255,255,255));
               cell112.setHorizontalAlignment(Element.ALIGN_LEFT);
                PdfPCell cell113=new PdfPCell(new Paragraph("Cell: "+rec));
               cell113.setBorderColor(new Color(255,255,255));
               cell113.setHorizontalAlignment(Element.ALIGN_LEFT);
               Font fontSize_16 =  FontFactory.getFont(FontFactory.TIMES, 22f);
               PdfPCell pazi = new PdfPCell(new Paragraph("Paziente",fontSize_16));
               pazi.setIndent(-40);
             
               pazi.setBorderColor(new Color(255,255,255));
               pazi.setHorizontalAlignment(Element.ALIGN_LEFT);
               PdfPCell cell111=new PdfPCell(new Paragraph(scelta));
               cell111.setBorderColor(new Color(255,255,255));
               cell111.setIndent(-40);
               cell112.setIndent(-40);
               cell113.setIndent(-40);
               cell111.setHorizontalAlignment(Element.ALIGN_LEFT);
              
               anagr.addCell(pazi);
                anagr.addCell(cell111);
                anagr.addCell(cell112);
                anagr.addCell(cell113);
                d.add(anagr);
            d.add(n);d.add(n);d.add(n);
            PdfPTable ptableh = new PdfPTable(4);
            
               String nomeh="Prestazione";
               String prezzoh="Acconto";
               //String ivah="Iva Applicata";
               String nettoh="Resto";
               String ivatoh="Totale";  
               PdfPCell cell1h=new PdfPCell(new Paragraph(nomeh));
               cell1h.setBorderColor(new Color(0,0,0));
               cell1h.setBackgroundColor(new Color(255,255,255));
               cell1h.setHorizontalAlignment(Element.ALIGN_CENTER);
               PdfPCell cell2h=new PdfPCell(new Paragraph(prezzoh)); 
               cell2h.setBorderColor(new Color(0,0,0));
                cell2h.setBackgroundColor(new Color(255,255,255));
                cell2h.setHorizontalAlignment(Element.ALIGN_CENTER);
                PdfPCell cell3h=new PdfPCell(new Paragraph(ivatoh));
               cell3h.setBorderColor(new Color(0,0,0));
                cell3h.setBackgroundColor(new Color(255,255,255));
               cell3h.setHorizontalAlignment(Element.ALIGN_CENTER);
               //PdfPCell cell4h=new PdfPCell(new Paragraph(ivah));
                //cell4h.setBorderColor(new Color(52,147,81));
                 //cell4h.setBackgroundColor(new Color(52,147,81));
                //cell4h.setHorizontalAlignment(Element.ALIGN_RIGHT);
                 PdfPCell cell5h=new PdfPCell(new Paragraph(nettoh));
                cell5h.setBorderColor(new Color(0,0,0));
                 cell5h.setBackgroundColor(new Color(255,255,255));
                cell5h.setHorizontalAlignment(Element.ALIGN_CENTER);
                ptableh.addCell(cell1h);
                ptableh.addCell(cell2h);
                ptableh.addCell(cell5h);
                //ptableh.addCell(cell4h);
                ptableh.addCell(cell3h);
                d.add(ptableh);
                 
            while(rep.next()){
               PdfPTable ptable = new PdfPTable(4);
               String nome=rep.getString("nome");
               String dente=rep.getString("dente");
               String impon=rep.getString("acconto");
               String iva_calc=rep.getString("resto");
               //String iva_app=rep.getString("iva");
               String total=rep.getString("prezzo");
               PdfPCell cell1=new PdfPCell(new Paragraph(nome));
               cell1.setBorderColor(new Color(0,0,0));
                PdfPCell celld=new PdfPCell(new Paragraph(dente));
               celld.setBorderColor(new Color(0,0,0));
               celld.setHorizontalAlignment(Element.ALIGN_LEFT);
               PdfPCell cell2=new PdfPCell(new Paragraph("€"+impon)); 
               cell2.setBorderColor(new Color(0,0,0));
                cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
                PdfPCell cell3=new PdfPCell(new Paragraph("€"+iva_calc));
               cell3.setBorderColor(new Color(0,0,0));
               cell3.setHorizontalAlignment(Element.ALIGN_LEFT);
               //PdfPCell cell4=new PdfPCell(new Paragraph(""+iva_app));
                //cell4.setBorderColor(new Color(52,147,81));
                //cell4.setHorizontalAlignment(Element.ALIGN_RIGHT);
                PdfPCell cell5=new PdfPCell(new Paragraph("€"+total));
                cell5.setBorderColor(new Color(0,0,0));
                cell5.setHorizontalAlignment(Element.ALIGN_LEFT);
                ptable.addCell(cell1);
                ptable.addCell(cell2);
                ptable.addCell(cell3);
                //ptable.addCell(cell4);
                ptable.addCell(cell5);
                d.add(ptable);
            }
                d.add(n);
                d.add(n);
            PdfPTable table1=new PdfPTable(1);
            String resor=txt_resto.getText();
            String t=txt_tot.getText();
            String totaler=txt_tot.getText();
            String accontor=txt_ant.getText();
            PdfPCell cell3=new PdfPCell(new Paragraph("Totale: €"+totaler+ "\nAcconto: €"+accontor+"\nSaldo: €"+resor));
            cell3.setBorder(0);
            cell3.setHorizontalAlignment(Element.ALIGN_RIGHT);
            table1.addCell(cell3);
            Image image1 = Image.getInstance("/dentalgest/footer.png");
            image1.scaleToFit(720, 55);
            d.add(table1);
            image1.setAbsolutePosition(15, 10);
            image1.setAlignment(Image.ALIGN_CENTER);
            d.add(image1);
           
            
            d.close();
            
            JOptionPane.showMessageDialog(null,"Report creato correttamente");
         try{
        //Process exec = Runtime.getRuntime().exec("cmd.exe /C /dentalgest/utility/open.bat");
        File file = new File("/dentalgest/reports/"+scelta+"/saldo-"+scelta+"_"+adesso+".pdf");
    if (file.toString().endsWith(".pdf")) 
       Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + file);
   else {
       Desktop desktop = Desktop.getDesktop();
       desktop.open(file);
}
         }    // File myFile = new File("/dentalgest/reports/saldo-"+scelta+"_"+adesso+".pdf");
        // Desktop.getDesktop().open(myFile);
         
         catch (IOException e){}}
        catch(HeadlessException e){
            JOptionPane.showMessageDialog(null,"Errore creazione report");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Clients.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException | IOException | DocumentException ex) {
            Logger.getLogger(Clients.class.getName()).log(Level.SEVERE, null, ex);
        } 
        finally {

            try{

                rep.close();
                prep.close();
                

            }
            catch(SQLException e){

            }
        
        }
    }//GEN-LAST:event_btn8ActionPerformed

    public void listFiles() throws IOException{
        String scelta = combo_cliente.getText();
        String folder = "/Dentalgest/reports/"+scelta+"/";
Desktop.getDesktop().open(new File(folder));
    }
    
    public void storico()
    {
         txt_tot.getText();
         txt_ant.getText();
         txt_resto.getText();
         
         PopulatePrest();
        try{
           
            String scelta= combo_cliente.getText();
          
            String sqlAcc = "select * from storico_acc where cliente='"+scelta+"' order by nome, dataora";
            prepSto=connSto.prepareStatement(sqlAcc);
            repSto=prepSto.executeQuery();
            Document d=new Document(PageSize.A4);
            
            File f = new File("/dentalgest/reports/"+scelta+"/storico/");
  
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
            PdfWriter.getInstance(d, new FileOutputStream("/dentalgest/reports/"+scelta+"/storico/storico-"+scelta+".pdf"));
            d.open();
            
            Image image = Image.getInstance("/dentalgest/header.png");
            image.scaleToFit(1400, 150);
            image.setBorderColor(new Color(0,0,0));
            PdfPCell cell=new PdfPCell();
           // d.add(image);
            Paragraph n=new Paragraph("\n");
            cell.setColspan(2);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setPadding(8.0f);
            Font font=new Font();
            font.setColor(0,0,0);
            font.setSize(28);
            
            int indentation = 0;
           
            d.add(image);
                    /* Font Size */
            
            d.add(n);d.add(n);
            PdfPTable anagr = new PdfPTable(1);
               
               String cf = ClientiList.getObj().txt_codfisc.getText();
               String rec = ClientiList.getObj().txt_recapito.getText();
                PdfPCell cell112=new PdfPCell(new Paragraph("C.F: "+cf.toUpperCase()));
               cell112.setBorderColor(new Color(255,255,255));
               cell112.setHorizontalAlignment(Element.ALIGN_LEFT);
                PdfPCell cell113=new PdfPCell(new Paragraph("Cell: "+rec));
               cell113.setBorderColor(new Color(255,255,255));
               cell113.setHorizontalAlignment(Element.ALIGN_LEFT);
               Font fontSize_16 =  FontFactory.getFont(FontFactory.TIMES, 22f);
               PdfPCell pazi = new PdfPCell(new Paragraph("Paziente",fontSize_16));
               pazi.setIndent(-40);
             
               pazi.setBorderColor(new Color(255,255,255));
               pazi.setHorizontalAlignment(Element.ALIGN_LEFT);
               PdfPCell cell111=new PdfPCell(new Paragraph(scelta));
               cell111.setBorderColor(new Color(255,255,255));
               cell111.setIndent(-40);
               cell112.setIndent(-40);
               cell113.setIndent(-40);
               cell111.setHorizontalAlignment(Element.ALIGN_LEFT);
              
               anagr.addCell(pazi);
                anagr.addCell(cell111);
                anagr.addCell(cell112);
                anagr.addCell(cell113);
                d.add(anagr);
            d.add(n);d.add(n);d.add(n);
            PdfPTable ptableh = new PdfPTable(4);
            
               String nomeh="Prestazione";
               String accontoh="Acconto";
               String datah="Data"; 
               PdfPCell cell1h=new PdfPCell(new Paragraph(nomeh));
               cell1h.setBorderColor(new Color(0,0,0));
               cell1h.setBackgroundColor(new Color(255,255,255));
               cell1h.setHorizontalAlignment(Element.ALIGN_CENTER);
               PdfPCell cell2h=new PdfPCell(new Paragraph(accontoh)); 
               cell2h.setBorderColor(new Color(0,0,0));
                cell2h.setBackgroundColor(new Color(255,255,255));
                cell2h.setHorizontalAlignment(Element.ALIGN_CENTER);
                PdfPCell cell3h=new PdfPCell(new Paragraph(datah));
               cell3h.setBorderColor(new Color(0,0,0));
                cell3h.setBackgroundColor(new Color(255,255,255));
               cell3h.setHorizontalAlignment(Element.ALIGN_CENTER);
               
                ptableh.addCell(cell1h);
                ptableh.addCell(cell2h);
                ptableh.addCell(cell3h);
                d.add(ptableh);
                 
            while(repSto.next()){
               PdfPTable ptable = new PdfPTable(3);
               String nomes=repSto.getString("nome");
               String accontos=repSto.getString("acconto");
               String quandos=repSto.getString("dataora");
               PdfPCell cell1=new PdfPCell(new Paragraph(nomes));
               cell1.setBorderColor(new Color(0,0,0));
                PdfPCell cell2=new PdfPCell(new Paragraph("€"+accontos));
               PdfPCell cell3=new PdfPCell(new Paragraph(quandos)); 
               cell2.setBorderColor(new Color(0,0,0));
                cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
               
                ptable.addCell(cell1);
                ptable.addCell(cell2);
                ptable.addCell(cell3);
               
                d.add(ptable);
            }
                d.add(n);
                d.add(n);
            PdfPTable table1=new PdfPTable(1);
            String resor=txt_resto.getText();
            String t=txt_tot.getText();
            String totaler=txt_tot.getText();
            String accontor=txt_ant.getText();
            PdfPCell cell3=new PdfPCell(new Paragraph("Totale: €"+totaler+ "\nAcconto: €"+accontor+"\nSaldo: €"+resor));
            cell3.setBorder(0);
            cell3.setHorizontalAlignment(Element.ALIGN_RIGHT);
            table1.addCell(cell3);
            Image image1 = Image.getInstance("/dentalgest/footer.png");
            image1.scaleToFit(720, 55);
            d.add(table1);
            image1.setAbsolutePosition(15, 10);
            image1.setAlignment(Image.ALIGN_CENTER);
            d.add(image1);
           
            
            d.close();
            
            JOptionPane.showMessageDialog(null,"Storico creato correttamente");
         try{
        //Process exec = Runtime.getRuntime().exec("cmd.exe /C /dentalgest/utility/open.bat");
        File file = new File("/dentalgest/reports/"+scelta+"/storico/storico-"+scelta+".pdf");
    if (file.toString().endsWith(".pdf")) 
       Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + file);
   else {
       Desktop desktop = Desktop.getDesktop();
       desktop.open(file);
}
         }    // File myFile = new File("/dentalgest/reports/saldo-"+scelta+"_"+adesso+".pdf");
        // Desktop.getDesktop().open(myFile);
         
         catch (IOException e){}}
        catch(HeadlessException e){
            JOptionPane.showMessageDialog(null,"Errore creazione storico");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Clients.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException | IOException | DocumentException ex) {
            Logger.getLogger(Clients.class.getName()).log(Level.SEVERE, null, ex);
        } 
        finally {

            try{

                repSto.close();
                prepSto.close();
                

            }
            catch(SQLException e){

            }
        
        }
        
    }
    private void tb1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb1MouseClicked
       
        DefaultTableModel model = (DefaultTableModel)tb1.getModel();
        tb1.setDefaultEditor(Object.class, null);
         int selectedRowIndex = tb1.getSelectedRow();

        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        txt_servizio.setText(model.getValueAt(selectedRowIndex, 2).toString());
        txt_costo.setText(model.getValueAt(selectedRowIndex, 6).toString());
        txt_anticipo.setText(model.getValueAt(selectedRowIndex, 4).toString());
           /* Double resto=0.0;
            Double costo=0.0;
            Double acconto=0.0;
            Double ttt=0.0;
            for(int i=0;i < tb1.getRowCount();i++){
                costo =  costo + Double.parseDouble(tb1.getValueAt(i,6).toString());
                acconto =  acconto + Double.parseDouble(tb1.getValueAt(i, 4).toString());
                
                resto = costo-acconto;
                
           
                
            }
*/
//             txt_resto.setText(decimalFormat.format(resto));
//            txt_tot.setText(decimalFormat.format(costo));
//        txt_ant.setText(decimalFormat.format(acconto));
        
    }//GEN-LAST:event_tb1MouseClicked

    private void prestazioniPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_prestazioniPopupMenuWillBecomeVisible
        // TODO add your handling code here:
         try {
            String sql = "SELECT * FROM  prestazioni ORDER BY nome ASC";
            pstva= connva.prepareStatement(sql);
            rscva = pstva.executeQuery();

            while(rscva.next())

            {
                String serv1 = rscva.getString("nome");
                prestazioni.addItem(serv1);
               

            }
           

        }
        catch (SQLException e){

        } finally{
            try{
                rscva.close();
                pstva.close();
                connva.close();
            }
            catch(SQLException e)
            {

            }
        }
    }//GEN-LAST:event_prestazioniPopupMenuWillBecomeVisible

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        dataora =  DateTimeFormatter.ofPattern("dd-MM-yyyy").format(LocalDateTime.now()); 
        int sec = tb1.getSelectedRow();
        String numero = tb1.getValueAt(sec, 1).toString();
       try{
            DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
            decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
            String val1 = combo_cliente.getText();
            if(val1.isEmpty()){JOptionPane.showMessageDialog(null, "Nessuna Cliente selezionato");}
            else{
                int x = JOptionPane.showConfirmDialog(null,"Sei sicuro di voler aggiornare la seguente prestazione?","Aggiorna Prestazione",JOptionPane.YES_NO_OPTION);
                if(x==0){
                    String account = txt_anticipo.getText();
                    String servizio = txt_servizio.getText();
                    Double var_anticipo = Double.valueOf(txt_anticipo.getText());
                    Double costo = Double.valueOf(txt_costo.getText());
                    int row = tb1.getSelectedRow();
                    String ant1 = tb1.getValueAt(row, 4).toString();
                    Double resto=0.00;
                    Double sum=0.00;
                    Double anti=0.00;
                    Double nett=0.00;
                    Double ttot=0.00;
                    for(int i=0;i < tb1.getRowCount();i++){
                        sum =  sum + Double.parseDouble(tb1.getValueAt(i, 6).toString());
                        anti =  anti + Double.parseDouble(tb1.getValueAt(i,4 ).toString());
                        ttot=ttot + Double.parseDouble(tb1.getValueAt(i, 6).toString());
                        resto = (ttot - anti);
                        //resto=Math.ceil(resto);
                        }
                    Double resto1 = costo - var_anticipo-Double.parseDouble(tb1.getValueAt(row,4 ).toString());
                    String sql="update prestazione_cliente set prezzo=?,acconto=?,resto=? ,dataora=?,tipo=? where cliente=? and nome=? and id=?";
                    System.out.println("Query update: "+sql);
                    pstUpd=connUpd.prepareStatement(sql);
                    var_anticipo = Double.valueOf(txt_anticipo.getText())+Double.valueOf(ant1);
                    pstUpd.setDouble(1, costo);
                    pstUpd.setDouble(2, var_anticipo);
                    pstUpd.setDouble(3, resto1);
                    pstUpd.setString(4, dataora);
                    pstUpd.setString(5, "aggiornamento");
                    pstUpd.setString(6, val1);
                    pstUpd.setString(7, servizio);
                    pstUpd.setString(8, numero);
                    Update_table();
                   pstUpd.execute();
                   
                   String sqlfurb = "insert into storico_acc (cliente,nome,dataora,acconto) values(?,?,?,?)";
                   Connection furb = Db.db();
                   PreparedStatement psfurb = furb.prepareStatement(sqlfurb);
                   psfurb.setString(1, val1);
                   psfurb.setString(2, servizio);
                   psfurb.setString(3, dataora);
                   psfurb.setString(4, account);
                   psfurb.execute();
                   Update_table();
                   PopulatePrest();
                     //tb1.removeColumn(tb1.getColumnModel().getColumn(1));
                    //tb1.removeColumn(tb1.getColumnModel().getColumn(5));
                    
                    txt_tot.setText(decimalFormat.format(sum));
                    txt_ant.setText(decimalFormat.format(anti));
                    resto=ttot-anti;
                    txt_resto.setText(decimalFormat.format(resto));
                    txt_tt.setText(decimalFormat.format(ttot));
                  

Update_table();
PopulatePrest();
                    
                    JOptionPane.showMessageDialog(null,"Prestazione modificata correttamente" );
                   Update_table(); 
                   PopulatePrest();
                    txt_costo.setText("");
                    txt_servizio.setText("");
                    txt_anticipo.setText("");
                  


                }}}
                catch(SQLException | HeadlessException e)
                {
                    JOptionPane.showMessageDialog(null,"Errore modifica prestazione");
                }


    }//GEN-LAST:event_jButton3ActionPerformed

    private void bt_elim1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_elim1ActionPerformed
        // TODO add your handling code here:

         Object[] options = {"Si", "No"};

        int n = JOptionPane
                .showOptionDialog(null, "Sei sicuro di voler cancellare le prestazioni selezionate?",
                        "Conferma cancellazione?",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, options,
                        options[1]);

        if (n == 0) // Confirm Delete = Yes
        {

            for (int i = 0; i < tb1.getRowCount(); i++) {

                Boolean chkDel = Boolean.valueOf(tb1.getValueAt(i, 0).toString()); // Checked

                if(chkDel) // Checked to Delete
                {
                    
                    

                    String nome = tb1.getValueAt(i, 2).toString();
                     String cliente = combo_cliente.getText();
                    String id = tb1.getValueAt(i, 1).toString();
                    int row = tb1.getSelectedRow();
                    DeleteDataPrest(nome,cliente,id); 
                    System.out.println("Cancello 3");
                    DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
                     decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
                    Double sum=0.00;
                    Double anti =0.00;
                    Double  ttot = 0.00;
                    Double resto = 0.00;
                    for(int j=0;j<tb1.getSelectedRow();j++){    
                    sum =   Double.parseDouble(tb1.getValueAt(j, 5).toString());
                         anti =  Double.parseDouble(tb1.getValueAt(j,3 ).toString());
                      ttot = Double.parseDouble(tb1.getValueAt(j, 5).toString());
                        resto = ((ttot + Double.parseDouble(tb1.getValueAt(j, 5).toString())) - (anti + Double.parseDouble(tb1.getValueAt(j, 3).toString())));
                        //resto=Math.ceil(resto);
                    
                     Update_table();
                    PopulatePrest();
                   
                    }
                     Update_table();
                    PopulatePrest();
                    
                }

            }

            JOptionPane.showMessageDialog(null, "prestazione/i cancallate correttamente");
            txt_costo.setText("");
                    txt_servizio.setText("");
                    txt_anticipo.setText("");
        }
    }//GEN-LAST:event_bt_elim1ActionPerformed

    private void txt_anticipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_anticipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_anticipoActionPerformed
    
    private void txt_costoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_costoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_costoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        CartellaClinica.getObj().paziente.setText(comb);
        CartellaClinica.getObj().PopulateData();
      CartellaClinica.getObj().setVisible(true);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        Appuntamenti.getObj().setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {
            // TODO add your handling code here:
            //deve aprire cartella dei report

            listFiles();
        } catch (IOException ex) {
            Logger.getLogger(Clients.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Clients.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Clients().setVisible(true);
                
            }
            
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bnt_agg_sek;
    private javax.swing.JButton bt_elim1;
    private javax.swing.JButton btn8;
    private javax.swing.JLabel chiudi;
    public javax.swing.JTextField combo_cliente;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel minimizza;
    public javax.swing.JComboBox prestazioni;
    private javax.swing.JTable tb1;
    private javax.swing.JLabel txt_ant;
    private javax.swing.JTextField txt_anticipo;
    public javax.swing.JTextField txt_c;
    private javax.swing.JTextField txt_costo;
    public javax.swing.JTextField txt_n;
    private javax.swing.JLabel txt_resto;
    private javax.swing.JLabel txt_servizio;
    private javax.swing.JLabel txt_tot;
    private javax.swing.JLabel txt_tt;
    // End of variables declaration//GEN-END:variables
}
