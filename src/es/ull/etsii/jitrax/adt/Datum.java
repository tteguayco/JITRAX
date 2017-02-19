package es.ull.etsii.jitrax.adt;

/**
 * Represents a specific data of a table's row.
 */
public class Datum {
	private String stringValue;
	
	public Datum(String aValue) {
		stringValue = aValue;
	}
	
	public String toString() {
		String toString = "";
		toString += getStringValue();
		
		return toString;
	}
	
	public String getStringValue() {
		return stringValue;
	}

	public void setStringValue(String stringValue) {
		this.stringValue = stringValue;
	}
}
