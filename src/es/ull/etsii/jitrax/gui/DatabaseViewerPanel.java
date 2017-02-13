package es.ull.etsii.jitrax.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
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
	private static final int EXTRA_GAP_SIZE = 10;
	
	private static final String PANEL_TITLE = "DB Viewer";
	private static final Color PANEL_BORDER_COLOR = Color.GRAY;
	
	private ArrayList<Database> databases;
	private SelectedDatabasePanel selectedDatabasePanel;
	private TablesPanel tablesPanel;
	private SelectedTablePanelViewer selectedTablePanel;
	
	public DatabaseViewerPanel() {
		databases = new ArrayList<Database>();
		ArrayList<Table> tables = new ArrayList<Table>();
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		ArrayList<Attribute> attrList = new ArrayList<Attribute>();
		Attribute dniAttr = new Attribute("DNI", true, DataType.STRING);
		Attribute nameAttr = new Attribute("Name", true, DataType.STRING);
		
		attrList.add(dniAttr);
		attrList.add(nameAttr);
		Table table1 = new Table("Students", attrList);
		Table table2 = new Table("Teachers", attrList);
		Table table3 = new Table("Others", attrList);
		tables.add(table1);
		tables.add(table2);
		tables.add(table3);
		
		ArrayList<Datum> table1Data = new ArrayList<Datum>();
		table1Data.add(new Datum(dniAttr, "21323L"));
		table1Data.add(new Datum(nameAttr, "sad"));
		
		try {
			table1.addRow(table1Data);
		} catch (DuplicatePrimaryKeyException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Database myDB = new Database("MyDB");
		databases.add(myDB);
		
		selectedDatabasePanel = new SelectedDatabasePanel(databases);
		tablesPanel = new TablesPanel(tables);
		selectedTablePanel = new SelectedTablePanelViewer(table1);
		
		JScrollPane tablesSP = new JScrollPane(tablesPanel);
		tablesSP.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		tablesSP.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		add(selectedDatabasePanel);
		add(tablesSP);
		
		add(Box.createVerticalStrut(EXTRA_GAP_SIZE));
		
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
		firstRowData.add(new Datum(nameAttr, "Juan"));
		
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
			e.printStackTrace();
		}
		
		selectedTablePanel = new SelectedTablePanelViewer(table); 
		add(selectedTablePanel);
	}

	public ArrayList<Database> getDatabases() {
		return databases;
	}

	public void setDatabases(ArrayList<Database> databases) {
		this.databases = databases;
	}

	public SelectedDatabasePanel getSelectedDatabasePanel() {
		return selectedDatabasePanel;
	}

	public void setSelectedDatabasePanel(SelectedDatabasePanel selectedDatabasePanel) {
		this.selectedDatabasePanel = selectedDatabasePanel;
	}

	public TablesPanel getTablesPanel() {
		return tablesPanel;
	}

	public void setTablesPanel(TablesPanel tablesPanel) {
		this.tablesPanel = tablesPanel;
	}

	public SelectedTablePanelViewer getSelectedTablePanel() {
		return selectedTablePanel;
	}

	public void setSelectedTablePanel(SelectedTablePanelViewer selectedTablePanel) {
		this.selectedTablePanel = selectedTablePanel;
	}
}
