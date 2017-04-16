package es.ull.etsii.jitrax.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
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

public class QueryResultViewer extends GraphicTable {
	private static final int COL_MIN_WIDTH = 100;
	private static String EMPTY_RESULT_MSG = "Empty relation as a result.";
	
	private ResultSet resultSet;
	private DefaultTableModel tableModel;
	private JLabel emptyResultLabel;
	private JPanel mainContainer;
	private JScrollPane tableSP;
	
	public QueryResultViewer() {
		resultSet = null;
		tableModel = new DefaultTableModel();
		emptyResultLabel = new JLabel(EMPTY_RESULT_MSG);
		mainContainer = new JPanel();
		
		setLayout(new BorderLayout());
		tableSP = new JScrollPane(graphicTable,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		tableSP.setBorder(BorderFactory.createEmptyBorder());
		
		graphicTable.setModel(tableModel);
		graphicTable.setFillsViewportHeight(true);
		graphicTable.setEnabled(false);
		
		addComponentListener(new ComponentAdapter() {
		    public void componentResized(ComponentEvent e) {
		        resizeColumnWidth(COL_MIN_WIDTH);          
		    }
		});
		
		mainContainer.add(tableSP);
		setLayout(new GridLayout(1,1));
		add(tableSP);
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
					String columnName = resultSet.getMetaData().getColumnName(i);
					
					// Append tableName if exists
					String tableName = resultSet.getMetaData().getTableName(i);
					tableName.trim();
					if (!tableName.equals("")) {
						columnName = tableName + "." + columnName;
					}
					
					columnNames.add(columnName);
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
		resizeColumnWidth(COL_MIN_WIDTH);
		
		if (tableModel.getColumnCount() <= 0) {
			System.out.println("\n> " + EMPTY_RESULT_MSG);
		}
		
		revalidate();
		repaint();
	}
	
	public boolean isEmpty() {
		if (tableModel.getColumnCount() <= 0) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * Returns the content of the this result table viewer 
	 * as CSV (Comma Separated Values).
	 * @return
	 */
	public String toCSV() {
		String csv = "";
		
		// Columns names
		for (int i = 0; i < tableModel.getColumnCount(); i++) {
			csv += tableModel.getColumnName(i);
			
			// Add comma
			if (i < tableModel.getColumnCount() - 1) {
				csv += ", ";
			} else {
				csv += "\n";
			}
		}
		
		// Rows
		for (int i = 0; i < tableModel.getRowCount(); i++) {
			for (int j = 0; j < tableModel.getColumnCount(); j++) {
				csv += (String) tableModel.getValueAt(i, j);
				
				// Add comma
				if (j < tableModel.getColumnCount() - 1) {
					csv += ", ";
				} else {
					csv += "\n";
				}
			}
		}
		
		return csv;
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
