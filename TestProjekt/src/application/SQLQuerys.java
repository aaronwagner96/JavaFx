package application;

public class SQLQuerys {

	private static String SELECT_FROM = "SELECT * FROM `" + AccessModel.DB + "`.";
	private static String INSERT_INTO = "INSERT INTO `" + AccessModel.DB + "`.";
	
	public static String FIND_LAST_LOGIN(String USER_ID) {
		
		StringBuilder sql = new StringBuilder();
		
		sql.append(SELECT_FROM);
		sql.append("`stm_session` ");
		sql.append("WHERE `USER_ID` = '");
		sql.append(USER_ID);
		sql.append("' ORDER BY `TIME` DESC LIMIT 2;");
		
		return sql.toString();
	};
	
	public static String FIND_LOGIN_DATA(String USER_ID) {
		
		StringBuilder sql = new StringBuilder();
		
		sql.append(SELECT_FROM);
		sql.append("`stm_login` ");
		sql.append("WHERE `USER_ID` = '");
		sql.append(USER_ID);
		sql.append("';");
		
		return sql.toString();
	}
	
	public static String CREATE_SESSION(String USER_ID) {
		
		StringBuilder sql = new StringBuilder();
		
		sql.append(INSERT_INTO);
		sql.append("`stm_session` (`USER_ID`) VALUES ('");
		sql.append(USER_ID);
		sql.append("');");
		
		return sql.toString();
	}
	
}
