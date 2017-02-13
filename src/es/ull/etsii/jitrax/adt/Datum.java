package es.ull.etsii.jitrax.adt;

/**
 * Represents a specific data of a table's row.
 * @param <T>
 */
public class Datum {
	private String stringValue;
	private Attribute attachedAttribute;
	
	public Datum(Attribute anAttribute, String aValue) {
		stringValue = aValue;
		attachedAttribute = anAttribute;
	}

	public String getStringValue() {
		return stringValue;
	}

	public void setStringValue(String stringValue) {
		this.stringValue = stringValue;
	}

	public Attribute getAttachedAttribute() {
		return attachedAttribute;
	}

	public void setAttachedAttribute(Attribute attachedAttribute) {
		this.attachedAttribute = attachedAttribute;
	}
}
