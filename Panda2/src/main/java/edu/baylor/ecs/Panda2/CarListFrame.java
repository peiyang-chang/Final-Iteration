package edu.baylor.ecs.Panda2;

import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import MessageFile.ContainMessage;
import MessageFile.LoginPlease;
import MessageFile.NotSelectedMessage;
import MessageFile.addMessage;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class CarListFrame extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    private JTextField textField;
	private JFrame frame = new JFrame("Car List"); 
	private String[] columnNames = {"Make", "Model", "Year",
			"Color", "Price"};
	private CarList myList;
	private Object[][] listData;
	private DefaultTableModel tableModel;
	private JTable table;
	private JButton backButton;
	private TableRowSorter<TableModel> rowSorter;
	private JButton addButton;
	private JButton payButton;
	private CarFavList FavList = new CarFavList();
	private String filePath = "";
	private PersonList person = new PersonList();
	private int index = -1;
	private String user = "";
	HomePage homePage = new HomePage();
	
	public CarListFrame() {
		super();
	}

    /**
     * Create the frame.
     * @param loginUsername 
     * @throws FileNotFoundException 
     */
    public void createGUI(String loginUsername) throws FileNotFoundException {
    	user = loginUsername;
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);

        JLabel label = new JLabel("Search :");
        label.setBounds(12, 12, 75, 18);
        
        
        textField = new JTextField();
        textField.setBounds(80, 7, 189, 28);
        contentPane.add(textField);
        textField.setColumns(10);
        label.setLabelFor(textField);
        contentPane.add(label);
        
        myList = new CarList();
        myList.readCSV("CarList1.csv");
        listData = myList.conver2Data();
        tableModel = new DefaultTableModel(listData,columnNames);
        table = new JTable(tableModel);
        rowSorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(rowSorter);
        textField.getDocument().addDocumentListener(new DocumentListener(){
            
            public void insertUpdate(DocumentEvent e) {
                String text = textField.getText();
                
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }
            
            public void removeUpdate(DocumentEvent e) {
                String text = textField.getText();
                
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            } 
            
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            
        });
        
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(22, 42, 570, 400);
        contentPane.add(scrollPane);
        
        backButton = new JButton("Back");
        backButton.setBounds(60, 455, 80, 40);
        contentPane.add(backButton);
        backButton.addActionListener(this);
        
        
        addButton = new JButton("Add");
        addButton.setBounds(260, 455, 80, 40);
        contentPane.add(addButton);
        addButton.addActionListener(this);
        
        payButton = new JButton("Pay");
        payButton.setBounds(460, 455, 80, 40);
        contentPane.add(payButton);
        payButton.addActionListener(this);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(650, 570);
        frame.setLocationRelativeTo(null);
        frame.add(contentPane);
        
    }
    
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == backButton) {
            frame.dispose();
            HomePage homePage = new HomePage();
            if(user == "") {
    			homePage.setLoginStatus(false);
    		}
    		else {
    			homePage.setLoginStatus(true);
    			homePage.setLoginUsername(user);
    		}
            homePage.CreateFrame();
        }
        else if(e.getSource() == addButton) {
        	if(user != "" && index != -1) {
        		try {
					person.readCSV("PersonList.csv");
				} catch (FileNotFoundException e2) {
					e2.printStackTrace();
				}
            	index = person.getCurr(user);
                filePath = person.getPerson(index).getUsername() + ".csv";
                try {
                	FavList.readCSV(filePath);
                }
                catch (FileNotFoundException e1){
                	FileWriter fileWriter;
        			try {
        				fileWriter = new FileWriter(filePath, true);
        				BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        		        bufferedWriter.close();
        			} catch (IOException e11) {
        				e11.printStackTrace();
        			} 
        	        
                }
            	if(table.getSelectionModel().isSelectionEmpty() == true) {
            		NotSelectedMessage msg1 = new NotSelectedMessage();
            		msg1.createGUI();
            	}
            	else {
    	    		int selectedRow = table.getSelectedRow();
    	    		Car car = new Car();
    	    		car = myList.getData(selectedRow);

            		FavList.add(car);
            		try {
        				FavList.save(filePath);
        			} catch (IOException e1) {
        				e1.printStackTrace();
        			}
            	}
        	}
        	else {
        		LoginPlease msg = new LoginPlease();
    			msg.createGUI();
        	}

        }
        else if(e.getSource() == payButton) {
        	if(user != "" && index != -1) {
	        	if(table.getSelectionModel().isSelectionEmpty() == true) {
	        		NotSelectedMessage msg1 = new NotSelectedMessage();
	        		msg1.createGUI();
	        	}
	        	else {
		        	int selectedRow = table.getSelectedRow();
		        	Car car = myList.getData(selectedRow);
			        frame.dispose();
			        MakePayment pay = new MakePayment();
			        pay.addCar(car); 
			        pay.createGUI(index);
	        	}
        	}
        	else {
        		LoginPlease msg = new LoginPlease();
    			msg.createGUI();
        	}
		}
    }
    
    
    
}
