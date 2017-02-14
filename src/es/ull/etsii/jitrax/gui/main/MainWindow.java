package es.ull.etsii.jitrax.gui.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import es.ull.etsii.jitrax.controllers.SelectedDBController;

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
	private InfoConsolePanel infoConsolePanel;
	private DatabaseViewerPanel databaseViewerPanel;
	
	public MainWindow() {
		horizontalMenuPanel = new MenuBar();
		codeEditorPanel = new CodeEditorPanel();
		infoConsolePanel = new InfoConsolePanel();
		databaseViewerPanel = new DatabaseViewerPanel();
		
		JPanel mainContainer = new JPanel();
		JPanel leftPanel = new JPanel();
		JPanel rightPanel = new JPanel();
		
		mainContainer.setLayout(new BorderLayout());
		leftPanel.add(databaseViewerPanel);
		rightPanel.setLayout(new BorderLayout());
		rightPanel.add(codeEditorPanel, BorderLayout.CENTER);
		rightPanel.add(infoConsolePanel, BorderLayout.SOUTH);
		
		setJMenuBar(horizontalMenuPanel);
		
		mainContainer.setBorder(new EmptyBorder(BORDER_GAP, BORDER_GAP, BORDER_GAP, BORDER_GAP));
		
		setLayout(new BorderLayout());
		
		add(databaseViewerPanel, BorderLayout.WEST);
		mainContainer.add(rightPanel, BorderLayout.CENTER);
		add(mainContainer, BorderLayout.CENTER);
		
		SelectedDBController selectedDBController = 
				new SelectedDBController(databaseViewerPanel.getTablesPanel(), 
										databaseViewerPanel.getSelectedTablePanel());
	}
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			System.out.println("Unsupported Lookn' Feel. Setting the default one...");
			e.printStackTrace();
		}
		
		MainWindow window = new MainWindow();
		
		window.setTitle(FRAME_TITLE);
		window.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		window.setMinimumSize(new Dimension(MINIMUM_WIDTH, MINIMUM_HEIGHT));
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
	}
}
