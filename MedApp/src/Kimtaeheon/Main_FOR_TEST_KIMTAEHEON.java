package Kimtaeheon;

import javafx.application.Application;
import javafx.stage.Stage;
import model.CManagerOrViewer;
import view.Number3;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;

public class Main_FOR_TEST_KIMTAEHEON extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader();
			Parent root = fxmlLoader.load(getClass().getResource("../view/Main_KimtaeHeon.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application_kimtaeheon.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		    CManagerOrViewer Manager = CManagerOrViewer.getInstance();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}