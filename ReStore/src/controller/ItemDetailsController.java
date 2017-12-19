package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import model.Database;
import model.GUIHelper;

public class ItemDetailsController extends BrowseController implements Initializable {

	@FXML
	private Button addToCartButton;
	@FXML
	private Button backButton;
	@FXML 
	private TextArea itemArea;
	@FXML
	private ImageView itemImage;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Database.imageBag.load(GUIHelper.getSelection().getImageFileName(), itemImage);
		itemArea.setText(GUIHelper.getSelection().toString());
		System.out.println(GUIHelper.getSelection());
	}
	
	public void backButtonFire(ActionEvent event) {

		switchView("/view/browseView.fxml", event);
	}
	
	public void addToCartButtonFire(ActionEvent event) {
		Database.currentUser.getCurrent().getCustomerCart().add(GUIHelper.getSelection());
		Database.userBag.save();
		
		switchView("/view/mainView.fxml", event);

	}
	

}
