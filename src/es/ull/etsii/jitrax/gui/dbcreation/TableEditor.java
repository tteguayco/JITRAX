package es.ull.etsii.jitrax.gui.dbcreation;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import es.ull.etsii.jitrax.adt.DataType;;

public class TableEditor extends JFrame {
	private static final String WINDOW_TITLE = "Table Editor";
	private static final String ATTR_LIST_TITLE = "Attributes";
	private static final String NEW_ATTR_TITLE = "New";
	
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
	private static final int ATTRLIST_WIDTH = 150;
	private static final int ATTRLIST_HEIGHT = 150;
	
	private Table table;
	private TableEditorMode mode;
	
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
	
	public TableEditor(Table aTable, TableEditorMode aMode) {
		table = aTable;
		mode = aMode;
		
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
		
		setOkButtonText();
		
		buildWindow();
		pack();
	}
	
	private void setOkButtonText() {
		if (mode == TableEditorMode.CREATION) {
			okButton.setText("✔ CREATE");
			okButton.setToolTipText("Create table");
		} 
		
		else if (mode == TableEditorMode.MODIFICATION) {
			okButton.setText("✔ APPLY");
			okButton.setToolTipText("Apply changes");
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
	}
	
	private void resetAttrEditorPanel() {
		newAttrName.setText("");
		newAttrType.setSelectedItem(DataType.STRING);
	}
	
	private void buildWindow() {
		setTitle(WINDOW_TITLE);
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setLocationRelativeTo(null);
		setResizable(false);
		
		if (mode == TableEditorMode.CREATION) {
			setTitle(getTitle() + " - Create new table");
		} else if (mode == TableEditorMode.MODIFICATION) {
			setTitle(getTitle() + " - Modify existing table");
		}
	}
	
	public static void main(String args[]) {
		Table table = new Table("Prueba", new ArrayList<Attribute>());
		TableEditor tableEditor = new TableEditor(null, TableEditorMode.CREATION);
		tableEditor.setVisible(true);
	}

	private class AddAttrListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// Getting name and type for the new attribute
			String name = getNewAttrName().getText().trim();
			DataType type = (DataType) getNewAttrType().getSelectedItem();
			
			boolean isWhitespace = name.matches(".*\\s+.*");
			
			// Name specified or whitespaces?
			if (!name.equals("") && !isWhitespace) {
				Attribute newAttr = new Attribute(name, type);
				defaultListModel.addElement((Attribute) newAttr); 
			}
			
			else {
				showAttrNameNotValidDialog();
			}
		}
	}
	
	private void showAttrNameNotValidDialog() {
		JOptionPane.showMessageDialog(null, "The name specified for the attribute you are trying \n"
				+ "to add is empty or contains whitespaces.",
				"Attribute name not valid", JOptionPane.ERROR_MESSAGE);
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

	public void setDefaultListModel(DefaultListModel defaultListModel) {
		this.defaultListModel = defaultListModel;
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
	
}
