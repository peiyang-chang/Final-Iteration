package MessageFile;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * <h1>Saved</h1> The Saved class in the MessageFile Package, it will print
 * "Saved!" to a windows to tell the user that his or her changes in profile are
 * saved.
 * <p>
 *
 * @author Peiyang Chang
 * @version 1.7
 * @since 2019-11-14
 */
public class Saved extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JButton okButton;
	private JLabel lbl;
	private JFrame frame;

	public Saved() {
		super();
	}

	public void createGUI() {
		frame = new JFrame();

		lbl = new JLabel("Saved!", JLabel.CENTER);
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

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == okButton) {
			frame.dispose();
		}
	}

}
