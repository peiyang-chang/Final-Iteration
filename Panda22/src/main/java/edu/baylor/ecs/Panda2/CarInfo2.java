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

/**
 * <h1>CarInfo2</h1> This is the frame that contain one specific Audi car
 * information
 * <p>
 *
 * @author Peiyang Chang
 * @version 1.7
 * @since 2019-9-25
 */
public class CarInfo2 extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton okButton;
	private JButton FavorButton;
	private JFrame frame = new JFrame("2019 Audi R8");
	private CarFavList FavList = new CarFavList();
	private String filePath = "";
	private Car AudiCar = new Car("Audi", "R8", "2020", "Blue", "189645");
	private PersonList person = new PersonList();
	private int index = -1;
	// private boolean login = false;
	private String user = "";

	public CarInfo2() {
		super();
	}

	/**
	 * This class will create an Audi car information frame
	 * 
	 * @param args loginUsername
	 * @return Nothing.
	 * @exception FileNotFoundException On input error.
	 * @see FileNotFoundException
	 */
	public void createGUI(String loginUsername) throws FileNotFoundException {
		user = loginUsername;
		person.readCSV("PersonList.csv");
		index = person.getCurr(loginUsername);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);

		JLabel label = new JLabel();
		ImageIcon img = new ImageIcon("audi.jpg");
		label.setIcon(img);
		label.setBounds(100, 25, 600, 340);
		contentPane.add(label);

		JLabel label1 = new JLabel("Test");
		label1.setText("The 2019 R8 spent plenty of time in Neckarsulm's gym, beefing up the 5.2-liter V10 to 562");
		label1.setBounds(100, 350, 600, 85);
		contentPane.add(label1);

		JLabel label2 = new JLabel("Test");
		label2.setText("horsepower and 406 pound-feet of torque, gains of 30 hp and seven lb-ft over last year's ");
		label2.setBounds(100, 370, 600, 85);
		contentPane.add(label2);

		JLabel label3 = new JLabel("Test");
		label3.setText("model. With the R8 Performance, the improvements are smaller, with just nine hp and 15 lb-ft.");
		label3.setBounds(100, 390, 600, 85);
		contentPane.add(label3);

		okButton = new JButton("OK");
		okButton.setBounds(150, 500, 80, 40);
		contentPane.add(okButton);
		okButton.addActionListener((ActionListener) this);

		index = person.getCurr(user);
		filePath = person.getPerson(index).getUsername() + ".csv";
		try {
			FavList.readCSV(filePath);
		} catch (FileNotFoundException e1) {
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

	/**
	 * This class will do the action of each action listener. okButton will back to
	 * home page. FavorButton will add this Audi car into user's favorite car list
	 * 
	 * @param args ActionEvent
	 * @return Nothing.
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == okButton) {
			frame.dispose();
			HomePage homePage = new HomePage();
			if (user == "") {
				homePage.setLoginStatus(false);
			} else {
				homePage.setLoginStatus(true);
				homePage.setLoginUsername(user);
			}
			homePage.CreateFrame();
			// frame2.setVisible(true);
		} else if (e.getSource() == FavorButton) {
			if (!user.equals("") && index != -1) {
				try {
					person.readCSV("PersonList.csv");
				} catch (FileNotFoundException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}

				FavList.add(AudiCar,filePath);
			} else {
				LoginPlease msg = new LoginPlease();
				msg.createGUI();
			}

		}
	}
}
