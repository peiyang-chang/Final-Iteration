package MessageFile;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * <h1>InformationChangeError</h1> The InformationChangeError class in the
 * MessageFile Package, it will print "Invalid phone number" if the phone number
 * is invalid.
 * <p>
 * it will print "Invalid Email (Baylor email only)" if the email is invalid
 * <p>
 * it will print "Invalid Driver License" if the driver license is invalid.
 * <p>
 * print message to a windows to tell the user that she or he needs to enter
 * valid information.
 * <p>
 *
 * @author Peiyang Chang
 * @version 1.7
 * @since 2019-11-25
 */
public class InformationChangeError extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JButton okButton;
	private JLabel lbl;
	private JFrame frame;

	public InformationChangeError() {
		super();
	}

	public void createGUI(int index) {

		frame = new JFrame();
		switch (index) {
		case 1:
			lbl = new JLabel("Invalid phone number", JLabel.CENTER);
			break;
		case 2:
			lbl = new JLabel("Invalid Email (Baylor email only)", JLabel.CENTER);
			break;
		case 3:
			lbl = new JLabel("Invaild Driver License", JLabel.CENTER);
			break;
		default:
			lbl = new JLabel("Information Wrong", JLabel.CENTER);
		}

		lbl.setBounds(10, 100, 150, 50);

		okButton = new JButton("OK");
		okButton.setBounds(50, 100, 80, 40);
		okButton.addActionListener(this);

		frame.add(okButton);
		frame.add(lbl);
		frame.setSize(200, 200);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == okButton) {
			frame.dispose();
		}
	}
}
