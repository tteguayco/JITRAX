package es.ull.etsii.jitrax.gui.dbcreation;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
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
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import es.ull.etsii.jitrax.adt.Attribute;
import es.ull.etsii.jitrax.adt.Table;
import es.ull.etsii.jitrax.exceptions.DuplicateTableException;
import es.ull.etsii.jitrax.gui.dialogs.ErrorsDialog;
import es.ull.etsii.jitrax.adt.DataType;;

public class TableEditor extends JFrame {
	private static final String WINDOW_TITLE = "Table Editor";
	private static final String ATTR_LIST_TITLE = "Attributes";
	private static final String NEW_ATTR_TITLE = "New";
	
	private static final String WHITESPACE_REGEXP = ".*\\s+.*";
	
	private static final int WINDOW_WIDTH = 400;
	private static final int WINDOW_HEIGHT = 200;
	
	private static final int TOP_PADDING = 10;
	private static final int LEFT_PADDING = 20;
	private static final int BOTTOM_PADDING = 10;
	private static final int RIGHT_PADDING = 20;
	
	private static final int CENTER_TOP_PADDING = 10;
	private static final int CENTER_LEFT_PADDING = 10;
	private static final int CENTER_BOTTOM_PADDING = 0;
	private static final int CENTER_RIGHT_PADDING = 10;
	
	private static final int TEXTFIELD_WIDTH = 100;
	private static final int TEXTFIELD_HEIGHT = 30;
	private static final int ATTRLIST_WIDTH = 170;
	private static final int ATTRLIST_HEIGHT = 150;
	
	private Table table;
	private TablesManagerWindow tablesManagerParent;
	private TableEditorMode mode;
	private boolean schemaHasChanged;
	
	private JPanel mainContainer;
	private JPanel centerPanel;
	private JPanel attrListPanel;
	private JPanel attrEditorPanel;
	
	private JTextField tableName;
	private JTextField newAttrName;
	private JComboBox<DataType> newAttrType;
	private JList<Attribute> attrList;
	private DefaultListModel<Attribute> defaultListModel;
	private JButton addAttrButton;
	private JButton eraseAttrButton;
	private JButton okButton;
	
	private String tableOriginalName;
	
	public TableEditor(TablesManagerWindow aTablesManager, Table aTable, TableEditorMode aMode) {
		table = aTable;
		tablesManagerParent = aTablesManager;
		mode = aMode;
		schemaHasChanged = false;
		
		mainContainer = new JPanel();
		centerPanel = new JPanel();
		attrListPanel = new JPanel();
		attrEditorPanel = new JPanel();
		
		tableName = new JTextField();
		newAttrName = new JTextField();
		newAttrType = new JComboBox<DataType>(DataType.values());
		attrList = new JList<Attribute>();
		defaultListModel = new DefaultListModel<Attribute>();
		attrList.setModel(defaultListModel);
	
		tableOriginalName = aTable.getName();
		
		newAttrName.setPreferredSize(new Dimension(TEXTFIELD_WIDTH, TEXTFIELD_HEIGHT));
		newAttrType.setPreferredSize(new Dimension(TEXTFIELD_WIDTH, TEXTFIELD_HEIGHT));
		
		addAttrButton = new JButton("ADD");
		eraseAttrButton = new JButton("ERASE");
		okButton = new JButton("OK");
		
		setLayout(new BorderLayout());
		
		JPanel tableNamePanel = new JPanel(new BorderLayout());
		tableNamePanel.add(new JLabel("Table name: "), BorderLayout.WEST);
		tableNamePanel.add(tableName, BorderLayout.CENTER);
		
		buildAttrListPanel();
		buildAttrEditorPanel();
		
		centerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		centerPanel.add(attrListPanel, BorderLayout.WEST);
		centerPanel.add(new JLabel(" << "), BorderLayout.CENTER);
		centerPanel.add(attrEditorPanel, BorderLayout.EAST);
		
		mainContainer.setLayout(new BorderLayout());
		mainContainer.add(tableNamePanel, BorderLayout.NORTH);
		mainContainer.add(centerPanel, BorderLayout.CENTER);
		addPaddingToMainContainer();
		add(mainContainer, BorderLayout.CENTER);
		
		JPanel okButtonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		okButtonPanel.add(okButton);
		mainContainer.add(okButtonPanel, BorderLayout.SOUTH);
		
		// Add some padding
		centerPanel.setBorder(new EmptyBorder(CENTER_TOP_PADDING,
				CENTER_LEFT_PADDING, CENTER_BOTTOM_PADDING, CENTER_RIGHT_PADDING));
		
		buildOkButton();
		buildWindow();
		setCreationModeConfiguration();
		setModificationModeConfiguration();
		
		pack();
	}
	
	private void buildOkButton() {
		if (mode == TableEditorMode.CREATION) {
			okButton.setText("✔ CREATE");
			okButton.setToolTipText("Create table on DBMS");
			okButton.addActionListener(new CreateTableListener());
		}
		
		else if (mode == TableEditorMode.MODIFICATION) {
			okButton.setText("✔ COMMIT");
			okButton.setToolTipText("Commit changes on DBMS");
			okButton.addActionListener(new AlterTableListener());
		}
	}
	
	private void fillWithExitingTableData() {
		// Table name 
		tableName.setText(table.getName());
		
		// List of attributes
		for (int i = 0; i < table.getAttributes().size(); i++) {
			defaultListModel.addElement(table.getAttributes().get(i));
		}
	}
	
	private void setCreationModeConfiguration() {
		if (mode == TableEditorMode.CREATION) {
			setTitle(getTitle() + " - Create new table");
		}
	}
	
	private void setModificationModeConfiguration() {
		if (mode == TableEditorMode.MODIFICATION) {
			setTitle(getTitle() + " - Modify existing table");
			//tableName.setEditable(false);
			//tableName.setToolTipText("You can only alter the table schema using this edition mode");
			fillWithExitingTableData();
		}
	}
	
	private void addPaddingToMainContainer() {
		Border padding = BorderFactory.createEmptyBorder(TOP_PADDING, 
				LEFT_PADDING, BOTTOM_PADDING, RIGHT_PADDING);
		mainContainer.setBorder(padding);
	}
	
	private void buildAttrListPanel() {
		attrList.setVisibleRowCount(5);
		
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.add(eraseAttrButton);
		
		JScrollPane sp = new JScrollPane(attrList);
		sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		sp.setPreferredSize(new Dimension(ATTRLIST_WIDTH, ATTRLIST_HEIGHT));
		
		attrListPanel.setBorder(BorderFactory.createTitledBorder(ATTR_LIST_TITLE));
		attrListPanel.setLayout(new BorderLayout());
		attrListPanel.add(sp, BorderLayout.CENTER);
		attrListPanel.add(buttonsPanel, BorderLayout.SOUTH);
	}
	
	private void buildAttrEditorPanel() {
		attrEditorPanel.setLayout(new BorderLayout());
		attrEditorPanel.setBorder(BorderFactory.createTitledBorder(NEW_ATTR_TITLE));
		
		JPanel namePanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		namePanel.add(new JLabel("Name: "));
		namePanel.add(newAttrName);
		
		JPanel typePanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		typePanel.add(new JLabel("Type: "));
		typePanel.add(newAttrType);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.add(namePanel);
		mainPanel.add(typePanel);
		
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.add(addAttrButton);
		
		attrEditorPanel.add(mainPanel, BorderLayout.CENTER);
		attrEditorPanel.add(buttonsPanel, BorderLayout.SOUTH);
		
		addAttrButton.addActionListener(new AddAttrListener());
		newAttrName.addActionListener(new AddAttrListener());
	}
	
	private void resetAttrEditorPanel() {
		newAttrName.setText("");
	}
	
	private void buildWindow() {
		setTitle(WINDOW_TITLE);
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		pack();
		setLocationRelativeTo(null);
		setResizable(false);
	}
	
	public static void main(String args[]) {
		Table table = new Table("Prueba", new ArrayList<Attribute>());
		TableEditor tableEditor = new TableEditor(null, null, TableEditorMode.CREATION);
		tableEditor.setVisible(true);
	}

	private class AddAttrListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// Getting name and type for the new attribute
			String name = getNewAttrName().getText().trim();
			DataType type = (DataType) getNewAttrType().getSelectedItem();
			
			boolean isWhitespace = name.matches(WHITESPACE_REGEXP);
			
			// Name specified or whitespaces?
			if (!name.equals("") && !isWhitespace) {
				Attribute newAttr = new Attribute(name, type);
				defaultListModel.addElement((Attribute) newAttr);
				resetAttrEditorPanel();
				schemaHasChanged = true;
			}
			
			else {
				showAttrNameNotValidDialog();
			}
		}
	}
	
	private boolean nameIsValid(String name) {
		return !name.equals("") && !name.matches(WHITESPACE_REGEXP);
	}
	
	private ArrayList<Attribute> getListOfAttributes() {
		ArrayList<Attribute> attributes = new ArrayList<Attribute>();
		for (int i = 0; i < defaultListModel.size(); i++) {
			attributes.add(defaultListModel.getElementAt(i));
		}
		
		return attributes;
	}
	
	private void createNewTable() {
		String newTableName = tableName.getText();
		
		// Add table if everything is OK
		if (nameIsValid(newTableName)) {
			
			// NumOfAttributes must be > 1
			if (defaultListModel.size() < 1) {
				showWrongNumberOfAttributesDialog();
				return;
			}
			
			// Getting attributes
			ArrayList<Attribute> attributes = getListOfAttributes();
			
			// Create table on DBMS
			Table newTable = new Table(newTableName, attributes);
			try {
				
				if (!tablesManagerParent.getDatabase().containsTable(newTableName)) {
					tablesManagerParent.getDatabase().getDbmsDriver().createTable(newTable);
					tablesManagerParent.getDatabase().addTable(newTable);
				} 
				
				else {
					showTableAlreadyExistsDialog();
					return;
				}
			}
			
			catch (DuplicateTableException | SQLException e) {
				ArrayList<String> errorsMessages = new ArrayList<String>();
				errorsMessages.add(e.getMessage());
				ErrorsDialog errorsDialog = new ErrorsDialog(errorsMessages);
			}
			
			closeWindowAndRefresh();
		}
		
		else {
			showTableNameNotValidDialog();
		}
	}
	
	private class CreateTableListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			createNewTable();
		}
	}
	
	private void alterTable() {
		String newTableName = tableName.getText();
		Table originalTable = tablesManagerParent.getDatabase().getTableByName(tableOriginalName);
		
		if (nameIsValid(newTableName)) {
			
			// NumOfAttributes must be > 1
			if (defaultListModel.size() < 1) {
				showWrongNumberOfAttributesDialog();
				return;
			}
			
			try {
			
				// Just rename table
				if (!schemaHasChanged) {
					tablesManagerParent.getDatabase().getDbmsDriver().renameTable(originalTable, 
							newTableName);
					originalTable.setName(newTableName);
				}
				
				else {
					int choice = showSchemaHasChangedConfirmation();
					
					if (choice == JOptionPane.YES_OPTION) {
						// Getting attributes
						ArrayList<Attribute> attributes = getListOfAttributes();
						Table newTable = new Table(newTableName, attributes);
						
						// DROP and RE-CREATE table
						tablesManagerParent.getDatabase().getDbmsDriver().dropTable(originalTable);
						tablesManagerParent.getDatabase().removeTable(originalTable);
						tablesManagerParent.getDatabase().getDbmsDriver().createTable(newTable);
						tablesManagerParent.getDatabase().addTable(newTable);
					}
				}		
			}
			
			catch (SQLException | DuplicateTableException e) {
				ArrayList<String> errorsMessages = new ArrayList<String>();
				errorsMessages.add(e.getMessage());
				ErrorsDialog errorsDialog = new ErrorsDialog(errorsMessages);
			}
			
			closeWindowAndRefresh();
		}
	}
	
	private class AlterTableListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			alterTable();
		}
	}
	
	private void closeWindowAndRefresh() {
		// Refresh TablesManager
		tablesManagerParent.updateTablesViewer();
		
		// Close this window
		TableEditor
			.this
			.dispatchEvent(new WindowEvent(TableEditor.this, WindowEvent.WINDOW_CLOSING));
	}
	
	private void showAttrNameNotValidDialog() {
		JOptionPane.showMessageDialog(null, "The name specified for the attribute you are trying \n"
				+ "to add is empty or contains whitespaces.",
				"Attribute name not valid", JOptionPane.ERROR_MESSAGE);
	}
	
	private void showTableNameNotValidDialog() {
		JOptionPane.showMessageDialog(null, "The name specified for the table you are trying \n"
				+ "to create is empty or contains whitespaces.",
				"Table name not valid", JOptionPane.ERROR_MESSAGE);
	}
	
	private void showWrongNumberOfAttributesDialog() {
		JOptionPane.showMessageDialog(null, "There must be at least one attribute",
				"Wrong number of attributes", JOptionPane.ERROR_MESSAGE);
	}
	
	private void showTableAlreadyExistsDialog() {
		JOptionPane.showMessageDialog(null, "A table with the specified name already\nexists."
				+ "Please, choose another one.",
				"Table duplication detected", JOptionPane.ERROR_MESSAGE);
	}
	
	private int showSchemaHasChangedConfirmation() {
		int choice = 0;
		
		choice = JOptionPane.showConfirmDialog(null, 
				"This table's schema has changed. If you commit the changes, the current rows "
				+ "will be deleted. Do you want to continue?",
				"Schema has changed", JOptionPane.YES_NO_OPTION);
		
		return choice;
	}
	
	public Table getTable() {
		return table;
	}

	public void setTable(Table table) {
		this.table = table;
	}

	public JPanel getMainContainer() {
		return mainContainer;
	}

	public void setMainContainer(JPanel mainContainer) {
		this.mainContainer = mainContainer;
	}

	public JPanel getCenterPanel() {
		return centerPanel;
	}

	public void setCenterPanel(JPanel centerPanel) {
		this.centerPanel = centerPanel;
	}

	public JPanel getAttrListPanel() {
		return attrListPanel;
	}

	public void setAttrListPanel(JPanel attrListPanel) {
		this.attrListPanel = attrListPanel;
	}

	public JPanel getAttrEditorPanel() {
		return attrEditorPanel;
	}

	public void setAttrEditorPanel(JPanel attrEditorPanel) {
		this.attrEditorPanel = attrEditorPanel;
	}

	public JTextField getTableName() {
		return tableName;
	}

	public void setTableName(JTextField tableName) {
		this.tableName = tableName;
	}

	public JTextField getNewAttrName() {
		return newAttrName;
	}

	public void setNewAttrName(JTextField newAttrName) {
		this.newAttrName = newAttrName;
	}

	public JComboBox<DataType> getNewAttrType() {
		return newAttrType;
	}

	public void setNewAttrType(JComboBox<DataType> newAttrType) {
		this.newAttrType = newAttrType;
	}

	public JList<Attribute> getAttrList() {
		return attrList;
	}

	public void setAttrList(JList<Attribute> attrList) {
		this.attrList = attrList;
	}

	public DefaultListModel getDefaultListModel() {
		return defaultListModel;
	}

	public JButton getAddAttrButton() {
		return addAttrButton;
	}

	public void setAddAttrButton(JButton addAttrButton) {
		this.addAttrButton = addAttrButton;
	}

	public JButton getEraseAttrButton() {
		return eraseAttrButton;
	}

	public void setEraseAttrButton(JButton eraseAttrButton) {
		this.eraseAttrButton = eraseAttrButton;
	}

	public TablesManagerWindow getTablesManagerParent() {
		return tablesManagerParent;
	}

	public void setTablesManagerParent(TablesManagerWindow tablesManagerParent) {
		this.tablesManagerParent = tablesManagerParent;
	}

	public TableEditorMode getMode() {
		return mode;
	}

	public void setMode(TableEditorMode mode) {
		this.mode = mode;
	}

	public JButton getOkButton() {
		return okButton;
	}

	public void setOkButton(JButton okButton) {
		this.okButton = okButton;
	}

	public void setDefaultListModel(DefaultListModel<Attribute> defaultListModel) {
		this.defaultListModel = defaultListModel;
	}
	
}
