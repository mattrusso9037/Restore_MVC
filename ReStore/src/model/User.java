package model;

import java.io.Serializable;
import java.util.Queue;
import java.util.Stack;

public class User implements Serializable {
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private int id;
	private static int idInt;
	private User current;
	Stack<Item> customerCart = new Stack<>();

	public User getCurrent() {
		return current;
	}

	public void setCurrent(User current) {
		this.current = current;

	}

	public User(String firstName, String lastName, String username, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.id = idInt++;
		this.customerCart = new Stack<Item>();
	}

	public Stack<Item> getCustomerCart() {
		return customerCart;
	}

	public User() {

	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "First Name: " + firstName + " \nLast Name: " + lastName + " \nUsername: " + username;
	}

	public int getId() {
		return id;
	}

}
