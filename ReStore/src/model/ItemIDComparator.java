package model;

import java.util.Comparator;

public class ItemIDComparator implements Comparator<Item> {

	@Override
	public int compare(Item o1, Item o2) {
		return o2.getId() - o1.getId();
	}

}
