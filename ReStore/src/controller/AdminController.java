package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Item;
import model.ItemBag;

public class AdminController extends MainController implements Initializable {
	@FXML
	private TextField nameTextBox;
	@FXML
	private TextField descriptionTextBox;
	@FXML
	private TextField priceTextBox;
	ObservableList data = FXCollections.observableArrayList();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	@FXML
	private Button addItemButton;
	public void logOutFire(ActionEvent event) {
		System.out.println("log out");
	}
	public void addItemFire(ActionEvent event) {

		Node node = (Node) event.getSource();
		Stage stage = (Stage) node.getScene().getWindow();
		Parent root = null;

		try {
			root = FXMLLoader.load(getClass().getResource("/view/addItemView.fxml"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Scene scene = new Scene(root);
		stage.setScene(scene);
	}
	
	
	public void addItemListFire(ActionEvent event) {
		

		Item newItem = new Item( nameTextBox.getText(), descriptionTextBox.getText(), 
				Double.parseDouble(priceTextBox.getText()));
		
		
		itemBag.addItem(newItem);
		itemBag.save();
		data.add(newItem.getName());
		
		System.out.println(itemBag.getItemList().get(0));
		
		
		Node node = (Node) event.getSource();
		Stage stage = (Stage) node.getScene().getWindow();
		Parent root = null;

		try {
			root = FXMLLoader.load(getClass().getResource("/view/mainView.fxml"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Scene scene = new Scene(root);
		stage.setScene(scene);
	}
	
	
	

}
