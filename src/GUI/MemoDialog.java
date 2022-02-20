package GUI;

import DentalGest.ClientiList;
import DentalGest.ClientiListApp;
import DentalGest.Clients;
import static GUI.DateManager.calMonth;
import static GUI.DateManager.calYear;
import com.itextpdf.text.Element;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import toDo.EmptyToDoException;
import toDo.TimeInputException;
import toDo.ToDo;

import javax.swing.JScrollPane;
import java.awt.GridLayout;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import com.jgoodies.forms.factories.FormFactory;
import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.awt.event.ActionEvent;
import java.io.FileWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;

public class MemoDialog extends JDialog implements ActionListener {

    private final JPanel pnDayView = new JPanel();
    private JPanel panel;
    JList<ToDo> list;
    static public DefaultListModel listModel;
    private JScrollPane spLeft;
    private JScrollPane spRight;
    private JPanel pnRight;
    private JPanel pnButtons;
    private JButton btnAdd;
    private JButton btnAddGuest;
    private JButton btnPrint;
    private JButton btnDelete;
    private AddDialog dlgAdd;
      private AddDialogNoAnagr dlgAddNoAnagr;
    private JTextPane tpDayRows[];
    private JLabel_1[] label;
    private int index;
    static int startPoint;
    static int length;
    static int colorSelect;
    LinkedList<ToDo> td = null;
    
    String fileName = null;
    private static JPanel pn;

    /**
     * Create the dialog.
     */
    public MemoDialog(JFrame parent) {
        super(parent, true);
        startPoint = 1;
        colorSelect = 0;
        setBounds(0, 1, 1000, 1000);
        getContentPane().setLayout(new BorderLayout());
        pnDayView.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(pnDayView, BorderLayout.CENTER);
        setTitle(CalendarGUI.calDayOfMon + " - " + CalendarGUI.MONTH_NAME[CalendarGUI.calMonth] +" - "+CalendarGUI.comboOper.getSelectedItem().toString());
        pnDayView.setLayout(new GridLayout(0, 1, 0, 0));
        {
            spLeft = new JScrollPane(pn);
            spLeft.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

            {
                pn = new JPanel();
                spLeft.setViewportView(pn);
                pn.setLayout(new FormLayout(new ColumnSpec[]{
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC},
                        new RowSpec[]{
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.RELATED_GAP_ROWSPEC,}
                ));
                for (int i = 9; i < 11; i++) { // naming first cell 08:00 ~ 22:00
                    // we can painting time table per hour
                    JLabel newlbl = new JLabel("0" + (i - 1) + ":00");
                    pn.add(newlbl, "2, " + (i * 2));
                    newlbl.setFont(new Font("TimesRoman", Font.PLAIN, 16));
                }

                for (int i = 11; i < 24; i++) {

                    JLabel newlbl = new JLabel((i - 1) + ":00");
                    pn.add(newlbl, "2, " + (i * 2));
                    newlbl.setFont(new Font("TimesRoman", Font.PLAIN, 16));
                }
                //pnDayView.add(spLeft);
            }

            {
                pnRight = new JPanel();

                pnRight.setBounds(0, 0, 0, 0);
                pnDayView.add(pnRight);

                pnRight.setLayout(new BorderLayout(0, 0));
                {
                    pnButtons = new JPanel();
                    pnRight.add(pnButtons, BorderLayout.NORTH);
                    pnButtons.setLayout(new GridLayout(0, 3, 0, 0));
                     {
                        btnAddGuest = new JButton("Ospite");
                        btnAddGuest.addActionListener(this);
                        pnButtons.add(btnAddGuest);
                    }
                    {
                        btnAdd = new JButton("Nuovo");
                        btnAdd.addActionListener(this);
                        pnButtons.add(btnAdd);
                    }

                    {
                        btnDelete = new JButton("Elimina");
                        btnDelete.addActionListener(this);
                        pnButtons.add(btnDelete);
                    }

                    {
                        btnPrint = new JButton("Stampa");
                        btnPrint.addActionListener(this);
                        pnButtons.add(btnPrint);
                    }
                }
                {
                    JPanel pnEvents = new JPanel();
                    pnRight.add(pnEvents, BorderLayout.CENTER);
                    pnEvents.setLayout(new BorderLayout(0, 0));
                    {
                        panel = new JPanel();
                        panel.setBorder(BorderFactory.createLineBorder(Color.black));
                        pnEvents.add(panel, BorderLayout.NORTH);
                        GridBagLayout gbl_panel = new GridBagLayout();
                        gbl_panel.columnWidths = new int[]{20, 20, 20, 20};
                        gbl_panel.rowHeights = new int[]{15, 0};
                        gbl_panel.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
                        gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
                        panel.setLayout(gbl_panel);
                        {
                            JLabel lblToDo = new JLabel("Ora");
                            GridBagConstraints gbc_lblToDo = new GridBagConstraints();
                            gbc_lblToDo.fill = GridBagConstraints.CENTER;
                            gbc_lblToDo.insets = new Insets(0, 0, 0, 0);
                            gbc_lblToDo.gridx = 0;
                            gbc_lblToDo.gridy = 0;
                            panel.add(lblToDo, gbc_lblToDo);
                        }
                        {
                            JLabel lblTime = new JLabel("Prestazione");
                            GridBagConstraints gbc_lblTime = new GridBagConstraints();
                            gbc_lblTime.fill = GridBagConstraints.WEST;
                            gbc_lblTime.insets = new Insets(0, 0, 0, 0);
                            gbc_lblTime.gridx = 2;
                            gbc_lblTime.gridy = 0;
                            panel.add(lblTime, gbc_lblTime);
                        }

                        {
                            JLabel lblclient = new JLabel("Paziente");
                            GridBagConstraints gbc_lblclient = new GridBagConstraints();
                            gbc_lblclient.fill = GridBagConstraints.CENTER;
                            gbc_lblclient.insets = new Insets(0, 0, 0, 0);
                            gbc_lblclient.gridx = 1;
                            gbc_lblclient.gridy = 0;
                            panel.add(lblclient, gbc_lblclient);
                        }

//                        {
//                            JLabel lblOper = new JLabel("Operatore");
//                            GridBagConstraints gbc_lblOper = new GridBagConstraints();
//                            gbc_lblOper.fill = GridBagConstraints.CENTER;
//                            gbc_lblOper.insets = new Insets(0, 0, 0, 0);
//                            gbc_lblOper.gridx = 3;
//                            gbc_lblOper.gridy = 0;
//                            panel.add(lblOper, gbc_lblOper);
//                        }
                    }

                    {

                        listModel = new DefaultListModel<ToDo>();

                        readTodo();
                        list = new JList<ToDo>(listModel);
                        list.setFont(new Font("TimesRoman", Font.PLAIN, 14));
                        list.setBorder(BorderFactory.createLineBorder(Color.black));
                        list.setPreferredSize(new Dimension(1000, 800));
                        pnEvents.setBorder(BorderFactory.createLineBorder(Color.black));
                        pnEvents.add(list, BorderLayout.WEST);
                    }
                }
            }
        }
    }// end constructor

    /**
     * find number of days to do on the selected day
     *
     * @return number of to do list
     */
    public int todoNum() {
        String selectOper = CalendarGUI.comboOper.getSelectedItem().toString().replace(".","");
        int numOfTodo = 0;
        fileName = "/dentalgest/TodoData/"+selectOper+"/" + CalendarGUI.calYear + ((CalendarGUI.calMonth + 1) < 10 ? "0" : "")
            + (CalendarGUI.calMonth + 1) + (CalendarGUI.calDayOfMon < 10 ? "0" : "") + CalendarGUI.calDayOfMon
            + ".dat";
        File f = new File(fileName);
        if (f.exists()) {

            try {
                ObjectInputStream is = new ObjectInputStream(new FileInputStream(fileName));
                LinkedList<ToDo> td = (LinkedList<ToDo>) is.readObject();

                is.close();
                numOfTodo = td.size();

            } catch (IOException | ClassNotFoundException e) {
                // TODO Auto-generated catch block

            }
            // TODO Auto-generated catch block

        }
        return numOfTodo;

    }

    public void readTodo() {
        int fromHour;
        int fromMinute;
        int toHour;
        int toMinute;
        label = new JLabel_1[todoNum()];
        String selectOper = CalendarGUI.comboOper.getSelectedItem().toString().replace(".", "");
       
        fileName =  "/dentalgest/TodoData/"+selectOper+"/" + CalendarGUI.calYear + ((CalendarGUI.calMonth + 1) < 10 ? "0" : "")
            + (CalendarGUI.calMonth + 1) + (CalendarGUI.calDayOfMon < 10 ? "0" : "") + CalendarGUI.calDayOfMon
            + ".dat";
         pn.updateUI();
        try {
            File f = new File(fileName);

            if (f.exists()) {
                ObjectInputStream is = new ObjectInputStream(new FileInputStream(fileName));
                td = (LinkedList<ToDo>) is.readObject();
                listModel.clear();

                String[] spString = null;
                for (int i = 0; i < td.size(); i++) {

                    String to_do = td.get(i).getClient();

                    fromHour = td.get(i).getFromHour();
                    fromMinute = td.get(i).getFromMinute();
                    toHour = td.get(i).getToHour();
                    toMinute = td.get(i).getToMinute();
                    String cliente = td.get(i).getTodo();
                    String operator = td.get(i).getOper();

                    listModel.addElement(new ToDo(cliente, fromHour, fromMinute, toHour, toMinute, to_do, operator));

                    startPoint = fromHour;
                    length = toHour - startPoint - 1;
                    if (length < 1) {
                        length++;
                    }
                    String str = (listModel.getSize() * 2 + 2) + ", " + (startPoint * 2 + 2) + ", " + 1 + ", " + (length * 2 + 2);
                    
                    label[i] = new JLabel_1(fromHour, toHour, cliente, to_do,operator);
                    label[i].setFont(new Font("TimesRoman", Font.PLAIN, 16));
//                                       spString = listModel.toString().split(",");

                    pn.add(label[i], str);
                    
                    label[i].setFont(new Font("TimesRoman", Font.PLAIN, 16));
                }
//                                 for(int h=0;h<td.size();h++){
//                                                    System.out.print(spString[h]);
//                                        
//                                               }
                is.close();
            }
        } catch (EOFException e1) {

        } catch (IOException e2) {
            e2.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (EmptyToDoException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (TimeInputException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void deleteData() {

        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream(fileName));
            LinkedList<ToDo> td = (LinkedList<ToDo>) is.readObject();
            index = list.getSelectedIndex();
            td.remove(index);
            is.close();

            if (td.size() == 0) {
                File file = new File(fileName);
                listModel.clear();
                file.delete();
            } else {
                ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fileName));
                os.writeObject(td);
                os.close();
            }

            td.clear();
//			for(int i=0;i<todoNum();i++) {
//				label[i].finalize();
//			}
//			dispose();

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    //create colored label
    static class JLabel_1 extends JLabel {		// JLabel_1 can be painted. so it placed on time table to show what event is planed

        public Color[] userColor = {new Color(255, 240, 97), new Color(247, 159, 72), new Color(249, 100, 100), new Color(183, 249, 241), new Color(141, 249, 138), new Color(244, 103, 244), new Color(244, 203, 149), new Color(207, 187, 255)};

        JLabel_1(int from, int to, String event, String client, String oper) {
            super(event);
            super.setOpaque(true);
            setBackground(userColor[colorSelect]);
            super.setName(event);

            if (oper.equals("Dott. Famiglietti")) {

                colorSelect = 1;
                setBackground(userColor[colorSelect]);
            } else if (oper.equals("Dott. Pagliarulo")) {
                colorSelect = 2;
                setBackground(userColor[colorSelect]);
            } else if (oper.equals("Dott. Damiano")) {

                colorSelect = 3;
                setBackground(userColor[colorSelect]);
            } else if (oper.equals("Dott. Cerella")) {
                colorSelect = 4;
                setBackground(userColor[colorSelect]);
            } else if (oper.equals("Dott. Ciampaglia")) {

                colorSelect = 5;
                setBackground(userColor[colorSelect]);
            } else if (oper.equals("Dott.ssa Calabrese")) {
                colorSelect = 6;
                setBackground(userColor[colorSelect]);
            } else if (oper.equals("Dott. Costigliola")) {

                colorSelect = 7;
                setBackground(userColor[colorSelect]);
            } else {
                colorSelect = 0;
                setBackground(userColor[colorSelect]);
            }
            System.out.println("OPERATORE COLORE: " + oper + " colore: " + colorSelect);

        }

        protected void finalize() {
            try {
                super.finalize();
            } catch (Throwable e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
        int flag;

         if (e.getSource() == btnAddGuest) {
            // create and show the dialog
            flag = 0;

            dlgAddNoAnagr = new AddDialogNoAnagr((MemoDialog) this, flag);
            dlgAddNoAnagr.setVisible(true);
            readTodo();
            dispose();
        } else
        if (e.getSource() == btnAdd) {
            // create and show the dialog
            flag = 0;

            dlgAdd = new AddDialog((MemoDialog) this, flag);
            dlgAdd.setVisible(true);
            readTodo();
            dispose();
        } else if (e.getSource() == btnPrint) {
            //		String[] spString = listModel.toString().split(",");
//			for(int h=0;h<td.size();h++){
//                                                    System.out.print(spString[h]+"\n");

//}
String nomeha = CalendarGUI.calDayOfMon+"-"+(CalendarGUI.calMonth+1)+"-"+CalendarGUI.calYear;
String operato = CalendarGUI.comboOper.getSelectedItem().toString();
            Document d = new Document(PageSize.A4);
            d.setMargins(0,0,0,0);
            File f = new File("/dentalgest/calendario/");
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
            try {
                PdfWriter.getInstance(d, new FileOutputStream("/dentalgest/calendario/calendario-"+nomeha+".pdf"));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(MemoDialog.class.getName()).log(Level.SEVERE, null, ex);
            } catch (DocumentException ex) {
                Logger.getLogger(MemoDialog.class.getName()).log(Level.SEVERE, null, ex);
            }
            d.open();
            com.lowagie.text.Font font = new com.lowagie.text.Font();
            Image image = null;
            try {
                image = Image.getInstance("/dentalgest/header.png");
            } catch (BadElementException ex) {
                Logger.getLogger(MemoDialog.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(MemoDialog.class.getName()).log(Level.SEVERE, null, ex);
            }
            image.scaleToFit(1400, 150);
            image.setBorderColor(new Color(0, 0, 0));
            PdfPCell cell = new PdfPCell();
// d.add(image);
            cell.setColspan(0);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setPadding(0);
            font.setColor(0, 0, 0);
            font.setSize(28);
            int indentation = 0;
            
            try {
                d.add(image);
            } catch (DocumentException ex) {
                Logger.getLogger(MemoDialog.class.getName()).log(Level.SEVERE, null, ex);
            }
            PdfPTable ptableh = new PdfPTable(1);
            
            PdfPCell cell1ha = new PdfPCell(new Paragraph(nomeha + "\n\nOperatore: "+operato));
            cell1ha.setBorderColor(new Color(0, 0, 0));
            cell1ha.setBackgroundColor(new Color(255, 255, 255));
            cell1ha.setHorizontalAlignment(Element.ALIGN_CENTER);
            ptableh.addCell(cell1ha);
            try {
                d.add(ptableh);
            } catch (DocumentException ex) {
                Logger.getLogger(MemoDialog.class.getName()).log(Level.SEVERE, null, ex);
            }
            String nome = null;
            int h =0;
            String text = listModel.toString().replace("[", "").replace("]", "");
            String[] spString = text.split(",");
           
            for (h = 0; h < td.size(); h++) {
              
                PdfPTable ptable = new PdfPTable(1);
              
                    Paragraph paragr = new Paragraph(spString[h]);
                    paragr.setAlignment(Element.ALIGN_LEFT);
                PdfPCell cell1a = new PdfPCell(paragr);
                font.setSize(9);
                cell1a.setBorderColor(new Color(255, 255, 255));
                cell1a.setBorder(0);
                 cell1a.setHorizontalAlignment(Element.ALIGN_LEFT);
                ptable.addCell(cell1a);
             
                try {
                    d.add(ptable);
                } catch (DocumentException ex) {
                    Logger.getLogger(MemoDialog.class.getName()).log(Level.SEVERE, null, ex);
                }
              //  Paragraph n = new Paragraph("\n");
            }
            Image image1 = null;
            try {
                image1 = Image.getInstance("/dentalgest/footer.png");
            } catch (BadElementException ex) {
                Logger.getLogger(MemoDialog.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(MemoDialog.class.getName()).log(Level.SEVERE, null, ex);
            }
            image1.scaleToFit(720, 55);
//          d.add(table1);
            image1.setAbsolutePosition(15, 10);
            image1.setAlignment(Image.ALIGN_CENTER);
            try {
                d.add(image1);
            } catch (DocumentException ex) {
                Logger.getLogger(MemoDialog.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                d.add(image1);
            } catch (DocumentException ex) {
                Logger.getLogger(MemoDialog.class.getName()).log(Level.SEVERE, null, ex);
            }
            d.close();
//d.add(n);
            JOptionPane.showMessageDialog(null, "Calendario del "+nomeha+" creato correttamente");
//Process exec = Runtime.getRuntime().exec("cmd.exe /C /dentalgest/utility/open.bat");
            File file = new File("/dentalgest/calendario/calendario-"+nomeha+".pdf");
            if (file.toString().endsWith(".pdf"))
    try {
                Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + file);
            } catch (IOException ex) {
                Logger.getLogger(MemoDialog.class.getName()).log(Level.SEVERE, null, ex);
            } else {
                Desktop desktop = Desktop.getDesktop();
                try {
                    desktop.open(file);
                } catch (IOException ex) {
                    Logger.getLogger(MemoDialog.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
// File myFile = new File("/dentalgest/reports/saldo-"+scelta+"_"+adesso+".pdf");
// Desktop.getDesktop().open(myFile);

        } else if (e.getSource() == btnDelete) {
            index = list.getSelectedIndex();
            if (index == -1) {
                JOptionPane.showMessageDialog(null, "Selezionare l'appuntamento", "Seleziona appuntamento", JOptionPane.ERROR_MESSAGE);
                setVisible(true);
            } else {
                int returnValue = JOptionPane.showConfirmDialog(null, "Sei sicuro di voler cancellare il seguente appuntamento?",
                        "Elimina appuntamento", JOptionPane.YES_NO_OPTION);
                if (returnValue == JOptionPane.YES_OPTION) {
                    deleteData();
                    setVisible(true);
                    readTodo();
                    dispose();

                }
            }
        }

    }

    public int getIndex() {
        return index;
    }

}
