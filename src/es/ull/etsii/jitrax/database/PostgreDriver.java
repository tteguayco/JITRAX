package es.ull.etsii.jitrax.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import es.ull.etsii.jitrax.adt.Attribute;
import es.ull.etsii.jitrax.adt.Database;
import es.ull.etsii.jitrax.adt.Datum;
import es.ull.etsii.jitrax.adt.Row;
import es.ull.etsii.jitrax.adt.Table;

public class PostgreDriver {
	private static final String DEFAULT_HOSTNAME = "localhost";
	private static final String DEFAULT_PORT 	 = "5432"; 
	private static final String DEFAULT_USERNAME = "postgres";
	private static final String DEFAULT_PASSWORD = "postgres";
	
	private String hostname;
	private String port;
	private String username;
	private String password;
	
	private Connection connection;
	private ResultSet queryResultSet;
	
	public PostgreDriver() throws SQLException {
		hostname = DEFAULT_HOSTNAME;
		port = DEFAULT_PORT;
		username = DEFAULT_USERNAME;
		password = DEFAULT_PASSWORD;
		
		String url = makeUrlConnection(hostname, port, "");
		connection = DriverManager.getConnection(url, username, password);
	}
	
	public PostgreDriver(String aHostname, String aPort, String anUsername, String aPassword) throws SQLException {
		hostname = aHostname;
		port = aPort;
		username = anUsername;
		password = aPassword;
		
		String url = makeUrlConnection(hostname, port, "");
		connection = DriverManager.getConnection(url, username, password);
	}
	
	private String makeUrlConnection(String hostname, String port, String databaseName) {
		return "jdbc:postgresql://" + hostname + ":" + port + "/" + databaseName;
	}
	
	public void closeConnection() throws SQLException {
		getConnection().close();
	}
	
	/**
	 * Switches to an existing database in PostgreSQL.
	 * @param databaseName
	 * @throws SQLException
	 */
	public void switchDatabase(String databaseName) throws SQLException {
		databaseName = databaseName.toLowerCase();
		String newUrl = makeUrlConnection(hostname, port, databaseName);
		connection = DriverManager.getConnection(newUrl, username, password);
	}
	
	/**
	 * Returns true if the specified database already exists in PostgreSQL.
	 * @param aDatabaseName
	 * @return
	 */
	public boolean databaseAlreadyExists(String aDatabaseName) {
		aDatabaseName = aDatabaseName.toLowerCase();
		
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(
					"SELECT datname FROM pg_catalog.pg_database WHERE datname='" + aDatabaseName + "'");
			
			if (!rs.next()) {
				return false;
			} else {
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public void createDatabase(String databaseName) throws SQLException {
		databaseName = databaseName.toLowerCase();
		Statement statement = connection.createStatement();
		statement.executeUpdate("CREATE DATABASE " + databaseName);
	}
	
	/**
	 * For the current database, sets up tables, attributes, rows, etc.
	 * @param databaseName
	 * @throws SQLException
	 */
	public void setUpDatabase(Database database) throws SQLException {
		Table auxTable;
		
		// CREATE TABLES
		for (int i = 0; i < database.getNumOfTables(); i++) {
			auxTable = database.getTables().get(i);
			createTable(auxTable);
			
			// INSERT ROWS
			for (int j = 0; j < auxTable.getRows().size(); j++) {
				insertRow(auxTable.getRows().get(j), auxTable);
			}
		}
	}
	
	/**
	 * Creates the specified table on the current database of PostgreSQL.
	 * @param table
	 */
	public void createTable(Table table) {
		Attribute auxAttr;
		String createTableStatement = "CREATE TABLE ";
		
		createTableStatement += table.getName();
		createTableStatement += "(";
		
		// ATTRIBUTES
		for (int i = 0; i < table.getNumOfColumns(); i++) {
			auxAttr = table.getAttributes().get(i);
			createTableStatement += auxAttr.getName();
			createTableStatement += " ";
			
			switch (auxAttr.getDataType()) {
				case STRING: createTableStatement += "varchar(255)"; break;
				case CHAR: createTableStatement += "char"; 			 break;
				case INT: createTableStatement += "int"; 			 break;
				case FLOAT: createTableStatement += "float"; 		 break;
				case DATE: createTableStatement += "date"; 			 break;
			}
			
			// Add comma
			if (i < table.getNumOfColumns() - 1) {
				createTableStatement += ",";
			} else {
				createTableStatement += ")";
			}
		}
		
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate(createTableStatement);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void dropTable(Table aTable) {
		String dropTableStatement = "DROP TABLE " + aTable.getName();
		
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate(dropTableStatement);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void insertRow(Row row, Table table) {
		Datum auxDatum;
		String insertRowStatement = "INSERT INTO " + table.getName() + " VALUES(";
		
		for (int i = 0; i < row.getData().size(); i++) {
			auxDatum = row.getData().get(i);
			insertRowStatement += auxDatum.getStringValue();
			
			// Add comma
			if (i < row.getData().size() - 1) {
				insertRowStatement += ",";
			} else {
				insertRowStatement += ")";
			}
		}
		
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate(insertRowStatement);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void dropDatabase(String databaseName) throws SQLException {
		Statement statement = connection.createStatement();
		statement.executeUpdate("DROP DATABASE " + databaseName);
	}
	
	public void executeQuery(String query) throws SQLException {
		Statement statement = connection.createStatement();
		queryResultSet = statement.executeQuery(query);
	}
	
	public String getResultSetString() throws SQLException {
		String resultSetString = "";
		
		while (queryResultSet.next()) {
			resultSetString += "\n";
			int nColumns = queryResultSet.getMetaData().getColumnCount();
			for (int i = 1; i <= nColumns; i++) {
				resultSetString += queryResultSet.getObject(i) + ",";
			}
		}
		
		return resultSetString;
	}

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public ResultSet getQueryResultSet() {
		return queryResultSet;
	}

	public void setQueryResultSet(ResultSet queryResultSet) {
		this.queryResultSet = queryResultSet;
	}
}
