package DataBase;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * <h1>PaymentList</h1> The PaymentList class from DataBase Package implements
 * to create a list that contains amount of PaymentInfo Objects, and read
 * PaymentInfo data from the list in the class
 * <p>
 *
 * A PaymentList contains an amount of PaymentInfo in a list
 *
 * @author Peiyang Chang
 * @version 1.7
 * @since 2019-9-25
 */
public class PaymentList {
	private ArrayList<PaymentInfo> list = new ArrayList<PaymentInfo>();

	public ArrayList<PaymentInfo> getList() {
		return list;
	}

	public void setList(ArrayList<PaymentInfo> list) {
		this.list = list;
	}

	public void add(PaymentInfo info) {
		list.add(info);
	}

	public PaymentInfo getData() {
		return list.get(getIndex());
	}

	public int getIndex() {
		return list.size() - 1;
	}

	public void readCSV(String fileName) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File(fileName));
		while (scanner.hasNext()) {
			String line = scanner.nextLine();
			String[] spilt = line.split(",");
			PaymentInfo car = new PaymentInfo(spilt[0], spilt[1], spilt[2], spilt[3], spilt[4]);
			list.add(car);
		}
		scanner.close();
	}

	public Object[][] conver2Data() {
		Object[][] data = new Object[list.size()][5];
		for (int i = 0; i < list.size(); i++) {
			data[i][0] = list.get(i).getCarName();
			data[i][1] = list.get(i).getCarPrice();
			data[i][2] = list.get(i).getBuyerName();
			data[i][3] = list.get(i).getBuyerPhone();
			data[i][3] = list.get(i).getAppTime();
		}
		return data;
	}

	/**
	 * This is the class return the specific position of a PaymentInfo Object in the
	 * PaymentInfo List
	 * 
	 * @param args index. An integer number.
	 * @return PaymentInfo. A PaymentInfo object with position in the PaymentInfo
	 *         List.
	 */
	public PaymentInfo CurrPerson(int index) {
		return list.get(index);
	}

	/**
	 * This is the class is to save the current Car Objects in the FavCarList into a
	 * csv file
	 * 
	 * @param args fileName. a csv file name
	 * @param args CarName. A Car Name
	 * @param args CarPrice. A Car Price
	 * @param args PersonName. A Person Name
	 * @param args phoneNumber. A phone Number
	 * @param args AppTime. A appointment Time
	 * @return Nothing
	 * @exception FileNotFoundException On input error.
	 * @see FileNotFoundException
	 */
	public void WriteIntoFile(String fileName, String CarName, String CarPrice, String PersonName, String phoneNumber,
			String AppTime) throws IOException {
		FileWriter fileWriter = new FileWriter(fileName, true);
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

		bufferedWriter.write(CarName);
		bufferedWriter.write(',');
		bufferedWriter.write(CarPrice);
		bufferedWriter.write(',');
		bufferedWriter.write(PersonName);
		bufferedWriter.write(',');
		bufferedWriter.write(phoneNumber);
		bufferedWriter.write(',');
		bufferedWriter.write(AppTime);
		bufferedWriter.newLine();

		bufferedWriter.close();
	}
}
