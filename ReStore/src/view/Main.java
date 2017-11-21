package view;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import model.User;
import model.UserBag;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;


public class Main extends Application {

	
	@Override
	public void start(Stage primaryStage) {

	
		
		
		try {
			Pane root = (BorderPane) FXMLLoader.load(getClass().getResource("mainView.fxml"));
			Scene scene = new Scene(root,800,600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public Scene getScene() {
		return getScene();
	}

	public Stage getStage() {
		return getStage();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
