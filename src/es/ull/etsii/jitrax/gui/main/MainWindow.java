package es.ull.etsii.jitrax.gui.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import es.ull.etsii.interpreters.RelationalAlgebraInterpreter;
import es.ull.etsii.jitrax.adt.Database;

public class MainWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	private static final int FRAME_WIDTH = 1000;
	private static final int FRAME_HEIGHT = 600;
	private static final int MINIMUM_WIDTH = 800;
	private static final int MINIMUM_HEIGHT = 500;
	private static final int BORDER_GAP = 10;
	
	private static final String FRAME_TITLE = "JITRAX";
	
	private MenuBar horizontalMenuPanel;
	private CodeEditorPanel codeEditorPanel;
	private Console infoConsolePanel;
	private DatabaseViewerPanel databaseViewerPanel;
	
	private SelectedTableExchanger selectedTableExchanger;
	private RelationalAlgebraInterpreter raInterpreter;
	
	public MainWindow(ArrayList<Database> newDatabases) {
		horizontalMenuPanel = new MenuBar();
		codeEditorPanel = new CodeEditorPanel();
		infoConsolePanel = new Console();
		databaseViewerPanel = new DatabaseViewerPanel(newDatabases);
		
		JPanel mainContainer = new JPanel();
		JPanel rightPanel = new JPanel();
		
		mainContainer.setLayout(new BorderLayout());
		rightPanel.setLayout(new BorderLayout());
		rightPanel.add(codeEditorPanel, BorderLayout.CENTER);
		rightPanel.add(infoConsolePanel, BorderLayout.SOUTH);
		
		setJMenuBar(horizontalMenuPanel);
		
		mainContainer.setBorder(new EmptyBorder(BORDER_GAP, BORDER_GAP, BORDER_GAP, BORDER_GAP));
		
		setLayout(new BorderLayout());
		mainContainer.add(databaseViewerPanel, BorderLayout.WEST);
		mainContainer.add(rightPanel, BorderLayout.CENTER);
		add(mainContainer, BorderLayout.CENTER);
		
		// Object that shows the selected table in the quick view in the GUI
		selectedTableExchanger = 
			new SelectedTableExchanger(databaseViewerPanel.getTablesPanel(), 
				databaseViewerPanel.getSelectedTablePanel());
		
		//raInterpreter = new RelationalAlgebraInterpreter(databaseViewerPanel);
		
		buildWindow();
	}
	
	private void buildWindow() {
		setTitle(FRAME_TITLE);
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setMinimumSize(new Dimension(MINIMUM_WIDTH, MINIMUM_HEIGHT));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
