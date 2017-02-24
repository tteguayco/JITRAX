package es.ull.etsii.jitrax.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import es.ull.etsii.jitrax.adt.Attribute;
import es.ull.etsii.jitrax.adt.DataType;
import es.ull.etsii.jitrax.adt.Database;
import es.ull.etsii.jitrax.adt.Table;

public class PostgreDriver {
	private static final String DEFAULT_URL = "jdbc:postgresql://localhost:5432/";
	private static final String DEFAULT_USERNAME = "postgres";
	private static final String DEFAULT_PASSWORD = "postgres";
	
	private Connection connection;
	private ResultSet queryResultSet;
	
	public PostgreDriver() throws SQLException {
		connection = DriverManager.getConnection(DEFAULT_URL, DEFAULT_USERNAME, DEFAULT_PASSWORD);
	}
	
	public PostgreDriver(String hostname, int port, String username, String password) throws SQLException {
		String url = "jdbc:postgresql://" + hostname + ":" + port + "/";
		connection = DriverManager.getConnection(url, username, password);
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
	
	/**
	 * Creates a new database with the specified name and switches to it.
	 * @param databaseName
	 * @throws SQLException
	 */
	public void createDatabase(Database database) throws SQLException {
		Statement statement = connection.createStatement();
		Table auxTable;
		
		// CREATE DATABASE
		statement.executeUpdate("CREATE DATABASE " + database.getName());
		
		// CREATE TABLES
		for (int i = 0; i < database.getNumOfTables(); i++) {
			auxTable = database.getTables().get(i);
			createTable(auxTable);
		}
		
		// INSERT ROWS
		// TO-DO
	}
	
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
		
		Statement statement;
		try {
			statement = connection.createStatement();
			statement.executeUpdate(createTableStatement);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void insertRow() {
		
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
}
