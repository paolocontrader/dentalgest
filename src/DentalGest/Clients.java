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
public final class Clients extends javax.swing.JFrame {
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
    Clients() {
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
    private static Clients obj=null;
    
    public static Clients getObj(){
        if(obj==null){
            obj=new Clients();
        }return obj;
    }
        
    
    
     void Update_table() {
    try{
        
        String cerca= ric_serv.getText();
        String cliente= combo_cliente.getSelectedItem().toString();
        String sql ="select * from prestazione_cliente where cliente='"+cerca+"' OR cliente='"+cliente+"'";
        
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
            tb1.removeColumn(tb1.getColumnModel().getColumn(1));
       
            for(int i=0;i < tb1.getRowCount();i++){
                
                accu =  accu + Double.parseDouble(tb1.getValueAt(i, 2).toString());
               
                ttt=ttt+Double.parseDouble(tb1.getValueAt(i,4).toString());
                resu = ttt - accu;
            }
           
           
            txt_ant.setText("acconto");
            txt_resto.setText("resto");
            txt_tt.setText("totale");

       
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        ric_serv = new javax.swing.JTextField();
        txt_resto = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txt_tot = new javax.swing.JLabel();
        bnt_agg_sek = new javax.swing.JButton();
        txt_ant = new javax.swing.JLabel();
        txt_servizio = new javax.swing.JLabel();
        combo_ser_sek = new javax.swing.JComboBox();
        btn8 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb1 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        bt_elim1 = new javax.swing.JButton();
        app = new javax.swing.JLabel();
        txt_costo = new javax.swing.JTextField();
        txt_anticipo = new javax.swing.JTextField();
        txt_tt = new javax.swing.JLabel();
        combo_cliente = new javax.swing.JComboBox<>();

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

        jLabel4.setText("Costo:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(40, 160, 70, 14);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DentalGest/images/minimizza.png"))); // NOI18N
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel9);
        jLabel9.setBounds(970, 0, 20, 20);

        ric_serv.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(52, 147, 81)));
        ric_serv.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ric_servKeyReleased(evt);
            }
        });
        getContentPane().add(ric_serv);
        ric_serv.setBounds(753, 120, 230, 25);

        txt_resto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(52, 147, 81)));
        getContentPane().add(txt_resto);
        txt_resto.setBounds(840, 570, 90, 25);

        jLabel5.setText("Saldo:  €");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(780, 570, 50, 14);

        jLabel8.setText("   Acconto:  €");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(570, 570, 80, 14);

        jLabel7.setText("Totale:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(580, 540, 80, 14);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DentalGest/images/chiudi.png"))); // NOI18N
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel10);
        jLabel10.setBounds(990, 0, 20, 20);

        jLabel11.setText("Anticipo:");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(260, 160, 50, 14);

        txt_tot.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(52, 147, 81)));
        getContentPane().add(txt_tot);
        txt_tot.setBounds(660, 540, 80, 25);

        bnt_agg_sek.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DentalGest/images/aggiungi.png"))); // NOI18N
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

        btn8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DentalGest/images/pulsanti/report_off.png"))); // NOI18N
        btn8.setToolTipText("Seleziona azienda da menu a tendina");
        btn8.setBorder(null);
        btn8.setContentAreaFilled(false);
        btn8.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/DentalGest/images/pulsanti/report_on.png"))); // NOI18N
        btn8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn8ActionPerformed(evt);
            }
        });
        getContentPane().add(btn8);
        btn8.setBounds(440, 120, 71, 71);

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

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DentalGest/images/modifica.png"))); // NOI18N
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
        bt_elim1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DentalGest/images/elimina.png"))); // NOI18N
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
        txt_costo.setBounds(130, 160, 60, 25);

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

        combo_cliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        combo_cliente.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                combo_clientePopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                combo_clientePopupMenuWillBecomeVisible(evt);
            }
        });
        getContentPane().add(combo_cliente);
        combo_cliente.setBounds(130, 100, 220, 23);

        setSize(new java.awt.Dimension(1010, 633));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ric_servKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ric_servKeyReleased
        // TODO add your handling code here:
        
        try{
            
            txt_servizio.setText("");
            txt_costo.setText("");
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

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        // TODO add your handling code here:
        setExtendedState(JFrame.ICONIFIED );
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        // TODO add your handling code here:

dispose();
    }//GEN-LAST:event_jLabel10MouseClicked

    private void bnt_agg_sekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnt_agg_sekActionPerformed
        // TODO add your handling code here:
        try{
                
                String cliente = combo_cliente.getSelectedItem().toString();
                if(cliente.isEmpty()){JOptionPane.showMessageDialog(null, "Selezionare un'azienda a menu a tendina");}
                else{
                    String servizio = combo_ser_sek.getSelectedItem().toString();
                    int x = JOptionPane.showConfirmDialog(null,"Sei sicuro di voler aggiungere il seguente servizio","Aggiungi Servizio",JOptionPane.YES_NO_OPTION);

                    if(x==0){    
   
                pstcheck = conn.createStatement();
                rsc = pstcheck.executeQuery("select nome from prestazione_cliente where cliente='"+cliente+"'and nome='"+servizio+"'");
                if(rsc.next()){
                    JOptionPane.showMessageDialog(null,"Servizio già esistente per l'azienda "+cliente );
                }
                else {
                    
                    Double accs,ress,tot;
                    accs=0.00;
                    ress=0.00;
                    tot=0.00;
                    
                    String accontos=Double.toString(accs);
                    String totales=Double.toString(tot);
                    String resos=Double.toString(ress);
                    String sql="insert into prestazione_cliente (nome,cliente,acconto,reso,totale) values (?,?,?,?,?)";
                    pst=conn.prepareStatement(sql);

                    pst.setString(1,servizio);
                    pst.setString(2,cliente);
                    pst.setString(3,accontos);
                    pst.setString(4,resos);
                    pst.setString(5,totales);

                    pst.execute();
                    JOptionPane.showMessageDialog(null,"Prestazione salvata correttamente" );
                    
                }
                Update_table();
                
                
                txt_costo.setText("");
                txt_anticipo.setText("");
                } }  
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

    private void tb1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb1MouseClicked
       
        DefaultTableModel model = (DefaultTableModel)tb1.getModel();
        tb1.setDefaultEditor(Object.class, null);
         int selectedRowIndex = tb1.getSelectedRow();

        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        txt_servizio.setText(model.getValueAt(selectedRowIndex, 0).toString());
        txt_costo.setText(model.getValueAt(selectedRowIndex, 5).toString());
        txt_anticipo.setText(model.getValueAt(selectedRowIndex, 2).toString());
            Double res=0.0;
            Double imp=0.0;
            Double acc=0.0;
            Double ttt=0.0;
            for(int i=0;i < tb1.getRowCount();i++){
                imp =  imp + Double.parseDouble(tb1.getValueAt(i,4 ).toString());
                acc =  acc + Double.parseDouble(tb1.getValueAt(i, 2).toString());
                
                ttt=ttt+Double.parseDouble(tb1.getValueAt(i,4).toString());
                res = ttt - acc;
            }

            txt_ant.setText(decimalFormat.format(acc));
            txt_resto.setText(decimalFormat.format(res));
            txt_tt.setText(decimalFormat.format(ttt));

        
    }//GEN-LAST:event_tb1MouseClicked

    private void combo_ser_sekPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_combo_ser_sekPopupMenuWillBecomeVisible
        // TODO add your handling code here:
         try {
            String sql = "SELECT * FROM  prestazioni ORDER BY nome ASC";
            pstv= connv.prepareStatement(sql);
            rscv = pstv.executeQuery();

            while(rscv.next())

            {
                String serv1 = rscv.getString("nome");
                String serv2 = rscv.getString("prezzo");
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

            String val1 = combo_cliente.getSelectedItem().toString();
            if(val1.isEmpty()){JOptionPane.showMessageDialog(null, "Nessuna Azienda/Servizio selezionato");}
            else{
                int x = JOptionPane.showConfirmDialog(null,"Sei sicuro di voler aggiornare il seguente servizio?","Aggiorna Servizio",JOptionPane.YES_NO_OPTION);
                if(x==0){
                    String servizio = txt_servizio.getText();

                    String prezzo = txt_costo.getText();

                   
                    String var_anticipo = txt_anticipo.getText();
                    Double senza_iva,il_totale;
                    
                    
                    il_totale=(Double.parseDouble(prezzo));
                    il_totale=il_totale*100;
                    double tot=Math.ceil(il_totale);
                    tot=tot/100;
                    String ptot=Double.toString(tot);
                    Double resto=0.00;
                    Double sum=0.00;
                    Double anti=0.00;
                    Double nett=0.00;
                    Double ttot=0.00;
                    for(int i=0;i < tb1.getRowCount();i++){
                        sum =  sum + Double.parseDouble(tb1.getValueAt(i,4 ).toString());
                        anti =  anti + Double.parseDouble(tb1.getValueAt(i,3 ).toString());
                        ttot=ttot + Double.parseDouble(tb1.getValueAt(i, 4).toString());
                        resto = (ttot - anti);
                        resto=Math.ceil(resto);
                        }
                    
                    String sql="update prestazione_cliente set nome='"+servizio+"',cliente='"+val1+"',costo='"+prezzo+"',reso='"+resto+"',acconto='"+var_anticipo+"',totale='"+ptot+"' where cliente='"+val1+"' and nome='"+servizio+"'";
                    pst=conn.prepareStatement(sql);
                   pst.execute();
                           
                     //tb1.removeColumn(tb1.getColumnModel().getColumn(1));
                    //tb1.removeColumn(tb1.getColumnModel().getColumn(5));
                    
                    txt_tot.setText(decimalFormat.format(sum));
                    txt_ant.setText(decimalFormat.format(anti));
                    resto=ttot-anti;
                    txt_resto.setText(decimalFormat.format(resto));
                    txt_tt.setText(decimalFormat.format(ttot));
                                                    //tb1.removeColumn(tb1.getColumnModel().getColumn(5));


                    
                    JOptionPane.showMessageDialog(null,"Servizio modificato correttamente per l'azienda "+val1 );
                   Update_table(); 
                    txt_costo.setText("");
                    txt_servizio.setText("");
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

            String cliente = combo_cliente.getSelectedItem().toString();
            if(cliente.isEmpty()){JOptionPane.showMessageDialog(null, "Nessuna Azienda/Servizio selezionato");}
            else{

                String servizio = txt_servizio.getText();
                int x = JOptionPane.showConfirmDialog(null,"Sei sicuro di voler rimuovere il seguente servizio?","Elimina Servizio",JOptionPane.YES_NO_OPTION);
                if(x==0){
                    String sql = "delete from prestazione_cliente where nome='"+servizio+"' and cliente='"+cliente+"'";

                    psti=coni.prepareStatement(sql);
                    psti.execute();
                    Update_table();
                    
                    JOptionPane.showMessageDialog(null,"Servizio eliminato correttamente" );

                    txt_costo.setText("");
                    txt_servizio.setText("");
                    txt_anticipo.setText("");

                }}}
                catch(SQLException | HeadlessException e)
                {
                    JOptionPane.showMessageDialog(null,"Errore eliminazione Servizio " );
                }
    }//GEN-LAST:event_bt_elim1ActionPerformed

    private void txt_anticipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_anticipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_anticipoActionPerformed

    private void combo_clientePopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_combo_clientePopupMenuWillBecomeVisible
        // TODO add your handling code here:
       txt_servizio.setText("");
       txt_costo.setText("");
       txt_anticipo.setText("");
       try {
        String sql = "SELECT nome,cognome FROM  pazienti ORDER BY cognome ASC";
        psts = conne.prepareStatement(sql);
        rss = psts.executeQuery();
     
        while(rss.next())

{ 
    String nome = rss.getString("nome");
    String cognome = rss.getString("cognome");
    String nominativo = nome.toUpperCase()+" "+cognome.toUpperCase();
    combo_cliente.addItem(nominativo);

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
               Logger.getLogger(Clients.class.getName()).log(Level.SEVERE, null, ex);
           }

       }  
    }//GEN-LAST:event_combo_clientePopupMenuWillBecomeVisible
    
    private void combo_clientePopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_combo_clientePopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        try{
            String cliente = combo_cliente.getSelectedItem().toString();
             System.out.println("recupero cliente: "+cliente);
           String sql="select * from prestazione_cliente where cliente = ? ";
            pst=conn.prepareStatement(sql);
           
            pst.setString(1,cliente);
            rs=pst.executeQuery();
           
            tb1.setModel(DbUtils.resultSetToTableModel(rs));
            tb1.removeColumn(tb1.getColumnModel().getColumn(1));
            DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
            Double res=0.0;
            
            Double acc=0.0;
           
            Double ttt=0.0;
            for(int i=0;i < tb1.getRowCount();i++){
                acc =  acc + Double.parseDouble(tb1.getValueAt(i, 2).toString());
                ttt=ttt+Double.parseDouble(tb1.getValueAt(i, 4).toString());
                res = ttt - acc;
            }
            
            ric_serv.setText(cliente);
            txt_ant.setText(decimalFormat.format(acc));
            txt_resto.setText(decimalFormat.format(res));
            txt_tot.setText(decimalFormat.format(ttt));
        }
     
        catch(SQLException | NumberFormatException e){
            JOptionPane.showMessageDialog(null, e);
        }
        finally{
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(Clients.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                pst.close();
            } catch (SQLException ex) {
                Logger.getLogger(Clients.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }//GEN-LAST:event_combo_clientePopupMenuWillBecomeInvisible

    private void txt_costoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_costoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_costoActionPerformed

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
    private javax.swing.JLabel app;
    private javax.swing.JButton bnt_agg_sek;
    private javax.swing.JButton bt_elim1;
    private javax.swing.JButton btn8;
    private javax.swing.JComboBox<String> combo_cliente;
    private javax.swing.JComboBox combo_ser_sek;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField ric_serv;
    private javax.swing.JTable tb1;
    private javax.swing.JLabel txt_ant;
    private javax.swing.JTextField txt_anticipo;
    private javax.swing.JTextField txt_costo;
    private javax.swing.JLabel txt_resto;
    private javax.swing.JLabel txt_servizio;
    private javax.swing.JLabel txt_tot;
    private javax.swing.JLabel txt_tt;
    // End of variables declaration//GEN-END:variables
}
