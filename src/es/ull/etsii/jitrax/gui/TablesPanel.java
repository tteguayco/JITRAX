package es.ull.etsii.jitrax.gui;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Set;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import es.ull.etsii.jitrax.adt.*;

public class TablesPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private static final Color SELECTED_TABLE_COLOR = Color.ORANGE;
	private static final Color UNSELECTED_TABLE_COLOR = Color.GRAY;
	
	private static final int DEFAULT_SELECTED_PANEL_INDEX = 0;
	private static final int NEW_TABLE_PANEL_TOP_PADDING = 10;
	private static final int NEW_TABLE_PANEL_LEFT_PADDING = 10;
	private static final int NEW_TABLE_PANEL_BOTTOM_PADDING = 10;
	private static final int NEW_TABLE_PANEL_RIGHT_PADDING = 10;
	private static final int GAP_BETWEEN_ATTRIBUTES = 5;
	
	private static final float ATTRIBUTES_ALIGNMENT = Component.CENTER_ALIGNMENT;
	
	private ArrayList<Table> tables;		// Tables to be shown
	private Set<String> tableNames;			// Useful for avoiding tables with the same name
	private int selectedPanelIndex;
	
	public TablesPanel() {
		tables = new ArrayList<Table>();
		selectedPanelIndex = DEFAULT_SELECTED_PANEL_INDEX;
		
		buildTablesPanel();
	}
	
	public TablesPanel(ArrayList<Table> newTables) {
		tables = new ArrayList<Table>(newTables);
		selectedPanelIndex = DEFAULT_SELECTED_PANEL_INDEX;
		
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
	}
	
	/**
	 * Creates a panel for each table and adds them to the tables' panel.
	 */
	private void printTablesOnPanel() {
		// Reset content
		removeAll();
		
		for (int i = 0; i < getTables().size(); i++) {
			String newTableName = getTables().get(i).getName();
			JPanel newTablePanel = new JPanel();
			
			// Customize panel's title
			newTablePanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),
	                newTableName,
	                TitledBorder.CENTER,
	                TitledBorder.TOP));
			
			// Adding the panel's border padding
			newTablePanel.setLayout(new BoxLayout(newTablePanel, BoxLayout.Y_AXIS));
			setBorder(BorderFactory.createEmptyBorder(NEW_TABLE_PANEL_TOP_PADDING, 
													NEW_TABLE_PANEL_LEFT_PADDING, 
													NEW_TABLE_PANEL_BOTTOM_PADDING, 
													NEW_TABLE_PANEL_RIGHT_PADDING));
			
			// Adding attributes to the panel, along with their data types
			for (int j = 0; j < getTables().get(i).getAttributes().size(); j++) {
				Attribute auxAttribute = getTables().get(i).getAttributes().get(j);
				String attributeName = auxAttribute.getName();
				String dataType = auxAttribute.getDataType().toString();
				
				// Gap between attributes
				newTablePanel.add(Box.createVerticalStrut(GAP_BETWEEN_ATTRIBUTES));
				String newAttributeText = "";
				JLabel newAttributeLabel = null;
				
				// Adding label PK to the new attribute in case it is primary key
				if (auxAttribute.isPrimaryKey()) {
					 newAttributeText = " (" + dataType + ", PK)";
					 newAttributeLabel = new JLabel("<html><u>" 
							 						+ attributeName 
							 						+ "</u>"
							 						+ newAttributeText
							 						+ "</html>");
				} else {
					newAttributeText = attributeName + " (" + dataType + ")";
					newAttributeLabel = new JLabel(newAttributeText);
				}
				
				// Adding the new attribute's info to the current table panel
				newTablePanel.add(newAttributeLabel);
			}
			
			// Extra gap
			newTablePanel.add(Box.createVerticalStrut(GAP_BETWEEN_ATTRIBUTES));
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
	
	public void markTableAsSelected(JPanel tablePanel) {
		String tableName = tablePanel.getName();
		LineBorder lineBorderPanel = (LineBorder) BorderFactory.createLineBorder(SELECTED_TABLE_COLOR);
		tablePanel.setBorder(BorderFactory.createTitledBorder(lineBorderPanel, tableName));
	}
	
	public void dismarkCurrentSelectedTable(JPanel tablePanel) {
		String tableName = tablePanel.getName();
		LineBorder lineBorderPanel = (LineBorder) BorderFactory.createLineBorder(UNSELECTED_TABLE_COLOR);
		tablePanel.setBorder(BorderFactory.createTitledBorder(lineBorderPanel, tableName));
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

	public int getSelectedPanelIndex() {
		return selectedPanelIndex;
	}

	public void setSelectedPanelIndex(int selectedPanelIndex) {
		this.selectedPanelIndex = selectedPanelIndex;
	}
}
