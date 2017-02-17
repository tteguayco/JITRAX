package es.ull.etsii.jitrax.databaseFileLoading;

import java.util.Scanner;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import es.ull.etsii.jitrax.adt.Database;

public class DatabaseFileLoader {

	private Database database;
	
	
	public static void main(String[] args) {
		try {
			System.out.print("> ");
			Scanner scanner = new Scanner(System.in);
			String inputString = scanner.nextLine();
			
			ANTLRInputStream input = new ANTLRInputStream(inputString);
		    DatabaseLexer lexer = new DatabaseLexer(input);
		    CommonTokenStream tokens = new CommonTokenStream(lexer);
		    DatabaseParser parser = new DatabaseParser(tokens);

		    ParseTree tree = parser.start();

			FileLoaderEvalVisitor eval = new FileLoaderEvalVisitor();
			System.out.println((Database) eval.visit(tree));
		}
		catch (Exception e){
			System.out.println("IOException was thrown...");
			e.printStackTrace();
		}		 
	}
}
