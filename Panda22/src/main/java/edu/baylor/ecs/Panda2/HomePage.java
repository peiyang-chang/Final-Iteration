package edu.baylor.ecs.Panda2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import DataBase.PersonList;
import MessageFile.LoginPlease;

/**
 * <h1>HomePage</h1> Basically, the home page contains login button to login your account, register Button to register
 * an account, profile button to open the profile if you log in, two recommend cars, and a car list in More Car button
 * 
 *  
 * <p>
 *
 * @author Yanjie Ning
 * @version 1.7
 * @since 2019-9-25
 */
public class HomePage extends JPanel implements ItemListener, ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame = new JFrame("PandaDealerShip");
	private JPanel contentPanel;
	private JButton LoginButton;
	private JButton RegisterButton;
	private JButton ProfileButton;
	private JButton MoreButton;
	private JButton YouHaveLogin;
	private JButton Logout;
	private boolean LoginStatus = false;
	private String LoginUsername = "";
	private int index = -1;
	private PersonList person = new PersonList();
	
	/**
	 * This is the class return a login user name
	 * 
	 * @param args Nothing
	 * @return String. login user name
	 */
	public String getLoginUsername() {
		return LoginUsername;
	}

	/**
	 * This is the class set a login user name
	 * 
	 * @param args loginUsername
	 * @return Nothing
	 */
	public void setLoginUsername(String loginUsername) {
		LoginUsername = loginUsername;
	}
	
	/**
	 * This is the class return a LoginStatus
	 * 
	 * @param args Nothing
	 * @return boolean. LoginStatus
	 */
	public boolean getLoginStatus() {
		return LoginStatus;
	}

	/**
	 * This is the class set a loginStatus
	 * 
	 * @param args loginStatus
	 * @return Nothing
	 */
	public void setLoginStatus(boolean loginStatus) {
		LoginStatus = loginStatus;
	}
	/**
	 * This class will create a home page frame
	 * 
	 * @param args Nothing
	 * @return Nothing.
	 */
	public void CreateFrame() {
		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5,5,5,5));
		contentPanel.setLayout(null);
		
		if(!LoginStatus) {
			// 转到login page
			LoginButton = new JButton("Login");
			LoginButton.setFont(new java.awt.Font("Leelawadee UI", 0, 15));
			LoginButton.setBounds(600,20,90,30);
			contentPanel.add(LoginButton);
			LoginButton.addActionListener(new ActionListener() {
	
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					closeThis();
					LoginPage loginPage = new LoginPage();
					loginPage.CreateLogin();
				}
				
			});
		}else {
			// 转到login page
			YouHaveLogin = new JButton("Loginned");
			YouHaveLogin.setFont(new java.awt.Font("Leelawadee UI", 0, 15));
			YouHaveLogin.setBounds(600,20,90,30);
			contentPanel.add(YouHaveLogin);
		}
		
		
		if(!LoginStatus) {
			// 转到Register page
			RegisterButton = new JButton("Register");
			RegisterButton.setFont(new java.awt.Font("Leelawadee UI", 0, 15));
			RegisterButton.setBounds(690,20,90,30);
			contentPanel.add(RegisterButton);
			RegisterButton.addActionListener(new ActionListener() {
	
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					closeThis();
					RegisterPage registerPage = new RegisterPage();
					registerPage.CreateRegister();
				}
						
			});
		}else {
			Logout = new JButton("Logout");
			Logout.setFont(new java.awt.Font("Leelawadee UI", 0, 15));
			Logout.setBounds(690,20,90,30);
			contentPanel.add(Logout);
			Logout.addActionListener(new ActionListener() {
	
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					closeThis();
					HomePage homeLogout = new HomePage();
					homeLogout.CreateFrame();
				}
						
			});
		}
		
		
		// 转到profile
		try {
			person.readCSV("PersonList.csv");
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		index = person.getCurr(LoginUsername);
		ProfileButton = new JButton("Profile");
		ImageIcon img3 = new ImageIcon("profile.jpg");
		ProfileButton.setIcon(img3);
		ProfileButton.setBounds(620,60,130,81);
		contentPanel.add(ProfileButton);
		ProfileButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(!LoginStatus || index == -1) {
					LoginPlease msg = new LoginPlease();
	    			msg.createGUI();
				}
				else {
					closeThis();
					ProfileFrame profile = new ProfileFrame();
					try {
						profile.createGUI(LoginUsername);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
					
		});
		
		// 标题1
		JLabel HomePageLabel1 = new JLabel();
		HomePageLabel1.setText("PandaDealerShip");
		HomePageLabel1.setFont(new java.awt.Font("Leelawadee UI", 0, 60));
		HomePageLabel1.setBounds(0 ,20,600,100);
		contentPanel.add(HomePageLabel1);
		
		// 标题2
		JLabel HomePageLabel2 = new JLabel();
		HomePageLabel2.setText("Best DealerShip in Waco");
		HomePageLabel2.setFont(new java.awt.Font("Leelawadee UI", 0, 20));
		HomePageLabel2.setBounds(0 ,120,250,30);
		contentPanel.add(HomePageLabel2);
		
		// 图片
		JLabel HomePagePhoto = new JLabel();
		ImageIcon imgHomePage = new ImageIcon("baylor.jpg");
		HomePagePhoto.setIcon(imgHomePage);
		HomePagePhoto.setBounds(0 ,150,750,150);
		contentPanel.add(HomePagePhoto);
		
		// Text Recommend
		JLabel Recommend = new JLabel();
		Recommend.setFont(new java.awt.Font("Leelawadee UI", 0, 20));
		Recommend.setText("Recommend to You:");
		Recommend.setBounds(0, 320, 200, 30);
		contentPanel.add(Recommend);
		
		// 奥迪R8 图片
		JButton imgButton1 = new JButton();
		ImageIcon img1 = new ImageIcon("audiR8.jpeg");
		imgButton1.setIcon(img1);
		imgButton1.setBounds(0,370,350,200);
		contentPanel.add(imgButton1);
		imgButton1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				closeThis();
				CarInfo2 Info2 = new CarInfo2();
				try {
					Info2.createGUI(LoginUsername);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		// 奥迪R8 描述
		JLabel carTest1 = new JLabel("Test");
		carTest1.setFont(new java.awt.Font("Leelawadee UI", 0, 20));
		carTest1.setText("2019 Audi R8!");
		carTest1.setBounds(50,570,200,50);
		contentPanel.add(carTest1);
		
		// 奔驰GT 图片
		JButton imgButton2 = new JButton();
		ImageIcon img2 = new ImageIcon("BenzGT63.jpg");
		imgButton2.setIcon(img2);
		imgButton2.setBounds(400,370,350,200);
		contentPanel.add(imgButton2);
		imgButton2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				closeThis();
				CarInfo1 Info1 = new CarInfo1();
				try {
					Info1.createGUI(LoginUsername);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		// 奔驰GT 描述
		JLabel carTest2 = new JLabel("Test");
		carTest2.setFont(new java.awt.Font("Leelawadee UI", 0, 20));
		carTest2.setText("Benz GT 63!");
		carTest2.setBounds(450,570,200,50);
		contentPanel.add(carTest2);
		
		
		// more Button
		MoreButton = new JButton("More Cars!");
		MoreButton.setFont(new java.awt.Font("Leelawadee UI", 0, 30));
		MoreButton.setBounds(0,650,300,50);
		contentPanel.add(MoreButton);
		MoreButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				closeThis();
				CarListFrame carList = new CarListFrame();
				
				try {
					carList.createGUI(LoginUsername);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setSize(900, 800);
		frame.setLocationRelativeTo(null);
		
		contentPanel.setBounds(50,0,800,800);
		
		frame.add(contentPanel);
		
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void closeThis() {
		frame.dispose();
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}

}
