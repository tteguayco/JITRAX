package es.ull.etsii.jitrax.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.alee.laf.WebLookAndFeel;

import es.ull.etsii.jitrax.adt.Database;
import es.ull.etsii.jitrax.controllers.MenuBarController;
import es.ull.etsii.jitrax.interpreters.RelationalAlgebraInterpreter;

public class MainWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	private static final int FRAME_WIDTH = 1000;
	private static final int FRAME_HEIGHT = 600;
	private static final int MINIMUM_WIDTH = 800;
	private static final int MINIMUM_HEIGHT = 500;
	private static final int BORDER_GAP = 10;
	
	private static final double HORIZONTAL_SPLITPANE_DEFAULT_WEIGHT = 0.95;
	private static final double VERTICAL_SPLITPANE_DEFAULT_WEIGHT = 0.02;
	
	private static final String FRAME_TITLE = "JITRAX";
	
	private MenuBar barMenu;
	private WorkspacePanel workspacePanel;
	private Console console;
	private DatabaseViewerPanel databaseViewerPanel;
	
	private SelectedTableExchanger selectedTableExchanger;
	private RelationalAlgebraInterpreter raInterpreter;
	
	public MainWindow() {
		barMenu = new MenuBar();
		
		setJMenuBar(barMenu);
		buildWindow();
	}
	
	public void setupContent(Database database) {
		workspacePanel = new WorkspacePanel();
		console = new Console();
		databaseViewerPanel = new DatabaseViewerPanel(database);
		
		JPanel mainContainer = new JPanel(new BorderLayout());
		JPanel rightPanel = new JPanel(new BorderLayout());
		
		// HORIZONTAL SPLITPANE
		JSplitPane horSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, true,
				workspacePanel, console);
		horSplitPane.setResizeWeight(HORIZONTAL_SPLITPANE_DEFAULT_WEIGHT);
		horSplitPane.setOneTouchExpandable(true);
		
		// VERTICAL SPLITPANE
		JSplitPane verSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, 
				databaseViewerPanel, rightPanel);
		verSplitPane.setResizeWeight(VERTICAL_SPLITPANE_DEFAULT_WEIGHT);
		verSplitPane.setOneTouchExpandable(true);
		
		rightPanel.add(horSplitPane, BorderLayout.CENTER);
		mainContainer.setBorder(new EmptyBorder(BORDER_GAP, BORDER_GAP, BORDER_GAP, BORDER_GAP));
		
		setLayout(new BorderLayout());
		mainContainer.add(verSplitPane, BorderLayout.CENTER);
		add(mainContainer, BorderLayout.CENTER);
		
		// Object that shows the selected table in the quick view in the GUI
		selectedTableExchanger = new SelectedTableExchanger(databaseViewerPanel.getTablesPanel(), 
				databaseViewerPanel.getSelectedTablePanel());
		
		// Refresh this window
		SwingUtilities.updateComponentTreeUI(MainWindow.this);
	}
	
	private void buildWindow() {
		setTitle(FRAME_TITLE);
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setMinimumSize(new Dimension(MINIMUM_WIDTH, MINIMUM_HEIGHT));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		try {
	        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	        setDefaultLookAndFeelDecorated(true);
	    } 
	    catch (UnsupportedLookAndFeelException e) {
	    	e.printStackTrace();
	    }
	    catch (ClassNotFoundException e) {
	    	e.printStackTrace();
	    }
	    catch (InstantiationException e) {
	    	e.printStackTrace();
	    }
	    catch (IllegalAccessException e) {
	    	e.printStackTrace();
	    }
		
		MainWindow window = new MainWindow();
		
		// Initialize controllers
		MenuBarController menuBarController = new MenuBarController(window);
	}
	
	public MenuBar getBarMenu() {
		return barMenu;
	}

	public void setBarMenu(MenuBar barMenu) {
		this.barMenu = barMenu;
	}

	public WorkspacePanel getCodeEditorPanel() {
		return workspacePanel;
	}

	public void setCodeEditorPanel(WorkspacePanel codeEditorPanel) {
		this.workspacePanel = codeEditorPanel;
	}

	public Console getConsole() {
		return console;
	}

	public void setConsole(Console console) {
		this.console = console;
	}

	public DatabaseViewerPanel getDatabaseViewerPanel() {
		return databaseViewerPanel;
	}

	public void setDatabaseViewerPanel(DatabaseViewerPanel databaseViewerPanel) {
		this.databaseViewerPanel = databaseViewerPanel;
	}

	public SelectedTableExchanger getSelectedTableExchanger() {
		return selectedTableExchanger;
	}

	public void setSelectedTableExchanger(SelectedTableExchanger selectedTableExchanger) {
		this.selectedTableExchanger = selectedTableExchanger;
	}

	public RelationalAlgebraInterpreter getRaInterpreter() {
		return raInterpreter;
	}

	public void setRaInterpreter(RelationalAlgebraInterpreter raInterpreter) {
		this.raInterpreter = raInterpreter;
	}
}
