package es.ull.etsii.jitrax.gui;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class GraphicTable extends JPanel {
	private static final long serialVersionUID = 1L;
	
	protected JTable graphicTable;
	
	public GraphicTable() {
		graphicTable = new JTable();
		
		graphicTable.setEnabled(false);
		graphicTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		graphicTable.setMinimumSize(graphicTable.getPreferredScrollableViewportSize());
		graphicTable.setPreferredScrollableViewportSize(graphicTable.getPreferredSize());
		graphicTable.setFillsViewportHeight(true);
		graphicTable.getTableHeader().setReorderingAllowed(false);
		graphicTable.setColumnSelectionAllowed(true);
		graphicTable.setRowSelectionAllowed(true);
		graphicTable.setRowSelectionAllowed(true);
		//(ListSelectionModel.SINGLE_SELECTION);
	}
	
	public GraphicTable(GraphicTable aGraphicTable) {
		graphicTable = new JTable(aGraphicTable.getGraphicTable().getModel());
	}
	
	public void disableCellsCurrentCells() {
		
	}
	
	/**
	 * Sets a minimum width for all table's columns.
	 */
	private void setMinColumnsWidth(int colMinWidth) {
		for (int i = 0; i < graphicTable.getColumnModel().getColumnCount(); i++) {
			graphicTable.getColumnModel().getColumn(i).setMinWidth(colMinWidth);
		}
		
		graphicTable.revalidate();
		graphicTable.repaint();
	}
	
	protected void resizeColumnWidth(int colMinWidth) {
		int graphicTableWidth = colMinWidth * graphicTable.getColumnCount();
		int parentWidth = graphicTable.getParent().getWidth();
		
		setMinColumnsWidth(colMinWidth);
		
		if (parentWidth < graphicTableWidth) {
			graphicTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		} else {
			graphicTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		}
	}

	public JTable getGraphicTable() {
		return graphicTable;
	}

	public void setGraphicTable(JTable graphicTable) {
		this.graphicTable = graphicTable;
	}
}
