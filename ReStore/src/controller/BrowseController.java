package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class BrowseController extends AdminController implements Initializable {

	@FXML
	private ListView<String> listView;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		System.out.println(data.isEmpty());
		System.out.println(itemBag.getItemList().isEmpty());
		listView.setItems(setData());
	}

	public ObservableList setData() {
for (int j = 0; j < itemBag.getItemList().size(); j++) {
	data.add(itemBag.getItemList().get(j));
}
		return data;

	}

	public ObservableList getObservableList() {
		return data;
	}
	
	public void backButtonFire(ActionEvent event) {
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

}
