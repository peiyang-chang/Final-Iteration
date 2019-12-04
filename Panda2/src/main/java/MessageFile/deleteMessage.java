package MessageFile;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class deleteMessage extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	private JButton deleteButton;
	private JLabel lbl;
	private JFrame frame;
	
	public deleteMessage() {
		super();
	}

	public void createGUI(){
		
		frame= new JFrame();	
		lbl = new JLabel("Delete sucessfully!", JLabel.CENTER);
		lbl.setBounds(10, 100, 150,50);
		
		deleteButton = new JButton("OK");
		deleteButton.setBounds(100, 130, 80, 40);
		deleteButton.addActionListener(this);
		
		frame.add(deleteButton);
		frame.add(lbl);
		frame.setSize(300, 200);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}
		
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == deleteButton) {
			frame.dispose();
		}
	}
}
