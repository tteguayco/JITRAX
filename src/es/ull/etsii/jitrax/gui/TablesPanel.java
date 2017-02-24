package es.ull.etsii.jitrax.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Set;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import es.ull.etsii.jitrax.adt.*;

public class TablesPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private static final Color TABLE_PANEL_TITLE_COLOR = new Color(60, 60, 60);
	private static final Color SELECTED_TABLE_COLOR = Color.ORANGE;
	private static final Color UNSELECTED_TABLE_COLOR = new Color(150, 150, 150);
	
	private static final int MINIMUM_WIDTH = 100;
	private static final int MINIMUM_HEIGHT = 100;
	private static final int MAXIMUM_WIDTH = 100;
	private static final int MAXIMUM_HEIGHT = 100;
	
	private static final float ATTRIBUTES_ALIGNMENT = Component.CENTER_ALIGNMENT;
	
	private ArrayList<Table> tables;		// Tables to be shown
	private Set<String> tableNames;			// Useful for avoiding tables with the same name
	private TablePanel selectedTablePanel;
	
	public TablesPanel() {
		tables = new ArrayList<Table>();
		selectedTablePanel = null;
		
		buildTablesPanel();
	}
	
	public TablesPanel(ArrayList<Table> newTables) {
		tables = new ArrayList<Table>(newTables);
		selectedTablePanel = null;

		buildTablesPanel();
	}

	/**
	 * Sets common settings in this panel for both constructors.
	 */
	private void buildTablesPanel() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setAlignmentX(ATTRIBUTES_ALIGNMENT);
		JScrollPane sp = new JScrollPane(this);
		sp.setVisible(true);
		printTablesOnPanel();
		
		setMinimumSize(new Dimension(MINIMUM_WIDTH, MINIMUM_HEIGHT));
		setMaximumSize(new Dimension(MAXIMUM_WIDTH, MAXIMUM_HEIGHT));
	}
	
	/**
	 * Creates a panel for each table and adds them to the tables' panel.
	 */
	private void printTablesOnPanel() {
		// Reset content
		removeAll();
		
		for (int i = 0; i < getTables().size(); i++) {
			// Create the new TablePanel
			TablePanel newTablePanel = new TablePanel(getTables().get(i));
			
			// Set the first panel as selected
			if (i == 0) {
				changeSelectedTablePanel(newTablePanel);
			}
		
			add(newTablePanel);
		}
	}
	
	/**
	 * Removes the specified table.
	 * @param tableNameToRemove
	 */
	public void eraseTable(String tableNameToRemove) {
		for (int i = 0; i < getTables().size(); i++) {
			if (getTables().get(i).getName().equals(tableNameToRemove)) {
				getTables().remove(i);
			}
		}
	}
	
	public void changeSelectedTablePanel(TablePanel newSelectedPanel) {
		if (getSelectedTablePanel() != null) {
			getSelectedTablePanel().unselect();
		}
		
		newSelectedPanel.select();
		setSelectedTablePanel(newSelectedPanel);
	}
	
	public ArrayList<Table> getTables() {
		return tables;
	}

	public void setTables(ArrayList<Table> tables) {
		this.tables = tables;
	}

	public Set<String> getTableNames() {
		return tableNames;
	}

	public void setTableNames(Set<String> tableNames) {
		this.tableNames = tableNames;
	}

	public TablePanel getSelectedTablePanel() {
		return selectedTablePanel;
	}

	public void setSelectedTablePanel(TablePanel selectedTablePanel) {
		this.selectedTablePanel = selectedTablePanel;
	}
}
