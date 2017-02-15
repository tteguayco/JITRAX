package es.ull.etsii.jitrax.gui.databaseSetup;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import es.ull.etsii.jitrax.adt.Database;
import es.ull.etsii.jitrax.adt.Table;

public class TablesManagerWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private static final String WINDOW_TITLE = "Tables Manager - ";
	private static final int WINDOW_WIDTH = 700;
	private static final int WINDOW_HEIGHT = 500;
	private static final int TABLELIST_VISIBLE_ROWS = 10;
	private static final int TOP_PADDING = 10;
	private static final int LEFT_PADDING = 10;
	private static final int BOTTOM_PADDING = 15;
	private static final int RIGHT_PADDING = 10;
	
	private Database database;
	private int selectedTableIndex;
	
	private JList tablesList;
	private JPanel schemaPanel;
	private JPanel selectedTableContentPanel;
	private JTable selectedTableContent;
	private DefaultTableModel selectedTableContentModel;
	private JPanel mainContainer;
	
	private JButton addTableButton;
	private JButton eraseTableButton;
	private JButton modifyTableButton;
	
	public TablesManagerWindow(Database aDatabase) {
		database = aDatabase;
		selectedTableIndex = -1;
		tablesList = new JList();
		schemaPanel = new JPanel();
		selectedTableContentPanel = new JPanel();
		selectedTableContent = new JTable();
		selectedTableContentModel = new DefaultTableModel();
		mainContainer = new JPanel(new BorderLayout());
		
		addTableButton = new JButton("ADD");
		eraseTableButton = new JButton("ERASE");
		modifyTableButton = new JButton("MODIFY");
		
		// Main container
		EmptyBorder padding = new EmptyBorder(TOP_PADDING, 
											LEFT_PADDING, 
											BOTTOM_PADDING, 
											RIGHT_PADDING);
		mainContainer.setBorder(padding);
		add(mainContainer);
		
		
		buildTablesListPanel();
		buildSchemaPanel();
		
		// SELECTED TABLE CONTENT PANEL
		selectedTableContent.setModel(selectedTableContentModel);
		
		JPanel rightPanel = new JPanel(new BorderLayout(10, 10));
		JScrollPane schemaPanelSP = new JScrollPane(schemaPanel);
		schemaPanelSP.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		rightPanel.add(schemaPanelSP, BorderLayout.NORTH);
		rightPanel.add(selectedTableContentPanel, BorderLayout.CENTER);
		mainContainer.add(rightPanel, BorderLayout.CENTER);
		
		buildWindow();
	}
	
	private void buildWindow() {
		setTitle(WINDOW_TITLE + getDatabase().getName());
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private void buildTablesListPanel() {
		String[] tablesNames = getDatabase().getTablesNames();
		getTablesList().setListData(tablesNames);
		getTablesList().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		getTablesList().setLayoutOrientation(JList.VERTICAL_WRAP);
		JScrollPane tablesListSP = new JScrollPane(getTablesList());
		tablesListSP.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		JPanel leftPanel = new JPanel(new BorderLayout());
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.add(getAddTableButton());
		buttonsPanel.add(getEraseTableButton());
		buttonsPanel.add(getModifyTableButton());
		leftPanel.add(buttonsPanel, BorderLayout.NORTH);
		leftPanel.add(tablesListSP, BorderLayout.CENTER);
		getMainContainer().add(leftPanel, BorderLayout.WEST);
		
		getTablesList().addListSelectionListener(new ListSelectionListener() {			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// Update selectedTablePanelSchema and selectedTablePanelContent
				setSelectedTableIndex(getTablesList().getSelectedIndex());
				updateSelectedTableSchema();
				updateSelectedTableContent();
			}
		});
	}
	
	private void updateSelectedTableSchema() {
		
	}
	
	private void updateSelectedTableContent() {
		
	}
	
	private void buildSchemaPanel() {
		getSchemaPanel().setBorder(BorderFactory.createTitledBorder(
				new LineBorder(Color.GRAY),
                "Schema",
                TitledBorder.LEFT,
                TitledBorder.TOP,
                null,
                Color.BLACK));
		
		getSchemaPanel().setPreferredSize(new Dimension(450, 80));
	}
	
	private void buildTableContentPanel() {
		getSchemaPanel().setBorder(BorderFactory.createTitledBorder(
				new LineBorder(Color.GRAY),
                "Content",
                TitledBorder.LEFT,
                TitledBorder.TOP,
                null,
                Color.GRAY));
		
		add(getSelectedTableContent());
	}
	
	private Table getSelectedTable() {
		return getDatabase().getTables().get(getSelectedTableIndex());
	}
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			System.out.println("Unsupported Lookn' Feel. Setting the default one...");
			e.printStackTrace();
		}
		
		Database mydb = new Database("MyDB");
		TablesManagerWindow tmWindow = new TablesManagerWindow(mydb);
	}

	public Database getDatabase() {
		return database;
	}

	public void setDatabase(Database database) {
		this.database = database;
	}

	public JList getTablesList() {
		return tablesList;
	}

	public void setTablesList(JList tablesList) {
		this.tablesList = tablesList;
	}

	public JPanel getSchemaPanel() {
		return schemaPanel;
	}

	public void setSchemaPanel(JPanel schemaPanel) {
		this.schemaPanel = schemaPanel;
	}

	public JTable getSelectedTableContent() {
		return selectedTableContent;
	}

	public void setSelectedTableContent(JTable selectedTableContent) {
		this.selectedTableContent = selectedTableContent;
	}

	public DefaultTableModel getSelectedTableContentModel() {
		return selectedTableContentModel;
	}

	public void setSelectedTableContentModel(DefaultTableModel selectedTableContentModel) {
		this.selectedTableContentModel = selectedTableContentModel;
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
}
