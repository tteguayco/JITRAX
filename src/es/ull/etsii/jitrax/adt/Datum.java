package es.ull.etsii.jitrax.adt;

/**
 * Represents a specific data of a table's row.
 * @param <T>
 */
public class Datum<T> {

	private DataType dataType;
	private T value;
	private boolean isPrimaryKey;
	
	public Datum(DataType aDataType, T aValue, boolean primaryKey) {
		dataType = aDataType;
		value = aValue;
		isPrimaryKey = primaryKey;
	}

	public DataType getDataType() {
		return dataType;
	}

	public void setDataType(DataType dataType) {
		this.dataType = dataType;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public boolean isPrimaryKey() {
		return isPrimaryKey;
	}

	public void setPrimaryKey(boolean isPrimaryKey) {
		this.isPrimaryKey = isPrimaryKey;
	}
}
