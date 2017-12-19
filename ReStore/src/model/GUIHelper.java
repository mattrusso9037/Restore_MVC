package model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javafx.animation.PauseTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.util.Duration;

public class GUIHelper {

	public static void setPause(Label label) {
		PauseTransition visiblePause = new PauseTransition(Duration.seconds(3));
		visiblePause.setOnFinished(event2 -> label.setVisible(false));
		visiblePause.play();

	}

	public static void selectIDQuery(ListView listView, int query) {
		listView.getSelectionModel().select(query);
		listView.getFocusModel().focus(query);
		listView.scrollTo(query);
	}

	public static void selectKeywordQuery(ListView listView, String query) {
		listView.getSelectionModel().select(query);
		listView.scrollTo(query);
	}

	private static ObservableList data = FXCollections.observableArrayList();
	private static int size;

	public static ObservableList<Item> setSortedDateData(ListView<Item> listView) {
		ItemDateComparator c = new ItemDateComparator();
		Item[] a = new Item[size];

		getData().toArray(a);
		Arrays.sort(a, c);
		listView.getItems().clear();

		data.addAll(a);

		return data;
	}

	public static ObservableList<Item> setSortedRecentlyCreatedData(ListView<Item> listView) {
		ItemIDComparator c = new ItemIDComparator();
		Item[] a = new Item[size];

		getData().toArray(a);
		Arrays.sort(a, c);
		listView.getItems().clear();

		data.addAll(a);

		return data;
	}

	public static ObservableList<Item> setSortedNameData(ListView<Item> listView) {
		ItemNameComparator c = new ItemNameComparator();
		Item[] a = new Item[size];

		getData().toArray(a);
		Arrays.sort(a, c);
		listView.getItems().clear();

		data.addAll(a);

		return data;
	}

	public static ObservableList<Item> setSortedPriceData(ListView<Item> listView) {
		ItemPriceComparator c = new ItemPriceComparator();

		Item[] a = new Item[size];

		getData().toArray(a);
		Arrays.sort(a, c);
		listView.getItems().clear();

		data.addAll(a);

		return data;
	}

	public static void setEmployeeQueryData(String keyword, ListView listView) {

		Iterator it = Database.employeeBag.getEmployeeMap().entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();

			if (pair.getValue().toString().contains(keyword))
				System.out.println(pair.getValue().toString());
			listView.getSelectionModel().select(pair.getValue());
		}

	}

	public static ObservableList<Item> setQueryData(String keyword) {
		for (int j = 0; j < Database.itemBag.getItemMap().size(); j++) {

			if (Database.itemBag.getItemMap().get(j) == null) {
				j++;

			}
			if (Database.itemBag.getItemMap().get(j).getDescription().contains(keyword)
					|| Database.itemBag.getItemMap().get(j).getName().contains(keyword)) {
				data.addAll(Database.itemBag.getItemMap().get(j));

			}
		}

		return data;
	}

	public static ObservableList<Item> setData(String type) {

		Iterator it = Database.itemBag.getItemMap().entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();

			if (pair.getValue().toString().contains(type))

				data.add(pair.getValue());
		}
		return data;

	}

	public static ObservableList<Item> getCartData() {
		return data;

	}

	public static ObservableList setOrderData(ListView<Order> listView) {
		listView.getItems().clear();
		data.addAll(Database.orderBag.getOrderMap().values());
		return data;

	}

	public static ObservableList<Item> setCartData() {

		for (int j = 0; j < Database.currentUser.getCurrent().getCustomerCart().size(); j++) {

			data.addAll(Database.currentUser.getCurrent().getCustomerCart().get(j));

		}
		return data;

	}

	public static ObservableList<Item> setAllData(ListView<Item> listView) {
		listView.getItems().clear();
		data.addAll(Database.itemBag.getItemMap().values());
		return data;

	}

	public static ObservableList<Item> getData() {
		return data;
	}

	public static void saveDataSize(int dataSize) {
		size = dataSize;
	}

	public static Item getSelected(ListView<Item> listView) {
		return listView.getSelectionModel().getSelectedItem();

	}

	public static void setSelected(ListView<Item> listView, Item item) {
		listView.getSelectionModel().select(item.getId());
		listView.getFocusModel().focus(item.getId());
		listView.scrollTo(item.getId());
	}

	public static Item item;

	public static void setSelection(Item selected) {
		item = selected;
	}

	public static Item getSelection() {
		return item;
	}

	public static void setCustomCells(ListView<Item> listView, String value) {
		listView.setCellFactory(param -> new ListCell<Item>() {
			private ImageView imageView = new ImageView();

			public void updateItem(Item item, boolean empty) {
				super.updateItem(item, empty);
				if (empty) {
					setText(null);
					setGraphic(null);
				} else {

					Database.imageBag.load(item.getImageFileName(), imageView);
					imageView.setFitWidth(150);
					imageView.setFitHeight(100);
					setGraphic(imageView);
					setText(item.toString() + value);
					Font font = new Font("Tahoma", 16);
					setFont(font);
				}
			}
		});
	}

	public static void setCustomOrderCells(ListView<Order> listView, String value) {
		listView.setCellFactory(param -> new ListCell<Order>() {

			public void updateItem(Order order, boolean empty) {
				super.updateItem(order, empty);

				Font font = new Font("Tahoma", 16);
				setFont(font);
			}

		});
	}

}
