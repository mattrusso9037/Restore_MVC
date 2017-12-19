package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Database {
	public static UserBag userBag = new UserBag();
	public static ItemBag itemBag = new ItemBag();
	public static ImageBag imageBag = new ImageBag();
	public static EmployeeBag employeeBag = new EmployeeBag();
	public static User currentUser = new User();

	private static LocalDateTime now = LocalDateTime.now();
	private static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MMM-dd-yyyy hh:mm a");
	private static String createdDate = now.format(dateFormatter);
	public static CustomerCart customerCart = new CustomerCart();
	public static OrderBag orderBag = new OrderBag();

	public static String getCreatedDate() {
		return createdDate;

	}

}
