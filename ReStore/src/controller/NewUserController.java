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
import model.User;

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

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}
	
public void cancelButtonFire(ActionEvent event) {
	Node node = (Node) event.getSource();
	Stage stage = (Stage) node.getScene().getWindow();
	Parent root = null;

	try {
		root = FXMLLoader.load(getClass().getResource("/view/loginView.fxml"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	Scene scene = new Scene(root);
	stage.setScene(scene);

}
	public void createButtonFire(ActionEvent event) {
		System.out.println("button clicked");

		User user = new User(firstName.getText(), lastName.getText(), email.getText(), password.getText());


		if (user.isValid() && user.passwordIsValid() && user.usernameIsValid() && !userBag.getUserMap().containsKey(email.getText())) {
		
			userBag.addUser(user.getUsername(), user);
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
		} else if (!user.usernameIsValid()){
			isValid.setText("*  not a valid email address");
		} else if (userBag.getUserMap().containsKey(email.getText())) {
			isValid.setText("*  Username already exists");
			email.clear();
		} else if (!user.passwordIsValid()) {
			isValid.setText("*  password must be at least 8 characters");
		} else {
			isValid.setText("*  all fields required");
		}
	}

}
