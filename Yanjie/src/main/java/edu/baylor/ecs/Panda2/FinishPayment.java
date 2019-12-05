package edu.baylor.ecs.Panda2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DataBase.PaymentList;

/**
 * <h1>CarListFrame</h1> This is the frame that will show when the payment is
 * finished which means all the payment information has been stored into our
 * database.
 * <p>
 *
 * @author Peiyang Chang
 * @version 1.7
 * @since 2019-10-14
 */
public class FinishPayment extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame = new JFrame("Your payment is successful!!!");
	private JLabel lbl1;
	private JPanel contentPane;
	private JButton BackButton;
	private JLabel lbl2;
	private PaymentList payment = new PaymentList();

	public FinishPayment() {
		super();
	}

	/**
	 * Create the finish payment frame, it will shows the appointment time that you
	 * chose
	 * 
	 * @param Nothing
	 */
	public void createGUI() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);

		BackButton = new JButton("EXIT");
		BackButton.setBounds(350, 525, 80, 40);
		contentPane.add(BackButton);
		BackButton.addActionListener(this);

		lbl1 = new JLabel("Your order has been successfully processed. Thank you!");
		lbl1.setBounds(200, 300, 400, 200);
		contentPane.add(lbl1);

		lbl2 = new JLabel();
		try {
			payment.readCSV("PaymentInfo.csv");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lbl2.setText("Come to store at " + payment.getData().getAppTime());
		lbl2.setBounds(200, 350, 400, 200);
		contentPane.add(lbl2);

		JLabel label = new JLabel();
		ImageIcon img = new ImageIcon("CCar.jpg");
		label.setIcon(img);
		label.setBounds(100, 30, 564, 299);
		contentPane.add(label);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		frame.setSize(800, 650);
		frame.setLocationRelativeTo(null);
		// frame.add(panel);
		frame.add(contentPane);

	}

	/**
	 * This class will do the action of each action listener. BackButton will back
	 * to home page.
	 * 
	 * @param args ActionEvent
	 * @return Nothing.
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == BackButton) {
			frame.dispose();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		}

	}

}
