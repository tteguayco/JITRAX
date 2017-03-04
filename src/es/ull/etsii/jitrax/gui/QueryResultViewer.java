package es.ull.etsii.jitrax.gui;

import java.sql.ResultSet;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class QueryResultViewer extends JPanel {

	private ResultSet resultSet;
	private JTable graphicTable;
	private DefaultTableModel tableModel;
	
	public QueryResultViewer() {
		resultSet = null;
		graphicTable = new JTable();
		tableModel = new DefaultTableModel();
		
		graphicTable.setModel(tableModel);
	}

	public ResultSet getResultSet() {
		return resultSet;
	}

	public void setResultSet(ResultSet resultSet) {
		this.resultSet = resultSet;
	}

	public JTable getGraphicTable() {
		return graphicTable;
	}

	public void setGraphicTable(JTable graphicTable) {
		this.graphicTable = graphicTable;
	}

	public DefaultTableModel getTableModel() {
		return tableModel;
	}

	public void setTableModel(DefaultTableModel tableModel) {
		this.tableModel = tableModel;
	}
}
