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
}
