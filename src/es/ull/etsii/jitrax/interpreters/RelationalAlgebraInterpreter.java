package es.ull.etsii.jitrax.interpreters;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import es.ull.etsii.jitrax.adt.Database;
import es.ull.etsii.jitrax.analysis.CustomErrorListener;
import es.ull.etsii.jitrax.analysis.dsl.DatabaseEvalVisitor;
import es.ull.etsii.jitrax.analysis.ra.RelationalAlgebraEvalVisitor;
import es.ull.etsii.jitrax.analysis.ra.RelationalAlgebraLexer;
import es.ull.etsii.jitrax.analysis.ra.RelationalAlgebraParser;
import es.ull.etsii.jitrax.gui.Console;

public class RelationalAlgebraInterpreter {
	
	private ANTLRInputStream input;
	private ParseTree tree;
	
	private RelationalAlgebraLexer lexer;
	private CommonTokenStream tokens;
	private RelationalAlgebraParser parser;
	private RelationalAlgebraEvalVisitor eval;
	
	private Database database;
	private String sqlTranslation;
	
	public RelationalAlgebraInterpreter(Database aDatabase) {
		database = aDatabase;
	}
	
	public String translate(String relationalAlgebraInput) {
		CustomErrorListener errorListener = new CustomErrorListener();	
		input = new ANTLRInputStream(relationalAlgebraInput);
	
		lexer = new RelationalAlgebraLexer(input);
		lexer.removeErrorListeners();
		lexer.addErrorListener(errorListener);
		
		tokens = new CommonTokenStream(lexer);
		parser = new RelationalAlgebraParser(tokens);
		parser.removeErrorListeners();
	    parser.addErrorListener(errorListener);
		
	    runSyntacticAnalysis();
	    
	    // Semantic analysis if syntax analysis was successful
	    if (errorListener.getSyntaxErrorsList().size() == 0) {	
	    	runSemanticAnalysis();
	    }
	    
	    else {
	    	System.out.println("> The Relational Algebra contains syntax errors:");
	    	errorListener.printErrors();
	    }
	    
		return sqlTranslation;
	}
	
	private void runSyntacticAnalysis() {
		tree = parser.start();
	}
	
	private void runSemanticAnalysis() {
		eval = new RelationalAlgebraEvalVisitor(database);
		sqlTranslation = eval.visit(tree);
	}

	public ANTLRInputStream getInput() {
		return input;
	}

	public void setInput(ANTLRInputStream input) {
		this.input = input;
	}

	public ParseTree getTree() {
		return tree;
	}

	public void setTree(ParseTree tree) {
		this.tree = tree;
	}

	public RelationalAlgebraLexer getLexer() {
		return lexer;
	}

	public void setLexer(RelationalAlgebraLexer lexer) {
		this.lexer = lexer;
	}

	public CommonTokenStream getTokens() {
		return tokens;
	}

	public void setTokens(CommonTokenStream tokens) {
		this.tokens = tokens;
	}

	public RelationalAlgebraParser getParser() {
		return parser;
	}

	public void setParser(RelationalAlgebraParser parser) {
		this.parser = parser;
	}

	public RelationalAlgebraEvalVisitor getEval() {
		return eval;
	}

	public void setEval(RelationalAlgebraEvalVisitor eval) {
		this.eval = eval;
	}

	public Database getDatabase() {
		return database;
	}

	public void setDatabase(Database database) {
		this.database = database;
	}

	public String getSqlTranslation() {
		return sqlTranslation;
	}

	public void setSqlTranslation(String sqlTranslation) {
		this.sqlTranslation = sqlTranslation;
	}
}
