package es.ull.etsii.jitrax.adt;

import java.util.ArrayList;
import java.util.UUID;

import es.ull.etsii.jitrax.database.PostgreDriver;
import es.ull.etsii.jitrax.exceptions.DuplicateTableException;

public class Database {

	private String name;
	private ArrayList<Table> tables;
	private PostgreDriver postgreDriver;
	
	/**
	 * @param name name for the database.
	 */
	public Database(String aName) {
		name = aName;
		tables = new ArrayList<Table>();
	}
	
	public Database(String aName, ArrayList<Table> tableList) {
		name = aName;
		tables = tableList;
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
		
		toString += "DATABASE " + getName() + ";\n";
		
		for (int i = 0; i < getTables().size(); i++) {
			toString += "\nTABLE " + getTables().get(i).getName() + " (";
			
			// Attributes with domains
			for (int j = 0; j < getTables().get(i).getAttributes().size(); j++) {
				toString += getTables().get(i).getAttributes().get(j).getName() + ": " +
						getTables().get(i).getAttributes().get(j).getDataType();
				
				// Add PK label
				if (getTables().get(i).getAttributes().get(j).isPrimaryKey()) {
					toString += ", PK";
				}
				
				// Add semicolon
				if (j < getTables().get(i).getAttributes().size() - 1) {
					toString += ";\n";
				} 
				
				else {
					toString += ")\n";
				}
			}
			
			toString += "=>\n";
			
			// Rows
			for (int j = 0; j < getTables().get(i).getRows().size(); j++) {
				toString += "(";
				for (int k = 0; k < getTables().get(i).getRows().get(j).size(); k++) {
					toString += getTables().get(i).getRows().get(j).getData().get(k).getStringValue();
					
					if (k < getTables().get(i).getRows().get(j).size() - 1) {
						toString += ",";
					}
					
					else {
						toString += ");\n";
					}
				}
			}
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

	public PostgreDriver getPostgreDriver() {
		return postgreDriver;
	}

	public void setPostgreDriver(PostgreDriver postgreDriver) {
		this.postgreDriver = postgreDriver;
	}
}
