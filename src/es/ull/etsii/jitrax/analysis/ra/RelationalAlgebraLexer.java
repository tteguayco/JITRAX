package es.ull.etsii.jitrax.analysis.ra;

// Generated from RelationalAlgebra.g4 by ANTLR 4.6
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class RelationalAlgebraLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.6", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, PROJECTION=8, 
		SELECTION=9, UNION=10, DIFFERENCE=11, CARTESIAN_PRODUCT=12, INTERSECTION=13, 
		NATURAL_JOIN=14, JOIN=15, DIVISION=16, EQUAL=17, NOT_EQUAL=18, GREATER_THAN=19, 
		GREATER_EQUAL=20, LESS_THAN=21, LESS_EQUAL=22, BOOLEAN_AND=23, BOOLEAN_OR=24, 
		BOOLEAN_NOT=25, STRING=26, IDENTIFIER=27, NUMBER=28, WHITESPACES=29, COMMENT=30, 
		LINE_COMMENT=31;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "PROJECTION", 
		"SELECTION", "UNION", "DIFFERENCE", "CARTESIAN_PRODUCT", "INTERSECTION", 
		"NATURAL_JOIN", "JOIN", "DIVISION", "EQUAL", "NOT_EQUAL", "GREATER_THAN", 
		"GREATER_EQUAL", "LESS_THAN", "LESS_EQUAL", "BOOLEAN_AND", "BOOLEAN_OR", 
		"BOOLEAN_NOT", "STRING", "IDENTIFIER", "NUMBER", "WHITESPACES", "COMMENT", 
		"LINE_COMMENT"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';'", "'('", "')'", "'['", "']'", "','", "'NOT'", null, null, null, 
		null, null, null, null, null, null, "'='", null, "'>'", "'>='", "'<'", 
		"'<='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, "PROJECTION", "SELECTION", 
		"UNION", "DIFFERENCE", "CARTESIAN_PRODUCT", "INTERSECTION", "NATURAL_JOIN", 
		"JOIN", "DIVISION", "EQUAL", "NOT_EQUAL", "GREATER_THAN", "GREATER_EQUAL", 
		"LESS_THAN", "LESS_EQUAL", "BOOLEAN_AND", "BOOLEAN_OR", "BOOLEAN_NOT", 
		"STRING", "IDENTIFIER", "NUMBER", "WHITESPACES", "COMMENT", "LINE_COMMENT"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public RelationalAlgebraLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "RelationalAlgebra.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2!\u01db\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \3\2"+
		"\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\tt\n\t\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u0094\n\n\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00a1\n\13\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\5\f\u00b8\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\5\r\u00eb\n\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\5\16\u0118\n\16\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\5\17\u013d\n\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20"+
		"\u0148\n\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\5\21\u015b\n\21\3\22\3\22\3\23\3\23\3\23\3\23"+
		"\5\23\u0163\n\23\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\27\3\27\3\27\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u0176\n\30\3\31\3\31\3\31\3\31\3\31"+
		"\5\31\u017d\n\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u0186\n\32\3"+
		"\33\3\33\7\33\u018a\n\33\f\33\16\33\u018d\13\33\3\33\3\33\3\33\7\33\u0192"+
		"\n\33\f\33\16\33\u0195\13\33\3\33\5\33\u0198\n\33\3\34\6\34\u019b\n\34"+
		"\r\34\16\34\u019c\3\34\7\34\u01a0\n\34\f\34\16\34\u01a3\13\34\3\34\3\34"+
		"\6\34\u01a7\n\34\r\34\16\34\u01a8\3\34\7\34\u01ac\n\34\f\34\16\34\u01af"+
		"\13\34\6\34\u01b1\n\34\r\34\16\34\u01b2\5\34\u01b5\n\34\3\35\6\35\u01b8"+
		"\n\35\r\35\16\35\u01b9\3\36\6\36\u01bd\n\36\r\36\16\36\u01be\3\36\3\36"+
		"\3\37\3\37\3\37\3\37\7\37\u01c7\n\37\f\37\16\37\u01ca\13\37\3\37\3\37"+
		"\3\37\3\37\3\37\3 \3 \3 \3 \7 \u01d5\n \f \16 \u01d8\13 \3 \3 \5\u018b"+
		"\u0193\u01c8\2!\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31"+
		"\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65"+
		"\34\67\359\36;\37= ?!\3\2\f\4\2ZZzz\4\2[[{{\4\2\61\61\u00f9\u00f9\4\2"+
		"((``\4\2xx~~\4\2C\\c|\6\2\62;C\\aac|\3\2\62;\5\2\13\f\17\17\"\"\4\2\f"+
		"\f\17\17\u0208\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3"+
		"\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2"+
		"\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3"+
		"\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2"+
		"\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\2"+
		"9\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\3A\3\2\2\2\5C\3\2\2\2\7E\3"+
		"\2\2\2\tG\3\2\2\2\13I\3\2\2\2\rK\3\2\2\2\17M\3\2\2\2\21s\3\2\2\2\23\u0093"+
		"\3\2\2\2\25\u00a0\3\2\2\2\27\u00b7\3\2\2\2\31\u00ea\3\2\2\2\33\u0117\3"+
		"\2\2\2\35\u013c\3\2\2\2\37\u0147\3\2\2\2!\u015a\3\2\2\2#\u015c\3\2\2\2"+
		"%\u0162\3\2\2\2\'\u0164\3\2\2\2)\u0166\3\2\2\2+\u0169\3\2\2\2-\u016b\3"+
		"\2\2\2/\u0175\3\2\2\2\61\u017c\3\2\2\2\63\u0185\3\2\2\2\65\u0197\3\2\2"+
		"\2\67\u019a\3\2\2\29\u01b7\3\2\2\2;\u01bc\3\2\2\2=\u01c2\3\2\2\2?\u01d0"+
		"\3\2\2\2AB\7=\2\2B\4\3\2\2\2CD\7*\2\2D\6\3\2\2\2EF\7+\2\2F\b\3\2\2\2G"+
		"H\7]\2\2H\n\3\2\2\2IJ\7_\2\2J\f\3\2\2\2KL\7.\2\2L\16\3\2\2\2MN\7P\2\2"+
		"NO\7Q\2\2OP\7V\2\2P\20\3\2\2\2QR\7R\2\2RS\7T\2\2ST\7Q\2\2TU\7L\2\2UV\7"+
		"G\2\2VW\7E\2\2WX\7V\2\2XY\7K\2\2YZ\7Q\2\2Zt\7P\2\2[\\\7r\2\2\\]\7t\2\2"+
		"]^\7q\2\2^_\7l\2\2_`\7g\2\2`a\7e\2\2ab\7v\2\2bc\7k\2\2cd\7q\2\2dt\7p\2"+
		"\2ef\7R\2\2fg\7T\2\2gh\7Q\2\2hi\7L\2\2ij\7G\2\2jk\7E\2\2kt\7V\2\2lm\7"+
		"r\2\2mn\7t\2\2no\7q\2\2op\7l\2\2pq\7g\2\2qr\7e\2\2rt\7v\2\2sQ\3\2\2\2"+
		"s[\3\2\2\2se\3\2\2\2sl\3\2\2\2t\22\3\2\2\2uv\7U\2\2vw\7G\2\2wx\7N\2\2"+
		"xy\7G\2\2yz\7E\2\2z{\7V\2\2{|\7K\2\2|}\7Q\2\2}\u0094\7P\2\2~\177\7u\2"+
		"\2\177\u0080\7g\2\2\u0080\u0081\7n\2\2\u0081\u0082\7g\2\2\u0082\u0083"+
		"\7e\2\2\u0083\u0084\7v\2\2\u0084\u0085\7k\2\2\u0085\u0086\7q\2\2\u0086"+
		"\u0094\7p\2\2\u0087\u0088\7U\2\2\u0088\u0089\7G\2\2\u0089\u008a\7N\2\2"+
		"\u008a\u008b\7G\2\2\u008b\u008c\7E\2\2\u008c\u0094\7V\2\2\u008d\u008e"+
		"\7u\2\2\u008e\u008f\7g\2\2\u008f\u0090\7n\2\2\u0090\u0091\7g\2\2\u0091"+
		"\u0092\7e\2\2\u0092\u0094\7v\2\2\u0093u\3\2\2\2\u0093~\3\2\2\2\u0093\u0087"+
		"\3\2\2\2\u0093\u008d\3\2\2\2\u0094\24\3\2\2\2\u0095\u0096\7W\2\2\u0096"+
		"\u0097\7P\2\2\u0097\u0098\7K\2\2\u0098\u0099\7Q\2\2\u0099\u00a1\7P\2\2"+
		"\u009a\u009b\7w\2\2\u009b\u009c\7p\2\2\u009c\u009d\7k\2\2\u009d\u009e"+
		"\7q\2\2\u009e\u00a1\7p\2\2\u009f\u00a1\7W\2\2\u00a0\u0095\3\2\2\2\u00a0"+
		"\u009a\3\2\2\2\u00a0\u009f\3\2\2\2\u00a1\26\3\2\2\2\u00a2\u00a3\7F\2\2"+
		"\u00a3\u00a4\7K\2\2\u00a4\u00a5\7H\2\2\u00a5\u00a6\7H\2\2\u00a6\u00a7"+
		"\7G\2\2\u00a7\u00a8\7T\2\2\u00a8\u00a9\7G\2\2\u00a9\u00aa\7P\2\2\u00aa"+
		"\u00ab\7E\2\2\u00ab\u00b8\7G\2\2\u00ac\u00ad\7f\2\2\u00ad\u00ae\7k\2\2"+
		"\u00ae\u00af\7h\2\2\u00af\u00b0\7h\2\2\u00b0\u00b1\7g\2\2\u00b1\u00b2"+
		"\7t\2\2\u00b2\u00b3\7g\2\2\u00b3\u00b4\7p\2\2\u00b4\u00b5\7e\2\2\u00b5"+
		"\u00b8\7g\2\2\u00b6\u00b8\7/\2\2\u00b7\u00a2\3\2\2\2\u00b7\u00ac\3\2\2"+
		"\2\u00b7\u00b6\3\2\2\2\u00b8\30\3\2\2\2\u00b9\u00ba\7E\2\2\u00ba\u00bb"+
		"\7C\2\2\u00bb\u00bc\7T\2\2\u00bc\u00bd\7V\2\2\u00bd\u00be\7G\2\2\u00be"+
		"\u00bf\7U\2\2\u00bf\u00c0\7K\2\2\u00c0\u00c1\7C\2\2\u00c1\u00c2\7P\2\2"+
		"\u00c2\u00c3\7\"\2\2\u00c3\u00c4\7R\2\2\u00c4\u00c5\7T\2\2\u00c5\u00c6"+
		"\7Q\2\2\u00c6\u00c7\7F\2\2\u00c7\u00c8\7W\2\2\u00c8\u00c9\7E\2\2\u00c9"+
		"\u00eb\7V\2\2\u00ca\u00cb\7e\2\2\u00cb\u00cc\7c\2\2\u00cc\u00cd\7t\2\2"+
		"\u00cd\u00ce\7v\2\2\u00ce\u00cf\7g\2\2\u00cf\u00d0\7u\2\2\u00d0\u00d1"+
		"\7k\2\2\u00d1\u00d2\7c\2\2\u00d2\u00d3\7p\2\2\u00d3\u00d4\7\"\2\2\u00d4"+
		"\u00d5\7r\2\2\u00d5\u00d6\7t\2\2\u00d6\u00d7\7q\2\2\u00d7\u00d8\7f\2\2"+
		"\u00d8\u00d9\7w\2\2\u00d9\u00da\7e\2\2\u00da\u00eb\7v\2\2\u00db\u00dc"+
		"\7R\2\2\u00dc\u00dd\7T\2\2\u00dd\u00de\7Q\2\2\u00de\u00df\7F\2\2\u00df"+
		"\u00e0\7W\2\2\u00e0\u00e1\7E\2\2\u00e1\u00eb\7V\2\2\u00e2\u00e3\7r\2\2"+
		"\u00e3\u00e4\7t\2\2\u00e4\u00e5\7q\2\2\u00e5\u00e6\7f\2\2\u00e6\u00e7"+
		"\7w\2\2\u00e7\u00e8\7e\2\2\u00e8\u00eb\7v\2\2\u00e9\u00eb\t\2\2\2\u00ea"+
		"\u00b9\3\2\2\2\u00ea\u00ca\3\2\2\2\u00ea\u00db\3\2\2\2\u00ea\u00e2\3\2"+
		"\2\2\u00ea\u00e9\3\2\2\2\u00eb\32\3\2\2\2\u00ec\u00ed\7K\2\2\u00ed\u00ee"+
		"\7P\2\2\u00ee\u00ef\7V\2\2\u00ef\u00f0\7G\2\2\u00f0\u00f1\7T\2\2\u00f1"+
		"\u00f2\7U\2\2\u00f2\u00f3\7G\2\2\u00f3\u00f4\7E\2\2\u00f4\u00f5\7V\2\2"+
		"\u00f5\u00f6\7K\2\2\u00f6\u00f7\7Q\2\2\u00f7\u0118\7P\2\2\u00f8\u00f9"+
		"\7k\2\2\u00f9\u00fa\7p\2\2\u00fa\u00fb\7v\2\2\u00fb\u00fc\7g\2\2\u00fc"+
		"\u00fd\7t\2\2\u00fd\u00fe\7u\2\2\u00fe\u00ff\7g\2\2\u00ff\u0100\7e\2\2"+
		"\u0100\u0101\7v\2\2\u0101\u0102\7k\2\2\u0102\u0103\7q\2\2\u0103\u0118"+
		"\7p\2\2\u0104\u0105\7K\2\2\u0105\u0106\7P\2\2\u0106\u0107\7V\2\2\u0107"+
		"\u0108\7G\2\2\u0108\u0109\7T\2\2\u0109\u010a\7U\2\2\u010a\u010b\7G\2\2"+
		"\u010b\u010c\7E\2\2\u010c\u0118\7V\2\2\u010d\u010e\7k\2\2\u010e\u010f"+
		"\7p\2\2\u010f\u0110\7v\2\2\u0110\u0111\7g\2\2\u0111\u0112\7t\2\2\u0112"+
		"\u0113\7u\2\2\u0113\u0114\7g\2\2\u0114\u0115\7e\2\2\u0115\u0118\7v\2\2"+
		"\u0116\u0118\7\u222b\2\2\u0117\u00ec\3\2\2\2\u0117\u00f8\3\2\2\2\u0117"+
		"\u0104\3\2\2\2\u0117\u010d\3\2\2\2\u0117\u0116\3\2\2\2\u0118\34\3\2\2"+
		"\2\u0119\u011a\7P\2\2\u011a\u011b\7C\2\2\u011b\u011c\7V\2\2\u011c\u011d"+
		"\7W\2\2\u011d\u011e\7T\2\2\u011e\u011f\7C\2\2\u011f\u0120\7N\2\2\u0120"+
		"\u0121\7\"\2\2\u0121\u0122\7L\2\2\u0122\u0123\7Q\2\2\u0123\u0124\7K\2"+
		"\2\u0124\u013d\7P\2\2\u0125\u0126\7P\2\2\u0126\u0127\7L\2\2\u0127\u0128"+
		"\7Q\2\2\u0128\u0129\7K\2\2\u0129\u013d\7P\2\2\u012a\u012b\7p\2\2\u012b"+
		"\u012c\7c\2\2\u012c\u012d\7v\2\2\u012d\u012e\7w\2\2\u012e\u012f\7t\2\2"+
		"\u012f\u0130\7c\2\2\u0130\u0131\7n\2\2\u0131\u0132\7\"\2\2\u0132\u0133"+
		"\7l\2\2\u0133\u0134\7q\2\2\u0134\u0135\7k\2\2\u0135\u013d\7p\2\2\u0136"+
		"\u0137\7p\2\2\u0137\u0138\7l\2\2\u0138\u0139\7q\2\2\u0139\u013a\7k\2\2"+
		"\u013a\u013d\7p\2\2\u013b\u013d\7,\2\2\u013c\u0119\3\2\2\2\u013c\u0125"+
		"\3\2\2\2\u013c\u012a\3\2\2\2\u013c\u0136\3\2\2\2\u013c\u013b\3\2\2\2\u013d"+
		"\36\3\2\2\2\u013e\u013f\7L\2\2\u013f\u0140\7Q\2\2\u0140\u0141\7K\2\2\u0141"+
		"\u0148\7P\2\2\u0142\u0143\7l\2\2\u0143\u0144\7q\2\2\u0144\u0145\7k\2\2"+
		"\u0145\u0148\7p\2\2\u0146\u0148\t\3\2\2\u0147\u013e\3\2\2\2\u0147\u0142"+
		"\3\2\2\2\u0147\u0146\3\2\2\2\u0148 \3\2\2\2\u0149\u014a\7F\2\2\u014a\u014b"+
		"\7K\2\2\u014b\u014c\7X\2\2\u014c\u014d\7K\2\2\u014d\u014e\7U\2\2\u014e"+
		"\u014f\7K\2\2\u014f\u0150\7Q\2\2\u0150\u015b\7P\2\2\u0151\u0152\7f\2\2"+
		"\u0152\u0153\7k\2\2\u0153\u0154\7x\2\2\u0154\u0155\7k\2\2\u0155\u0156"+
		"\7u\2\2\u0156\u0157\7k\2\2\u0157\u0158\7q\2\2\u0158\u015b\7p\2\2\u0159"+
		"\u015b\t\4\2\2\u015a\u0149\3\2\2\2\u015a\u0151\3\2\2\2\u015a\u0159\3\2"+
		"\2\2\u015b\"\3\2\2\2\u015c\u015d\7?\2\2\u015d$\3\2\2\2\u015e\u015f\7#"+
		"\2\2\u015f\u0163\7?\2\2\u0160\u0161\7>\2\2\u0161\u0163\7@\2\2\u0162\u015e"+
		"\3\2\2\2\u0162\u0160\3\2\2\2\u0163&\3\2\2\2\u0164\u0165\7@\2\2\u0165("+
		"\3\2\2\2\u0166\u0167\7@\2\2\u0167\u0168\7?\2\2\u0168*\3\2\2\2\u0169\u016a"+
		"\7>\2\2\u016a,\3\2\2\2\u016b\u016c\7>\2\2\u016c\u016d\7?\2\2\u016d.\3"+
		"\2\2\2\u016e\u016f\7C\2\2\u016f\u0170\7P\2\2\u0170\u0176\7F\2\2\u0171"+
		"\u0172\7c\2\2\u0172\u0173\7p\2\2\u0173\u0176\7f\2\2\u0174\u0176\t\5\2"+
		"\2\u0175\u016e\3\2\2\2\u0175\u0171\3\2\2\2\u0175\u0174\3\2\2\2\u0176\60"+
		"\3\2\2\2\u0177\u0178\7Q\2\2\u0178\u017d\7T\2\2\u0179\u017a\7q\2\2\u017a"+
		"\u017d\7t\2\2\u017b\u017d\t\6\2\2\u017c\u0177\3\2\2\2\u017c\u0179\3\2"+
		"\2\2\u017c\u017b\3\2\2\2\u017d\62\3\2\2\2\u017e\u017f\7P\2\2\u017f\u0180"+
		"\7Q\2\2\u0180\u0186\7V\2\2\u0181\u0182\7p\2\2\u0182\u0183\7q\2\2\u0183"+
		"\u0186\7v\2\2\u0184\u0186\7\u0080\2\2\u0185\u017e\3\2\2\2\u0185\u0181"+
		"\3\2\2\2\u0185\u0184\3\2\2\2\u0186\64\3\2\2\2\u0187\u018b\7$\2\2\u0188"+
		"\u018a\13\2\2\2\u0189\u0188\3\2\2\2\u018a\u018d\3\2\2\2\u018b\u018c\3"+
		"\2\2\2\u018b\u0189\3\2\2\2\u018c\u018e\3\2\2\2\u018d\u018b\3\2\2\2\u018e"+
		"\u0198\7$\2\2\u018f\u0193\7)\2\2\u0190\u0192\13\2\2\2\u0191\u0190\3\2"+
		"\2\2\u0192\u0195\3\2\2\2\u0193\u0194\3\2\2\2\u0193\u0191\3\2\2\2\u0194"+
		"\u0196\3\2\2\2\u0195\u0193\3\2\2\2\u0196\u0198\7)\2\2\u0197\u0187\3\2"+
		"\2\2\u0197\u018f\3\2\2\2\u0198\66\3\2\2\2\u0199\u019b\t\7\2\2\u019a\u0199"+
		"\3\2\2\2\u019b\u019c\3\2\2\2\u019c\u019a\3\2\2\2\u019c\u019d\3\2\2\2\u019d"+
		"\u01a1\3\2\2\2\u019e\u01a0\t\b\2\2\u019f\u019e\3\2\2\2\u01a0\u01a3\3\2"+
		"\2\2\u01a1\u019f\3\2\2\2\u01a1\u01a2\3\2\2\2\u01a2\u01b4\3\2\2\2\u01a3"+
		"\u01a1\3\2\2\2\u01a4\u01b0\7\60\2\2\u01a5\u01a7\t\7\2\2\u01a6\u01a5\3"+
		"\2\2\2\u01a7\u01a8\3\2\2\2\u01a8\u01a6\3\2\2\2\u01a8\u01a9\3\2\2\2\u01a9"+
		"\u01ad\3\2\2\2\u01aa\u01ac\t\b\2\2\u01ab\u01aa\3\2\2\2\u01ac\u01af\3\2"+
		"\2\2\u01ad\u01ab\3\2\2\2\u01ad\u01ae\3\2\2\2\u01ae\u01b1\3\2\2\2\u01af"+
		"\u01ad\3\2\2\2\u01b0\u01a6\3\2\2\2\u01b1\u01b2\3\2\2\2\u01b2\u01b0\3\2"+
		"\2\2\u01b2\u01b3\3\2\2\2\u01b3\u01b5\3\2\2\2\u01b4\u01a4\3\2\2\2\u01b4"+
		"\u01b5\3\2\2\2\u01b58\3\2\2\2\u01b6\u01b8\t\t\2\2\u01b7\u01b6\3\2\2\2"+
		"\u01b8\u01b9\3\2\2\2\u01b9\u01b7\3\2\2\2\u01b9\u01ba\3\2\2\2\u01ba:\3"+
		"\2\2\2\u01bb\u01bd\t\n\2\2\u01bc\u01bb\3\2\2\2\u01bd\u01be\3\2\2\2\u01be"+
		"\u01bc\3\2\2\2\u01be\u01bf\3\2\2\2\u01bf\u01c0\3\2\2\2\u01c0\u01c1\b\36"+
		"\2\2\u01c1<\3\2\2\2\u01c2\u01c3\7\61\2\2\u01c3\u01c4\7,\2\2\u01c4\u01c8"+
		"\3\2\2\2\u01c5\u01c7\13\2\2\2\u01c6\u01c5\3\2\2\2\u01c7\u01ca\3\2\2\2"+
		"\u01c8\u01c9\3\2\2\2\u01c8\u01c6\3\2\2\2\u01c9\u01cb\3\2\2\2\u01ca\u01c8"+
		"\3\2\2\2\u01cb\u01cc\7,\2\2\u01cc\u01cd\7\61\2\2\u01cd\u01ce\3\2\2\2\u01ce"+
		"\u01cf\b\37\3\2\u01cf>\3\2\2\2\u01d0\u01d1\7\61\2\2\u01d1\u01d2\7\61\2"+
		"\2\u01d2\u01d6\3\2\2\2\u01d3\u01d5\n\13\2\2\u01d4\u01d3\3\2\2\2\u01d5"+
		"\u01d8\3\2\2\2\u01d6\u01d4\3\2\2\2\u01d6\u01d7\3\2\2\2\u01d7\u01d9\3\2"+
		"\2\2\u01d8\u01d6\3\2\2\2\u01d9\u01da\b \3\2\u01da@\3\2\2\2\37\2s\u0093"+
		"\u00a0\u00b7\u00ea\u0117\u013c\u0147\u015a\u0162\u0175\u017c\u0185\u018b"+
		"\u0193\u0197\u019c\u019f\u01a1\u01a8\u01ab\u01ad\u01b2\u01b4\u01b9\u01be"+
		"\u01c8\u01d6\4\b\2\2\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}