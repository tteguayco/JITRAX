package es.ull.etsii.jitrax.gui;

import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class VerticalMenuPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JMenuBar menu;
	private JMenu fileMenu;
	private JMenu databaseMenu;
	private JMenu viewMenu;
	private JMenu languageMenu;
	private JMenu aboutMenu;
	
	public VerticalMenuPanel() {
		menu = new JMenuBar();
		
		buildFileMenu();
		buildDatabaseMenu();
		
		menu.add(fileMenu);
		//menu.add(databaseMenu);
		//menu.add(viewMenu);
		//menu.add(languageMenu);
		//menu.add(aboutMenu);
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
		add(menu);
		
	}
	
	private void buildFileMenu() {
		setFileMenu(new JMenu("File"));
		JMenuItem saveRAQueryMI = new JMenuItem("Save RA Query");
		saveRAQueryMI.setMnemonic(KeyEvent.VK_N);

		getFileMenu().add(saveRAQueryMI);
	}
	
	private void buildDatabaseMenu() {
		
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

	public JMenuBar getMenu() {
		return menu;
	}

	public void setMenu(JMenuBar menu) {
		this.menu = menu;
	}
}
