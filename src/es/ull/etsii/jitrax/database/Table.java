package es.ull.etsii.jitrax.database;

import java.util.ArrayList;

public class Table {
	private String name;
	private ArrayList<Attribute> attributes;
	
	public Table(String aName) {
		name = aName;
		attributes = new ArrayList<Attribute>();
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
}