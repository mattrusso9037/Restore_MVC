package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class EmployeeBag implements Serializable {
	
	private Map<String, Employee> employeeMap = new HashMap<String, Employee>();

	
	public Map getEmployeeMap() {
		return employeeMap;
	}
	public void addEmployee(String username, Employee employee) {
		
		employeeMap.put(username, employee);
	}
	
	public void save() { 
		FileOutputStream fileOutput = null;
		ObjectOutputStream objectOutput = null;

		try {
			fileOutput = new FileOutputStream("employeeBag.dat");
			objectOutput = new ObjectOutputStream(fileOutput);
			objectOutput.writeObject(employeeMap);
			System.out.println("bag saved.");

			objectOutput.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void load() {
		FileInputStream fileInput = null;
		ObjectInputStream objectInput = null;

		try {
			fileInput = new FileInputStream("employeeBag.dat");
			File file = new File("employeeBag.dat");
			objectInput = new ObjectInputStream(fileInput);

			if (file.exists()) {

				employeeMap = (HashMap) objectInput.readObject();
			} else {
				System.out.println("nothing to load");
			}

			objectInput.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("nothing to load");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
