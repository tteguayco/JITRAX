package es.ull.etsii.jitrax.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import es.ull.etsii.jitrax.adt.*;

public class TablesViewer extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private static final int MINIMUM_WIDTH = 100;
	private static final int MINIMUM_HEIGHT = 100;
	private static final int MAXIMUM_WIDTH = 100;
	private static final int MAXIMUM_HEIGHT = 100;
	
	private static final int TOP_MARGIN = 10;
	private static final int LEFT_MARGIN = 10;
	private static final int BOTTOM_MARGIN = 10;
	private static final int RIGHT_MARGIN = 10;
	
	private static final Color BACKGROUND_COLOR = Color.WHITE;
	
	private static final float ATTRIBUTES_ALIGNMENT = Component.CENTER_ALIGNMENT;
	
	private ArrayList<Table> tables;
	private ArrayList<TablePanel> graphicTables;
	private TablePanel selectedTablePanel;
	
	public TablesViewer() {
		tables = new ArrayList<Table>();
		graphicTables = new ArrayList<TablePanel>();
		selectedTablePanel = null;
		
		setBorder(BorderFactory.createEmptyBorder(TOP_MARGIN, LEFT_MARGIN, 
				BOTTOM_MARGIN, RIGHT_MARGIN));
	}
	
	public TablesViewer(ArrayList<Table> newTables) {
		tables = newTables;
		graphicTables = new ArrayList<TablePanel>();
		selectedTablePanel = null;

		buildTablesPanel();
	}
	
	public void updateTables(ArrayList<Table> newTables) {
		tables = newTables;
		graphicTables = new ArrayList<TablePanel>();
		selectedTablePanel = null;
		
		buildTablesPanel();
	}

	public int getIndexOfGraphicTable(TablePanel aTablePanel) {
		if (aTablePanel != null) {
			for (int i = 0; i < getGraphicTables().size(); i++) {
				if (getGraphicTables().get(i).getTable().getName()
						.equalsIgnoreCase(aTablePanel.getTable().getName())) {
					return i;
				}
			}
		}
		
		return -1;
	}
	
	/**
	 * Sets common settings in this panel for both constructors.
	 */
	private void buildTablesPanel() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setAlignmentX(ATTRIBUTES_ALIGNMENT);
		printTablesOnPanel();
		
		setMinimumSize(new Dimension(MINIMUM_WIDTH, MINIMUM_HEIGHT));
		setMaximumSize(new Dimension(MAXIMUM_WIDTH, MAXIMUM_HEIGHT));
		setBackground(BACKGROUND_COLOR);
	}
	
	/**
	 * Creates a panel for each table and adds them to the tables' panel.
	 */
	private void printTablesOnPanel() {
		// Reset content
		removeAll();
		setGraphicTables(new ArrayList<TablePanel>());
		
		for (int i = 0; i < getTables().size(); i++) {
			// Create the new TablePanel
			TablePanel newTablePanel = new TablePanel(getTables().get(i));
			
			// Set the first panel as selected
			if (i == 0) {
				changeSelectedTablePanel(newTablePanel);
			}
		
			getGraphicTables().add(newTablePanel);
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
	
	public void changeSelectedTablePanelByIndex(int tablePanelIndex) {
		if (tablePanelIndex >= 0) {
			TablePanel targetTablePanel = getGraphicTables().get(tablePanelIndex);
			changeSelectedTablePanel(targetTablePanel);
		}
	}
	
	public int getNumOfTables() {
		return getTables().size();
	}
	
	public ArrayList<Table> getTables() {
		return tables;
	}

	public void setTables(ArrayList<Table> tables) {
		this.tables = tables;
	}

	public TablePanel getSelectedTablePanel() {
		return selectedTablePanel;
	}

	public void setSelectedTablePanel(TablePanel selectedTablePanel) {
		this.selectedTablePanel = selectedTablePanel;
	}

	public ArrayList<TablePanel> getGraphicTables() {
		return graphicTables;
	}

	public void setGraphicTables(ArrayList<TablePanel> graphicTables) {
		this.graphicTables = graphicTables;
	}
}
