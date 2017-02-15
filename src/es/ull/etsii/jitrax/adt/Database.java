package es.ull.etsii.jitrax.adt;

import java.util.ArrayList;
import java.util.UUID;

import es.ull.etsii.jitrax.exceptions.DuplicateTableException;

public class Database {

	private String name;
	private ArrayList<Table> tables;
	private String uniqueID;
	
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
	
	/**
	 * Returns the number of tables the DB has.
	 * @return
	 */
	public int getSize() {
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
}
