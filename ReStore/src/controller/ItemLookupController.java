package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import model.Database;
import model.GUIHelper;
import model.Item;
import model.Validation;

public class ItemLookupController extends MainController implements Initializable {

	@FXML
	private TextField itemField;
	@FXML
	private Button lookupButton;
	@FXML
	private Button deleteButton;
	@FXML
	private Button backButton;
	@FXML
	private ImageView itemImage;
	@FXML
	private VBox itemBox;
	@FXML
	private Label itemLabel;
	@FXML
	private Label notFoundLabel;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		System.out.println(Database.itemBag.getItemMap().get(0));
		notFoundLabel.setVisible(false);
	}

	public void lookupButtonFire(ActionEvent event) {

		int id = Integer.valueOf(itemField.getText());

		if (Validation.itemExists(id)) {
			Item item = Database.itemBag.getItemMap().get(id);
			itemLabel.setText(item.toString());
			Database.imageBag.load(item.getImageFileName(), itemImage);
		} else {

			notFoundLabel.setVisible(true);
			GUIHelper.setPause(notFoundLabel);
		}
		itemField.clear();

	}

	public void backButtonFire(ActionEvent event) {
		switchView("/view/adminCenter.fxml", event);
	}

	public void deleteButtonFire(ActionEvent event) {

	}

}
