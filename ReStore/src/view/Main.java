package view;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Admin;
import model.EmployeeBag;
import model.ImageBag;
import model.ItemBag;
import model.UserBag;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		final Admin admin = Admin.createAdmin();

		try {
			Pane root = (Pane) FXMLLoader.load(getClass().getResource("mainView.fxml"));
			Scene scene = new Scene(root,600,400);
			scene.getStylesheets().add("/view/application.css");

			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
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
