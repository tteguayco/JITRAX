package es.ull.etsii.jitrax.adt;

import java.sql.ResultSet;

import org.antlr.v4.gui.TreeViewer;

public class Query {

	private String name;
	private String relationalAlgebraExpr;
	private String sqlTranslation;
	private TreeViewer treeViewer;
	private ResultSet resultSet;
	
	public Query(String aName) {
		name = aName;
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

	public ResultSet getResultSet() {
		return resultSet;
	}

	public void setResultSet(ResultSet resultSet) {
		this.resultSet = resultSet;
	}
}
