package es.ull.etsii.jitrax.gui;

import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSeparator;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

public class MenuBar extends JMenuBar {
	private static final long serialVersionUID = 1L;
	
	private static final String DOC_URL = "";
	private static final String SOURCE_CODE_URL = "https://bitbucket.org/tteguayco/jitrax/src";
	
	private JMenu fileMenu;
	private JMenu editMenu;
	private JMenu viewMenu;
	private JMenu languageMenu;
	private JMenu helpMenu;
	
	private JRadioButtonMenuItem defaultViewRadioButton;
	private JRadioButtonMenuItem nimbusViewRadioButton;
	
	private JMenuItem openDatabase;
	private JMenuItem newDatabase;
	private JMenuItem saveDatabase;
	private JMenuItem saveDatabaseAs;
	private JMenuItem importOption;
	private JMenuItem exportOption;
	private JMenuItem exitOption;
	
	private JMenuItem onlineDocumentationOption;
	private JMenuItem sourceCodeOption;
	private JMenuItem aboutOption;
	
	private JRadioButtonMenuItem englishRadioButton;
	
	public MenuBar() {
		buildFileMenu();
		buildEditMenu();
		buildViewMenu();
		buildLanguageMenu();
		buildHelpMenu();
		
		add(fileMenu);
		add(editMenu);
		add(viewMenu);
		add(languageMenu);
		add(helpMenu);
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
	}
	
	private void buildFileMenu() {
		setFileMenu(new JMenu("File"));
		fileMenu.setMnemonic(KeyEvent.VK_F);
		
		newDatabase = new JMenuItem("New Database");
		newDatabase.setMnemonic(KeyEvent.VK_N);
		
		openDatabase = new JMenuItem("Open...");
		openDatabase.setMnemonic(KeyEvent.VK_O);
		
		saveDatabase = new JMenuItem("Save");
		saveDatabase.setMnemonic(KeyEvent.VK_S);
		
		saveDatabaseAs = new JMenuItem("Save As...");
		
		saveDatabase.setEnabled(false);
		saveDatabaseAs.setEnabled(false);
		
		importOption = new JMenuItem("Import");
		exportOption = new JMenuItem("Export");
		
		exitOption = new JMenuItem("Exit");
		
		getFileMenu().add(newDatabase);
		getFileMenu().add(openDatabase);
		getFileMenu().add(new JSeparator());
		getFileMenu().add(saveDatabase);
		getFileMenu().add(saveDatabaseAs);
		getFileMenu().add(new JSeparator());
		getFileMenu().add(importOption);
		getFileMenu().add(exportOption);
		getFileMenu().add(new JSeparator());
		getFileMenu().add(exitOption);
	}
	
	private void buildEditMenu() {
		editMenu = new JMenu("Edit");
		editMenu.setMnemonic(KeyEvent.VK_E);
	}
	
	private void buildViewMenu() {
		setDefaultViewRadioButton(new JRadioButtonMenuItem("OS Default", false));
		setNimbusViewRadioButton(new JRadioButtonMenuItem("Nimbus", true));
		
		getDefaultViewRadioButton().addActionListener(new LAFListener());
		getNimbusViewRadioButton().addActionListener(new LAFListener());
		
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(getDefaultViewRadioButton());
		buttonGroup.add(getNimbusViewRadioButton());
		
		setViewMenu(new JMenu("View"));
		getViewMenu().setMnemonic(KeyEvent.VK_V);
		getViewMenu().add(getNimbusViewRadioButton());
		getViewMenu().add(getDefaultViewRadioButton());
	}
	
	/**
	 * Listener for Look And Feel options.
	 */
	private class LAFListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			String newLAF = ((JRadioButtonMenuItem) e.getSource()).getText();
			
			try {
				if (newLAF.equals("Nimbus")) {
					for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
	                    if ("Nimbus".equals(info.getName())) {
	                            UIManager.setLookAndFeel(info.getClassName());
	                            SwingUtilities.updateComponentTreeUI(MenuBar.this.getParent());
	                            break;
	                    }
	                }
				} 
				
				else if (newLAF.equals("OS Default")) {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					SwingUtilities.updateComponentTreeUI(MenuBar.this.getParent());
				}
			}
			
			catch (ClassNotFoundException ex) {
				ex.printStackTrace();
			} catch (InstantiationException ex) {
				ex.printStackTrace();
			} catch (IllegalAccessException ex) {
				ex.printStackTrace();
			} catch (UnsupportedLookAndFeelException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	private void buildLanguageMenu() {
		setEnglishRadioButton(new JRadioButtonMenuItem("English", true));
		
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(getEnglishRadioButton());
		
		setLanguageMenu(new JMenu("Language"));
		getLanguageMenu().setMnemonic(KeyEvent.VK_L);
		getLanguageMenu().add(getEnglishRadioButton());
	}
	
	private void buildHelpMenu() {
		setOnlineDocumentationOption(new JMenuItem("Documentation"));
		setSourceCodeOption(new JMenuItem("Source Code"));
		setAboutOption(new JMenuItem("About"));
		
		getOnlineDocumentationOption().addActionListener(new UrlListener());
		getSourceCodeOption().addActionListener(new UrlListener());
		
		setHelpMenu(new JMenu("Help"));
		getHelpMenu().setMnemonic(KeyEvent.VK_H);
		
		getHelpMenu().add(getOnlineDocumentationOption());
		getHelpMenu().add(getSourceCodeOption());
		getHelpMenu().add(new JSeparator());
		getHelpMenu().add(getAboutOption());
	}
	
	private class UrlListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (Desktop.isDesktopSupported()) {
				try {
					if (e.getSource() == getOnlineDocumentationOption()) {
						Desktop.getDesktop().browse(new URI(DOC_URL)); 
					}
					
					else if (e.getSource() == getSourceCodeOption()) {
						Desktop.getDesktop().browse(new URI(SOURCE_CODE_URL));
					}
				}
				 
				catch (IOException e1) {
					e1.printStackTrace();
				} catch (URISyntaxException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
	
	public void enableSavingOptions() {
		getSaveDatabase().setEnabled(true);
		getSaveDatabaseAs().setEnabled(true);
	}
	
	public JMenu getFileMenu() {
		return fileMenu;
	}

	public void setFileMenu(JMenu fileMenu) {
		this.fileMenu = fileMenu;
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

	public JMenu getHelpMenu() {
		return helpMenu;
	}

	public void setHelpMenu(JMenu helpMenu) {
		this.helpMenu = helpMenu;
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

	public JMenu getQueryMenu() {
		return editMenu;
	}

	public void setQueryMenu(JMenu queryMenu) {
		this.editMenu = queryMenu;
	}

	public JMenuItem getOpenDatabase() {
		return openDatabase;
	}

	public void setOpenDatabase(JMenuItem openDatabase) {
		this.openDatabase = openDatabase;
	}

	public JMenuItem getNewDatabase() {
		return newDatabase;
	}

	public void setNewDatabase(JMenuItem newDatabase) {
		this.newDatabase = newDatabase;
	}

	public JMenuItem getSaveDatabase() {
		return saveDatabase;
	}

	public void setSaveDatabase(JMenuItem saveDatabase) {
		this.saveDatabase = saveDatabase;
	}

	public JMenuItem getSaveDatabaseAs() {
		return saveDatabaseAs;
	}

	public void setSaveDatabaseAs(JMenuItem saveDatabaseAs) {
		this.saveDatabaseAs = saveDatabaseAs;
	}

	public JMenuItem getImportOption() {
		return importOption;
	}

	public void setImportOption(JMenuItem importOption) {
		this.importOption = importOption;
	}

	public JMenuItem getExportOption() {
		return exportOption;
	}

	public void setExportOption(JMenuItem exportOption) {
		this.exportOption = exportOption;
	}

	public JMenuItem getExitOption() {
		return exitOption;
	}

	public void setExitOption(JMenuItem exitOption) {
		this.exitOption = exitOption;
	}

	public JMenu getEditMenu() {
		return editMenu;
	}

	public void setEditMenu(JMenu editMenu) {
		this.editMenu = editMenu;
	}

	public JMenuItem getOnlineDocumentationOption() {
		return onlineDocumentationOption;
	}

	public void setOnlineDocumentationOption(JMenuItem onlineDocumentationOption) {
		this.onlineDocumentationOption = onlineDocumentationOption;
	}

	public JMenuItem getAboutOption() {
		return aboutOption;
	}

	public void setAboutOption(JMenuItem aboutOption) {
		this.aboutOption = aboutOption;
	}

	public JMenuItem getSourceCodeOption() {
		return sourceCodeOption;
	}

	public void setSourceCodeOption(JMenuItem sourceCodeOption) {
		this.sourceCodeOption = sourceCodeOption;
	}
}
