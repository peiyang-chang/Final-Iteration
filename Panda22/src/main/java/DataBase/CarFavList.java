package DataBase;

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

/**
 * <h1>CarFavList</h1> The CarFavList class from DataBase Package implements to
 * create a list that contains amount of favorite Car Objects, and read car data
 * from the list in the class
 * <p>
 *
 * A CarFavList only contains the favorite car
 *
 * @author Peiyang Chang
 * @version 1.7
 * @since 2019-9-25
 */
public class CarFavList extends AbstractTableModel {
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

	/**
	 * This is class will read data from a csv file and store into the FavCar list
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
	 * This is the class return the specific position of a Car Object in the FavCar
	 * List
	 * 
	 * @param args index. An integer number.
	 * @return Car. A car object in the FavCar List.
	 */
	public Car getData(int index) {
		return carList.get(index);
	}

	/**
	 * This is the class is to check if the Car Object is in the FavCar List
	 * 
	 * @param args car. A Car Object
	 * @return 1 is the car is in the list, 0 is the car is not in the list
	 */
	public int containValue(Car car) {
		int check = 0;
		System.out.println(car.getModel() + ": Car ");
		for (int i = 0; i < carList.size(); i++) {
			System.out.println(carList.get(i).getModel());
			if (carList.get(i).equals(car)) {
				check = 1;
			}
		}
		System.out.println("\n");
		return check;
	}

	/**
	 * This is the class is to convert the car in the FavCar List into 2D data
	 * array.
	 * 
	 * @param Nothing
	 * @return Object [][] 2D array
	 */
	public Object[][] conver2Data() {
		data = new Object[carList.size()][5];
		for (int i = 0; i < carList.size(); i++) {
			data[i][0] = carList.get(i).getMake();
			data[i][1] = carList.get(i).getModel();
			data[i][2] = carList.get(i).getYear();
			data[i][3] = carList.get(i).getColor();
			data[i][4] = carList.get(i).getPrice();
		}
		return data;
	}

	/**
	 * This is the class is to add a Car Object into the FavCarList, if the car is
	 * already in the FavCarList, it prints "contains" message.
	 * 
	 * @param args car. A Car Object
	 * @return Nothing
	 */
	public void add(Car car) {
		if (containValue(car) == 0) {
			addMessage msg = new addMessage();
			msg.createGUI();
			carList.add(getRowCount(), car);
		} else {
			ContainMessage msg1 = new ContainMessage();
			msg1.createGUI();
		}
	}

	/**
	 * This is the class is to delete a Car Object from the FavCarList
	 * 
	 * @param args index, a position
	 * @return Nothing
	 */
	public void delete(int index) {
		carList.remove(index);
	}

	/**
	 * This is the class is to save the current Car Objects in the FavCarList into a
	 * csv file
	 * 
	 * @param args fileName. a csv file name
	 * @return Nothing
	 * @exception FileNotFoundException On input error.
	 * @see FileNotFoundException
	 */
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
