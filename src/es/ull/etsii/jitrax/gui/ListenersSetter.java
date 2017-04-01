package es.ull.etsii.jitrax.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.postgresql.util.PSQLException;

import es.ull.etsii.jitrax.adt.Database;
import es.ull.etsii.jitrax.database.DatabaseComparator;
import es.ull.etsii.jitrax.database.PostgreDriver;
import es.ull.etsii.jitrax.gui.dialogs.DBMSConnectionWindow;
import es.ull.etsii.jitrax.gui.dialogs.ErrorsDialog;
import es.ull.etsii.jitrax.gui.dialogs.FileDialog;

public class ListenersSetter {
	private static final int RA_QUERY_MAX_CHAR = 1000;
	
	private MainWindow mainWindow;
	private String lastSavingLocation;
	private FileDialog fileDialog;
	private PostgreDriver postgreDriver;
	
	public ListenersSetter(MainWindow aMainWindow) {
		mainWindow = aMainWindow;
		lastSavingLocation = "";
		fileDialog = new FileDialog();
		setFileMenuListeners();
	}
	
	private void setFileMenuListeners() {
		getMainWindow().getBarMenu().getOpenDatabase().addActionListener(new OpenListener());
		getMainWindow().getBarMenu().getNewDatabase().addActionListener(new NewListener());
		getMainWindow().getBarMenu().getSaveDatabase().addActionListener(new SaveListener());
		getMainWindow().getBarMenu().getSaveDatabaseAs().addActionListener(new SaveAsListener());
		getMainWindow().getBarMenu().getExitOption().addActionListener(new ExitListener());
		getMainWindow().getBarMenu().getImportRelAlgQuery().addActionListener(new ImportationOptionListener());
		getMainWindow().getBarMenu().getExportRelAlgQuery().addActionListener(new ExportationOptionListener());
		getMainWindow().getBarMenu().getExportSqlQuery().addActionListener(new ExportationOptionListener());
		getMainWindow().getQueryList().getSaveButton().addActionListener(new ExportationOptionListener());
	}
	
	private class NewListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			
		}
	}
	
	private class OpenListener implements ActionListener {

		private void readDatabase(PostgreDriver postgreDriver) throws SQLException {
			FileDialog fileDialog = new FileDialog();
			Database importedDatabase = fileDialog.importDatabaseDialog();
			
			if (importedDatabase != null) {
			
				// Assign a PostgreDriver to the new database
				importedDatabase.setPostgreDriver(postgreDriver);
				
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
					
					// Compare them
					DatabaseComparator dbComparator = new DatabaseComparator(
							importedDatabase, postgreDriver.getConnection());
					
					if (dbComparator.databasesAreCompatible()) {
						mainWindow.addDatabase(importedDatabase);
						System.out.println("> Database '" + importedDatabase.getName() +
								"' was retrieved from DBMS.");
					}
					
					else {
						showDatabasesContentsDifferDialog();
						// TODO ask for updating the database in the dbms
						postgreDriver.closeConnection();
					}
				}
					
			}
		}
		
		public void actionPerformed(ActionEvent arg0) {
			if (getMainWindow().getPostgreDriver() == null) {
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
						
						// Empty fields are not allowed
						if (hostname.equals("") || port.equals("") 
								|| username.equals("") || password.equals("")) {
							showRequiredFieldsDialog();
						}
						
						try {
							postgreDriver = new PostgreDriver(hostname, 
									port, 
									username, 
									password);
							
							getMainWindow().setPostgreDriver(postgreDriver);
							readDatabase(postgreDriver);
						} 

						// Errors? Show them
						catch (SQLException e) {
							ArrayList<String> errors = new ArrayList<String>();
							errors.add(e.getMessage());
							ErrorsDialog errorsDialog = new ErrorsDialog(errors);
						}
					}
				});
			}
			
			else {
				postgreDriver = getMainWindow().getPostgreDriver();
				try {
					readDatabase(postgreDriver);
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
			String currentDatabaseString = currentDatabase.toString();
			
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
			String currentDatabaseString = currentDatabase.toString();
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
			// Export RA query?
			if (e.getSource() == getMainWindow().getBarMenu().getExportRelAlgQuery()
					|| e.getSource() == getMainWindow().getQueryList().getSaveButton()) {
				String raQuery = getMainWindow().getWorkspace().getRelationalAlgebraCodeEditor().getText();
				
				if (raQuery.length() > 0) {
					fileDialog.exportFile("Export Relational Algebra Query", raQuery, ".ra");
				}	
			}
			
			// Export SQL query
			else if (e.getSource() == getMainWindow().getBarMenu().getExportSqlQuery()) {
				String sqlQuery = getMainWindow().getWorkspace().getSQLCodeEditor().getText();
				
				if (sqlQuery.length() > 0) {
					fileDialog.exportFile("Export SQL Query", sqlQuery, ".sql");
				}
			}
		}
	}
	
	private void showRequiredFieldsDialog() {
		JOptionPane.showMessageDialog(null,"All the fields are required.",
				"Warning", JOptionPane.INFORMATION_MESSAGE);
	}
	
	private void showDatabasesContentsDifferDialog() {
		JOptionPane.showMessageDialog(null, "A database exists on the DBMS whose content differs "
				+ "from the content of the specified database.",
				"Error", JOptionPane.INFORMATION_MESSAGE);
	}

	private void showFileTooLongDialog() {
		JOptionPane.showMessageDialog(null, "The specified file exceeds the size limit",
				"File too long", JOptionPane.INFORMATION_MESSAGE);
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
