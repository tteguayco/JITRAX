package es.ull.etsii.jitrax.analysisRA;

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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, PROJECTION=9, 
		SELECTION=10, UNION=11, DIFFERENCE=12, CARTESIAN_PRODUCT=13, INTERSECTION=14, 
		NATURAL_JOIN=15, JOIN=16, DIVISION=17, RENAME=18, AS=19, EQUAL=20, NOT_EQUAL=21, 
		GREATER_THAN=22, GREATER_EQUAL=23, LESS_THAN=24, LESS_EQUAL=25, BOOLEAN_AND=26, 
		BOOLEAN_OR=27, BOOLEAN_NOT=28, IDENTIFIER=29, NUMBER=30, WHITESPACES=31;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "PROJECTION", 
		"SELECTION", "UNION", "DIFFERENCE", "CARTESIAN_PRODUCT", "INTERSECTION", 
		"NATURAL_JOIN", "JOIN", "DIVISION", "RENAME", "AS", "EQUAL", "NOT_EQUAL", 
		"GREATER_THAN", "GREATER_EQUAL", "LESS_THAN", "LESS_EQUAL", "BOOLEAN_AND", 
		"BOOLEAN_OR", "BOOLEAN_NOT", "IDENTIFIER", "NUMBER", "WHITESPACES"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';'", "'='", "'('", "')'", "'['", "']'", "','", "'NOT'", null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		"'>'", "'>='", "'<'", "'<='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, "PROJECTION", "SELECTION", 
		"UNION", "DIFFERENCE", "CARTESIAN_PRODUCT", "INTERSECTION", "NATURAL_JOIN", 
		"JOIN", "DIVISION", "RENAME", "AS", "EQUAL", "NOT_EQUAL", "GREATER_THAN", 
		"GREATER_EQUAL", "LESS_THAN", "LESS_EQUAL", "BOOLEAN_AND", "BOOLEAN_OR", 
		"BOOLEAN_NOT", "IDENTIFIER", "NUMBER", "WHITESPACES"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2!\u019b\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \3\2"+
		"\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\5\nl\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5"+
		"\13\u0083\n\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u0090\n"+
		"\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\5\r\u00a7\n\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16"+
		"\u00da\n\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\5\17\u00fb\n\17\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\5\20\u0120\n\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21"+
		"\u012b\n\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\5\22\u013e\n\22\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u014f\n\23\3\24\3\24"+
		"\3\24\3\24\5\24\u0155\n\24\3\25\3\25\3\25\5\25\u015a\n\25\3\26\3\26\3"+
		"\26\3\26\5\26\u0160\n\26\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\32\3\32"+
		"\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\5\33\u0173\n\33\3\34\3\34\3\34"+
		"\3\34\3\34\5\34\u017a\n\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\5\35\u0183"+
		"\n\35\3\36\6\36\u0186\n\36\r\36\16\36\u0187\3\36\7\36\u018b\n\36\f\36"+
		"\16\36\u018e\13\36\3\37\6\37\u0191\n\37\r\37\16\37\u0192\3 \6 \u0196\n"+
		" \r \16 \u0197\3 \3 \2\2!\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25"+
		"\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32"+
		"\63\33\65\34\67\359\36;\37= ?!\3\2\t\4\2ZZzz\4\2[[{{\4\2\61\61\u00f9\u00f9"+
		"\4\2C\\c|\6\2\62;C\\aac|\3\2\62;\5\2\13\f\17\17\"\"\u01c0\2\3\3\2\2\2"+
		"\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2"+
		"\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2"+
		"\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2"+
		"\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2"+
		"\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2"+
		"\2\2\2?\3\2\2\2\3A\3\2\2\2\5C\3\2\2\2\7E\3\2\2\2\tG\3\2\2\2\13I\3\2\2"+
		"\2\rK\3\2\2\2\17M\3\2\2\2\21O\3\2\2\2\23k\3\2\2\2\25\u0082\3\2\2\2\27"+
		"\u008f\3\2\2\2\31\u00a6\3\2\2\2\33\u00d9\3\2\2\2\35\u00fa\3\2\2\2\37\u011f"+
		"\3\2\2\2!\u012a\3\2\2\2#\u013d\3\2\2\2%\u014e\3\2\2\2\'\u0154\3\2\2\2"+
		")\u0159\3\2\2\2+\u015f\3\2\2\2-\u0161\3\2\2\2/\u0163\3\2\2\2\61\u0166"+
		"\3\2\2\2\63\u0168\3\2\2\2\65\u0172\3\2\2\2\67\u0179\3\2\2\29\u0182\3\2"+
		"\2\2;\u0185\3\2\2\2=\u0190\3\2\2\2?\u0195\3\2\2\2AB\7=\2\2B\4\3\2\2\2"+
		"CD\7?\2\2D\6\3\2\2\2EF\7*\2\2F\b\3\2\2\2GH\7+\2\2H\n\3\2\2\2IJ\7]\2\2"+
		"J\f\3\2\2\2KL\7_\2\2L\16\3\2\2\2MN\7.\2\2N\20\3\2\2\2OP\7P\2\2PQ\7Q\2"+
		"\2QR\7V\2\2R\22\3\2\2\2ST\7R\2\2TU\7T\2\2UV\7Q\2\2VW\7L\2\2WX\7G\2\2X"+
		"Y\7E\2\2YZ\7V\2\2Z[\7K\2\2[\\\7Q\2\2\\l\7P\2\2]^\7R\2\2^_\7T\2\2_`\7Q"+
		"\2\2`a\7L\2\2ab\7G\2\2bc\7E\2\2cl\7V\2\2de\7r\2\2ef\7t\2\2fg\7q\2\2gh"+
		"\7l\2\2hi\7g\2\2ij\7e\2\2jl\7v\2\2kS\3\2\2\2k]\3\2\2\2kd\3\2\2\2l\24\3"+
		"\2\2\2mn\7U\2\2no\7G\2\2op\7N\2\2pq\7G\2\2qr\7E\2\2rs\7V\2\2st\7K\2\2"+
		"tu\7Q\2\2u\u0083\7P\2\2vw\7U\2\2wx\7G\2\2xy\7N\2\2yz\7G\2\2z{\7E\2\2{"+
		"\u0083\7V\2\2|}\7u\2\2}~\7g\2\2~\177\7n\2\2\177\u0080\7g\2\2\u0080\u0081"+
		"\7e\2\2\u0081\u0083\7v\2\2\u0082m\3\2\2\2\u0082v\3\2\2\2\u0082|\3\2\2"+
		"\2\u0083\26\3\2\2\2\u0084\u0085\7W\2\2\u0085\u0086\7P\2\2\u0086\u0087"+
		"\7K\2\2\u0087\u0088\7Q\2\2\u0088\u0090\7P\2\2\u0089\u008a\7w\2\2\u008a"+
		"\u008b\7p\2\2\u008b\u008c\7k\2\2\u008c\u008d\7q\2\2\u008d\u0090\7p\2\2"+
		"\u008e\u0090\7W\2\2\u008f\u0084\3\2\2\2\u008f\u0089\3\2\2\2\u008f\u008e"+
		"\3\2\2\2\u0090\30\3\2\2\2\u0091\u0092\7F\2\2\u0092\u0093\7K\2\2\u0093"+
		"\u0094\7H\2\2\u0094\u0095\7H\2\2\u0095\u0096\7G\2\2\u0096\u0097\7T\2\2"+
		"\u0097\u0098\7G\2\2\u0098\u0099\7P\2\2\u0099\u009a\7E\2\2\u009a\u00a7"+
		"\7G\2\2\u009b\u009c\7f\2\2\u009c\u009d\7k\2\2\u009d\u009e\7h\2\2\u009e"+
		"\u009f\7h\2\2\u009f\u00a0\7g\2\2\u00a0\u00a1\7t\2\2\u00a1\u00a2\7g\2\2"+
		"\u00a2\u00a3\7p\2\2\u00a3\u00a4\7e\2\2\u00a4\u00a7\7g\2\2\u00a5\u00a7"+
		"\7/\2\2\u00a6\u0091\3\2\2\2\u00a6\u009b\3\2\2\2\u00a6\u00a5\3\2\2\2\u00a7"+
		"\32\3\2\2\2\u00a8\u00a9\7E\2\2\u00a9\u00aa\7C\2\2\u00aa\u00ab\7T\2\2\u00ab"+
		"\u00ac\7V\2\2\u00ac\u00ad\7G\2\2\u00ad\u00ae\7U\2\2\u00ae\u00af\7K\2\2"+
		"\u00af\u00b0\7C\2\2\u00b0\u00b1\7P\2\2\u00b1\u00b2\7\"\2\2\u00b2\u00b3"+
		"\7R\2\2\u00b3\u00b4\7T\2\2\u00b4\u00b5\7Q\2\2\u00b5\u00b6\7F\2\2\u00b6"+
		"\u00b7\7W\2\2\u00b7\u00b8\7E\2\2\u00b8\u00da\7V\2\2\u00b9\u00ba\7e\2\2"+
		"\u00ba\u00bb\7c\2\2\u00bb\u00bc\7t\2\2\u00bc\u00bd\7v\2\2\u00bd\u00be"+
		"\7g\2\2\u00be\u00bf\7u\2\2\u00bf\u00c0\7k\2\2\u00c0\u00c1\7c\2\2\u00c1"+
		"\u00c2\7p\2\2\u00c2\u00c3\7\"\2\2\u00c3\u00c4\7r\2\2\u00c4\u00c5\7t\2"+
		"\2\u00c5\u00c6\7q\2\2\u00c6\u00c7\7f\2\2\u00c7\u00c8\7w\2\2\u00c8\u00c9"+
		"\7e\2\2\u00c9\u00da\7v\2\2\u00ca\u00cb\7R\2\2\u00cb\u00cc\7T\2\2\u00cc"+
		"\u00cd\7Q\2\2\u00cd\u00ce\7F\2\2\u00ce\u00cf\7W\2\2\u00cf\u00d0\7E\2\2"+
		"\u00d0\u00da\7V\2\2\u00d1\u00d2\7r\2\2\u00d2\u00d3\7t\2\2\u00d3\u00d4"+
		"\7q\2\2\u00d4\u00d5\7f\2\2\u00d5\u00d6\7w\2\2\u00d6\u00d7\7e\2\2\u00d7"+
		"\u00da\7v\2\2\u00d8\u00da\t\2\2\2\u00d9\u00a8\3\2\2\2\u00d9\u00b9\3\2"+
		"\2\2\u00d9\u00ca\3\2\2\2\u00d9\u00d1\3\2\2\2\u00d9\u00d8\3\2\2\2\u00da"+
		"\34\3\2\2\2\u00db\u00dc\7K\2\2\u00dc\u00dd\7P\2\2\u00dd\u00de\7V\2\2\u00de"+
		"\u00df\7G\2\2\u00df\u00e0\7T\2\2\u00e0\u00e1\7U\2\2\u00e1\u00e2\7G\2\2"+
		"\u00e2\u00e3\7E\2\2\u00e3\u00e4\7V\2\2\u00e4\u00e5\7K\2\2\u00e5\u00e6"+
		"\7Q\2\2\u00e6\u00fb\7P\2\2\u00e7\u00e8\7K\2\2\u00e8\u00e9\7P\2\2\u00e9"+
		"\u00ea\7V\2\2\u00ea\u00eb\7G\2\2\u00eb\u00ec\7T\2\2\u00ec\u00ed\7U\2\2"+
		"\u00ed\u00ee\7G\2\2\u00ee\u00ef\7E\2\2\u00ef\u00fb\7V\2\2\u00f0\u00f1"+
		"\7k\2\2\u00f1\u00f2\7p\2\2\u00f2\u00f3\7v\2\2\u00f3\u00f4\7g\2\2\u00f4"+
		"\u00f5\7t\2\2\u00f5\u00f6\7u\2\2\u00f6\u00f7\7g\2\2\u00f7\u00f8\7e\2\2"+
		"\u00f8\u00fb\7v\2\2\u00f9\u00fb\7\u222b\2\2\u00fa\u00db\3\2\2\2\u00fa"+
		"\u00e7\3\2\2\2\u00fa\u00f0\3\2\2\2\u00fa\u00f9\3\2\2\2\u00fb\36\3\2\2"+
		"\2\u00fc\u00fd\7P\2\2\u00fd\u00fe\7C\2\2\u00fe\u00ff\7V\2\2\u00ff\u0100"+
		"\7W\2\2\u0100\u0101\7T\2\2\u0101\u0102\7C\2\2\u0102\u0103\7N\2\2\u0103"+
		"\u0104\7\"\2\2\u0104\u0105\7L\2\2\u0105\u0106\7Q\2\2\u0106\u0107\7K\2"+
		"\2\u0107\u0120\7P\2\2\u0108\u0109\7P\2\2\u0109\u010a\7L\2\2\u010a\u010b"+
		"\7Q\2\2\u010b\u010c\7K\2\2\u010c\u0120\7P\2\2\u010d\u010e\7p\2\2\u010e"+
		"\u010f\7c\2\2\u010f\u0110\7v\2\2\u0110\u0111\7w\2\2\u0111\u0112\7t\2\2"+
		"\u0112\u0113\7c\2\2\u0113\u0114\7n\2\2\u0114\u0115\7\"\2\2\u0115\u0116"+
		"\7l\2\2\u0116\u0117\7q\2\2\u0117\u0118\7k\2\2\u0118\u0120\7p\2\2\u0119"+
		"\u011a\7p\2\2\u011a\u011b\7l\2\2\u011b\u011c\7q\2\2\u011c\u011d\7k\2\2"+
		"\u011d\u0120\7p\2\2\u011e\u0120\7,\2\2\u011f\u00fc\3\2\2\2\u011f\u0108"+
		"\3\2\2\2\u011f\u010d\3\2\2\2\u011f\u0119\3\2\2\2\u011f\u011e\3\2\2\2\u0120"+
		" \3\2\2\2\u0121\u0122\7L\2\2\u0122\u0123\7Q\2\2\u0123\u0124\7K\2\2\u0124"+
		"\u012b\7P\2\2\u0125\u0126\7l\2\2\u0126\u0127\7q\2\2\u0127\u0128\7k\2\2"+
		"\u0128\u012b\7p\2\2\u0129\u012b\t\3\2\2\u012a\u0121\3\2\2\2\u012a\u0125"+
		"\3\2\2\2\u012a\u0129\3\2\2\2\u012b\"\3\2\2\2\u012c\u012d\7F\2\2\u012d"+
		"\u012e\7K\2\2\u012e\u012f\7X\2\2\u012f\u0130\7K\2\2\u0130\u0131\7U\2\2"+
		"\u0131\u0132\7K\2\2\u0132\u0133\7Q\2\2\u0133\u013e\7P\2\2\u0134\u0135"+
		"\7f\2\2\u0135\u0136\7k\2\2\u0136\u0137\7x\2\2\u0137\u0138\7k\2\2\u0138"+
		"\u0139\7u\2\2\u0139\u013a\7k\2\2\u013a\u013b\7q\2\2\u013b\u013e\7p\2\2"+
		"\u013c\u013e\t\4\2\2\u013d\u012c\3\2\2\2\u013d\u0134\3\2\2\2\u013d\u013c"+
		"\3\2\2\2\u013e$\3\2\2\2\u013f\u0140\7T\2\2\u0140\u0141\7G\2\2\u0141\u0142"+
		"\7P\2\2\u0142\u0143\7C\2\2\u0143\u0144\7O\2\2\u0144\u014f\7G\2\2\u0145"+
		"\u0146\7t\2\2\u0146\u0147\7g\2\2\u0147\u0148\7p\2\2\u0148\u0149\7c\2\2"+
		"\u0149\u014a\7o\2\2\u014a\u014f\7g\2\2\u014b\u014c\7T\2\2\u014c\u014d"+
		"\7G\2\2\u014d\u014f\7P\2\2\u014e\u013f\3\2\2\2\u014e\u0145\3\2\2\2\u014e"+
		"\u014b\3\2\2\2\u014f&\3\2\2\2\u0150\u0151\7C\2\2\u0151\u0155\7U\2\2\u0152"+
		"\u0153\7c\2\2\u0153\u0155\7u\2\2\u0154\u0150\3\2\2\2\u0154\u0152\3\2\2"+
		"\2\u0155(\3\2\2\2\u0156\u015a\7?\2\2\u0157\u0158\7?\2\2\u0158\u015a\7"+
		"?\2\2\u0159\u0156\3\2\2\2\u0159\u0157\3\2\2\2\u015a*\3\2\2\2\u015b\u015c"+
		"\7>\2\2\u015c\u0160\7@\2\2\u015d\u015e\7#\2\2\u015e\u0160\7?\2\2\u015f"+
		"\u015b\3\2\2\2\u015f\u015d\3\2\2\2\u0160,\3\2\2\2\u0161\u0162\7@\2\2\u0162"+
		".\3\2\2\2\u0163\u0164\7@\2\2\u0164\u0165\7?\2\2\u0165\60\3\2\2\2\u0166"+
		"\u0167\7>\2\2\u0167\62\3\2\2\2\u0168\u0169\7>\2\2\u0169\u016a\7?\2\2\u016a"+
		"\64\3\2\2\2\u016b\u016c\7C\2\2\u016c\u016d\7P\2\2\u016d\u0173\7F\2\2\u016e"+
		"\u016f\7c\2\2\u016f\u0170\7p\2\2\u0170\u0173\7f\2\2\u0171\u0173\7(\2\2"+
		"\u0172\u016b\3\2\2\2\u0172\u016e\3\2\2\2\u0172\u0171\3\2\2\2\u0173\66"+
		"\3\2\2\2\u0174\u0175\7Q\2\2\u0175\u017a\7T\2\2\u0176\u0177\7q\2\2\u0177"+
		"\u017a\7t\2\2\u0178\u017a\7~\2\2\u0179\u0174\3\2\2\2\u0179\u0176\3\2\2"+
		"\2\u0179\u0178\3\2\2\2\u017a8\3\2\2\2\u017b\u017c\7P\2\2\u017c\u017d\7"+
		"Q\2\2\u017d\u0183\7V\2\2\u017e\u017f\7p\2\2\u017f\u0180\7q\2\2\u0180\u0183"+
		"\7v\2\2\u0181\u0183\7\u0080\2\2\u0182\u017b\3\2\2\2\u0182\u017e\3\2\2"+
		"\2\u0182\u0181\3\2\2\2\u0183:\3\2\2\2\u0184\u0186\t\5\2\2\u0185\u0184"+
		"\3\2\2\2\u0186\u0187\3\2\2\2\u0187\u0185\3\2\2\2\u0187\u0188\3\2\2\2\u0188"+
		"\u018c\3\2\2\2\u0189\u018b\t\6\2\2\u018a\u0189\3\2\2\2\u018b\u018e\3\2"+
		"\2\2\u018c\u018a\3\2\2\2\u018c\u018d\3\2\2\2\u018d<\3\2\2\2\u018e\u018c"+
		"\3\2\2\2\u018f\u0191\t\7\2\2\u0190\u018f\3\2\2\2\u0191\u0192\3\2\2\2\u0192"+
		"\u0190\3\2\2\2\u0192\u0193\3\2\2\2\u0193>\3\2\2\2\u0194\u0196\t\b\2\2"+
		"\u0195\u0194\3\2\2\2\u0196\u0197\3\2\2\2\u0197\u0195\3\2\2\2\u0197\u0198"+
		"\3\2\2\2\u0198\u0199\3\2\2\2\u0199\u019a\b \2\2\u019a@\3\2\2\2\30\2k\u0082"+
		"\u008f\u00a6\u00d9\u00fa\u011f\u012a\u013d\u014e\u0154\u0159\u015f\u0172"+
		"\u0179\u0182\u0187\u018a\u018c\u0192\u0197\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}