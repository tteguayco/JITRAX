package es.ull.etsii.jitrax.gui.databaseSetup;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class NewDatabaseWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private static final int FRAME_WIDTH = 260;
	private static final int FRAME_HEIGHT = 80;
	private static final int TEXTFIELD_WIDTH = 150;
	private static final int TEXTFIELD_HEIGHT = 21;
	
	private static final String WINDOW_TITLE = "Create a DB";
	
	private JTextField newDatabaseNameField;
	private JButton nextButton;
	
	public NewDatabaseWindow() {
		newDatabaseNameField = new JTextField();
		nextButton = new JButton("NEXT");
		newDatabaseNameField.setPreferredSize(new Dimension(TEXTFIELD_WIDTH, TEXTFIELD_HEIGHT));
		
		setLayout(new BorderLayout());
		
		EmptyBorder padding = new EmptyBorder(5, 5, 5, 5);
		JPanel textFieldPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		textFieldPanel.setBorder(padding);
		buttonsPanel.setBorder(padding);
		
		textFieldPanel.add(new JLabel("DB name: "));
		textFieldPanel.add(newDatabaseNameField);
		buttonsPanel.add(nextButton);
		
		add(textFieldPanel, BorderLayout.NORTH);
		add(buttonsPanel, BorderLayout.SOUTH);
		
		buildWindow();
	}
	
	private void buildWindow() {
		setTitle(WINDOW_TITLE);
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
	}
	
	public static void main(String[] args) {
		NewDatabaseWindow createDBWindow = new NewDatabaseWindow();
		createDBWindow.setVisible(true);
	}
}
