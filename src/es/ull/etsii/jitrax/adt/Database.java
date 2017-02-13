package es.ull.etsii.jitrax.adt;

import java.util.ArrayList;

import es.ull.etsii.jitrax.exceptions.DuplicateTableException;

public class Database {

	private String name;
	private ArrayList<Table> tables;
	
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
}
