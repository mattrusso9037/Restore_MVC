package model;

import javafx.scene.image.ImageView;

public class Item {
	private ImageView itemImage;
	private String name;
	private String description;
	private double price;
	private String dimensions;

	public Item(String name, String description, double price, String dimensions, ImageView itemImage) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.dimensions = dimensions;
		this.itemImage = itemImage;
	}

	public Item() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getDimensions() {
		return dimensions;
	}

	public void setDimensions(String dimensions) {
		this.dimensions = dimensions;
	}

}