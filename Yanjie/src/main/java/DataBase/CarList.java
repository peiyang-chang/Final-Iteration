package DataBase;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.table.AbstractTableModel;

/**
 * <h1>CarList</h1> The CarList class from DataBase Package implements to create
 * a list that contains amount of Car Objects, and read car data from the list
 * in the class
 * <p>
 *
 * A CarList contains an amount of car in a list
 *
 * @author Peiyang Chang
 * @version 1.7
 * @since 2019-9-25
 */
public class CarList extends AbstractTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Car> carList;

	public CarList() {
		carList = new ArrayList<Car>();
	}

	public void add(Car a) {
		carList.add(a);
	}

	/**
	 * This is the class return the specific position of a Car Object in the Car
	 * List
	 * 
	 * @param args index. An integer number.
	 * @return Car. A car object in the Car List.
	 */
	public Car getData(int index) {
		return carList.get(index);
	}

	/**
	 * This is class will read data from a csv file and store into the Car list
	 * 
	 * @param args fileName
	 * @return Nothing.
	 * @exception FileNotFoundException On input error.
	 * @see FileNotFoundException
	 */
	public void readCSV(String fileName) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File(fileName));
		while (scanner.hasNext()) {
			String line = scanner.nextLine();
			String[] spilt = line.split(",");
			Car car = new Car(spilt[0], spilt[1], spilt[2], spilt[3], spilt[4]);
			carList.add(car);
		}
		scanner.close();
	}

	/**
	 * This is the class is to convert the car in the Car List into 2D data array.
	 * 
	 * @param Nothing
	 * @return Object [][] 2D array
	 */
	public Object[][] conver2Data() {
		Object[][] data = new Object[carList.size()][5];
		for (int i = 0; i < carList.size(); i++) {
			data[i][0] = carList.get(i).getMake();
			data[i][1] = carList.get(i).getModel();
			data[i][2] = carList.get(i).getYear();
			data[i][3] = carList.get(i).getColor();
			data[i][4] = carList.get(i).getPrice();
		}
		return data;
	}

	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

}
