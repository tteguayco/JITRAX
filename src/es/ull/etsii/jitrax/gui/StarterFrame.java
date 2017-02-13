package es.ull.etsii.jitrax.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;

public class StarterFrame extends JFrame {
	private static final int FRAME_WIDTH = 400;
	private static final int FRAME_HEIGHT = 110;
	
	private static final String FRAME_TITLE = "Welcome to JITRAX";
	
	private JButton createButton;
	private JButton loadButton;
	
	public StarterFrame() {
		createButton = new JButton("CREATE");
		loadButton = new JButton("LOAD");
		String firstMessage = "To start, we need a database."; 
		String secondMessage = "Would you like to create or load an existing one?";
		
		Border padding = BorderFactory.createEmptyBorder(10, 10, 5, 10);
		
		setLayout(new BorderLayout());
		JPanel messagePanel = new JPanel();
		JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		messagePanel.setBorder(padding);
		buttonsPanel.setBorder(padding);
		messagePanel.add(new JLabel(firstMessage));
		messagePanel.add(new JLabel(secondMessage));
		buttonsPanel.add(createButton);
		buttonsPanel.add(loadButton);
		
		add(messagePanel, BorderLayout.CENTER);
		add(buttonsPanel, BorderLayout.SOUTH);
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
		
		StarterFrame starterFrame = new StarterFrame();
		
		starterFrame.setTitle(FRAME_TITLE);
		starterFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		starterFrame.setLocationRelativeTo(null);
		starterFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		starterFrame.setVisible(true);
		starterFrame.setResizable(true);
	}
}
