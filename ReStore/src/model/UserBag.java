package model;

import java.util.HashMap;
import java.util.Map;

public class UserBag {
	private Map<String, User> userMap = new HashMap<String, User>();
	private User user;
	User admin = new User(null, null, "admin", "");
	
	

	
	
	public void addUser(String username, User user) {
		userMap.put(user.getUsername(), user);
		
	}
	
	public Map getUserMap() {
		return userMap;
	}

	public User getAdmin() {
		return admin;
	}

	
}