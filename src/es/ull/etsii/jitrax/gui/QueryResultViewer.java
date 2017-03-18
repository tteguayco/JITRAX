package es.ull.etsii.jitrax.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class QueryResultViewer extends JPanel {
	private static final int COL_MIN_WIDTH = 150;
	private static String EMPTY_RESULT_MSG = "Empty relation as a result.";
	
	private ResultSet resultSet;
	private JTable graphicTable;
	private DefaultTableModel tableModel;
	private JLabel emptyResultLabel;
	private JPanel mainContainer;
	private JScrollPane tableSP;
	
	public QueryResultViewer() {
		resultSet = null;
		graphicTable = new JTable();
		tableModel = new DefaultTableModel();
		emptyResultLabel = new JLabel(EMPTY_RESULT_MSG);
		mainContainer = new JPanel();
		
		graphicTable.setModel(tableModel);
		
		setLayout(new BorderLayout());
		tableSP = new JScrollPane(graphicTable,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		tableSP.setBorder(BorderFactory.createEmptyBorder());
		
		graphicTable.setFillsViewportHeight(false);
	
		graphicTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		graphicTable.setEnabled(false);
		
		mainContainer.add(tableSP);
		setLayout(new GridLayout(1,1));
		add(tableSP);
	}
	
	/**
	 * Sets a minimum width for all table's columns.
	 */
	private void setMinColumnsWidth() {
		for (int i = 0; i < graphicTable.getColumnModel().getColumnCount(); i++) {
			graphicTable.getColumnModel().getColumn(i).setMinWidth(COL_MIN_WIDTH);
		}
	}
	
	public void updateTableData(ResultSet resultSet) throws SQLException {
		int numColumns = resultSet.getMetaData().getColumnCount();
		boolean columnNamesAreFilled = false;
		
		ArrayList<String> columnNames = new ArrayList<String>();
		ArrayList<String[]> rowsData = new ArrayList<String[]>();
		
		while (resultSet.next()) {
			String[] rowData = new String[numColumns];
			for (int i = 1 ; i <= numColumns ; i++) {
				if (!columnNamesAreFilled) {
					columnNames.add(resultSet.getMetaData().getColumnName(i));
				}
				rowData[i-1] = String.valueOf(resultSet.getObject(i));
	        }
			
			rowsData.add(rowData);
			columnNamesAreFilled = true;
		}
		
		String[] columnNamesAsArray = columnNames.toArray(new String[columnNames.size()]);
		String[][] rowsDataAsArray = new String[rowsData.size()][numColumns];
		
		for (int i = 0; i < rowsData.size(); i++) {
			for (int j = 0; j < rowsData.get(i).length; j++) {
				rowsDataAsArray[i][j] = (String) rowsData.get(i)[j];
			}
		}
		
		tableModel.setDataVector(rowsDataAsArray, columnNamesAsArray);
		tableModel.fireTableDataChanged();
		setMinColumnsWidth();
		
		if (tableModel.getColumnCount() <= 0) {
			System.out.println("> " + EMPTY_RESULT_MSG);
		}
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
