package MessageFile;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class NotSelectedMessage extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	private JButton okButton;
	private JLabel lbl;
	private JFrame frame;
	
	public NotSelectedMessage() {
		super();
	}
	
	public void createGUI(){
			frame= new JFrame();
			
			lbl = new JLabel("No selected car!", JLabel.CENTER);
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
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == okButton) {
			frame.dispose();
		}
	}
}
