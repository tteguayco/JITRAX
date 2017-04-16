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
		NATURAL_JOIN=14, JOIN=15, DIVISION=16, RENAME=17, AS=18, EQUAL=19, NOT_EQUAL=20, 
		GREATER_THAN=21, GREATER_EQUAL=22, LESS_THAN=23, LESS_EQUAL=24, BOOLEAN_AND=25, 
		BOOLEAN_OR=26, BOOLEAN_NOT=27, STRING=28, IDENTIFIER=29, NUMBER=30, WHITESPACES=31, 
		COMMENT=32, LINE_COMMENT=33;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "PROJECTION", 
		"SELECTION", "UNION", "DIFFERENCE", "CARTESIAN_PRODUCT", "INTERSECTION", 
		"NATURAL_JOIN", "JOIN", "DIVISION", "RENAME", "AS", "EQUAL", "NOT_EQUAL", 
		"GREATER_THAN", "GREATER_EQUAL", "LESS_THAN", "LESS_EQUAL", "BOOLEAN_AND", 
		"BOOLEAN_OR", "BOOLEAN_NOT", "STRING", "IDENTIFIER", "NUMBER", "WHITESPACES", 
		"COMMENT", "LINE_COMMENT"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';'", "'('", "')'", "'['", "']'", "','", "'NOT'", null, null, null, 
		null, null, null, null, null, null, null, null, "'='", null, "'>'", "'>='", 
		"'<'", "'<='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, "PROJECTION", "SELECTION", 
		"UNION", "DIFFERENCE", "CARTESIAN_PRODUCT", "INTERSECTION", "NATURAL_JOIN", 
		"JOIN", "DIVISION", "RENAME", "AS", "EQUAL", "NOT_EQUAL", "GREATER_THAN", 
		"GREATER_EQUAL", "LESS_THAN", "LESS_EQUAL", "BOOLEAN_AND", "BOOLEAN_OR", 
		"BOOLEAN_NOT", "STRING", "IDENTIFIER", "NUMBER", "WHITESPACES", "COMMENT", 
		"LINE_COMMENT"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2#\u01f7\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3"+
		"\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\5\tx\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u0098"+
		"\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00a5"+
		"\n\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\5\f\u00bc\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\5\r\u00ef\n\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u011c\n\16\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\5\17\u0141\n\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\5\20\u014c\n\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u015f\n\21\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\5\22\u0173\n\22\3\23\3\23\3\23\3\23\5\23\u0179\n\23\3\24\3\24\3"+
		"\25\3\25\3\25\3\25\5\25\u0181\n\25\3\26\3\26\3\27\3\27\3\27\3\30\3\30"+
		"\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u0194\n\32\3\33"+
		"\3\33\3\33\3\33\3\33\5\33\u019b\n\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34"+
		"\5\34\u01a4\n\34\3\35\3\35\7\35\u01a8\n\35\f\35\16\35\u01ab\13\35\3\35"+
		"\3\35\3\35\7\35\u01b0\n\35\f\35\16\35\u01b3\13\35\3\35\5\35\u01b6\n\35"+
		"\3\36\6\36\u01b9\n\36\r\36\16\36\u01ba\3\36\7\36\u01be\n\36\f\36\16\36"+
		"\u01c1\13\36\3\36\3\36\6\36\u01c5\n\36\r\36\16\36\u01c6\3\36\5\36\u01ca"+
		"\n\36\7\36\u01cc\n\36\f\36\16\36\u01cf\13\36\5\36\u01d1\n\36\3\37\6\37"+
		"\u01d4\n\37\r\37\16\37\u01d5\3 \6 \u01d9\n \r \16 \u01da\3 \3 \3!\3!\3"+
		"!\3!\7!\u01e3\n!\f!\16!\u01e6\13!\3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\7\"\u01f1"+
		"\n\"\f\"\16\"\u01f4\13\"\3\"\3\"\5\u01a9\u01b1\u01e4\2#\3\3\5\4\7\5\t"+
		"\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23"+
		"%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#\3\2"+
		"\f\4\2ZZzz\4\2[[{{\4\2\61\61\u00f9\u00f9\4\2((``\4\2xx~~\4\2C\\c|\6\2"+
		"\62;C\\aac|\3\2\62;\5\2\13\f\17\17\"\"\4\2\f\f\17\17\u0227\2\3\3\2\2\2"+
		"\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2"+
		"\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2"+
		"\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2"+
		"\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2"+
		"\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2"+
		"\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\3E\3\2\2\2\5G\3\2\2\2\7I\3\2\2\2"+
		"\tK\3\2\2\2\13M\3\2\2\2\rO\3\2\2\2\17Q\3\2\2\2\21w\3\2\2\2\23\u0097\3"+
		"\2\2\2\25\u00a4\3\2\2\2\27\u00bb\3\2\2\2\31\u00ee\3\2\2\2\33\u011b\3\2"+
		"\2\2\35\u0140\3\2\2\2\37\u014b\3\2\2\2!\u015e\3\2\2\2#\u0172\3\2\2\2%"+
		"\u0178\3\2\2\2\'\u017a\3\2\2\2)\u0180\3\2\2\2+\u0182\3\2\2\2-\u0184\3"+
		"\2\2\2/\u0187\3\2\2\2\61\u0189\3\2\2\2\63\u0193\3\2\2\2\65\u019a\3\2\2"+
		"\2\67\u01a3\3\2\2\29\u01b5\3\2\2\2;\u01b8\3\2\2\2=\u01d3\3\2\2\2?\u01d8"+
		"\3\2\2\2A\u01de\3\2\2\2C\u01ec\3\2\2\2EF\7=\2\2F\4\3\2\2\2GH\7*\2\2H\6"+
		"\3\2\2\2IJ\7+\2\2J\b\3\2\2\2KL\7]\2\2L\n\3\2\2\2MN\7_\2\2N\f\3\2\2\2O"+
		"P\7.\2\2P\16\3\2\2\2QR\7P\2\2RS\7Q\2\2ST\7V\2\2T\20\3\2\2\2UV\7R\2\2V"+
		"W\7T\2\2WX\7Q\2\2XY\7L\2\2YZ\7G\2\2Z[\7E\2\2[\\\7V\2\2\\]\7K\2\2]^\7Q"+
		"\2\2^x\7P\2\2_`\7r\2\2`a\7t\2\2ab\7q\2\2bc\7l\2\2cd\7g\2\2de\7e\2\2ef"+
		"\7v\2\2fg\7k\2\2gh\7q\2\2hx\7p\2\2ij\7R\2\2jk\7T\2\2kl\7Q\2\2lm\7L\2\2"+
		"mn\7G\2\2no\7E\2\2ox\7V\2\2pq\7r\2\2qr\7t\2\2rs\7q\2\2st\7l\2\2tu\7g\2"+
		"\2uv\7e\2\2vx\7v\2\2wU\3\2\2\2w_\3\2\2\2wi\3\2\2\2wp\3\2\2\2x\22\3\2\2"+
		"\2yz\7U\2\2z{\7G\2\2{|\7N\2\2|}\7G\2\2}~\7E\2\2~\177\7V\2\2\177\u0080"+
		"\7K\2\2\u0080\u0081\7Q\2\2\u0081\u0098\7P\2\2\u0082\u0083\7u\2\2\u0083"+
		"\u0084\7g\2\2\u0084\u0085\7n\2\2\u0085\u0086\7g\2\2\u0086\u0087\7e\2\2"+
		"\u0087\u0088\7v\2\2\u0088\u0089\7k\2\2\u0089\u008a\7q\2\2\u008a\u0098"+
		"\7p\2\2\u008b\u008c\7U\2\2\u008c\u008d\7G\2\2\u008d\u008e\7N\2\2\u008e"+
		"\u008f\7G\2\2\u008f\u0090\7E\2\2\u0090\u0098\7V\2\2\u0091\u0092\7u\2\2"+
		"\u0092\u0093\7g\2\2\u0093\u0094\7n\2\2\u0094\u0095\7g\2\2\u0095\u0096"+
		"\7e\2\2\u0096\u0098\7v\2\2\u0097y\3\2\2\2\u0097\u0082\3\2\2\2\u0097\u008b"+
		"\3\2\2\2\u0097\u0091\3\2\2\2\u0098\24\3\2\2\2\u0099\u009a\7W\2\2\u009a"+
		"\u009b\7P\2\2\u009b\u009c\7K\2\2\u009c\u009d\7Q\2\2\u009d\u00a5\7P\2\2"+
		"\u009e\u009f\7w\2\2\u009f\u00a0\7p\2\2\u00a0\u00a1\7k\2\2\u00a1\u00a2"+
		"\7q\2\2\u00a2\u00a5\7p\2\2\u00a3\u00a5\7W\2\2\u00a4\u0099\3\2\2\2\u00a4"+
		"\u009e\3\2\2\2\u00a4\u00a3\3\2\2\2\u00a5\26\3\2\2\2\u00a6\u00a7\7F\2\2"+
		"\u00a7\u00a8\7K\2\2\u00a8\u00a9\7H\2\2\u00a9\u00aa\7H\2\2\u00aa\u00ab"+
		"\7G\2\2\u00ab\u00ac\7T\2\2\u00ac\u00ad\7G\2\2\u00ad\u00ae\7P\2\2\u00ae"+
		"\u00af\7E\2\2\u00af\u00bc\7G\2\2\u00b0\u00b1\7f\2\2\u00b1\u00b2\7k\2\2"+
		"\u00b2\u00b3\7h\2\2\u00b3\u00b4\7h\2\2\u00b4\u00b5\7g\2\2\u00b5\u00b6"+
		"\7t\2\2\u00b6\u00b7\7g\2\2\u00b7\u00b8\7p\2\2\u00b8\u00b9\7e\2\2\u00b9"+
		"\u00bc\7g\2\2\u00ba\u00bc\7/\2\2\u00bb\u00a6\3\2\2\2\u00bb\u00b0\3\2\2"+
		"\2\u00bb\u00ba\3\2\2\2\u00bc\30\3\2\2\2\u00bd\u00be\7E\2\2\u00be\u00bf"+
		"\7C\2\2\u00bf\u00c0\7T\2\2\u00c0\u00c1\7V\2\2\u00c1\u00c2\7G\2\2\u00c2"+
		"\u00c3\7U\2\2\u00c3\u00c4\7K\2\2\u00c4\u00c5\7C\2\2\u00c5\u00c6\7P\2\2"+
		"\u00c6\u00c7\7\"\2\2\u00c7\u00c8\7R\2\2\u00c8\u00c9\7T\2\2\u00c9\u00ca"+
		"\7Q\2\2\u00ca\u00cb\7F\2\2\u00cb\u00cc\7W\2\2\u00cc\u00cd\7E\2\2\u00cd"+
		"\u00ef\7V\2\2\u00ce\u00cf\7e\2\2\u00cf\u00d0\7c\2\2\u00d0\u00d1\7t\2\2"+
		"\u00d1\u00d2\7v\2\2\u00d2\u00d3\7g\2\2\u00d3\u00d4\7u\2\2\u00d4\u00d5"+
		"\7k\2\2\u00d5\u00d6\7c\2\2\u00d6\u00d7\7p\2\2\u00d7\u00d8\7\"\2\2\u00d8"+
		"\u00d9\7r\2\2\u00d9\u00da\7t\2\2\u00da\u00db\7q\2\2\u00db\u00dc\7f\2\2"+
		"\u00dc\u00dd\7w\2\2\u00dd\u00de\7e\2\2\u00de\u00ef\7v\2\2\u00df\u00e0"+
		"\7R\2\2\u00e0\u00e1\7T\2\2\u00e1\u00e2\7Q\2\2\u00e2\u00e3\7F\2\2\u00e3"+
		"\u00e4\7W\2\2\u00e4\u00e5\7E\2\2\u00e5\u00ef\7V\2\2\u00e6\u00e7\7r\2\2"+
		"\u00e7\u00e8\7t\2\2\u00e8\u00e9\7q\2\2\u00e9\u00ea\7f\2\2\u00ea\u00eb"+
		"\7w\2\2\u00eb\u00ec\7e\2\2\u00ec\u00ef\7v\2\2\u00ed\u00ef\t\2\2\2\u00ee"+
		"\u00bd\3\2\2\2\u00ee\u00ce\3\2\2\2\u00ee\u00df\3\2\2\2\u00ee\u00e6\3\2"+
		"\2\2\u00ee\u00ed\3\2\2\2\u00ef\32\3\2\2\2\u00f0\u00f1\7K\2\2\u00f1\u00f2"+
		"\7P\2\2\u00f2\u00f3\7V\2\2\u00f3\u00f4\7G\2\2\u00f4\u00f5\7T\2\2\u00f5"+
		"\u00f6\7U\2\2\u00f6\u00f7\7G\2\2\u00f7\u00f8\7E\2\2\u00f8\u00f9\7V\2\2"+
		"\u00f9\u00fa\7K\2\2\u00fa\u00fb\7Q\2\2\u00fb\u011c\7P\2\2\u00fc\u00fd"+
		"\7k\2\2\u00fd\u00fe\7p\2\2\u00fe\u00ff\7v\2\2\u00ff\u0100\7g\2\2\u0100"+
		"\u0101\7t\2\2\u0101\u0102\7u\2\2\u0102\u0103\7g\2\2\u0103\u0104\7e\2\2"+
		"\u0104\u0105\7v\2\2\u0105\u0106\7k\2\2\u0106\u0107\7q\2\2\u0107\u011c"+
		"\7p\2\2\u0108\u0109\7K\2\2\u0109\u010a\7P\2\2\u010a\u010b\7V\2\2\u010b"+
		"\u010c\7G\2\2\u010c\u010d\7T\2\2\u010d\u010e\7U\2\2\u010e\u010f\7G\2\2"+
		"\u010f\u0110\7E\2\2\u0110\u011c\7V\2\2\u0111\u0112\7k\2\2\u0112\u0113"+
		"\7p\2\2\u0113\u0114\7v\2\2\u0114\u0115\7g\2\2\u0115\u0116\7t\2\2\u0116"+
		"\u0117\7u\2\2\u0117\u0118\7g\2\2\u0118\u0119\7e\2\2\u0119\u011c\7v\2\2"+
		"\u011a\u011c\7\u222b\2\2\u011b\u00f0\3\2\2\2\u011b\u00fc\3\2\2\2\u011b"+
		"\u0108\3\2\2\2\u011b\u0111\3\2\2\2\u011b\u011a\3\2\2\2\u011c\34\3\2\2"+
		"\2\u011d\u011e\7P\2\2\u011e\u011f\7C\2\2\u011f\u0120\7V\2\2\u0120\u0121"+
		"\7W\2\2\u0121\u0122\7T\2\2\u0122\u0123\7C\2\2\u0123\u0124\7N\2\2\u0124"+
		"\u0125\7\"\2\2\u0125\u0126\7L\2\2\u0126\u0127\7Q\2\2\u0127\u0128\7K\2"+
		"\2\u0128\u0141\7P\2\2\u0129\u012a\7P\2\2\u012a\u012b\7L\2\2\u012b\u012c"+
		"\7Q\2\2\u012c\u012d\7K\2\2\u012d\u0141\7P\2\2\u012e\u012f\7p\2\2\u012f"+
		"\u0130\7c\2\2\u0130\u0131\7v\2\2\u0131\u0132\7w\2\2\u0132\u0133\7t\2\2"+
		"\u0133\u0134\7c\2\2\u0134\u0135\7n\2\2\u0135\u0136\7\"\2\2\u0136\u0137"+
		"\7l\2\2\u0137\u0138\7q\2\2\u0138\u0139\7k\2\2\u0139\u0141\7p\2\2\u013a"+
		"\u013b\7p\2\2\u013b\u013c\7l\2\2\u013c\u013d\7q\2\2\u013d\u013e\7k\2\2"+
		"\u013e\u0141\7p\2\2\u013f\u0141\7,\2\2\u0140\u011d\3\2\2\2\u0140\u0129"+
		"\3\2\2\2\u0140\u012e\3\2\2\2\u0140\u013a\3\2\2\2\u0140\u013f\3\2\2\2\u0141"+
		"\36\3\2\2\2\u0142\u0143\7L\2\2\u0143\u0144\7Q\2\2\u0144\u0145\7K\2\2\u0145"+
		"\u014c\7P\2\2\u0146\u0147\7l\2\2\u0147\u0148\7q\2\2\u0148\u0149\7k\2\2"+
		"\u0149\u014c\7p\2\2\u014a\u014c\t\3\2\2\u014b\u0142\3\2\2\2\u014b\u0146"+
		"\3\2\2\2\u014b\u014a\3\2\2\2\u014c \3\2\2\2\u014d\u014e\7F\2\2\u014e\u014f"+
		"\7K\2\2\u014f\u0150\7X\2\2\u0150\u0151\7K\2\2\u0151\u0152\7U\2\2\u0152"+
		"\u0153\7K\2\2\u0153\u0154\7Q\2\2\u0154\u015f\7P\2\2\u0155\u0156\7f\2\2"+
		"\u0156\u0157\7k\2\2\u0157\u0158\7x\2\2\u0158\u0159\7k\2\2\u0159\u015a"+
		"\7u\2\2\u015a\u015b\7k\2\2\u015b\u015c\7q\2\2\u015c\u015f\7p\2\2\u015d"+
		"\u015f\t\4\2\2\u015e\u014d\3\2\2\2\u015e\u0155\3\2\2\2\u015e\u015d\3\2"+
		"\2\2\u015f\"\3\2\2\2\u0160\u0161\7T\2\2\u0161\u0162\7G\2\2\u0162\u0163"+
		"\7P\2\2\u0163\u0164\7C\2\2\u0164\u0165\7O\2\2\u0165\u0173\7G\2\2\u0166"+
		"\u0167\7t\2\2\u0167\u0168\7g\2\2\u0168\u0169\7p\2\2\u0169\u016a\7c\2\2"+
		"\u016a\u016b\7o\2\2\u016b\u0173\7g\2\2\u016c\u016d\7T\2\2\u016d\u016e"+
		"\7G\2\2\u016e\u0173\7P\2\2\u016f\u0170\7t\2\2\u0170\u0171\7g\2\2\u0171"+
		"\u0173\7p\2\2\u0172\u0160\3\2\2\2\u0172\u0166\3\2\2\2\u0172\u016c\3\2"+
		"\2\2\u0172\u016f\3\2\2\2\u0173$\3\2\2\2\u0174\u0175\7C\2\2\u0175\u0179"+
		"\7U\2\2\u0176\u0177\7c\2\2\u0177\u0179\7u\2\2\u0178\u0174\3\2\2\2\u0178"+
		"\u0176\3\2\2\2\u0179&\3\2\2\2\u017a\u017b\7?\2\2\u017b(\3\2\2\2\u017c"+
		"\u017d\7#\2\2\u017d\u0181\7?\2\2\u017e\u017f\7>\2\2\u017f\u0181\7@\2\2"+
		"\u0180\u017c\3\2\2\2\u0180\u017e\3\2\2\2\u0181*\3\2\2\2\u0182\u0183\7"+
		"@\2\2\u0183,\3\2\2\2\u0184\u0185\7@\2\2\u0185\u0186\7?\2\2\u0186.\3\2"+
		"\2\2\u0187\u0188\7>\2\2\u0188\60\3\2\2\2\u0189\u018a\7>\2\2\u018a\u018b"+
		"\7?\2\2\u018b\62\3\2\2\2\u018c\u018d\7C\2\2\u018d\u018e\7P\2\2\u018e\u0194"+
		"\7F\2\2\u018f\u0190\7c\2\2\u0190\u0191\7p\2\2\u0191\u0194\7f\2\2\u0192"+
		"\u0194\t\5\2\2\u0193\u018c\3\2\2\2\u0193\u018f\3\2\2\2\u0193\u0192\3\2"+
		"\2\2\u0194\64\3\2\2\2\u0195\u0196\7Q\2\2\u0196\u019b\7T\2\2\u0197\u0198"+
		"\7q\2\2\u0198\u019b\7t\2\2\u0199\u019b\t\6\2\2\u019a\u0195\3\2\2\2\u019a"+
		"\u0197\3\2\2\2\u019a\u0199\3\2\2\2\u019b\66\3\2\2\2\u019c\u019d\7P\2\2"+
		"\u019d\u019e\7Q\2\2\u019e\u01a4\7V\2\2\u019f\u01a0\7p\2\2\u01a0\u01a1"+
		"\7q\2\2\u01a1\u01a4\7v\2\2\u01a2\u01a4\7\u0080\2\2\u01a3\u019c\3\2\2\2"+
		"\u01a3\u019f\3\2\2\2\u01a3\u01a2\3\2\2\2\u01a48\3\2\2\2\u01a5\u01a9\7"+
		"$\2\2\u01a6\u01a8\13\2\2\2\u01a7\u01a6\3\2\2\2\u01a8\u01ab\3\2\2\2\u01a9"+
		"\u01aa\3\2\2\2\u01a9\u01a7\3\2\2\2\u01aa\u01ac\3\2\2\2\u01ab\u01a9\3\2"+
		"\2\2\u01ac\u01b6\7$\2\2\u01ad\u01b1\7)\2\2\u01ae\u01b0\13\2\2\2\u01af"+
		"\u01ae\3\2\2\2\u01b0\u01b3\3\2\2\2\u01b1\u01b2\3\2\2\2\u01b1\u01af\3\2"+
		"\2\2\u01b2\u01b4\3\2\2\2\u01b3\u01b1\3\2\2\2\u01b4\u01b6\7)\2\2\u01b5"+
		"\u01a5\3\2\2\2\u01b5\u01ad\3\2\2\2\u01b6:\3\2\2\2\u01b7\u01b9\t\7\2\2"+
		"\u01b8\u01b7\3\2\2\2\u01b9\u01ba\3\2\2\2\u01ba\u01b8\3\2\2\2\u01ba\u01bb"+
		"\3\2\2\2\u01bb\u01bf\3\2\2\2\u01bc\u01be\t\b\2\2\u01bd\u01bc\3\2\2\2\u01be"+
		"\u01c1\3\2\2\2\u01bf\u01bd\3\2\2\2\u01bf\u01c0\3\2\2\2\u01c0\u01d0\3\2"+
		"\2\2\u01c1\u01bf\3\2\2\2\u01c2\u01cd\7\60\2\2\u01c3\u01c5\t\7\2\2\u01c4"+
		"\u01c3\3\2\2\2\u01c5\u01c6\3\2\2\2\u01c6\u01c4\3\2\2\2\u01c6\u01c7\3\2"+
		"\2\2\u01c7\u01c9\3\2\2\2\u01c8\u01ca\t\b\2\2\u01c9\u01c8\3\2\2\2\u01ca"+
		"\u01cc\3\2\2\2\u01cb\u01c4\3\2\2\2\u01cc\u01cf\3\2\2\2\u01cd\u01cb\3\2"+
		"\2\2\u01cd\u01ce\3\2\2\2\u01ce\u01d1\3\2\2\2\u01cf\u01cd\3\2\2\2\u01d0"+
		"\u01c2\3\2\2\2\u01d0\u01d1\3\2\2\2\u01d1<\3\2\2\2\u01d2\u01d4\t\t\2\2"+
		"\u01d3\u01d2\3\2\2\2\u01d4\u01d5\3\2\2\2\u01d5\u01d3\3\2\2\2\u01d5\u01d6"+
		"\3\2\2\2\u01d6>\3\2\2\2\u01d7\u01d9\t\n\2\2\u01d8\u01d7\3\2\2\2\u01d9"+
		"\u01da\3\2\2\2\u01da\u01d8\3\2\2\2\u01da\u01db\3\2\2\2\u01db\u01dc\3\2"+
		"\2\2\u01dc\u01dd\b \2\2\u01dd@\3\2\2\2\u01de\u01df\7\61\2\2\u01df\u01e0"+
		"\7,\2\2\u01e0\u01e4\3\2\2\2\u01e1\u01e3\13\2\2\2\u01e2\u01e1\3\2\2\2\u01e3"+
		"\u01e6\3\2\2\2\u01e4\u01e5\3\2\2\2\u01e4\u01e2\3\2\2\2\u01e5\u01e7\3\2"+
		"\2\2\u01e6\u01e4\3\2\2\2\u01e7\u01e8\7,\2\2\u01e8\u01e9\7\61\2\2\u01e9"+
		"\u01ea\3\2\2\2\u01ea\u01eb\b!\3\2\u01ebB\3\2\2\2\u01ec\u01ed\7\61\2\2"+
		"\u01ed\u01ee\7\61\2\2\u01ee\u01f2\3\2\2\2\u01ef\u01f1\n\13\2\2\u01f0\u01ef"+
		"\3\2\2\2\u01f1\u01f4\3\2\2\2\u01f2\u01f0\3\2\2\2\u01f2\u01f3\3\2\2\2\u01f3"+
		"\u01f5\3\2\2\2\u01f4\u01f2\3\2\2\2\u01f5\u01f6\b\"\3\2\u01f6D\3\2\2\2"+
		" \2w\u0097\u00a4\u00bb\u00ee\u011b\u0140\u014b\u015e\u0172\u0178\u0180"+
		"\u0193\u019a\u01a3\u01a9\u01b1\u01b5\u01ba\u01bd\u01bf\u01c6\u01c9\u01cd"+
		"\u01d0\u01d5\u01da\u01e4\u01f2\4\b\2\2\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}