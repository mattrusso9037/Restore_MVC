package model;

import java.time.LocalDateTime;
import java.util.Comparator;

public class ItemDateComparator implements Comparator<Item> {

	@Override
	public int compare(Item o1, Item o2) {
		return LocalDateTime.parse(o1.getCreatedDate()).compareTo(LocalDateTime.parse(o2.getCreatedDate()));
	}

}
