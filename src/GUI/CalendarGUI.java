package GUI;

import DentalGest.Db;
import DentalGest.Operatori;
import static com.sun.glass.ui.Cursor.setVisible;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;

import toDo.ToDo;

/**
 * calendar GUI
 */
public class CalendarGUI extends DateManager {

    
	JFrame mainFrame;
	private ImageIcon icon = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon.png")));
	private JPanel pnCalOption;
	private JButton btnToday;
	private JLabel lblToday;
	private JButton btnPreYear;
	private JButton btnPreMonth;
	private JLabel lblCurrentDate;
	private JButton btnNextMonth;
	private JButton btnNextYear;
        private JButton btnScegli;
        public static JComboBox comboOper = null;
	private ListenForCalOpButtons lForCalOpButtons = new ListenForCalOpButtons();
        private ListenForCalOpButtons lForCalScegliButtons = new ListenForCalOpButtons();
	private JPanel pnCal;
	private JButton weekDaysName[];
	private JButton dateButs[][] = new JButton[6][7];
	private JLabel dateLabs[][] = new JLabel[7][6];
        private JLabel operLab = null;
	private listenForDateButs lForDateButs = new listenForDateButs();
	private JLabel Clock;

	final String WEEK_DAY_NAME[] = { "LUN", "MAR", "MER", "GIO", "VEN", "SAB" ,"DOM" };
	final String title = "Dentalgest";
	private JPanel pnTop;
	private JPanel pnBottom;
        Connection conn = null;
        
        
         private static CalendarGUI obj=null;
    
    public static  CalendarGUI getObj(){
        if(obj==null){
            obj=new CalendarGUI();
        }return obj;
    } 
        
	public CalendarGUI() {
            conn = Db.db();
		initialize();
                
                
	}

	/**
	 * initialize calendar GUI
	 */
	private void initialize() {
             
		mainFrame = new JFrame(title);
		mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		mainFrame.setSize(850, 560);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setIconImage(icon.getImage());

		try {
			// select Look and Feel
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
                 
		pnCalOption = new JPanel();
		pnCalOption.setLayout(new GridLayout(0, 1, 0, 0));

		pnTop = new JPanel();
		pnCalOption.add(pnTop);
		GridBagLayout gbl_pnTop = new GridBagLayout();
		gbl_pnTop.columnWidths = new int[] { 31, 102, 570, 67, 0 };
		gbl_pnTop.rowHeights = new int[] { 29, 0 };
		gbl_pnTop.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0 };
		gbl_pnTop.rowWeights = new double[] { 0.0 };
		pnTop.setLayout(gbl_pnTop);
		btnToday = new JButton("Oggi");
		GridBagConstraints gbc_btnToday = new GridBagConstraints();
		gbc_btnToday.fill = GridBagConstraints.BOTH;
		gbc_btnToday.insets = new Insets(0, 0, 0, 5);
		gbc_btnToday.gridx = 1;
		gbc_btnToday.gridy = 0;
		//pnTop.add(btnToday, gbc_btnToday);
		btnToday.addActionListener(lForCalOpButtons);
		lblToday = new JLabel((today.get(Calendar.DAY_OF_MONTH)) +"/"+  (today.get(Calendar.MONTH) +1) + "/" + 
				+ today.get(Calendar.YEAR));
		GridBagConstraints gbc_lblToday = new GridBagConstraints();
		gbc_lblToday.fill = GridBagConstraints.VERTICAL;
		gbc_lblToday.insets = new Insets(0, 0, 0, 5);
		gbc_lblToday.gridx = 2;
		gbc_lblToday.gridy = 0;
		pnTop.add(lblToday, gbc_lblToday);
		Clock = new JLabel("", SwingConstants.RIGHT);
		GridBagConstraints gbc_Clock = new GridBagConstraints();
		gbc_Clock.anchor = GridBagConstraints.EAST;
		gbc_Clock.gridx = 3;
		gbc_Clock.gridy = 0;
		pnTop.add(Clock, gbc_Clock);
		Clock.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                                
                {  
                    comboOper = new JComboBox();
        String sql="select * from operatori ORDER BY nome ASC "; 
        PreparedStatement psPrest = null;
       
        try {
            psPrest=conn.prepareStatement(sql);
            ResultSet rsPrest=psPrest.executeQuery();
            while(rsPrest.next()){
            comboOper.addItem(rsPrest.getString("nome"));
            
            
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
                        
                        comboOper.setLayout(new BorderLayout());
			GridBagConstraints gbc_txtOper = new GridBagConstraints();
			gbc_txtOper.fill = GridBagConstraints.BOTH;
			gbc_txtOper.insets = new Insets(0, 0, 5, 5);
			gbc_txtOper.gridx = 1;
			gbc_txtOper.gridy = 2;
                         
			pnTop.add(comboOper, gbc_txtOper);
			comboOper.setSize(120, 50);
                }
                {
                 btnScegli = new JButton("Carica");
		GridBagConstraints gbc_btnScegli = new GridBagConstraints();
		gbc_btnScegli.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnScegli.insets = new Insets(0, 0, 0, 5);
		gbc_btnScegli.gridx = 3;
		gbc_btnScegli.gridy = 2;
		pnTop.add(btnScegli, gbc_btnScegli);
                btnScegli.setSize(60, 40);
		btnScegli.addActionListener(lForCalScegliButtons);
                       
        }               
                     
                
		pnBottom = new JPanel();
		pnCalOption.add(pnBottom);
		GridBagLayout gbl_pnBottom = new GridBagLayout();
		gbl_pnBottom.columnWidths = new int[] { 31, 75, 75, 446, 75, 76, 0 };
		gbl_pnBottom.rowHeights = new int[] { 32, 0 };
		gbl_pnBottom.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
		gbl_pnBottom.rowWeights = new double[] { 0.0 };
		pnBottom.setLayout(gbl_pnBottom);
		btnPreYear = new JButton("<<");
		GridBagConstraints gbc_btnPreYear = new GridBagConstraints();
		gbc_btnPreYear.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnPreYear.insets = new Insets(0, 0, 0, 5);
		gbc_btnPreYear.gridx = 1;
		gbc_btnPreYear.gridy = 0;
		pnBottom.add(btnPreYear, gbc_btnPreYear);
		btnPreYear.addActionListener(lForCalOpButtons);
		btnPreMonth = new JButton("<");
		GridBagConstraints gbc_btnPreMonth = new GridBagConstraints();
		gbc_btnPreMonth.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnPreMonth.insets = new Insets(0, 0, 0, 5);
		gbc_btnPreMonth.gridx = 2;
		gbc_btnPreMonth.gridy = 0;
		pnBottom.add(btnPreMonth, gbc_btnPreMonth);
		btnPreMonth.addActionListener(lForCalOpButtons);
		lblCurrentDate = new JLabel(
				"<html><table width=100><tr><th><font size=4>" + ((calMonth + 1) < 10 ? "&nbsp;" : "") + (calMonth + 1)
						+ " / " + calYear + "</th></tr></table></html>");
		GridBagConstraints gbc_lblCurrentDate = new GridBagConstraints();
		gbc_lblCurrentDate.fill = GridBagConstraints.VERTICAL;
		gbc_lblCurrentDate.insets = new Insets(0, 0, 0, 5);
		gbc_lblCurrentDate.gridx = 3;
		gbc_lblCurrentDate.gridy = 0;
		pnBottom.add(lblCurrentDate, gbc_lblCurrentDate);
		btnNextMonth = new JButton(">");
		GridBagConstraints gbc_btnNextMonth = new GridBagConstraints();
		gbc_btnNextMonth.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNextMonth.insets = new Insets(0, 0, 0, 5);
		gbc_btnNextMonth.gridx = 4;
		gbc_btnNextMonth.gridy = 0;
		pnBottom.add(btnNextMonth, gbc_btnNextMonth);
		btnNextMonth.addActionListener(lForCalOpButtons);
		btnNextYear = new JButton(">>");
		GridBagConstraints gbc_btnNextYear = new GridBagConstraints();
		gbc_btnNextYear.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNextYear.gridx = 5;
		gbc_btnNextYear.gridy = 0;
		pnBottom.add(btnNextYear, gbc_btnNextYear);
		btnNextYear.addActionListener(lForCalOpButtons);

		pnCal = new JPanel();
		weekDaysName = new JButton[7];
		for (int i = 0; i < COLUMN; i++) {
			weekDaysName[i] = new JButton(WEEK_DAY_NAME[i]);
			weekDaysName[i].setBorderPainted(true);
			weekDaysName[i].setContentAreaFilled(true);
			weekDaysName[i].setEnabled(true);
			weekDaysName[i].setForeground(Color.WHITE);
			if (i == 6)
				weekDaysName[i].setBackground(new Color(232, 186, 171));
			else if (i == 5)
				weekDaysName[i].setBackground(new Color(167, 200, 229));
			else
				weekDaysName[i].setBackground(new Color(206, 199, 194));
			weekDaysName[i].setOpaque(true);
			weekDaysName[i].setFocusPainted(false);
			pnCal.add(weekDaysName[i]);
		}

		for (int i = 0; i < ROW; i++) {
			for (int j = 0; j < COLUMN; j++) {
				dateButs[i][j] = new JButton();
				dateButs[i][j].setBorderPainted(true);
				dateButs[i][j].setContentAreaFilled(false);
				dateButs[i][j].setBackground(Color.WHITE);
				dateButs[i][j].setOpaque(false);
				dateButs[i][j].addActionListener(lForDateButs);
				JLabel test = new JLabel("test");

				pnCal.add(dateButs[i][j]);
				//dateButs[i][j].add(test);
			}
		}
		pnCal.setLayout(new GridLayout(0, 7, 2, 2));
		pnCal.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
		showCal(comboOper.getSelectedItem().toString());

		JPanel pnCalender = new JPanel();
		Dimension calOpPanelSize = pnCalOption.getPreferredSize();
		calOpPanelSize.height = 90;
		pnCalOption.setPreferredSize(calOpPanelSize);
		pnCalender.setLayout(new BorderLayout());
		pnCalender.add(pnCalOption, BorderLayout.NORTH);
		pnCalender.add(pnCal, BorderLayout.CENTER);

		Dimension frameSubPanelWestSize = pnCalender.getPreferredSize();
		frameSubPanelWestSize.width = 410;
		pnCalender.setPreferredSize(frameSubPanelWestSize);

		// Place in frame
		mainFrame.getContentPane().setLayout(new BorderLayout());
		mainFrame.getContentPane().add(pnCalender, BorderLayout.CENTER);

		mainFrame.setVisible(true);

		// focus on current date
//		focusToday();

		// Thread (clock)
		ClockThread ckThread = new ClockThread();
		ckThread.start();
	}

	// focus on current date
	private void focusToday() {
		if (today.get(Calendar.DAY_OF_WEEK) == 0)
			dateButs[today.get(Calendar.WEEK_OF_MONTH) - 2][today.get(Calendar.DAY_OF_WEEK) - 2].requestFocusInWindow();
		else
			dateButs[today.get(Calendar.WEEK_OF_MONTH)-2][today.get(Calendar.DAY_OF_WEEK)-2].requestFocusInWindow();
	}

        private void comboOperPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {                                                       
        // TODO add your handling code here:
        
        String scelta=comboOper.getSelectedItem().toString();
        
         showCal(scelta);  
        
    } 
        
	// show to-do data to calendarGUI
	private void showCal(String txtOper) {
            txtOper  = comboOper.getSelectedItem().toString().replace(".", "");
            
        
                    
             for (int i = 0; i < ROW; i++) {
			for (int j = 0; j < COLUMN; j++) {
				String fontColor = "black";
				if (j == 6)
					fontColor = "red";
				else if (j == 5)
					fontColor = "blue";
                                
                               
				String file = "/dentalgest/TodoData/"+txtOper+"/" + calYear + ((calMonth + 1) < 10 ? "0" : "") + (calMonth + 1)
						+ (calDates[i][j] < 10 ? "0" : "") + calDates[i][j] + ".dat";
				File f = new File(file);

				if (f.exists()) {

					String to_do = new String("");
					String client = new String("");
                                       

					try {
						ObjectInputStream is = new ObjectInputStream(new FileInputStream(file));
						LinkedList<ToDo> td = (LinkedList<ToDo>) is.readObject();
						  
                                                client = td.get(0).getClient();
                                                to_do = td.get(0).getTodo();
                                                
						if (to_do.length() > 100) {
							to_do = to_do.substring(0, 25);
							to_do += "...";
						}
						
						//is.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if (calMonth == today.get(Calendar.MONTH) && calYear == today.get(Calendar.YEAR)
							&& calDates[i][j] == today.get(Calendar.DAY_OF_MONTH)) {
						dateButs[i][j].setText(
								"<html><p font color=green style=\"text-align:right\"> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; "
										+ "&nbsp; &nbsp; &nbsp; &nbsp;<b>" + calDates[i][j] + "</b></p>" 
										+to_do+   "<br></html>");
					} else {
						dateButs[i][j].setText("<html><p font color=" + fontColor
								+ " style=\"text-align:right\"> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; "
								+ "&nbsp; &nbsp; &nbsp; &nbsp;<b>" + calDates[i][j] + "</b></p>" + to_do +   "<br></html>");
					}

				} else {
					dateButs[i][j].setText("<html><p font color=" + fontColor
							+ " style=\"text-align:right\"> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; "
							+ "&nbsp; &nbsp; &nbsp; &nbsp;" + calDates[i][j] + "</p><br><br></html>");
				}
                                  
				dateButs[i][j].removeAll();

				if (calDates[i][j] == 0) {
					dateButs[i][j].setVisible(false);
				} else {
					dateButs[i][j].setVisible(true);

				}
			}
		}
            
	}

        private class ListenForCalScegliButtons implements ActionListener {
		public void actionPerformed(ActionEvent e) {
                showCal(comboOper.getSelectedItem().toString());
                }
        }
        
	private class ListenForCalOpButtons implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnToday) {
				setToday();
				lForDateButs.actionPerformed(e);
				focusToday();
			} else if (e.getSource() == btnPreYear)
				moveMonth(-12);
			else if (e.getSource() == btnPreMonth)
				moveMonth(-1);
			else if (e.getSource() == btnNextMonth)
				moveMonth(1);
			else if (e.getSource() == btnNextYear)
				moveMonth(12);

			lblCurrentDate
					.setText("<html><table width=100><tr><th><font size=4>" + ((calMonth + 1) < 10 ? "&nbsp;" : "")
							+ (calMonth + 1) + " / " + calYear + "</th></tr></table></html>");
			showCal(comboOper.getSelectedItem().toString());
		}
	}

	private class listenForDateButs implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int k = 0, l = 0;
			for (int i = 0; i < ROW; i++) {
				for (int j = 0; j < COLUMN; j++) {
					if (e.getSource() == dateButs[i][j]) {
						k = i;
						l = j;
					}
				}
			}

			if (!(k == 0 && l == 0)) {
				calDayOfMon = calDates[k][l];

				// create and show the dialog
				MemoDialog dlg = new MemoDialog(mainFrame);
				dlg.setVisible(true);
				showCal(comboOper.getSelectedItem().toString());
			}
			cal = new GregorianCalendar(calYear, calMonth, calDayOfMon);

			String dDayString = new String();
			int dDay = ((int) ((cal.getTimeInMillis() - today.getTimeInMillis()) / 1000 / 60 / 60 / 24));
			if (dDay == 0 && (cal.get(Calendar.YEAR) == today.get(Calendar.YEAR))
					&& (cal.get(Calendar.MONTH) == today.get(Calendar.MONTH))
					&& (cal.get(Calendar.DAY_OF_MONTH) == today.get(Calendar.DAY_OF_MONTH)))
				dDayString = "Today";
			else if (dDay >= 0)
				dDayString = "D-" + (dDay + 1);
			else if (dDay < 0)
				dDayString = "D+" + (dDay) * (-1);

		}
	}

	private class ClockThread extends Thread {
		public void run() {
			boolean msgCntFlag = false;
			int num = 0;
			String curStr = new String();
			while (true) {
				try {
					today = Calendar.getInstance();
					String amPm = (today.get(Calendar.AM_PM) == 0 ? "AM" : "PM");
					String hour;
					if (today.get(Calendar.HOUR) == 0)
						hour = "12";
					else if (today.get(Calendar.HOUR) == 12)
						hour = " 0";
					else
						hour = (today.get(Calendar.HOUR) < 10 ? " " : "") + today.get(Calendar.HOUR);
					String min = (today.get(Calendar.MINUTE) < 10 ? "0" : "") + today.get(Calendar.MINUTE);
					String sec = (today.get(Calendar.SECOND) < 10 ? "0" : "") + today.get(Calendar.SECOND);
					Clock.setText( hour + ":" + min + ":" + sec + " "+amPm);

					sleep(1000);

				} catch (InterruptedException e) {
					System.out.println("Thread:Error");
				}
			}
		}
	}
}