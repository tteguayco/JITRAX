package es.ull.etsii.jitrax.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

import es.ull.etsii.jitrax.adt.Attribute;
import es.ull.etsii.jitrax.adt.Datum;
import es.ull.etsii.jitrax.adt.Row;
import es.ull.etsii.jitrax.adt.Table;

public class SelectedTablePanel extends JPanel {
	private static final int MINIMUM_WIDTH = 250;
	private static final int MINIMUM_HEIGHT = 120;
	private static final int MAXIMUM_WIDTH = 250;
	private static final int MAXIMUM_HEIGHT = 120;
	
	private Table table;
	private JTable graphicTable;
	private JButton detailsButton;
	
	public SelectedTablePanel(Table aTable) {
		table = aTable;
		detailsButton = new JButton("DETAILS");
		createGraphicTable();
	}
	
	/**
	 * Creates a customized JTable with the table's information.
	 */
	private void createGraphicTable() {
		String[] columnNames = getColumnNames();
		String[][] rowsData = getTableRowsData();
		graphicTable = new JTable(rowsData, columnNames);
		
		setLayout(new BorderLayout());
		graphicTable.setEnabled(false);
		
		JPanel buttonsContainer = new JPanel();
		buttonsContainer.add(detailsButton);
		
		JScrollPane tableSP = new JScrollPane(graphicTable);
		tableSP.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		tableSP.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		add(tableSP, BorderLayout.CENTER);
		add(buttonsContainer, BorderLayout.SOUTH);
		
		setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),
                "Students",
                TitledBorder.CENTER,
                TitledBorder.TOP));
		
		tableSP.setPreferredSize(new Dimension(MINIMUM_WIDTH, MINIMUM_HEIGHT));
		setMinimumSize(new Dimension(MINIMUM_WIDTH, MINIMUM_HEIGHT));
		setMaximumSize(new Dimension(MAXIMUM_WIDTH, MAXIMUM_HEIGHT));
	}
	
	/**
	 * Gets the names to be printed in the columns of the graphical table.
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
	private String[][] getTableRowsData() {
		ArrayList<Row> rows = getTable().getRows();
		String[][] tableRowsData = new String[rows.size()][getTable().getNumOfColumns()];
		ArrayList<Datum> auxData;
		
		for (int i = 0; i < rows.size(); i++) {
			auxData = rows.get(i).getData();
			for (int j = 0; j < auxData.size(); j++) {
				tableRowsData[i][j] = auxData.get(j).getStringValue();
			}
		}
		
		return tableRowsData;
	}

	public Table getTable() {
		return table;
	}

	public void setTable(Table table) {
		this.table = table;
	}
}
