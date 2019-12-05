package edu.baylor.ecs.Panda2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import org.jdatepicker.impl.DateComponentFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import DataBase.Car;
import DataBase.PaymentList;
import DataBase.PersonList;
import MessageFile.NoDate;
import MessageFile.PaymentError;

/**
 * <h1>MakePayment</h1> This is the frame that user can make a payment and
 * appointment to come to store and pick up the car.
 * <p>
 *
 * @author Peiyang Chang
 * @version 1.7
 * @since 2019-9-25
 */
public class MakePayment extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JFrame frame = new JFrame("Make a Payment");
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JButton payButton;
	private JButton backButton;
	private String pic = "pay1.jpg";
	private JCheckBox c1;
	private Car car = new Car();
	private PersonList person = new PersonList();
	private PaymentList payment = new PaymentList();
	private int index = -1;
	private JDatePickerImpl datePicker;
	private String Username;
	private JButton readButton;

	public MakePayment() {
		super();
	}

	public void addCar(Car info) {
		this.car = info;
	}

	/**
	 * Create the Make Payment frame. It contains the car information and person
	 * information (car name and price, person name and phone) and those information
	 * is not editable. The only thing you can put in is the appointment time which
	 * is the time you want to pick up your car in the store
	 * 
	 * @param number : position of the logged in person in the person list
	 * @throws FileNotFoundException
	 */
	public void createGUI(int number) {
		index = number;
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		JLabel lblNewLabel = new JLabel(new ImageIcon(pic));
		lblNewLabel.setBounds(10, 10, 116, 133);
		contentPane.add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Make Payment: ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 150, 750, 370);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel label = new JLabel("Car Names");
		label.setBounds(20, 34, 155, 18);
		panel.add(label);

		JLabel label_1 = new JLabel("Car Price");
		label_1.setBounds(20, 75, 155, 18);
		panel.add(label_1);

		JLabel label_2 = new JLabel("Buyer's Names");
		label_2.setBounds(20, 116, 155, 18);
		panel.add(label_2);

		JLabel label_3 = new JLabel("Buyer's Phone");
		label_3.setBounds(20, 157, 155, 18);
		panel.add(label_3);

		JLabel lblNewLabel_1 = new JLabel("Appointment Time");
		lblNewLabel_1.setBounds(20, 198, 155, 18);
		panel.add(lblNewLabel_1);

		textField = new JTextField(car.getMake() + " " + car.getModel());
		textField.setEditable(false);
		textField.setBounds(200, 34, 188, 28);
		panel.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField(car.getPrice());
		textField_1.setEditable(false);
		textField_1.setBounds(200, 75, 188, 28);
		panel.add(textField_1);
		textField_1.setColumns(10);

		try {
			person.readCSV("PersonList.csv");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Username = person.getPerson(index).getUsername();

		textField_2 = new JTextField(
				person.getPerson(index).getFristName() + " " + person.getPerson(index).getLastName());
		textField_2.setEditable(false);
		textField_2.setBounds(200, 116, 188, 23);
		panel.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField(person.getPerson(index).getPhone());
		textField_3.setEditable(false);
		textField_3.setBounds(200, 157, 188, 23);
		panel.add(textField_3);
		textField_3.setColumns(10);

		UtilDateModel model = new UtilDateModel();
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		datePicker = new JDatePickerImpl(datePanel, new DateComponentFormatter());
		datePicker.setBounds(200, 198, 188, 23);
		panel.add(datePicker);

		backButton = new JButton("Back");
		backButton.setBounds(350, 525, 80, 40);
		contentPane.add(backButton);
		backButton.addActionListener(this);

		payButton = new JButton("Submit");
		payButton.setBounds(135, 525, 80, 40);
		contentPane.add(payButton);
		payButton.addActionListener(this);
		
		readButton = new JButton("read");
		readButton.setBounds(395, 565, 60, 30);
		contentPane.add(readButton);
		readButton.addActionListener(this);

		c1 = new JCheckBox("I have read and agree to the Terms");
		c1.setBounds(145, 565, 288, 23);
		contentPane.add(c1);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		frame.setSize(800, 650);
		frame.setLocationRelativeTo(null);
		frame.add(panel);
		frame.add(contentPane);
	}

	/**
	 * This class will do the action of each action listener. backButton will back
	 * to home page. 
	 * <p>
	 * payButton which will submit the payment information to to
	 * paymentInfo list and store into our PaymentInfo.csv. it will print error
	 * message if not selected or not logged in
	 * <p>
	 * readButton will pop out a screen.
	 * 
	 * @param args ActionEvent
	 * @return Nothing.
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == readButton) {
			final JFrame frame1 = new JFrame();
			JLabel lbl12 = new JLabel();
			ImageIcon img = new ImageIcon("2235940_1.jpg");
			lbl12.setIcon(img);
			lbl12.setBounds(10, 100, 150, 50);

			JButton yesButton = new JButton("YES");
			yesButton.setBounds(280, 580, 80, 40);
			yesButton.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					frame1.dispose();
				}
				
			});

			frame1.add(yesButton);
			frame1.add(lbl12);
			frame1.setSize(640, 650);
			frame1.setLocationRelativeTo(null);
			frame1.setVisible(true);
		}
		if (e.getSource() == payButton) {
			if (c1.isSelected() == true) {
				if (datePicker.getModel().getValue() == null) {
					NoDate msg = new NoDate();
					msg.createGUI();
				} else {
					Date selectedDate = (Date) datePicker.getModel().getValue();
					DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
					String date = df.format(selectedDate);
					try {
						payment.WriteIntoFile("PaymentInfo.csv", textField.getText(), textField_1.getText(),
								textField_2.getText(), textField_3.getText(), date);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					frame.dispose();
					FinishPayment pay = new FinishPayment();
					pay.createGUI();
				}
			} else {
				PaymentError error = new PaymentError();
				error.createGUI();
				// frame.setEnabled(false);
			}
		} else if (e.getSource() == backButton) {
			frame.dispose();
			HomePage homePage = new HomePage();
			homePage.setLoginStatus(true);
			homePage.setLoginUsername(Username);
			homePage.CreateFrame();
		}

	}
}
