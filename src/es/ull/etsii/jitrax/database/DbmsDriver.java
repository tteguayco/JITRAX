package es.ull.etsii.jitrax.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import es.ull.etsii.jitrax.adt.Attribute;
import es.ull.etsii.jitrax.adt.Database;
import es.ull.etsii.jitrax.adt.Datum;
import es.ull.etsii.jitrax.adt.Row;
import es.ull.etsii.jitrax.adt.Table;

public class DbmsDriver {
	protected String dbmsPrefix;
	protected String hostname;
	protected String port;
	protected String username;
	protected String password;
	
	protected Connection connection;
	protected ResultSet queryResultSet;
	
	public DbmsDriver(String aDbmsPrefix, String aHostname, String aPort, 
			String anUsername, String aPassword) throws SQLException {
		dbmsPrefix = aDbmsPrefix;
		hostname = aHostname;
		port = aPort;
		username = anUsername;
		password = aPassword;
		
		String url = makeUrlConnection(hostname, port, "");
		connection = DriverManager.getConnection(url, username, password);
	}
	
	private String makeUrlConnection(String hostname, String port, String databaseName) {
		return "jdbc:" + dbmsPrefix + "://" + hostname + ":" + port + "/" + databaseName;
	}
	
	public void closeConnection() throws SQLException {
		getConnection().close();
	}
	
	/**
	 * Switches to an existing database on the DBMS.
	 * @param databaseName
	 * @throws SQLException
	 */
	public void switchDatabase(String databaseName) throws SQLException {
		databaseName = databaseName.toLowerCase();
		String newUrl = makeUrlConnection(hostname, port, databaseName);
		connection = DriverManager.getConnection(newUrl, username, password);
	}
	
	/**
	 * Returns true if the specified database already exists on the DBMS.
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
	 * @throws SQLException 
	 */
	public void createTable(Table table) throws SQLException {
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
		
		Statement statement = connection.createStatement();
		statement.executeUpdate(createTableStatement);
	}
	
	public void dropTable(Table aTable) throws SQLException {
		String dropTableStatement = "DROP TABLE IF EXISTS " + aTable.getName() + " CASCADE";
		
		Statement statement = connection.createStatement();
		statement.executeUpdate(dropTableStatement);
	}
	
	public void deleteAllRowsFromTable(Table aTable) throws SQLException {
		String deleteRowsStatement = "DELETE FROM " + aTable.getName() + " WHERE 1=1";
		
		Statement statement = connection.createStatement();
		statement.executeUpdate(deleteRowsStatement);
	}
	
	public void deleteRow(Table table, Row row) throws SQLException {
		String deleteRowStmt = "DELETE FROM " + table.getName() + " WHERE ";
		for (int i = 0; i < row.getTableAttributes().size(); i++) {
			deleteRowStmt += row.getTableAttributes().get(i).getName() 
					+ " = " + row.getDatum(i);
			
			// Add logical AND
			if (i < row.getTableAttributes().size() - 1) {
				deleteRowStmt += " and ";
			}
		}
		
		Statement statement = connection.createStatement();
		statement.executeUpdate(deleteRowStmt);
	}
	
	public void renameTable(Table aTable, String newName) throws SQLException {
		String renameStatement = "ALTER TABLE " + aTable.getName() 
			+ " RENAME TO " + newName;
		
		Statement statement = connection.createStatement();
		statement.executeUpdate(renameStatement);
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
	
	public void insertRow(ArrayList<String> row, Table table) throws SQLException {
		String insertRowStatement = "INSERT INTO " + table.getName() + " VALUES(";
		
		for (int i = 0; i < row.size(); i++) {
			insertRowStatement += row.get(i);
			
			// Add comma
			if (i < row.size() - 1) {
				insertRowStatement += ",";
			} else {
				insertRowStatement += ")";
			}
		}
		
		Statement statement = connection.createStatement();
		statement.executeUpdate(insertRowStatement);
	}
	
	public void dropDatabase(String databaseName) throws SQLException {
		Statement statement = connection.createStatement();
		statement.executeUpdate("DROP DATABASE " + databaseName);
	}
	
	public void executeQuery(String query) throws SQLException {
		Statement statement = connection.createStatement();
		queryResultSet = statement.executeQuery(query);
	}
	
	public void executeUpdate(String query) throws SQLException {
		Statement statement = connection.createStatement();
		statement.executeUpdate(query);
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
