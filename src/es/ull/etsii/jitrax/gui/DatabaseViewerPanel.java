package es.ull.etsii.jitrax.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import es.ull.etsii.jitrax.database.Database;

public class DatabaseViewerPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private static final String PANEL_TITLE = "DB Viewer";
	private static final Color PANEL_BORDER_COLOR = Color.GRAY;
	
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
	
		selectedDB.setPreferredSize(new Dimension(200, 40));
		
		((JLabel)selectedDB.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		selectedDB.setFocusable(false);
		
		setLayout(new BorderLayout());
		buttonsPanel.add(addButton);
		buttonsPanel.add(eraseButton);
		add(selectedDB, BorderLayout.CENTER);
		add(buttonsPanel, BorderLayout.SOUTH);
		
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
