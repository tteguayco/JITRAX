package es.ull.etsii.jitrax.gui;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;

import javax.swing.JPanel;

/**
 * Changes the color of the selected table and shows
 * its content in the panel which shows the content of 
 * a table in the main frame.
 */
public class SelectedTableExchanger {
	
	private TablesPanel tablesPanel;
	private SelectedTablePanelViewer selectedTablePanelViewer;
	
	public SelectedTableExchanger(TablesPanel aTablesPanel, SelectedTablePanelViewer aSelectedTablePanelViewer) {
		tablesPanel = aTablesPanel;
		selectedTablePanelViewer = aSelectedTablePanelViewer;
		
		// Setting listeners for all the table panels
		for (int i = 0; i < tablesPanel.getComponentCount(); i++) {
			JPanel tablePanel = (JPanel) tablesPanel.getComponent(i);
			
			tablePanel.addMouseListener(new MouseAdapter() {	
				public void mouseClicked(MouseEvent e) {
					TablePanel targetTablePanel = ((TablePanel) e.getSource());
					tablesPanel.changeSelectedTablePanel(targetTablePanel);
					
					// Get new data
					String[] newColsNames = targetTablePanel.getTable().getColumnsNames();
					String[][] newRowsData = targetTablePanel.getTable().getRowsData();
					
					// Update table's model
					selectedTablePanelViewer.setTable(targetTablePanel.getTable());
					selectedTablePanelViewer.getTableModel().setDataVector(newRowsData, newColsNames);
					selectedTablePanelViewer.getTableModel().fireTableDataChanged();
					
					// Change title for selectedTablePanelViewer
					selectedTablePanelViewer.updateTitle();
				}
			});
		}
	}
}
