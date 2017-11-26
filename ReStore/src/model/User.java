package model;

import java.io.Serializable;

public class User implements Serializable {
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	

	public User(String firstName, String lastName, String username, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
	}

	public User() {

	}
	

	public boolean usernameIsValid() {
		if (username.contains("@")) {
			return true;
		}
		return false;
	}

	public boolean passwordIsValid() {
		if (password.length() < 8) {
			return false;
		}
		return true;
	}

	public boolean isValid() {
		if (firstName.isEmpty() | lastName.isEmpty() | username.isEmpty() | password.isEmpty()) {
			return false;
		}
		return true;
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
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", username=" + username + "password: "
				+ password + "]";
	}

}
