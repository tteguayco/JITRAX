package es.ull.etsii.jitrax.gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSeparator;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

public class MenuBar extends JMenuBar {
	private static final long serialVersionUID = 1L;
	
	private JMenu fileMenu;
	private JMenu editMenu;
	private JMenu viewMenu;
	private JMenu languageMenu;
	private JMenu helpMenu;
	
	private JRadioButtonMenuItem defaultViewRadioButton;
	private JRadioButtonMenuItem nimbusViewRadioButton;
	private JRadioButtonMenuItem metalViewRadioButton;
	
	private JMenuItem openDatabase;
	private JMenuItem newDatabase;
	private JMenuItem saveDatabase;
	private JMenuItem saveDatabaseAs;
	private JMenuItem importOption;
	private JMenuItem exportOption;
	private JMenuItem exitOption;
	
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
		setListeners();
	}
	
	private void buildFileMenu() {
		setFileMenu(new JMenu("File"));
		fileMenu.setMnemonic(KeyEvent.VK_F);
		
		openDatabase = new JMenuItem("Open");
		openDatabase.setMnemonic(KeyEvent.VK_O);
		
		newDatabase = new JMenuItem("New");
		newDatabase.setMnemonic(KeyEvent.VK_N);
		
		saveDatabase = new JMenuItem("Save");
		saveDatabase.setMnemonic(KeyEvent.VK_S);
		
		saveDatabaseAs = new JMenuItem("Save as...");
		
		importOption = new JMenuItem("Import");
		exportOption = new JMenuItem("Export");
		
		exitOption = new JMenuItem("Exit");
		
		getFileMenu().add(openDatabase);
		getFileMenu().add(newDatabase);
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
		setDefaultViewRadioButton(new JRadioButtonMenuItem("OS Default", true));
		setNimbusViewRadioButton(new JRadioButtonMenuItem("Nimbus", true));
		setMetalViewRadioButton(new JRadioButtonMenuItem("Metal", true));
		
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(getDefaultViewRadioButton());
		buttonGroup.add(getNimbusViewRadioButton());
		buttonGroup.add(getMetalViewRadioButton());
		
		setViewMenu(new JMenu("View"));
		getViewMenu().setMnemonic(KeyEvent.VK_V);
		getViewMenu().add(getDefaultViewRadioButton());
		getViewMenu().add(getNimbusViewRadioButton());
		getViewMenu().add(getMetalViewRadioButton());
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
		setHelpMenu(new JMenu("Help"));
		getHelpMenu().setMnemonic(KeyEvent.VK_H);
	}

	private void setListeners() {
		// DEFAULT OS LOOKN' FEEL
		getDefaultViewRadioButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					SwingUtilities.updateComponentTreeUI(MenuBar.this.getParent());
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (InstantiationException e1) {
					e1.printStackTrace();
				} catch (IllegalAccessException e1) {
					e1.printStackTrace();
				} catch (UnsupportedLookAndFeelException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		// NIMBUS LOOK AND FEEL
		getNimbusViewRadioButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
                    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                        if ("Nimbus".equals(info.getName())) {
                                UIManager.setLookAndFeel(info.getClassName());
                                SwingUtilities.updateComponentTreeUI(MenuBar.this.getParent());
                                break;
                        }
                    }
                 } catch (Exception exc) {
                	 exc.printStackTrace();
                 }
			}	
		});
		
		// METAL LOOK AND FEEL
		getMetalViewRadioButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
                    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                        if ("Metal".equals(info.getName())) {
                                UIManager.setLookAndFeel(info.getClassName());
                                SwingUtilities.updateComponentTreeUI(MenuBar.this.getParent());
                                break;
                        }
                    }
                 } catch (Exception exc) {
                	 exc.printStackTrace();
                 }
			}	
		});
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

	public JRadioButtonMenuItem getMetalViewRadioButton() {
		return metalViewRadioButton;
	}

	public void setMetalViewRadioButton(JRadioButtonMenuItem metalViewRadioButton) {
		this.metalViewRadioButton = metalViewRadioButton;
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
}
