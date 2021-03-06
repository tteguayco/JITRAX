package es.ull.etsii.jitrax.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.print.PrintException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;

import org.antlr.v4.gui.TreeViewer;
import org.postgresql.util.PSQLException;

import es.ull.etsii.jitrax.adt.Database;
import es.ull.etsii.jitrax.database.DatabaseComparator;
import es.ull.etsii.jitrax.database.DbmsDriver;
import es.ull.etsii.jitrax.database.MySqlDriver;
import es.ull.etsii.jitrax.database.PostgreSqlDriver;
import es.ull.etsii.jitrax.gui.dbcreation.NewDatabaseDialog;
import es.ull.etsii.jitrax.gui.dbcreation.TablesManagerWindow;
import es.ull.etsii.jitrax.gui.dialogs.DBMSConnectionWindow;
import es.ull.etsii.jitrax.gui.dialogs.ErrorsDialog;
import es.ull.etsii.jitrax.gui.dialogs.FileDialog;

public class ListenersSetter {
	private static final int RA_QUERY_MAX_CHAR = 1000;
	
	private MainWindow mainWindow;
	private String lastSavingLocation;
	private FileDialog fileDialog;
	private DbmsDriver dbmsDriver;
	
	public ListenersSetter(MainWindow aMainWindow) {
		mainWindow = aMainWindow;
		lastSavingLocation = "";
		fileDialog = new FileDialog();
		setFileMenuListeners();
	}
	
	private void setFileMenuListeners() {
		getMainWindow().getBarMenu().getOpenDatabase().addActionListener(new OpenListener());
		getMainWindow().getBarMenu().getNewDatabase().addActionListener(new NewDatabaseListener());
		getMainWindow().getBarMenu().getSaveDatabase().addActionListener(new SaveListener());
		getMainWindow().getBarMenu().getSaveDatabaseAs().addActionListener(new SaveAsListener());
		getMainWindow().getBarMenu().getExitOption().addActionListener(new ExitListener());
		getMainWindow().getBarMenu().getImportRelAlgQuery().addActionListener(new ImportationOptionListener());
		getMainWindow().getBarMenu().getExportRelAlgQuery().addActionListener(new ExportationOptionListener());
		getMainWindow().getBarMenu().getExportSqlQuery().addActionListener(new ExportationOptionListener());
		getMainWindow().getQueryList().getSaveButton().addActionListener(new ExportationOptionListener());
		getMainWindow().getBarMenu().getExportQueryResultTable().addActionListener(new ExportationOptionListener());
		getMainWindow().getBarMenu().getExportParseTree().addActionListener(new ExportationOptionListener());
		getMainWindow().getBarMenu().getRaCodeHighLighting().addActionListener(new HighlightingEnabler());
		getMainWindow().getBarMenu().getSqlCodeHighLighting().addActionListener(new HighlightingEnabler());
		getMainWindow().getBarMenu().getConsoleShow().addActionListener(new ViewsHidder());
		getMainWindow().getBarMenu().getDbViewerShow().addActionListener(new ViewsHidder());
		getMainWindow().getBarMenu().getQueriesListShow().addActionListener(new ViewsHidder());
		getMainWindow().getBarMenu().getEnglishRadioButton().addActionListener(new LanguageHandler());
		getMainWindow().getBarMenu().getSpanishRadioButton().addActionListener(new LanguageHandler());
		getMainWindow().getBarMenu().getAboutOption().addActionListener(new AboutListener());
	}
	
	private class NewDatabaseListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			NewDatabaseDialog newDatabaseDialog = new NewDatabaseDialog();
			newDatabaseDialog.getNextButton().addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					String newDatabaseName = newDatabaseDialog.getNewDatabaseNameField().getText();
					if (!newDatabaseName.equals("")) {
						Database newDatabase = new Database(newDatabaseName);
						TablesManagerWindow tablesManagerWindow = 
								new TablesManagerWindow(newDatabase, mainWindow.getDatabaseViewerPanel());
					}
				}
			});
		}
	}
	
	private class OpenListener implements ActionListener {

		private void readDatabase(DbmsDriver postgreDriver) throws SQLException {
			FileDialog fileDialog = new FileDialog();
			Database importedDatabase = fileDialog.importDatabaseDialog();
			
			if (importedDatabase != null) {
				
				if (databaseAlreadyExists(importedDatabase.getName())) {
					showDatabaseAlreadyExistsDialog();
					return;
				}
			
				// Assign a PostgreDriver to the new database
				importedDatabase.setDbmsDriver(postgreDriver);
				
				// If it does not exist, create, switch and set it up
				if (!postgreDriver.databaseAlreadyExists(importedDatabase.getName())) {
					postgreDriver.createDatabase(importedDatabase.getName());
					postgreDriver.switchDatabase(importedDatabase.getName());
					postgreDriver.setUpDatabase(importedDatabase);
					
					// Add new database to the environment
					mainWindow.addDatabase(importedDatabase);
					System.out.println("> Database '" + importedDatabase.getName() + 
							"' was created.");
				}
				
				else {
					// Switch to the existing database
					postgreDriver.switchDatabase(importedDatabase.getName());
					// Initialize comparator
					DatabaseComparator dbComparator = new DatabaseComparator(
							importedDatabase, postgreDriver.getConnection());
					
					// Ask for overwriting
					int choice = showOverwritingQuestionDialog();
					
					if (choice == JOptionPane.YES_OPTION) {
						
						try {
							dbComparator.overwriteDatabaseOnDbms();
						}
						 catch (SQLException e) {
							 // A common error would be: the user does not have enough
							 // permissions to overwrite. 
							 ArrayList<String> errors = new ArrayList<String>();
							 errors.add(e.getMessage());
							 ErrorsDialog errorsDialog = new ErrorsDialog(errors);
						 }
						
						mainWindow.addDatabase(importedDatabase);
						System.out.println("> Database '" + importedDatabase.getName() +
								"' was overwritten on DBMS.");
					}
		
					// Check schemas and contents
					else if (choice == JOptionPane.NO_OPTION) {
						if (dbComparator.databasesAreCompatible()) {
							mainWindow.addDatabase(importedDatabase);
							System.out.println("> Database '" + importedDatabase.getName() +
									"' was retrieved from DBMS.");
						}
						
						else {
							showDatabasesTablesSchemasDiffers();
						}
					}
		
				}
					
			}
		}
		
		public void actionPerformed(ActionEvent arg0) {
			if (getMainWindow().getDbmsDriver() == null) {
				DBMSConnectionWindow dbmsConnectionWindow = new DBMSConnectionWindow(mainWindow);
				
				dbmsConnectionWindow.getNextButton().addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent event) {
						dbmsConnectionWindow.dispose();
						
						// GET DBMS PARAMETERS
						String hostname = dbmsConnectionWindow.getHostname().getText();
						String port = dbmsConnectionWindow.getPort().getText();
						String username = dbmsConnectionWindow.getUsername().getText();
						String password = new String(dbmsConnectionWindow.getPassword().getPassword());
						
						hostname.trim();
						port.trim();
						username.trim();
						
						// Empty fields are not allowed
						if (hostname.equals("") || port.equals("") 
								|| username.equals("") || password.equals("")) {
							showRequiredFieldsDialog();
						}
						
						try {
							
							// DBMS to work with
							if (dbmsConnectionWindow.postgreIsSelected()) {
								dbmsDriver = new PostgreSqlDriver(hostname, 
										port, 
										username, 
										password);
							} else if (dbmsConnectionWindow.mysqlIsSelected()) {
								dbmsDriver = new MySqlDriver(hostname, 
										port, 
										username, 
										password);
							}
							
							getMainWindow().setDbmsDriver(dbmsDriver);
							readDatabase(dbmsDriver);
						} 

						// Errors? Show them
						catch (SQLException e) {
							ArrayList<String> errors = new ArrayList<String>();
							errors.add(e.getMessage());
							ErrorsDialog errorsDialog = new ErrorsDialog(errors);
						}
						
						catch (Exception e) {
							ArrayList<String> errors = new ArrayList<String>();
							errors.add("Unknown error while connecting to the DBMS.");
							ErrorsDialog errorsDialog = new ErrorsDialog(errors);
						}
					}
				});
			}
			
			else {
				dbmsDriver = getMainWindow().getDbmsDriver();
				try {
					readDatabase(dbmsDriver);
				} catch (SQLException e) {
					ArrayList<String> errors = new ArrayList<String>();
					errors.add(e.getMessage());
					ErrorsDialog errorsDialog = new ErrorsDialog(errors);
				}
			}
		}
			
	}
	
	private class SaveListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			Database currentDatabase = getMainWindow().getDatabaseViewerPanel().getSelectedDatabase();
			String currentDatabaseString = currentDatabase.toDSL();
			
			// Save As if there is not a lastSavingLocation
			if (getLastSavingLocation().equals("")) {
				getMainWindow().getBarMenu().getSaveDatabaseAs().doClick();
			} 
			
			// Save in last location
			else {
				PrintWriter printWriter;
				try {
					printWriter = new PrintWriter(getLastSavingLocation());
					printWriter.print(currentDatabaseString);
					printWriter.close();
				} 
				catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
	
	private class SaveAsListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			FileDialog fileDialog = new FileDialog();
			Database currentDatabase = getMainWindow().getDatabaseViewerPanel().getSelectedDatabase();
			String currentDatabaseString = currentDatabase.toDSL();
			fileDialog.exportFile("Save Database", currentDatabaseString, ".db");
			setLastSavingLocation(fileDialog.getLastSavingLocation());
		}
	}
	
	private class ExitListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			int dialogResult = JOptionPane.showConfirmDialog (null, 
					"Are you sure you want to exit JITRAX?",
					"Confirm Exit",
					JOptionPane.YES_NO_OPTION);
			
			if(dialogResult == JOptionPane.YES_OPTION){
				getMainWindow().dispose();
			}
		}
	}
	
	private class ImportationOptionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// Import RA query?
			if (e.getSource() == getMainWindow().getBarMenu().getImportRelAlgQuery()) {
				// Read file
				String raQuery = fileDialog.importFileContent("Import Relational Algebra Query");
					
				if (raQuery != null) {
					// Too big?
					if (raQuery.length() > RA_QUERY_MAX_CHAR) {
						showFileTooLongDialog();
					}
						
					// Create new query in the queries list
					getMainWindow().getQueryList().getAddButton().doClick();
					// Fill the RA editor
					getMainWindow().getWorkspace().getRelationalAlgebraCodeEditor().setText(raQuery);
				}
			}
		}
	}
	
	private class ExportationOptionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String fileName = (String) getMainWindow().getQueryList().getSelectedQuery().getName();
			
			// Export RA query?
			if (e.getSource() == getMainWindow().getBarMenu().getExportRelAlgQuery()
					|| e.getSource() == getMainWindow().getQueryList().getSaveButton()) {
				String raQuery = getMainWindow().getWorkspace().getRelationalAlgebraCodeEditor().getText();
				
				if (raQuery.length() > 0) {
					fileDialog.exportFile("Export Relational Algebra Query", raQuery, fileName + ".ra");
				}	
			}
			
			// Export SQL query
			else if (e.getSource() == getMainWindow().getBarMenu().getExportSqlQuery()) {
				String sqlQuery = getMainWindow().getWorkspace().getSQLCodeEditor().getText();
				
				if (sqlQuery.length() > 0) {
					fileDialog.exportFile("Export SQL Query", sqlQuery, fileName + ".sql");
				}
			}
			
			// Export Parse Tree
			else if (e.getSource() == getMainWindow().getBarMenu().getExportParseTree()) {
				FileDialog fileDialog = new FileDialog();
				TreeViewer treeViewer = getMainWindow().getWorkspace().getParseTreeViewer();
				fileDialog.exportParseTree("Export Parse Tree", treeViewer, fileName + ".png");
			}
			
			// Export Result Table
			else if (e.getSource() == getMainWindow().getBarMenu().getExportQueryResultTable()) {
				QueryResultViewer queryResultViewer = getMainWindow().getWorkspace().getQueryResultViewer();
				if (queryResultViewer != null) {
					if (!queryResultViewer.isEmpty()) {
						String content = queryResultViewer.toCSV();
						fileDialog.exportFile("Export Result Table", content, fileName + ".csv");
					}
				}
			}
		}
	}
	
	private class HighlightingEnabler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == getMainWindow().getBarMenu().getRaCodeHighLighting()) {
				if (((JCheckBoxMenuItem) e.getSource()).isSelected()) {
					getMainWindow().getWorkspace().enableSyntaxEditingRaEditor();
				} else {
					getMainWindow().getWorkspace().disableSyntaxEditingRaEditor();
				}
			}
			
			else if (e.getSource() == getMainWindow().getBarMenu().getSqlCodeHighLighting()) {
				if (((JCheckBoxMenuItem) e.getSource()).isSelected()) {
					getMainWindow().getWorkspace().enableSyntaxEditingSqlEditor();
				} else {
					getMainWindow().getWorkspace().disableSyntaxEditingSqlEditor();
				}
			}
		}
	}
	
	private class ViewsHidder implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// CONSOLE VIEW
			if (e.getSource() == getMainWindow().getBarMenu().getConsoleShow()) {
				if (((JCheckBoxMenuItem) e.getSource()).isSelected()) {
					getMainWindow().getConsole().setVisible(true);
				} else {
					getMainWindow().getConsole().setVisible(false);
				}
			}
			
			// DB VIEWER VIEW
			else if (e.getSource() == getMainWindow().getBarMenu().getDbViewerShow()) {
				if (((JCheckBoxMenuItem) e.getSource()).isSelected()) {
					getMainWindow().getDatabaseViewerPanel().setVisible(true);
				} else {
					getMainWindow().getDatabaseViewerPanel().setVisible(false);
				}
			}
			
			// QUERIES LIST
			else if (e.getSource() == getMainWindow().getBarMenu().getQueriesListShow()) {
				if (((JCheckBoxMenuItem) e.getSource()).isSelected()) {
					getMainWindow().getQueryList().setVisible(true);
					getMainWindow().setUpHorSplitPaneHeight();
					getMainWindow().revalidate();
					getMainWindow().repaint();
				} else {
					getMainWindow().getQueryList().setVisible(false);
				}
			}
		}
	}

	private class LanguageHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			if (actionEvent.getSource() == getMainWindow().getBarMenu().getEnglishRadioButton()) {
				getMainWindow().setLocale(new Locale("en"));
			}

			else if (actionEvent.getSource() == getMainWindow().getBarMenu().getSpanishRadioButton()) {
				getMainWindow().setLocale(new Locale("es"));
			}

			getMainWindow().translate();
		}
	}
	
	private class AboutListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			AboutWindow aboutWindow = new AboutWindow();
		}
	}
	
	private boolean databaseAlreadyExists(String aDatabaseName) {
		int databaseIndex = ((DefaultComboBoxModel) getMainWindow()
				.getDatabaseViewerPanel()
				.getSelectedDatabaseViewer()
				.getCombo()
				.getModel()).getIndexOf(aDatabaseName);
				
		if (databaseIndex < 0) {
			return false;
		}
		
		return true;
	}
	
	private void showRequiredFieldsDialog() {
		JOptionPane.showMessageDialog(null,"All the fields are required.",
				"Warning", JOptionPane.INFORMATION_MESSAGE);
	}
	
	private void showDatabasesTablesSchemasDiffers() {
		JOptionPane.showMessageDialog(null, "A database exists on the DBMS whose schema differs\n"
				+ "from the schema of the specified database.",
				"Error", JOptionPane.INFORMATION_MESSAGE);
	}

	private void showFileTooLongDialog() {
		JOptionPane.showMessageDialog(null, "The specified file exceeds the size limit",
				"File too long", JOptionPane.INFORMATION_MESSAGE);
	}
	
	private int showOverwritingQuestionDialog() {
		int choice = 0;
		
		choice = JOptionPane.showConfirmDialog(null, 
				"Do you want to overwrite the database which exists on the DBMS? "
				+ "\n\nNOTE: If you don't, JITRAX will compare the databases' schemas\n"
				+ "and if they coincide, the contents (rows) will be "
				+ "synchronized for \neach table. Otherwise, you won't be able to re-use this database.",
				"Database Overwriting", JOptionPane.YES_NO_OPTION);
		
		return choice;
	}
	
	private void showDatabaseAlreadyExistsDialog() {
		JOptionPane.showMessageDialog(null, "A database with the same name you have "
				+ "specified already exists in the environment.",
				"Database already exists", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public MainWindow getMainWindow() {
		return mainWindow;
	}

	public void setMainWindow(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
	}

	public String getLastSavingLocation() {
		return lastSavingLocation;
	}

	public void setLastSavingLocation(String lastSavingLocation) {
		this.lastSavingLocation = lastSavingLocation;
	}
}
