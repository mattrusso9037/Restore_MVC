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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Admin;
import model.Database;
import model.Validation;

public class MainController implements Initializable {

	protected static int typeID;
	protected static String searchQuery;

	public static int getTypeID() {
		return typeID;
	}

	public void setTypeID(int typeID) {
		this.typeID = typeID;
	}

	@FXML
	private Hyperlink signInLink;
	@FXML
	private Hyperlink signOutLink;
	@FXML
	private Hyperlink myCartLink;
	@FXML
	private ImageView woodImage;
	@FXML
	private ImageView couchImage;
	@FXML
	private ImageView windowImage;
	@FXML
	private ImageView doorImage;
	@FXML
	private Button adminButton;
	@FXML
	private Label welcomeLabel = null;
	@FXML
	private Button inventoryButton;
	@FXML
	private Button goButton;
	@FXML
	private Button pendingOrdersButton;
	@FXML
	private TextField searchBox; 
	@FXML
	private Pane pane;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		goButton.setDefaultButton(true);

		Database.userBag.load();
		Database.itemBag.load();
		Database.employeeBag.load();
		Database.orderBag.load();
		Admin.get_Admin().load();
		// button hide
		adminButton.setVisible(false);
		inventoryButton.setVisible(false);
		signOutLink.setVisible(false);
		myCartLink.setVisible(false);
		pendingOrdersButton.setVisible(false); 

		if (Database.currentUser.getCurrent() != null) {
			signInLink.setVisible(false);
			signOutLink.setVisible(true); 

			if (Validation.isAdmin(Database.currentUser.getCurrent().getUsername())
					|| Validation.isEmployee(Database.currentUser.getCurrent().getUsername())) {
				myCartLink.setVisible(false);
			} else {
				myCartLink.setVisible(true);

			}

		}

		
		if (Database.currentUser.getCurrent() != null) {
			welcomeLabel.setText("Welcome " + Database.currentUser.getCurrent().getFirstName());

		}

		if (Database.currentUser.getCurrent() != null
				&& Validation.isAdmin(Database.currentUser.getCurrent().getUsername())) {
			adminButton.setVisible(true);
			pendingOrdersButton.setVisible(true);
		}

		if (Database.currentUser.getCurrent() != null
				&& Validation.isEmployee(Database.currentUser.getCurrent().getUsername())) {
			inventoryButton.setVisible(true);
			pendingOrdersButton.setVisible(true);

		}

	}

	public void pendingOrdersButtonFire(ActionEvent event) {
		switchView("/view/pendingOrdersView.fxml", event);
	}

	public void woodImageFire(MouseEvent event) {
		setTypeID(0);
		switchMouseView("/view/browseView.fxml", event);
	}

	public void couchFire(MouseEvent event) {
		setTypeID(1);
		switchMouseView("/view/browseView.fxml", event);

	}

	public void windowFire(MouseEvent event) {
		setTypeID(2);
		switchMouseView("/view/browseView.fxml", event);
	}

	public void doorFire(MouseEvent event) {
		setTypeID(3);
		switchMouseView("/view/browseView.fxml", event);
	}

	public void adminButtonFire(ActionEvent event) {
		switchView("/view/adminCenter.fxml", event);
	}

	public void signInLinkFire(ActionEvent event) {
		switchView("/view/loginView.fxml", event);
	}

	public void signOutLinkFire(ActionEvent event) {
		Database.currentUser.setCurrent(null);
		switchView("/view/mainView.fxml", event);

	}

	public void myCartLinkFire(ActionEvent event) {

		switchView("/view/myCartView.fxml", event);
	}

	public void inventoryButtonFire(ActionEvent event) {
		switchView("/view/employeeCenter.fxml", event);
	}

	public void goButtonFire(ActionEvent event) {
		setTypeID(4);
		searchQuery = searchBox.getText();
		switchView("/view/browseView.fxml", event);
	}

	public Label getWelcomeLabel() {
		return welcomeLabel;
	}

	public void setWelcomeLabel(Label welcomeLabel) {
		this.welcomeLabel = welcomeLabel;
	}

	public void switchView(String viewName, ActionEvent event) {
		Node node = (Node) event.getSource();
		Stage stage = (Stage) node.getScene().getWindow();
		Parent root = null;

		try {
			root = FXMLLoader.load(getClass().getResource(viewName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Scene scene = new Scene(root);
		scene.getStylesheets().add("/view/application.css");

		stage.setScene(scene);

	}

	public void switchMouseView(String viewName, MouseEvent event) {
		Node node = (Node) event.getSource();
		Stage stage = (Stage) node.getScene().getWindow();
		Parent root = null;

		try {
			root = FXMLLoader.load(getClass().getResource(viewName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Scene scene = new Scene(root);
		scene.getStylesheets().add("/view/application.css");
		stage.setScene(scene);

	}

}
