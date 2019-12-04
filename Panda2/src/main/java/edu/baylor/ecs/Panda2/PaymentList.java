package edu.baylor.ecs.Panda2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

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
    public void readCSV(String fileName) throws FileNotFoundException{
    	Scanner scanner = new Scanner(new File(fileName));
    	while(scanner.hasNext()) {
    		String line = scanner.nextLine();
    		String[] spilt = line.split(",");
    		PaymentInfo car = new PaymentInfo(spilt[0],spilt[1],spilt[2],
    				spilt[3],spilt[4]);
    		list.add(car);
    	}
    	scanner.close();
    }
    public Object[][] conver2Data(){
    	Object[][] data = new Object[list.size()][5];
    	for(int i = 0; i < list.size(); i++) {
    		data[i][0] = list.get(i).getCarName();
    		data[i][1] = list.get(i).getCarPrice();
    		data[i][2] = list.get(i).getBuyerName();
    		data[i][3] = list.get(i).getBuyerPhone();
    		data[i][3] = list.get(i).getAppTime();
    	}
    	return data; 
    }
    public PaymentInfo CurrPerson(int index) {
    	return list.get(index);
    }
    public void WriteIntoFile(String fileName, String CarName, String CarPrice, String PersonName, String phoneNumber, String AppTime) throws IOException {
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
