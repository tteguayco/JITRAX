
/*
 * TokenMaker for the Relational Algebra Language (based on Java's TokenMaker).
 */
package org.fife.ui.rsyntaxtextarea.modes;

import java.io.*;
import javax.swing.text.Segment;

import org.fife.ui.rsyntaxtextarea.*;

%%

%public
%class RelationalAlgebraTokenMaker
%extends AbstractJFlexCTokenMaker
%unicode
%type org.fife.ui.rsyntaxtextarea.Token


%{


	/**
	 * Constructor.  This must be here because JFlex does not generate a
	 * no-parameter constructor.
	 */
	public RelationalAlgebraTokenMaker() {
	}


	/**
	 * Adds the token specified to the current linked list of tokens.
	 *
	 * @param tokenType The token's type.
	 * @see #addToken(int, int, int)
	 */
	private void addHyperlinkToken(int start, int end, int tokenType) {
		int so = start + offsetShift;
		addToken(zzBuffer, start,end, tokenType, so, true);
	}


	/**
	 * Adds the token specified to the current linked list of tokens.
	 *
	 * @param tokenType The token's type.
	 */
	private void addToken(int tokenType) {
		addToken(zzStartRead, zzMarkedPos-1, tokenType);
	}


	/**
	 * Adds the token specified to the current linked list of tokens.
	 *
	 * @param tokenType The token's type.
	 * @see #addHyperlinkToken(int, int, int)
	 */
	private void addToken(int start, int end, int tokenType) {
		int so = start + offsetShift;
		addToken(zzBuffer, start,end, tokenType, so, false);
	}


	/**
	 * Adds the token specified to the current linked list of tokens.
	 *
	 * @param array The character array.
	 * @param start The starting offset in the array.
	 * @param end The ending offset in the array.
	 * @param tokenType The token's type.
	 * @param startOffset The offset in the document at which this token
	 *                    occurs.
	 * @param hyperlink Whether this token is a hyperlink.
	 */
	@Override
	public void addToken(char[] array, int start, int end, int tokenType,
						int startOffset, boolean hyperlink) {
		super.addToken(array, start,end, tokenType, startOffset, hyperlink);
		zzStartRead = zzMarkedPos;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public String[] getLineCommentStartAndEnd(int languageIndex) {
		return new String[] { "//", null };
	}


	/**
	 * Returns the first token in the linked list of tokens generated
	 * from <code>text</code>.  This method must be implemented by
	 * subclasses so they can correctly implement syntax highlighting.
	 *
	 * @param text The text from which to get tokens.
	 * @param initialTokenType The token type we should start with.
	 * @param startOffset The offset into the document at which
	 *        <code>text</code> starts.
	 * @return The first <code>Token</code> in a linked list representing
	 *         the syntax highlighted text.
	 */
	public Token getTokenList(Segment text, int initialTokenType, int startOffset) {

		resetTokenList();
		this.offsetShift = -text.offset + startOffset;

		// Start off in the proper state.
		int state = Token.NULL;
		switch (initialTokenType) {
			case Token.COMMENT_MULTILINE:
				state = MLC;
				start = text.offset;
				break;
			case Token.COMMENT_DOCUMENTATION:
				state = DOCCOMMENT;
				start = text.offset;
				break;
			default:
				state = Token.NULL;
		}

		s = text;
		try {
			yyreset(zzReader);
			yybegin(state);
			return yylex();
		} catch (IOException ioe) {
			ioe.printStackTrace();
			return new TokenImpl();
		}

	}


	/**
	 * Refills the input buffer.
	 *
	 * @return      <code>true</code> if EOF was reached, otherwise
	 *              <code>false</code>.
	 */
	private boolean zzRefill() {
		return zzCurrentPos>=s.offset+s.count;
	}


	/**
	 * Resets the scanner to read from a new input stream.
	 * Does not close the old reader.
	 *
	 * All internal variables are reset, the old input stream 
	 * <b>cannot</b> be reused (internal buffer is discarded and lost).
	 * Lexical state is set to <tt>YY_INITIAL</tt>.
	 *
	 * @param reader   the new input stream 
	 */
	public final void yyreset(Reader reader) {
		// 's' has been updated.
		zzBuffer = s.array;
		/*
		 * We replaced the line below with the two below it because zzRefill
		 * no longer "refills" the buffer (since the way we do it, it's always
		 * "full" the first time through, since it points to the segment's
		 * array).  So, we assign zzEndRead here.
		 */
		//zzStartRead = zzEndRead = s.offset;
		zzStartRead = s.offset;
		zzEndRead = zzStartRead + s.count - 1;
		zzCurrentPos = zzMarkedPos = zzPushbackPos = s.offset;
		zzLexicalState = YYINITIAL;
		zzReader = reader;
		zzAtBOL  = true;
		zzAtEOF  = false;
	}


%}

Letter							= ([A-Za-z])
LetterOrUnderscore				= ({Letter}|"_")
Underscores						= ([_]+)
NonzeroDigit						= ([1-9])
BinaryDigit						= ([0-1])
Digit							= ("0"|{NonzeroDigit})
HexDigit							= ({Digit}|[A-Fa-f])
OctalDigit						= ([0-7])
AnyCharacterButApostropheOrBackSlash	= ([^\\'])
AnyCharacterButDoubleQuoteOrBackSlash	= ([^\\\"\n])
EscapedSourceCharacter				= ("u"{HexDigit}{HexDigit}{HexDigit}{HexDigit})
Escape							= ("\\"(([btnfr\"'\\])|([0123]{OctalDigit}?{OctalDigit}?)|({OctalDigit}{OctalDigit}?)|{EscapedSourceCharacter}))
NonSeparator						= ([^\t\f\r\n\ \(\)\{\}\[\]\;\,\.\=\>\<\!\~\?\:\+\-\*\/\&\|\^\%\"\']|"#"|"\\")
IdentifierStart					= ({LetterOrUnderscore}|"$")
IdentifierPart						= ({IdentifierStart}|{Digit}|("\\"{EscapedSourceCharacter}))

LineTerminator				= (\n)
WhiteSpace				= ([ \t\f])

CharLiteral				= ([\']({AnyCharacterButApostropheOrBackSlash}|{Escape})[\'])
UnclosedCharLiteral			= ([\'][^\'\n]*)
ErrorCharLiteral			= ({UnclosedCharLiteral}[\'])
StringLiteral				= ([\"]({AnyCharacterButDoubleQuoteOrBackSlash}|{Escape})*[\"])
UnclosedStringLiteral		= ([\"]([\\].|[^\\\"])*[^\"]?)
ErrorStringLiteral			= ({UnclosedStringLiteral}[\"])

MLCBegin					= "/*"
MLCEnd					= "*/"
DocCommentBegin			= "/**"
LineCommentBegin			= "//"

DigitOrUnderscore			= ({Digit}|[_])
DigitsAndUnderscoresEnd		= ({DigitOrUnderscore}*{Digit})
IntegerHelper				= (({NonzeroDigit}{DigitsAndUnderscoresEnd}?)|"0")
IntegerLiteral				= ({IntegerHelper}[lL]?)

BinaryDigitOrUnderscore		= ({BinaryDigit}|[_])
BinaryDigitsAndUnderscores	= ({BinaryDigit}({BinaryDigitOrUnderscore}*{BinaryDigit})?)
BinaryLiteral				= ("0"[bB]{BinaryDigitsAndUnderscores})

HexDigitOrUnderscore		= ({HexDigit}|[_])
HexDigitsAndUnderscores		= ({HexDigit}({HexDigitOrUnderscore}*{HexDigit})?)
OctalDigitOrUnderscore		= ({OctalDigit}|[_])
OctalDigitsAndUnderscoresEnd= ({OctalDigitOrUnderscore}*{OctalDigit})
HexHelper					= ("0"(([xX]{HexDigitsAndUnderscores})|({OctalDigitsAndUnderscoresEnd})))
HexLiteral					= ({HexHelper}[lL]?)

FloatHelper1				= ([fFdD]?)
FloatHelper2				= ([eE][+-]?{Digit}+{FloatHelper1})
FloatLiteral1				= ({Digit}+"."({FloatHelper1}|{FloatHelper2}|{Digit}+({FloatHelper1}|{FloatHelper2})))
FloatLiteral2				= ("."{Digit}+({FloatHelper1}|{FloatHelper2}))
FloatLiteral3				= ({Digit}+{FloatHelper2})
FloatLiteral				= ({FloatLiteral1}|{FloatLiteral2}|{FloatLiteral3}|({Digit}+[fFdD]))

ErrorNumberFormat			= (({IntegerLiteral}|{HexLiteral}|{FloatLiteral}){NonSeparator}+)
BooleanLiteral				= ("true"|"false")

Separator					= ([\(\)\{\}\[\]])
Separator2				= ([\;,.])

NonAssignmentOperator		= ("+"|"-"|"<="|"^"|"++"|"<"|"*"|">="|"%"|"--"|">"|"/"|"!="|"?"|">>"|"!"|"&"|"=="|":"|">>"|"~"|"|"|"&&"|">>>")
AssignmentOperator			= ("="|"-="|"*="|"/="|"|="|"&="|"^="|"+="|"%="|"<<="|">>="|">>>=")
Operator					= ({NonAssignmentOperator}|{AssignmentOperator})

CurrentBlockTag				= ("author"|"deprecated"|"exception"|"param"|"return"|"see"|"serial"|"serialData"|"serialField"|"since"|"throws"|"version")
ProposedBlockTag			= ("category"|"example"|"tutorial"|"index"|"exclude"|"todo"|"internal"|"obsolete"|"threadsafety")
BlockTag					= ({CurrentBlockTag}|{ProposedBlockTag})
InlineTag					= ("code"|"docRoot"|"inheritDoc"|"link"|"linkplain"|"literal"|"value")

Identifier				= ({IdentifierStart}{IdentifierPart}*)
ErrorIdentifier			= ({NonSeparator}+)

Annotation				= ("@"{Identifier}?)

URLGenDelim				= ([:\/\?#\[\]@])
URLSubDelim				= ([\!\$&'\(\)\*\+,;=])
URLUnreserved			= ({LetterOrUnderscore}|{Digit}|[\-\.\~])
URLCharacter			= ({URLGenDelim}|{URLSubDelim}|{URLUnreserved}|[%])
URLCharacters			= ({URLCharacter}*)
URLEndCharacter			= ([\/\$]|{Letter}|{Digit})
URL						= (((https?|f(tp|ile))"://"|"www.")({URLCharacters}{URLEndCharacter})?)


%state MLC
%state DOCCOMMENT
%state EOL_COMMENT

%%

<YYINITIAL> {

	/* Keywords */
	
	"PROJECTION" |
	"projection" |
	"PROJECT" |
	"project" |
	
	"SELECTION" |
	"selection" |
	"SELECT" |
	"select" |
	
	"UNION" |
	"union" |
	"U" |
	
	"DIFFERENCE" |
	"difference" |
	"-" |
	
	"CARTESIAN_PRODUCT" |
	"cartesian_product" |
	"PRODUCT" |
	"product" |
	"X" |
	"x" |
	
	"INTERSECTION" |
	"intersection" |
	"INTERSECT" |
	"intersect" |
	"∩" |

	"NATURAL_JOIN" |
	"natural_join" |
	"NJOIN" |
	"njoin" |
	"*" |
	
	"JOIN" |
	"join" |
	"*" |
	"Y" |;
	"y" |
	
	"DIVISION" |
	"division" |
	"÷" |
	"/" |
	
	"AND"  |
	"and" |
	"&" |
	"^" |
	"OR" |
	"or" |
	"|" |
	"v" |
	"NOT" |
	"not" |
	"~" 			{ addToken(Token.RESERVED_WORD); }

	/* Booleans. */
	{BooleanLiteral}			{ addToken(Token.LITERAL_BOOLEAN); }

	

	{LineTerminator}				{ addNullToken(); return firstToken; }

	{Identifier}					{ addToken(Token.IDENTIFIER); }

	{WhiteSpace}+					{ addToken(Token.WHITESPACE); }

	/* String/Character literals. */
	{CharLiteral}					{ addToken(Token.LITERAL_CHAR); }
	{UnclosedCharLiteral}			{ addToken(Token.ERROR_CHAR); addNullToken(); return firstToken; }
	{ErrorCharLiteral}				{ addToken(Token.ERROR_CHAR); }
	{StringLiteral}				{ addToken(Token.LITERAL_STRING_DOUBLE_QUOTE); }
	{UnclosedStringLiteral}			{ addToken(Token.ERROR_STRING_DOUBLE); addNullToken(); return firstToken; }
	{ErrorStringLiteral}			{ addToken(Token.ERROR_STRING_DOUBLE); }

	/* Comment literals. */
	"/**/"						{ addToken(Token.COMMENT_MULTILINE); }
	{MLCBegin}					{ start = zzMarkedPos-2; yybegin(MLC); }
	{DocCommentBegin}				{ start = zzMarkedPos-3; yybegin(DOCCOMMENT); }
	{LineCommentBegin}			{ start = zzMarkedPos-2; yybegin(EOL_COMMENT); }

	/* Annotations. */
	{Annotation}					{ addToken(Token.ANNOTATION); }

	/* Separators. */
	{Separator}					{ addToken(Token.SEPARATOR); }
	{Separator2}					{ addToken(Token.IDENTIFIER); }

	/* Operators. */
	{Operator}					{ addToken(Token.OPERATOR); }

	/* Numbers */
	{IntegerLiteral}				{ addToken(Token.LITERAL_NUMBER_DECIMAL_INT); }
	{BinaryLiteral}					{ addToken(Token.LITERAL_NUMBER_DECIMAL_INT); }
	{HexLiteral}					{ addToken(Token.LITERAL_NUMBER_HEXADECIMAL); }
	{FloatLiteral}					{ addToken(Token.LITERAL_NUMBER_FLOAT); }
	{ErrorNumberFormat}				{ addToken(Token.ERROR_NUMBER_FORMAT); }

	{ErrorIdentifier}				{ addToken(Token.ERROR_IDENTIFIER); }

	/* Ended with a line not in a string or comment. */
	<<EOF>>						{ addNullToken(); return firstToken; }

	/* Catch any other (unhandled) characters and flag them as identifiers. */
	.							{ addToken(Token.ERROR_IDENTIFIER); }

}


<MLC> {

	[^hwf\n\*]+				{}
	{URL}					{ int temp=zzStartRead; addToken(start,zzStartRead-1, Token.COMMENT_MULTILINE); addHyperlinkToken(temp,zzMarkedPos-1, Token.COMMENT_MULTILINE); start = zzMarkedPos; }
	[hwf]					{}

	\n						{ addToken(start,zzStartRead-1, Token.COMMENT_MULTILINE); return firstToken; }
	{MLCEnd}					{ yybegin(YYINITIAL); addToken(start,zzStartRead+1, Token.COMMENT_MULTILINE); }
	\*						{}
	<<EOF>>					{ addToken(start,zzStartRead-1, Token.COMMENT_MULTILINE); return firstToken; }

}


<DOCCOMMENT> {

	[^hwf\@\{\n\<\*]+			{}
	{URL}						{ int temp=zzStartRead; addToken(start,zzStartRead-1, Token.COMMENT_DOCUMENTATION); addHyperlinkToken(temp,zzMarkedPos-1, Token.COMMENT_DOCUMENTATION); start = zzMarkedPos; }
	[hwf]						{}

	"@"{BlockTag}				{ int temp=zzStartRead; addToken(start,zzStartRead-1, Token.COMMENT_DOCUMENTATION); addToken(temp,zzMarkedPos-1, Token.COMMENT_KEYWORD); start = zzMarkedPos; }
	"@"							{}
	"{@"{InlineTag}[^\}]*"}"	{ int temp=zzStartRead; addToken(start,zzStartRead-1, Token.COMMENT_DOCUMENTATION); addToken(temp,zzMarkedPos-1, Token.COMMENT_KEYWORD); start = zzMarkedPos; }
	"{"							{}
	\n							{ addToken(start,zzStartRead-1, Token.COMMENT_DOCUMENTATION); return firstToken; }
	"<"[/]?({Letter}[^\>]*)?">"	{ int temp=zzStartRead; addToken(start,zzStartRead-1, Token.COMMENT_DOCUMENTATION); addToken(temp,zzMarkedPos-1, Token.COMMENT_MARKUP); start = zzMarkedPos; }
	\<							{}
	{MLCEnd}					{ yybegin(YYINITIAL); addToken(start,zzStartRead+1, Token.COMMENT_DOCUMENTATION); }
	\*							{}
	<<EOF>>						{ yybegin(YYINITIAL); addToken(start,zzEndRead, Token.COMMENT_DOCUMENTATION); return firstToken; }

}


<EOL_COMMENT> {
	[^hwf\n]+				{}
	{URL}					{ int temp=zzStartRead; addToken(start,zzStartRead-1, Token.COMMENT_EOL); addHyperlinkToken(temp,zzMarkedPos-1, Token.COMMENT_EOL); start = zzMarkedPos; }
	[hwf]					{}
	\n						{ addToken(start,zzStartRead-1, Token.COMMENT_EOL); addNullToken(); return firstToken; }
	<<EOF>>					{ addToken(start,zzStartRead-1, Token.COMMENT_EOL); addNullToken(); return firstToken; }

}
