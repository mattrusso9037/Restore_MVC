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
import java.util.Stack;

public class ItemBag implements Serializable {

	private Map<Integer, Item> itemMap = new HashMap<>();

	public Map<Integer, Item> getItemMap() {
		return itemMap;
	}

	public void deleteItem(int key) {
		itemMap.remove(key);
	}

	public void addItem2(int key, Item item) {
		itemMap.put(key, item);
	}

	public void save() {
		FileOutputStream fileOutput = null;
		ObjectOutputStream objectOutput = null;

		try {
			fileOutput = new FileOutputStream("itemBag.dat");
			objectOutput = new ObjectOutputStream(fileOutput);
			objectOutput.writeObject(getItemMap());
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

				itemMap = (Map<Integer, Item>) objectInput.readObject();
				System.out.println("items loaded");
			} else {
				System.out.println("nothing to load");
			}

			objectInput.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
