package es.ull.etsii.jitrax.adt;

import java.util.ArrayList;
import java.util.HashMap;

import es.ull.etsii.jitrax.exceptions.DuplicatePrimaryKeyException;

public class Table {
	private String name;
	private ArrayList<Attribute> attributes;
	private HashMap<String, Integer> attributesNames;
	private ArrayList<Row> rows;
	
	public Table(String aName, ArrayList<Attribute> attrList) {
		name = aName;
		attributes = attrList;
		attributesNames = new HashMap<String, Integer>();
		rows = new ArrayList<Row>();
	}

	/**
	 * Returns true if an attribute already exists.
	 * @param anAttribute
	 * @return
	 */
	private boolean attributeExists(String attributeName) {
		if (getAttributesNames().containsKey(attributeName)) {
			return true;
		} else {
			return false;
		}
	}
	
	public String[] getColumnsNames() {
		String[] columnNames = new String[getAttributes().size()];
		
		for (int i = 0; i < getAttributes().size(); i++) {
			columnNames[i] = getAttributes().get(i).getName();
		}
		
		return columnNames;
	}
	
	public String[][] getRowsData() {
		String[][] rowsData = new String[getRows().size()][getAttributes().size()];
		
		for (int i = 0; i < getRows().size(); i++) {
			for (int j = 0; j < getRows().get(i).size(); j++) {
				rowsData[i][j] = getRows().get(i).getData().get(j).getStringValue();
			}
		}
		
		return rowsData;
	}
	
	/**
	 * The size of a table will be its number of attributes.
	 * @return
	 */
	public int getNumOfColumns() {
		return getAttributes().size();
	}
	
	/**
	 * Adds a new row or tuple to this table.
	 * @return
	 */
	public void addRow(ArrayList<Datum> newRowData) throws DuplicatePrimaryKeyException {
		/**
		 * PROVISIONAL
		 */
		
		// Si no existe la clave primera, insertar...
		Row newRow = new Row(getAttributes(), newRowData);
		getRows().add(newRow);
	}
	
	/**
	 * Returns true if the specified set of values already
	 * exists as a primary key.
	 * @return
	 */
	/*private boolean primaryKeyExists(ArrayList<String> values) {
		for (int i = 0; i < getRows().size(); i++) {
			
		}
	}*/
	
	/**
	 * Adds a new attribute to the table. Returns false if couldn't do it
	 * because the attribute already exists.
	 * @param attributeName
	 * @param attributeDatatype
	 * @return
	 */
	public boolean addAttribute(String attributeName, boolean primaryKey, DataType attributeDatatype) {
		if (!attributeExists(attributeName)) {
			Attribute newAttribute = new Attribute(attributeName, primaryKey, attributeDatatype);
			getAttributes().add(newAttribute);
			return true;
			
		} else {
			return false;
		}
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Attribute> getAttributes() {
		return attributes;
	}

	public void setAttributes(ArrayList<Attribute> attributes) {
		this.attributes = attributes;
	}

	public HashMap<String, Integer> getAttributesNames() {
		return attributesNames;
	}

	public void setAttributesNames(HashMap<String, Integer> attributesNames) {
		this.attributesNames = attributesNames;
	}

	public ArrayList<Row> getRows() {
		return rows;
	}

	public void setRows(ArrayList<Row> rows) {
		this.rows = rows;
	}
}