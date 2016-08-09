package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB_Controller {

	private static Connection connection;
	
	public static boolean createDBConnection() {
		
		String ip = "localhost";
		String db = "test";
		String username = "root";
		String password = "0000";
		String url = "jdbc:mysql://" + ip + ":3306/" + db;
		
		try {
			connection = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
    public static ResultSet executeQuery(String query) {
    	Statement stmt = null;
    	ResultSet rs = null;

    	try {
			if (connection == null || connection.isClosed())
				createDBConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    	try {
    		stmt = connection.createStatement();
	    	rs = stmt.executeQuery(query);
    	}
    	catch (SQLException ex){
    	    System.out.println("SQLException: " + ex.getMessage());
    	}
    	finally {
//    	    if (rs != null) {
//    	        try {
//    	            rs.close();
//    	        } catch (SQLException sqlEx) {}
//    	    }
//    	    if (stmt != null) {
//    	        try {
//    	            stmt.close();
//    	        } catch (SQLException sqlEx) {}
//    	    }
    	}

    	if (rs == null)
    		return null;
    	
    	return rs;
    }
    
    public static boolean login(String username, String password) {
    	
    	ResultSet rs = executeQuery(SQLQuerys.FIND_LOGIN_DATA(username));
    	
    	if (rs == null)
    		return false;
    	
    	String passwordInDB = null;
    	try {
			while (rs.next()) {
				passwordInDB = rs.getString("password");
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
			return false;
		}

    	if (password != null && passwordInDB.equals(password)) {

    		Statement stmt;
			try {
				// Login Session erzeugen
				stmt = connection.createStatement();
				stmt.executeUpdate(SQLQuerys.CREATE_SESSION(username));
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
    		
    		return true;
    	}
    	
    	return false;
    }
	
}
