package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class EmployeeCenterController extends MainController implements Initializable {

	@FXML
	private Button inventoryButton;
	@FXML
	private Button lookupButton;
	@FXML
	private Button backButton;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	public void inventoryFire(ActionEvent event) {
		switchView("/view/addItemView.fxml", event);
	}
	
	public void lookupFire(ActionEvent event) {
		switchView("/view/itemLookupView.fxml", event);

	}
	public void backButtonFire(ActionEvent event) {
		switchView("/view/mainView.fxml", event);
	}
}