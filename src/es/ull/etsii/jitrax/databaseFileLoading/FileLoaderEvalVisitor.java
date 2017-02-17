package es.ull.etsii.jitrax.databaseFileLoading;

import es.ull.etsii.jitrax.adt.Database;
import es.ull.etsii.jitrax.adt.Datum;
import es.ull.etsii.jitrax.adt.Attribute;
import es.ull.etsii.jitrax.adt.Row;
import es.ull.etsii.jitrax.adt.Table;
import es.ull.etsii.jitrax.adt.DataType;
import es.ull.etsii.jitrax.exceptions.DuplicatePrimaryKeyException;
import es.ull.etsii.jitrax.exceptions.DuplicateTableException;

import java.util.ArrayList;

/**
 * This class allows to analyze semantically a expression which describes
 * a database specification (using a DSL). It has to be syntactically correct.
 * @author teguayco
 */
public class FileLoaderEvalVisitor extends DatabaseBaseVisitor<Object> {

	private Database database;
	private ArrayList<Attribute> auxAttributeList;
	
	public Object visitDatabaseCreation(DatabaseParser.DatabaseCreationContext ctx) {
		String databaseName = ctx.IDENTIFIER().getText();
		database = new Database(databaseName);
		
		// We have to visit each table
		for (int i = 0; i < ctx.table().size(); i++) {
			try {
				database.addTable((Table) visit(ctx.table(i)));
			} catch (DuplicateTableException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return database;
	}
	
	public Object visitTableCreation(DatabaseParser.TableCreationContext ctx) {
		String tableName = ctx.IDENTIFIER().getText();
		ArrayList<Attribute> attrList = (ArrayList<Attribute>) visit(ctx.attrlist());
		Table newTable = new Table(tableName, attrList);
		
		for (int i = 0; i < ctx.datalist().size(); i++) {
			ArrayList<Datum> data = (ArrayList<Datum>) visit(ctx.datalist(i)); 
			Row newRow = new Row(attrList, data);
			
			try {
				newTable.addRow(newRow);
			} catch (DuplicatePrimaryKeyException e) {
				System.out.println("Provisional: tabla duplicada");
				e.printStackTrace();
			}
		}
	
		return newTable;
	}
	
	public Object visitSingleAttribute(DatabaseParser.SingleAttributeContext ctx) {
		ArrayList<Attribute> singleAttr = new ArrayList<Attribute>();
		singleAttr.add((Attribute) visit(ctx.attribute()));
		return singleAttr;
	}
	
	public Object visitAttributeList(DatabaseParser.AttributeListContext ctx) {
		Attribute firstAttribute = (Attribute) visit(ctx.attribute());
		ArrayList<Attribute> attrList = new ArrayList<Attribute>();
		attrList.addAll((ArrayList<Attribute>) visit(ctx.attrlist()));
		attrList.add(0, firstAttribute);
		
		return attrList;
	}
	
	public Object visitSingleDatum(DatabaseParser.SingleDatumContext ctx) {
		String datumName = ctx.datum().getText();
		ArrayList<Datum> singleDatum = new ArrayList<Datum>();
		singleDatum.add(new Datum(datumName, DataType.STRING));
		
		return singleDatum;
	}
	
	public Object visitDataList(DatabaseParser.DataListContext ctx) {
		Datum firstDatum = (Datum) visit(ctx.datum());
		ArrayList<Datum> dataList = new ArrayList<Datum>();
		dataList.addAll((ArrayList<Datum>) visit(ctx.datalist()));
		dataList.add(0, firstDatum);
		
		return dataList;
	}
	
	public Object visitAttributeValue(DatabaseParser.AttributeValueContext ctx) {
		String attrName = ctx.IDENTIFIER().getText();
		String dataTypeString = (String) visit(ctx.datatype());
		DataType dataType = null;
		boolean primaryKey = false;
		
		if (dataTypeString.equals("string")) {
			dataType = DataType.STRING;
		} else if (dataTypeString.equals("char")) {
			dataType = DataType.CHAR;
		} else if (dataTypeString.equals("int")) {
			dataType = DataType.INT;
		} else if (dataTypeString.equals("float")) {
			dataType = DataType.FLOAT;
		} else if (dataTypeString.equals("date")) {
			dataType = DataType.DATE;
		} else { // Should never happen
			dataType = DataType.STRING;
		}
		
		// PrimaryKey?
		if (ctx.PK() != null) {
			primaryKey = true;
		}
		
		Attribute attribute = new Attribute(attrName, primaryKey, dataType);
		return attribute;
	}
	
	public Object visitStringValue(DatabaseParser.StringValueContext ctx) {
		return (String) "string";
	}
	
	public Object visitCharValue(DatabaseParser.CharValueContext ctx) {
		return (String) "char";
	}
	
	public Object visitIntegerValue(DatabaseParser.IntegerValueContext ctx) {
		return (String) "int";
	}
	
	public Object visitFloatValue(DatabaseParser.FloatValueContext ctx) {
		return (String) "float";
	}
	
	public Object visitDateValue(DatabaseParser.DateValueContext ctx) {
		return (String) "date";
	}
}
