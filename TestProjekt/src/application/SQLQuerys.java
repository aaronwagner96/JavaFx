package application;

public class SQLQuerys {

	public static String FIND_LAST_LOGIN(String username) {
		
		StringBuilder sql = new StringBuilder();
		
		sql.append("SELECT * FROM `test`.`session` WHERE `Name` = '");
		sql.append(username);
		sql.append("' ORDER BY `Time` DESC LIMIT 2;");
		
		return sql.toString();
	};
	
	public static String FIND_LOGIN_DATA(String username) {
		
		StringBuilder sql = new StringBuilder();
		
		sql.append("SELECT * FROM `test`.`userdata` WHERE `username` = '");
		sql.append(username);
		sql.append("';");
		
		return sql.toString();
	}
	
	public static String CREATE_SESSION(String username) {
		
		StringBuilder sql = new StringBuilder();
		
		sql.append("INSERT INTO `test`.`session` (`Name`) VALUES ('");
		sql.append(username);
		sql.append("');");
		
		return sql.toString();
	}
	
}
