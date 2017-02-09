package es.ull.etsii.jitrax.gui;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import es.ull.etsii.jitrax.database.Database;

public class DatabaseViewerPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private static final String PANEL_TITLE = "DB Viewer";
	private static final Color PANEL_BORDER_COLOR = Color.BLACK;
	
	private ArrayList<Database> databases;
	
	public DatabaseViewerPanel() {
		databases = new ArrayList<Database>();
		
		
		/**
		 * 
		 * PROVISIONAL
		 * 
		 */
		JPanel selectedDatabasePanel = new JPanel();
		JComboBox selectedDB = new JComboBox();
		selectedDB.addItem((String) "MyDB");
		JPanel buttonsPanel = new JPanel();
		JButton addButton = new JButton("ADD");
		JButton eraseButton = new JButton("ERASE");
	
		buttonsPanel.add(addButton);
		buttonsPanel.add(eraseButton);
		add(selectedDB);
		add(buttonsPanel);
		
		LineBorder lineBorderPanel = (LineBorder) BorderFactory.createLineBorder(PANEL_BORDER_COLOR);
		setBorder(BorderFactory.createTitledBorder(lineBorderPanel, PANEL_TITLE));
		
	}

	public ArrayList<Database> getDatabases() {
		return databases;
	}

	public void setDatabases(ArrayList<Database> databases) {
		this.databases = databases;
	}
}
