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
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model.Item;

public class BrowseController extends AdminController implements Initializable {

	@FXML
	private ListView<Item> listView;
	@FXML
	private ImageView itemImage;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		System.out.println(data.isEmpty());
		System.out.println(itemBag.getItemStack().isEmpty());
		System.out.println("test");
		System.out.println(MainController.getTypeID());
		
		switch (MainController.getTypeID()) {
		case 0:
			listView.setItems(setData("wood"));
			break;
		case 1:
			listView.setItems(setData("furniture"));
			break;
		case 2:
			listView.setItems(setData("window"));
			break;
		case 3:
			listView.setItems(setData("door"));
			break;
		}

	
	}

	public void displayImage() {

		imageBag.load(listView.getSelectionModel().getSelectedItem().getImageFileName(), itemImage);
	}

	public void backButtonFire(ActionEvent event) {

		switchView("/view/mainView.fxml", event);
	}

}