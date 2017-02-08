package es.ull.etsii.jitrax.gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

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
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
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
