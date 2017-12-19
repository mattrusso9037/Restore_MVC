package controller;

import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import model.Database;
import model.Employee;
import model.GUIHelper;

public class EmployeesController extends MainController implements Initializable {

	@FXML
	private Button backButton;
	@FXML
	private TextField searchBox;
	@FXML
	private Button searchButton;
	@FXML
	private Button deleteButton;
	@FXML
	private ListView listView;
	@FXML
	private Label notFoundLabel;
	@FXML
	private Label employeeLabel;

	private ObservableList employeeData = FXCollections.observableArrayList();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		notFoundLabel.setVisible(false);
		listView.setItems(setEmployeeData());
		searchButton.setDefaultButton(true);
	}

	private ObservableList setEmployeeData() {
		employeeData.addAll(Database.employeeBag.getEmployeeMap().values());
		return employeeData;

	}

	public void backButtonFire(ActionEvent event) {
		switchView("/view/adminCenter.fxml", event);
	}

	public void searchButtonFire(ActionEvent event) {
		String keyword = searchBox.getText();
		GUIHelper.setEmployeeQueryData(keyword, listView);
		
		System.out.println("clicked");
	}

	public void deleteButtonFire(ActionEvent event) {
		Database.employeeBag.getEmployeeMap().remove(listView.getSelectionModel().getSelectedItem());
		Database.employeeBag.save();
		switchView("/view/employeesView.fxml", event);
	}

}
