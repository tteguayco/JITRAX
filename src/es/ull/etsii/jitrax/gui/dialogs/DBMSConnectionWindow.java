package es.ull.etsii.jitrax.gui.dialogs;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class DBMSConnectionDialog extends JFrame {
	private static final String WINDOW_TITLE = "DBMS Connection";
	private static final String[] DBMS_LIST = { "PostgreSQL" };
	private static final String DEFAULT_HOSTNAME = "127.0.0.1";
	private static final String DEFAULT_PORT = "5432";

	private static final int WINDOW_WIDTH = 240;
	private static final int WINDOW_HEIGHT = 240;
	
	private static final int TEXTFIELD_WIDTH = 130;
	private static final int TEXTFIELD_HEIGHT = 30;
	
	private JComboBox<String> dbmsList;
	
	private JTextField hostname;
	private JTextField port;
	private JTextField username;
	private JPasswordField password;
	private JButton nextButton;
	
	public DBMSConnectionDialog() {
		dbmsList = new JComboBox<String>(DBMS_LIST);
		hostname = new JTextField();
		port = new JTextField();
		username = new JTextField();
		password = new JPasswordField();
		nextButton = new JButton("✔ Next");
		
		hostname.setText(DEFAULT_HOSTNAME);
		port.setText(DEFAULT_PORT);
		
		dbmsList.setPreferredSize(new Dimension(TEXTFIELD_WIDTH, TEXTFIELD_HEIGHT));
		hostname.setPreferredSize(new Dimension(TEXTFIELD_WIDTH, TEXTFIELD_HEIGHT));
		port.setPreferredSize(new Dimension(TEXTFIELD_WIDTH, TEXTFIELD_HEIGHT));
		username.setPreferredSize(new Dimension(TEXTFIELD_WIDTH, TEXTFIELD_HEIGHT));
		password.setPreferredSize(new Dimension(TEXTFIELD_WIDTH, TEXTFIELD_HEIGHT));
		
		JPanel mainContainer = new JPanel();
		mainContainer.setLayout(new BoxLayout(mainContainer, BoxLayout.Y_AXIS));
		mainContainer.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		JPanel dbmsPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		dbmsPanel.add(new JLabel("DBMS: "));
		dbmsPanel.add(dbmsList);
		
		JPanel hostnamePanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		hostnamePanel.add(new JLabel("Hostname: "));
		hostnamePanel.add(hostname);
		
		JPanel portPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		portPanel.add(new JLabel("Port: "));
		portPanel.add(port);
		
		JPanel usernamePanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		usernamePanel.add(new JLabel("Username: "));
		usernamePanel.add(username);
		
		JPanel passwordPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		passwordPanel.add(new JLabel("Password: "));
		passwordPanel.add(password);
		
		JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		buttonsPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		buttonsPanel.add(nextButton);
		
		mainContainer.add(dbmsPanel);
		mainContainer.add(hostnamePanel);
		mainContainer.add(portPanel);
		mainContainer.add(usernamePanel);
		mainContainer.add(passwordPanel);
		mainContainer.add(buttonsPanel);
		add(mainContainer);
		
		buildWindow();
	}
	
	private void buildWindow() {
		setTitle(WINDOW_TITLE);
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		pack();
		setResizable(false);
	}
	
	public static void main(String[] args) {
		try {
	        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	        setDefaultLookAndFeelDecorated(true);
	    }
	    catch (UnsupportedLookAndFeelException e) {
	    	e.printStackTrace();
	    }
	    catch (ClassNotFoundException e) {
	    	e.printStackTrace();
	    }
	    catch (InstantiationException e) {
	    	e.printStackTrace();
	    }
	    catch (IllegalAccessException e) {
	    	e.printStackTrace();
	    }
		
		DBMSConnectionDialog dialog = new DBMSConnectionDialog();
	}
}
