package es.ull.etsii.jitrax.database;

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
