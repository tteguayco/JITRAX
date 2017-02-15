package es.ull.etsii.jitrax.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import es.ull.etsii.jitrax.adt.*;

public class SelectedDatabasePanel extends JPanel {
	private static final int TOP_PADDING = 5;
	private static final int LEFT_PADDING = 20;
	private static final int BOTTOM_PADDING = 5;
	private static final int RIGHT_PADDING = 20;
	private static final int COMBOBOX_WIDTH = 200;
	private static final int COMBOBOX_HEIGHT = 40;
	private static final int MINIMUM_WIDTH = 250;
	private static final int MINIMUM_HEIGHT = 100;
	private static final int MAXIMUM_WIDTH = 250;
	private static final int MAXIMUM_HEIGHT = 100;
	private static final int VGAP = 5;
	private static final int HGAP = 5;
	private static final int NROWS = 2;
	private static final int NCOLS = 1;
	
	private JComboBox<String> dbComboBox;
	private JButton addButton;
	private JButton eraseButton;
	
	public SelectedDatabasePanel(ArrayList<Database> databases) {
		dbComboBox = new JComboBox<String>();
		addButton = new JButton("ADD");
		eraseButton = new JButton("ERASE");
		
		updateComboBox(databases);
		setLayout(new GridLayout(NROWS, NCOLS, VGAP, HGAP));
		setBorder(new EmptyBorder(TOP_PADDING,
								LEFT_PADDING,
								BOTTOM_PADDING,
								RIGHT_PADDING));
		
		// ComboBox settings
		dbComboBox.setPreferredSize(new Dimension(COMBOBOX_WIDTH, COMBOBOX_HEIGHT));
		((JLabel)dbComboBox.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		dbComboBox.setFocusable(false);
		
		JPanel comboBoxContainer = new JPanel();
		comboBoxContainer.add(dbComboBox);
		
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.add(addButton);
		buttonsPanel.add(eraseButton);
		
		add(comboBoxContainer);
		add(buttonsPanel);
		
		setMinimumSize(new Dimension(MINIMUM_WIDTH, MINIMUM_HEIGHT));
		setMaximumSize(new Dimension(MAXIMUM_WIDTH, MAXIMUM_HEIGHT));
	}
	
	/**
	 * Fills the combobox with the list of databases.
	 * @param databases
	 */
	private void updateComboBox(ArrayList<Database> databases) {
		for (int i = 0; i < databases.size(); i++) {
			getDbComboBox().addItem(databases.get(i).getName());
		}
	}

	public JComboBox<String> getDbComboBox() {
		return dbComboBox;
	}

	public void setDbComboBox(JComboBox<String> dbComboBox) {
		this.dbComboBox = dbComboBox;
	}

	public JButton getAddButton() {
		return addButton;
	}

	public void setAddButton(JButton addButton) {
		this.addButton = addButton;
	}

	public JButton getEraseButton() {
		return eraseButton;
	}

	public void setEraseButton(JButton eraseButton) {
		this.eraseButton = eraseButton;
	}
}
