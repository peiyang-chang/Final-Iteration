package MessageFile;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * <h1>LoginPlease</h1> The LoginPlease class in the MessageFile Package, it
 * will print "Please Login!" to a windows to tell the user that he or she to
 * log in, and the user can do adding to user's FavCar List, opening profile,
 * and making payment
 * <p>
 *
 * @author Yanjie Ning
 * @version 1.7
 * @since 2019-11-14
 */
public class LoginPlease extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton okButton;
	private JLabel lbl;
	private JFrame frame;

	public LoginPlease() {
		super();
	}

	public void createGUI() {

		frame = new JFrame();
		lbl = new JLabel("Please Login!", JLabel.CENTER);
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
