package es.ull.etsii.jitrax.analysisRelationalAlgebra;

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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, PROJECTION=12, SELECTION=13, UNION=14, DIFFERENCE=15, 
		CARTESIAN_PRODUCT=16, INTERSECTION=17, NATURAL_JOIN=18, JOIN=19, DIVISION=20, 
		RENAME=21, AS=22, EQUAL=23, NOT_EQUAL=24, GREATER_THAN=25, GREATER_EQUAL=26, 
		LESS_THAN=27, LESS_EQUAL=28, BOOLEAN_AND=29, BOOLEAN_OR=30, BOOLEAN_NOT=31, 
		IDENTIFIER=32, NUMBER=33, WHITESPACES=34;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "PROJECTION", "SELECTION", "UNION", "DIFFERENCE", "CARTESIAN_PRODUCT", 
		"INTERSECTION", "NATURAL_JOIN", "JOIN", "DIVISION", "RENAME", "AS", "EQUAL", 
		"NOT_EQUAL", "GREATER_THAN", "GREATER_EQUAL", "LESS_THAN", "LESS_EQUAL", 
		"BOOLEAN_AND", "BOOLEAN_OR", "BOOLEAN_NOT", "IDENTIFIER", "NUMBER", "WHITESPACES"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';'", "'//'", "'/*'", "'*/'", "'='", "'('", "')'", "'['", "']'", 
		"','", "'NOT'", null, null, null, null, null, null, null, null, null, 
		null, "'AS'", null, null, "'>'", "'>='", "'<'", "'<='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		"PROJECTION", "SELECTION", "UNION", "DIFFERENCE", "CARTESIAN_PRODUCT", 
		"INTERSECTION", "NATURAL_JOIN", "JOIN", "DIVISION", "RENAME", "AS", "EQUAL", 
		"NOT_EQUAL", "GREATER_THAN", "GREATER_EQUAL", "LESS_THAN", "LESS_EQUAL", 
		"BOOLEAN_AND", "BOOLEAN_OR", "BOOLEAN_NOT", "IDENTIFIER", "NUMBER", "WHITESPACES"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2$\u013e\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5\3\6\3\6"+
		"\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\rt\n\r\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\5\16\u0085\n\16\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u008d\n\17\3\20\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u009a\n\20\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u00b5\n\21\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u00c4"+
		"\n\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\5\23\u00d8\n\23\3\24\3\24\3\24\3\24\3\24\5\24"+
		"\u00df\n\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u00ea\n"+
		"\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u00f5\n\26\3\27"+
		"\3\27\3\27\3\30\3\30\3\30\5\30\u00fd\n\30\3\31\3\31\3\31\3\31\5\31\u0103"+
		"\n\31\3\32\3\32\3\33\3\33\3\33\3\34\3\34\3\35\3\35\3\35\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\5\36\u0116\n\36\3\37\3\37\3\37\3\37\3\37\5\37\u011d"+
		"\n\37\3 \3 \3 \3 \3 \3 \3 \5 \u0126\n \3!\6!\u0129\n!\r!\16!\u012a\3!"+
		"\7!\u012e\n!\f!\16!\u0131\13!\3\"\6\"\u0134\n\"\r\"\16\"\u0135\3#\6#\u0139"+
		"\n#\r#\16#\u013a\3#\3#\2\2$\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25"+
		"\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32"+
		"\63\33\65\34\67\359\36;\37= ?!A\"C#E$\3\2\t\4\2ZZzz\4\2[[{{\4\2\61\61"+
		"\u00f9\u00f9\4\2C\\c|\6\2\62;C\\aac|\3\2\62;\5\2\13\f\17\17\"\"\u0155"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2"+
		"\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3"+
		"\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\3G\3\2\2"+
		"\2\5I\3\2\2\2\7L\3\2\2\2\tO\3\2\2\2\13R\3\2\2\2\rT\3\2\2\2\17V\3\2\2\2"+
		"\21X\3\2\2\2\23Z\3\2\2\2\25\\\3\2\2\2\27^\3\2\2\2\31s\3\2\2\2\33\u0084"+
		"\3\2\2\2\35\u008c\3\2\2\2\37\u0099\3\2\2\2!\u00b4\3\2\2\2#\u00c3\3\2\2"+
		"\2%\u00d7\3\2\2\2\'\u00de\3\2\2\2)\u00e9\3\2\2\2+\u00f4\3\2\2\2-\u00f6"+
		"\3\2\2\2/\u00fc\3\2\2\2\61\u0102\3\2\2\2\63\u0104\3\2\2\2\65\u0106\3\2"+
		"\2\2\67\u0109\3\2\2\29\u010b\3\2\2\2;\u0115\3\2\2\2=\u011c\3\2\2\2?\u0125"+
		"\3\2\2\2A\u0128\3\2\2\2C\u0133\3\2\2\2E\u0138\3\2\2\2GH\7=\2\2H\4\3\2"+
		"\2\2IJ\7\61\2\2JK\7\61\2\2K\6\3\2\2\2LM\7\61\2\2MN\7,\2\2N\b\3\2\2\2O"+
		"P\7,\2\2PQ\7\61\2\2Q\n\3\2\2\2RS\7?\2\2S\f\3\2\2\2TU\7*\2\2U\16\3\2\2"+
		"\2VW\7+\2\2W\20\3\2\2\2XY\7]\2\2Y\22\3\2\2\2Z[\7_\2\2[\24\3\2\2\2\\]\7"+
		".\2\2]\26\3\2\2\2^_\7P\2\2_`\7Q\2\2`a\7V\2\2a\30\3\2\2\2bc\7R\2\2cd\7"+
		"T\2\2de\7Q\2\2ef\7L\2\2fg\7G\2\2gh\7E\2\2hi\7V\2\2ij\7K\2\2jk\7Q\2\2k"+
		"t\7P\2\2lm\7R\2\2mn\7T\2\2no\7Q\2\2op\7L\2\2pq\7G\2\2qr\7E\2\2rt\7V\2"+
		"\2sb\3\2\2\2sl\3\2\2\2t\32\3\2\2\2uv\7U\2\2vw\7G\2\2wx\7N\2\2xy\7G\2\2"+
		"yz\7E\2\2z{\7V\2\2{|\7K\2\2|}\7Q\2\2}\u0085\7P\2\2~\177\7U\2\2\177\u0080"+
		"\7G\2\2\u0080\u0081\7N\2\2\u0081\u0082\7G\2\2\u0082\u0083\7E\2\2\u0083"+
		"\u0085\7V\2\2\u0084u\3\2\2\2\u0084~\3\2\2\2\u0085\34\3\2\2\2\u0086\u0087"+
		"\7W\2\2\u0087\u0088\7P\2\2\u0088\u0089\7K\2\2\u0089\u008a\7Q\2\2\u008a"+
		"\u008d\7P\2\2\u008b\u008d\7W\2\2\u008c\u0086\3\2\2\2\u008c\u008b\3\2\2"+
		"\2\u008d\36\3\2\2\2\u008e\u008f\7F\2\2\u008f\u0090\7K\2\2\u0090\u0091"+
		"\7H\2\2\u0091\u0092\7H\2\2\u0092\u0093\7G\2\2\u0093\u0094\7T\2\2\u0094"+
		"\u0095\7G\2\2\u0095\u0096\7P\2\2\u0096\u0097\7E\2\2\u0097\u009a\7G\2\2"+
		"\u0098\u009a\7/\2\2\u0099\u008e\3\2\2\2\u0099\u0098\3\2\2\2\u009a \3\2"+
		"\2\2\u009b\u009c\7E\2\2\u009c\u009d\7C\2\2\u009d\u009e\7T\2\2\u009e\u009f"+
		"\7V\2\2\u009f\u00a0\7G\2\2\u00a0\u00a1\7U\2\2\u00a1\u00a2\7K\2\2\u00a2"+
		"\u00a3\7C\2\2\u00a3\u00a4\7P\2\2\u00a4\u00a5\7\"\2\2\u00a5\u00a6\7R\2"+
		"\2\u00a6\u00a7\7T\2\2\u00a7\u00a8\7Q\2\2\u00a8\u00a9\7F\2\2\u00a9\u00aa"+
		"\7W\2\2\u00aa\u00ab\7E\2\2\u00ab\u00b5\7V\2\2\u00ac\u00ad\7R\2\2\u00ad"+
		"\u00ae\7T\2\2\u00ae\u00af\7Q\2\2\u00af\u00b0\7F\2\2\u00b0\u00b1\7W\2\2"+
		"\u00b1\u00b2\7E\2\2\u00b2\u00b5\7V\2\2\u00b3\u00b5\t\2\2\2\u00b4\u009b"+
		"\3\2\2\2\u00b4\u00ac\3\2\2\2\u00b4\u00b3\3\2\2\2\u00b5\"\3\2\2\2\u00b6"+
		"\u00b7\7K\2\2\u00b7\u00b8\7P\2\2\u00b8\u00b9\7V\2\2\u00b9\u00ba\7G\2\2"+
		"\u00ba\u00bb\7T\2\2\u00bb\u00bc\7U\2\2\u00bc\u00bd\7G\2\2\u00bd\u00be"+
		"\7E\2\2\u00be\u00bf\7V\2\2\u00bf\u00c0\7K\2\2\u00c0\u00c1\7Q\2\2\u00c1"+
		"\u00c4\7P\2\2\u00c2\u00c4\7\u222b\2\2\u00c3\u00b6\3\2\2\2\u00c3\u00c2"+
		"\3\2\2\2\u00c4$\3\2\2\2\u00c5\u00c6\7P\2\2\u00c6\u00c7\7C\2\2\u00c7\u00c8"+
		"\7V\2\2\u00c8\u00c9\7W\2\2\u00c9\u00ca\7T\2\2\u00ca\u00cb\7C\2\2\u00cb"+
		"\u00cc\7N\2\2\u00cc\u00cd\7\"\2\2\u00cd\u00ce\7L\2\2\u00ce\u00cf\7Q\2"+
		"\2\u00cf\u00d0\7K\2\2\u00d0\u00d8\7P\2\2\u00d1\u00d2\7P\2\2\u00d2\u00d3"+
		"\7L\2\2\u00d3\u00d4\7Q\2\2\u00d4\u00d5\7K\2\2\u00d5\u00d8\7P\2\2\u00d6"+
		"\u00d8\7,\2\2\u00d7\u00c5\3\2\2\2\u00d7\u00d1\3\2\2\2\u00d7\u00d6\3\2"+
		"\2\2\u00d8&\3\2\2\2\u00d9\u00da\7L\2\2\u00da\u00db\7Q\2\2\u00db\u00dc"+
		"\7K\2\2\u00dc\u00df\7P\2\2\u00dd\u00df\t\3\2\2\u00de\u00d9\3\2\2\2\u00de"+
		"\u00dd\3\2\2\2\u00df(\3\2\2\2\u00e0\u00e1\7F\2\2\u00e1\u00e2\7K\2\2\u00e2"+
		"\u00e3\7X\2\2\u00e3\u00e4\7K\2\2\u00e4\u00e5\7U\2\2\u00e5\u00e6\7K\2\2"+
		"\u00e6\u00e7\7Q\2\2\u00e7\u00ea\7P\2\2\u00e8\u00ea\t\4\2\2\u00e9\u00e0"+
		"\3\2\2\2\u00e9\u00e8\3\2\2\2\u00ea*\3\2\2\2\u00eb\u00ec\7T\2\2\u00ec\u00ed"+
		"\7G\2\2\u00ed\u00ee\7P\2\2\u00ee\u00ef\7C\2\2\u00ef\u00f0\7O\2\2\u00f0"+
		"\u00f5\7G\2\2\u00f1\u00f2\7T\2\2\u00f2\u00f3\7G\2\2\u00f3\u00f5\7P\2\2"+
		"\u00f4\u00eb\3\2\2\2\u00f4\u00f1\3\2\2\2\u00f5,\3\2\2\2\u00f6\u00f7\7"+
		"C\2\2\u00f7\u00f8\7U\2\2\u00f8.\3\2\2\2\u00f9\u00fd\7?\2\2\u00fa\u00fb"+
		"\7?\2\2\u00fb\u00fd\7?\2\2\u00fc\u00f9\3\2\2\2\u00fc\u00fa\3\2\2\2\u00fd"+
		"\60\3\2\2\2\u00fe\u00ff\7>\2\2\u00ff\u0103\7@\2\2\u0100\u0101\7#\2\2\u0101"+
		"\u0103\7?\2\2\u0102\u00fe\3\2\2\2\u0102\u0100\3\2\2\2\u0103\62\3\2\2\2"+
		"\u0104\u0105\7@\2\2\u0105\64\3\2\2\2\u0106\u0107\7@\2\2\u0107\u0108\7"+
		"?\2\2\u0108\66\3\2\2\2\u0109\u010a\7>\2\2\u010a8\3\2\2\2\u010b\u010c\7"+
		">\2\2\u010c\u010d\7?\2\2\u010d:\3\2\2\2\u010e\u010f\7C\2\2\u010f\u0110"+
		"\7P\2\2\u0110\u0116\7F\2\2\u0111\u0112\7c\2\2\u0112\u0113\7p\2\2\u0113"+
		"\u0116\7f\2\2\u0114\u0116\7(\2\2\u0115\u010e\3\2\2\2\u0115\u0111\3\2\2"+
		"\2\u0115\u0114\3\2\2\2\u0116<\3\2\2\2\u0117\u0118\7Q\2\2\u0118\u011d\7"+
		"T\2\2\u0119\u011a\7q\2\2\u011a\u011d\7t\2\2\u011b\u011d\7~\2\2\u011c\u0117"+
		"\3\2\2\2\u011c\u0119\3\2\2\2\u011c\u011b\3\2\2\2\u011d>\3\2\2\2\u011e"+
		"\u011f\7P\2\2\u011f\u0120\7Q\2\2\u0120\u0126\7V\2\2\u0121\u0122\7p\2\2"+
		"\u0122\u0123\7q\2\2\u0123\u0126\7v\2\2\u0124\u0126\7\u0080\2\2\u0125\u011e"+
		"\3\2\2\2\u0125\u0121\3\2\2\2\u0125\u0124\3\2\2\2\u0126@\3\2\2\2\u0127"+
		"\u0129\t\5\2\2\u0128\u0127\3\2\2\2\u0129\u012a\3\2\2\2\u012a\u0128\3\2"+
		"\2\2\u012a\u012b\3\2\2\2\u012b\u012f\3\2\2\2\u012c\u012e\t\6\2\2\u012d"+
		"\u012c\3\2\2\2\u012e\u0131\3\2\2\2\u012f\u012d\3\2\2\2\u012f\u0130\3\2"+
		"\2\2\u0130B\3\2\2\2\u0131\u012f\3\2\2\2\u0132\u0134\t\7\2\2\u0133\u0132"+
		"\3\2\2\2\u0134\u0135\3\2\2\2\u0135\u0133\3\2\2\2\u0135\u0136\3\2\2\2\u0136"+
		"D\3\2\2\2\u0137\u0139\t\b\2\2\u0138\u0137\3\2\2\2\u0139\u013a\3\2\2\2"+
		"\u013a\u0138\3\2\2\2\u013a\u013b\3\2\2\2\u013b\u013c\3\2\2\2\u013c\u013d"+
		"\b#\2\2\u013dF\3\2\2\2\27\2s\u0084\u008c\u0099\u00b4\u00c3\u00d7\u00de"+
		"\u00e9\u00f4\u00fc\u0102\u0115\u011c\u0125\u012a\u012d\u012f\u0135\u013a"+
		"\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}