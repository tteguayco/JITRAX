package es.ull.etsii.jitrax.databaseFileLoading;

import es.ull.etsii.jitrax.adt.Database;
import es.ull.etsii.jitrax.adt.Datum;
import es.ull.etsii.jitrax.adt.Row;
import es.ull.etsii.jitrax.adt.Table;
import es.ull.etsii.jitrax.exceptions.DuplicatePrimaryKeyException;
import es.ull.etsii.jitrax.exceptions.DuplicateTableException;

import java.util.ArrayList;

import es.ull.etsii.jitrax.adt.Attribute;
import es.ull.etsii.jitrax.adt.DataType;

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
		Attribute attribute = new Attribute(attrName, DataType.STRING);
		return attribute;
	}
}
