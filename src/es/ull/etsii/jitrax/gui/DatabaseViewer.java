package es.ull.etsii.jitrax.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import es.ull.etsii.jitrax.adt.Database;
import es.ull.etsii.jitrax.gui.dbcreation.TablesManagerWindow;
import es.ull.etsii.jitrax.listeners.TablePanelListener;

public class DatabaseViewer extends JPanel {
	private static final long serialVersionUID = 1L;
	private static final int EXTRA_GAP_SIZE = 10;
	
	private static final String PANEL_TITLE = "DB Viewer";
	private static final Color PANEL_BORDER_COLOR = Color.GRAY;
	
	private SelectedDatabaseViewer selectedDatabaseViewer;
	private TablesViewer tablesViewer;
	private SelectedTableViewer selectedTableViewer;
	
	public DatabaseViewer() {
		selectedDatabaseViewer = new SelectedDatabaseViewer();
		tablesViewer = new TablesViewer();
		selectedTableViewer = new SelectedTableViewer();
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JScrollPane tablesSP = new JScrollPane(tablesViewer);
		tablesSP.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		tablesSP.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		add(Box.createVerticalStrut(EXTRA_GAP_SIZE));
		add(selectedDatabaseViewer);
		add(tablesSP);
		add(Box.createVerticalStrut(EXTRA_GAP_SIZE));
		add(selectedTableViewer);
		
		LineBorder lineBorderPanel = (LineBorder) BorderFactory.createLineBorder(PANEL_BORDER_COLOR);
		setBorder(BorderFactory.createTitledBorder(lineBorderPanel, PANEL_TITLE));
		
		setListeners();
	}
	
	/**
	 * Adds a new database to be shown in the viewer.
	 * @param database
	 */
	public void addDatabase(Database database) {
		getSelectedDatabaseViewer().addDatabase(database);
	}
	
	private void updateSelectedDatabase() {
		Database newSelectedDatabase = getSelectedDatabaseViewer().getSelectedDatabase();
		
		getTablesViewer().updateTables(newSelectedDatabase.getTables());
		getSelectedTableViewer().updateTable(newSelectedDatabase.getTables().get(0));
		
		// Listeners for graphic tables in the db viewer
		for (int i = 0; i < getTablesViewer().getNumOfTables(); i++) {
			getTablesViewer().getGraphicTables().get(i).addMouseListener(
					new TablePanelListener(getTablesViewer(), getSelectedTableViewer()));
		}
		
		// Update the three panels
		getSelectedDatabaseViewer().revalidate();
		getTablesViewer().revalidate();
		getSelectedTableViewer().revalidate();
	}
	
	private void setListeners() {
		getSelectedDatabaseViewer().getCombo().addItemListener(new ComboBoxListener());
		getSelectedDatabaseViewer().getRemoveButton().addActionListener(new RemoveButtonListener());
		getSelectedDatabaseViewer().getAlterButton().addActionListener(new AlterButtonListener());
	}
	
	private class ComboBoxListener implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			
			// If the values changes
			if (e.getStateChange() == ItemEvent.SELECTED) {
				Database selectedDatabase = 
						(Database) getSelectedDatabaseViewer().getCombo().getSelectedItem();
				getSelectedDatabaseViewer().getCombo().setSelectedItem(selectedDatabase);
				updateSelectedDatabase();
		    }
		}
	}
	
	private class RemoveButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			JComboBox<Database> databasesCombo = getSelectedDatabaseViewer().getCombo();
			// There must be at least one database
			if (databasesCombo.getItemCount() > 1) {
				Database databaseToRemove = (Database)
						getSelectedDatabaseViewer().getCombo().getSelectedItem();
				// Confirm deletion
				int dialogResult = JOptionPane.showConfirmDialog (null, 
						"Are you sure you want to remove the database " + databaseToRemove.getName() + "?",
						"Confirm Deletion",
						JOptionPane.YES_NO_OPTION);
				
				if(dialogResult == JOptionPane.YES_OPTION){
					databasesCombo.removeItem((Database) databaseToRemove);
				}
			}
			
			else {
				JOptionPane.showMessageDialog(DatabaseViewer.this.getParent(), 
						"There must be at least one database.", 
						"Warning", 
						JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
	
	private class AlterButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Database selectedDatabase = (Database) getSelectedDatabaseViewer().getCombo().getSelectedItem();
			TablesManagerWindow tmWindow = new TablesManagerWindow(selectedDatabase);
			int graphicTableIndex;
			
			//System.out.println("> " + tmWindow.getTablesViewer().getGraphicTables());
			
			// Mark the current selected table
			TablePanel selectedTablePanel = getTablesViewer().getSelectedTablePanel();
			graphicTableIndex = tmWindow.getTablesViewer().getIndexOfGraphicTable(selectedTablePanel);
			tmWindow.updateSelectedTable(selectedTablePanel,
					graphicTableIndex);
			
			// Move scrollbar to show selectedTablePanel
			tmWindow.getTablesViewer().scrollRectToVisible(
					tmWindow.getTablesViewer().getGraphicTables().get(graphicTableIndex).getBounds());
		}
	}
	
	public Database getSelectedDatabase() {
		return (Database) getSelectedDatabaseViewer().getCombo().getSelectedItem();
	}

	public SelectedDatabaseViewer getSelectedDatabaseViewer() {
		return selectedDatabaseViewer;
	}

	public void setSelectedDatabaseViewer(SelectedDatabaseViewer selectedDatabasePanel) {
		this.selectedDatabaseViewer = selectedDatabasePanel;
	}

	public TablesViewer getTablesViewer() {
		return tablesViewer;
	}

	public void setTablesViewer(TablesViewer tablesPanel) {
		this.tablesViewer = tablesPanel;
	}

	public SelectedTableViewer getSelectedTableViewer() {
		return selectedTableViewer;
	}

	public void setSelectedTableViewer(SelectedTableViewer selectedTablePanel) {
		this.selectedTableViewer = selectedTablePanel;
	}
}
