package edu.baylor.ecs.Panda2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import DataBase.Person;
import MessageFile.LoginError;

public class LoginPage extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame = new JFrame("Login");
	private JPanel contentPanel;
	private JButton BackButton;
	private JButton ConfirmButton;
	HomePage homePage = new HomePage();
	
	public void CreateLogin() {
		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5,5,5,5));
		contentPanel.setLayout(null);
		
		// 标题
		JLabel HomeLabel = new JLabel();
		HomeLabel.setText("Login");
		HomeLabel.setFont(new java.awt.Font("Leelawadee UI", 0, 30));
		HomeLabel.setBounds(350,20,200,50);
		contentPanel.add(HomeLabel);
		
		// 图片
		JLabel LoginPhoto = new JLabel();
		ImageIcon imgLogin = new ImageIcon("baylor_bear.png");
		LoginPhoto.setIcon(imgLogin);
		LoginPhoto.setBounds(325,100,150,150);
		contentPanel.add(LoginPhoto);
		
		// User Name
		JLabel UsernameLabel = new JLabel();
		UsernameLabel.setText("User Name:");
		UsernameLabel.setFont(new java.awt.Font("Leelawadee UI", 0, 20));
		UsernameLabel.setBounds(200,300,200,30);
		contentPanel.add(UsernameLabel);
		
		final JTextField UsernameField = new JTextField();
		UsernameField.setFont(new java.awt.Font("Leelawadee UI", 0, 20));
		UsernameField.setBounds(400,300,300,30);
		contentPanel.add(UsernameField);

		// Password
		JLabel PasswordLabel = new JLabel();
		PasswordLabel.setText("PassWord");
		PasswordLabel.setFont(new java.awt.Font("Leelawadee UI", 0, 20));
		PasswordLabel.setBounds(200,350,200,30);
		contentPanel.add(PasswordLabel);
				
		final JPasswordField PasswordField = new JPasswordField();
		PasswordField.setFont(new java.awt.Font("Leelawadee UI", 0, 20));
		PasswordField.setBounds(400,350,300,30);
		contentPanel.add(PasswordField);	
		
		// Confirm Button
		ConfirmButton = new JButton("OK");
		ConfirmButton.setFont(new java.awt.Font("Leelawadee UI", 0, 15));
		ConfirmButton.setBounds(250,450,100,50);
		contentPanel.add(ConfirmButton);
		ConfirmButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				boolean ifRegistered = false;
				int counter = 0;
				ArrayList<Person> pList = new ArrayList<Person>();
				try {
					Person person;
					Scanner sc = new Scanner(new File("PersonList.csv"));
					while(sc.hasNext()) {
						person = new Person();
						String line = sc.nextLine();
						String[] content = {"","","","","","","",""};
						String[] split = line.split(",");
						for(int i = 0; i < 8; i++) {
							content[i] = split[i];
						}
						person.setLastName(content[0]);
						person.setFristName(content[1]);
						person.setEmail(content[2]);
						person.setPhone(content[3]);
						person.setPassword(content[4]);
						person.setUsername(content[6]);
						person.setLicense(content[7]);
						pList.add(person);
						counter++;
					}
				} catch (FileNotFoundException e1) {
					System.out.println(e1.toString());
					System.exit(1);
				}
				for(int i = 0; i < counter; i++) {
					if(pList.get(i).getUsername().equalsIgnoreCase(UsernameField.getText()) && 
							   pList.get(i).getPassword().equals(PasswordField.getText())) {
								ifRegistered = true;
					}
				}
				if(!ifRegistered) {
					LoginError errorMessage = new LoginError();
					errorMessage.createGUI();
				}else {
				    final JFrame SuccessFrame;
				    JButton okButton;
				  	JLabel lbl;
				    	
				   	SuccessFrame= new JFrame();	
				   	lbl = new JLabel("Login Successed!", JLabel.CENTER);
					//lbl.setBounds(10, 100, 150,50);
						
					okButton = new JButton("OK");
					okButton.setBounds(60, 120, 80, 40);
					okButton.addActionListener(new ActionListener() {

						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							SuccessFrame.dispose();
							closeThis();
							homePage.setLoginStatus(true);
							homePage.setLoginUsername(UsernameField.getText());
							homePage.CreateFrame();
						}							
					});
					SuccessFrame.add(okButton);
					SuccessFrame.add(lbl);
					SuccessFrame.setSize(200, 200);
					SuccessFrame.setLocationRelativeTo(null);
					SuccessFrame.setVisible(true);
				}
			}		
	});
		
		// Back Button
		BackButton = new JButton("Back");
		BackButton.setFont(new java.awt.Font("Leelawadee UI", 0, 15));
		BackButton.setBounds(400,450,100,50);
		contentPanel.add(BackButton);
		BackButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				closeThis();
				//HomePage homePage = new HomePage();
				homePage.CreateFrame();
			}
					
		});
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setSize(800, 650);
		frame.setLocationRelativeTo(null);
		
		contentPanel.setBounds(0,0,800,650);
		frame.add(contentPanel);
	}
	
	public void closeThis() {
		frame.dispose();
	}
}
