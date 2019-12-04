package edu.baylor.ecs.Panda2;
 
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.table.AbstractTableModel;

import MessageFile.ContainMessage;
import MessageFile.addMessage;
 
public class CarFavList extends AbstractTableModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Car> carList;
	private Object[][] data;
	
	public CarFavList() {
		super();
		carList = new ArrayList<Car>();
	} 
    public void readCSV(String fileName) throws FileNotFoundException{
    	Scanner scanner = new Scanner(new File(fileName));
    	while(scanner.hasNext()) {
    		String line = scanner.nextLine();
    		String[] spilt = line.split(",");
    		Car car = new Car(spilt[0],spilt[1],spilt[2],
    				spilt[3],spilt[4]);
    		carList.add(car);
    	}
    	scanner.close();
    }
    public Car getData(int index) {
		return carList.get(index);
    }
    
	public int containValue(Car car) {
		int check = 0;
		System.out.println(car.getModel() + ": Car ");
		for(int i = 0; i < carList.size(); i++) {
			System.out.println(carList.get(i).getModel());
			if(carList.get(i).equals(car)) {
				check = 1;
			}
		}
		System.out.println("\n");
		return check;
	}
    
    public Object[][] conver2Data(){
    	data = new Object[carList.size()][5];
    	for(int i = 0; i < carList.size(); i++) {
    		data[i][0] = carList.get(i).getMake();
    		data[i][1] = carList.get(i).getModel();
    		data[i][2] = carList.get(i).getYear();
    		data[i][3] = carList.get(i).getColor();
    		data[i][4] = carList.get(i).getPrice();
    	}
    	return data;
    }
    public void add(Car car) {
    	if(containValue(car) == 0) {
    		addMessage msg = new addMessage();
    		msg.createGUI();
    		carList.add(getRowCount(), car);
    	}
    	else {
    		ContainMessage msg1 = new ContainMessage();
			msg1.createGUI();
    	}
    }

    public void delete(int index) {
    	carList.remove(index);
    }
    public void save(String fileName) throws IOException {
		 FileWriter fileWriter = new FileWriter(fileName);
	     PrintWriter printWriter = new PrintWriter(fileWriter);
	     data = conver2Data();
	     for (int i = 0; i < data.length; i++) {
	         for (int j = 0; j < getColumnCount(); j++) {
	        	 printWriter.print(data[i][j]);
	             if (j + 1 < getColumnCount()) {
	                 printWriter.print(",");
	             }
	         }
	         printWriter.print("\n");
	     }
	     printWriter.close();
    }
	public int getRowCount() {
		data = conver2Data();
		return data.length;
	}
	public int getColumnCount() {
		
		return 5;
	}
	public Object getValueAt(int rowIndex, int columnIndex) {
		data = conver2Data();
		return data[rowIndex][columnIndex];
	}
	
}
