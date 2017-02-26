package es.ull.etsii.jitrax.adt;

import java.util.ArrayList;
import java.util.UUID;

import es.ull.etsii.jitrax.database.PostgreDriver;
import es.ull.etsii.jitrax.exceptions.DuplicateTableException;

public class Database {

	private String name;
	private ArrayList<Table> tables;
	private String uniqueID;
	private PostgreDriver postgreDriver;
	
	/**
	 * @param name name for the database.
	 */
	public Database(String aName) {
		name = aName;
		tables = new ArrayList<Table>();
		uniqueID = UUID.randomUUID().toString();
	}
	
	public Database(String aName, ArrayList<Table> tableList) {
		name = aName;
		tables = tableList;
		uniqueID = UUID.randomUUID().toString();
	}
	
	public void addTable(Table newTable) throws DuplicateTableException {
		getTables().add(newTable);
	}
	
	public String[] getTablesNames() {
		String[] tablesNames = new String[getTables().size()];
		
		for (int i = 0; i < getTables().size(); i++) {
			tablesNames[i] = getTables().get(i).getName();
		}
		
		return tablesNames;
	}
	
	public String toString() {
		String toString = "";
		
		toString += "DATABASE " + getName() + "\n";
		toString += "UniqueIDE " + getUniqueID() + "\n\n";
		
		for (int i = 0; i < getTables().size(); i++) {
			toString += getTables().get(i).getName() + " (";
			
			// Attributes with domains
			for (int j = 0; j < getTables().get(i).getAttributes().size(); j++) {
				toString += getTables().get(i).getAttributes().get(j).getName() + ": " +
						getTables().get(i).getAttributes().get(j).getDataType() + ", ";
			}
			
			toString += ")\n => \n";
			
			// Rows
			toString += "(";
			for (int j = 0; j < getTables().get(i).getRows().size(); j++) {
				for (int k = 0; k < getTables().get(i).getRows().get(j).size(); k++) {
					toString += getTables().get(i).getRows().get(j).getData().get(k).getStringValue() + ", ";
				}
			}
			
			toString += ")\n\n";
		}
		
		return toString;
	}
	
	/**
	 * Returns the number of tables the DB has.
	 * @return
	 */
	public int getNumOfTables() {
		return getTables().size();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Table> getTables() {
		return tables;
	}

	public void setTables(ArrayList<Table> tables) {
		this.tables = tables;
	}

	public String getUniqueID() {
		return uniqueID;
	}

	public void setUniqueID(String uniqueID) {
		this.uniqueID = uniqueID;
	}

	public PostgreDriver getPostgreDriver() {
		return postgreDriver;
	}

	public void setPostgreDriver(PostgreDriver postgreDriver) {
		this.postgreDriver = postgreDriver;
	}
}
