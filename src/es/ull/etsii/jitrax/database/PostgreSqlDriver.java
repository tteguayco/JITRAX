package es.ull.etsii.jitrax.database;

import java.sql.SQLException;

public class PostgreSqlDriver extends DbmsDriver {
	private static final String DEFAULT_DBMS_PREFIX = "postgresql";
	
	public PostgreSqlDriver(String hostname, String port, 
			String username, String password) throws SQLException {
		super(DEFAULT_DBMS_PREFIX, hostname, port, username, password);
	}
	
	public String toString() {
		return "PostgreSQL";
	}
}
