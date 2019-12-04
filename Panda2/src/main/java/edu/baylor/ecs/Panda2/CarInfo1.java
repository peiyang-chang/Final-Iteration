package edu.baylor.ecs.Panda2;

import javax.swing.ImageIcon; 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DataBase.Car;
import DataBase.CarFavList;
import DataBase.PersonList;
import MessageFile.LoginPlease;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class CarInfo1 extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton okButton;
	private JButton FavorButton;
	private JFrame frame = new JFrame("2018 Mercedes-Benz GT 63");
	private Car BenzCar = new Car("Mercedes", "GT 63", "2018", "Blue", "136500");
	private CarFavList FavList = new CarFavList();
	private PersonList person = new PersonList();
	private String filePath = "";
	private int index = -1;
	//private boolean login = false;
	private String user = "";
	
	public CarInfo1() {
		super();
	}
	public void createGUI(String loginUsername) throws FileNotFoundException {
		user = loginUsername;
		person.readCSV("PersonList.csv");
		index = person.getCurr(loginUsername);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		contentPane.setLayout(null);
		
		JLabel label = new JLabel();
		ImageIcon img = new ImageIcon("BenzGT63 2.jpg");
		label.setIcon(img);
		label.setBounds(125,25,500,333);
		contentPane.add(label);
		
		JLabel label1 = new JLabel("Test");
		label1.setText("The high-performance sedan is powered by a 4.0-liter twin-turbo V8 making 577 horsepower");
		label1.setBounds(100, 350, 600, 85);
		contentPane.add(label1);
		
		JLabel label2 = new JLabel("Test");
		label2.setText("and 590 lb-ft of torque. It's higher output sibling, the Mercedes-AMG GT 63 S, makes 630");
		label2.setBounds(100, 370, 600, 85);
		contentPane.add(label2);
		
		JLabel label3 = new JLabel("Test");
		label3.setText(" horsepower and 664 lb-ft of torque and is appropriately priced higher at $159,000");
		label3.setBounds(100, 390, 600, 85);
		contentPane.add(label3);
		
		
		okButton = new JButton("OK");
		okButton.setBounds(150, 500, 80, 40);
		contentPane.add(okButton);
		okButton.addActionListener((ActionListener) this);
		
		FavorButton = new JButton("Favor");
		FavorButton.setBounds(550, 500, 80, 40);
		contentPane.add(FavorButton);
		FavorButton.addActionListener((ActionListener) this);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack(); 
		frame.setVisible(true);
		frame.setSize(800, 650);
		frame.setLocationRelativeTo(null);
		frame.add(contentPane);
		
		
		
	}
	public void actionPerformed(ActionEvent e) {
    	if(e.getSource() == okButton) {
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
    	else if(e.getSource() == FavorButton) {
    		if(user != "" && index != -1) {
				try {
					person.readCSV("PersonList.csv");
				} catch (FileNotFoundException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
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
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} 
			        
		        }
		    	FavList.add(BenzCar);
				try {
					FavList.save(filePath);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
    		}
    		else {
    			LoginPlease msg = new LoginPlease();
    			msg.createGUI();
    		}
    	}
    }
	
}
