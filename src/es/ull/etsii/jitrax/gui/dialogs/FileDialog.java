package es.ull.etsii.jitrax.gui.dialogs;

import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import es.ull.etsii.jitrax.adt.Database;
import es.ull.etsii.jitrax.database.DatabaseFileLoader;
import es.ull.etsii.jitrax.gui.Console;

public class FileDialog {
	
	public FileDialog() {
	}
	
	/**
	 * Asks for a file which contains a database specification using the
	 * created DSL. Returns a new database created from it.
	 * @return
	 */
	public Database importDatabaseDialog() {
		JFileChooser fileChooser = new JFileChooser();
	    int option = fileChooser.showOpenDialog(null);
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
	
	/**
	 * Exports the specified content to the specified file.
	 * 
	 * If the file already exists, the user has to confirm whether he wants
	 * override its content or not.
	 * 
	 * Furthermore, an extension is added if the file had to be created.
	 * 
	 * @param dialogTitle
	 * @param content
	 * @param extension
	 */
	public void exportFile(String dialogTitle, String content, String extension) {
		JFileChooser fileChooser = new JFileChooser();
		PrintWriter printWriter;
		String filePath;
		int userSelection;
		
		fileChooser.setDialogTitle(dialogTitle);
		userSelection = fileChooser.showSaveDialog(null);
		
		// Export console content to file
		if (userSelection == JFileChooser.APPROVE_OPTION) {
			filePath = fileChooser.getSelectedFile().getAbsolutePath();
			
			int response;
			BufferedReader br;
			
			try {
				br = new BufferedReader(new FileReader(filePath));
				
				// If file is not empty
				try {
					if (br.readLine() != null) {
						response = JOptionPane.showConfirmDialog(fileChooser, 
					            "Do you want to replace the existing file?",
					            "Confirm", JOptionPane.YES_NO_OPTION, 
					            JOptionPane.QUESTION_MESSAGE);
						br.close();
						
						// Confirm saving
						if (response != JOptionPane.YES_OPTION) {
							return;
						}
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			} 
			
			catch (FileNotFoundException e1) {
				new File(filePath + extension);
			}
			
			try {
				printWriter = new PrintWriter(filePath);
				printWriter.print(content);
				printWriter.close();
			} 
			
			catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} 
		}
	}
	
	public String importRAQuery() {
		String raQuery = null;
		
		return raQuery;
	}

	public String importSQLQueryDialog() {
		String sqlQuery = null;
		
		return sqlQuery;
	}
}
