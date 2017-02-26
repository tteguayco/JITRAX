package es.ull.etsii.jitrax.gui;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import es.ull.etsii.jitrax.adt.Attribute;
import es.ull.etsii.jitrax.adt.Table;

public class TablePanel extends JPanel {
	private static final Color SELECTED_TABLE_COLOR = Color.BLACK;
	private static final Color UNSELECTED_TABLE_COLOR = new Color(70, 70, 70);
	
	private static final int NEW_TABLE_PANEL_TOP_PADDING = 10;
	private static final int NEW_TABLE_PANEL_LEFT_PADDING = 10;
	private static final int NEW_TABLE_PANEL_BOTTOM_PADDING = 0;
	private static final int NEW_TABLE_PANEL_RIGHT_PADDING = 10;
	private static final int SELECTED_PANEL_BORDER_THICKNESS = 2;
	private static final int UNSELECTED_PANEL_BORDER_THICKNESS = 1;
	private static final int GAP_BETWEEN_ATTRIBUTES = 5;
	
	private Table table;
	private boolean isSelected;
	
	public TablePanel(Table aTable) {
		table = aTable;
		
		// Adding the panel's border padding
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(BorderFactory.createEmptyBorder(NEW_TABLE_PANEL_TOP_PADDING, 
												NEW_TABLE_PANEL_LEFT_PADDING, 
												NEW_TABLE_PANEL_BOTTOM_PADDING, 
												NEW_TABLE_PANEL_RIGHT_PADDING));
		
		// Fill the panel with the attributes info
		addAttributes();
	}
	
	private void addAttributes() {
		// Adding attributes to the panel, along with their data types
		for (int i = 0; i < getTable().getAttributes().size(); i++) {
			Attribute auxAttribute = getTable().getAttributes().get(i);
			String attributeName = auxAttribute.getName();
			String dataType = auxAttribute.getDataType().toString();
			
			// Set as not selected
			unselect();
			
			// Gap between attributes
			add(Box.createVerticalStrut(GAP_BETWEEN_ATTRIBUTES));
			String newAttributeText = "";
			JLabel newAttributeLabel = null;
			
			// Adding label PK to the new attribute in case it is primary key
			if (auxAttribute.isPrimaryKey()) {
				 newAttributeText = " (" + dataType + ", PK)";
				 newAttributeLabel = new JLabel("<html><u>" 
						 						+ attributeName 
						 						+ "</u>"
						 						+ newAttributeText
						 						+ "</html>");
			} else {
				newAttributeText = attributeName + " (" + dataType + ")";
				newAttributeLabel = new JLabel(newAttributeText);
			}
			
			// Adding the new attribute's info to the current table panel
			add(newAttributeLabel);
			
			// Extra gap
			add(Box.createVerticalStrut(GAP_BETWEEN_ATTRIBUTES));
		}
	}
	
	public void updateTable(Table aTable) {
		table = aTable;
		revalidate();
		repaint();
	}
	
	public void select() {
		buildBorder(SELECTED_TABLE_COLOR, SELECTED_PANEL_BORDER_THICKNESS);
	}
	
	public void unselect() {
		buildBorder(UNSELECTED_TABLE_COLOR, UNSELECTED_PANEL_BORDER_THICKNESS);
	}
	
	private void buildBorder(Color color, int borderThickness) {
		setBorder(BorderFactory.createTitledBorder(
				new LineBorder(color, borderThickness),
                getTable().getName(),
                TitledBorder.CENTER,
                TitledBorder.TOP,
                null,
                color));
	}
	
	public Table getTable() {
		return table;
	}

	public void setTable(Table table) {
		this.table = table;
	}

	public boolean isSelected() {
		return isSelected;
	}

	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}
}
