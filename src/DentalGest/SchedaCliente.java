/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DentalGest;

import com.itextpdf.text.Element;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;


/**
 *
 * @author Paolo
 */
public final class SchedaCliente extends javax.swing.JFrame {
    Connection connv=null;
    Connection conna=null;
    Connection conne=null;
    Connection conn=null;
    Connection conn1=null;
    Connection conn2=null;
    Connection conn3=null;
    Connection conns=null;
    Connection coni=null;
    Connection repo=null;
    ResultSet rs=null;
    ResultSet rsc=null;
    ResultSet rscv=null;
    ResultSet rscs=null;
    PreparedStatement pstv=null;
    PreparedStatement psti=null;
    PreparedStatement pstz=null;
    PreparedStatement pstcc=null;
    PreparedStatement pst=null;
    PreparedStatement pstr=null;
    PreparedStatement prep=null;
    Statement pstcheck=null;
    ResultSet rss=null;
     ResultSet rscd=null;
     ResultSet rep=null;
    PreparedStatement psts=null;
    
    /**
     * Creates new form Clients
     */
    SchedaCliente() {
        initComponents();
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
    private static SchedaCliente obj=null;
    
    public static SchedaCliente getObj(){
        if(obj==null){
            obj=new SchedaCliente();
        }return obj;
    }
        
    
    
     void Update_table() {
    try{
        
        String cerca= ric_serv.getText();
        String sql ="select * from servizi_erogati where azienda='"+cerca+"'";
        
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
            Double impu=0.0;
            Double accu=0.0;
            Double scorpu=0.0;
            Double ttt=0.0;
            tb1.removeColumn(tb1.getColumnModel().getColumn(1));
        tb1.removeColumn(tb1.getColumnModel().getColumn(4));
        tb1.removeColumn(tb1.getColumnModel().getColumn(4));
            for(int i=0;i < tb1.getRowCount();i++){
                impu =  impu + Double.parseDouble(tb1.getValueAt(i,1 ).toString());
                accu =  accu + Double.parseDouble(tb1.getValueAt(i, 3).toString());
                scorpu= scorpu + Double.parseDouble(tb1.getValueAt(i, 2).toString());
                ttt=ttt+Double.parseDouble(tb1.getValueAt(i,4).toString());
                resu = ttt - accu;
            }
           
            txt_tot.setText(decimalFormat.format(impu));
            txt_ant.setText(decimalFormat.format(accu));
            txt_resto.setText(decimalFormat.format(resu));
            txt_iv.setText(decimalFormat.format(scorpu));
            txt_tt.setText(decimalFormat.format(ttt));

       
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

    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        ric_serv = new javax.swing.JTextField();
        bnt_agg = new javax.swing.JButton();
        txt_resto = new javax.swing.JLabel();
        combo_ser = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txt_tot = new javax.swing.JLabel();
        btn5 = new javax.swing.JButton();
        bnt_agg_sek = new javax.swing.JButton();
        txt_ant = new javax.swing.JLabel();
        txt_servizio = new javax.swing.JLabel();
        combo_ser_sek = new javax.swing.JComboBox();
        btn8 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb1 = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        txt_iv = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        bt_elim1 = new javax.swing.JButton();
        app = new javax.swing.JLabel();
        txt_costo = new javax.swing.JTextField();
        txt_iva = new javax.swing.JTextField();
        txt_anticipo = new javax.swing.JTextField();
        txt_tt = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        combo_azienda = new javax.swing.JComboBox<>();
        combo_scelta = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("MascGest - Gestione Clienti");
        setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        setUndecorated(true);
        getContentPane().setLayout(null);

        jLabel1.setText("Azienda:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(40, 100, 70, 14);

        jLabel2.setText("Servizio:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(40, 130, 60, 14);

        jLabel3.setText("Iva:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(160, 160, 30, 14);

        jLabel4.setText("Imponibile:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(20, 160, 70, 14);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MascGest/images/minimizza.png"))); // NOI18N
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel9);
        jLabel9.setBounds(960, 20, 20, 20);

        ric_serv.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(52, 147, 81)));
        ric_serv.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ric_servKeyReleased(evt);
            }
        });
        getContentPane().add(ric_serv);
        ric_serv.setBounds(753, 120, 230, 25);

        bnt_agg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MascGest/images/aggiungi.png"))); // NOI18N
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
        getContentPane().add(bnt_agg);
        bnt_agg.setBounds(50, 560, 70, 40);

        txt_resto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(52, 147, 81)));
        getContentPane().add(txt_resto);
        txt_resto.setBounds(840, 570, 90, 25);

        combo_ser.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        combo_ser.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));
        combo_ser.setToolTipText("Seleziona Servizio Confagricoltura Avellino");
        combo_ser.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(52, 147, 81)));
        combo_ser.setEditor(null);

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_ONCE, combo_ser, org.jdesktop.beansbinding.ObjectProperty.create(), combo_ser, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);

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
        getContentPane().add(combo_ser);
        combo_ser.setBounds(150, 570, 320, 25);

        jLabel5.setText("Saldo:  €");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(780, 570, 50, 14);

        jLabel8.setText("   Acconto:  €");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(570, 570, 80, 14);

        jLabel7.setText("Imponibile: €");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(580, 540, 80, 14);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MascGest/images/chiudi.png"))); // NOI18N
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel10);
        jLabel10.setBounds(980, 20, 20, 20);

        jLabel11.setText("Anticipo:");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(260, 160, 50, 14);

        txt_tot.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(52, 147, 81)));
        getContentPane().add(txt_tot);
        txt_tot.setBounds(660, 540, 80, 25);

        btn5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MascGest/images/pulsanti/adesioni-off.png"))); // NOI18N
        btn5.setBorder(null);
        btn5.setContentAreaFilled(false);
        btn5.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/MascGest/images/pulsanti/adesioni-on.png"))); // NOI18N
        btn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn5ActionPerformed(evt);
            }
        });
        getContentPane().add(btn5);
        btn5.setBounds(430, 110, 71, 71);

        bnt_agg_sek.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MascGest/images/aggiungi.png"))); // NOI18N
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
        getContentPane().add(bnt_agg_sek);
        bnt_agg_sek.setBounds(50, 490, 70, 40);

        txt_ant.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(52, 147, 81)));
        getContentPane().add(txt_ant);
        txt_ant.setBounds(660, 570, 80, 25);

        txt_servizio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(52, 147, 81)));
        getContentPane().add(txt_servizio);
        txt_servizio.setBounds(130, 130, 220, 25);

        combo_ser_sek.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        combo_ser_sek.setToolTipText("Seleziona servizio Se'Koma Servizi SRL");
        combo_ser_sek.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(52, 147, 81)));
        combo_ser_sek.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                combo_ser_sekPopupMenuWillBecomeVisible(evt);
            }
        });
        getContentPane().add(combo_ser_sek);
        combo_ser_sek.setBounds(150, 500, 320, 25);

        btn8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MascGest/images/pulsanti/report_off.png"))); // NOI18N
        btn8.setToolTipText("Seleziona azienda da menu a tendina");
        btn8.setBorder(null);
        btn8.setContentAreaFilled(false);
        btn8.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/MascGest/images/pulsanti/report_on.png"))); // NOI18N
        btn8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn8ActionPerformed(evt);
            }
        });
        getContentPane().add(btn8);
        btn8.setBounds(520, 110, 71, 71);

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

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(42, 220, 930, 240);

        jLabel12.setText("    Iva:   €");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(780, 540, 50, 14);

        txt_iv.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(52, 147, 81)));
        getContentPane().add(txt_iv);
        txt_iv.setBounds(840, 540, 90, 25);

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MascGest/images/modifica.png"))); // NOI18N
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.setFocusPainted(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(370, 70, 75, 47);

        bt_elim1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        bt_elim1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MascGest/images/elimina.png"))); // NOI18N
        bt_elim1.setBorderPainted(false);
        bt_elim1.setContentAreaFilled(false);
        bt_elim1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_elim1ActionPerformed(evt);
            }
        });
        getContentPane().add(bt_elim1);
        bt_elim1.setBounds(460, 70, 75, 47);
        getContentPane().add(app);
        app.setBounds(10, 170, 0, 0);

        txt_costo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(52, 147, 81)));
        txt_costo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_costoActionPerformed(evt);
            }
        });
        getContentPane().add(txt_costo);
        txt_costo.setBounds(90, 160, 60, 25);

        txt_iva.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(52, 147, 81)));
        txt_iva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_ivaActionPerformed(evt);
            }
        });
        getContentPane().add(txt_iva);
        txt_iva.setBounds(190, 160, 60, 25);

        txt_anticipo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(52, 147, 81)));
        txt_anticipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_anticipoActionPerformed(evt);
            }
        });
        getContentPane().add(txt_anticipo);
        txt_anticipo.setBounds(320, 160, 72, 25);
        getContentPane().add(txt_tt);
        txt_tt.setBounds(960, 510, 0, 0);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(52, 147, 81));
        jLabel13.setText("Società:");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(40, 70, 70, 14);

        combo_azienda.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        combo_azienda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Seleziona Azienda -" }));
        combo_azienda.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                combo_aziendaPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                combo_aziendaPopupMenuWillBecomeVisible(evt);
            }
        });
        getContentPane().add(combo_azienda);
        combo_azienda.setBounds(130, 100, 220, 23);

        combo_scelta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        combo_scelta.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "- Seleziona Società -", "Se Koma Servizi SRL", "Confagricoltura Avellino" }));
        combo_scelta.setToolTipText("\n");
        combo_scelta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(52, 147, 81)));
        combo_scelta.setOpaque(false);
        combo_scelta.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                combo_sceltaPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        combo_scelta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_sceltaActionPerformed(evt);
            }
        });
        getContentPane().add(combo_scelta);
        combo_scelta.setBounds(130, 70, 220, 23);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MascGest/images/gestione-adesioni.png"))); // NOI18N
        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(52, 147, 81)));
        getContentPane().add(jLabel6);
        jLabel6.setBounds(0, 0, 1010, 630);

        bindingGroup.bind();

        setSize(new java.awt.Dimension(1010, 633));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ric_servKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ric_servKeyReleased
        // TODO add your handling code here:
        
        try{
            
            txt_servizio.setText("");
            txt_costo.setText("");
            txt_iva.setText("");
            txt_anticipo.setText("");
            txt_tot.setText("");
            txt_ant.setText("");
            txt_resto.setText("");
            String contain=ric_serv.getText().toLowerCase();
            String sql="select * from servizi_erogati where azienda = '"+contain+"'";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            tb1.setModel(DbUtils.resultSetToTableModel(rs));
             tb1.removeColumn(tb1.getColumnModel().getColumn(1));
             tb1.removeColumn(tb1.getColumnModel().getColumn(4));
           tb1.removeColumn(tb1.getColumnModel().getColumn(4));
            DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
            Double res=0.0;
            Double imp=0.0;
            Double acc=0.0;
            Double scorp=0.0;
            Double ttt=0.0;
            for(int i=0;i < tb1.getRowCount();i++){
                imp =  imp + Double.parseDouble(tb1.getValueAt(i,1 ).toString());
                acc =  acc + Double.parseDouble(tb1.getValueAt(i, 3).toString());
                scorp= scorp + Double.parseDouble(tb1.getValueAt(i, 2).toString());
                ttt=ttt+Double.parseDouble(tb1.getValueAt(i,4).toString());
               res = ttt - acc;
            }
            txt_tot.setText(decimalFormat.format(imp));
            txt_ant.setText(decimalFormat.format(acc));
            txt_resto.setText(decimalFormat.format(res));
            txt_iv.setText(decimalFormat.format(scorp));
            txt_tt.setText(decimalFormat.format(ttt));

            
           
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
    }//GEN-LAST:event_ric_servKeyReleased

    private void bnt_aggActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnt_aggActionPerformed
        // TODO add your handling code here:
        
            try{
              
                String azienda = ric_serv.getText().toLowerCase();
                if(azienda.isEmpty()){JOptionPane.showMessageDialog(null, "Selezionare un'azienda a menu a tendina");}
                else{
                    String servizio = combo_ser.getSelectedItem().toString();
                    int x = JOptionPane.showConfirmDialog(null,"Sei sicuro di voler aggiungere il seguente servizio","Aggiungi Servizio",JOptionPane.YES_NO_OPTION);

                    if(x==0){    
   
                pstcheck = conn.createStatement();
                rsc = pstcheck.executeQuery("select nome from servizi_erogati where azienda='"+azienda+"'and nome='"+servizio+"'");
                if(rsc.next()){
                    JOptionPane.showMessageDialog(null,"Servizio già esistente per l'azienda "+azienda );
                }
                else {
                    int ivac=0;
                    Double imponibilec,accc,scorpc,resc,totc;
                    imponibilec=0.00;
                    accc=0.00;
                    scorpc=0.00;
                    resc=0.00;
                    totc=0.00;
                    
                    String impc=Double.toString(imponibilec);
                    String iva_applicatac=Integer.toString(ivac);
                    String accontoc=Double.toString(accc);
                    String scorporoc=Double.toString(scorpc);
                    String resoc=Double.toString(resc);
                    String totalec=Double.toString(totc);
                    String sql="insert into servizi_erogati (nome,azienda,imponibile,scorporo,acconto,reso,iva,totale) values (?,?,?,?,?,?,?,?)";
                    
                pst=conn.prepareStatement(sql);

                     pst.setString(1,servizio);
                    pst.setString(2,azienda);
                    pst.setString(3,impc);
                    pst.setString(4,scorporoc);
                    pst.setString(5,accontoc);
                    pst.setString(6,resoc);
                    pst.setString(7,iva_applicatac);
                    pst.setString(8, totalec);

                    pst.execute();
                    JOptionPane.showMessageDialog(null,"Servizio salvato correttamente" );
                    
                }
                Update_table();
                
                
                txt_costo.setText("");
                txt_iva.setText("");
                txt_anticipo.setText("");
                } }  
            }catch(SQLException | HeadlessException e)
            {
                JOptionPane.showMessageDialog(null,"Errore Salvataggio Servizio");
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
    }                                               

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
       
    }//GEN-LAST:event_bnt_aggActionPerformed

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        // TODO add your handling code here:
        setExtendedState(JFrame.ICONIFIED );
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        // TODO add your handling code here:

dispose();
    }//GEN-LAST:event_jLabel10MouseClicked

    private void combo_serPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_combo_serPopupMenuWillBecomeVisible
        // TODO add your handling code here:
       try {
            String sql = "SELECT * FROM  servizi ORDER BY nome_s  ASC";
            pstz= conn3.prepareStatement(sql);
            rscs = pstz.executeQuery();

            while(rscs.next())

            {
                String serv = rscs.getString("nome_s");
                combo_ser.addItem(serv);

            }

        }
        catch (SQLException e){

        } finally{
            try{
                rscs.close();
                pstz.close();
                conn3.close();
            }
            catch(SQLException e)
            {

            }
        }
            
    }//GEN-LAST:event_combo_serPopupMenuWillBecomeVisible

    private void btn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn5ActionPerformed
        // TODO add your handling code here:
        modifica_adesione.getObj().setVisible(true);
        modifica_adesione.getObj().setExtendedState( JFrame.NORMAL );
    }//GEN-LAST:event_btn5ActionPerformed

    private void combo_serPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_combo_serPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        combo_ser.setSelectedItem("");
    }//GEN-LAST:event_combo_serPopupMenuWillBecomeInvisible

    private void bnt_agg_sekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnt_agg_sekActionPerformed
        // TODO add your handling code here:
        try{
                
                String azienda = ric_serv.getText().toLowerCase();
                if(azienda.isEmpty()){JOptionPane.showMessageDialog(null, "Selezionare un'azienda a menu a tendina");}
                else{
                    String servizio = combo_ser_sek.getSelectedItem().toString();
                    int x = JOptionPane.showConfirmDialog(null,"Sei sicuro di voler aggiungere il seguente servizio","Aggiungi Servizio",JOptionPane.YES_NO_OPTION);

                    if(x==0){    
   
                pstcheck = conn.createStatement();
                rsc = pstcheck.executeQuery("select nome from servizi_erogati where azienda='"+azienda+"'and nome='"+servizio+"'");
                if(rsc.next()){
                    JOptionPane.showMessageDialog(null,"Servizio già esistente per l'azienda "+azienda );
                }
                else {
                    int ivas=0;
                    Double imponibiles,accs,scorps,ress,tot;
                    imponibiles=0.00;
                    accs=0.00;
                    scorps=0.00;
                    ress=0.00;
                    tot=0.00;
                    
                    String imps=Double.toString(imponibiles);
                    String iva_applicatas=Integer.toString(ivas);
                    String accontos=Double.toString(accs);
                    String scorporos=Double.toString(scorps);
                    String resos=Double.toString(ress);
                    String totales=Double.toString(tot);
                    String sql="insert into servizi_erogati (nome,azienda,imponibile,scorporo,acconto,reso,iva,totale) values (?,?,?,?,?,?,?,?)";
                    pst=conn.prepareStatement(sql);

                    pst.setString(1,servizio);
                    pst.setString(2,azienda);
                    pst.setString(3,imps);
                    pst.setString(4,scorporos);
                    pst.setString(5,accontos);
                    pst.setString(6,resos);
                    pst.setString(7,iva_applicatas);
                    pst.setString(8,totales);

                    pst.execute();
                    JOptionPane.showMessageDialog(null,"Servizio salvato correttamente" );
                    
                }
                Update_table();
                
                
                txt_costo.setText("");
                txt_iva.setText("");
                txt_anticipo.setText("");
                } }  
            }catch(SQLException | HeadlessException e)
            {
                JOptionPane.showMessageDialog(null,"Errore Salvataggio Servizio");
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
    
         txt_tot.getText();
         txt_ant.getText();
         txt_resto.getText();
         
         Update_table();
        try{
            
            String scelta= ric_serv.getText();
            
            String sql = "select * from servizi_erogati where azienda='"+scelta+"'";
            prep=repo.prepareStatement(sql);
            rep=prep.executeQuery();
            Document d=new Document();
            PdfWriter.getInstance(d, new FileOutputStream("c:/mascgest/reports/saldo-"+scelta+".pdf"));
            d.open();
            
            Image image = Image.getInstance("c:/mascgest/testata.png");
            PdfPCell cell=new PdfPCell();
            d.add(image);
            Paragraph n=new Paragraph("\n");
            cell.setColspan(2);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setPadding(8.0f);
            Font font=new Font();
            font.setColor(52,147,81);
            font.setSize(28);
            Paragraph azienda= new Paragraph(scelta,font);
            azienda.setAlignment(Element.ALIGN_CENTER);
            d.add(azienda); /* Font Size */
            
            d.add(n);d.add(n);
            
            d.add(n);
            PdfPTable ptableh = new PdfPTable(4);
               String nomeh="Servizio";
               String prezzoh="Imponibile";
               //String ivah="Iva Applicata";
               String nettoh="Iva Calcolata";
               String ivatoh="Totale";  
               PdfPCell cell1h=new PdfPCell(new Paragraph(nomeh));
               cell1h.setBorderColor(new Color(52,147,81));
               cell1h.setBackgroundColor(new Color(52,147,81));
               cell1h.setHorizontalAlignment(Element.ALIGN_LEFT);
               PdfPCell cell2h=new PdfPCell(new Paragraph(prezzoh)); 
               cell2h.setBorderColor(new Color(52,147,81));
                cell2h.setBackgroundColor(new Color(52,147,81));
                cell2h.setHorizontalAlignment(Element.ALIGN_RIGHT);
                PdfPCell cell3h=new PdfPCell(new Paragraph(ivatoh));
               cell3h.setBorderColor(new Color(52,147,81));
                cell3h.setBackgroundColor(new Color(52,147,81));
               cell3h.setHorizontalAlignment(Element.ALIGN_RIGHT);
               //PdfPCell cell4h=new PdfPCell(new Paragraph(ivah));
                //cell4h.setBorderColor(new Color(52,147,81));
                 //cell4h.setBackgroundColor(new Color(52,147,81));
                //cell4h.setHorizontalAlignment(Element.ALIGN_RIGHT);
                 PdfPCell cell5h=new PdfPCell(new Paragraph(nettoh));
                cell5h.setBorderColor(new Color(52,147,81));
                 cell5h.setBackgroundColor(new Color(52,147,81));
                cell5h.setHorizontalAlignment(Element.ALIGN_RIGHT);
                ptableh.addCell(cell1h);
                ptableh.addCell(cell2h);
                ptableh.addCell(cell5h);
                //ptableh.addCell(cell4h);
                ptableh.addCell(cell3h);
                d.add(ptableh);
            while(rep.next()){
               PdfPTable ptable = new PdfPTable(4);
               String nome=rep.getString("nome");
               String impon=rep.getString("imponibile");
               String iva_calc=rep.getString("scorporo");
               //String iva_app=rep.getString("iva");
               String total=rep.getString("totale");
               PdfPCell cell1=new PdfPCell(new Paragraph(nome));
               cell1.setBorderColor(new Color(52,147,81));
               cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
               PdfPCell cell2=new PdfPCell(new Paragraph("€"+impon)); 
               cell2.setBorderColor(new Color(52,147,81));
                cell2.setHorizontalAlignment(Element.ALIGN_RIGHT);
                PdfPCell cell3=new PdfPCell(new Paragraph("€"+iva_calc));
               cell3.setBorderColor(new Color(52,147,81));
               cell3.setHorizontalAlignment(Element.ALIGN_RIGHT);
               //PdfPCell cell4=new PdfPCell(new Paragraph(""+iva_app));
                //cell4.setBorderColor(new Color(52,147,81));
                //cell4.setHorizontalAlignment(Element.ALIGN_RIGHT);
                PdfPCell cell5=new PdfPCell(new Paragraph("€"+total));
                cell5.setBorderColor(new Color(52,147,81));
                cell5.setHorizontalAlignment(Element.ALIGN_RIGHT);
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
            String iv=txt_iv.getText();
            String totaler=txt_tt.getText();
            String accontor=txt_ant.getText();
            PdfPCell cell3=new PdfPCell(new Paragraph("Totale: €"+totaler+ "\nAcconto: €"+accontor+"\nSaldo: €"+resor));
            cell3.setBorder(0);
            cell3.setHorizontalAlignment(Element.ALIGN_RIGHT);
            table1.addCell(cell3);

            d.add(table1);
            d.close();
            
            JOptionPane.showMessageDialog(null,"Report creato correttamente");
         try{
        Process exec = Runtime.getRuntime().exec("cmd.exe /C c:/mascgest/utility/open.exe");       }
         catch (IOException e){}}
        catch(HeadlessException e){
            JOptionPane.showMessageDialog(null,"Errore creazione report");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SchedaCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException | IOException | DocumentException ex) {
            Logger.getLogger(SchedaCliente.class.getName()).log(Level.SEVERE, null, ex);
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

    private void tb1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb1MouseClicked
       
        DefaultTableModel model = (DefaultTableModel)tb1.getModel();
        tb1.setDefaultEditor(Object.class, null);
         int selectedRowIndex = tb1.getSelectedRow();

        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        txt_servizio.setText(model.getValueAt(selectedRowIndex, 0).toString());
        txt_costo.setText(model.getValueAt(selectedRowIndex, 2).toString());
        txt_iva.setText(model.getValueAt(selectedRowIndex, 6).toString());
        txt_anticipo.setText(model.getValueAt(selectedRowIndex, 4).toString());
            Double res=0.0;
            Double imp=0.0;
            Double acc=0.0;
            Double scorp=0.0;
            Double ttt=0.0;
            for(int i=0;i < tb1.getRowCount();i++){
                imp =  imp + Double.parseDouble(tb1.getValueAt(i,1 ).toString());
                acc =  acc + Double.parseDouble(tb1.getValueAt(i, 3).toString());
                
                scorp= scorp + Double.parseDouble(tb1.getValueAt(i, 2).toString());
                ttt=ttt+Double.parseDouble(tb1.getValueAt(i,5).toString());
                res = ttt - acc;
            }

            txt_tot.setText(decimalFormat.format(imp));
            txt_ant.setText(decimalFormat.format(acc));
            txt_resto.setText(decimalFormat.format(res));
            txt_iv.setText(decimalFormat.format(scorp));
            txt_tt.setText(decimalFormat.format(ttt));

        
    }//GEN-LAST:event_tb1MouseClicked

    private void combo_ser_sekPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_combo_ser_sekPopupMenuWillBecomeVisible
        // TODO add your handling code here:
         try {
            String sql = "SELECT * FROM  servizi_s ORDER BY nome_s  ASC";
            pstv= connv.prepareStatement(sql);
            rscv = pstv.executeQuery();

            while(rscv.next())

            {
                String serv1 = rscv.getString("nome_s");
                combo_ser_sek.addItem(serv1);

            }

        }
        catch (SQLException e){

        } finally{
            try{
                rscv.close();
                pstv.close();
                connv.close();
            }
            catch(SQLException e)
            {

            }
        }
    }//GEN-LAST:event_combo_ser_sekPopupMenuWillBecomeVisible

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:

        try{
            DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
            decimalFormat.setRoundingMode(RoundingMode.HALF_UP);

            String val1 = ric_serv.getText().toLowerCase();
            if(val1.isEmpty()){JOptionPane.showMessageDialog(null, "Nessuna Azienda/Servizio selezionato");}
            else{
                int x = JOptionPane.showConfirmDialog(null,"Sei sicuro di voler aggiornare il seguente servizio?","Aggiorna Servizio",JOptionPane.YES_NO_OPTION);
                if(x==0){
                    String servizio = txt_servizio.getText();

                    String prezzo = txt_costo.getText();

                    String var_iva = txt_iva.getText();
                    String var_anticipo = txt_anticipo.getText();
                    Double senza_iva,il_totale;
                    
                    
                    senza_iva=(Double.parseDouble(prezzo) * (1+(Double.parseDouble(var_iva)/100))) - Double.parseDouble(prezzo);
                    senza_iva=senza_iva*100;
                    double si=Math.ceil(senza_iva);
                    si=si/100;
                    il_totale=(Double.parseDouble(prezzo)+si);
                    il_totale=il_totale*100;
                    double tot=Math.ceil(il_totale);
                    tot=tot/100;
                    String ptot=Double.toString(tot);
                    String senza_iv=Double.toString(si);
                    app.setText(senza_iv);
                    Double resto=0.00;
                    Double sum=0.00;
                    Double anti=0.00;
                    Double nett=0.00;
                    Double ttot=0.00;
                    for(int i=0;i < tb1.getRowCount();i++){
                        sum =  sum + Double.parseDouble(tb1.getValueAt(i,1 ).toString());
                        anti =  anti + Double.parseDouble(tb1.getValueAt(i,3 ).toString());
                        nett= nett + Double.parseDouble(tb1.getValueAt(i, 2).toString());
                        ttot=ttot + Double.parseDouble(tb1.getValueAt(i, 4).toString());
                        resto = (ttot - anti);
                        //resto=Math.ceil(resto);
                        }
                    
                    String sql="update servizi_erogati set nome='"+servizio+"',azienda='"+val1+"',imponibile='"+prezzo+"',iva='"+var_iva+"',acconto='"+var_anticipo+"',scorporo='"+senza_iv+"',totale='"+ptot+"' where azienda='"+val1+"' and nome='"+servizio+"'";
                    String acc="update servizi_erogati set reso='"+resto+"' where azienda='"+val1+"'"; 
                    pst=conn.prepareStatement(sql);
                   pst.execute();
                           
                    pst=conn.prepareStatement(acc);
                    pst.execute();
                     //tb1.removeColumn(tb1.getColumnModel().getColumn(1));
                    //tb1.removeColumn(tb1.getColumnModel().getColumn(5));
                    
                    txt_tot.setText(decimalFormat.format(sum));
                    txt_ant.setText(decimalFormat.format(anti));
                    resto=ttot-anti;
                    txt_resto.setText(decimalFormat.format(resto));
                    txt_iv.setText(decimalFormat.format(nett));
                    txt_tt.setText(decimalFormat.format(ttot));
                                                    //tb1.removeColumn(tb1.getColumnModel().getColumn(5));


                    
                    JOptionPane.showMessageDialog(null,"Servizio modificato correttamente per l'azienda "+val1 );
                   Update_table(); 
                    txt_costo.setText("");
                    txt_servizio.setText("");
                   txt_iva.setText("");
                    txt_anticipo.setText("");
                  


                }}}
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
                }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void bt_elim1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_elim1ActionPerformed
        // TODO add your handling code here:

        try{

            String azienda = ric_serv.getText().toLowerCase();
            if(azienda.isEmpty()){JOptionPane.showMessageDialog(null, "Nessuna Azienda/Servizio selezionato");}
            else{

                String servizio = txt_servizio.getText();
                int x = JOptionPane.showConfirmDialog(null,"Sei sicuro di voler rimuovere il seguente servizio?","Elimina Servizio",JOptionPane.YES_NO_OPTION);
                if(x==0){
                    String sql = "delete from servizi_erogati where nome='"+servizio+"' and azienda='"+azienda+"'";

                    psti=coni.prepareStatement(sql);
                    psti.execute();
                    Update_table();
                    
                    JOptionPane.showMessageDialog(null,"Servizio eliminato correttamente" );

                    txt_costo.setText("");
                    txt_servizio.setText("");
                    txt_iva.setText("");
                    txt_anticipo.setText("");

                }}}
                catch(SQLException | HeadlessException e)
                {
                    JOptionPane.showMessageDialog(null,"Errore eliminazione Servizio " );
                }
    }//GEN-LAST:event_bt_elim1ActionPerformed

    private void txt_costoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_costoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_costoActionPerformed

    private void txt_ivaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_ivaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ivaActionPerformed

    private void txt_anticipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_anticipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_anticipoActionPerformed

    private void combo_sceltaPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_combo_sceltaPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
                    String scelta=combo_scelta.getSelectedItem().toString();
        if(scelta.equals("- Seleziona Società -")){
            combo_azienda.removeAllItems();
            combo_azienda.setEnabled(false);
            tb1.setVisible(false);
                    txt_costo.setText("");
                    txt_servizio.setText("");
                    txt_iva.setText("");
                    txt_anticipo.setText("");
                    txt_tot.setText("");
                    txt_ant.setText("");
                    txt_resto.setText("");
                    txt_iv.setText("");
                    txt_tt.setText("");
                    ric_serv.setText("");
            
        }
        else{
            combo_azienda.setEnabled(true);
            tb1.setVisible(true);
        }
    }//GEN-LAST:event_combo_sceltaPopupMenuWillBecomeInvisible

    private void combo_sceltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_sceltaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_sceltaActionPerformed

    private void combo_aziendaPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_combo_aziendaPopupMenuWillBecomeVisible
        // TODO add your handling code here:
        combo_azienda.removeAllItems();
       txt_servizio.setText("");
       txt_costo.setText("");
       txt_iva.setText("");
       txt_anticipo.setText("");
        String scelta=combo_scelta.getSelectedItem().toString();
       try {
        String sql = "SELECT azienda FROM  adesione where soc='"+scelta+"' ORDER BY azienda ASC";
        psts = conne.prepareStatement(sql);
        rss = psts.executeQuery();
     
        while(rss.next())

{   
combo_azienda.addItem(rss.getString("azienda"));

}
      
        }
        catch (SQLException e){
                
        } 
       finally{
           try {
               rss.close();
               psts.close();
               
               //conne.close();
           } catch (SQLException ex) {
               Logger.getLogger(SchedaCliente.class.getName()).log(Level.SEVERE, null, ex);
           }

       }  
    }//GEN-LAST:event_combo_aziendaPopupMenuWillBecomeVisible
    
    private void combo_aziendaPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_combo_aziendaPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        try{
            String azienda = combo_azienda.getSelectedItem().toString();
           String sql="select * from servizi_erogati where azienda=?";
            pst=conn.prepareStatement(sql);
            pst.setString(1,azienda);
            rs=pst.executeQuery();
            tb1.setModel(DbUtils.resultSetToTableModel(rs));
            tb1.removeColumn(tb1.getColumnModel().getColumn(1));
             tb1.removeColumn(tb1.getColumnModel().getColumn(4));
                          tb1.removeColumn(tb1.getColumnModel().getColumn(4));
            DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
            Double res=0.0;
            Double imp=0.0;
            Double acc=0.0;
            Double scorp=0.0;
            Double ttt=0.0;
            for(int i=0;i < tb1.getRowCount();i++){
                imp =  imp + Double.parseDouble(tb1.getValueAt(i,1 ).toString());
                acc =  acc + Double.parseDouble(tb1.getValueAt(i, 3).toString());
                ttt=ttt+Double.parseDouble(tb1.getValueAt(i, 4).toString());
                scorp= scorp + Double.parseDouble(tb1.getValueAt(i, 2).toString());
                res = ttt - acc;
            }
            
            ric_serv.setText(azienda);
            txt_tot.setText(decimalFormat.format(imp));
            txt_ant.setText(decimalFormat.format(acc));
            txt_resto.setText(decimalFormat.format(res));
            txt_iv.setText(decimalFormat.format(scorp));
            txt_tt.setText(decimalFormat.format(ttt));
        }
        catch(SQLException | NumberFormatException e){
            JOptionPane.showMessageDialog(null, e);
        }
        
    }//GEN-LAST:event_combo_aziendaPopupMenuWillBecomeInvisible

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
            java.util.logging.Logger.getLogger(SchedaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
        
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SchedaCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel app;
    private javax.swing.JButton bnt_agg;
    private javax.swing.JButton bnt_agg_sek;
    private javax.swing.JButton bt_elim1;
    private javax.swing.JButton btn5;
    private javax.swing.JButton btn8;
    private javax.swing.JComboBox<String> combo_azienda;
    private javax.swing.JComboBox combo_scelta;
    private javax.swing.JComboBox combo_ser;
    private javax.swing.JComboBox combo_ser_sek;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField ric_serv;
    private javax.swing.JTable tb1;
    private javax.swing.JLabel txt_ant;
    private javax.swing.JTextField txt_anticipo;
    private javax.swing.JTextField txt_costo;
    private javax.swing.JLabel txt_iv;
    private javax.swing.JTextField txt_iva;
    private javax.swing.JLabel txt_resto;
    private javax.swing.JLabel txt_servizio;
    private javax.swing.JLabel txt_tot;
    private javax.swing.JLabel txt_tt;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
