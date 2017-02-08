package es.ull.etsii.jitrax.gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class MainWindow extends JFrame {
	private static final int FRAME_WIDTH = 1000;
	private static final int FRAME_HEIGHT = 600;
	
	private static final String FRAME_TITLE = "JITRAX";
	
	private VerticalMenuPanel verticalMenuPanel;
	private CodeEditorPanel codeEditorPanel;
	
	public MainWindow() {
		verticalMenuPanel = new VerticalMenuPanel();
		codeEditorPanel = new CodeEditorPanel();
		
		setLayout(new BorderLayout());
		add(verticalMenuPanel, BorderLayout.NORTH);
		add(codeEditorPanel, BorderLayout.CENTER);
	}
	
	public static void main(String[] args) {
		MainWindow window = new MainWindow();
		
		window.setTitle(FRAME_TITLE);
		window.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
	}
}
