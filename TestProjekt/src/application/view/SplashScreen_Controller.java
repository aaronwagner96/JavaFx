package application.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import application.DB_Controller;
import application.Main;
import application.SQLQuerys;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class SplashScreen_Controller {

	// Reference to the main application.
	private Main mainApp;

	@FXML
	private Label lbl_welcome;
	
	@FXML
	private Label lbl_lastLogin;
	
	public SplashScreen_Controller() {
	}

	@FXML
	private void initialize() {
		
		ResultSet rs = DB_Controller.executeQuery(SQLQuerys.FIND_LAST_LOGIN(Main.userID));
		
		Timestamp lastLogin = null;
    	try {
			while (rs.next()) {
				lastLogin = rs.getTimestamp("Time");
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
    	lbl_welcome.setText(lbl_welcome.getText() + " " + Main.userID);
		if (lastLogin != null) {
			lbl_lastLogin.setText(lbl_lastLogin.getText() + " " + lastLogin.toString());
		} else {
			lbl_lastLogin.setText(lbl_lastLogin.getText() + " never");
		}
    	
    	
    	
	}

	public void setMainApp(Main mainApp) {
		this.mainApp = mainApp;
	}
}