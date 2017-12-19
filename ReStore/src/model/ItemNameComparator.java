package model;

import java.util.Comparator;

public class ItemNameComparator implements Comparator<Item> {

	@Override
	public int compare(Item o1, Item o2) {
		return String.valueOf(o1.getName().charAt(0)).toLowerCase().compareTo(String.valueOf(o2.getName().charAt(0)).toLowerCase());
	}

}
