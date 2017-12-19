package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class AdminCenterController extends AdminController implements Initializable {
	@FXML
	private Button addEmployeeButton;
	@FXML
	private Button inventoryButton;
	@FXML
	private Button lookupButton;
	@FXML
	private Button employeesButton;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
	}
	public void lookupButtonFire(ActionEvent event) {
		switchView("/view/itemLookupView.fxml", event);
	}
	public void inventoryButtonFire(ActionEvent event) {
		switchView("/view/addItemView.fxml", event);
	}

	public void addEmployeeButtonFire(ActionEvent event) {
		switchView("/view/newEmployeeView.fxml", event);
	}
	
	public void homeButtonFire(ActionEvent event) {
		switchView("/view/mainView.fxml", event);

	}
	public void employeesButtonFire(ActionEvent event) {
		switchView("/view/employeesView.fxml", event);
	}

}
