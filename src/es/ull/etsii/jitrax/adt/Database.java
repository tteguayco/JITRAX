package es.ull.etsii.jitrax.adt;

import java.util.ArrayList;

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
