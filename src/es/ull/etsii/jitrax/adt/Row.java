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
	
	public boolean equals(Row anOther) {
		if (anOther.size() != this.size()) {
			return false;
		}
		
		// Comparing Data
		for (int i = 0; i < anOther.size(); i++) {
			if (!anOther.getDatum(i).equals(this.getDatum(i))) {
				return false;
			}
		}
		
		return true;
	}
	
	public Datum getDatum(int index) {
		return getData().get(index);
	}
	
	public String toString() {
		String toString = "";
		
		for (int i = 0; i < getData().size(); i++) {
			toString += getData().get(i).getStringValue() + ",";
		}
		
		return toString;
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
