package es.ull.etsii.jitrax.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import es.ull.etsii.jitrax.adt.Attribute;
import es.ull.etsii.jitrax.adt.Datum;
import es.ull.etsii.jitrax.adt.Row;
import es.ull.etsii.jitrax.adt.Table;

public class SelectedTablePanelViewer extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private static final int MINIMUM_WIDTH = 270;
	private static final int MINIMUM_HEIGHT = 130;
	private static final int MAXIMUM_WIDTH = 270;
	private static final int MAXIMUM_HEIGHT = 130;
	private static final int ODD_ROW_R = 220;
	private static final int ODD_ROW_G = 220;
	private static final int ODD_ROW_B = 220;
	
	private Table table;
	private JTable graphicTable;
	private JButton detailsButton;
	private DefaultTableModel tableModel;
	
	public SelectedTablePanelViewer() {
		table = null;
		initializeGuiComponents();
	}
	
	public SelectedTablePanelViewer(Table aTable) {
		table = aTable;
		
		initializeGuiComponents();
		initializeTableModel();
		graphicTable.setModel(tableModel);
	}
	
	private void initializeGuiComponents() {
		graphicTable = new JTable();
		detailsButton = new JButton("DETAILS");
	}
	
	public void updateTable(Table aTable) {
		table = aTable;
		initializeTableModel();
		graphicTable.setModel(tableModel);
	}
	
	/**
	 * Creates a customized JTable with the table's information.
	 */
	private void initializeTableModel() {
		String[] columnNames = getColumnNames();
		String[][] rowsData = getTableRowsData();
		tableModel = new DefaultTableModel(rowsData, columnNames);
		
		// Mark odd rows with a different color
		markOddRows();
		
		setLayout(new BorderLayout());
		graphicTable.setEnabled(false);
		//graphicTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		graphicTable.setMinimumSize(graphicTable.getPreferredScrollableViewportSize());
		//graphicTable.setPreferredScrollableViewportSize(graphicTable.getPreferredSize());
		//graphicTable.setFillsViewportHeight(true);
		
		JPanel buttonsContainer = new JPanel();
		buttonsContainer.add(detailsButton);
		
		JScrollPane tableSP = new JScrollPane(graphicTable);
		tableSP.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		tableSP.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		add(tableSP, BorderLayout.CENTER);
		add(buttonsContainer, BorderLayout.SOUTH);
		
		updateTitle();
		
		tableSP.setPreferredSize(new Dimension(MINIMUM_WIDTH, MINIMUM_HEIGHT));
		setMinimumSize(new Dimension(MINIMUM_WIDTH, MINIMUM_HEIGHT));
		setMaximumSize(new Dimension(MAXIMUM_WIDTH, MAXIMUM_HEIGHT));
	}
	
	/**
	 * Alternates the rows' color in the graphic table.
	 */
	private void markOddRows() {
		UIDefaults defaults = UIManager.getLookAndFeelDefaults();
		if (defaults.get("Table.alternateRowColor") == null) {
		    defaults.put("Table.alternateRowColor", new Color(ODD_ROW_R, ODD_ROW_G, ODD_ROW_B));
		}
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

	public void updateTitle() {
		setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),
                getTable().getName(),
                TitledBorder.CENTER,
                TitledBorder.TOP));
	}
	
	public Table getTable() {
		return table;
	}

	public void setTable(Table table) {
		this.table = table;
	}

	public JTable getGraphicTable() {
		return graphicTable;
	}

	public void setGraphicTable(JTable graphicTable) {
		this.graphicTable = graphicTable;
	}

	public JButton getDetailsButton() {
		return detailsButton;
	}

	public void setDetailsButton(JButton detailsButton) {
		this.detailsButton = detailsButton;
	}

	public DefaultTableModel getTableModel() {
		return tableModel;
	}

	public void setTableModel(DefaultTableModel tableModel) {
		this.tableModel = tableModel;
	}
}
