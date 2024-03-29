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
import java.util.PriorityQueue;
import java.util.Queue;

public class OrderBag implements Serializable {
	private Map<Integer, Order> orderMap = new HashMap<>();

	public Map<Integer, Order> getOrderMap() {
		return orderMap;
	}

	public void save() {
		FileOutputStream fileOutput = null;
		ObjectOutputStream objectOutput = null;

		try {
			fileOutput = new FileOutputStream("orderBag.dat");
			objectOutput = new ObjectOutputStream(fileOutput);
			objectOutput.writeObject(getOrderMap());
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
			fileInput = new FileInputStream("orderBag.dat");
			File file = new File("orderBag.dat");
			objectInput = new ObjectInputStream(fileInput);

			if (file.exists()) {

				orderMap = (Map<Integer, Order>) objectInput.readObject();
				System.out.println("order bag loaded");

			} else {
				System.out.println("no orders");
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
