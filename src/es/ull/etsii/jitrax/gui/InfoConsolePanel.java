package es.ull.etsii.jitrax.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

public class InfoConsolePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private static final String PANEL_TITLE = "Console";
	private static final String DEFAULT_QUERY = "PROJECT [name, age] (Students)";
	private static final String CONSOLE_STYLE = "Courier New";
	
	private static final Color PANEL_BORDER_COLOR = Color.GRAY;
	
	private static final int NROWS = 6;
	
	private JTextArea console;
	
	public InfoConsolePanel() {
		console = new JTextArea();
		
		console.setFont(new Font(CONSOLE_STYLE, Font.PLAIN, 15));
		console.setRows(NROWS);
		//console.setEditable(false);
		JScrollPane sp = new JScrollPane(console);
		
		console.setSelectedTextColor(Color.GRAY);
		
		setLayout(new BorderLayout());
		add(sp);
		
		LineBorder lineBorderPanel = (LineBorder) BorderFactory.createLineBorder(PANEL_BORDER_COLOR);
		setBorder(BorderFactory.createTitledBorder(lineBorderPanel, PANEL_TITLE));
	}
}
