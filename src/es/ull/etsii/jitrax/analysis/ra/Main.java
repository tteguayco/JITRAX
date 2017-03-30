package es.ull.etsii.jitrax.analysis.ra;

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

		    System.out.println();
		    
			RelationalAlgebraEvalVisitor eval = new RelationalAlgebraEvalVisitor(null);
			eval.visit(tree);
			
			if (eval.syntaxErrors()) {
				eval.printErrorsList();
			} else {
				//System.out.println(eval.getExprTranslation());
			}
		}
		catch (Exception e){
			e.printStackTrace();
		}	
	}
}
