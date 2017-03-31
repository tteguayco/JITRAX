package es.ull.etsii.jitrax.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import es.ull.etsii.jitrax.adt.Query;

public class QueryList extends JPanel {
	private static final String PANEL_TITLE = "Queries";
	private static final Color PANEL_BORDER_COLOR = Color.GRAY;
	private static final String DEFAULT_QUERY_PREFIX = "query";
	
	private static final int CELL_WIDTH = 150;
	private static final int CELL_HEIGHT = 30;
	
	private static final int BUTTON_BORDER_INSET = 10;
	
	private JTable queryList;
	private DefaultTableModel listModel;
	private int queryCounter;
	private ArrayList<Query> queries;
	private JButton addButton;
	private JButton removeButton;
	private JButton saveButton;
	
	public QueryList() {
		queryList = new JTable(1, 1);
		listModel = new DefaultTableModel(); 
		queryCounter = 1;
		queries = new ArrayList<Query>();
		addButton = new JButton("➕");
		removeButton = new JButton("➖");
		saveButton = new JButton("💾");
		
		addButton.setToolTipText("Add new query");
		removeButton.setToolTipText("Remove selected query");
		saveButton.setToolTipText("Save selected query");
	    
		//queryList.setTableHeader(null);
		queryList.setFillsViewportHeight(true);
		
		//queryList.setFixedCellWidth(CELL_WIDTH);
		//queryList.setFixedCellHeight(CELL_HEIGHT);
		
		queryList.setModel(listModel);
		listModel.addRow(new Object[] {new Query("query1")});
		listModel.addRow(new Object[] {new Query("query2")});
		listModel.addRow(new Object[] {new Query("query3")});
		
		listModel.fireTableDataChanged();
		
		setLayout(new BorderLayout());
		JScrollPane sp = new JScrollPane(queryList);
		JPanel buttonsPanel = new JPanel();
		
		sp.setPreferredSize(
	    	    new Dimension(CELL_WIDTH,
	    	    		queryList.getRowHeight()));
		
		buttonsPanel.add(addButton);
		buttonsPanel.add(removeButton);
		buttonsPanel.add(saveButton);
		add(sp, BorderLayout.CENTER);
		add(buttonsPanel, BorderLayout.NORTH);
		
		LineBorder lineBorderPanel = (LineBorder) BorderFactory.createLineBorder(PANEL_BORDER_COLOR);
		setBorder(BorderFactory.createTitledBorder(lineBorderPanel, PANEL_TITLE));
	}
	
	public void addQuery(String queryName) {
		
	}
	
	public Query getSelectedQuery() {
		return null;
		//return (Query) getQueryList().getSelectedValue();
	}

	public int getQueryCounter() {
		return queryCounter;
	}

	public void setQueryCounter(int queryCounter) {
		this.queryCounter = queryCounter;
	}

	public JTable getQueryList() {
		return queryList;
	}

	public void setQueryList(JTable queryList) {
		this.queryList = queryList;
	}

	public DefaultTableModel getListModel() {
		return listModel;
	}

	public void setListModel(DefaultTableModel listModel) {
		this.listModel = listModel;
	}

	public ArrayList<Query> getQueries() {
		return queries;
	}

	public void setQueries(ArrayList<Query> queries) {
		this.queries = queries;
	}

	public JButton getAddButton() {
		return addButton;
	}

	public void setAddButton(JButton addButton) {
		this.addButton = addButton;
	}

	public JButton getRemoveButton() {
		return removeButton;
	}

	public void setRemoveButton(JButton removeButton) {
		this.removeButton = removeButton;
	}

	public JButton getSaveButton() {
		return saveButton;
	}

	public void setSaveButton(JButton saveButton) {
		this.saveButton = saveButton;
	}
}
