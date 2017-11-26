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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.ItemBag;
import model.User;
import model.UserBag;
import view.Main;

public class MainController implements Initializable {

	public static UserBag userBag = new UserBag();
	public static ItemBag itemBag = new ItemBag();

	Main main = new Main();
	@FXML
	private Hyperlink signInLink;
	@FXML
	private ImageView woodImage;
	@FXML
	private ImageView couchImage;
	@FXML
	private ImageView windowImage;
	@FXML
	private ImageView doorImage;
	@FXML
	private Button add;
	User user = null;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		userBag.load();
		itemBag.load();
		
		if (userBag.getUserMap().containsKey("admin")) {

		} else {
			userBag.addUser("admin", userBag.getAdmin());
		}


		
	}

	public void woodImageFire(MouseEvent event) {
		System.out.println("wood clicked");

		Node node = (Node) event.getSource();
		Stage stage = (Stage) node.getScene().getWindow();
		Parent root = null;

		try {
			root = FXMLLoader.load(getClass().getResource("/view/browseView.fxml"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Scene scene = new Scene(root);
		stage.setScene(scene);
	}

	public void couchFire(MouseEvent event) {
		System.out.println("couch clicked");
	}

	public void windowFire(MouseEvent event) {
		System.out.println("window clicked");
	}

	public void doorFire(MouseEvent event) {
		System.out.println("door clicked");
	}

	public void signInLinkFire(ActionEvent event) {
		System.out.println("button clicked");
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

}
