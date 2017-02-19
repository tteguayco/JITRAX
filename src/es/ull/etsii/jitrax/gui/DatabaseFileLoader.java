package es.ull.etsii.jitrax.gui;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import es.ull.etsii.jitrax.OutputStreamExchanger.StreamExchanger;
import es.ull.etsii.jitrax.adt.Database;
import es.ull.etsii.jitrax.analysisDSL.DatabaseLexer;
import es.ull.etsii.jitrax.analysisDSL.DatabaseParser;
import es.ull.etsii.jitrax.analysisDSL.DescriptiveErrorListenerDSL;
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
	 * Returns true if the file was read correctly.
	 * False otherwise.
	 */
	public void readDatabaseFromFile() {
		try {
			String inputString = readFile();
			
			DescriptiveErrorListenerDSL errorListener = new DescriptiveErrorListenerDSL();
			ANTLRInputStream input = new ANTLRInputStream(inputString);
		    
			// Lexer
			DatabaseLexer lexer = new DatabaseLexer(input);
		    lexer.removeErrorListeners();
		    lexer.addErrorListener(errorListener);
		    
		    // Parser from tokens from the lexer
		    CommonTokenStream tokens = new CommonTokenStream(lexer);
		    DatabaseParser parser = new DatabaseParser(tokens);
		    parser.removeErrorListeners();
		    parser.addErrorListener(errorListener);
		    
		    // Syntax analysis
		    ParseTree tree = parser.start();
		    System.out.println("num of errors: " + errorListener.getSyntaxErrorsList());
		    
		    // Semantic analysis
		    if (errorListener.getSyntaxErrorsList().size() == 0) {	
		    	DatabaseEvalVisitor eval = new DatabaseEvalVisitor();
				database = (Database) eval.visit(tree);
		    } else {
		    	// TODO Mostrar ventana con errores de sintaxis
		    	System.out.println("no se procederá con el análisis semántico");
		    }
		}
		
		catch (Exception e){
			e.printStackTrace();
		}		
	}
	
	public Database getDatabase() {
		return database;
	}
}
