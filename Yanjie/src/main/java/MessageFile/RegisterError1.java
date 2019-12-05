package MessageFile;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;



/**
 * <h1>RegisterError1</h1> The RegisterError1 class in the MessageFile Package,
 * it will print "Check the Password", to a windows to tell the user that he or
 * she that the password and confirmed password are not the same
 * <p>
 *
 * @author Yanjie Ning
 * @version 1.7
 * @since 2019-11-14
 */
public class RegisterError1 extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton okButton;
	private JLabel lbl;
	private JFrame frame;
	

	public RegisterError1(){
		
		frame= new JFrame();	
		lbl = new JLabel("Check the Password", JLabel.CENTER);
		lbl.setBounds(10, 100, 150,50);
		
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
		if(e.getSource() == okButton) {
			frame.dispose();
		}
	}
	
	
}
