package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Stack;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import model.Database;
import model.GUIHelper;
import model.Item;
import model.Order;

public class MyCartController extends MainController implements Initializable {

	@FXML
	private Button backButton;
	@FXML
	private ListView listView;
	@FXML
	private Button checkOutButton;
	@FXML
	private Button removeButton;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		listView.setItems(GUIHelper.setCartData());
		GUIHelper.setCustomCells(listView, "");

		if (!Database.orderBag.getOrderMap().isEmpty()) {
			Order.setIdCounter(Database.orderBag.getOrderMap().size());
		} else {
			Order.setIdCounter(0);

		}
	}

	public void backButtonFire(ActionEvent event) {
		listView.getItems().clear();
		switchView("/view/mainView.fxml", event);
	}

	public void removeButtonFire(ActionEvent event) {
		Database.customerCart.getCartQueue().remove(listView.getSelectionModel().getSelectedItem());
		listView.getItems().clear();
		switchView("/view/myCartView.fxml", event);

	}

	public void checkOutButtonFire(ActionEvent event) {

		Stack stack = new Stack();
		Order order = new Order(Database.currentUser.getCurrent(), stack);
		Database.orderBag.getOrderMap().put(order.getID(), order);

		for (int i = 0; i < GUIHelper.getCartData().size(); i++) {
			Database.itemBag.deleteItem(GUIHelper.getCartData().get(i).getId());
			Database.customerCart.deleteItem(GUIHelper.getCartData().get(i));
			stack.push(GUIHelper.getCartData().get(i));

		}
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Receipt");
		alert.setContentText("Your Item will be ready for pickup in 1 hour." + "\n" + order.getItems());
		alert.showAndWait();

		Database.itemBag.save();
		Database.orderBag.save();
		listView.getItems().clear();
		switchView("/view/mainView.fxml", event);
	}

}
