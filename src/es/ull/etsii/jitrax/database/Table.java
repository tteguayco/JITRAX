package es.ull.etsii.jitrax.database;

import java.util.ArrayList;
import java.util.HashMap;

public class Table {
	private String name;
	private ArrayList<Attribute> attributes;
	private HashMap<String, Integer> attributesNames;
	
	public Table(String aName) {
		name = aName;
		attributes = new ArrayList<Attribute>();
		attributesNames = new HashMap<String, Integer>();
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
}