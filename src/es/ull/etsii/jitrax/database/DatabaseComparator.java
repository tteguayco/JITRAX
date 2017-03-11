package es.ull.etsii.jitrax.database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import es.ull.etsii.jitrax.adt.Attribute;
import es.ull.etsii.jitrax.adt.DataType;
import es.ull.etsii.jitrax.adt.Database;
import es.ull.etsii.jitrax.adt.Table;

/**
 * Compares a Database object with a database in a DBMS
 * (it checks whether they have the same attributes, domains, etc).
 */
public class DatabaseComparator {
	
	private Database database;
	private Connection dbmsConnection;
	
	public DatabaseComparator(Database aDatabase, Connection aDbmsConnection) {
		database = aDatabase;
		dbmsConnection = aDbmsConnection;
	}

	public boolean databasesAreCompatible() {
		
		try {
			DatabaseMetaData meta = getDbmsConnection().getMetaData();
			ResultSet tablesResultSet = meta.getTables(null, null, null, new String[] {"TABLE"});
			
			// Getting tables on DBMS
			ArrayList<String> dbmsTables = new ArrayList<String>();
			HashMap<String, ArrayList<Attribute>> attributes = new HashMap<String, ArrayList<Attribute>>();
			
			while (tablesResultSet.next()) {
				// Getting tables
				String tableName = tablesResultSet.getString("TABLE_NAME");
				dbmsTables.add(tableName.toLowerCase());
				Table currentLocalTable = getDatabase().getTableByName(tableName);
				int numberOfAttributesForRemote = 0;
				
				// Getting attributes
				ResultSet attrResultSet = meta.getColumns(null, null, tableName, "%");
				
				// Getting the number of rows returned (number of attributes in the current table)
				if (attrResultSet != null)   
				{  
				  attrResultSet.beforeFirst();  
				  attrResultSet.last();  
				  numberOfAttributesForRemote = attrResultSet.getRow();
				  attrResultSet.beforeFirst();
				}
				
				// If the number of attributes differs, exit
				if (currentLocalTable.getNumOfColumns() != numberOfAttributesForRemote) {
					return false;
				}
				
				// COMPARING ATTRIBUTES
				while (attrResultSet.next()) {
					String attrName = attrResultSet.getString("COLUMN_NAME");
					String attrType = attrResultSet.getString("TYPE_NAME");
					DataType attrDataType;
					boolean primaryKey = false;
					
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
						attrDataType = DataType.STRING;
					}
					
					// TODO check if the attribute is primary key
					if (!currentLocalTable.attributeExists(attrName, attrDataType, primaryKey)) {
						//System.out.println(attrName);
						System.out.println(attrDataType);
						return false;
					}
				}
			}
			
			// COMPARING TABLES (it does not matter if there are more tables in the DBMS;
			// all of the tables of the locale database have to be in the DBMS)
			for (int i = 0; i < getDatabase().getNumOfTables(); i++) {
				String localTable = getDatabase().getTables().get(i).getName().toLowerCase();
				if (!dbmsTables.contains(localTable)) {
					return false;
				}
			}
			
			// COMPARING ROWS
			
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return true;
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
}
