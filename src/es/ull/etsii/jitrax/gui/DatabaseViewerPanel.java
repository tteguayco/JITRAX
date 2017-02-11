package es.ull.etsii.jitrax.gui;

import java.awt.Color;

import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import es.ull.etsii.jitrax.database.DataType;
import es.ull.etsii.jitrax.database.Database;
import es.ull.etsii.jitrax.database.Table;

public class DatabaseViewerPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private static final String PANEL_TITLE = "DB Viewer";
	private static final Color PANEL_BORDER_COLOR = Color.GRAY;
	
	private ArrayList<Database> databases;
	private SelectedDatabasePanel selectedDatabasePanel;
	private TablesPanel tablesPanel;
	private SelectedTablePanel selectedTablePanel;
	
	public DatabaseViewerPanel() {
		databases = new ArrayList<Database>();
		ArrayList<Table> tables = new ArrayList<Table>();
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		Table table1 = new Table("Students");
		Table table2 = new Table("Teachers");
		Table table3 = new Table("Others");
		table1.addAttribute("DNI", true, DataType.STRING);
		table2.addAttribute("DNI", true, DataType.STRING);
		table3.addAttribute("DNI", true, DataType.STRING);
		tables.add(table1);
		tables.add(table2);
		tables.add(table3);
		
		Database myDB = new Database("MyDB");
		databases.add(myDB);
		
		selectedDatabasePanel = new SelectedDatabasePanel(databases);
		tablesPanel = new TablesPanel(tables);
		selectedTablePanel = new SelectedTablePanel();
		
		JScrollPane tablesSP = new JScrollPane(tablesPanel);
		tablesSP.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		add(selectedDatabasePanel);
		add(tablesSP);
		//add(selectedTablePanel);
		
		LineBorder lineBorderPanel = (LineBorder) BorderFactory.createLineBorder(PANEL_BORDER_COLOR);
		setBorder(BorderFactory.createTitledBorder(lineBorderPanel, PANEL_TITLE));
		
		/*
		Object rowData[][] = { { "12345678R", "Antonio"},
		        { "87654321L", "Juan" } };
		Object columnNames[] = { "DNI", "Name" };
		JTable table = new JTable(rowData, columnNames);
		table.setEnabled(false);
		JPanel tablePanel = new JPanel();
		tablePanel.setLayout(new BoxLayout(tablePanel, BoxLayout.Y_AXIS));
		JPanel buttonPanel = new JPanel();
	    buttonPanel.add(new JButton("DETAILS"));
		JScrollPane scrollPane = new JScrollPane(table);
	    tablePanel.add(scrollPane);
		tablePanel.add(buttonPanel);
		add(tablePanel/*, BorderLayout.SOUTH);
		scrollPane.setPreferredSize(new Dimension(100, 100));
		scrollPane.setBorder (BorderFactory.createTitledBorder (BorderFactory.createEtchedBorder (),
                "Students Content",
                TitledBorder.CENTER,
                TitledBorder.TOP));
		UIDefaults defaults = UIManager.getLookAndFeelDefaults();
		if (defaults.get("Table.alternateRowColor") == null)
		    defaults.put("Table.alternateRowColor", new Color(240, 240, 240));*/
	}

	public ArrayList<Database> getDatabases() {
		return databases;
	}

	public void setDatabases(ArrayList<Database> databases) {
		this.databases = databases;
	}
}
