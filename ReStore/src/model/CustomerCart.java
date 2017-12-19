package model;

import java.util.PriorityQueue;
import java.util.Queue;

public class CustomerCart { 
	private Queue<Item> cartQueue = new PriorityQueue<>();
	
	private int id;
	//= Database.currentUser.getCurrent().getId();

	public CustomerCart(int id) {
		this.id = id;
	}
	
	public CustomerCart() {
		
	}

	public Queue<Item> getCartQueue() {
		return cartQueue; 
	}


	public void setCartQueue(Queue<Item> cartQueue) {
		this.cartQueue = cartQueue;
	}


	public void addItem(Item item) {
	cartQueue.add(item);
	
		}
	
	public void deleteItem(Item item) {
		cartQueue.remove(item);
	}
}
