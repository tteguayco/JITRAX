package es.ull.etsii.jitrax.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import es.ull.etsii.jitrax.adt.Query;

public class QueryList extends JPanel {
	private static final String PANEL_TITLE = "Queries";
	private static final Color PANEL_BORDER_COLOR = Color.GRAY;
	private static final String DEFAULT_QUERY_PREFIX = "query";
	
	private static final int CELL_WIDTH = 170;
	private static final int CELL_HEIGHT = 30;
	
	private JTable queryList;
	private DefaultTableModel listModel;
	private int queryCounter;
	private ArrayList<Query> queries;
	private JButton addButton;
	private JButton removeButton;
	private JButton saveButton;
	
	public QueryList() {
		Object rowData[][] = { { new Query("query1")} };
		Object columnNames[] = { "Query" };
		
		queryList = new JTable();
		listModel = new CustomListModel(rowData, columnNames); 
		queryCounter = 2;
		queries = new ArrayList<Query>();
		addButton = new JButton("➕");
		removeButton = new JButton("➖");
		saveButton = new JButton("💾");
		
		addButton.addActionListener(new QueryAdder());
		removeButton.addActionListener(new QueryRemover());
		
		addButton.setToolTipText("Add new query");
		removeButton.setToolTipText("Remove selected query");
		saveButton.setToolTipText("Save selected query");
		
		queryList.setModel(listModel);
		queryList.setTableHeader(null);
		queryList.setFillsViewportHeight(true);
		queryList.setRowHeight(CELL_HEIGHT);
		queryList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		queryList.setRowSelectionInterval(0, 0);
		
		//listModel.addRow(new Object[] { new Query("query1")});
		//listModel.fireTableDataChanged();
		
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
	
	private void addQuery(String queryName) {
		Query newQuery = new Query(queryName);
		listModel.addRow(new Object[] { newQuery });
		listModel.fireTableDataChanged();
		queryCounter++;
	}
	
	public Query getSelectedQuery() {
		int selectedRowIndex = getQueryList().getSelectedRow();
		if (selectedRowIndex < 0) {
			selectedRowIndex = queryList.getRowCount() - 1;
		}
		
		return (Query) listModel.getValueAt(selectedRowIndex, 0);
	}

	private class QueryAdder implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			addQuery(DEFAULT_QUERY_PREFIX + getQueryCounter());
			int lastRowIndex = queryList.getRowCount() - 1;
			queryList.changeSelection(lastRowIndex, 0, false, false);
		}
	}
	
	private class QueryRemover implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			int selectedRowIndex = getQueryList().getSelectedRow();
			// We force to be at least one query
			if (selectedRowIndex > 0) {
				listModel.removeRow(selectedRowIndex);
				// Select the former
				queryList.changeSelection(selectedRowIndex - 1, 0, false, false);
			}
		}
	}
	
	private class CustomListModel extends DefaultTableModel {
		public CustomListModel(Object[][] rowData, Object[] columnNames) {
			super(rowData, columnNames);
		}

		/**
		 * Cada vez que el usuario cambie el nombre de una consulta,
		 * lo que se debe modificar el atributo nombre de ESA consulta 
		 * (no lo que se hace por defecto: sustituir un objeto de tipo
		 * 'Query' por una String en la queryList)
		 */
		@Override
		public void setValueAt(Object s, int row, int col) {
			Query targetQuery = (Query) queryList.getModel().getValueAt(row, col);
			String newQueryName = (String) s;
			targetQuery.setName(newQueryName);
		}
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
