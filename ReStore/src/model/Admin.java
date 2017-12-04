package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Admin extends User implements Serializable {

	private static Admin _Admin;
	
	
	
	public static Admin createAdmin() {
		if (_Admin == null) {
			_Admin = new Admin("admin", null, "admin", "1234");
			System.out.println("Admin created");
		} else {
			System.out.println("There can only be one admin");
		}
		return _Admin;
	}
	

	public Admin(String firstName, String lastName, String username, String password) {
		super(firstName, lastName, username, password);
	}

	public static Admin get_Admin() {
		return _Admin;
	}

	public static void set_Admin(Admin _Admin) {
		Admin._Admin = _Admin;
	}
	public void save() {
		FileOutputStream fileOutput = null;
		ObjectOutputStream objectOutput = null;

		try {
			fileOutput = new FileOutputStream("admin.dat");
			objectOutput = new ObjectOutputStream(fileOutput);
			objectOutput.writeObject(Admin.get_Admin());
			System.out.println("admin saved.");

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
			fileInput = new FileInputStream("admin.dat");
			File file = new File("admin.dat");
			objectInput = new ObjectInputStream(fileInput);

			if (file.exists()) {

				Admin.set_Admin((Admin) objectInput.readObject());
			} else {
				System.out.println("no admin data");
			}

			objectInput.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("no admin data");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}