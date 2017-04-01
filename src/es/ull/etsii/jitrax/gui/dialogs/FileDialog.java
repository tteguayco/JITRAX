package es.ull.etsii.jitrax.gui.dialogs;

import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import es.ull.etsii.jitrax.adt.Database;
import es.ull.etsii.jitrax.database.DatabaseFileLoader;
import es.ull.etsii.jitrax.gui.Console;

public class FileDialog {
	
	private String lastSavingLocation;
	
	public FileDialog() {
		lastSavingLocation = "";
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
	 * Returns as a string the content of a chosen file.
	 * @param dialogTitle
	 * @return
	 */
	public String importFileContent(String dialogTitle) {
		JFileChooser fileChooser = new JFileChooser();
		String filePath;
		int userSelection;
		
		fileChooser.setDialogTitle(dialogTitle);
		userSelection = fileChooser.showSaveDialog(null);
		
		if (userSelection == JFileChooser.APPROVE_OPTION) {
			filePath = fileChooser.getSelectedFile().getAbsolutePath();
			
			// Read file
			byte[] encoded;
			
			try {
				encoded = Files.readAllBytes(Paths.get(filePath));
				return new String(encoded, StandardCharsets.UTF_8);
			}
			
			catch (IOException e) {
				e.printStackTrace();
			} 
		}
		
		return "";
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
		
		if (userSelection == JFileChooser.APPROVE_OPTION) {
			filePath = fileChooser.getSelectedFile().getAbsolutePath();
			
			int response;
			BufferedReader br;
			
			try {
				br = new BufferedReader(new FileReader(filePath));
				setLastSavingLocation(filePath);
				
				// If file is not empty
				try {
					if (br.readLine() != null) {
						response = JOptionPane.showConfirmDialog(fileChooser, 
					            "Do you want to replace the existing file?",
					            "Confirm", JOptionPane.YES_NO_OPTION, 
					            JOptionPane.QUESTION_MESSAGE);
						br.close();
						
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
				String newFilePath = filePath + extension;
				new File(newFilePath);
				setLastSavingLocation(newFilePath);
			}
			
			try {
				printWriter = new PrintWriter(filePath);
				printWriter.print(content);
				printWriter.close();
				showSuccessfulExportationWarning();
			} 
			
			catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} 
		}
	}
	
	private void showSuccessfulExportationWarning() {
		JOptionPane.showMessageDialog(null, "Content successfully exported.",
				"Warning", JOptionPane.INFORMATION_MESSAGE);
	}

	public String getLastSavingLocation() {
		return lastSavingLocation;
	}

	public void setLastSavingLocation(String lastSavingLocation) {
		this.lastSavingLocation = lastSavingLocation;
	}
}
