package es.ull.etsii.jitrax.gui.dialogs;

import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

import es.ull.etsii.jitrax.adt.Database;
import es.ull.etsii.jitrax.database.DatabaseFileLoader;
import es.ull.etsii.jitrax.gui.Console;

public class FileDialog {

	private JFrame parentFrame;
	
	public FileDialog(JFrame aParentFrame) {
		parentFrame = aParentFrame;
	}
	
	/**
	 * Asks for a file which contains a database specification using the
	 * created DSL. Returns a new database created from it.
	 * @return
	 */
	public Database importDatabaseDialog() {
		JFileChooser fileChooser = new JFileChooser();
	    int option = fileChooser.showOpenDialog(parentFrame);
	    String fileDir;
	    String fileName;
	    
	    // If the user presses OK
        if (option == JFileChooser.APPROVE_OPTION) {
        	// Take the file's path
        	fileDir = fileChooser.getCurrentDirectory().toString() + "/";
        	fileName = fileChooser.getSelectedFile().getName();
        	
        	// Open the file and create a database from it
        	DatabaseFileLoader databaseFileLoader = new DatabaseFileLoader(fileDir + fileName);
        	boolean success = databaseFileLoader.readDatabaseFromFile();
        	
        	// return the created DB if success
        	if (success) {
        		return databaseFileLoader.getDatabase();
        	} else {
        		return null;
        	}
        	
        } else {
        	return null;
        }
	}
	
	/**
	 * Asks for a file which will be used for saving the specified database.
	 * @param database
	 */
	public void exportDatabaseDialog(Database database) {
		
	}
	
	public String importRAQuery() {
		String raQuery = null;
		
		return raQuery;
	}
	
	public void exportRAQuery() {
		
	} 
	
	public String importSQLQueryDialog() {
		String sqlQuery = null;
		
		return sqlQuery;
	}
	
	public void exportSQLQueryDialog(Console console) {
		
	}
	
	public void exportConsoleDialog() {
		
	}
}
