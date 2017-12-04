package model;

import controller.MainController;

public class Validation {

	public static boolean usernameIsValid(String username) {
		if (username.contains("@")) {
			return true;
		}
		return false;
	}

	public static boolean passwordIsValid(String password) {
		if (password.length() < 8) {
			return false;
		}
		return true;
	}

	public static boolean isValid(User user) {
		if (user.getFirstName().isEmpty() | user.getLastName().isEmpty() | user.getUsername().isEmpty()
				| user.getPassword().isEmpty()) {
			return false;
		}
		return true;
	}

	public static boolean userExists(String userName) {
		if (MainController.userBag.getUserMap().containsKey(userName)) {
			return true;
		}
		return false;
	}

	public static boolean passwordsMatch(String passwordEntered, String password) {
		if (passwordEntered.equals(password)) {
			return true;
		}
		return false;
	}
	public static boolean isAdmin(String username) {
		if (username.equals(Admin.get_Admin().getUsername())) {
			return true;
		}
		return false;
	}
}