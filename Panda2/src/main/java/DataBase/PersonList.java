package DataBase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.table.AbstractTableModel;

public class PersonList extends AbstractTableModel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Person> list = new ArrayList<Person>();
	private Object[][] data;

	public ArrayList<Person> getList() {
		return list;
	}
	public void setList(ArrayList<Person> list) {
		this.list = list;
	}
	
    public void readCSV(String fileName) throws FileNotFoundException{
    	Scanner scanner = new Scanner(new File(fileName));
    	while(scanner.hasNext()) {
    		String line = scanner.nextLine();
    		String[] spilt = line.split(",");
    		Person person = new Person(spilt[0],spilt[1],spilt[2],
    				spilt[3],spilt[4],spilt[6],spilt[7],spilt[8]);
    		list.add(person);
    	}
    	scanner.close();
    }
    
    public Object[][] conver2Data(){
    	Object[][] data = new Object[list.size()][9];
    	
    	for(int i = 0; i < list.size(); i++) {
    		data[i][0] = list.get(i).getLastName();
    		data[i][1] = list.get(i).getFristName();
    		data[i][2] = list.get(i).getEmail();
    		data[i][3] = list.get(i).getPhone();
    		data[i][4] = list.get(i).getPassword();
    		data[i][5] = list.get(i).getPassword();
    		data[i][6] = list.get(i).getUsername();
    		data[i][7] = list.get(i).getLicense();
    		data[i][8] = list.get(i).getPicPath();
    		
    	}
    	return data;
    }
    public void save(int index) throws IOException {
		 FileWriter fileWriter = new FileWriter("PersonList.csv");
	     PrintWriter printWriter = new PrintWriter(fileWriter);
	     data = conver2Data();
         for (int j = 0; j < getColumnCount(); j++) {
        	 printWriter.print(data[index][j]);
             if (j + 1 < getColumnCount()) {
                 printWriter.print(",");
             }
         }
         printWriter.print("\n");
	     printWriter.close();
    }
	public Person getPerson(int index) {
		return list.get(index);
	}
	
	public int getCurr(String userName) {
		int index = -1;
		for(int i = 0; i < list.size();i++) {
			if(list.get(i).getUsername().equals(userName)) {
				index = i;
			}	
		}
		
		return index;
	}
	
	public void store(Person person) {
		list.add(person);
	}
	public int getRowCount() {
		return list.size();
	}
	public int getColumnCount() {
		return 9;
	}
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	} 
}

