package es.ull.etsii.jitrax.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import es.ull.etsii.jitrax.adt.Query;

public class QueryList extends JPanel {
	private static final String PANEL_TITLE = "Queries";
	private static final Color PANEL_BORDER_COLOR = Color.GRAY;
	private static final String DEFAULT_QUERY_PREFIX = "query";
	
	private static final int CELL_WIDTH = 150;
	private static final int CELL_HEIGHT = 30;
	
	private JList<Query> queryList;
	private DefaultListModel listModel;
	private int queryCounter;
	private ArrayList<Query> queries;
	private JButton addButton;
	private JButton removeButton;
	
	public QueryList() {
		queryList = new JList<Query>();
		listModel = new DefaultListModel<Query>(); 
		queryCounter = 1;
		queries = new ArrayList<Query>();
		addButton = new JButton("+");
		removeButton = new JButton("−");
		addButton.setToolTipText("Add new query");
		removeButton.setToolTipText("Remove selected query");
		
		queryList.setFixedCellWidth(CELL_WIDTH);
		queryList.setFixedCellHeight(CELL_HEIGHT);
		
		queryList.setModel(listModel);
		listModel.addElement(new Query("query1"));
		listModel.addElement(new Query("my query 2"));
		queryList.setSelectedIndex(0);
		
		setLayout(new BorderLayout());
		JScrollPane sp = new JScrollPane(queryList);
		JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		buttonsPanel.add(addButton);
		buttonsPanel.add(removeButton);
		add(sp, BorderLayout.CENTER);
		add(buttonsPanel, BorderLayout.NORTH);
		
		LineBorder lineBorderPanel = (LineBorder) BorderFactory.createLineBorder(PANEL_BORDER_COLOR);
		setBorder(BorderFactory.createTitledBorder(lineBorderPanel, PANEL_TITLE));
	}
	
	public void addQuery(String queryName) {
		
	}
	
	public Query getSelectedQuery() {
		return (Query) getQueryList().getSelectedValue();
	}

	public JList getQueryList() {
		return queryList;
	}

	public void setQueryList(JList queryList) {
		this.queryList = queryList;
	}

	public int getQueryCounter() {
		return queryCounter;
	}

	public void setQueryCounter(int queryCounter) {
		this.queryCounter = queryCounter;
	}
}
