package MessageFile;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class RegisterError2 extends JFrame implements ActionListener{

	private JButton okButton;
	private JLabel lbl;
	private JFrame frame;
	

	public RegisterError2(int a){
		
		frame= new JFrame();
		switch(a) {
			case 1: lbl = new JLabel("Last Name Missing!", JLabel.CENTER);
					break;
			case 2: lbl = new JLabel("First Name Missing!", JLabel.CENTER);
					break;
			case 3: lbl = new JLabel("Invaild Email! (Baylor email only)", JLabel.CENTER);
					break;
			case 4: lbl = new JLabel("Invaild Phone Number", JLabel.CENTER);
					break;
			case 5: lbl = new JLabel("Password Missing!", JLabel.CENTER);
					break;
			case 6: lbl = new JLabel("Used User Name!", JLabel.CENTER);
					break;
		}
		
		
		//lbl.setBounds(10, 100, 150,50);
		
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
		if(e.getSource() == okButton) {
			frame.dispose();
		}
	}
	
	
}
