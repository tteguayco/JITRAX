package es.ull.etsii.jitrax.interpreters;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import es.ull.etsii.jitrax.adt.Database;
import es.ull.etsii.jitrax.analysisRA.RelationalAlgebraTranslator;
import es.ull.etsii.jitrax.gui.Console;
import es.ull.etsii.jitrax.analysisRA.RelationalAlgebraLexer;
import es.ull.etsii.jitrax.analysisRA.RelationalAlgebraParser;

public class RelationalAlgebraInterpreter {
	
	private ANTLRInputStream input;
	private RelationalAlgebraLexer lexer;
	private CommonTokenStream tokens;
	private RelationalAlgebraParser parser;
	private ParseTree tree;
	private RelationalAlgebraTranslator eval;
	private Database database;
	private Console console;
	
	public RelationalAlgebraInterpreter(Database aDatabase, Console aConsole) {
		database = aDatabase;
		console = aConsole;
	}
	
	public void runAnalysis(String relationalAlgebraInput) {
		input = new ANTLRInputStream(relationalAlgebraInput);
		lexer = new RelationalAlgebraLexer(input);
		tokens = new CommonTokenStream(lexer);
		parser = new RelationalAlgebraParser(tokens);
	}
	
	public void runSyntacticAnalysis() {
		//tree = parser.start();
	}
	
	private void runSemanticAnalysis() {
		//EvalVisitor eval = new EvalVisitor();
		//eval.visit(tree);
	}
}
