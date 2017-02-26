package es.ull.etsii.jitrax.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.postgresql.util.PSQLException;

import es.ull.etsii.jitrax.adt.Database;
import es.ull.etsii.jitrax.database.PostgreDriver;
import es.ull.etsii.jitrax.gui.MainWindow;
import es.ull.etsii.jitrax.gui.dialogs.DBMSConnectionWindow;
import es.ull.etsii.jitrax.gui.dialogs.FileDialog;

public class MenuBarController {

	private MainWindow mainWindow;
	
	public MenuBarController(MainWindow aMainWindow) {
		mainWindow = aMainWindow;
		
		setFileMenuListeners();
	}
	
	private void setFileMenuListeners() {
		
		mainWindow.getBarMenu().getOpenDatabase().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				openDatabase();
			}
		});
	
		mainWindow.getBarMenu().getNewDatabase().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
	}
	
	/**
	 * Creates a DB in the DBMS from a file, and loads it in the MainWindow.
	 */
	private void openDatabase() {
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
					//showRequiredFieldsWarning(dbmsConnectionWindow);
				}
				
				else {
					FileDialog fileDialog = new FileDialog(mainWindow);
					Database importedDatabase = fileDialog.importDatabaseDialog();
					
					if (importedDatabase != null) {
						try {
							// Establish a connection and create the database
							PostgreDriver postgreDriver = new PostgreDriver(hostname, 
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
							}
							
							else {
								System.out.println("NOT IMPLEMENTED YET: DB ALREADY IN DBMS");
								
								// Habría que comprobar que la existente es igual a la especificada
								// en fichero?
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
	
	private void showRequiredFieldsWarning(JFrame parentFrame) {
		JOptionPane.showMessageDialog(parentFrame,"All the fields are required.",
				"Warning", JOptionPane.INFORMATION_MESSAGE);
	}
}
