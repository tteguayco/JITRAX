package es.ull.etsii.jitrax.gui;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
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
	
	private static final String RA_SYNTAX_STYLE_ID = "text/RelationalAlgebra";
	private static final String TOKEN_MAKER_LOCATION =
			"es.ull.etsii.jitrax.codeEditor.RelationalAlgebraTokenMaker";
	
	private RSyntaxTextArea relationalAlgebraCodeEditor;
	private RSyntaxTextArea sqlCodeEditor;
	
	private JTabbedPane tabbedPane = new JTabbedPane();
	
	public CodeEditorPanel() {
		relationalAlgebraCodeEditor = new RSyntaxTextArea();
		sqlCodeEditor = new RSyntaxTextArea();
		
		tabbedPane = new JTabbedPane();
		
		setLayout(new BorderLayout());
		RTextScrollPane relationalAlgebraSP = new RTextScrollPane(relationalAlgebraCodeEditor);
	    RTextScrollPane sqlSP = new RTextScrollPane(sqlCodeEditor);
		
		add(tabbedPane);
		tabbedPane.add("Relational Algebra", relationalAlgebraSP);
		tabbedPane.addTab("SQL", sqlSP);
	    sqlCodeEditor.setEditable(false);
		
		setSyntaxHighlightingForRelationalAlgebra();
		setSyntaxHighlightingForSQL();
		
		LineBorder lineBorderPanel = (LineBorder) BorderFactory.createLineBorder(Color.BLACK);
		setBorder(BorderFactory.createTitledBorder(lineBorderPanel, "Editor"));
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
		relationalAlgebraCodeEditor = relationalAlgebraCodeEditor;
	}

	public RSyntaxTextArea getSQLCodeEditor() {
		return sqlCodeEditor;
	}

	public void setSQLCodeEditor(RSyntaxTextArea sQLCodeEditor) {
		sqlCodeEditor = sQLCodeEditor;
	}
}