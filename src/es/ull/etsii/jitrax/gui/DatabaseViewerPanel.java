package es.ull.etsii.jitrax.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import es.ull.etsii.jitrax.adt.Attribute;
import es.ull.etsii.jitrax.adt.DataType;
import es.ull.etsii.jitrax.adt.Database;
import es.ull.etsii.jitrax.adt.Datum;
import es.ull.etsii.jitrax.adt.Row;
import es.ull.etsii.jitrax.adt.Table;
import es.ull.etsii.jitrax.exceptions.DuplicatePrimaryKeyException;

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
		
		ArrayList<Attribute> attrList = new ArrayList<Attribute>();
		Attribute dniAttr = new Attribute("DNI", true, DataType.STRING);
		attrList.add(dniAttr);
		Table table1 = new Table("Students", attrList);
		Table table2 = new Table("Teachers", attrList);
		Table table3 = new Table("Others", attrList);
		tables.add(table1);
		tables.add(table2);
		tables.add(table3);
		
		Database myDB = new Database("MyDB");
		databases.add(myDB);
		
		selectedDatabasePanel = new SelectedDatabasePanel(databases);
		tablesPanel = new TablesPanel(tables);
		selectedTablePanel = new SelectedTablePanel(table1);
		
		JScrollPane tablesSP = new JScrollPane(tablesPanel);
		tablesSP.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		tablesSP.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		add(selectedDatabasePanel);
		add(tablesSP);
		
		//add(selectedTablePanel);
		
		LineBorder lineBorderPanel = (LineBorder) BorderFactory.createLineBorder(PANEL_BORDER_COLOR);
		setBorder(BorderFactory.createTitledBorder(lineBorderPanel, PANEL_TITLE));
		
		
		
		
		
		
		ArrayList<Datum> firstRowData = new ArrayList<Datum>();
		ArrayList<Datum> firstRowData1 = new ArrayList<Datum>();
		ArrayList<Datum> firstRowData2 = new ArrayList<Datum>();
		ArrayList<Datum> firstRowData3 = new ArrayList<Datum>();
		ArrayList<Datum> firstRowData4 = new ArrayList<Datum>();
		ArrayList<Datum> firstRowData5 = new ArrayList<Datum>();
		ArrayList<Datum> firstRowData6 = new ArrayList<Datum>();
		ArrayList<Datum> firstRowData7 = new ArrayList<Datum>();
		
		Datum dniDatum = new Datum(dniAttr, "12345678R");
	
		//attrList.add(dniAttr);
		firstRowData.add(dniDatum);
		firstRowData1.add(dniDatum);
		firstRowData2.add(dniDatum);
		firstRowData3.add(dniDatum);
		firstRowData4.add(dniDatum);
		firstRowData5.add(dniDatum);
		firstRowData6.add(dniDatum);
		firstRowData7.add(dniDatum);
		
		
		
		Table table = new Table("Students", attrList);
		try {
			table.addRow(firstRowData);
			table.addRow(firstRowData1);
			table.addRow(firstRowData2);
			table.addRow(firstRowData3);
			table.addRow(firstRowData4);
			table.addRow(firstRowData5);
			table.addRow(firstRowData6);
			table.addRow(firstRowData7);
		} catch (DuplicatePrimaryKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		selectedTablePanel = new SelectedTablePanel(table); 
		add(selectedTablePanel);
		
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
		add(tablePanel);
		scrollPane.setPreferredSize(new Dimension(100, 100));
		scrollPane.setBorder (BorderFactory.createTitledBorder (BorderFactory.createEtchedBorder (),
                "Students Content",
                TitledBorder.CENTER,
                TitledBorder.TOP));*/
		
		/*UIDefaults defaults = UIManager.getLookAndFeelDefaults();
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
