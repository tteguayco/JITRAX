package es.ull.etsii.jitrax.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import es.ull.etsii.jitrax.adt.Database;
import es.ull.etsii.jitrax.gui.FileDialog;
import es.ull.etsii.jitrax.gui.main.MainWindow;

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
				FileDialog fileDialog = new FileDialog(mainWindow);
				Database existingDatabase = fileDialog.importDatabaseDialog();
				mainWindow.addDatabase(existingDatabase);
			}
		});
	}
}
