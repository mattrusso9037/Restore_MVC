package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UserBag implements Serializable {

	private Map<String, User> userMap = new HashMap<String, User>();
	
	private User admin;
	

	public void save() {
		FileOutputStream fileOutput = null;
		ObjectOutputStream objectOutput = null;

		try {
			fileOutput = new FileOutputStream("userBag.dat");
			objectOutput = new ObjectOutputStream(fileOutput);
			objectOutput.writeObject(getUserMap());
			System.out.println("userbag saved.");

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
			fileInput = new FileInputStream("userBag.dat");
			File file = new File("userBag.dat");
			objectInput = new ObjectInputStream(fileInput);

			if (file.exists()) {

				userMap = (Map<String, User>) objectInput.readObject();
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

	public void addUser(String username, User user) {
		userMap.put(user.getUsername(), user);

	}

	

	public Map getUserMap() {
		return userMap;
	}

	public void setAdminPassword(String password) {

		userMap.get("admin").setPassword(password);
		save();
	}

	public User getAdmin() {
		admin = userMap.get("admin");
		return admin;
	}

}
