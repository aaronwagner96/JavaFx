package application.view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;

import application.Main;
import javafx.fxml.FXML;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MainController {

    @FXML
    private ProgressIndicator progressIndicator;

    @FXML
    private TextField tf_ip;

    @FXML
    private TextField tf_db;
    
    @FXML
    private TextField tf_user;
    
    @FXML
    private TextField tf_pw;
    
    @FXML
    private TextArea ta_status;
    
    private Connection connection;
    
    // Reference to the main application.
    private Main mainApp;

    public MainController() {}

    @FXML
    private void initialize() {
    	
    }

    @FXML
    private void connectDatabase() {
    	new Thread() {
    		
    		@Override
    		public void run() {
    			connect();
    		}
    	}.start();
     }
    
    private void connect() {
       	ta_status.clear();

    	newStatus("Setting ip ...");
    	String ip = tf_ip.getText();
    	
    	newStatus("Setting db ...");
    	String db = tf_db.getText();
		
    	newStatus("Setting up connection url ...");
    	String url = "jdbc:mysql://" + ip + ":3306/" + db;
		
    	newStatus("Setting username ...");
    	String username = tf_user.getText();
    	
    	newStatus("Setting password ...");
		String password = tf_pw.getText();

		newStatus("All done.");
		newStatus("Connecting database ...");
		
		try {
			connection = DriverManager.getConnection(url, username, password);
			newStatus("Database connected successfully!");
			
			newStatus("Creating Session ...");
			Statement stmt = connection.createStatement();
	    	stmt.executeUpdate("INSERT INTO `test`.`login` (`Name`) VALUES ('Aaron');");
	    	newStatus("Session created successfully!");
	    	newStatus("Welcome!");
		} catch (Exception e) {
			newStatus("Couldn't connect to Database!");
		}
	}
    
    @FXML
    private void testQuery() {
    	startQuery("");
    }
    
    private void startQuery(String query) {
    	Statement stmt = null;
    	ResultSet rs = null;

    	try {
    		stmt = connection.createStatement();
	    	rs = stmt.executeQuery(query);
    	}
    	catch (SQLException ex){
    	    System.out.println("SQLException: " + ex.getMessage());
    	}
    	finally {
    	    if (rs != null) {
    	        try {
    	            rs.close();
    	        } catch (SQLException sqlEx) {}
    	        rs = null;
    	    }

    	    if (stmt != null) {
    	        try {
    	            stmt.close();
    	        } catch (SQLException sqlEx) {}
    	        stmt = null;
    	    }
    	}
    	
    	if (rs == null)
    		return;
    	
    	// Ergebnis nutzen
    }
    
    private void newStatus(String status) {
    	if (ta_status.getText().isEmpty()) {
    		ta_status.setText(status);
    		return;
    	}
    	
    	ta_status.setText(ta_status.getText() + "\n" + status);
    }
    
    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }
}