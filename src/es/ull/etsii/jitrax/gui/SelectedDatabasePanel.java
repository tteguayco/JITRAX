package es.ull.etsii.jitrax.gui;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import es.ull.etsii.jitrax.adt.*;

public class SelectedDatabasePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
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
	private JButton alterButton;
	private JButton removeButton;
	
	public SelectedDatabasePanel(ArrayList<Database> databases) {
		dbComboBox = new JComboBox<String>();
		alterButton = new JButton("ALTER");
		removeButton = new JButton("REMOVE");
		
		setLayout(new GridLayout(NROWS, NCOLS, VGAP, HGAP));
		setBorder(new EmptyBorder(TOP_PADDING,
								LEFT_PADDING,
								BOTTOM_PADDING,
								RIGHT_PADDING));
		
		updateComboBox(databases);
		
		// ComboBox settings
		dbComboBox.setPreferredSize(new Dimension(COMBOBOX_WIDTH, COMBOBOX_HEIGHT));
		DefaultListCellRenderer dlcr = new DefaultListCellRenderer(); 
		dlcr.setHorizontalAlignment(DefaultListCellRenderer.CENTER); 
		dbComboBox.setRenderer(dlcr);
		dbComboBox.setFocusable(false);
		
		JPanel comboBoxContainer = new JPanel();
		comboBoxContainer.add(dbComboBox);
		
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.add(alterButton);
		buttonsPanel.add(removeButton);
		
		add(comboBoxContainer);
		add(buttonsPanel);
		
		setMinimumSize(new Dimension(MINIMUM_WIDTH, MINIMUM_HEIGHT));
		setMaximumSize(new Dimension(MAXIMUM_WIDTH, MAXIMUM_HEIGHT));
		
		setListeners();
	}
	
	public void setListeners() {
		alterButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
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

	public JButton getAlterButton() {
		return alterButton;
	}

	public void setAlterButton(JButton alterButton) {
		this.alterButton = alterButton;
	}
}
