package es.ull.etsii.jitrax.gui.dbcreation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import es.ull.etsii.jitrax.adt.Database;
import es.ull.etsii.jitrax.adt.Datum;
import es.ull.etsii.jitrax.adt.Row;
import es.ull.etsii.jitrax.adt.Table;
import es.ull.etsii.jitrax.gui.TablesViewer;
import es.ull.etsii.jitrax.gui.dialogs.ErrorsDialog;
import es.ull.etsii.jitrax.listeners.TablePanelListener;
import es.ull.etsii.jitrax.gui.DatabaseViewer;
import es.ull.etsii.jitrax.gui.MainWindow;
import es.ull.etsii.jitrax.gui.SelectedTableViewer;
import es.ull.etsii.jitrax.gui.TablePanel;

public class TablesManagerWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private static final String WINDOW_TITLE = "Tables Manager - ";
	private static final String SCHEMA_PANEL_DEFAULT_MESSAGE = "No tables were found.";
	
	private static final int WINDOW_WIDTH = 700;
	private static final int WINDOW_HEIGHT = 500;
	private static final int WINDOW_MIN_WIDTH = 500;
	private static final int WINDOW_MIN_HEIGHT = 300;
	private static final int BORDERS_THICKNESS = 1;
	private static final int TOP_PADDING = 10;
	private static final int LEFT_PADDING = 10;
	private static final int BOTTOM_PADDING = 10;
	private static final int RIGHT_PADDING = 10;
	private static final int SCHEMA_PANEL_GAP = 5; 
	
	private Database database;
	private int selectedTableIndex;
	
	private DatabaseViewer databaseViewer;
	
	private JPanel leftPanel;
	private JPanel rightPanel;
	private JPanel mainContainer;
	
	private TablesViewer tablesViewer;
	private SelectedTableViewer selectedTableViewer;
	
	private JButton addTableButton;
	private JButton eraseTableButton;
	private JButton modifyTableButton;
	private JButton insertButton;
	
	private JButton newRowButton;
	private JButton removeRowButton;
	private JButton doneButton;
	
	public TablesManagerWindow(Database aDatabase, DatabaseViewer aDatabaseViewer) {
		database = aDatabase;
		selectedTableIndex = -1;
		
		databaseViewer = aDatabaseViewer;
		mainContainer = new JPanel(new BorderLayout());
		leftPanel = new JPanel(new BorderLayout());
		rightPanel = new JPanel(new BorderLayout());
		
		selectedTableViewer = new SelectedTableViewer();
		selectedTableViewer.makeEditable();
		
		addTableButton = new JButton("CREATE");
		eraseTableButton = new JButton("DROP");
		modifyTableButton = new JButton("ALTER");
		insertButton = new JButton("INSERT");
		doneButton = new JButton("  ✔ DONE  ");
		insertButton.setToolTipText("Insert new rows on DBMS for this table");
		
		newRowButton = new JButton("➕");
		removeRowButton = new JButton("➖");
		newRowButton.setToolTipText("Add new row");
		removeRowButton.setToolTipText("Remove selected rows");
		
		// Setting up listeners
		addTableButton.addActionListener(new TableEditorSetterUp());
		modifyTableButton.addActionListener(new TableEditorSetterUp());
		eraseTableButton.addActionListener(new RemoveTableListener());
		newRowButton.addActionListener(new NewRowListener());
		removeRowButton.addActionListener(new RemoveRowListener());
		insertButton.addActionListener(new InsertRows());
		doneButton.addActionListener(new DoneButtonListener());
		
		EmptyBorder schemaPanelPadding = new EmptyBorder(10, 10, 10, 10);
		
		// Main container
		EmptyBorder padding = new EmptyBorder(TOP_PADDING, 
											LEFT_PADDING, 
											BOTTOM_PADDING, 
											RIGHT_PADDING);
		
		setLayout(new BorderLayout());
		mainContainer.setBorder(padding);
		add(mainContainer, BorderLayout.CENTER);
		
		buildLeftPanel();
		buildRightPanel();
		
		mainContainer.add(leftPanel, BorderLayout.WEST);
		mainContainer.add(rightPanel, BorderLayout.CENTER);
		
		buildWindow();
	}
	
	private void buildWindow() {
		setTitle(WINDOW_TITLE + getDatabase().getName());
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setMinimumSize(new Dimension(WINDOW_MIN_WIDTH, WINDOW_MIN_HEIGHT));
		//setMaximumSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private void buildLeftPanel() {
		String[] tablesNames = getDatabase().getTablesNames();
		setCommonBorder(getLeftPanel(), "Tables");
		
		tablesViewer = new TablesViewer(database.getTables());
		JScrollPane tablesListSP = new JScrollPane(tablesViewer);
		tablesListSP.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		// Listeners for the graphic tables
		setPanelsListeners();
		
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.add(getAddTableButton());
		buttonsPanel.add(getEraseTableButton());
		buttonsPanel.add(getModifyTableButton());
		getLeftPanel().add(buttonsPanel, BorderLayout.SOUTH);
		getLeftPanel().add(tablesListSP, BorderLayout.CENTER);
	}
	
	private void setPanelsListeners() {
		for (int i = 0; i < tablesViewer.getNumOfTables(); i++) {
			tablesViewer.getGraphicTables().get(i).addMouseListener(
					new TablePanelListener(tablesViewer, selectedTableViewer));
		}
	}
	
	private void buildRightPanel() {
		JPanel tableButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		// Buttons
		tableButtonPanel.add(newRowButton);
		tableButtonPanel.add(removeRowButton);
		
		JPanel southButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		southButtonPanel.add(insertButton);
		selectedTableViewer.add(tableButtonPanel, BorderLayout.NORTH);
		selectedTableViewer.add(southButtonPanel, BorderLayout.SOUTH);
		
		JScrollPane contentTablePanelSP = new JScrollPane(selectedTableViewer);
		contentTablePanelSP.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		// Remove ugly borders
		contentTablePanelSP.setViewportBorder(null);
		
		JPanel bottomPanel = new JPanel(new BorderLayout());
		JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		buttonsPanel.add(doneButton);
		bottomPanel.add(buttonsPanel, BorderLayout.SOUTH);
		getRightPanel().add(selectedTableViewer, BorderLayout.CENTER);
		getRightPanel().add(bottomPanel, BorderLayout.SOUTH);
	}
	
	private void updateSelectionRowColumn() {
		int numOfCheckBoxes = selectedTableViewer.getTableModel().getRowCount();
		ArrayList<JComboBox> checkboxesColumn = new ArrayList<JComboBox>();
		
		// Creating comboboxes
		for (int i = 0; i < numOfCheckBoxes; i++) {
			checkboxesColumn.add(new JComboBox());
		}
		
		//selectedTableViewer.getTableModel().addColumn("", checkboxesColumn));
	}
	
	private void setCommonBorder(JPanel aPanel, String name) {
		aPanel.setBorder(BorderFactory.createTitledBorder(
				new LineBorder(Color.GRAY, BORDERS_THICKNESS),
                name,
                TitledBorder.LEFT,
                TitledBorder.TOP,
                null,
                Color.BLACK));
	}
	
	public void updateSelectedTable(TablePanel tablePanel, int tablePanelIndex) {
		// Update tablesPanel
		getTablesViewer().changeSelectedTablePanelByIndex(tablePanelIndex);
		
		// Update selected table viewer
		getSelectedTableViewer().updateTable(tablePanel.getTable());
		
		revalidate();
		repaint();
	}
	
	public void updateTablesViewer() {
		ArrayList<Table> tables = database.getTables();
		tablesViewer.updateTables(tables);
		
		// Listeners for panels
		setPanelsListeners();
	}
	
	public void updateDatabaseViewer() {
		ArrayList<Table> tables = database.getTables();
		databaseViewer.getTablesViewer().updateTables(tables);
	}
	
	public static void main(String[] args) {
		for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                try {
					UIManager.setLookAndFeel(info.getClassName());
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (UnsupportedLookAndFeelException e) {
					e.printStackTrace();
				}
                break;
            }
        }
		
		Database mydb = new Database("MyDB");
		TablesManagerWindow tmWindow = new TablesManagerWindow(mydb, null);
	}
	
	private class TableEditorSetterUp implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String tableName = tablesViewer.getSelectedTablePanel().getTable().getName();
			Table targetTable = database.getTableByName(tableName);
			TableEditor tableEditor = null;
			
			// ADD NEW TABLE
			if (e.getSource() == getAddTableButton()) {
				tableEditor = new TableEditor(TablesManagerWindow.this, 
						targetTable, TableEditorMode.CREATION);
			}
			
			// MODIFY EXISTING TABLE
			else if (e.getSource() == getModifyTableButton()) {
				tableEditor = new TableEditor(TablesManagerWindow.this, 
						targetTable, TableEditorMode.MODIFICATION);
			}
			
			tableEditor.setVisible(true);
		}
	}
	
	private class RemoveTableListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Table targetTable = tablesViewer.getSelectedTablePanel().getTable();
			
			if (database.getNumOfTables() <= 1) {
				showWrongNumberOfTablesDialog();
				return;
			}
			
			// Confirm removal
			int choice = showTableRemovalConfirmation(targetTable.getName());
			
			if (choice == JOptionPane.YES_OPTION) {
				// Remove from gui
				database.removeTable(targetTable);
				
				// Remove from DBMS
				try {
					database.getDbmsDriver().dropTable(targetTable);
				} 
				
				catch (SQLException e1) {
					ArrayList<String> errorsMessages = new ArrayList<String>();
					errorsMessages.add(e1.getMessage());
					ErrorsDialog errorsDialog = new ErrorsDialog(errorsMessages);
				}
				
				// Refresh panels
				updateTablesViewer();
			}
		}
	}
	
	private class InsertRows implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Table targetTable = selectedTableViewer.getTable();
			ArrayList<Vector> rows = 
					new ArrayList<Vector>(selectedTableViewer.getTableModel().getDataVector());
			
			try {
				
				ArrayList<ArrayList<String>> rowsToInsert = new ArrayList<ArrayList<String>>();
				for (int i = 0; i < rows.size(); i++) {
					ArrayList<String> auxRow = new ArrayList<String>();
					for (int j = 0; j < rows.get(i).size(); j++) {
						auxRow.add((String) rows.get(i).get(j).toString());
					}
					
					rowsToInsert.add(new ArrayList<String>(auxRow));
					auxRow.clear();
				}
			
				database.getDbmsDriver().deleteRowsFromTable(targetTable);
				for (int i = 0; i < rowsToInsert.size(); i++) {
					database.getDbmsDriver().insertRow(rowsToInsert.get(i), targetTable);
					
					// If everything was OK, save the row locally
					Datum datum;
					ArrayList<Datum> dataForRow = new ArrayList<Datum>();
					for (int j = 0; j < rowsToInsert.get(i).size(); j++) {
						datum = new Datum(rowsToInsert.get(i).get(j));
						dataForRow.add(datum);
					}
					
					targetTable.addRow(dataForRow);
					dataForRow.clear();
				}
				
				showCorrectRowsInsertionDialog();
			}
			
			catch(SQLException | NullPointerException e1) {
				ArrayList<String> errorsMessages = new ArrayList<String>();
				errorsMessages.add(new String("Some rows are not valid and could not"
						+ " insert them into the DBMS. Please, check the following:\n"
						+ "    * Char or string values are between single quotes.\n"
						+ "    * There are no empty values.\n"
						+ "    * Numeric (integer or float) or date values are correct."));
				ErrorsDialog errorsDialog = new ErrorsDialog(errorsMessages);
			}
		}
	}
	
	private class DoneButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// Close window
			TablesManagerWindow
				.this
				.dispatchEvent(new WindowEvent(TablesManagerWindow.this, WindowEvent.WINDOW_CLOSING));
		}
	}
	
	private class NewRowListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			selectedTableViewer.addEmptyRow();
		}
	}
	
	private class RemoveRowListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			ArrayList<Row> selectedRows = new ArrayList<Row>();
			
			// Getting which rows are selected
			for (int i = 0; i < getSelectedTableViewer().getGraphicTable().getRowCount(); i++) {
				if (getSelectedTableViewer().getGraphicTable().isRowSelected(i)) {
					selectedRows.add(getSelectedTableViewer().getTable().getRowAt(i));
				}
			}
			
			try {
				// Delete selected rows from DBMS
				for (int i = 0; i < selectedRows.size(); i++) {
					Table selectedTable = getSelectedTableViewer().getTable();
					database.getDbmsDriver().deleteRow(selectedTable, selectedRows.get(i));
				}
			}
			catch (SQLException exc) {
				exc.printStackTrace();
			}
		}
	}
	
	private void showWrongNumberOfTablesDialog() {
		JOptionPane.showMessageDialog(null, "There must be at least one table.",
				"Table removal failed", JOptionPane.ERROR_MESSAGE);
	}
	
	private void showCorrectRowsInsertionDialog() {
		JOptionPane.showMessageDialog(null, "All rows were correctly inserted on the DBMS.",
				"Rows inserted", JOptionPane.INFORMATION_MESSAGE);
	}
	
	private int showTableRemovalConfirmation(String tableName) {
		int choice = 0;
		
		choice = JOptionPane.showConfirmDialog(null, 
				"Are you sure you want to drop the table '" + tableName + "'?",
				"Table removal", JOptionPane.YES_NO_OPTION);
		
		return choice;
	}
	
	public Database getDatabase() {
		return database;
	}

	public void setDatabase(Database database) {
		this.database = database;
	}
	
	public JButton getAddTableButton() {
		return addTableButton;
	}

	public void setAddTableButton(JButton addTableButton) {
		this.addTableButton = addTableButton;
	}

	public JButton getEraseTableButton() {
		return eraseTableButton;
	}

	public void setEraseTableButton(JButton eraseTableButton) {
		this.eraseTableButton = eraseTableButton;
	}

	public JButton getModifyTableButton() {
		return modifyTableButton;
	}

	public void setModifyTableButton(JButton modifyTableButton) {
		this.modifyTableButton = modifyTableButton;
	}

	public JPanel getMainContainer() {
		return mainContainer;
	}

	public void setMainContainer(JPanel mainContainer) {
		this.mainContainer = mainContainer;
	}

	public int getSelectedTableIndex() {
		return selectedTableIndex;
	}

	public void setSelectedTableIndex(int selectedTableIndex) {
		this.selectedTableIndex = selectedTableIndex;
	}

	public JPanel getLeftPanel() {
		return leftPanel;
	}

	public void setLeftPanel(JPanel leftPanel) {
		this.leftPanel = leftPanel;
	}

	public JPanel getRightPanel() {
		return rightPanel;
	}

	public void setRightPanel(JPanel rightPanel) {
		this.rightPanel = rightPanel;
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
