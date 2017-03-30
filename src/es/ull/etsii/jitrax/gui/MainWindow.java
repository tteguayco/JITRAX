package es.ull.etsii.jitrax.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.antlr.runtime.tree.TreeParser;
import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.tree.ParseTree;

import es.ull.etsii.jitrax.adt.Database;
import es.ull.etsii.jitrax.adt.Query;
import es.ull.etsii.jitrax.database.PostgreDriver;
import es.ull.etsii.jitrax.interpreters.RelationalAlgebraInterpreter;

public class MainWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	private static final int FRAME_WIDTH = 1000;
	private static final int FRAME_HEIGHT = 600;
	private static final int MINIMUM_WIDTH = 800;
	private static final int MINIMUM_HEIGHT = 500;
	private static final int BORDER_GAP = 10;
	
	private static final String WELCOME_MSG = "> Welcome to JITRAX (v1.0)";
	private static final String QUERY_TRANSLATION_MSG = "> Relational Algebra query translated to SQL.";
	private static final String DBMS_EXECUTION_MSG = "> SQL query executed on DBMS.";
	private static final String DBMS_ERRORS_MSG = "> The DBMS detected the following error:";
	
	private static final double HORIZONTAL_SPLITPANE_DEFAULT_WEIGHT = 0.55d;
	private static final double VERTICAL_SPLITPANE_DEFAULT_WEIGHT = 0.02;
	
	private static final String FRAME_TITLE = "JITRAX";
	
	private MenuBar barMenu;
	private Workspace workspace;
	private Console console;
	private DatabaseViewer databaseViewerPanel;
	private JPanel mainContainer;
	private QueryList queryList;
	
	private RelationalAlgebraInterpreter raInterpreter;
	
	public MainWindow() {
		barMenu = new MenuBar();
		
		workspace = new Workspace();
		queryList = new QueryList();
		console = new Console();
		databaseViewerPanel = new DatabaseViewer();
		
		mainContainer = new JPanel(new BorderLayout());
		JPanel rightPanel = new JPanel(new BorderLayout());
		JPanel rightInnerPanel = new JPanel(new BorderLayout());
		
		rightInnerPanel.add(queryList, BorderLayout.WEST);
		rightInnerPanel.add(workspace, BorderLayout.CENTER);
		
		// HORIZONTAL SPLITPANE
		JSplitPane horSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, true,
				rightInnerPanel, console);
		horSplitPane.setResizeWeight(HORIZONTAL_SPLITPANE_DEFAULT_WEIGHT);
		horSplitPane.setOneTouchExpandable(true);
		
		// VERTICAL SPLITPANE
		//JSplitPane verSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, 
			//	databaseViewerPanel, rightPanel);
		//verSplitPane.setResizeWeight(VERTICAL_SPLITPANE_DEFAULT_WEIGHT);
		//verSplitPane.setOneTouchExpandable(true);
		
		rightPanel.add(horSplitPane, BorderLayout.CENTER);
		mainContainer.setBorder(new EmptyBorder(BORDER_GAP, BORDER_GAP, BORDER_GAP, BORDER_GAP));
		
		setLayout(new BorderLayout());
		mainContainer.add(databaseViewerPanel, BorderLayout.WEST);
		mainContainer.add(horSplitPane);
		add(mainContainer, BorderLayout.CENTER);
		
		mainContainer.setVisible(false);

		setJMenuBar(barMenu);
		setListeners();
		buildWindow();
		
		/**
		 * Redirect System.out to the console in the GUI.
		 */
		redirectOutputToConsole();
	}
	
	public void addDatabase(Database database) {
		databaseViewerPanel.addDatabase(database);
		mainContainer.setVisible(true);
		barMenu.enableSavingOptions();
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
		
		MainWindow window = new MainWindow();
		translateGUI();
		
		System.out.println(WELCOME_MSG + "\n");
		
		MenuBarListenersSetter menuBarController = new MenuBarListenersSetter(window);
	}
	
	/**
	 * After a call to this method, everything written through 
	 * System.out will be displayed in the GUI console.
	 */
	private void redirectOutputToConsole() {
		
		class ConsoleOutputStream extends ByteArrayOutputStream {
			@Override
			public void write(byte[] bytes, int off, int len) {
				String message = new String(bytes, off, len, StandardCharsets.UTF_8);
				getConsole().appendMessage(message);
			}
		}
		
		PrintStream ps = new PrintStream(new ConsoleOutputStream());
		System.setOut(ps);
	}
	
	private void setListeners() {
		getWorkspace().getTranslateButton().addActionListener(new TranslationListener());
		getWorkspace().getExecuteButton().addActionListener(new ExecutionListener());
		getWorkspace().getRelationalAlgebraCodeEditor().getDocument()
			.addDocumentListener(new RelationalAlgebraEditorListener());
		getQueryList().getQueryList().addListSelectionListener(new QueryExchanger());
	}
	
	private class TranslationListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (getWorkspace().getRelationalAlgebraCodeEditor().getText().equals("")) {
				return;
			}
			
			String sqlTranslation;
			Database currentDatabase = getDatabaseViewerPanel().getSelectedDatabase();
			String raInput = getWorkspace().getRelationalAlgebraCodeEditor().getText();
			RelationalAlgebraInterpreter interpreter = new RelationalAlgebraInterpreter(currentDatabase);
			
			sqlTranslation = interpreter.translate(raInput);
			
			// Successful translation
			if (sqlTranslation != null) {
				getWorkspace().setSqlTranslation(sqlTranslation);
				
				// Show ParseTree
				Parser parser = interpreter.getParser();
				ParseTree tree = interpreter.getTree();
				TreeViewer treeViewer = new TreeViewer(Arrays.asList(parser.getRuleNames()),tree);
				
		        // Save information into query
		        Query selectedQuery = getQueryList().getSelectedQuery();
		        selectedQuery.setSqlTranslation(sqlTranslation);
		        selectedQuery.setTreeViewer(treeViewer);
		        
		        // Update workspace fields
		        try {
					getWorkspace().updateWorkspaceFromQuery(selectedQuery);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
		        
				getWorkspace().switchToSqlTab();
		        
				System.out.println(QUERY_TRANSLATION_MSG);
			}
			
			// Errors...
			else {
				
			}
		}
	}
	
	private class ExecutionListener implements ActionListener {

		public void actionPerformed(ActionEvent evt) {
			Database currentDatabase = getDatabaseViewerPanel().getSelectedDatabase();
			PostgreDriver postgreDriver = currentDatabase.getPostgreDriver();
			String sqlCode = getWorkspace().getSqlCodeEditor().getText();
			String statements[];
			ResultSet resultSet;
			
			// Break the translation into views and the single expression
			statements = sqlCode.split(";");
			String views[] = new String[0];
			if (statements.length > 1) {
				views = Arrays.copyOfRange(statements, 0, statements.length - 2);
			}
			String expr = statements[statements.length - 1];
			
			try {
				
				// Execute views
				for (int i = 0; i < views.length; i++) {
					postgreDriver.executeQuery(views[i]);
				}
				
				// Execute expression
				postgreDriver.executeQuery(expr);
				
				// Send the result table to the Result Viewer
				resultSet = postgreDriver.getQueryResultSet();
				
				// Save the query's information
				Query selectedQuery = getQueryList().getSelectedQuery();
				selectedQuery.setResultSet(resultSet);
				getWorkspace().updateWorkspaceFromQuery(selectedQuery);
				
				getWorkspace().switchToQueryResultTab();
				
				System.out.println(DBMS_EXECUTION_MSG);
			}
			
			catch (SQLException e) {
				System.out.println(DBMS_ERRORS_MSG);
				System.out.println(" - " + e.getMessage());
			}
		}
	}
	
	private class RelationalAlgebraEditorListener implements DocumentListener {
		Query selectedQuery;
		
		private void updateWorkspace() {
			selectedQuery = getQueryList().getSelectedQuery();
			String raExpr = getWorkspace().getRelationalAlgebraCodeEditor().getText();
			selectedQuery.setRelationalAlgebraExpr(raExpr);
		}
		
		@Override
		public void changedUpdate(DocumentEvent arg0) {
			updateWorkspace();
		}

		@Override
		public void insertUpdate(DocumentEvent arg0) {
			updateWorkspace();
		}

		@Override
		public void removeUpdate(DocumentEvent arg0) {
			updateWorkspace();
		}
	}
	
	private class QueryExchanger implements ListSelectionListener {

		@Override
		public void valueChanged(ListSelectionEvent e) {
			Query selectedQuery = getQueryList().getSelectedQuery();
			try {
				getWorkspace().updateWorkspaceFromQuery(selectedQuery);
				getWorkspace().switchToRelationalAlgebraTab();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	private static void translateGUI() {
		UIManager.put("OptionPane.yesButtonText", "Yes");
	}
	
	public MenuBar getBarMenu() {
		return barMenu;
	}

	public void setBarMenu(MenuBar barMenu) {
		this.barMenu = barMenu;
	}

	public Workspace getWorkspace() {
		return workspace;
	}

	public void setWorkspace(Workspace codeEditorPanel) {
		this.workspace = codeEditorPanel;
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

	public RelationalAlgebraInterpreter getRaInterpreter() {
		return raInterpreter;
	}

	public void setRaInterpreter(RelationalAlgebraInterpreter raInterpreter) {
		this.raInterpreter = raInterpreter;
	}

	public QueryList getQueryList() {
		return queryList;
	}

	public void setQueryList(QueryList queryList) {
		this.queryList = queryList;
	}
}
