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
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSeparator;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

import es.ull.etsii.jitrax.gui.dialogs.FileDialog;

public class MenuBar extends JMenuBar {
	private static final long serialVersionUID = 1L;
	
	private static final String DOC_URL = "https://github.com/tteguayco/JITRAX#quick-start";
	private static final String SOURCE_CODE_URL = "https://github.com/tteguayco/JITRAX";
	
	private Workspace workspace;
	
	private JMenu fileMenu;
	private JMenu editMenu;
	private JMenu viewMenu;
	private JMenu languageMenu;
	private JMenu helpMenu;
	
	private JMenu importOption;
	private JMenu exportOption;
	
	private JMenuItem openDatabase;
	private JMenuItem newDatabase;
	private JMenuItem saveDatabase;
	private JMenuItem saveDatabaseAs;
	private JMenuItem importRelAlgQuery;
	private JMenuItem exportRelAlgQuery;
	private JMenuItem exportSqlQuery;
	private JMenuItem exitOption;
	
	private JMenuItem undoOption;
	private JMenuItem redoOption;
	private JMenuItem cutOption;
	private JMenuItem copyOption;
	private JMenuItem pasteOption;
	private JMenuItem deleteOption;
	private JMenuItem selectAllOption;
	
	private JCheckBoxMenuItem raCodeHighLighting;
	private JCheckBoxMenuItem sqlCodeHighLighting;
	private JCheckBoxMenuItem consoleShow;
	private JCheckBoxMenuItem dbViewerShow;
	private JCheckBoxMenuItem queriesListShow;
	
	private JMenuItem onlineDocumentationOption;
	private JMenuItem sourceCodeOption;
	private JMenuItem aboutOption;
	
	private JRadioButtonMenuItem englishRadioButton;
	
	public MenuBar(Workspace aWorkspace) {
		workspace = aWorkspace;
		
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
		
		importOption = new JMenu("Import");
		importRelAlgQuery = new JMenuItem("Relational Algebra Query");
		importOption.add(importRelAlgQuery);
		
		exportOption = new JMenu("Export");
		exportRelAlgQuery = new JMenuItem("Relational Algebra Query");
		exportSqlQuery = new JMenuItem("SQL Query");
		exportOption.add(exportRelAlgQuery);
		exportOption.add(exportSqlQuery);
		
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
		
		saveDatabase.setEnabled(false);
		saveDatabaseAs.setEnabled(false);
		importOption.setEnabled(false);
		exportOption.setEnabled(false);
	}
	
	private void buildEditMenu() {
		editMenu = new JMenu("Edit");
		editMenu.setMnemonic(KeyEvent.VK_E);
		
		undoOption = new JMenuItem("Undo");
		undoOption.setMnemonic(KeyEvent.VK_Z);
		redoOption = new JMenuItem("Redo");
		redoOption.setMnemonic(KeyEvent.VK_Y);
		cutOption = new JMenuItem("Cut");
		cutOption.setMnemonic(KeyEvent.VK_X);
		copyOption = new JMenuItem("Copy");
		copyOption.setMnemonic(KeyEvent.VK_C);
		pasteOption = new JMenuItem("Paste");
		pasteOption.setMnemonic(KeyEvent.VK_P);
		deleteOption = new JMenuItem("Delete");
		deleteOption.setMnemonic(KeyEvent.VK_DELETE);
		selectAllOption = new JMenuItem("Select All");
		selectAllOption.setMnemonic(KeyEvent.VK_A);
		
		getEditMenu().add(undoOption);
		getEditMenu().add(redoOption);
		getEditMenu().add(new JSeparator());
		getEditMenu().add(cutOption);
		getEditMenu().add(copyOption);
		getEditMenu().add(pasteOption);
		getEditMenu().add(deleteOption);
		getEditMenu().add(new JSeparator());
		getEditMenu().add(selectAllOption);
		
		undoOption.addActionListener(new UndoListener());
		redoOption.addActionListener(new RedoListener());
		cutOption.addActionListener(new CutListener());
		copyOption.addActionListener(new CopyListener());
		pasteOption.addActionListener(new PasteListener());
		deleteOption.addActionListener(new DeleteListener());
		selectAllOption.addActionListener(new SelectAllListener());
		
		undoOption.setEnabled(false);
		redoOption.setEnabled(false);
		cutOption.setEnabled(false);
		copyOption.setEnabled(false);
		pasteOption.setEnabled(false);
		deleteOption.setEnabled(false);
		selectAllOption.setEnabled(false);
	}
	
	private void buildViewMenu() {
		
		ButtonGroup buttonGroup = new ButtonGroup();
		
		JMenu codeHMenu = new JMenu("Code highlighting");
		raCodeHighLighting = new JCheckBoxMenuItem("Relational Algebra", true);
		sqlCodeHighLighting = new JCheckBoxMenuItem("SQL", true);
		
		codeHMenu.add(raCodeHighLighting);
		codeHMenu.add(sqlCodeHighLighting);
		
		JMenu showMenu = new JMenu("Show");
		consoleShow = new JCheckBoxMenuItem("Console", true);
		dbViewerShow = new JCheckBoxMenuItem("DB Viewer", true);
		queriesListShow = new JCheckBoxMenuItem("Query List", true);
		
		showMenu.add(dbViewerShow);
		showMenu.add(queriesListShow);
		showMenu.add(consoleShow);
		
		setViewMenu(new JMenu("View"));
		getViewMenu().setMnemonic(KeyEvent.VK_V);
		getViewMenu().add(codeHMenu);
		getViewMenu().add(showMenu);
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
		
		getOnlineDocumentationOption().addActionListener(new HelpOptionListener());
		getSourceCodeOption().addActionListener(new HelpOptionListener());
		getAboutOption().addActionListener(new HelpOptionListener());
		
		setHelpMenu(new JMenu("Help"));
		getHelpMenu().setMnemonic(KeyEvent.VK_H);
		
		getHelpMenu().add(getOnlineDocumentationOption());
		getHelpMenu().add(getSourceCodeOption());
		getHelpMenu().add(new JSeparator());
		getHelpMenu().add(getAboutOption());
	}
	
	private class HelpOptionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (Desktop.isDesktopSupported()) {
				try {
					if (e.getSource() == getOnlineDocumentationOption()) {
						Desktop.getDesktop().browse(new URI(DOC_URL)); 
					}
					
					else if (e.getSource() == getSourceCodeOption()) {
						Desktop.getDesktop().browse(new URI(SOURCE_CODE_URL));
					}
					
					else if (e.getSource() == getAboutOption()) {
						// TODO display about dialog
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
	
	private class UndoListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			getWorkspace().getRelationalAlgebraCodeEditor().undoLastAction();;
		}
	}
	
	private class RedoListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			getWorkspace().getRelationalAlgebraCodeEditor().redoLastAction();
		}
	}
	
	private class CutListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			getWorkspace().getRelationalAlgebraCodeEditor().cut();
		}
	}
	
	private class CopyListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			getWorkspace().getRelationalAlgebraCodeEditor().copy();
		}
	}
	
	private class PasteListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			getWorkspace().getRelationalAlgebraCodeEditor().paste();
		}
	}
	
	private class DeleteListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			//getWorkspace().getRelationalAlgebraCodeEditor().dele();
		}
	}
	
	private class SelectAllListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			getWorkspace().getRelationalAlgebraCodeEditor().selectAll();
		}
	}
	
	public void enableDisabledOptions() {
		getSaveDatabase().setEnabled(true);
		getSaveDatabaseAs().setEnabled(true);
		getImportOption().setEnabled(true);
		getExportOption().setEnabled(true);
		
		getUndoOption().setEnabled(true);
		getRedoOption().setEnabled(true);
		getCutOption().setEnabled(true);
		getCopyOption().setEnabled(true);
		getPasteOption().setEnabled(true);
		getDeleteOption().setEnabled(true);
		getSelectAllOption().setEnabled(true);
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

	public JMenuItem getExportOption() {
		return exportOption;
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

	public JMenuItem getImportRelAlgQuery() {
		return importRelAlgQuery;
	}

	public void setImportRelAlgQuery(JMenuItem importRelAlgQuery) {
		this.importRelAlgQuery = importRelAlgQuery;
	}

	public void setImportOption(JMenu importOption) {
		this.importOption = importOption;
	}

	public void setExportOption(JMenu exportOption) {
		this.exportOption = exportOption;
	}

	public JMenuItem getExportRelAlgQuery() {
		return exportRelAlgQuery;
	}

	public void setExportRelAlgQuery(JMenuItem exportRelAlgQuery) {
		this.exportRelAlgQuery = exportRelAlgQuery;
	}

	public JMenuItem getExportSqlQuery() {
		return exportSqlQuery;
	}

	public void setExportSqlQuery(JMenuItem exportSqlQuery) {
		this.exportSqlQuery = exportSqlQuery;
	}

	public JCheckBoxMenuItem getRaCodeHighLighting() {
		return raCodeHighLighting;
	}

	public void setRaCodeHighLighting(JCheckBoxMenuItem raCodeHighLighting) {
		this.raCodeHighLighting = raCodeHighLighting;
	}

	public JCheckBoxMenuItem getSqlCodeHighLighting() {
		return sqlCodeHighLighting;
	}

	public void setSqlCodeHighLighting(JCheckBoxMenuItem sqlCodeHighLighting) {
		this.sqlCodeHighLighting = sqlCodeHighLighting;
	}

	public JCheckBoxMenuItem getConsoleShow() {
		return consoleShow;
	}

	public void setConsoleShow(JCheckBoxMenuItem consoleShow) {
		this.consoleShow = consoleShow;
	}

	public JCheckBoxMenuItem getDbViewerShow() {
		return dbViewerShow;
	}

	public void setDbViewerShow(JCheckBoxMenuItem dbViewerShow) {
		this.dbViewerShow = dbViewerShow;
	}

	public JCheckBoxMenuItem getQueriesListShow() {
		return queriesListShow;
	}

	public void setQueriesListShow(JCheckBoxMenuItem queriesListShow) {
		this.queriesListShow = queriesListShow;
	}

	public Workspace getWorkspace() {
		return workspace;
	}

	public void setWorkspace(Workspace workspace) {
		this.workspace = workspace;
	}

	public JMenuItem getUndoOption() {
		return undoOption;
	}

	public void setUndoOption(JMenuItem undoOption) {
		this.undoOption = undoOption;
	}

	public JMenuItem getRedoOption() {
		return redoOption;
	}

	public void setRedoOption(JMenuItem redoOption) {
		this.redoOption = redoOption;
	}

	public JMenuItem getCutOption() {
		return cutOption;
	}

	public void setCutOption(JMenuItem cutOption) {
		this.cutOption = cutOption;
	}

	public JMenuItem getCopyOption() {
		return copyOption;
	}

	public void setCopyOption(JMenuItem copyOption) {
		this.copyOption = copyOption;
	}

	public JMenuItem getPasteOption() {
		return pasteOption;
	}

	public void setPasteOption(JMenuItem pasteOption) {
		this.pasteOption = pasteOption;
	}

	public JMenuItem getDeleteOption() {
		return deleteOption;
	}

	public void setDeleteOption(JMenuItem deleteOption) {
		this.deleteOption = deleteOption;
	}

	public JMenuItem getSelectAllOption() {
		return selectAllOption;
	}

	public void setSelectAllOption(JMenuItem selectAllOption) {
		this.selectAllOption = selectAllOption;
	}
}
