package es.ull.etsii.jitrax.adt;

public class Attribute {

	private String name;
	private DataType dataType;
	
	public Attribute(String aName, DataType aDataType) {
		name = aName;
		dataType = aDataType;
	}
	
	public boolean equals(Object object) {
		if (object != null && object instanceof Attribute) {
			Attribute anotherAttr = (Attribute) object;
			
			// Comparing names and domains (data types)
			if (this.getName().equalsIgnoreCase(anotherAttr.getName())) {
				if (this.getDataType() == anotherAttr.getDataType()) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	public int hashCode() {
		return getName().hashCode() * getDataType().hashCode();
	}
	
	public String toString() {
		String toString = "";	
		toString += getName() + " (" + getDataType() + ")";
	
		return toString;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public DataType getDataType() {
		return dataType;
	}

	public void setDataType(DataType dataType) {
		this.dataType = dataType;
	}
}
