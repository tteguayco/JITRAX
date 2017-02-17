package es.ull.etsii.jitrax.gui.main;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;

import javax.swing.Box;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class MenuBar extends JMenuBar {
	private static final long serialVersionUID = 1L;
	
	private JMenu fileMenu;
	private JMenu databaseMenu;
	private JMenu viewMenu;
	private JMenu languageMenu;
	private JMenu aboutMenu;
	
	public MenuBar() {buildFileMenu();
		buildDatabaseMenu();
		buildViewMenu();
		buildLanguageMenu();
		buildAboutMenu();
		
		add(fileMenu);
		add(databaseMenu);
		add(viewMenu);
		add(languageMenu);
		add(aboutMenu);
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
	}
	
	private void buildFileMenu() {
		setFileMenu(new JMenu("File"));
		JMenuItem saveRAQueryMI = new JMenuItem("Save RA Query");
		saveRAQueryMI.setMnemonic(KeyEvent.VK_N);

		getFileMenu().add(saveRAQueryMI);
	}
	
	private void buildDatabaseMenu() {
		setDatabaseMenu(new JMenu("Database"));
	}
	
	private void buildViewMenu() {
		setViewMenu(new JMenu("View"));
	}
	
	private void buildLanguageMenu() {
		setLanguageMenu(new JMenu("Language"));
	}
	
	private void buildAboutMenu() {
		setAboutMenu(new JMenu("About"));
	}

	public JMenu getFileMenu() {
		return fileMenu;
	}

	public void setFileMenu(JMenu fileMenu) {
		this.fileMenu = fileMenu;
	}

	public JMenu getDatabaseMenu() {
		return databaseMenu;
	}

	public void setDatabaseMenu(JMenu databaseMenu) {
		this.databaseMenu = databaseMenu;
	}

	public JMenu getViewMenu() {
		return viewMenu;
	}

	public void setViewMenu(JMenu viewMenu) {
		this.viewMenu = viewMenu;
	}

	public JMenu getLanguageMenu() {
		return languageMenu;
	}

	public void setLanguageMenu(JMenu languageMenu) {
		this.languageMenu = languageMenu;
	}

	public JMenu getAboutMenu() {
		return aboutMenu;
	}

	public void setAboutMenu(JMenu aboutMenu) {
		this.aboutMenu = aboutMenu;
	}
}
