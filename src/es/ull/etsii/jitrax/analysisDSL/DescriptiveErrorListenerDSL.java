package es.ull.etsii.jitrax.analysisDSL;

import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.atn.ATNConfigSet;

import java.util.ArrayList;
import java.util.BitSet;


public class DescriptiveErrorListenerDSL implements ANTLRErrorListener {
	private ArrayList<String> syntaxErrorsList;
	
	public DescriptiveErrorListenerDSL() {
		syntaxErrorsList = new ArrayList<String>();
	}
	
	public int getNumberOfSyntaxErrors() {
		return syntaxErrorsList.size();
	}


	@Override
	public void reportAmbiguity(Parser arg0, org.antlr.v4.runtime.dfa.DFA arg1, int arg2, int arg3, boolean arg4,
			BitSet arg5, ATNConfigSet arg6) {
		
	}


	@Override
	public void reportAttemptingFullContext(Parser arg0, org.antlr.v4.runtime.dfa.DFA arg1, int arg2, int arg3,
			BitSet arg4, ATNConfigSet arg5) {
		
	}


	@Override
	public void reportContextSensitivity(Parser arg0, org.antlr.v4.runtime.dfa.DFA arg1, int arg2, int arg3, int arg4,
			ATNConfigSet arg5) {
		
	}


	@Override
	public void syntaxError(org.antlr.v4.runtime.Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String message,
			org.antlr.v4.runtime.RecognitionException arg5) {
		String newSyntaxError = "line " + line + ":" + charPositionInLine + " " + message;
		syntaxErrorsList.add(newSyntaxError);
	}

	public ArrayList<String> getSyntaxErrorsList() {
		return syntaxErrorsList;
	}
}
