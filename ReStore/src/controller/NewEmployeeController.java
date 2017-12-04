package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.Employee;

public class NewEmployeeController extends MainController implements Initializable {
	@FXML
	private TextField emailTextField;
	@FXML
	private Button createButton;
	@FXML
	private TextField firstName;
	@FXML
	private TextField lastName;

	@Override

	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

	public void createButtonFire(ActionEvent event) {
		Employee employee = new Employee(firstName.getText(), lastName.getText(), emailTextField.getText(), "1234");
		employeeBag.addEmployee(employee.getUsername(), employee);
		employeeBag.save();
		switchView("/view/adminCenter.fxml", event);
	}

	public void backButtonFire(ActionEvent event) {
		switchView("/view/adminCenter.fxml", event);
	}
}