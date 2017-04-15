package es.ull.etsii.jitrax.gui.dbcreation;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

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
	
	private Table table;
	
	private JPanel mainContainer;
	private JPanel centerPanel;
	private JPanel attrListPanel;
	private JPanel attrEditorPanel;
	
	private JTextField tableName;
	private JTextField newAttrName;
	private JComboBox<DataType> newAttrType;
	private JList<Attribute> attrList;
	private DefaultListModel defaultListModel;
	private JButton addAttrButton;
	private JButton eraseAttrButton;
	
	public TableEditor(Table aTable) {
		table = aTable;
		
		mainContainer = new JPanel();
		centerPanel = new JPanel();
		attrListPanel = new JPanel();
		attrEditorPanel = new JPanel();
		
		tableName = new JTextField();
		newAttrName = new JTextField();
		newAttrType = new JComboBox<DataType>(DataType.values());
		attrList = new JList<Attribute>();
		defaultListModel = new DefaultListModel();
		attrList.setModel(defaultListModel);
	
		addAttrButton = new JButton("ADD");
		eraseAttrButton = new JButton("ERASE");
		
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
		
		buildWindow();
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
		
		attrListPanel.setBorder(BorderFactory.createTitledBorder(ATTR_LIST_TITLE));
		attrListPanel.setLayout(new BorderLayout());
		attrListPanel.add(attrList, BorderLayout.CENTER);
		attrListPanel.add(buttonsPanel, BorderLayout.SOUTH);
	}
	
	private void buildAttrEditorPanel() {
		attrEditorPanel.setLayout(new BorderLayout());
		attrEditorPanel.setBorder(BorderFactory.createTitledBorder(NEW_ATTR_TITLE));
		
		JPanel namePanel = new JPanel(new BorderLayout());
		namePanel.add(new JLabel("Name: "), BorderLayout.WEST);
		namePanel.add(newAttrName, BorderLayout.CENTER);
		
		JPanel typePanel = new JPanel(new BorderLayout());
		typePanel.add(new JLabel("Type: "), BorderLayout.WEST);
		typePanel.add(newAttrType, BorderLayout.CENTER);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.add(namePanel);
		mainPanel.add(typePanel);
		
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.add(addAttrButton);
		
		attrEditorPanel.add(mainPanel, BorderLayout.CENTER);
		attrEditorPanel.add(buttonsPanel, BorderLayout.SOUTH);
	}
	
	private void resetAttrEditorPanel() {
		newAttrName.setText("");
		newAttrType.setSelectedItem(DataType.STRING);
	}
	
	private void buildWindow() {
		setTitle(WINDOW_TITLE);
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setLocationRelativeTo(null);
	}
	
	public static void main(String args[]) {
		Table table = new Table("Prueba", new ArrayList<Attribute>());
		TableEditor tableEditor = new TableEditor(null);
		tableEditor.setVisible(true);
	}
	
}
