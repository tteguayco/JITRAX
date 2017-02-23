package es.ull.etsii.jitrax.analysisRA;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.*;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		try {
			System.out.println("ejecutando...");
			Scanner scanner = new Scanner(System.in);
			String inputString = scanner.nextLine();

			ANTLRInputStream input = new ANTLRInputStream(inputString);

		    RelationalAlgebraLexer lexer = new RelationalAlgebraLexer(input);

		    CommonTokenStream tokens = new CommonTokenStream(lexer);
		    RelationalAlgebraParser parser = new RelationalAlgebraParser(tokens);

		    ParseTree tree = parser.start();	

		    System.out.println("SQL");
		    
			RelationalAlgebraEvalVisitor eval = new RelationalAlgebraEvalVisitor();
			eval.visit(tree);
		}
		catch (Exception e){
			e.printStackTrace();
		}	
	}
}
