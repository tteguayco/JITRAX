package es.ull.etsii.jitrax.gui.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.LineBorder;

import org.fife.ui.rsyntaxtextarea.AbstractTokenMakerFactory;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rsyntaxtextarea.TokenMakerFactory;
import org.fife.ui.rtextarea.RTextScrollPane;

public class CodeEditorPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private static final String[] FONT_STYLES = { "Plain", "Arial", "Verdana"};
	private static final String[] SGBD_LIST = { "PostgreSQL" };
	
	private static final String PANEL_TITLE = "Editor";
	private static final String RA_SYNTAX_STYLE_ID = "text/RelationalAlgebra";
	private static final String TOKEN_MAKER_LOCATION =
			"es.ull.etsii.jitrax.codeEditor.RelationalAlgebraTokenMaker";
	
	private static final Color RA_CARET_COLOR = Color.BLACK;
	private static final Color SQL_CARET_COLOR = Color.BLACK;
	private static final Color PANEL_BORDER_COLOR = Color.GRAY;
	
	private static final int DEFAULT_FONT_SIZE = 16;
	private static final int DEFAULT_FONT_STYLE = Font.PLAIN;
	private static final int MIN_FONT_SIZE = 6;
	private static final int MAX_FONT_SIZE = 18;
	private static final int SPINNER_STEP = 1;
	
	private RSyntaxTextArea relationalAlgebraCodeEditor;
	private RSyntaxTextArea sqlCodeEditor;
	
	private JComboBox raFontStyles;
	private JComboBox sqlFontStyles;
	private JComboBox sgbdList;
	private JSpinner raFontSizeSelector;
	private JSpinner sqlFontSizeSelector;
	private SpinnerModel raFontSizeModel;
	private SpinnerModel sqlFontSizeModel;
	
	private JTabbedPane tabbedPane = new JTabbedPane();
	private JButton translateButton;
	private JButton executeButton;
	
	public CodeEditorPanel() {
		relationalAlgebraCodeEditor = new RSyntaxTextArea();
		sqlCodeEditor = new RSyntaxTextArea();
		translateButton = new JButton("Translate to SQL");
		executeButton = new JButton("Execute on");
		
		relationalAlgebraCodeEditor.setCaretColor(RA_CARET_COLOR);
		String currentFontName = relationalAlgebraCodeEditor.getFont().getName();
		relationalAlgebraCodeEditor.setFont(new Font(currentFontName, 
													DEFAULT_FONT_STYLE, 
													DEFAULT_FONT_SIZE));
		
		sqlCodeEditor.setCaretColor(SQL_CARET_COLOR);
		sqlCodeEditor.setEditable(false);
		
		setSyntaxHighlightingForRelationalAlgebra();
		setSyntaxHighlightingForSQL();
		
		RTextScrollPane relationalAlgebraSP = new RTextScrollPane(relationalAlgebraCodeEditor);
	    RTextScrollPane sqlSP = new RTextScrollPane(sqlCodeEditor);
		
	    // RA Code Editor parameters
	    int raCodeEditorFontSize = relationalAlgebraCodeEditor.getFont().getSize();
	    int raCodeEditorFontStyle = relationalAlgebraCodeEditor.getFont().getStyle();
	    raFontStyles = new JComboBox(FONT_STYLES);
		raFontSizeModel = new SpinnerNumberModel(raCodeEditorFontSize, 
				MIN_FONT_SIZE, 
				MAX_FONT_SIZE, 
				SPINNER_STEP);
		raFontSizeSelector = new JSpinner(raFontSizeModel);
	    
		// SQL Code Editor parameters
		int sqlCodeEditorFontSize = sqlCodeEditor.getFont().getSize();
		int sqlCodeEditorFontStyle = sqlCodeEditor.getFont().getSize();
		sqlFontStyles = new JComboBox(FONT_STYLES);
		sqlFontSizeModel = new SpinnerNumberModel(sqlCodeEditorFontSize, 
				MIN_FONT_SIZE, 
				MAX_FONT_SIZE, 
				SPINNER_STEP); 
		sqlFontSizeSelector = new JSpinner(sqlFontSizeModel);
		sgbdList = new JComboBox(SGBD_LIST);
		
	    // Relational Algebra Tab
	    JPanel raPanel = new JPanel(new BorderLayout());
	    JPanel raControlPanel = new JPanel(new BorderLayout());
	    JPanel translationPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
	    JPanel raEditorElementsPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
	    raPanel.add(relationalAlgebraSP, BorderLayout.CENTER);
	    raPanel.add(raControlPanel, BorderLayout.SOUTH);
	    translationPanel.add(translateButton);
	    raControlPanel.add(translationPanel, BorderLayout.WEST);
	    raControlPanel.add(raEditorElementsPanel);
	    raEditorElementsPanel.add(new JLabel("Font: "));
	    raEditorElementsPanel.add(raFontStyles);
	    raEditorElementsPanel.add(new JLabel("Size: "));
	    raEditorElementsPanel.add(raFontSizeSelector);
	    
	    // SQL Tab
	    JPanel sqlPanel = new JPanel(new BorderLayout());
	    JPanel sqlControlPanel = new JPanel(new BorderLayout());
	    JPanel executionPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
	    JPanel sqlEditorElementsPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
	    sqlPanel.add(sqlSP, BorderLayout.CENTER);
	    sqlPanel.add(sqlControlPanel, BorderLayout.SOUTH);
	    executionPanel.add(executeButton);
	    executionPanel.add(sgbdList);
	    sqlControlPanel.add(executionPanel, BorderLayout.WEST);
	    sqlControlPanel.add(sqlEditorElementsPanel);
	    sqlEditorElementsPanel.add(new JLabel("Font: "));
	    sqlEditorElementsPanel.add(sqlFontStyles);
	    sqlEditorElementsPanel.add(new JLabel("Size: "));
	    sqlEditorElementsPanel.add(sqlFontSizeSelector);
	    
		setLayout(new BorderLayout());
		tabbedPane = new JTabbedPane();
		tabbedPane.add("Relational Algebra", raPanel);
		tabbedPane.addTab("SQL", sqlPanel);
		tabbedPane.addTab("Parse Tree", new JPanel());
		tabbedPane.setFocusable(false);
		add(tabbedPane, BorderLayout.CENTER);
		
		LineBorder lineBorderPanel = (LineBorder) BorderFactory.createLineBorder(PANEL_BORDER_COLOR);
		setBorder(BorderFactory.createTitledBorder(lineBorderPanel, PANEL_TITLE));
	}
	
	/**
	 * Tells the RSyntaxTextArea instance what TokerMaker it has
	 * to use in order to recognize the Relational Algebra language.
	 */
	private void setSyntaxHighlightingForRelationalAlgebra() {
		AbstractTokenMakerFactory atmf = 
				(AbstractTokenMakerFactory)TokenMakerFactory.getDefaultInstance();
	    atmf.putMapping(RA_SYNTAX_STYLE_ID, TOKEN_MAKER_LOCATION);
	    getRelationalAlgebraCodeEditor().setSyntaxEditingStyle(RA_SYNTAX_STYLE_ID);
	}
	
	/**
	 * Set syntax highlighting for SQL. RSyntaxTextArea already
	 * includes SQL support.
	 */
	private void setSyntaxHighlightingForSQL() {
		getSQLCodeEditor().setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_SQL);
	}

	public RSyntaxTextArea getRelationalAlgebraCodeEditor() {
		return relationalAlgebraCodeEditor;
	}

	public void setRelationalAlgebraCodeEditor(RSyntaxTextArea relationalAlgebraCodeEditor) {
		this.relationalAlgebraCodeEditor = relationalAlgebraCodeEditor;
	}

	public RSyntaxTextArea getSQLCodeEditor() {
		return sqlCodeEditor;
	}

	public void setSQLCodeEditor(RSyntaxTextArea sQLCodeEditor) {
		sqlCodeEditor = sQLCodeEditor;
	}
}