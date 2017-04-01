package es.ull.etsii.jitrax.adt;

import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import org.antlr.v4.gui.TreeViewer;

public class Query {

	private String name;
	private String relationalAlgebraExpr;
	private String sqlTranslation;
	private TreeViewer treeViewer;
	
	// Result query
	private Vector<String> resultSetData;
	private Vector<String> resultSetColumns;
	
	public Query(String aName) {
		name = aName;
	}

	public void updateResultSetDataFromTableModel(DefaultTableModel aTableModel) {
		resultSetData = new Vector(aTableModel.getDataVector());
		resultSetColumns = new Vector<String>();
		// Get columns names
		for (int i = 0; i < aTableModel.getColumnCount(); i++) {
			resultSetColumns.add(aTableModel.getColumnName(i));
		}
	}
	
	public String toString() {
		return getName();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRelationalAlgebraExpr() {
		return relationalAlgebraExpr;
	}

	public void setRelationalAlgebraExpr(String relationalAlgebraExpr) {
		this.relationalAlgebraExpr = relationalAlgebraExpr;
	}

	public String getSqlTranslation() {
		return sqlTranslation;
	}

	public void setSqlTranslation(String sqlTranslation) {
		this.sqlTranslation = sqlTranslation;
	}

	public TreeViewer getTreeViewer() {
		return treeViewer;
	}

	public void setTreeViewer(TreeViewer treeViewer) {
		this.treeViewer = treeViewer;
	}

	public Vector getResultSetData() {
		return resultSetData;
	}

	public void setResultSetData(Vector resultSetData) {
		this.resultSetData = resultSetData;
	}

	public Vector getResultSetColumns() {
		return resultSetColumns;
	}

	public void setResultSetColumns(Vector resultSetColumns) {
		this.resultSetColumns = resultSetColumns;
	}
}
