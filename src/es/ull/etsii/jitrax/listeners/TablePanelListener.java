package es.ull.etsii.jitrax.listeners;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import es.ull.etsii.jitrax.gui.SelectedTableViewer;
import es.ull.etsii.jitrax.gui.TablePanel;
import es.ull.etsii.jitrax.gui.TablesViewer;

public class TablePanelListener extends MouseAdapter {

	private TablesViewer tablesViewer;
	private SelectedTableViewer selectedTableViewer;
	
	public TablePanelListener(TablesViewer aTablesViewer, SelectedTableViewer aSelectedTableViewer) {
		tablesViewer = aTablesViewer;
		selectedTableViewer = aSelectedTableViewer;
		makeFirstTableSelected();
	}
	
	/**
	 * Updates the graphic table in order to display
	 * the new target table in the TablesViewer.
	 * 
	 * @param table
	 */
	private void updateSelectedTable(TablePanel tablePanel) {
		// Update tablesPanel
		getTablesViewer().changeSelectedTablePanel(tablePanel);
		
		// Update selected table viewer
		getSelectedTableViewer().updateTable(tablePanel.getTable());
	}
	
	public void makeFirstTableSelected() {
		if (getTablesViewer().getGraphicTables().size() > 0) {
			updateSelectedTable(getTablesViewer().getGraphicTables().get(0));
		}
	}
	
	public void mouseClicked(MouseEvent e) {
			TablePanel targetTablePanel = ((TablePanel) e.getSource());
			updateSelectedTable(targetTablePanel);
	}

	public TablesViewer getTablesViewer() {
		return tablesViewer;
	}

	public void setTablesViewer(TablesViewer tablesViewer) {
		this.tablesViewer = tablesViewer;
	}

	public SelectedTableViewer getSelectedTableViewer() {
		return selectedTableViewer;
	}

	public void setSelectedTableViewer(SelectedTableViewer selectedTableViewer) {
		this.selectedTableViewer = selectedTableViewer;
	}
}
