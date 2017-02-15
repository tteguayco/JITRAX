package es.ull.etsii.interpreters;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import es.ull.etsii.jitrax.gui.InfoConsolePanel;
import es.ull.etsii.relationalAlgebraAnalysis.EvalVisitor;
import es.ull.etsii.relationalAlgebraAnalysis.RelationalAlgebraLexer;
import es.ull.etsii.relationalAlgebraAnalysis.RelationalAlgebraParser;

public class RelationalAlgebraInterpreter {
	
	private ANTLRInputStream input;
	private RelationalAlgebraLexer lexer;
	private CommonTokenStream tokens;
	private RelationalAlgebraParser parser;
	private ParseTree tree;
	private EvalVisitor eval;
	
	public RelationalAlgebraInterpreter(String relationalAlgebraInput, InfoConsolePanel console) {
		input = new ANTLRInputStream(relationalAlgebraInput);
		lexer = new RelationalAlgebraLexer(input);
		tokens = new CommonTokenStream(lexer);
		parser = new RelationalAlgebraParser(tokens);
		
		//tree = parser.start();
		//EvalVisitor eval = new EvalVisitor();
		//eval.visit(tree);
	}
}
