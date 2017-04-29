package es.ull.etsii.jitrax.interpreters;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import es.ull.etsii.jitrax.adt.Database;
import es.ull.etsii.jitrax.analysis.CustomErrorListener;
import es.ull.etsii.jitrax.analysis.ra.PreprocessingEvalVisitor;
import es.ull.etsii.jitrax.analysis.ra.RelationalAlgebraEvalVisitor;
import es.ull.etsii.jitrax.analysis.ra.RelationalAlgebraLexer;
import es.ull.etsii.jitrax.analysis.ra.RelationalAlgebraParser;

public class RelationalAlgebraInterpreter {
	private static final String SYNTAX_ERRORS_MSG = 
			"> The entered Relational Algebra expression contains syntax errors:";
	
	private ANTLRInputStream input;
	private ParseTree tree;
	
	private RelationalAlgebraLexer lexer;
	private CommonTokenStream tokens;
	private RelationalAlgebraParser parser;
	private RelationalAlgebraEvalVisitor eval;
	private CustomErrorListener errorListener;
	
	private Database database;
	private String sqlTranslation;
	
	public RelationalAlgebraInterpreter(Database aDatabase) {
		database = aDatabase;
		errorListener = new CustomErrorListener();	
		sqlTranslation = null;
	}
	
	private void runSyntaxAnalysis(String relationalAlgebraInput) {
		input = new ANTLRInputStream(relationalAlgebraInput);
		
		lexer = new RelationalAlgebraLexer(input);
		lexer.removeErrorListeners();
		lexer.addErrorListener(errorListener);
		
		tokens = new CommonTokenStream(lexer);
		parser = new RelationalAlgebraParser(tokens);
		parser.removeErrorListeners();
	    parser.addErrorListener(errorListener);
	}
	
	private String getPreprocessedQuery(String relationalAlgebraInput) {
		runSyntaxAnalysis(relationalAlgebraInput);
	    tree = parser.start();
	    
	    if (errorListener.getSyntaxErrorsList().size() <= 0) {
	    	PreprocessingEvalVisitor eval = new PreprocessingEvalVisitor();
		    return eval.visit(tree);
	    }
	    
	    else {
	    	System.out.println("\n" + SYNTAX_ERRORS_MSG);
	    	errorListener.printErrors();
	    	System.out.println();
	    }
	    
	    return null;
	}
	
	public String translate(String relationalAlgebraInput) {
		String preprocessedQuery = getPreprocessedQuery(relationalAlgebraInput);
		
		if (preprocessedQuery != null) {
			errorListener = new CustomErrorListener();
			runSyntaxAnalysis(preprocessedQuery);
		    tree = parser.start();
			
		    // Semantic analysis if syntax analysis was successful
		    if (errorListener.getSyntaxErrorsList().size() == 0) {	
		    	runSemanticAnalysis();
		    }
		    
		    else {
		    	System.out.println("\n" + SYNTAX_ERRORS_MSG);
		    	errorListener.printErrors();
		    }
		}
		
		return sqlTranslation;
	}
	
	private void runSemanticAnalysis() {
		eval = new RelationalAlgebraEvalVisitor(database);
		sqlTranslation = eval.visit(tree);
		
		// Semantic errors?
		if (eval.getErrorsList().size() > 0) {
			System.out.println("\n" + SYNTAX_ERRORS_MSG);
			for (int i = 0; i < eval.getErrorsList().size(); i++) {
				System.out.println(" - " + eval.getErrorsList().get(i));
			}
		}
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
