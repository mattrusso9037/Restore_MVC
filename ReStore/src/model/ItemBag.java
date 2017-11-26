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
import java.util.Map;

public class ItemBag implements Serializable {
	
	
	private ArrayList<Item> itemList = new ArrayList<Item>();

	public ArrayList<Item> getItemList() {
		return itemList;
	}





	public void addItem(Item item) {

		itemList.add(item);

	}
	public void save() {
		FileOutputStream fileOutput = null;
		ObjectOutputStream objectOutput = null;

		try {
			fileOutput = new FileOutputStream("itemBag.dat");
			objectOutput = new ObjectOutputStream(fileOutput);
			objectOutput.writeObject(getItemList());
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
			fileInput = new FileInputStream("itemBag.dat");
			File file = new File("itemBag.dat");
			objectInput = new ObjectInputStream(fileInput);

			if (file.exists()) {

				//for (int i = 0; i < file.length(); i++) {
//					User user = (User) objectInput.readObject();
//					userMap.put(user.getUsername(), user);
//					System.out.println(user.getFirstName());
			//	}
				itemList = (ArrayList<Item>) objectInput.readObject();
			} else {
			System.out.println("nothing to load");
			}

			objectInput.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("no item data");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
