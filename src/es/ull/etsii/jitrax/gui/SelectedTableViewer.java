package es.ull.etsii.jitrax.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ComponentAdapter;

import es.ull.etsii.jitrax.adt.Table;

public class SelectedTableViewer extends GraphicTable {
	private static final long serialVersionUID = 1L;
	
	private static final int MINIMUM_WIDTH = 290;
	private static final int MINIMUM_HEIGHT = 130;
	private static final int MAXIMUM_WIDTH = 290;
	private static final int MAXIMUM_HEIGHT = 130;
	private static final int ODD_ROW_R = 220;
	private static final int ODD_ROW_G = 220;
	private static final int ODD_ROW_B = 220;
	private static final int COL_MIN_WIDTH = 100;
	
	private Table table;
	private DefaultTableModel tableModel;
	
	public SelectedTableViewer() {
		table = null;
		initializeGuiComponents();
		buildGraphicTable();
	}
	
	public SelectedTableViewer(Table aTable) {
		table = aTable;
		initializeGuiComponents();
		buildGraphicTable();
	}
	
	private void initializeGuiComponents() {
		//graphicTable = new JTable();
		tableModel = new DefaultTableModel();
		graphicTable.setModel(tableModel);
		
		// Listener for whole-row-selection
		graphicTable.addMouseListener(new RowSelectorListener());
	}
	
	public void makeEditable() {
		graphicTable.setEnabled(true);
	}
	
	/**
	 * Creates a customized JTable with the table's information.
	 */
	private void buildGraphicTable() {
		// Mark odd rows with a different color
		markOddRows();
		
		setLayout(new BorderLayout());
		
		graphicTable.setFocusable(true);
		graphicTable.setColumnSelectionAllowed(true);
		graphicTable.setRowSelectionAllowed(true);
		
		JScrollPane tableSP = new JScrollPane(graphicTable);
		tableSP.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		tableSP.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		add(tableSP, BorderLayout.CENTER);
		tableSP.setPreferredSize(new Dimension(MINIMUM_WIDTH, MINIMUM_HEIGHT));
		setMinimumSize(new Dimension(MINIMUM_WIDTH, MINIMUM_HEIGHT));
		setMaximumSize(new Dimension(MAXIMUM_WIDTH, MAXIMUM_HEIGHT));
		
		addComponentListener(new ComponentAdapter() {
		    public void componentResized(ComponentEvent e) {
		        resizeColumnWidth(COL_MIN_WIDTH);          
		    }
		});
		
		revalidate();
		repaint();
	}
	
	public void updateTable(Table aTable) {
		table = aTable;
		tableModel.setDataVector(aTable.getRowsData(), aTable.getColumnsNames());
		tableModel.fireTableDataChanged();
		updateTitle();
		resizeColumnWidth(COL_MIN_WIDTH);
	}
	
	/**
	 * Alternates the rows' color in the graphic table.
	 */
	private void markOddRows() {
		UIDefaults defaults = UIManager.getLookAndFeelDefaults();
		if (defaults.get("Table.alternateRowColor") == null) {
		    defaults.put("Table.alternateRowColor", new Color(ODD_ROW_R, ODD_ROW_G, ODD_ROW_B));
		}
	}

	public void updateTitle() {
		setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),
                getTable().getName(),
                TitledBorder.CENTER,
                TitledBorder.TOP));
	}
	
	public void addEmptyRow() {
		((DefaultTableModel) graphicTable.getModel()).addRow(new Object[] {});
		((DefaultTableModel) graphicTable.getModel()).fireTableDataChanged();
	}
	
	private boolean isRowSelected(int rowIndex) {
		for (int col = 0; col < graphicTable.getColumnCount(); col++) {
			if (!graphicTable.isCellSelected(rowIndex, col)) {
				return false; 
			}
		}
		
		return true;
	}
	
	private class RowSelectorListener extends MouseAdapter {
		@Override
	    public void mouseClicked(MouseEvent e)
	    {   
	       Point pnt = e.getPoint();
	       int row = graphicTable.rowAtPoint(pnt);
	       
	       // Allow only one row selected at a time
	       // Disable the others...
	       graphicTable.clearSelection();
	       
	       selectWholeRow(row);
	    }
	}
	
	public void selectWholeRow(int rowIndex) {
		// Check limits
	    if (rowIndex >= 0 && rowIndex < graphicTable.getRowCount()) {
		    // Select the whole row
	        graphicTable.addRowSelectionInterval(rowIndex, rowIndex);
	        graphicTable.addColumnSelectionInterval(0, 
	    		   graphicTable.getColumnCount() - 1);
		   
	    }
	}
	
	public Table getTable() {
		return table;
	}

	public void setTable(Table table) {
		this.table = table;
	}

	public JTable getGraphicTable() {
		return graphicTable;
	}

	public void setGraphicTable(JTable graphicTable) {
		this.graphicTable = graphicTable;
	}

	public DefaultTableModel getTableModel() {
		return tableModel;
	}

	public void setTableModel(DefaultTableModel tableModel) {
		this.tableModel = tableModel;
	}
}
