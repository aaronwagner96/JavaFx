package application;

import java.io.IOException;

import application.view.Main_Controller;
import application.view.SplashScreen_Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

	private Stage primaryStage;
	public static String userID;

	@Override
	public void start(Stage primaryStage) {
		try {
			this.primaryStage = primaryStage;

			// Load root layout from fxml file.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/MainView.fxml"));
			Pane rootLayout = (Pane) loader.load();

			Scene scene = new Scene(rootLayout);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();

			
			/*
			 * Controller Accesses
			 */
			
			Main_Controller controller_main = loader.getController();
			controller_main.setMainApp(this);
			
			loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/SplashScreen.fxml"));
			loader.load();
			SplashScreen_Controller controller_splash = loader.getController();
			controller_splash.setMainApp(this);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void setNewScene(String path) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource(path));
			Pane rootLayout;
			rootLayout = (Pane) loader.load();

			Scene scene = new Scene(rootLayout);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
