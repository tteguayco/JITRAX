package es.ull.etsii.jitrax.gui.main;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;

public class MenuBar extends JMenuBar {
	private static final long serialVersionUID = 1L;
	
	private JMenu fileMenu;
	private JMenu databaseMenu;
	private JMenu viewMenu;
	private JMenu languageMenu;
	private JMenu aboutMenu;
	
	private JRadioButtonMenuItem defaultViewRadioButton;
	private JRadioButtonMenuItem nimbusViewRadioButton;
	
	private JRadioButtonMenuItem englishRadioButton;
	
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
		setDefaultViewRadioButton(new JRadioButtonMenuItem("SO Default", true));
		setNimbusViewRadioButton(new JRadioButtonMenuItem("Nimbus", true));
		
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(getDefaultViewRadioButton());
		buttonGroup.add(getNimbusViewRadioButton());
		
		setViewMenu(new JMenu("View"));
		getViewMenu().add(getDefaultViewRadioButton());
		getViewMenu().add(getNimbusViewRadioButton());
	}
	
	private void buildLanguageMenu() {
		setEnglishRadioButton(new JRadioButtonMenuItem("English", true));
		
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(getEnglishRadioButton());
		
		setLanguageMenu(new JMenu("Language"));
		getLanguageMenu().add(getEnglishRadioButton());
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

	public JRadioButtonMenuItem getDefaultViewRadioButton() {
		return defaultViewRadioButton;
	}

	public void setDefaultViewRadioButton(JRadioButtonMenuItem defaultViewRadioButton) {
		this.defaultViewRadioButton = defaultViewRadioButton;
	}

	public JRadioButtonMenuItem getNimbusViewRadioButton() {
		return nimbusViewRadioButton;
	}

	public void setNimbusViewRadioButton(JRadioButtonMenuItem nimbusViewRadioButton) {
		this.nimbusViewRadioButton = nimbusViewRadioButton;
	}

	public JRadioButtonMenuItem getEnglishRadioButton() {
		return englishRadioButton;
	}

	public void setEnglishRadioButton(JRadioButtonMenuItem englishRadioButton) {
		this.englishRadioButton = englishRadioButton;
	}
}
