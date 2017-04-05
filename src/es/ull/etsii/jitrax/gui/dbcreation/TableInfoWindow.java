package es.ull.etsii.jitrax.gui.dbcreation;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TableInfoWindow extends JFrame {
	private static final String WINDOW_TITLE = "New Table";
	private static final int WINDOW_WIDTH = 200;
	private static final int WINDOW_HEIGHT = 100;
	
	private JTextField newTableName;
	private JButton cancelButton;
	private JButton nextButton;
	
	public TableInfoWindow() {
		newTableName = new JTextField();
		cancelButton = new JButton(" ✘ Cancel ");
		nextButton = new JButton(" ✔ Next ");
		
		setLayout(new BorderLayout());
		
		JPanel tableNamePanel = new JPanel();
		tableNamePanel.add(new JLabel("Table name: "));
		tableNamePanel.add(newTableName);
		
		JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		buttonsPanel.add(cancelButton);
		buttonsPanel.add(nextButton);
		
		add(tableNamePanel, BorderLayout.CENTER);
		add(buttonsPanel, BorderLayout.SOUTH);
		
		buildWindow();
		pack();
	}
	
	private void buildWindow() {
		setTitle(WINDOW_TITLE);
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
	}

	public JTextField getNewTableName() {
		return newTableName;
	}

	public void setNewTableName(JTextField newTableName) {
		this.newTableName = newTableName;
	}

	public JButton getCancelButton() {
		return cancelButton;
	}

	public void setCancelButton(JButton cancelButton) {
		this.cancelButton = cancelButton;
	}

	public JButton getNextButton() {
		return nextButton;
	}

	public void setNextButton(JButton nextButton) {
		this.nextButton = nextButton;
	}
}
