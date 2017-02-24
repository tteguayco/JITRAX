package es.ull.etsii.jitrax.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import org.postgresql.util.PSQLException;

import es.ull.etsii.jitrax.adt.Database;
import es.ull.etsii.jitrax.gui.FileDialog;
import es.ull.etsii.jitrax.gui.main.MainWindow;
import es.ull.etsii.jitrax.jdbc.PostgreDriver;

public class MenuBarController {

	private MainWindow mainWindow;
	
	public MenuBarController(MainWindow aMainWindow) {
		mainWindow = aMainWindow;
		
		setFileMenuListeners();
	}
	
	private void setFileMenuListeners() {
		// OPEN EXISTING DATABASE
		mainWindow.getBarMenu().getOpenDatabase().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// Select the file .db
				FileDialog fileDialog = new FileDialog(mainWindow);
				Database databaseFromFile = fileDialog.importDatabaseDialog();
				
				try {
					// Establish a connection and create the database
					PostgreDriver postgreDriver = new PostgreDriver();
					String databaseName = databaseFromFile.getName();
					
					// If it does not exist, create it
					if (!postgreDriver.databaseAlreadyExists(databaseName)) {
						postgreDriver.createDatabase(databaseFromFile);
					} 
					
					// If it already exists, drop it and create a new one
					else {
						postgreDriver.dropDatabase(databaseName);
						postgreDriver.createDatabase(databaseFromFile);
					}
					
					mainWindow.addDatabase(databaseFromFile);
	
				} catch (PSQLException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		
		
	}
}
