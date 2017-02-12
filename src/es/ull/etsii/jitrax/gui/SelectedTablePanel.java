package es.ull.etsii.jitrax.gui;

import java.util.ArrayList;

import javax.swing.JPanel;

import es.ull.etsii.jitrax.adt.Attribute;
import es.ull.etsii.jitrax.adt.Datum;
import es.ull.etsii.jitrax.adt.Row;
import es.ull.etsii.jitrax.adt.Table;

public class SelectedTablePanel extends JPanel {

	private Table table;
	
	public SelectedTablePanel(Table aTable) {
		table = aTable;
		createGraphicTable();
	}
	
	/**
	 * Creates a customized JTable with the table's information.
	 */
	private void createGraphicTable() {
		
	}
	
	/**
	 * Gets the names to be printed in the graphical table.
	 * @return
	 */
	private String[] getColumnNames() {
		ArrayList<Attribute> attributes = getTable().getAttributes();
		String[] columnNames = new String[attributes.size()];
		
		for (int i = 0; i < columnNames.length; i++) {
			columnNames[i] = attributes.get(i).getName();
		}
		
		return columnNames;
	}
	
	/**
	 * Returns the rows of a table in terms of a matrix of data.
	 * @return
	 */
	/*private Datum[][] getTableRows() {
		ArrayList<Row> rows = getTable().getRows();
		Datum[][] tableRowsData = new Datum[rows.size()][getTable().getNumOfColumns()];
		
		for (int i = 0; i < rows.size(); i++) {
			
		}
		
		
	}*/

	public Table getTable() {
		return table;
	}

	public void setTable(Table table) {
		this.table = table;
	}
}
