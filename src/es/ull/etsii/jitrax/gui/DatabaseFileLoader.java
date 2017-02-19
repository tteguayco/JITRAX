package es.ull.etsii.jitrax.gui;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import es.ull.etsii.jitrax.OutputStreamExchanger.StreamExchanger;
import es.ull.etsii.jitrax.adt.Database;
import es.ull.etsii.jitrax.analysisDSL.DatabaseLexer;
import es.ull.etsii.jitrax.analysisDSL.DatabaseParser;
import es.ull.etsii.jitrax.analysisDSL.DatabaseEvalVisitor;
import es.ull.etsii.jitrax.analysisRA.EvalVisitor;

public class DatabaseFileLoader {

	private Database database;
	private String filePath;
	private String syntaxErrors;
	private StreamExchanger streamExchanger;
	
	public DatabaseFileLoader(String aFilePath) {
		filePath = aFilePath;
		streamExchanger = new StreamExchanger(System.err);
	}
	
	private String readFile() throws IOException {
		byte[] encoded = Files.readAllBytes(Paths.get(filePath));
		return new String(encoded);
	}
	
	/**
	 * Returs true if the file was read correctly.
	 * False otherwise.
	 */
	public void readDatabaseFromFile() {
		try {
			String inputString = readFile();
			
			streamExchanger.redirectOutputStream();
			ANTLRInputStream input = new ANTLRInputStream(inputString);
		    DatabaseLexer lexer = new DatabaseLexer(input);
		    CommonTokenStream tokens = new CommonTokenStream(lexer);
		    DatabaseParser parser = new DatabaseParser(tokens);
		    streamExchanger.restoreOutputStream();
		    
		    // Semantic analysis
		    if (parser.getNumberOfSyntaxErrors() == 0) {
		    	ParseTree tree = parser.start();	
		    	DatabaseEvalVisitor eval = new DatabaseEvalVisitor();
				database = (Database) eval.visit(tree);
		    } else {
		    	syntaxErrors += streamExchanger.getSavedString();
		    }
		}
		
		catch (Exception e){
			System.out.println("Exception was thrown...");
			e.printStackTrace();
		}		
	}
	
	public Database getDatabase() {
		return database;
	}
}
