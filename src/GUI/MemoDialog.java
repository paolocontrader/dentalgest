package GUI;

import DentalGest.ClientiListApp;
import static GUI.DateManager.calMonth;
import static GUI.DateManager.calYear;
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
import java.awt.Dimension;
import java.awt.FlowLayout;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
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
import java.util.ArrayList;
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
	private JButton btnEdit;
	private JButton btnDelete;
	private AddDialog dlgAdd;
	private JTextPane tpDayRows[];
	private JLabel_1 [] label;
	private int index;
	static int startPoint;
	static int length;
	static int colorSelect;
	
	String fileName = "/dentalgest/TodoData/" + CalendarGUI.calYear + ((CalendarGUI.calMonth + 1) < 10 ? "0" : "")
			+ (CalendarGUI.calMonth + 1) + (CalendarGUI.calDayOfMon < 10 ? "0" : "") + CalendarGUI.calDayOfMon
			+ ".dat";
	private static JPanel pn;
	

	/**
	 * Create the dialog.
	 */
	public MemoDialog(JFrame parent) {
		super(parent, true);
		startPoint = 1;
		colorSelect = 0;
		setBounds(0, 1, 600, 540);
		getContentPane().setLayout(new BorderLayout());
		pnDayView.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(pnDayView, BorderLayout.CENTER);
		setTitle(CalendarGUI.calDayOfMon +" - " +CalendarGUI.MONTH_NAME[CalendarGUI.calMonth ]);
		pnDayView.setLayout(new GridLayout(0, 1, 0, 0));
		{
			spLeft = new JScrollPane(pn);
			spLeft.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			
			{
				pn = new JPanel();
				spLeft.setViewportView(pn);
				pn.setLayout(new FormLayout(new ColumnSpec[] {
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
						FormFactory.DEFAULT_COLSPEC,},
					new RowSpec[] {
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						}
                                ));
				for( int i = 1 ; i < 11 ; i++ ){ // naming first cell 00:00 ~ 24:00
					// we can painting time table per hour
					JLabel newlbl = new JLabel("0"+(i-1)+":00");
					pn.add(newlbl,"2, " + (i*2));
				}
				
				for(int i = 11 ; i < 26 ; i++){
					
					JLabel newlbl = new JLabel((i-1)+":00");
					pn.add(newlbl,"2, " + (i*2));
				}
				pnDayView.add(spLeft);
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
						btnAdd = new JButton("Nuovo");
						btnAdd.addActionListener(this);
						pnButtons.add(btnAdd);
					}
//					{
//						btnEdit = new JButton("Modifica");
//						btnEdit.addActionListener(this);
//						pnButtons.add(btnEdit);
//					}
					{
						btnDelete = new JButton("Elimina");
						btnDelete.addActionListener(this);
						pnButtons.add(btnDelete);
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
						gbl_panel.columnWidths = new int[] { 106, 106, 106, 106 };
						gbl_panel.rowHeights = new int[] { 15, 0 };
						gbl_panel.columnWeights = new double[] { 1.0, 1.0,1.0,1.0, Double.MIN_VALUE };
						gbl_panel.rowWeights = new double[] { 0.0,0.0,0.0, Double.MIN_VALUE };
						panel.setLayout(gbl_panel);
						{
							JLabel lblToDo = new JLabel("Ora");
							GridBagConstraints gbc_lblToDo = new GridBagConstraints();
							gbc_lblToDo.fill = GridBagConstraints.CENTER;
							gbc_lblToDo.insets = new Insets(0, 0, 5, 5);
							gbc_lblToDo.gridx = 0;
							gbc_lblToDo.gridy = 0;
							panel.add(lblToDo, gbc_lblToDo);
						}
						{
							JLabel lblTime = new JLabel("Prestazione");
							GridBagConstraints gbc_lblTime = new GridBagConstraints();
							gbc_lblTime.fill = GridBagConstraints.CENTER;
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
                                                
                                                {
							JLabel lblOper = new JLabel("Operatore");
							GridBagConstraints gbc_lblOper = new GridBagConstraints();
							gbc_lblOper.fill = GridBagConstraints.CENTER;
                                                        gbc_lblOper.insets = new Insets(0, 0, 0, 0);
                                                        gbc_lblOper.gridx = 3;
							gbc_lblOper.gridy = 0;
							panel.add(lblOper, gbc_lblOper);
						}
					}

					{

						listModel = new DefaultListModel<ToDo>();
                                                
						readTodo();
						list = new JList<ToDo>(listModel);
                                                list.setBorder(BorderFactory.createLineBorder(Color.black));
                                                list.setPreferredSize( new Dimension(100,25));
                                                pnEvents.setBorder(BorderFactory.createLineBorder(Color.black));
						pnEvents.add(list,BorderLayout.CENTER);
					}
				}
			}
		}
	}// end constructor

	/**
	 * find number of days to do on the selected day
	 * @return number of to do list 
	 */
	public int todoNum() {
		int numOfTodo = 0;

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
		label= new JLabel_1[todoNum()];
		pn.updateUI();
		try {
			File f = new File(fileName);
			
			if (f.exists()) {
				ObjectInputStream is = new ObjectInputStream(new FileInputStream(fileName));
				LinkedList<ToDo> td = (LinkedList<ToDo>) is.readObject();
				listModel.clear();
				
				
				for (int i = 0; i < td.size(); i++) {
                                        
                                        String to_do = td.get(i).getClient();
					
					fromHour = td.get(i).getFromHour();
					fromMinute = td.get(i).getFromMinute();
					toHour = td.get(i).getToHour();
					toMinute = td.get(i).getToMinute();
                                        String cliente = td.get(i).getTodo();
                                        String operator = td.get(i).getOper();

					listModel.addElement(new ToDo(cliente, fromHour, fromMinute, toHour, toMinute,to_do,operator));

					startPoint = fromHour;
					length = toHour - startPoint-1;
					if(length<1) length++;
					String str = (listModel.getSize()*2+2)+", "+(startPoint*2+2)+", "+ 1 +", "+(length*2+1);
					label[i] = new JLabel_1(fromHour,toHour,cliente,to_do,operator);
//                                        String[] spString = td.toString().split(",");
//                                         str = spString.subString(IndexOf("[")+1);
//                                         for(int h=0;h<td.size();h++){
//                                         
//                                              System.out.println(spString[h]);
//                                         
//                                         }

    

                                        
					pn.add(label[i],str);
				}
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
			}

			else {
				ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fileName));
				os.writeObject(td);
				os.close();
			}

			td.clear();
//			for(int i=0;i<todoNum();i++) {
//				label[i].finalize();
//			}
			//dispose();

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
	static class JLabel_1 extends JLabel 
	{		// JLabel_1 can be painted. so it placed on time table to show what event is planed
		public Color[] userColor = {new Color(232, 186, 171),new Color(238, 218, 149),new Color(183, 194, 126),new Color(208, 224, 235),new Color(223, 208, 235),new Color(249, 216, 172)};
		JLabel_1(int from, int to, String event,String client,String oper){	
			super(event);
			super.setOpaque(true);
			super.setBackground(userColor[colorSelect%6]);	// random color
			super.setName(event);
                        
			colorSelect++;	
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
	
		
		if (e.getSource() == btnAdd) {
			// create and show the dialog
			flag = 0;
                        
			dlgAdd = new AddDialog((MemoDialog)this, flag);
			dlgAdd.setVisible(true);
			readTodo();
			dispose();
			//} else if (e.getSource() == btnEdit) {
//		
//			flag = 1;
//			
//			index = list.getSelectedIndex();
//			if (index == -1) {
//				JOptionPane.showMessageDialog(null, "Please select event", "Not Selected", JOptionPane.ERROR_MESSAGE);
//				setVisible(true);
//			} else {
//				dlgAdd = new AddDialog((MemoDialog)this, flag);
//				dlgAdd.setVisible(true);
//				readTodo();
//				dispose();
//				dispose();
//		
//			}	
		}

		else if (e.getSource() == btnDelete) {
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