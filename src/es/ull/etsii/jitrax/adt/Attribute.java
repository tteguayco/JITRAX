package es.ull.etsii.jitrax.adt;

public class Attribute {

	private String name;
	private boolean isPrimaryKey;
	private DataType dataType;
	
	public Attribute(String aName, boolean primaryKey, DataType aDataType) {
		name = aName;
		isPrimaryKey = primaryKey;
		dataType = aDataType;
	}

	public Attribute(String aName, DataType aDataType) {
		name = aName;
		isPrimaryKey = false;
		dataType = aDataType;
	}
	
	public boolean equals(Object object) {
		if (object != null && object instanceof Attribute) {
			Attribute anotherAttr = (Attribute) object;
			
			// Comparing names and domains (data types)
			if (this.getName().equalsIgnoreCase(anotherAttr.getName())) {
				if (this.getDataType() == anotherAttr.getDataType()) {
					System.out.println(this.getName() + " == " + anotherAttr.getName());
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
		
		toString += "(" + getName() + ": " + getDataType();
		
		if (isPrimaryKey()) {
			toString += ", PK)";
		} else {
			toString += ")";
		}
		
		return toString;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isPrimaryKey() {
		return isPrimaryKey;
	}

	public void setPrimaryKey(boolean isPrimaryKey) {
		this.isPrimaryKey = isPrimaryKey;
	}

	public DataType getDataType() {
		return dataType;
	}

	public void setDataType(DataType dataType) {
		this.dataType = dataType;
	}
}
