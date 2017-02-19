package es.ull.etsii.jitrax.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;

import es.ull.etsii.jitrax.adt.Database;
import es.ull.etsii.jitrax.gui.main.MainWindow;

public class StarterWindow extends JFrame {
	private static final int FRAME_WIDTH = 400;
	private static final int FRAME_HEIGHT = 140;
	
	private static final String FRAME_TITLE = "Welcome to JITRAX";
	
	private JButton createButton;
	private JButton loadButton;
	
	public StarterWindow() {
		createButton = new JButton("CREATE");
		loadButton = new JButton("LOAD");
		String firstMessage = "To start, we need a database."; 
		String secondMessage = "Would you like to create or load an existing one?";
		
		JLabel firstMessageLabel = new JLabel(firstMessage);
		JLabel secondMessageLabel = new JLabel(secondMessage);
		firstMessageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		secondMessageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		Border padding = BorderFactory.createEmptyBorder(10, 10, 10, 10);
		
		setLayout(new BorderLayout());
		JPanel messagePanel = new JPanel();
		JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		messagePanel.setLayout(new BoxLayout(messagePanel, BoxLayout.Y_AXIS));
		messagePanel.setBorder(padding);
		messagePanel.add(firstMessageLabel);
		messagePanel.add(Box.createVerticalStrut(3));
		messagePanel.add(secondMessageLabel);
		buttonsPanel.add(createButton);
		buttonsPanel.add(loadButton);
		
		JPanel mainContainer = new JPanel(new BorderLayout());
		mainContainer.setBorder(padding);
		
		mainContainer.add(messagePanel, BorderLayout.CENTER);
		mainContainer.add(buttonsPanel, BorderLayout.SOUTH);
		add(mainContainer, BorderLayout.CENTER);
		
		setListeners();
	}
	
	private void setListeners() {
		// Create a DB from file specification
		loadButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				/*
				 * Show a FileDialog to get the file with a new DB specification.
				 * Create a new DB from it.
				 * Launch a MainWindow with the former DB loaded.
				 */
				FileDialog fileDialog = new FileDialog(StarterWindow.this);
				Database newDatabase = fileDialog.importDatabaseDialog();
				
				if (newDatabase != null) {
					ArrayList<Database> databases = new ArrayList<Database>();
					databases.add(newDatabase);
					launchMainWindow(databases);
				}
			}
		});
		
		// Create a DB from GUI
		createButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
	}
	
	private void launchMainWindow(ArrayList<Database> databases) {
		// Close this frame
    	StarterWindow.this.setVisible(false);
    	StarterWindow.this.dispose();
		
		// Load the new database in the main frame
    	MainWindow window = new MainWindow(databases);
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
		
		StarterWindow window = new StarterWindow();
		
		window.setTitle(FRAME_TITLE);
		window.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		window.setMaximumSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		window.setResizable(false);
		window.pack();
	}
}
