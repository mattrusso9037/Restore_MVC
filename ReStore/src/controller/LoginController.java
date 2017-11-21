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
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.User;

public class LoginController extends MainController implements Initializable {
	@FXML
	private Button signInBtn;
	@FXML
	private Hyperlink createAccount;
	@FXML
	private TextField username;
	@FXML
	private TextField password;
	@FXML
	private Label isValidLabel;
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
			root = FXMLLoader.load(getClass().getResource("/view/mainView.fxml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Scene scene = new Scene(root);
		stage.setScene(scene);

	}

	public void signInFire(ActionEvent event) {
		
		User user;
		System.out.println("button clicked");

		
		
		
		
		//admin login
		
		
		//if valid add to bag
		if (userBag.getUserMap().containsKey(username.getText())) {
			user = (User) userBag.getUserMap().get(username.getText());

			if (password.getText().equals(user.getPassword())) {
				System.out.println("CREDENTIALS MATCH");
				
				if (user.getUsername() == "admin") {
					//load admin view
					System.out.println("admin login");
					
				}
			} else {
				isValidLabel.setText("*invalid password");
			}

		} else {
			isValidLabel.setText("*user not found");
		}
	

	}

	public void createAccountFire(ActionEvent event) {
		System.out.println("button clicked");

		Node node = (Node) event.getSource();
		Stage stage = (Stage) node.getScene().getWindow();
		Parent root = null;

		try {
			root = FXMLLoader.load(getClass().getResource("/view/createAccountView.fxml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Scene scene = new Scene(root);
		stage.setScene(scene);
	}

}