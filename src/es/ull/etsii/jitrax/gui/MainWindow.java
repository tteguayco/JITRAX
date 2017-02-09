package es.ull.etsii.jitrax.gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

public class MainWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	private static final int FRAME_WIDTH = 1000;
	private static final int FRAME_HEIGHT = 600;
	
	private static final String FRAME_TITLE = "JITRAX";
	
	private MenuBar horizontalMenuPanel;
	private CodeEditorPanel codeEditorPanel;
	private InfoConsolePanel infoConsolePanel;
	
	public MainWindow() {
		horizontalMenuPanel = new MenuBar();
		codeEditorPanel = new CodeEditorPanel();
		infoConsolePanel = new InfoConsolePanel();
		
		JPanel leftPanel = new JPanel();
		JPanel rightPanel = new JPanel();
		
		rightPanel.setLayout(new BorderLayout());
		rightPanel.add(codeEditorPanel, BorderLayout.CENTER);
		rightPanel.add(infoConsolePanel, BorderLayout.SOUTH);
		
		setJMenuBar(horizontalMenuPanel);
		
		setLayout(new BorderLayout());
		add(rightPanel, BorderLayout.CENTER);
		add(leftPanel, BorderLayout.SOUTH);
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
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
	}
}
