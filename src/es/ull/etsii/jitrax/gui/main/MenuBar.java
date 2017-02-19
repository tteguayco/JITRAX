package es.ull.etsii.jitrax.gui.main;

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
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

public class MenuBar extends JMenuBar {
	private static final long serialVersionUID = 1L;
	
	private JMenu fileMenu;
	private JMenu databaseMenu;
	private JMenu viewMenu;
	private JMenu languageMenu;
	private JMenu aboutMenu;
	
	private JRadioButtonMenuItem defaultViewRadioButton;
	private JRadioButtonMenuItem nimbusViewRadioButton;
	private JRadioButtonMenuItem metalViewRadioButton;
	
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
		setListeners();
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
		setDefaultViewRadioButton(new JRadioButtonMenuItem("OS Default", true));
		setNimbusViewRadioButton(new JRadioButtonMenuItem("Nimbus", true));
		setMetalViewRadioButton(new JRadioButtonMenuItem("Metal", true));
		
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(getDefaultViewRadioButton());
		buttonGroup.add(getNimbusViewRadioButton());
		buttonGroup.add(getMetalViewRadioButton());
		
		setViewMenu(new JMenu("View"));
		getViewMenu().add(getDefaultViewRadioButton());
		getViewMenu().add(getNimbusViewRadioButton());
		getViewMenu().add(getMetalViewRadioButton());
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

	public JRadioButtonMenuItem getMetalViewRadioButton() {
		return metalViewRadioButton;
	}

	public void setMetalViewRadioButton(JRadioButtonMenuItem metalViewRadioButton) {
		this.metalViewRadioButton = metalViewRadioButton;
	}
}
