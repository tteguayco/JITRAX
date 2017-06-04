package es.ull.etsii.jitrax.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.tree.ParseTree;

import es.ull.etsii.jitrax.adt.Database;
import es.ull.etsii.jitrax.adt.Query;
import es.ull.etsii.jitrax.database.DbmsDriver;
import es.ull.etsii.jitrax.interpreters.RelationalAlgebraInterpreter;

public class MainWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	private static final int FRAME_WIDTH = 1050;
	private static final int FRAME_HEIGHT = 550;
	private static final int MINIMUM_WIDTH = 1050;
	private static final int MINIMUM_HEIGHT = 550;
	private static final int BORDER_GAP = 15;
	
	private static final String WELCOME_MSG = "> Welcome to JITRAX (v1.0)";
	private static final String QUERY_TRANSLATION_MSG = "> Relational Algebra query translated to SQL.";
	private static final String DBMS_EXECUTION_MSG = "> Relational Algebra query executed on DBMS.";
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
	private DbmsDriver dbmsDriver;
	private JSplitPane horSplitPane;
	
	private RelationalAlgebraInterpreter raInterpreter;
	
	public MainWindow() {
		workspace = new Workspace();
		barMenu = new MenuBar(workspace);
		queryList = new QueryList();
		console = new Console();
		databaseViewerPanel = new DatabaseViewer();
		
		mainContainer = new JPanel(new BorderLayout());
		JPanel rightPanel = new JPanel(new BorderLayout());
		JPanel rightInnerPanel = new JPanel(new BorderLayout());
		
		rightInnerPanel.add(queryList, BorderLayout.WEST);
		rightInnerPanel.add(workspace, BorderLayout.CENTER);
		
		// HORIZONTAL SPLITPANE
		horSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, true,
				rightInnerPanel, console);
		horSplitPane.setOneTouchExpandable(true);
		setUpHorSplitPaneHeight();
		
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
		
		// Make relational algebra code editor focused
		addWindowFocusListener(new WindowAdapter() {
		    public void windowGainedFocus(WindowEvent e) {
		        getWorkspace().getRelationalAlgebraCodeEditor().requestFocusInWindow();
		    }
		});
		
		/**
		 * Redirect System.out to the console in the GUI.
		 */
		redirectOutputToConsole();
	}
	
	public void addDatabase(Database database) {
		databaseViewerPanel.addDatabase(database);
		mainContainer.setVisible(true);
		barMenu.enableDisabledOptions();
	}
	
	public void setUpHorSplitPaneHeight() {
		horSplitPane.setResizeWeight(HORIZONTAL_SPLITPANE_DEFAULT_WEIGHT);
		horSplitPane.setDividerLocation(HORIZONTAL_SPLITPANE_DEFAULT_WEIGHT);
		horSplitPane.revalidate();
		revalidate();
		repaint();
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
		
		ListenersSetter menuBarController = new ListenersSetter(window);
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
		getWorkspace().getExecuteButton().addActionListener(new ExecutionListener());
		getWorkspace().getRelationalAlgebraCodeEditor().getDocument()
			.addDocumentListener(new RelationalAlgebraEditorListener());
		getQueryList().getQueryList().getSelectionModel().addListSelectionListener((new QueryExchanger()));
	}
	
	private boolean translateToSql() {
		if (getWorkspace().getRelationalAlgebraCodeEditor().getText().equals("")) {
			return false;
		}
		
		String sqlTranslation;
		Database currentDatabase = getDatabaseViewerPanel().getSelectedDatabase();
		String raInput = getWorkspace().getRelationalAlgebraCodeEditor().getText();
		RelationalAlgebraInterpreter interpreter = new RelationalAlgebraInterpreter(currentDatabase);
		
		sqlTranslation = interpreter.translate(raInput);
		
		// Successful translation
		if (sqlTranslation != null) {
			// Show ParseTree
			Parser parser = interpreter.getParser();
			ParseTree tree = interpreter.getTree();
			TreeViewer treeViewer = new TreeViewer(Arrays.asList(parser.getRuleNames()), tree);
			
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
			
			return true;
		}
		
		else {
			return false;
		}
	}
	
	private boolean executeTranslationOnDbms() {
		Database currentDatabase = getDatabaseViewerPanel().getSelectedDatabase();
		DbmsDriver postgreDriver = currentDatabase.getDbmsDriver();
		String sqlCode = getWorkspace().getSqlCodeEditor().getText();
		String statements[];
		ResultSet resultSet;
		
		// Break the translation into views and the single expression
		statements = sqlCode.split(";");
		String views[] = new String[0];
		if (statements.length > 1) {
			views = Arrays.copyOfRange(statements, 0, statements.length - 1);
		}
		String expr = statements[statements.length - 1];
		
		try {
			// Change to current Database
			postgreDriver.switchDatabase(currentDatabase.getName());
			
			// Execute views
			for (int i = 0; i < views.length; i++) {
				postgreDriver.executeUpdate(views[i]);
			}
			
			// Execute expression
			postgreDriver.executeQuery(expr);
			
			// Send the result table to the Result Viewer
			resultSet = postgreDriver.getQueryResultSet();
			getWorkspace().getQueryResultViewer().updateTableData(resultSet);
			
			// Save the query's information
			Query selectedQuery = getQueryList().getSelectedQuery();
			selectedQuery.updateResultSetDataFromTableModel(
					getWorkspace().getQueryResultViewer().getTableModel());
			getWorkspace().updateWorkspaceFromQuery(selectedQuery);
			System.out.println(DBMS_EXECUTION_MSG);
			
			return true;
		}
		
		catch (SQLException e) {
			System.out.println("\n" + DBMS_ERRORS_MSG);
			System.out.println(" - " + e.getMessage() + "\n");
			return false;
		}
	}
	
	private class ExecutionListener implements ActionListener {

		public void actionPerformed(ActionEvent evt) {
			// Translation successful?
			if (translateToSql()) {
				if (executeTranslationOnDbms()) {
					getWorkspace().switchToQueryResultTab();
				}
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
	
	private class DoneButtonTablesManagerListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			getDatabaseViewerPanel().updateSelectedDatabase();
		}
	}
	
	private static void translateGUI() {
		UIManager.put("OptionPane.yesButtonText", "Yes");
		UIManager.put("OptionPane.cancelButtonText", "Cancel");
		UIManager.put("OptionPane.okButtonText", "OK");
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

	public DbmsDriver getDbmsDriver() {
		return dbmsDriver;
	}

	public void setDbmsDriver(DbmsDriver postgreDriver) {
		this.dbmsDriver = postgreDriver;
	}

	public JSplitPane getHorSplitPane() {
		return horSplitPane;
	}

	public void setHorSplitPane(JSplitPane horSplitPane) {
		this.horSplitPane = horSplitPane;
	}
}
