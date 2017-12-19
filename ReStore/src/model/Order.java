package model;

import java.io.Serializable;
import java.util.Stack;

public class Order implements Serializable{

	private Stack items;
	private User user;
	private static int idCounter;
	private int id;
	
	public Order(User user, Stack items) {
	
		this.items = items;
		this.user = user;
		this.id = idCounter++;
	}

	public Order() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		
		return "Order " + "ID:  " + id + "\nCustomer:" + "\n" + user + "\n" + "Item(s):" + items.toString();
	}

	public Stack getItems() {
		return items;
	}

	public void setItems(Stack items) {
		this.items = items;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getID() {
		return id;
	}
	public static void setIdCounter(int idCounter) {
		Order.idCounter = idCounter;
	}
	
}
