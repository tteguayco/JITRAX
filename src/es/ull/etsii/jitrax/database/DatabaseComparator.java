package es.ull.etsii.jitrax.database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import es.ull.etsii.jitrax.adt.Attribute;
import es.ull.etsii.jitrax.adt.DataType;
import es.ull.etsii.jitrax.adt.Database;
import es.ull.etsii.jitrax.adt.Datum;
import es.ull.etsii.jitrax.adt.Row;
import es.ull.etsii.jitrax.adt.Table;

/**
 * Compares a Database object with a database in a DBMS
 * (it checks whether they have the same attributes, domains, etc).
 */
public class DatabaseComparator {
	private static final String NUMBER_REGEXP = "\\d+(\\.\\d+)?";
	
	private Database database;
	private Connection dbmsConnection;
	private ArrayList<String> queriesForUpdate;
	
	/**
	 * Names of those table on the application that 
	 * are on the DBMS as well.
	 */
	private ArrayList<Table> localTablesOnDbms;
	
	private DatabaseMetaData databaseMetadata;
	private ResultSet tablesResultSet;
	
	public DatabaseComparator(Database aDatabase, Connection aDbmsConnection) {
		database = aDatabase;
		dbmsConnection = aDbmsConnection;
		queriesForUpdate = new ArrayList<String>();
		localTablesOnDbms = new ArrayList<Table>();
		
		try {
			databaseMetadata = getDbmsConnection().getMetaData();
			tablesResultSet = databaseMetadata.getTables(null, null, null, new String[] {"TABLE"});
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @return true if the object database is identical to the database 
	 * on the DBMS (all queries executed within this method are read-only).
	 */
	public boolean databasesAreCompatible() {	
		// TABLES?
		if (!localTablesAreOnDbms()) {
			return false;
		}
		
		// FOR EACH TABLE, ATTRIBUTES?
		else if (!databaseSchemasCoincide()) {
			return false;
		}
		
		// CONTENTS (rows)?
		else if (!tablesContentsCoincide()) {
			// Sync rows up
			syncContents();
			System.out.println("> Rows were synchronized.");
		}
		
		return true;
	}
	
	/**
	 * Overwrites the database in the DBMS with the database specified
	 * on the application. This means:
	 * 	- DROP all the tables in the database on the DBMS
	 *  - CREATE all the tables on the application again on the DBMS.
	 * @throws SQLException 
	 */
	public void overwriteDatabaseOnDbms() throws SQLException {
		Table auxTable;
		DbmsDriver dbmsDriver = database.getDbmsDriver();
		
		// dROP TABLES
		for (int i = 0; i < database.getTables().size(); i++) {
			auxTable = database.getTables().get(i);
			dbmsDriver.dropTable(auxTable);
		}
		
		// SET UP DATABASE AGAIN (create tables and insert rows)
		dbmsDriver.setUpDatabase(database);
	}
	
	public boolean localTablesAreOnDbms() {
		ArrayList<String> dbmsTables = new ArrayList<String>();
		
		try {
			// Getting tables' names on DBMS
			tablesResultSet.beforeFirst();
			while (tablesResultSet.next()) {
				// Getting tables
				String tableName = tablesResultSet.getString("TABLE_NAME");
				dbmsTables.add(tableName.toLowerCase());
			}
			tablesResultSet.beforeFirst();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		// COMPARING TABLES (it does not matter if there are more tables in the DBMS;
		// all of the tables of the locale database have to be in the DBMS)
		for (int i = 0; i < getDatabase().getNumOfTables(); i++) {
			Table localTable = getDatabase().getTables().get(i);
			if (!dbmsTables.contains(localTable.getName().toLowerCase())) {
				return false;
			} else  {
				localTablesOnDbms.add(localTable);
			}
		}
		
		return true;
	}
	
	public boolean databaseSchemasCoincide() {
		
		try {
			// For each DBMS table
			tablesResultSet.beforeFirst();
			while (tablesResultSet.next()) {
				// Getting tables
				String tableName = tablesResultSet.getString("TABLE_NAME");
				Table currentLocalTable = getDatabase().getTableByName(tableName);
				int numberOfAttributesForRemote = 0;
				
				if (currentLocalTable != null) {
				
					// Getting attributes
					ResultSet attrResultSet = databaseMetadata.getColumns(null, null, tableName, "%");
					
					// Getting the number of rows returned (number of attributes in the current table)
					// and storing it in the 'numberOfAttributesForRemote'
					if (attrResultSet != null) {  
					  attrResultSet.beforeFirst();  
					  attrResultSet.last();  
					  numberOfAttributesForRemote = attrResultSet.getRow();
					  attrResultSet.beforeFirst();
					}
					
					// If the number of attributes differs, databases are not compatibles
					if (currentLocalTable.getNumOfColumns() != numberOfAttributesForRemote) {
						return false;
					}
					
					// COMPARING ATTRIBUTES
					while (attrResultSet.next()) {
						String attrName = attrResultSet.getString("COLUMN_NAME");
						String attrType = attrResultSet.getString("TYPE_NAME");
						DataType attrDataType;
						
						// Comparing data types
						if (attrType.contains("varchar")) {
							attrDataType = DataType.STRING;
						} else if (attrType.contains("char")) {
							attrDataType = DataType.CHAR;
						} else if (attrType.contains("int")) {
							attrDataType = DataType.INT;
						} else if (attrType.contains("float")) {
							attrDataType = DataType.FLOAT;
						} else if (attrType.contains("date")) {
							attrDataType = DataType.DATE;
						} else {
							attrDataType = null;
						}
						
						// Check if the attribute exists on the current table
						if (!currentLocalTable.attributeExists(attrName, attrDataType)) {
							return false;
						}
					}
				}
			}
			
			tablesResultSet.isBeforeFirst();
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
			
		return true;
	}
	
	private boolean tablesContentsCoincide() {
		Table currentLocalTable;
		
		// COMPARING ROWS
		for (int tableIndex = 0; tableIndex < localTablesOnDbms.size(); tableIndex++) {
			currentLocalTable = localTablesOnDbms.get(tableIndex);
			
			try {
				for (int i = 0; i < getDatabase().getNumOfTables(); i++) {
					int numOfRows = 0;
					Statement st = getDbmsConnection().createStatement();
					ResultSet countRS = st.executeQuery("select count(*) from " + 
							currentLocalTable.getName());
					
					countRS.next();
					numOfRows = countRS.getInt(1);
					
					// Check matching between number of rows (on DBMS and locally)
					if (currentLocalTable.getNumOfRows() != numOfRows) {
						return false;
					}
					
					// Compare contents
					String[][] rowsData = currentLocalTable.getRowsData();
					for (int j = 0; j < rowsData.length; j++) {
						String query = "SELECT * FROM " + currentLocalTable.getName() + " WHERE ";
						for (int k = 0; k < rowsData[j].length; k++) {
							query += currentLocalTable.getAttributes().get(k).getName() + "=";
							query += rowsData[j][k];
							if (k < rowsData[j].length - 1) {
								query += " AND ";
							}
						}
						ResultSet rs = st.executeQuery(query);
						//System.out.println(query);
						if (!rs.next()) {
							return false;
						}
					}
				}
			}
			
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return true;
	}
	
	private void insertDbmsRowsToLocalTable() throws SQLException {
		tablesResultSet.beforeFirst();
		// For each table on the DBMS
		while (tablesResultSet.next()) {
			String remoteTableName = tablesResultSet.getString("TABLE_NAME");
			Table localTable = database.getTableByName(remoteTableName);
			
			if (localTable != null) {
				// Getting all the rows
				Statement st = getDbmsConnection().createStatement();
				ResultSet rowsRS = st.executeQuery("SELECT * FROM " + 
						remoteTableName);
				
				// Insert them locally if they not exist
				ArrayList<Attribute> attrs = localTable.getAttributes();
				ArrayList<Datum> data;
				Row newRow = null;
				
				while (rowsRS.next()) {
					data = new ArrayList<Datum>();
					int numColumns = rowsRS.getMetaData().getColumnCount();
			        for ( int col = 1 ; col <= numColumns ; col++ ) {
			        	String dataValue = String.valueOf(rowsRS.getObject(col));
			        	
			        	// If it is not a number, add quotations marks
			        	if (!dataValue.matches(NUMBER_REGEXP)) {
			        		dataValue = "'" + dataValue + "'";
			        	}
			        	
			        	data.add(new Datum(dataValue));
			        }
			        newRow = new Row(attrs, data);
			        localTable.addRow(newRow);
				}
			}
		}
		tablesResultSet.beforeFirst();
	}
	
	private void insertLocalTablesRowsToDbms() throws SQLException {
		Table auxTable;
		Row auxRow;
		Datum auxDatum;
		Statement st = getDbmsConnection().createStatement();
		String insertRowStatement = "";
		
		// FOR EACH TABLE
		for (int table = 0; table < database.getTables().size(); table++) {
			auxTable = database.getTables().get(table);
			
			// FOR EACH ROW
			for (int row = 0; row < auxTable.getRows().size(); row++) {
				// INSERT IF NOT EXISTS
				insertRowStatement = "INSERT INTO " + auxTable.getName() + " SELECT ";
				auxRow = auxTable.getRows().get(row);
				
				// FOR EACH COLUMN
				for (int col = 0; col < auxRow.getData().size(); col++) {
					auxDatum = auxRow.getData().get(col);
					insertRowStatement += auxDatum.getStringValue();
					
					// Add comma or bracket
					if (col < auxRow.getData().size() - 1) {
						insertRowStatement += ", ";
					}
				}
				
				insertRowStatement += " WHERE NOT EXISTS (SELECT 1 FROM " + auxTable.getName();
				insertRowStatement += " WHERE ";
				
				// FOR EACH COLUMN
				if (auxRow.getData().size() == auxRow.getTableAttributes().size()) {
					for (int col = 0; col < auxRow.getData().size(); col++) {
						auxDatum = auxRow.getData().get(col);
						String attrName = auxRow.getTableAttributes().get(col).getName();
						
						insertRowStatement += attrName + " = " + auxDatum.getStringValue();
						if (col < auxRow.getData().size() - 1) {
							insertRowStatement += " and ";
						} else {
							insertRowStatement += ");";
						}
					}
				}
				
				st.executeUpdate(insertRowStatement);				
			}
		}
	}
	
	/**
	 * Deletes all rows for each table in the application.
	 */
	private void deleteLocalTablesContents() {
		for (int i = 0; i < database.getTables().size(); i++) {
			database.getTables().get(i).setRows(new ArrayList<Row>());
		}
	}
	
	/**
	 * Estrategia de sincronización:
	 *  1. Pasar las filas de la aplicación al SG.
	 *  2. Borrar todas las fillas de cada tabla en la aplicación.
	 *  3. Pasar todas las filas del SG a las tablas de la aplicación.
	 */
	private void syncContents() {
		try {
			insertLocalTablesRowsToDbms();
			deleteLocalTablesContents();
			insertDbmsRowsToLocalTable();
		} 
		
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Database getDatabase() {
		return database;
	}

	public void setDatabase(Database database) {
		this.database = database;
	}

	public Connection getDbmsConnection() {
		return dbmsConnection;
	}

	public void setDbmsConnection(Connection dbmsConnection) {
		this.dbmsConnection = dbmsConnection;
	}

	public ArrayList<String> getQueriesForUpdate() {
		return queriesForUpdate;
	}

	public void setQueriesForUpdate(ArrayList<String> queriesForUpdate) {
		this.queriesForUpdate = queriesForUpdate;
	}
}
