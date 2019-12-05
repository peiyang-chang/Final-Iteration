package MessageFile;

import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * <h1>RegisterError2</h1> The RegisterError2 class in the MessageFile Package,
 * it will prints "Last Name Missing!" that the last name is empty.
 * <p>
 * it will prints "First Name Missing!" that the first name is empty.
 * <p>
 * it will prints "Invalid Email! (Baylor email only)" that the email is invalid
 * <p>
 * it will prints "Invalid Phone Number" that the phone is invalid
 * <p>
 * it will prints "Password Missing!" that the password is missing
 * <p>
 * it will prints "Used User Name!" that the user name has been used
 * <p>
 *
 * @author Yanjie Ning
 * @version 1.7
 * @since 2019-11-14
 */
public class RegisterError2 extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton okButton;
	private JLabel lbl;
	private JFrame frame;

	public RegisterError2(int a) {

		frame = new JFrame();
		switch (a) {
		case 1:
			lbl = new JLabel("Last Name Missing!", JLabel.CENTER);
			break;
		case 2:
			lbl = new JLabel("First Name Missing!", JLabel.CENTER);
			break;
		case 3:
			lbl = new JLabel("Invalid Email! (Baylor email only)", JLabel.CENTER);
			break;
		case 4:
			lbl = new JLabel("Invalid Phone Number", JLabel.CENTER);
			break;
		case 5:
			lbl = new JLabel("Password Missing!", JLabel.CENTER);
			break;
		case 6:
			lbl = new JLabel("Used User Name!", JLabel.CENTER);
			break;
		}

		// lbl.setBounds(10, 100, 150,50);

		okButton = new JButton("OK");
		okButton.setBounds(120, 80, 80, 40);
		okButton.addActionListener(this);

		frame.add(okButton);
		frame.add(lbl);
		frame.setSize(300, 150);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == okButton) {
			frame.dispose();
		}
	}

}
