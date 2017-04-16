package es.ull.etsii.jitrax.tokenMaker;
import javax.swing.text.Segment;

import org.fife.ui.rsyntaxtextarea.AbstractTokenMaker;
import org.fife.ui.rsyntaxtextarea.RSyntaxUtilities;
import org.fife.ui.rsyntaxtextarea.Token;
import org.fife.ui.rsyntaxtextarea.TokenMap;

/**
 * Class written according to: 
 * https://github.com/bobbylight/RSyntaxTextArea/wiki/Adding-Syntax-Highlighting-for-a-new-Language
 * @author teguayco
 */
public class RelationalAlgebraTokenMaker extends AbstractTokenMaker {

	protected final String separators = "()[]";
	
	int currentTokenStart;
	int currentTokenType;
	
	@Override
	public void addToken(Segment segment, int start, int end, int tokenType, int startOffset) {
		switch (tokenType) {
			// Since reserved words, functions, and data types are all passed into here
			// as "identifiers," we have to see what the token really is...
			case Token.IDENTIFIER:
				int value = wordsToHighlight.get(segment, start,end);
				if (value!=-1)
					tokenType = value;
				break;
			case Token.WHITESPACE:
			case Token.SEPARATOR:
			case Token.OPERATOR:
			case Token.LITERAL_NUMBER_DECIMAL_INT:
			case Token.LITERAL_STRING_DOUBLE_QUOTE:
			case Token.LITERAL_CHAR:
			case Token.LITERAL_BACKQUOTE:
			case Token.COMMENT_EOL:
			case Token.PREPROCESSOR:
			case Token.VARIABLE:
				break;
	
			default:
				tokenType = Token.IDENTIFIER;
				break;
	
		}
		
		super.addToken(segment, start, end, tokenType, startOffset);
	}
	
	@Override
	public TokenMap getWordsToHighlight() {
		TokenMap tokenMap = new TokenMap();
	
		tokenMap.put("PROJECTION", Token.RESERVED_WORD);
		tokenMap.put("projection", Token.RESERVED_WORD);
		tokenMap.put("PROJECT", Token.RESERVED_WORD);
		tokenMap.put("project", Token.RESERVED_WORD);
		
		tokenMap.put("SELECTION", Token.RESERVED_WORD);
		tokenMap.put("selection", Token.RESERVED_WORD);
		tokenMap.put("SELECT", Token.RESERVED_WORD);
		tokenMap.put("select", Token.RESERVED_WORD);
		
		tokenMap.put("UNION", Token.RESERVED_WORD);
		tokenMap.put("union", Token.RESERVED_WORD);
		tokenMap.put("U", Token.RESERVED_WORD);
		
		tokenMap.put("DIFFERENCE", Token.RESERVED_WORD);
		tokenMap.put("difference", Token.RESERVED_WORD);
		tokenMap.put("-", Token.RESERVED_WORD);
		
		tokenMap.put("CARTESIAN_PRODUCT",  Token.RESERVED_WORD);
		tokenMap.put("cartesian_product", Token.RESERVED_WORD);
		tokenMap.put("PRODUCT", Token.RESERVED_WORD);
		tokenMap.put("product", Token.RESERVED_WORD);
		tokenMap.put("X", Token.RESERVED_WORD);
		tokenMap.put("x", Token.RESERVED_WORD);
		
		tokenMap.put("INTERSECTION", Token.RESERVED_WORD);
		tokenMap.put("intersection", Token.RESERVED_WORD);
		tokenMap.put("INTERSECT", Token.RESERVED_WORD);
		tokenMap.put("intersect",  Token.RESERVED_WORD);
		tokenMap.put("∩", Token.RESERVED_WORD);
		
		tokenMap.put("NATURAL_JOIN", Token.RESERVED_WORD);
		tokenMap.put("natural_join", Token.RESERVED_WORD);
		tokenMap.put("NJOIN", Token.RESERVED_WORD);
		tokenMap.put("njoin", Token.RESERVED_WORD);
		tokenMap.put("*", Token.RESERVED_WORD);
		
		tokenMap.put("JOIN", Token.RESERVED_WORD);
		tokenMap.put("join", Token.RESERVED_WORD);
		tokenMap.put("*", Token.RESERVED_WORD);
		tokenMap.put("Y", Token.RESERVED_WORD);
		tokenMap.put("y", Token.RESERVED_WORD);
		
		tokenMap.put("DIVISION", Token.RESERVED_WORD);
		tokenMap.put("division", Token.RESERVED_WORD);
		tokenMap.put("÷", Token.RESERVED_WORD);
		tokenMap.put("/", Token.RESERVED_WORD);
		
		tokenMap.put("RENAME", Token.RESERVED_WORD);
		tokenMap.put("rename", Token.RESERVED_WORD);
		tokenMap.put("REN", Token.RESERVED_WORD);
		
		tokenMap.put("AS", Token.RESERVED_WORD);
		tokenMap.put("as", Token.RESERVED_WORD);
		
		tokenMap.put("AND", Token.RESERVED_WORD);
		tokenMap.put("and", Token.RESERVED_WORD);
		tokenMap.put("&", Token.RESERVED_WORD);
		tokenMap.put("^", Token.RESERVED_WORD);
		tokenMap.put("OR", Token.RESERVED_WORD);
		tokenMap.put("or", Token.RESERVED_WORD);
		tokenMap.put("|", Token.RESERVED_WORD);
		tokenMap.put("v", Token.RESERVED_WORD);
		tokenMap.put("NOT", Token.RESERVED_WORD);
		tokenMap.put("not", Token.RESERVED_WORD);
		tokenMap.put("~", Token.RESERVED_WORD);
		
		return tokenMap;
	}
	
	@Override
	public Token getTokenList(Segment text, int startTokenType, int startOffset) {
		resetTokenList();

		char[] array = text.array;
		int offset = text.offset;
		int count = text.count;
		int end = offset + count;

		// See, when we find a token, its starting position is always of the form:
		// 'startOffset + (currentTokenStart-offset)'; but since startOffset and
		// offset are constant, tokens' starting positions become:
		// 'newStartOffset+currentTokenStart' for one less subraction operation.
		int newStartOffset = startOffset - offset;

		currentTokenStart = offset;
		currentTokenType  = startTokenType;
		
		 for (int i=offset; i<end; i++) {

		      char c = array[i];

		      switch (currentTokenType) {

		         case Token.NULL:

		            currentTokenStart = i;   // Starting a new token here.

		            switch (c) {

		               case ' ':
		               case '\t':
		                  currentTokenType = Token.WHITESPACE;
		                  break;

		               case '"':
		                  currentTokenType = Token.LITERAL_STRING_DOUBLE_QUOTE;
		                  break;

		               case '#':
		                  currentTokenType = Token.COMMENT_EOL;
		                  break;

		               default:
		            	   int firstIsSeparator = separators.indexOf(c,0);
		            	   
		                  if (RSyntaxUtilities.isDigit(c)) {
		                     currentTokenType = Token.LITERAL_NUMBER_DECIMAL_INT;
		                     break;
		                  }
		                  else if (RSyntaxUtilities.isLetter(c) || c=='/' || c=='_') {
		                     currentTokenType = Token.IDENTIFIER;
		                     break;
		                  } else if (firstIsSeparator > -1) {
		                	    addToken(text, currentTokenStart,i, Token.SEPARATOR, newStartOffset+currentTokenStart);
								currentTokenType = Token.NULL;
								break;
							}

		                  // Anything not currently handled - mark as an identifier
		                  currentTokenType = Token.IDENTIFIER;
		                  break;

		            } 
		            
		            break;

		         case Token.WHITESPACE:

		            switch (c) {

		               case ' ':
		               case '\t':
		                  break;   // Still whitespace.

		               case '"':
		                  addToken(text, currentTokenStart,i-1, Token.WHITESPACE, newStartOffset+currentTokenStart);
		                  currentTokenStart = i;
		                  currentTokenType = Token.LITERAL_STRING_DOUBLE_QUOTE;
		                  break;

		               case '#':
		                  addToken(text, currentTokenStart,i-1, Token.WHITESPACE, newStartOffset+currentTokenStart);
		                  currentTokenStart = i;
		                  currentTokenType = Token.COMMENT_EOL;
		                  break;

		               default:   // Add the whitespace token and start anew.
		            	   int firstIsSeparator = separators.indexOf(c,0);
		            	   
		                  addToken(text, currentTokenStart,i-1, Token.WHITESPACE, newStartOffset+currentTokenStart);
		                  currentTokenStart = i;

		                  if (RSyntaxUtilities.isDigit(c)) {
		                     currentTokenType = Token.LITERAL_NUMBER_DECIMAL_INT;
		                     break;
		                  }
		                  else if (RSyntaxUtilities.isLetter(c) || c=='/' || c=='_') {
		                     currentTokenType = Token.IDENTIFIER;
		                     break;
		                  } else if (firstIsSeparator > -1) {
		                	    addToken(text, i,i, Token.SEPARATOR, newStartOffset+i);
								currentTokenType = Token.NULL;
								break;
							}

		                  // Anything not currently handled - mark as identifier
		                  currentTokenType = Token.IDENTIFIER;

		            }

		            break;

		         default: 
		         case Token.IDENTIFIER:

		            switch (c) {

		               case ' ':
		               case '\t':
		                  addToken(text, currentTokenStart,i-1, Token.IDENTIFIER, newStartOffset+currentTokenStart);
		                  currentTokenStart = i;
		                  currentTokenType = Token.WHITESPACE;
		                  break;

		               case '"':
		                  addToken(text, currentTokenStart,i-1, Token.IDENTIFIER, newStartOffset+currentTokenStart);
		                  currentTokenStart = i;
		                  currentTokenType = Token.LITERAL_STRING_DOUBLE_QUOTE;
		                  break;

		               default:
		            	   int firstIsSeparator = separators.indexOf(c,0);
		            	   
		                  if (RSyntaxUtilities.isLetterOrDigit(c) || c=='/' || c=='_') {
		                     break;   // Still an identifier of some type.
		                  }
		                  else if (firstIsSeparator > -1) {
		                	  addToken(text, currentTokenStart,i-1, Token.IDENTIFIER, newStartOffset+currentTokenStart);
							  addToken(text, i,i, Token.SEPARATOR, newStartOffset+i);
							  currentTokenType = Token.NULL;
							  break;
		                  }

		            }

		         case Token.LITERAL_STRING_DOUBLE_QUOTE:
		             if (c=='"') {
		                addToken(text, currentTokenStart,i, Token.LITERAL_STRING_DOUBLE_QUOTE, newStartOffset+currentTokenStart);
		                currentTokenType = Token.NULL;
		             }
		             
		             break;  
		             
		        }
		   }

		   switch (currentTokenType) {

		      // Remember what token type to begin the next line with.
		      case Token.LITERAL_STRING_DOUBLE_QUOTE:
		         addToken(text, currentTokenStart,end-1, currentTokenType, newStartOffset+currentTokenStart);
		         break;

		      // Do nothing if everything was okay.
		      case Token.NULL:
		         addNullToken();
		         break;

		      // All other token types don't continue to the next line...
		      default:
		         addToken(text, currentTokenStart,end-1, currentTokenType, newStartOffset+currentTokenStart);
		         addNullToken();

		   }
		
		   return firstToken;
	}
	
}
