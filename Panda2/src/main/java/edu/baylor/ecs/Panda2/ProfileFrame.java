package edu.baylor.ecs.Panda2;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import MessageFile.NotSelectedMessage;
import MessageFile.deleteMessage;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

public class ProfileFrame extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTable table;
    private JButton okButton;
	private JTextField textField_3;
	private JButton uploadButton;
	private JFrame frame = new JFrame("Personal Infomation");
	private JButton payButton;
	private CarFavList FavList = new CarFavList();
	private Object[][] listData;
	private String[] columnNames = {"Make", "Model", "Year",
			"Color", "Price"};
	private DefaultTableModel tableModel;
	private JMenuBar menuBar;
	private JMenuItem menuItem1;
	private JButton deleteButton;
	private JLabel lblNewLabel;
	private String picPath = "";
	private String filePath = "";
	private PersonList person = new PersonList();
	private BufferedImage image;
	private File picFile;
	private int index = -1;
	private String user = "";
	private JTextField textField1;
	private HomePage home;
	
	public ProfileFrame() {
		super();
	}
    /**
     * Create the frame.
     * @param loginUsername 
     * @throws FileNotFoundException 
     */
    
    public void createGUI(String loginUsername) throws FileNotFoundException {
    	user = loginUsername;
    	person.readCSV("PersonList.csv");
    	index = person.getCurr(loginUsername);
        contentPane = new JPanel(); 
        contentPane.setLayout(null);
        
        lblNewLabel = new JLabel();
        lblNewLabel.setBounds(10, 10, 116, 133);
        if(!person.getPerson(index).getPicPath().equals("null")) {
        	picPath = person.getPerson(index).getPicPath();
        	lblNewLabel.setIcon(ResizeImage(picPath));
    		lblNewLabel.setVisible(true);
        }
        
        contentPane.add(lblNewLabel);
        
        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(null, "Infomation: ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel.setBounds(10, 150, 750, 370);
        contentPane.add(panel);
        panel.setLayout(null);
        

        JLabel label = new JLabel("FName");
        label.setBounds(20, 34, 55, 18);
        panel.add(label);
        
        JLabel label1 = new JLabel("LName");
        label1.setBounds(175,34,55,18);
        panel.add(label1);

        JLabel label_1 = new JLabel("Phone");
        label_1.setBounds(20, 75, 57, 18);
        panel.add(label_1);

        JLabel label_2 = new JLabel("Email");
        label_2.setBounds(20, 116, 57, 18);
        panel.add(label_2);
        
        JLabel label_3 = new JLabel("Licenses");
        label_3.setBounds(20, 157, 55, 18);
        panel.add(label_3);
        
        JLabel lblNewLabel_1 = new JLabel("Favorite Car");
        lblNewLabel_1.setBounds(20, 198, 85, 18);
        panel.add(lblNewLabel_1);
        
        textField = new JTextField();
        textField.setText(person.getPerson(index).getFristName());
        textField.setBounds(82, 34, 88, 28);
        panel.add(textField);
        textField.setColumns(10);
        
        textField1 = new JTextField();
        textField1.setText(person.getPerson(index).getLastName());
        textField1.setBounds(229, 34, 88, 28);
        panel.add(textField1);
        
        textField_1 = new JTextField();
        textField_1.setText(person.getPerson(index).getPhone());
        textField_1.setBounds(82, 75, 148, 28);
        panel.add(textField_1);
        textField_1.setColumns(10);

        textField_2 = new JTextField();
        textField_2.setText(person.getPerson(index).getEmail());
        textField_2.setBounds(82, 116, 148, 23);
        panel.add(textField_2);
        textField_2.setColumns(10);
        
        textField_3 = new JTextField();
        textField_3.setText(person.getPerson(index).getLicense());
        textField_3.setBounds(82, 157, 148, 23);
        panel.add(textField_3);
        textField_3.setColumns(10);
        
        FavList = new CarFavList();
        filePath = person.getPerson(index).getUsername() + ".csv";
        try {
        	FavList.readCSV(filePath);
        }
        catch (FileNotFoundException e){
        	FileWriter fileWriter;
			try {
				fileWriter = new FileWriter(filePath, true);
				BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		        bufferedWriter.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
	        
        }
        listData = FavList.conver2Data();
        tableModel = new DefaultTableModel(listData,columnNames);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(120, 210, 595, 108);
        
        panel.add(scrollPane);
        
        okButton = new JButton("OK");
        okButton.setBounds(650, 525, 80, 40);
        contentPane.add(okButton);
        okButton.addActionListener(this);
        
        deleteButton = new JButton("Delete");
        deleteButton.setBounds(350, 525, 80, 40);
        contentPane.add(deleteButton);
        deleteButton.addActionListener(this);
        
        uploadButton = new JButton("Upload");
        uploadButton.setBounds(135, 100, 80, 40);
        contentPane.add(uploadButton);
        contentPane.setVisible(true);
        uploadButton.addActionListener(this);
        
        payButton = new JButton("Pay");
        payButton.setBounds(50, 525, 80, 40);
        contentPane.add(payButton);
        payButton.addActionListener(this);
        
        menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        menuBar.add(menu);

        menuItem1 = new JMenuItem("Save");
        menuItem1.addActionListener(this);
        menu.add(menuItem1);
        
        frame.setJMenuBar(menuBar);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(800, 650);
        frame.setLocationRelativeTo(null);
        frame.add(panel);
        frame.add(contentPane); 
        
    }
   
	protected Icon ResizeImage(String picPath2) {
		ImageIcon image = new ImageIcon(picPath2);
		Image img = image.getImage();
		Image newImg = img.getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon im = new ImageIcon(newImg);
		return im;
	}

	public void actionPerformed(ActionEvent e) {
    	if(e.getSource() == okButton) {
    		frame.dispose();
    		HomePage homePage = new HomePage();
    		homePage.setLoginStatus(true);
    		homePage.setLoginUsername(user);
    		homePage.CreateFrame();
    	}
    	else if (e.getSource() == uploadButton) {
    		JFileChooser file = new JFileChooser();
    		file.setCurrentDirectory(new File(System.getProperty("user.home")));
    		FileNameExtensionFilter filter = new FileNameExtensionFilter("Images", "jpg", "png", "gif");
    		file.addChoosableFileFilter(filter);
    		int result = file.showOpenDialog(null);
    		if(result == JFileChooser.APPROVE_OPTION) {
    			File selectedFile = file.getSelectedFile();
    			picPath = selectedFile.getAbsolutePath();
    			File imagefile = new File(picPath);
    			try {
					image = ImageIO.read(imagefile);
					if(picPath.endsWith(".jpg")) {
						picFile = new File(person.getPerson(index).getUsername() + ".jpg");
						ImageIO.write(image, "jpg",picFile);
					}
					else if(picPath.endsWith(".png")) {
						picFile = new File(person.getPerson(index).getUsername() + ".png");
						ImageIO.write(image, "png",picFile);
					}
					else if(picPath.endsWith(".gif")) {
						picFile = new File(person.getPerson(index).getUsername() + ".gif");
						ImageIO.write(image, "gif",picFile);
					}
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
    			
    			lblNewLabel.setIcon(ResizeImage(picPath));
	    		lblNewLabel.setVisible(true);
	    		person.getPerson(index).setPicPath(picFile.getName());
    		}
    		else if(result == JFileChooser.CANCEL_OPTION) {
    			System.out.println("No File Select.");
    		}  		
    	}
    	else if (e.getSource() == payButton) {
        	if(table.getSelectionModel().isSelectionEmpty() == true) {
        		NotSelectedMessage msg1 = new NotSelectedMessage();
        		msg1.createGUI();
        	}
        	else {
	    		frame.dispose();
	    		int selectedRow = table.getSelectedRow();
	    		Car car = FavList.getData(selectedRow);
	    		MakePayment payInfo = new MakePayment();
	    		payInfo.addCar(car);
	    		payInfo.createGUI(index);
        	}
    	}
    	else if(e.getSource() == deleteButton) {
        	if(table.getSelectionModel().isSelectionEmpty() == true) {
        		NotSelectedMessage msg1 = new NotSelectedMessage();
        		msg1.createGUI();
        	}
        	else {
	    		deleteMessage msg = new deleteMessage();
	    		msg.createGUI();
	    		int selectedRow = table.getSelectedRow();
	    		tableModel.removeRow(selectedRow);
	    		FavList.delete(selectedRow);
	    		try {
					FavList.save(filePath);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
        	}
    	}
    	else if(e.getSource() == menuItem1) {
    		try {
    			person.getPerson(index).setFristName(textField.getText());
    			person.getPerson(index).setLastName(textField1.getText());
    			person.getPerson(index).setPhone(textField_1.getText());
    			person.getPerson(index).setEmail(textField_2.getText());
    			person.getPerson(index).setLicense(textField_3.getText());
				person.save(index);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    	}
    } 

}
