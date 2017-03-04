package es.ull.etsii.jitrax.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.fife.ui.rsyntaxtextarea.AbstractTokenMakerFactory;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rsyntaxtextarea.TokenMakerFactory;
import org.fife.ui.rtextarea.RTextScrollPane;

public class Workspace extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private static final String[] FONT_STYLES = { "Plain", "Bold", "Italic" };
	private static final int[] FONT_STYLES_CONSTANTS = { Font.PLAIN, Font.BOLD, Font.ITALIC };
	
	private static final String PANEL_TITLE = "Workspace";
	private static final String RA_SYNTAX_STYLE_ID = "text/RelationalAlgebra";
	private static final String TOKEN_MAKER_LOCATION =
			"es.ull.etsii.jitrax.tokenMaker.RelationalAlgebraTokenMaker";
	
	private static final Color RA_CARET_COLOR = Color.BLACK;
	private static final Color SQL_CARET_COLOR = Color.BLACK;
	private static final Color PANEL_BORDER_COLOR = Color.GRAY;
	
	private static final int DEFAULT_RA_FONT_SIZE = 16;
	private static final int DEFAULT_RA_FONT_STYLE = Font.PLAIN;
	private static final int DEFAULT_SQL_FONT_SIZE = 16;
	private static final int DEFAULT_SQL_FONT_STYLE = Font.PLAIN;
	private static final int MIN_FONT_SIZE = 11;
	private static final int MAX_FONT_SIZE = 24;
	private static final int SPINNER_STEP = 1;
	
	private static final int BUTTON_MARGIN_TOP = 2;
	private static final int BUTTON_MARGIN_LEFT = 4;
	private static final int BUTTON_MARGIN_BOTTOM = 2;
	private static final int BUTTON_MARGIN_RIGHT = 4;
	
	private static final int SQL_TAB_INDEX = 1;
	private static final int PARSE_TREE_TAB_INDEX = 2;
	private static final int QUERY_RESULT_TAB_INDEX = 3;
	
	private RSyntaxTextArea relationalAlgebraCodeEditor;
	private RSyntaxTextArea sqlCodeEditor;
	
	private JComboBox<String> raFontStyles;
	private JComboBox<String> sqlFontStyles;
	private JSpinner raFontSizeSelector;
	private JSpinner sqlFontSizeSelector;
	private SpinnerModel raFontSizeModel;
	private SpinnerModel sqlFontSizeModel;
	
	private JTabbedPane tabbedPane = new JTabbedPane();
	private JButton translateButton;
	private JButton executeButton;
	
	public Workspace() {
		relationalAlgebraCodeEditor = new RSyntaxTextArea();
		sqlCodeEditor = new RSyntaxTextArea();
		translateButton = new JButton("Translate to SQL");
		executeButton = new JButton("Execute on DBMS");
		
		relationalAlgebraCodeEditor.setCaretColor(RA_CARET_COLOR);
		String raCurrentFontName = relationalAlgebraCodeEditor.getFont().getName();
		relationalAlgebraCodeEditor.setFont(new Font(raCurrentFontName, 
													DEFAULT_RA_FONT_STYLE, 
													DEFAULT_RA_FONT_SIZE));
		
		String sqlCurrentFontName = sqlCodeEditor.getFont().getName();
		sqlCodeEditor.setFont(new Font(sqlCurrentFontName, 
				DEFAULT_RA_FONT_STYLE, 
				DEFAULT_RA_FONT_SIZE));
		sqlCodeEditor.setCaretColor(SQL_CARET_COLOR);
		sqlCodeEditor.setEditable(false);
		
		// Buttons
		translateButton.setMargin(new Insets(BUTTON_MARGIN_TOP, 
				BUTTON_MARGIN_LEFT, 
				BUTTON_MARGIN_BOTTOM, 
				BUTTON_MARGIN_RIGHT));
		executeButton.setMargin(new Insets(BUTTON_MARGIN_TOP, 
				BUTTON_MARGIN_LEFT, 
				BUTTON_MARGIN_BOTTOM, 
				BUTTON_MARGIN_RIGHT));
		
		// Enable code highlighting
		setSyntaxHighlightingForRelationalAlgebra();
		setSyntaxHighlightingForSQL();
		
		RTextScrollPane relationalAlgebraSP = new RTextScrollPane(relationalAlgebraCodeEditor);
	    RTextScrollPane sqlSP = new RTextScrollPane(sqlCodeEditor);
	    
	    // Show line numbers
	    relationalAlgebraSP.setLineNumbersEnabled(true);
	    sqlSP.setLineNumbersEnabled(true);
	    
	    // RA Code Editor parameters
	    int raCodeEditorFontSize = relationalAlgebraCodeEditor.getFont().getSize();
	    raFontStyles = new JComboBox<String>(FONT_STYLES);
		raFontSizeModel = new SpinnerNumberModel(raCodeEditorFontSize, 
				MIN_FONT_SIZE, 
				MAX_FONT_SIZE, 
				SPINNER_STEP);
		raFontSizeSelector = new JSpinner(raFontSizeModel);
	    
		// SQL Code Editor parameters
		int sqlCodeEditorFontSize = sqlCodeEditor.getFont().getSize();
		sqlFontStyles = new JComboBox<String>(FONT_STYLES);
		sqlFontSizeModel = new SpinnerNumberModel(sqlCodeEditorFontSize, 
				MIN_FONT_SIZE, 
				MAX_FONT_SIZE, 
				SPINNER_STEP); 
		sqlFontSizeSelector = new JSpinner(sqlFontSizeModel);
		
	    // Relational Algebra Tab
	    JPanel raPanel = new JPanel(new BorderLayout());
	    JPanel raControlPanel = new JPanel(new BorderLayout());
	    JPanel translationPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
	    JPanel raEditorElementsPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
	    raPanel.add(relationalAlgebraSP, BorderLayout.CENTER);
	    raPanel.add(raControlPanel, BorderLayout.SOUTH);
	    translationPanel.add(translateButton);
	    raControlPanel.add(translationPanel, BorderLayout.WEST);
	    raControlPanel.add(raEditorElementsPanel, BorderLayout.EAST);
	    raEditorElementsPanel.add(new JLabel("Style: "));
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
	    sqlControlPanel.add(executionPanel, BorderLayout.WEST);
	    sqlControlPanel.add(sqlEditorElementsPanel);
	    sqlEditorElementsPanel.add(new JLabel("Style: "));
	    sqlEditorElementsPanel.add(sqlFontStyles);
	    sqlEditorElementsPanel.add(new JLabel("Size: "));
	    sqlEditorElementsPanel.add(sqlFontSizeSelector);
	    
		setLayout(new BorderLayout());
		tabbedPane = new JTabbedPane();
		tabbedPane.add("Relational Algebra", raPanel);
		tabbedPane.addTab("SQL", sqlPanel);
		tabbedPane.addTab("Parse Tree", new JPanel());
		tabbedPane.addTab("Query Result", new JPanel());
		tabbedPane.setFocusable(false);
		tabbedPane.setEnabledAt(SQL_TAB_INDEX, false);
		tabbedPane.setEnabledAt(PARSE_TREE_TAB_INDEX, false);
		tabbedPane.setEnabledAt(QUERY_RESULT_TAB_INDEX, false);
		add(tabbedPane, BorderLayout.CENTER);
		
		setListeners();
		
		LineBorder lineBorderPanel = (LineBorder) BorderFactory.createLineBorder(PANEL_BORDER_COLOR);
		setBorder(BorderFactory.createTitledBorder(lineBorderPanel, PANEL_TITLE));
	}
	
	public void enableSqlTab() {
		tabbedPane.setEnabledAt(SQL_TAB_INDEX, true);
	}
	
	public void enableParseTreeTab() {
		tabbedPane.setEnabledAt(PARSE_TREE_TAB_INDEX, true);
	}
	
	public void enableResultTab() {
		tabbedPane.setEnabledAt(QUERY_RESULT_TAB_INDEX, true);
	}
	
	public void switchToSqlTab() {
		tabbedPane.setSelectedIndex(SQL_TAB_INDEX);
	}
	
	public void switchToParseTreeTab() {
		tabbedPane.setSelectedIndex(PARSE_TREE_TAB_INDEX);
	}
	
	public void switchToQueryResultTab() {
		tabbedPane.setSelectedIndex(QUERY_RESULT_TAB_INDEX);
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
	
	private void setListeners() {
		
		raFontSizeSelector.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				float newSize = (int) raFontSizeSelector.getValue();
				Font currentFont = relationalAlgebraCodeEditor.getFont();
				relationalAlgebraCodeEditor.setFont(currentFont.deriveFont(newSize));
			}
		});
		
		sqlFontSizeSelector.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				float newSize = (int) sqlFontSizeSelector.getValue();
				Font currentFont = sqlCodeEditor.getFont();
				sqlCodeEditor.setFont(currentFont.deriveFont(newSize));
			}
		});
		
		raFontStyles.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int styleIndex = raFontStyles.getSelectedIndex();
				Font currentFont = relationalAlgebraCodeEditor.getFont();
				int[] styleFonts = getFontStylesConstants();
				relationalAlgebraCodeEditor.setFont(currentFont.deriveFont(styleFonts[styleIndex]));
			}
		});
		
		sqlFontStyles.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int styleIndex = sqlFontStyles.getSelectedIndex();
				Font currentFont = sqlCodeEditor.getFont();
				int[] styleFonts = getFontStylesConstants();
				sqlCodeEditor.setFont(currentFont.deriveFont(styleFonts[styleIndex]));
			}
		});
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

	public RSyntaxTextArea getSqlCodeEditor() {
		return sqlCodeEditor;
	}

	public void setSqlCodeEditor(RSyntaxTextArea sqlCodeEditor) {
		this.sqlCodeEditor = sqlCodeEditor;
	}

	public JComboBox<String> getRaFontStyles() {
		return raFontStyles;
	}

	public void setRaFontStyles(JComboBox<String> raFontStyles) {
		this.raFontStyles = raFontStyles;
	}

	public JComboBox<String> getSqlFontStyles() {
		return sqlFontStyles;
	}

	public void setSqlFontStyles(JComboBox<String> sqlFontStyles) {
		this.sqlFontStyles = sqlFontStyles;
	}

	public JSpinner getRaFontSizeSelector() {
		return raFontSizeSelector;
	}

	public void setRaFontSizeSelector(JSpinner raFontSizeSelector) {
		this.raFontSizeSelector = raFontSizeSelector;
	}

	public JSpinner getSqlFontSizeSelector() {
		return sqlFontSizeSelector;
	}

	public void setSqlFontSizeSelector(JSpinner sqlFontSizeSelector) {
		this.sqlFontSizeSelector = sqlFontSizeSelector;
	}

	public SpinnerModel getRaFontSizeModel() {
		return raFontSizeModel;
	}

	public void setRaFontSizeModel(SpinnerModel raFontSizeModel) {
		this.raFontSizeModel = raFontSizeModel;
	}

	public SpinnerModel getSqlFontSizeModel() {
		return sqlFontSizeModel;
	}

	public void setSqlFontSizeModel(SpinnerModel sqlFontSizeModel) {
		this.sqlFontSizeModel = sqlFontSizeModel;
	}

	public JTabbedPane getTabbedPane() {
		return tabbedPane;
	}

	public void setTabbedPane(JTabbedPane tabbedPane) {
		this.tabbedPane = tabbedPane;
	}

	public JButton getTranslateButton() {
		return translateButton;
	}

	public void setTranslateButton(JButton translateButton) {
		this.translateButton = translateButton;
	}

	public JButton getExecuteButton() {
		return executeButton;
	}

	public void setExecuteButton(JButton executeButton) {
		this.executeButton = executeButton;
	}

	public static String[] getFontStyles() {
		return FONT_STYLES;
	}

	public static int[] getFontStylesConstants() {
		return FONT_STYLES_CONSTANTS;
	}
}