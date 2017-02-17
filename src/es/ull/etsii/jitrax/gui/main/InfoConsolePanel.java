package es.ull.etsii.jitrax.gui.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

public class InfoConsolePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private static final String PANEL_TITLE = "Console";
	private static final String DEFAULT_QUERY = "PROJECT [name, age] (Students)";
	private static final String CONSOLE_STYLE = "Courier New";
	private static final String CONSOLE_START_STR = "> ";
	private static final String WELCOME_MESSAGE = "JITRAX v1.0";
	
	private static final Color PANEL_BORDER_COLOR = Color.GRAY;
	
	private static final int NROWS = 8;
	
	private JTextArea console;
	private JButton clearButton;
	private JButton exportButton;
	
	public InfoConsolePanel() {
		console = new JTextArea();
		clearButton = new JButton("Clear");
		exportButton = new JButton("Export");
		
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		buttonsPanel.add(clearButton);
		buttonsPanel.add(exportButton);
		
		console.setFont(new Font(CONSOLE_STYLE, Font.PLAIN, 15));
		console.setRows(NROWS);
		console.setEditable(false);
		JScrollPane sp = new JScrollPane(console);
		console.setSelectedTextColor(Color.GRAY);
		appendLine(WELCOME_MESSAGE);
		
		setLayout(new BorderLayout());
		
		add(buttonsPanel, BorderLayout.SOUTH);
		add(sp);
		
		LineBorder lineBorderPanel = (LineBorder) BorderFactory.createLineBorder(PANEL_BORDER_COLOR);
		setBorder(BorderFactory.createTitledBorder(lineBorderPanel, PANEL_TITLE));
	}
	
	public void appendLine(String newLine) {
		getConsole().append(CONSOLE_START_STR + newLine + "\n");
	}

	public JTextArea getConsole() {
		return console;
	}

	public void setConsole(JTextArea console) {
		this.console = console;
	}

	public JButton getClearButton() {
		return clearButton;
	}

	public void setClearButton(JButton clearButton) {
		this.clearButton = clearButton;
	}

	public JButton getExportButton() {
		return exportButton;
	}

	public void setExportButton(JButton exportButton) {
		this.exportButton = exportButton;
	}
}
