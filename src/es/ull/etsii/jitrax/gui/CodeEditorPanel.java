package es.ull.etsii.jitrax.gui;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.LineBorder;

import org.fife.ui.rsyntaxtextarea.AbstractTokenMakerFactory;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rsyntaxtextarea.TokenMakerFactory;
import org.fife.ui.rtextarea.RTextScrollPane;

public class CodeEditorPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private static final String PANEL_TITLE = "Editor";
	private static final String RA_SYNTAX_STYLE_ID = "text/RelationalAlgebra";
	private static final String TOKEN_MAKER_LOCATION =
			"es.ull.etsii.jitrax.codeEditor.RelationalAlgebraTokenMaker";
	
	private static final Color RA_CARET_COLOR = Color.BLACK;
	private static final Color SQL_CARET_COLOR = Color.BLACK;
	private static final Color PANEL_BORDER_COLOR = Color.BLACK;
	
	private RSyntaxTextArea relationalAlgebraCodeEditor;
	private RSyntaxTextArea sqlCodeEditor;
	
	private JTabbedPane tabbedPane = new JTabbedPane();
	private JButton translateButton;
	private JButton executeButton;
	
	public CodeEditorPanel() {
		relationalAlgebraCodeEditor = new RSyntaxTextArea();
		sqlCodeEditor = new RSyntaxTextArea();
		translateButton = new JButton("Translate to SQL");
		executeButton = new JButton("Execute on Postgre");
		
		relationalAlgebraCodeEditor.setCaretColor(RA_CARET_COLOR);
		sqlCodeEditor.setCaretColor(SQL_CARET_COLOR);
		sqlCodeEditor.setEditable(false);
		
		setSyntaxHighlightingForRelationalAlgebra();
		setSyntaxHighlightingForSQL();
		
		RTextScrollPane relationalAlgebraSP = new RTextScrollPane(relationalAlgebraCodeEditor);
	    RTextScrollPane sqlSP = new RTextScrollPane(sqlCodeEditor);
		
		setLayout(new BorderLayout());
		tabbedPane = new JTabbedPane();
		tabbedPane.add("Relational Algebra", relationalAlgebraSP);
		tabbedPane.addTab("SQL", sqlSP);
		add(tabbedPane, BorderLayout.CENTER);
		
		JPanel controlPanel = new JPanel();
		controlPanel.add(translateButton);
		controlPanel.add(executeButton);
		
		add(controlPanel, BorderLayout.SOUTH);
		
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