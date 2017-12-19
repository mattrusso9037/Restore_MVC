package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Admin;
import model.Database;
import model.User;
import model.Validation;

public class NewUserController extends LoginController implements Initializable {
	@FXML
	private Button createButton;
	@FXML
	private TextField firstName;
	@FXML
	private TextField lastName;
	@FXML
	private TextField email;
	@FXML
	private PasswordField password;
	@FXML
	private Label isValid;
	@FXML
	private Button cancelButton;
	@FXML
	private Button nextButton;
	@FXML
	private PasswordField newPassword;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	public void newPasswordButtonFire(ActionEvent event) {

		if (Validation.isAdmin(Database.currentUser.getCurrent().getUsername())) {
			Admin.get_Admin().setPassword(newPassword.getText());
			System.out.println("new pw : " + Admin.get_Admin().getPassword());
			System.out.println("admin after pw change: " + Admin.get_Admin());
			Admin.get_Admin().save();
		}

		if (Validation.isEmployee(Database.currentUser.getCurrent().getUsername())) {
			System.out.println("this is employee");
			Database.currentUser.getCurrent().setPassword(newPassword.getText());
			System.out.println(Database.currentUser.getCurrent() + Database.currentUser.getCurrent().getPassword());
			Database.employeeBag.save();
		}

		switchView("/view/mainView.fxml", event);

	}

	public void cancelButtonFire(ActionEvent event) {
		switchView("/view/loginView.fxml", event);
	}

	public void createButtonFire(ActionEvent event) {

		User user = new User(firstName.getText(), lastName.getText(), email.getText(), password.getText());
	
		if (Validation.isValid(user) && Validation.passwordIsValid(user.getPassword())
				&& Validation.usernameIsValid(user.getUsername())
				&& !Database.userBag.getUserMap().containsKey(email.getText())) {

			Database.userBag.getUserMap().put(user.getUsername(), user);
			Database.userBag.save();
			System.out.println(Database.userBag.getUserMap().get(user.getUsername()));

			switchView("/view/loginView.fxml", event);
		} else if (!Validation.usernameIsValid(user.getUsername())) {
			isValid.setText("*  not a valid email address");
		} else if (Database.userBag.getUserMap().containsKey(email.getText())) {
			isValid.setText("*  Username already exists");
			email.clear();
		} else if (!Validation.passwordIsValid(user.getPassword())) {
			isValid.setText("*  password must be at least 8 characters");
		} else {
			isValid.setText("*  all fields required");
		}
	}

}
