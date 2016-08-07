package application.view;

import application.DB_Controller;
import application.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class MainController {

    @FXML
    private TextField tf_username;

    @FXML
    private PasswordField tf_password;

    @FXML
    private Button btn_login;
    
    // Reference to the main application.
    private Main mainApp;

    public MainController() {}

    @FXML
    private void initialize() {
    	new Thread() {
    		@Override
    		public void run() {
    			DB_Controller.createDBConnection();
    		}
    	}.start();
    }

    @FXML
    private void loginUser() {
    	
    	String username = tf_username.getText();
    	String password = tf_password.getText();
    	
    	if (username.isEmpty() || password.isEmpty())
    		return;
    	
    	boolean loggedIn = DB_Controller.login(username, password);
    	
    	if (loggedIn) {
    		mainApp.setNewScene("view/SplashScreen.fxml");
    	}
    }
    
    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }
}