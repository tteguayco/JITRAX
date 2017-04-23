package es.ull.etsii.jitrax.database;

import java.sql.SQLException;

public class MySqlDriver extends DbmsDriver {
	private static final String DEFAULT_DBMS_PREFIX = "mysql";
	
	public MySqlDriver(String hostname, String port, String username, String password) 
			throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		super(DEFAULT_DBMS_PREFIX, hostname, port, username, password);
		Class.forName("com.mysql.jdbc.Driver").newInstance();
	}
	
	public String toString() {
		return "MySQL";
	}
}
