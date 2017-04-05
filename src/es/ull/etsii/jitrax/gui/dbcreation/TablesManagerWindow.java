package es.ull.etsii.jitrax.gui.dbcreation;

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
import javax.swing.DefaultListModel;
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
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import es.ull.etsii.jitrax.adt.Database;
import es.ull.etsii.jitrax.adt.Table;
import es.ull.etsii.jitrax.gui.TablesViewer;
import es.ull.etsii.jitrax.listeners.TablePanelListener;
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
	
	private JPanel leftPanel;
	private JPanel rightPanel;
	private JPanel mainContainer;
	
	private TablesViewer tablesViewer;
	private SelectedTableViewer selectedTableViewer;
	
	private JButton addTableButton;
	private JButton eraseTableButton;
	private JButton modifyTableButton;
	private JButton okButton;
	
	public TablesManagerWindow(Database aDatabase) {
		database = aDatabase;
		selectedTableIndex = -1;
		mainContainer = new JPanel(new BorderLayout());
		leftPanel = new JPanel(new BorderLayout());
		rightPanel = new JPanel(new BorderLayout());
		
		selectedTableViewer = new SelectedTableViewer();
		
		addTableButton = new JButton("ADD");
		eraseTableButton = new JButton("ERASE");
		modifyTableButton = new JButton("MODIFY");
		okButton = new JButton("  ✔ OK  ");
		
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
		for (int i = 0; i < tablesViewer.getNumOfTables(); i++) {
			tablesViewer.getGraphicTables().get(i).addMouseListener(
					new TablePanelListener(tablesViewer, selectedTableViewer));
		}
		
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.add(getAddTableButton());
		buttonsPanel.add(getEraseTableButton());
		buttonsPanel.add(getModifyTableButton());
		getLeftPanel().add(buttonsPanel, BorderLayout.SOUTH);
		getLeftPanel().add(tablesListSP, BorderLayout.CENTER);
	}
	
	private void buildRightPanel() {
		//setCommonBorder(selectedTableViewer, "Content");
		
		JScrollPane contentTablePanelSP = new JScrollPane(selectedTableViewer);
		contentTablePanelSP.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		// Remove ugly borders
		contentTablePanelSP.setViewportBorder(null);
		
		JPanel bottomPanel = new JPanel(new BorderLayout());
		JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		buttonsPanel.add(getOkButton());
		bottomPanel.add(buttonsPanel, BorderLayout.SOUTH);
		getRightPanel().add(selectedTableViewer, BorderLayout.CENTER);
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
	
	public void updateSelectedTable(TablePanel tablePanel, int tablePanelIndex) {
		// Update tablesPanel
		getTablesViewer().changeSelectedTablePanelByIndex(tablePanelIndex);
		
		// Update selected table viewer
		getSelectedTableViewer().updateTable(tablePanel.getTable());
		
		revalidate();
		repaint();
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
		TablesManagerWindow tmWindow = new TablesManagerWindow(mydb);
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

	public JButton getOkButton() {
		return okButton;
	}

	public void setOkButton(JButton okButton) {
		this.okButton = okButton;
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
