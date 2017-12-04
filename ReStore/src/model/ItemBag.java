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
import java.util.Stack;

import javafx.scene.image.Image;

public class ItemBag implements Serializable {
	
	private Stack<Item> itemStack = new Stack<Item>();
	
//	private ArrayList<Item> itemList = new ArrayList<Item>();

	public Stack<Item> getItemStack() {
		return itemStack;
	}



	public void addItem(Item item) {
		itemStack.add(item);
		

	}
	public void save() {
		FileOutputStream fileOutput = null;
		ObjectOutputStream objectOutput = null;

		try {
			fileOutput = new FileOutputStream("itemBag.dat");
			objectOutput = new ObjectOutputStream(fileOutput);
			objectOutput.writeObject(getItemStack());
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

				itemStack = (Stack<Item>) objectInput.readObject();
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