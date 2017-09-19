package es.ull.etsii.jitrax.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.text.DefaultCaret;

import es.ull.etsii.jitrax.gui.dialogs.FileDialog;
import es.ull.etsii.jitrax.i18n.Translatable;

public class Console extends JPanel implements Translatable {
	private static final long serialVersionUID = 1L;
	
	private static final String PANEL_TITLE = "Console";
	private static final String CONSOLE_STYLE = "monospaced";
	
	private static final String EXPORT_WINDOW_TITLE = "Export console";
	private static final String EXPORTATION_EXT = ".out";
	
	private static final Color PANEL_BORDER_COLOR = Color.GRAY;
	
	private static final int FONT_SIZE = 14;
	private static final int NROWS = 12;
	
	private JTextArea console;
	private JButton clearButton;
	//private JButton exportButton;

	private String panelTitle;
	
	public Console() {
		console = new JTextArea();
		clearButton = new JButton("Clear");
		//exportButton = new JButton("Export");
		setPanelTitle(PANEL_TITLE);

		clearButton.addActionListener(new ClearListener());
		//exportButton.addActionListener(new ExportListener());
		
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		buttonsPanel.add(clearButton);
		//buttonsPanel.add(exportButton);
		
		console.setFont(new Font(CONSOLE_STYLE, Font.PLAIN, FONT_SIZE));
		//console.setRows(NROWS);
		console.setEditable(false);
		JScrollPane sp = new JScrollPane(console);
		sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		console.setSelectedTextColor(Color.GRAY);
		console.setLineWrap(true);
		console.setWrapStyleWord(true);
		
		// Automatic down scrolling
		DefaultCaret caret = (DefaultCaret) getConsole().getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		
		setLayout(new BorderLayout());
		
		add(buttonsPanel, BorderLayout.SOUTH);
		add(sp);
		
		LineBorder lineBorderPanel = (LineBorder) BorderFactory.createLineBorder(PANEL_BORDER_COLOR);
		setBorder(BorderFactory.createTitledBorder(lineBorderPanel, getPanelTitle()));
	}

	private void createTitledBorder(String title) {
		LineBorder lineBorderPanel = (LineBorder) BorderFactory.createLineBorder(PANEL_BORDER_COLOR);
		setBorder(BorderFactory.createTitledBorder(lineBorderPanel, title));
	}

	public void appendMessage(String newMessage) {
		// Scroll to bottom
		getConsole().setCaretPosition(getConsole().getDocument().getLength());
		String currentText = getConsole().getText();
		getConsole().setText(currentText + newMessage);
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

	//public JButton getExportButton() {
	//	return exportButton;
	//}

	//public void setExportButton(JButton exportButton) {
	//	this.exportButton = exportButton;
	//}

	@Override
	public void translate(ResourceBundle rb) {
		getClearButton().setText(rb.getString("clear"));
		createTitledBorder(rb.getString("console"));
	}

	public String getPanelTitle() {
		return panelTitle;
	}

	public void setPanelTitle(String panelTitle) {
		this.panelTitle = panelTitle;
	}

	private class ClearListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			getConsole().setText("");
		}
	}
	
	private class ExportListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			// If the console is empty, not save
			if (!getConsole().getText().equals("")) {
				FileDialog fileDialog = new FileDialog();
				fileDialog.exportFile(EXPORT_WINDOW_TITLE, 
						getConsole().getText(), 
						EXPORTATION_EXT);
			}
		}
	}
	
}
