package MessageFile;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * <h1>addMessage</h1> The addMessage class in the MessageFile Package, it will
 * print "Add to FavCarList successfully!" to a windows to tell the user that he
 * or she add the car to FavCar List successfully.
 * <p>
 *
 * @author Peiyang Chang
 * @version 1.7
 * @since 2019-11-14
 */
public class addMessage extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JButton okButton;
	private JLabel lbl;
	private JFrame frame;

	public addMessage() {
		super();
	}

	/**
	 * Create the CaddMessage frame.
	 */
	public void createGUI() {
		frame = new JFrame();

		lbl = new JLabel("Add to FavCarList sucessfully!", JLabel.CENTER);
		lbl.setBounds(80, 100, 150, 50);

		okButton = new JButton("Yes");
		okButton.setBounds(100, 130, 80, 40);
		okButton.addActionListener(this);

		frame.add(okButton);
		frame.add(lbl);
		frame.setSize(300, 200);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}

	/**
	 * This class will do the action of each action listener. backButton will back
	 * to home page.
	 * <p>
	 * 
	 * @param args ActionEvent
	 * @return Nothing.
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == okButton) {
			frame.dispose();
		}
	}

}
