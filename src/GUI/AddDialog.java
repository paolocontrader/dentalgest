package GUI;

import DentalGest.ClientiListApp;
import DentalGest.ClientiListCem;
import GUI.CalendarGUI;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import toDo.EmptyToDoException;
import toDo.TimeInputException;
import toDo.ToDo;

import java.awt.event.*;
import java.io.*;
import java.util.*;

public class AddDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtEventName;
        public JTextField txtCliente;
        public JComboBox txtOper;
	private JSpinner spFrom;
	private JSpinner spTo;
	private JTextField txtFrom;
	private JTextField txtTo;
	private String fileName = "/dentalgest/TodoData/" + CalendarGUI.calYear + ((CalendarGUI.calMonth + 1) < 10 ? "0" : "")
			+ (CalendarGUI.calMonth + 1) + (CalendarGUI.calDayOfMon < 10 ? "0" : "") + CalendarGUI.calDayOfMon
			+ ".dat";
	private String todo;
        private String client;
	private int fromH;
	private int fromM;
	private int toH;
	private int toM;

	/**
	 * Create the dialog.
	 */
        
        private static AddDialog obj=null;
    
    public static  AddDialog getObj(){
        if(obj==null){
            obj=new AddDialog();
        }return obj;
    } 
        
    public AddDialog(){
        
    }
        
	public AddDialog(MemoDialog parent, int flag) {
		setBounds(100, 100, 361, 250);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(1, 1, 1, 1));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		setTitle(CalendarGUI.calDayOfMon + " - " + CalendarGUI.MONTH_NAME[CalendarGUI.calMonth]);
                		gbl_contentPanel.columnWeights = new double[] { 1.0, 2.0 };
		gbl_contentPanel.rowWeights = new double[] { 1.0, 1.0, 1.0 ,1.0,1.0};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblEvent = new JLabel("Prestazione");
			GridBagConstraints gbc_lblEvent = new GridBagConstraints();
			gbc_lblEvent.fill = GridBagConstraints.VERTICAL;
			gbc_lblEvent.insets = new Insets(0, 0, 5, 5);
			gbc_lblEvent.gridx = 0;
			gbc_lblEvent.gridy = 1;
                        contentPanel.add(lblEvent, gbc_lblEvent);
                        
			
		}
		{
			txtEventName = new JTextField();
                        
			if (flag == 1) {
				try {
					File f = new File(fileName);
					if (f.exists()) {
						ObjectInputStream is = new ObjectInputStream(new FileInputStream(fileName));
						LinkedList<ToDo> tmp = (LinkedList<ToDo>) is.readObject();
						is.close();
                                                client = tmp.get(parent.getIndex()).getClient();
						todo = tmp.get(parent.getIndex()).getTodo();
						fromH = tmp.get(parent.getIndex()).getFromHour();
						fromM = tmp.get(parent.getIndex()).getFromMinute();
						toH = tmp.get(parent.getIndex()).getToHour();
						toM = tmp.get(parent.getIndex()).getToMinute();
						if(fromH>12) fromH-=12;
						else fromH+=12;
						if(toH>12) toH-=12;
						else toH+=12;
						tmp.clear();
                                                  txtCliente.setText(client);
						txtEventName.setText(todo);
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} 
			GridBagConstraints gbc_txtEventName = new GridBagConstraints();
			gbc_txtEventName.fill = GridBagConstraints.BOTH;
			gbc_txtEventName.insets = new Insets(0, 0, 5, 5);
			gbc_txtEventName.gridx = 1;
			gbc_txtEventName.gridy = 1;
			contentPanel.add(txtEventName, gbc_txtEventName);
			txtEventName.setColumns(10);

		}
                {
                        JLabel lblEventN = new JLabel("Paziente");
                        JButton cliebtn = new JButton("Seleziona");
                        cliebtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
                                                
                                               
                                               ClientiListApp.getObj().setFocusableWindowState(true);
						ClientiListApp.getObj().setVisible(true);
                                                ClientiListApp.getObj().setAlwaysOnTop(true);
                                               
					}
				});
			GridBagConstraints gbc_lblEventN = new GridBagConstraints();
			gbc_lblEventN.fill = GridBagConstraints.VERTICAL;
			gbc_lblEventN.insets = new Insets(0, 0, 5, 5);
			gbc_lblEventN.gridx = 0;
			gbc_lblEventN.gridy = 0;
                        GridBagConstraints gbc_lblEventB = new GridBagConstraints();
			gbc_lblEventB.fill = GridBagConstraints.VERTICAL;
			gbc_lblEventB.insets = new Insets(0, 0, 5, 5);
			gbc_lblEventB.gridx = 1;
			gbc_lblEventB.gridy = 0;
                        contentPanel.add(lblEventN, gbc_lblEventN);
                        contentPanel.add(cliebtn, gbc_lblEventB);
                        
                }
                
                {
                        txtCliente = new JTextField();
                        txtCliente.setLayout(new BorderLayout());
			GridBagConstraints gbc_txtCliente = new GridBagConstraints();
			gbc_txtCliente.fill = GridBagConstraints.BOTH;
			gbc_txtCliente.insets = new Insets(0, 0, 0, 0);
			gbc_txtCliente.gridx = 1;
			gbc_txtCliente.gridy = 1;
                         txtCliente.setSize(0,0);
                         txtCliente.setBorder(null);
                         txtCliente.setBackground(null);
			contentPanel.add(txtCliente, gbc_txtCliente);
			txtCliente.setColumns(0);
                       
                        
                        
                }
                {
                        JLabel lblOper = new JLabel("Operatore");
                       GridBagConstraints gbc_lblOper = new GridBagConstraints();
			gbc_lblOper.fill = GridBagConstraints.VERTICAL;
			gbc_lblOper.insets = new Insets(0, 0, 5, 5);
			gbc_lblOper.gridx = 0;
			gbc_lblOper.gridy = 2;
                        contentPanel.add(lblOper, gbc_lblOper);
                        
                }
                
                {
                        
                        String[] operStrings = { "","Dott. Famiglietti", "Dott. Donnarumma", "Dott.ssa Calabrese", "Dott. Pagliarulo"};
                       txtOper = new JComboBox(operStrings);
                        txtOper.setLayout(new BorderLayout());
			GridBagConstraints gbc_txtOper = new GridBagConstraints();
			gbc_txtOper.fill = GridBagConstraints.BOTH;
			gbc_txtOper.insets = new Insets(0, 0, 5, 5);
			gbc_txtOper.gridx = 1;
			gbc_txtOper.gridy = 2;
                         
			contentPanel.add(txtOper, gbc_txtOper);
			txtOper.setSize(120, 50);
                       
                        
                        
                }
                
		{
			JLabel lblFrom = new JLabel("Dalle ore: ");
			GridBagConstraints gbc_lblFrom = new GridBagConstraints();
			gbc_lblFrom.fill = GridBagConstraints.VERTICAL;
			gbc_lblFrom.insets = new Insets(0, 0, 5, 5);
			gbc_lblFrom.gridx = 0;
			gbc_lblFrom.gridy = 3;
			contentPanel.add(lblFrom, gbc_lblFrom);
		}
		{
			txtFrom = new JTextField();
			txtFrom.setLayout(new BorderLayout());
			GridBagConstraints gbc_txtFrom = new GridBagConstraints();
			gbc_txtFrom.fill = GridBagConstraints.BOTH;
			gbc_txtFrom.insets = new Insets(0, 0, 0, 0);
			gbc_txtFrom.gridx = 1;
			gbc_txtFrom.gridy = 3;
			contentPanel.add(txtFrom, gbc_txtFrom);
			txtFrom.setColumns(10);
                        txtFrom.setSize(120, 60);

			spFrom = new JSpinner(new SpinnerDateModel());
			JSpinner.DateEditor spinnerEditor = new JSpinner.DateEditor(spFrom, "HH:mm");
			spinnerEditor.getTextField().setHorizontalAlignment(JTextField.CENTER);
			spFrom.setEditor(spinnerEditor);
			spFrom.setValue(new Date(11));

			if (flag == 1) {
				Calendar cal = Calendar.getInstance();
				cal.set(Calendar.HOUR, fromH);
				cal.set(Calendar.MINUTE, fromM);
				Date date = cal.getTime();
				spFrom.setValue(date);
			}

			txtFrom.add(spFrom);
		}
		{
			JLabel lblTo = new JLabel("Alle ore: ");
			GridBagConstraints gbc_lblTo  = new GridBagConstraints();
			gbc_lblTo .fill = GridBagConstraints.VERTICAL;
			gbc_lblTo .insets = new Insets(0, 0, 5, 5);
			gbc_lblTo .gridx = 0;
			gbc_lblTo  .gridy = 4;
			contentPanel.add(lblTo , gbc_lblTo );
		}
		{
			txtTo = new JTextField();
			txtTo.setLayout(new BorderLayout());
			GridBagConstraints gbc_txtTo = new GridBagConstraints();
			gbc_txtTo.fill = GridBagConstraints.BOTH;
			gbc_txtTo.insets = new Insets(0,0 , 0, 0);
			gbc_txtTo.gridx = 1;
			gbc_txtTo.gridy = 4;
			contentPanel.add(txtTo, gbc_txtTo);
			txtTo.setColumns(10);
                        txtTo.setSize(120, 60);

			spTo = new JSpinner(new SpinnerDateModel());
			JSpinner.DateEditor spinnerEditor = new JSpinner.DateEditor(spTo, "HH:mm");
			spinnerEditor.getTextField().setHorizontalAlignment(JTextField.CENTER);
			spTo.setEditor(spinnerEditor);
			spTo.setValue(new Date(11));

			if (flag == 1) {
				Calendar cal = Calendar.getInstance();
				cal.set(Calendar.HOUR, fromH);
				cal.set(Calendar.MINUTE, fromM);
				Date date = cal.getTime();
				spTo.setValue(date);
			}

			txtTo.add(spTo);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						if(flag==1) {
							parent.deleteData();	
							
						}

						Date time = (Date) spFrom.getValue();
						Calendar calendar = GregorianCalendar.getInstance();
						calendar.setTime(time);

						String event = txtEventName.getText();
                                                
                                                String clie = ClientiListApp.getObj().getCliente();
                                               
                                                String oper = txtOper.getSelectedItem().toString();
                                                
                                                txtCliente.setText(clie);
						int startHour = calendar.get(Calendar.HOUR);
						int startMinute = calendar.get(Calendar.MINUTE);
						int amPm = calendar.get(Calendar.AM_PM);
						if (amPm == 1)
							startHour += 12;

						time = (Date) spTo.getValue();
						calendar.setTime(time);

						int endHour = calendar.get(Calendar.HOUR);
						int endMinute = calendar.get(Calendar.MINUTE);
						amPm = calendar.get(Calendar.AM_PM);
						if (amPm == 1)
							endHour += 12;

						File f = new File("TodoData");
						if (!f.isDirectory())
							f.mkdir();

						File file = new File(fileName);
						boolean hasSameTime = false;
						try {

							// if the day has no event
							if (!file.exists()) {
								// save the data to file
								ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fileName));
								LinkedList<ToDo> tmp = new LinkedList<ToDo>();
								tmp.add(new ToDo(event, startHour, startMinute, endHour, endMinute,clie,oper));
								os.writeObject(tmp);
								tmp.clear();
								os.close();
								dispose();
							}
							// if the day has at least one event
							else {
								// read ToDo class from file and save to object tmp
								ObjectInputStream is = new ObjectInputStream(new FileInputStream(fileName));
								LinkedList<ToDo> tmp = (LinkedList<ToDo>) is.readObject();

								// add new event to object tmp
								tmp.add(new ToDo(event, startHour, startMinute, endHour, endMinute,clie,oper));

								// sort events by time
								Collections.sort(tmp);

								// Check for events that have the same start and end times
								for (int i = 0; i < tmp.size() - 1; i++) {
									if (tmp.get(i).isSame(tmp.get(i + 1))) {

										JOptionPane.showMessageDialog(null,
												"Orario non disponibile",
												"Orario gia scelto", JOptionPane.ERROR_MESSAGE);
										setVisible(true);
										txtFrom.requestFocusInWindow();
										hasSameTime = true;
										break;
									}
								}
								is.close();

								if (!hasSameTime) {
									ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fileName));
									os.writeObject(tmp);
									os.close();
									dispose();
								}
								tmp.clear();

							}

						} catch (EmptyToDoException e1) {
							JOptionPane.showMessageDialog(null, "Inserire prestazione", "Nessuna prestazione",
									JOptionPane.ERROR_MESSAGE);
							setVisible(true);
							txtEventName.requestFocusInWindow();
                                                        

						}
                                                catch (TimeInputException e1) {
							JOptionPane.showMessageDialog(null, "L'ora d'inizio deve essere antecedente a quella di fine",
									"Ora di inizio errata", JOptionPane.ERROR_MESSAGE);
							setVisible(true);
							txtFrom.requestFocusInWindow();

						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					
					}
				});
                                okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancella");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
        
}
