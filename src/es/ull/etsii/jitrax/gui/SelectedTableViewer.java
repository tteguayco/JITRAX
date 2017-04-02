package es.ull.etsii.jitrax.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Arrays;

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

public class SelectedTableViewer extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private static final int MINIMUM_WIDTH = 290;
	private static final int MINIMUM_HEIGHT = 130;
	private static final int MAXIMUM_WIDTH = 290;
	private static final int MAXIMUM_HEIGHT = 130;
	private static final int ODD_ROW_R = 220;
	private static final int ODD_ROW_G = 220;
	private static final int ODD_ROW_B = 220;
	private static final int COL_MIN_WIDTH = 100;
	
	private Table table;
	private JTable graphicTable;
	private DefaultTableModel tableModel;
	
	public SelectedTableViewer() {
		table = null;
		initializeGuiComponents();
		buildGraphicTable();
	}
	
	public SelectedTableViewer(Table aTable) {
		table = aTable;
		initializeGuiComponents();
		buildGraphicTable();
	}
	
	private void initializeGuiComponents() {
		graphicTable = new JTable();
		tableModel = new DefaultTableModel();
		graphicTable.setModel(tableModel);
	}
	
	/**
	 * Creates a customized JTable with the table's information.
	 */
	private void buildGraphicTable() {
		// Mark odd rows with a different color
		markOddRows();
		
		setLayout(new BorderLayout());
		graphicTable.setEnabled(false);
		graphicTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		graphicTable.setMinimumSize(graphicTable.getPreferredScrollableViewportSize());
		//graphicTable.setPreferredScrollableViewportSize(graphicTable.getPreferredSize());
		graphicTable.setFillsViewportHeight(true);
		
		JScrollPane tableSP = new JScrollPane(graphicTable);
		tableSP.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		tableSP.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		add(tableSP, BorderLayout.CENTER);
		tableSP.setPreferredSize(new Dimension(MINIMUM_WIDTH, MINIMUM_HEIGHT));
		setMinimumSize(new Dimension(MINIMUM_WIDTH, MINIMUM_HEIGHT));
		setMaximumSize(new Dimension(MAXIMUM_WIDTH, MAXIMUM_HEIGHT));
	}
	
	public void updateTable(Table aTable) {
		table = aTable;
		tableModel.setDataVector(aTable.getRowsData(), aTable.getColumnsNames());
		tableModel.fireTableDataChanged();
		updateTitle();
		setMinColumnsWidth();
	}
	
	/**
	 * Sets a minimum width for all table's columns.
	 */
	private void setMinColumnsWidth() {
		for (int i = 0; i < graphicTable.getColumnModel().getColumnCount(); i++) {
			graphicTable.getColumnModel().getColumn(i).setMinWidth(COL_MIN_WIDTH);
		}
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

	public DefaultTableModel getTableModel() {
		return tableModel;
	}

	public void setTableModel(DefaultTableModel tableModel) {
		this.tableModel = tableModel;
	}
}
