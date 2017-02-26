package es.ull.etsii.jitrax.database;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import es.ull.etsii.jitrax.adt.Database;
import es.ull.etsii.jitrax.analysisDSL.DatabaseLexer;
import es.ull.etsii.jitrax.analysisDSL.DatabaseParser;
import es.ull.etsii.jitrax.analysisDSL.DescriptiveErrorListenerDSL;
import es.ull.etsii.jitrax.gui.dialogs.ErrorsDialog;
import es.ull.etsii.jitrax.analysisDSL.DatabaseEvalVisitor;

public class DatabaseFileLoader {

	private Database database;
	private String filePath;
	private String syntaxErrors;
	
	public DatabaseFileLoader(String aFilePath) {
		filePath = aFilePath;
	}
	
	private String readFile() throws IOException {
		byte[] encoded = Files.readAllBytes(Paths.get(filePath));
		return new String(encoded);
	}
	
	/**
	 * Returns true if the file was read correctly.
	 * False otherwise.
	 * Returns true if there were not errors.
	 */
	public boolean readDatabaseFromFile() {
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
		    
		    // Semantic analysis if syntax analysis was successful
		    if (errorListener.getSyntaxErrorsList().size() == 0) {	
		    	DatabaseEvalVisitor eval = new DatabaseEvalVisitor();
				database = (Database) eval.visit(tree);
				return true;
		    } 
		    
		    else {
		    	// Window showing the errors for the user
		    	ArrayList<String> errors = errorListener.getSyntaxErrorsList();
		    	ErrorsDialog errorsDialog = new ErrorsDialog(errors);
		    	return false;
		    }
		}
		
		catch (Exception e){
			e.printStackTrace();
			return false;
		}		
	}
	
	public Database getDatabase() {
		return database;
	}
}
