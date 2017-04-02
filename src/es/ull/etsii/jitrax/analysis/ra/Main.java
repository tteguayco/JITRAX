package es.ull.etsii.jitrax.analysis.ra;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import es.ull.etsii.jitrax.adt.Database;
import es.ull.etsii.jitrax.gui.dialogs.FileDialog;

import java.util.*;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		try {
			FileDialog fileDialog = new FileDialog();
			Database database = fileDialog.importDatabaseDialog();
			
			System.out.println("CONSULTA > ");
			Scanner scanner = new Scanner(System.in);
			String inputString = scanner.nextLine();
			
			ANTLRInputStream input = new ANTLRInputStream(inputString);

		    RelationalAlgebraLexer lexer = new RelationalAlgebraLexer(input);

		    CommonTokenStream tokens = new CommonTokenStream(lexer);
		    RelationalAlgebraParser parser = new RelationalAlgebraParser(tokens);

		    ParseTree tree = parser.start();	

		    System.out.println();
		    
			RelationalAlgebraEvalVisitor eval = new RelationalAlgebraEvalVisitor(database);
			eval.visit(tree);
			
			if (eval.syntaxErrors()) {
				eval.printErrorsList();
			} else {
				System.out.println(eval.getSqlTranslation());
			}
		}
		catch (Exception e){
			e.printStackTrace();
		}	
	}
}
