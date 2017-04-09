package es.ull.etsii.jitrax.gui;

import javax.swing.JPanel;
import javax.swing.JTable;

public class GraphicTable extends JPanel {
	
	protected JTable graphicTable;
	
	public GraphicTable() {
		graphicTable = new JTable();
	}
	
	/**
	 * Sets a minimum width for all table's columns.
	 */
	private void setMinColumnsWidth(int colMinWidth) {
		for (int i = 0; i < graphicTable.getColumnModel().getColumnCount(); i++) {
			graphicTable.getColumnModel().getColumn(i).setMinWidth(colMinWidth);
		}
	}
	
	protected void resizeColumnWidth(int colMinWidth) {
		int graphicTableWidth = colMinWidth * graphicTable.getColumnCount();
		int parentWidth = graphicTable.getParent().getWidth();
		
		setMinColumnsWidth(colMinWidth);
		
		System.out.println("graphicTableWidth: " + graphicTableWidth);
		System.out.println("parentWidth: " + parentWidth);
		
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
