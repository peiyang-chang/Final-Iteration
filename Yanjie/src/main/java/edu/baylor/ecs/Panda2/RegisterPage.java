package edu.baylor.ecs.Panda2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import MessageFile.RegisterError1;
import MessageFile.RegisterError2;

public class RegisterPage extends JFrame{
	private JFrame frame = new JFrame("Register");
	private JPanel contentPanel;
	private JButton BackButton;
	private JButton ConfirmButton;
	HomePage homePage = new HomePage();
	
	public void CreateRegister() {
		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5,5,5,5));
		contentPanel.setLayout(null);
		
		// 标题
		JLabel HomeLabel = new JLabel();
		HomeLabel.setText("Register");
		HomeLabel.setFont(new java.awt.Font("Leelawadee UI", 0, 30));
		HomeLabel.setBounds(350,20,200,50);
		contentPanel.add(HomeLabel);
		
		// Last Name
		JLabel LastNameLabel = new JLabel();
		LastNameLabel.setText("Last Name*");
		LastNameLabel.setFont(new java.awt.Font("Leelawadee UI", 0, 20));
		LastNameLabel.setBounds(20,100,200,30);
		contentPanel.add(LastNameLabel);
		
		final JTextField LNField = new JTextField();
		LNField.setFont(new java.awt.Font("Leelawadee UI", 0, 20));
		LNField.setBounds(500,100,270,30);
		contentPanel.add(LNField);
		
		// First Name
		JLabel FirstNameLabel = new JLabel();
		FirstNameLabel.setText("First Name*");
		FirstNameLabel.setFont(new java.awt.Font("Leelawadee UI", 0, 20));
		FirstNameLabel.setBounds(20,140,200,30);
		contentPanel.add(FirstNameLabel);
		
		final JTextField FNField = new JTextField();
		FNField.setFont(new java.awt.Font("Leelawadee UI", 0, 20));
		FNField.setBounds(500,140,270,30);
		contentPanel.add(FNField);
		
		// Email
		JLabel EmailLabel = new JLabel();
		EmailLabel.setText("Email*");
		EmailLabel.setFont(new java.awt.Font("Leelawadee UI", 0, 20));
		EmailLabel.setBounds(20,180,200,30);
		contentPanel.add(EmailLabel);
		
		final JTextField EmailField = new JTextField();
		EmailField.setFont(new java.awt.Font("Leelawadee UI", 0, 20));
		EmailField.setBounds(500,180,270,30);
		contentPanel.add(EmailField);
		
		// Phone
		JLabel PhoneLabel = new JLabel();
		PhoneLabel.setText("Phone*");
		PhoneLabel.setFont(new java.awt.Font("Leelawadee UI", 0, 20));
		PhoneLabel.setBounds(20,220,200,30);
		contentPanel.add(PhoneLabel);
		
		final JTextField PhoneField = new JTextField();
		PhoneField.setFont(new java.awt.Font("Leelawadee UI", 0, 20));
		PhoneField.setBounds(500,220,270,30);
		contentPanel.add(PhoneField);
		
		// Set Password
		JLabel SetPasswordLabel = new JLabel();
		SetPasswordLabel.setText("Set Password*");
		SetPasswordLabel.setFont(new java.awt.Font("Leelawadee UI", 0, 20));
		SetPasswordLabel.setBounds(20,260,200,30);
		contentPanel.add(SetPasswordLabel);
		
		final JPasswordField SPField = new JPasswordField();
		SPField.setFont(new java.awt.Font("Leelawadee UI", 0, 20));
		SPField.setBounds(500,260,270,30);
		contentPanel.add(SPField);
		
		// Confirm Password
		JLabel ConfirmPasswordLabel = new JLabel();
		ConfirmPasswordLabel.setText("Confirm Password*");
		ConfirmPasswordLabel.setFont(new java.awt.Font("Leelawadee UI", 0, 20));
		ConfirmPasswordLabel.setBounds(20,300,200,30);
		contentPanel.add(ConfirmPasswordLabel);
		
		final JPasswordField CPField = new JPasswordField();
		CPField.setFont(new java.awt.Font("Leelawadee UI", 0, 20));
		CPField.setBounds(500,300,270,30);
		contentPanel.add(CPField);
		
		// User Name
		JLabel UsernameLabel = new JLabel();
		UsernameLabel.setText("User Name* ");
		UsernameLabel.setFont(new java.awt.Font("Leelawadee UI", 0, 20));
		UsernameLabel.setBounds(20,340,400,30);
		contentPanel.add(UsernameLabel);
		
		final JTextField UNField = new JTextField();
		UNField.setFont(new java.awt.Font("Leelawadee UI", 0, 20));
		UNField.setBounds(500,340,270,30);
		contentPanel.add(UNField);
		
		// Licenses
		JLabel LicensesLabel = new JLabel();
		LicensesLabel.setText("Licenses");
		LicensesLabel.setFont(new java.awt.Font("Leelawadee UI", 0, 20));
		LicensesLabel.setBounds(20,380,400,30);
		contentPanel.add(LicensesLabel);
				
		final JTextField LField = new JTextField();
		LField.setFont(new java.awt.Font("Leelawadee UI", 0, 20));
		LField.setBounds(500,380,270,30);
		contentPanel.add(LField);
		
		// Confirm Button
		ConfirmButton = new JButton("OK");
		ConfirmButton.setFont(new java.awt.Font("Leelawadee UI", 0, 15));
		ConfirmButton.setBounds(250,450,100,50);
		contentPanel.add(ConfirmButton);
		ConfirmButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) { 
				boolean ifRegistered = true;
				if(ifRegistered == true) {
					if(!SPField.getText().equals(CPField.getText()) ) {
						RegisterError1 errorMassage = new RegisterError1();
						ifRegistered = false;
					}
				}
				if(ifRegistered == true) {
					if(LNField.getText().equals("")){
						RegisterError2 errorMassage2 = new RegisterError2(1);
						ifRegistered = false;
					}
				}
				if(ifRegistered == true) {
					if(FNField.getText().equals("")) {
						RegisterError2 errorMassage2 = new RegisterError2(2);
						ifRegistered = false;
					}
				}
				if(ifRegistered == true) {
					if(emailCheck(EmailField.getText())) {
						RegisterError2 errorMassage2 = new RegisterError2(3);
						ifRegistered = false;
					}
				}
				if(ifRegistered == true) {
					if(phoneCheck(PhoneField.getText())) {
						RegisterError2 errorMassage2 = new RegisterError2(4);
						ifRegistered = false;
					}
				}
				if(ifRegistered == true) {
					if(SPField.getText().equals("")) {
						RegisterError2 errorMassage2 = new RegisterError2(5);
						ifRegistered = false;
					}
				}
				if(ifRegistered == true) {
					if(usernameCheck(UNField.getText())){
						RegisterError2 errorMassage2 = new RegisterError2(6);
						ifRegistered = false;
					}
				}
				if(ifRegistered == true) {
					if(LicenseCheck(LField.getText())){
						RegisterError2 errorMassage2 = new RegisterError2(7);
						ifRegistered = false;
					}
				}
				if(ifRegistered == true){
					// The name of the file to open. 
			        String fileName = "PersonList.csv";  
			        try { 
			        // Assume default encoding. 
			        FileWriter fileWriter = new FileWriter(fileName, true); 
			        // Always wrap FileWriter in BufferedWriter. 
			        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter); 
	
			        bufferedWriter.write(LNField.getText()); 
			        bufferedWriter.write(','); 
			        bufferedWriter.write(FNField.getText()); 
			        bufferedWriter.write(','); 
			        bufferedWriter.write(EmailField.getText()); 
			        bufferedWriter.write(',');
			        bufferedWriter.write(PhoneField.getText()); 
			        bufferedWriter.write(','); 
			        bufferedWriter.write(SPField.getText()); 
			        bufferedWriter.write(','); 
			        bufferedWriter.write(CPField.getText()); 
			        bufferedWriter.write(',');
			        bufferedWriter.write(UNField.getText()); 
			        bufferedWriter.write(','); 
			        bufferedWriter.write(LField.getText());
			        bufferedWriter.write(',');
			        bufferedWriter.write("null");
			        bufferedWriter.write(',');
			        bufferedWriter.newLine();
			         
			        // Always close files. 
			        bufferedWriter.close(); 
			        
			        final JFrame SuccessFrame;
			        JButton okButton;
			    	JLabel lbl;
			    	
			    	SuccessFrame= new JFrame();	
					lbl = new JLabel("Register Successed!", JLabel.CENTER);
					//lbl.setBounds(10, 100, 150,50);
					
					okButton = new JButton("OK");
					okButton.setBounds(50, 100, 80, 40);
					okButton.addActionListener(new ActionListener() {

						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							SuccessFrame.dispose();
							closeThis();
							homePage.setLoginStatus(homePage.getLoginStatus());
							homePage.CreateFrame();
						}
						
					});
					SuccessFrame.add(okButton);
					SuccessFrame.add(lbl);
					SuccessFrame.setSize(200, 200);
					SuccessFrame.setLocationRelativeTo(null);
					SuccessFrame.setVisible(true);
			        } 
			        catch(IOException ex) { 
			         System.out.println(
			          "Error writing to file '" 
			          + fileName + "'"); 
			         // Or we could just do this: 
			         // ex.printStackTrace(); 
			        } 
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
				homePage.setLoginStatus(homePage.getLoginStatus());
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
	
	/**
	 * This class will check the email is valid or not
	 * 
	 * @param args str. string value of email
	 * @return true if email is invalid, false if email is valid.
	 */
	public boolean emailCheck(String str) {
		boolean tester = true;
		if(str.length() < 3) {
			return true;
		}else {
			for(int i = 0; i < str.length(); i++) {
				if(str.charAt(i) == '@') {
					if(i == str.length() - 1) {
						return true;
					}
					tester = false;
				}
			}
			if(tester == false) {
				String[] content = {"",""};
				String[] split = str.split("@");
				content[0] = split[0];
				content[1] = split[1];
				if(content[0].equalsIgnoreCase("")) {
					return true;
				}
				if(content[1].equalsIgnoreCase("baylor.edu")) {
					return false;
				}	
			}
		}
		
		return true;
	}
	public boolean phoneCheck(String str) {
		if(str.length() != 10) {
			return true;
		}
		for(int i = 0; i < 10; i++) {
			if(!Character.isDigit(str.charAt(i))) {
				return true;
			}
		}
		return false;
	}
	
	public boolean usernameCheck(String str) {
		int counter = 0;
		ArrayList<String> userList = new ArrayList<String>();
		try {
			Scanner sc = new Scanner(new File("PersonList.csv"));
			while(sc.hasNext()) {
				String line = sc.nextLine();
				String content = "";
				String[] split = line.split(",");
				content = split[6];
				userList.add(content);
				counter++;
			}
		} catch (FileNotFoundException e) {
			// The name of the file to open. 
	        String fileName = "PersonList.csv";  
	        try { 
	        // Assume default encoding. 
	        FileWriter fileWriter = new FileWriter(fileName, true); 
	        // Always wrap FileWriter in BufferedWriter. 
	        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter); 

	        bufferedWriter.write("Last Name"); 
	        bufferedWriter.write(','); 
	        bufferedWriter.write("First Name"); 
	        bufferedWriter.write(','); 
	        bufferedWriter.write("Email"); 
	        bufferedWriter.write(',');
	        bufferedWriter.write("Phone"); 
	        bufferedWriter.write(','); 
	        bufferedWriter.write("Password"); 
	        bufferedWriter.write(','); 
	        bufferedWriter.write("Confirm Password"); 
	        bufferedWriter.write(',');
	        bufferedWriter.write("User Name"); 
	        bufferedWriter.write(','); 
	        bufferedWriter.write("License Number"); 
	        bufferedWriter.write(','); 
	        bufferedWriter.write("Pic Path"); 
	        bufferedWriter.write(','); 
	        bufferedWriter.newLine();
	         
	        // Always close files. 
	        bufferedWriter.close(); 
	        }
		    catch(IOException ex) { 
		         System.out.println(
		          "Error writing to file '" 
		          + fileName + "'");  
			} 
		}
		for(int i = 0; i < counter; i++) {
			if(userList.get(i).equalsIgnoreCase(str)) {
				return true;
			}
		}
		return false;
		
	}
	public boolean LicenseCheck(String str) {
		if(str.length() != 8) {
			return true;
		}
		for(int i = 0; i < 8; i++) {
			if(!Character.isDigit(str.charAt(i))) {
				return true;
			}
		}
		return false;
	}
}
