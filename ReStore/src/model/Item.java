package model;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Item implements Serializable {
	private String imageFileName;
	private String type;
	private String name;
	private String description;
	private double price;
	private static int idCounter;
	private int id;
	private String createdDate = Database.getCreatedDate();
	
 

	NumberFormat formatter = new DecimalFormat("#0.00");
	
	public Item(String type, String name, String description, double price, String imageFileName, String createdDate) {
		super();
		this.type = type;
		this.name = name;
		this.description = description;
		this.price = price;
		this.setImageFileName(imageFileName);
		this.createdDate = createdDate;
		this.id = idCounter++;
	}
	
	public String getCreatedDate() {
		return createdDate;
	}
	
	
	
	public String getName() {

		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getId() {
		return id;
	}


	public static void setIdCounter(int idCounter) {
		Item.idCounter = idCounter;
	}


	@Override
	public String toString() {
		
		return type + "\n" + name + "\n" + description
				+ "\n" + "$" + formatter.format(price) + "\n" + id;
	}


	public Item() {

	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	


	public String getImageFileName() {
		return imageFileName;
	}


	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}








}
