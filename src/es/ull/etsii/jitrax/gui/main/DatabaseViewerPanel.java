package es.ull.etsii.jitrax.gui.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
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

public class DatabaseViewerPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private static final int EXTRA_GAP_SIZE = 15;
	
	private static final String PANEL_TITLE = "DB Viewer";
	private static final Color PANEL_BORDER_COLOR = Color.GRAY;
	
	private ArrayList<Database> databases;
	private int selectedDatabaseIndex;
	private SelectedDatabasePanel selectedDatabasePanel;
	private TablesPanel tablesPanel;
	private SelectedTablePanelViewer selectedTablePanel;
	
	public DatabaseViewerPanel(ArrayList<Database> databases) {
		
		ArrayList<Table> tables = databases.get(0).getTables();
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		selectedDatabasePanel = new SelectedDatabasePanel(databases);
		tablesPanel = new TablesPanel(tables);
		
		selectedTablePanel = new SelectedTablePanelViewer(tables.get(0));
		
		JScrollPane tablesSP = new JScrollPane(tablesPanel);
		tablesSP.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		tablesSP.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		add(selectedDatabasePanel);
		add(tablesSP);
		add(Box.createVerticalStrut(EXTRA_GAP_SIZE));
		add(selectedTablePanel);
		
		LineBorder lineBorderPanel = (LineBorder) BorderFactory.createLineBorder(PANEL_BORDER_COLOR);
		setBorder(BorderFactory.createTitledBorder(lineBorderPanel, PANEL_TITLE));
		
		setListeners();
	}
	
	private void setListeners() {
		selectedDatabasePanel.getDbComboBox().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectedDatabaseIndex = selectedDatabasePanel.getDbComboBox().getSelectedIndex();
				tablesPanel.setTables(databases.get(selectedDatabaseIndex).getTables());
			}
		});
	}

	/**
	 * Returns the database the user is working with.
	 * @return
	 */
	public Database getSelectedDatabase() {
		return getDatabases().get(getSelectedDatabaseIndex());
	}
	
	public ArrayList<Database> getDatabases() {
		return databases;
	}

	public void setDatabases(ArrayList<Database> databases) {
		this.databases = databases;
	}

	public SelectedDatabasePanel getSelectedDatabasePanel() {
		return selectedDatabasePanel;
	}

	public void setSelectedDatabasePanel(SelectedDatabasePanel selectedDatabasePanel) {
		this.selectedDatabasePanel = selectedDatabasePanel;
	}

	public TablesPanel getTablesPanel() {
		return tablesPanel;
	}

	public void setTablesPanel(TablesPanel tablesPanel) {
		this.tablesPanel = tablesPanel;
	}

	public SelectedTablePanelViewer getSelectedTablePanel() {
		return selectedTablePanel;
	}

	public void setSelectedTablePanel(SelectedTablePanelViewer selectedTablePanel) {
		this.selectedTablePanel = selectedTablePanel;
	}

	public int getSelectedDatabaseIndex() {
		return selectedDatabaseIndex;
	}

	public void setSelectedDatabaseIndex(int selectedDatabaseIndex) {
		this.selectedDatabaseIndex = selectedDatabaseIndex;
	}
}
