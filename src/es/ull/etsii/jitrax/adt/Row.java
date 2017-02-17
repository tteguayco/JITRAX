package es.ull.etsii.jitrax.adt;

import java.util.ArrayList;

/**
 * Represents a row of a table.
 */
public class Row {
	
	private ArrayList<Attribute> tableAttributes;
	private ArrayList<Datum> data;
	
	public Row(ArrayList<Attribute> attributes, ArrayList<Datum> rowData) {
		tableAttributes = attributes;
		data = rowData;
	}

	/**
	 * The size of a row is its number of attributes or column.
	 * @return
	 */
	public int size() {
		return getData().size();
	}
	
	public ArrayList<Attribute> getTableAttributes() {
		return tableAttributes;
	}

	public void setTableAttributes(ArrayList<Attribute> tableAttributes) {
		this.tableAttributes = tableAttributes;
	}

	public ArrayList<Datum> getData() {
		return data;
	}

	public void setData(ArrayList<Datum> data) {
		this.data = data;
	}
}
