package es.ull.etsii.jitrax.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.postgresql.util.PSQLException;

import es.ull.etsii.jitrax.adt.Database;
import es.ull.etsii.jitrax.database.DatabaseComparator;
import es.ull.etsii.jitrax.database.PostgreDriver;
import es.ull.etsii.jitrax.gui.dialogs.DBMSConnectionWindow;
import es.ull.etsii.jitrax.gui.dialogs.FileDialog;

public class MenuBarListenersSetter {

	private MainWindow mainWindow;
	private String lastSavingLocation;
	
	public MenuBarListenersSetter(MainWindow aMainWindow) {
		mainWindow = aMainWindow;
		lastSavingLocation = "";
		setFileMenuListeners();
	}
	
	private void setFileMenuListeners() {
		getMainWindow().getBarMenu().getOpenDatabase().addActionListener(new OpenListener());
		getMainWindow().getBarMenu().getNewDatabase().addActionListener(new NewListener());
		getMainWindow().getBarMenu().getSaveDatabase().addActionListener(new SaveListener());
		getMainWindow().getBarMenu().getSaveDatabaseAs().addActionListener(new SaveAsListener());
	}
	
	private class NewListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			
		}
	}
	
	private class OpenListener implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
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
					if (hostname.equals("") || port.equals("") || username.equals("") || password.equals("")) {
						showRequiredFieldsDialog();
					}
					
					else {
						FileDialog fileDialog = new FileDialog();
						Database importedDatabase = fileDialog.importDatabaseDialog();
						PostgreDriver postgreDriver;
						
						if (importedDatabase != null) {
							try {
								// Establish a connection and create the database
								postgreDriver = new PostgreDriver(hostname, 
																	port, 
																	username, 
																	password);
								
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
								
							} catch (PSQLException e) {
								e.printStackTrace();
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}
					}
				}
			});
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
	
	private void showRequiredFieldsDialog() {
		JOptionPane.showMessageDialog(null,"All the fields are required.",
				"Warning", JOptionPane.INFORMATION_MESSAGE);
	}
	
	private void showDatabasesContentsDifferDialog() {
		JOptionPane.showMessageDialog(null,"A database exists on the DBMS whose content differs "
				+ "from the content of the specified database.",
				"Error", JOptionPane.INFORMATION_MESSAGE);
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
