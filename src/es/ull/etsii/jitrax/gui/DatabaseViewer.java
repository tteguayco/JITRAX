package es.ull.etsii.jitrax.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import es.ull.etsii.jitrax.adt.Attribute;
import es.ull.etsii.jitrax.adt.DataType;
import es.ull.etsii.jitrax.adt.Database;
import es.ull.etsii.jitrax.adt.Datum;
import es.ull.etsii.jitrax.adt.Row;
import es.ull.etsii.jitrax.adt.Table;
import es.ull.etsii.jitrax.exceptions.DuplicatePrimaryKeyException;

public class DatabaseViewer extends JPanel {
	private static final long serialVersionUID = 1L;
	private static final int EXTRA_GAP_SIZE = 10;
	
	private static final String PANEL_TITLE = "DB Viewer";
	private static final Color PANEL_BORDER_COLOR = Color.GRAY;
	
	private HashMap<String, Database> databases;
	//private SelectedTableExchanger selectedTableExchanger;
	
	private SelectedDatabaseViewer selectedDatabasePanel;
	private TablesViewer tablesPanel;
	private SelectedTableViewer selectedTablePanel;
	
	public DatabaseViewer() {
		databases = new HashMap<String, Database>();

		selectedDatabasePanel = new SelectedDatabaseViewer(databases);
		tablesPanel = new TablesViewer();
		selectedTablePanel = new SelectedTableViewer();
		//selectedTableExchanger = new SelectedTableExchanger();
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JScrollPane tablesSP = new JScrollPane(tablesPanel);
		tablesSP.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		tablesSP.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		add(Box.createVerticalStrut(EXTRA_GAP_SIZE));
		add(selectedDatabasePanel);
		add(tablesSP);
		add(Box.createVerticalStrut(EXTRA_GAP_SIZE));
		add(selectedTablePanel);
		
		LineBorder lineBorderPanel = (LineBorder) BorderFactory.createLineBorder(PANEL_BORDER_COLOR);
		setBorder(BorderFactory.createTitledBorder(lineBorderPanel, PANEL_TITLE));
		
		setListeners();
	}
	
	/**
	 * Adds a new database to be shown in the viewer.
	 * @param database
	 */
	public void addDatabase(Database database) {
		// Add new database
		databases.put(database.getName(), database);
		
		// Update GUI Components
		selectedDatabasePanel.addDatabase(database.getName());
		updateSelectedDatabase(database.getName());
	}
	
	private void updateSelectedDatabase(String newSelectedDatabaseName) {
		Database newSelectedDatabase = databases.get(newSelectedDatabaseName);
		
		tablesPanel.updateTables(newSelectedDatabase.getTables());
		selectedTablePanel.updateTable(newSelectedDatabase.getTables().get(0));
		updateSelectedTable(tablesPanel.getGraphicTables().get(0));
		
		// Listeners for graphic tables in the db viewer
		for (int i = 0; i < getTablesPanel().getNumOfTables(); i++) {
			getTablesPanel().getGraphicTables().get(i).addMouseListener(new TablePanelListener());
		}
		
		// Revalidate the three panels
		selectedDatabasePanel.revalidate();
		tablesPanel.revalidate();
		selectedTablePanel.revalidate();
	}
	
	private void setListeners() {
		getSelectedDatabasePanel().getDbComboBox().addItemListener(new ComboBoxListener());
		getSelectedDatabasePanel().getRemoveButton().addActionListener(new RemoveButtonListener());
	}
	
	public Database getSelectedDatabase() {
		String databaseName = (String) selectedDatabasePanel.getDbComboBox().getSelectedItem();
		return databases.get(databaseName);
	}
	
	public HashMap<String, Database> getDatabases() {
		return databases;
	}

	public void setDatabases(HashMap<String, Database> databases) {
		this.databases = databases;
	}

	public SelectedDatabaseViewer getSelectedDatabasePanel() {
		return selectedDatabasePanel;
	}

	public void setSelectedDatabasePanel(SelectedDatabaseViewer selectedDatabasePanel) {
		this.selectedDatabasePanel = selectedDatabasePanel;
	}

	public TablesViewer getTablesPanel() {
		return tablesPanel;
	}

	public void setTablesPanel(TablesViewer tablesPanel) {
		this.tablesPanel = tablesPanel;
	}

	public SelectedTableViewer getSelectedTablePanel() {
		return selectedTablePanel;
	}

	public void setSelectedTablePanel(SelectedTableViewer selectedTablePanel) {
		this.selectedTablePanel = selectedTablePanel;
	}
	
	private class ComboBoxListener implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			
			// If the values changes
			if (e.getStateChange() == ItemEvent.SELECTED) {
				String selectedDatabaseName = 
						(String) selectedDatabasePanel.getDbComboBox().getSelectedItem();
				updateSelectedDatabase(selectedDatabaseName);
		    }
		}
	}
	
	private class RemoveButtonListener implements ActionListener {
		JComboBox<String> databasesCombo = selectedDatabasePanel.getDbComboBox();
		
		public void actionPerformed(ActionEvent e) {
			// There must be at least one database
			if (databasesCombo.getItemCount() > 1) {
				String databaseToRemoveName = 
						(String) selectedDatabasePanel.getDbComboBox().getSelectedItem();
				databases.remove(databaseToRemoveName);
				System.out.println(databases);
				selectedDatabasePanel.updateComboBox(databases);
			}
			
			else {
				JOptionPane.showMessageDialog(DatabaseViewer.this.getParent(), 
						"There must be at least one database.", 
						"Warning", 
						JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
	
	/**
	 * Updates the graphic table in order to display
	 * the new target table in the DB Viewer.
	 * 
	 * @param table
	 */
	private void updateSelectedTable(TablePanel tablePanel) {
		// Get new data
		String[] newColsNames = tablePanel.getTable().getColumnsNames();
		String[][] newRowsData = tablePanel.getTable().getRowsData();
		
		// Update table's model
		selectedTablePanel.setTable(tablePanel.getTable());
		selectedTablePanel.getTableModel().setDataVector(newRowsData, newColsNames);
		selectedTablePanel.getTableModel().fireTableDataChanged();
		
		// Change title for selectedTablePanelViewer
		selectedTablePanel.updateTitle();
	}
	
	private class TablePanelListener extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {
			TablePanel targetTablePanel = ((TablePanel) e.getSource());
			tablesPanel.changeSelectedTablePanel(targetTablePanel);
			updateSelectedTable(targetTablePanel);
		}
	}
}
