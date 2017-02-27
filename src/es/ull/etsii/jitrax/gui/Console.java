package es.ull.etsii.jitrax.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

public class Console extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private static final String PANEL_TITLE = "Console";
	private static final String DEFAULT_QUERY = "PROJECT [name, age] (Students)";
	private static final String CONSOLE_STYLE = "Courier New";
	
	private static final String EXPORT_FILECHOOSER_TITLE = "Export console";
	private static final String EXPORTATION_EXT = ".out";
	
	private static final Color PANEL_BORDER_COLOR = Color.GRAY;
	
	private static final int NROWS = 8;
	
	private JTextArea console;
	private JButton clearButton;
	private JButton exportButton;
	
	public Console() {
		console = new JTextArea();
		clearButton = new JButton("Clear");
		exportButton = new JButton("Export");
		
		clearButton.addActionListener(new ClearListener());
		exportButton.addActionListener(new ExportListener());
		
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		buttonsPanel.add(clearButton);
		buttonsPanel.add(exportButton);
		
		console.setFont(new Font(CONSOLE_STYLE, Font.PLAIN, 15));
		console.setRows(NROWS);
		console.setEditable(false);
		JScrollPane sp = new JScrollPane(console);
		console.setSelectedTextColor(Color.GRAY);
		
		setLayout(new BorderLayout());
		
		add(buttonsPanel, BorderLayout.SOUTH);
		add(sp);
		
		LineBorder lineBorderPanel = (LineBorder) BorderFactory.createLineBorder(PANEL_BORDER_COLOR);
		setBorder(BorderFactory.createTitledBorder(lineBorderPanel, PANEL_TITLE));
	}
	
	public void appendMessage(String newMessage) {
		getConsole().append(newMessage);
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
	
	private class ClearListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			getConsole().setText("");
		}
	}
	
	private class ExportListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			// If the console is empty, not save
			if (getConsole().getText().equals("")) {
				return;
			}
			
			JFileChooser fileChooser = new JFileChooser();
			PrintWriter printWriter;
			String filePath;
			int userSelection;
			
			fileChooser.setDialogTitle(EXPORT_FILECHOOSER_TITLE);
			userSelection = fileChooser.showSaveDialog(null);
			
			// Export console content to file
			if (userSelection == JFileChooser.APPROVE_OPTION) {
				filePath = fileChooser.getSelectedFile().getAbsolutePath();
				
				int response;
				BufferedReader br;
				
				try {
					br = new BufferedReader(new FileReader(filePath));
					
					// If file is not empty
					try {
						if (br.readLine() != null) {
							response = JOptionPane.showConfirmDialog(fileChooser, 
						            "Do you want to replace the existing file?",
						            "Confirm", JOptionPane.YES_NO_OPTION, 
						            JOptionPane.QUESTION_MESSAGE);
							br.close();
							
							// Confirm saving
							if (response != JOptionPane.YES_OPTION) {
								return;
							}
						}
					} catch (HeadlessException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				} 
				
				catch (FileNotFoundException e1) {
					new File(filePath);
				} 
				
				try {
					printWriter = new PrintWriter(filePath);
					printWriter.print(getConsole().getText());
					printWriter.close();
				} 
				
				catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} 
			}
		}
	}
}
