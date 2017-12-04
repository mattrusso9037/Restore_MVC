package controller;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import model.Item;

public class AdminController extends MainController implements Initializable {
	@FXML
	private ComboBox<String> typeComboBox;
	@FXML
	private TextField descriptionTextBox;
	@FXML
	private TextField priceTextBox;
	@FXML
	private Button addItemButton;
	@FXML
	private ListView<Item> listView;
	@FXML
	private ImageView itemImageView;
	@FXML
	private TextField imagePathTextField;
	@FXML
	private Button imageChooserButton;
	

	private Image image;
	private Item newItem;

	ObservableList data = FXCollections.observableArrayList();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		listView.setItems(setAllData());
		typeComboBox.getItems().addAll("wood", "furniture", "window", "door");
		typeComboBox.setVisibleRowCount(4);

	}

	public ObservableList<Item> setAllData() {

		for (int j = 0; j < itemBag.getItemStack().size(); j++) {
			data.addAll(itemBag.getItemStack().get(j));
		}
		return data;

	}

	public ObservableList<Item> setData(String type) {

		for (int j = 0; j < itemBag.getItemStack().size(); j++) {

			if (itemBag.getItemStack().get(j).getName().equals(type)) {
				data.addAll(itemBag.getItemStack().get(j));

			}

		}
		return data;

	}

	public void logOutFire(ActionEvent event) {
		System.out.println("log out");
	}

	public void addItemFire(ActionEvent event) {

		switchView("/view/addItemView.fxml", event);
	}

	public void displayImage() {

		imageBag.load(listView.getSelectionModel().getSelectedItem().getImageFileName(), itemImageView);
	}

	public void addItemListFire(ActionEvent event) {
		newItem = new Item(typeComboBox.getValue(), descriptionTextBox.getText(),
				Double.parseDouble(priceTextBox.getText()), imagePathTextField.getText());
		System.out.println("new item filename: " + newItem.getImageFileName());

		switch (typeComboBox.getValue()) {

		case "wood":

			System.out.println("wood");
			break;
		case "furniture":

			System.out.println("furniture");
			break;
		case "window":

			System.out.println("window");
			break;
		case "door":

			System.out.println("door");
			break;

		}
		System.out.println("image path: " + imagePathTextField.getText());
		System.out.println("image file name: " + newItem.getImageFileName());

		System.out.println("IMAGEBAG: " + imageBag.getImageMap().get(newItem.getImageFileName()));

		// delete
		imageBag.addImage(imagePathTextField.getText(), image);
		// save as filename
		// ->name file
		imageBag.save(imagePathTextField.getText());
		itemBag.addItem(newItem);
		itemBag.save();
		listView.setItems(setAllData());

		switchView("/view/addItemView.fxml", event);

	}

	public void imageChooserButtonFire(ActionEvent event) {
		FileChooser fileChooser = new FileChooser();
		File selectedFile = fileChooser.showOpenDialog(null);
		if (selectedFile != null) {
			imagePathTextField.setText(selectedFile.getPath());

			image = new Image("file:///" + selectedFile.getPath());

			System.out.println("file:///" + selectedFile.getPath());
			itemImageView.setImage(image);

		}
	}

	

	public void backFire(ActionEvent event) {

		switchView("/view/adminCenter.fxml", event);
	}

}