package es.ull.etsii.jitrax.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import es.ull.etsii.jitrax.adt.Database;
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
	private Workspace workspacePanel;
	private Console console;
	private DatabaseViewer databaseViewerPanel;
	private JPanel mainContainer;
	
	private SelectedTableExchanger selectedTableExchanger;
	private RelationalAlgebraInterpreter raInterpreter;
	
	
	public MainWindow() {
		barMenu = new MenuBar();
		
		workspacePanel = new Workspace();
		console = new Console();
		databaseViewerPanel = new DatabaseViewer();
		
		mainContainer = new JPanel(new BorderLayout());
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
		
		mainContainer.setVisible(false);

		setJMenuBar(barMenu);
		buildWindow();
		
		/**
		 * Redirect System.out to the console in the GUI.
		 */
		redirectOutputToConsole();
	}
	
	public void addDatabase(Database database) {
		databaseViewerPanel.addDatabase(database);
		mainContainer.setVisible(true);
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
		
		System.out.println("> Welcome to JITRAX (v1.0)\n");
		
		MenuBarListenersSetter menuBarController = new MenuBarListenersSetter(window);
		
		UIManager.put("OptionPane.cancelButtonText", "Cancel");
	    UIManager.put("OptionPane.noButtonText", "No");
	    UIManager.put("OptionPane.okButtonText", "OK");
	    UIManager.put("OptionPane.yesButtonText", "Yes");
	}
	
	/**
	 * Everything written through System.out will be displayed in the console.
	 */
	public void redirectOutputToConsole() {
		
		class ConsoleOutputStream extends ByteArrayOutputStream {
			@Override
			public void write(byte[] bytes, int off, int len) {
				String message = new String(bytes, off, len, StandardCharsets.UTF_8);
				console.appendMessage(message);
			}
		}
		
		PrintStream ps = new PrintStream(new ConsoleOutputStream());
		System.setOut(ps);
	}
	
	public MenuBar getBarMenu() {
		return barMenu;
	}

	public void setBarMenu(MenuBar barMenu) {
		this.barMenu = barMenu;
	}

	public Workspace getCodeEditorPanel() {
		return workspacePanel;
	}

	public void setCodeEditorPanel(Workspace codeEditorPanel) {
		this.workspacePanel = codeEditorPanel;
	}

	public Console getConsole() {
		return console;
	}

	public void setConsole(Console console) {
		this.console = console;
	}

	public DatabaseViewer getDatabaseViewerPanel() {
		return databaseViewerPanel;
	}

	public void setDatabaseViewerPanel(DatabaseViewer databaseViewerPanel) {
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
