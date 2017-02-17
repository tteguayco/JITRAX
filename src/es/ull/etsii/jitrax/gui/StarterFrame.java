package es.ull.etsii.jitrax.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
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

public class StarterFrame extends JFrame {
	private static final int FRAME_WIDTH = 400;
	private static final int FRAME_HEIGHT = 130;
	
	private static final String FRAME_TITLE = "Welcome to JITRAX";
	
	private JButton createButton;
	private JButton loadButton;
	
	private Database database;
	
	public StarterFrame() {
		createButton = new JButton("CREATE");
		loadButton = new JButton("LOAD");
		String firstMessage = "To start, we need a database."; 
		String secondMessage = "Would you like to create or load an existing one?";
		
		Border padding = BorderFactory.createEmptyBorder(5, 10, 5, 10);
		
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
		
		setListeners();
	}
	
	private void buildWindow() {
		
	}
	
	private void setListeners() {
		// LOAD BUTTON
		loadButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
			    int option = fileChooser.showOpenDialog(StarterFrame.this);
			    String fileDir;
			    String fileName;
			    
			    // If the user presses OK
		        if (option == JFileChooser.APPROVE_OPTION) {
		        	// Take the file's path
		        	fileDir = fileChooser.getCurrentDirectory().toString() + "/";
		        	fileName = fileChooser.getSelectedFile().getName();
		        	
		        	// Open the file and create a database from it
		        	DatabaseFileLoader databaseFileLoader = new DatabaseFileLoader(fileDir + fileName);
		        	databaseFileLoader.readDatabaseFromFile();
		        	
		        	// Fetch the created DB
		        	database = databaseFileLoader.getDatabase();
		        	
		        	ArrayList<Database> newDatabase = new ArrayList<Database>();
		        	newDatabase.add(database);
		        	MainWindow window = new MainWindow(newDatabase);
		        	
		        	// Close this frame
		        	StarterFrame.this.setVisible(false);
		        	StarterFrame.this.dispose();
		        }
			}
		});
	}
	
	private Database createDatabaseFromFile() {
		Database newDatabase = null;
		
		return newDatabase;
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
		starterFrame.setResizable(false);
	}
}
