package es.ull.etsii.jitrax.gui.tables;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
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
	private static final String SCHEMA_PANEL_DEFAULT_MESSAGE = "No tables were found";
	
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
	
	private JList tablesList;
	private JPanel schemaPanel;
	private JTable selectedTableContent;
	private DefaultTableModel selectedTableContentModel;
	private JPanel leftPanel;
	private JPanel rightPanel;
	private JPanel mainContainer;
	
	private JButton addTableButton;
	private JButton eraseTableButton;
	private JButton modifyTableButton;
	private JButton okButton;
	
	public TablesManagerWindow(Database aDatabase) {
		database = aDatabase;
		selectedTableIndex = -1;
		tablesList = new JList();
		selectedTableContent = new JTable();
		selectedTableContentModel = new DefaultTableModel();
		schemaPanel = new JPanel();
		mainContainer = new JPanel(new BorderLayout());
		leftPanel = new JPanel(new BorderLayout());
		rightPanel = new JPanel(new BorderLayout());
		
		schemaPanel.setLayout(new BoxLayout(schemaPanel, BoxLayout.X_AXIS));
		addTableButton = new JButton("ADD");
		eraseTableButton = new JButton("ERASE");
		modifyTableButton = new JButton("MODIFY");
		okButton = new JButton("  ✔ OK  ");

		EmptyBorder schemaPanelPadding = new EmptyBorder(10, 10, 10, 10);
		
		schemaPanel.add(Box.createHorizontalStrut(SCHEMA_PANEL_GAP));
		schemaPanel.add(new JLabel(SCHEMA_PANEL_DEFAULT_MESSAGE));
		schemaPanel.add(Box.createHorizontalStrut(SCHEMA_PANEL_GAP));
		selectedTableContent.setModel(selectedTableContentModel);
		
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private void buildLeftPanel() {
		String[] tablesNames = getDatabase().getTablesNames();
		setCommonBorder(getLeftPanel(), "Tables");
		getTablesList().setListData(tablesNames);
		getTablesList().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		getTablesList().setLayoutOrientation(JList.VERTICAL_WRAP);
		JScrollPane tablesListSP = new JScrollPane(getTablesList());
		tablesListSP.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.add(getAddTableButton());
		buttonsPanel.add(getEraseTableButton());
		buttonsPanel.add(getModifyTableButton());
		getLeftPanel().add(buttonsPanel, BorderLayout.SOUTH);
		getLeftPanel().add(tablesListSP, BorderLayout.CENTER);
		
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
	
	private void buildRightPanel() {
		JPanel contentTablePanel = new JPanel(new BorderLayout());
		
		setCommonBorder(getSchemaPanel(), "Schema");
		setCommonBorder(contentTablePanel, "Content");
		
		contentTablePanel.add(getSelectedTableContent(), BorderLayout.CENTER);
		
		JScrollPane schemaPanelSP = new JScrollPane(getSchemaPanel());
		JScrollPane contentTablePanelSP = new JScrollPane(contentTablePanel);
		schemaPanelSP.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		contentTablePanelSP.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		// Remove ugly borders
		schemaPanelSP.setViewportBorder(null);
		contentTablePanelSP.setViewportBorder(null);
		
		JPanel bottomPanel = new JPanel(new BorderLayout());
		JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		buttonsPanel.add(getOkButton());
		bottomPanel.add(schemaPanelSP, BorderLayout.CENTER);
		bottomPanel.add(buttonsPanel, BorderLayout.SOUTH);
		getRightPanel().add(contentTablePanelSP, BorderLayout.CENTER);
		getRightPanel().add(bottomPanel, BorderLayout.SOUTH);
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
	
	private void updateSelectedTableSchema() {
		
	}
	
	private void updateSelectedTableContent() {
		
	}
	
	private Table getSelectedTable() {
		return getDatabase().getTables().get(getSelectedTableIndex());
	}
	
	private void setListeners() {
		getAddTableButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				NewTableWindow newTableWindow = new NewTableWindow();
				
				
			}
		});
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

	public JButton getOkButton() {
		return okButton;
	}

	public void setOkButton(JButton okButton) {
		this.okButton = okButton;
	}
}
