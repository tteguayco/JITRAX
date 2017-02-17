package es.ull.etsii.jitrax.databaseFileLoading;

// Generated from Database.g4 by ANTLR 4.6
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class DatabaseLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.6", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, DATABASE=8, TABLE=9, 
		STRING=10, CHAR=11, INT=12, FLOAT=13, DATE=14, PK=15, IDENTIFIER=16, NUMBER=17, 
		WHITESPACES=18;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "DATABASE", "TABLE", 
		"STRING", "CHAR", "INT", "FLOAT", "DATE", "PK", "IDENTIFIER", "NUMBER", 
		"WHITESPACES"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'//'", "';'", "'('", "')'", "'=>'", "','", "':'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, "DATABASE", "TABLE", "STRING", 
		"CHAR", "INT", "FLOAT", "DATE", "PK", "IDENTIFIER", "NUMBER", "WHITESPACES"
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


	public DatabaseLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Database.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\24\u00e8\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\7\3"+
		"\7\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\tP\n\t\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\na\n\n\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13"+
		"u\n\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u0083\n\f\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00a0\n\r\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u00b1\n\16"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00bf"+
		"\n\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\5\20\u00d0\n\20\3\21\6\21\u00d3\n\21\r\21\16\21\u00d4\3\21"+
		"\7\21\u00d8\n\21\f\21\16\21\u00db\13\21\3\22\6\22\u00de\n\22\r\22\16\22"+
		"\u00df\3\23\6\23\u00e3\n\23\r\23\16\23\u00e4\3\23\3\23\2\2\24\3\3\5\4"+
		"\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22"+
		"#\23%\24\3\2\6\4\2C\\c|\6\2\62;C\\aac|\3\2\62;\5\2\13\f\17\17\"\"\u00fd"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\3\'\3\2\2\2\5*\3\2\2\2\7,\3\2\2\2\t.\3\2\2\2\13\60\3\2"+
		"\2\2\r\63\3\2\2\2\17\65\3\2\2\2\21O\3\2\2\2\23`\3\2\2\2\25t\3\2\2\2\27"+
		"\u0082\3\2\2\2\31\u009f\3\2\2\2\33\u00b0\3\2\2\2\35\u00be\3\2\2\2\37\u00cf"+
		"\3\2\2\2!\u00d2\3\2\2\2#\u00dd\3\2\2\2%\u00e2\3\2\2\2\'(\7\61\2\2()\7"+
		"\61\2\2)\4\3\2\2\2*+\7=\2\2+\6\3\2\2\2,-\7*\2\2-\b\3\2\2\2./\7+\2\2/\n"+
		"\3\2\2\2\60\61\7?\2\2\61\62\7@\2\2\62\f\3\2\2\2\63\64\7.\2\2\64\16\3\2"+
		"\2\2\65\66\7<\2\2\66\20\3\2\2\2\678\7F\2\289\7C\2\29:\7V\2\2:;\7C\2\2"+
		";<\7D\2\2<=\7C\2\2=>\7U\2\2>P\7G\2\2?@\7F\2\2@A\7c\2\2AB\7v\2\2BC\7c\2"+
		"\2CD\7d\2\2DE\7c\2\2EF\7u\2\2FP\7g\2\2GH\7f\2\2HI\7c\2\2IJ\7v\2\2JK\7"+
		"c\2\2KL\7d\2\2LM\7c\2\2MN\7u\2\2NP\7g\2\2O\67\3\2\2\2O?\3\2\2\2OG\3\2"+
		"\2\2P\22\3\2\2\2QR\7V\2\2RS\7C\2\2ST\7D\2\2TU\7N\2\2Ua\7G\2\2VW\7V\2\2"+
		"WX\7c\2\2XY\7d\2\2YZ\7n\2\2Za\7g\2\2[\\\7v\2\2\\]\7c\2\2]^\7d\2\2^_\7"+
		"n\2\2_a\7g\2\2`Q\3\2\2\2`V\3\2\2\2`[\3\2\2\2a\24\3\2\2\2bc\7U\2\2cd\7"+
		"V\2\2de\7T\2\2ef\7K\2\2fg\7P\2\2gu\7I\2\2hi\7U\2\2ij\7v\2\2jk\7t\2\2k"+
		"l\7k\2\2lm\7p\2\2mu\7i\2\2no\7u\2\2op\7v\2\2pq\7t\2\2qr\7k\2\2rs\7p\2"+
		"\2su\7i\2\2tb\3\2\2\2th\3\2\2\2tn\3\2\2\2u\26\3\2\2\2vw\7E\2\2wx\7J\2"+
		"\2xy\7C\2\2y\u0083\7T\2\2z{\7E\2\2{|\7j\2\2|}\7c\2\2}\u0083\7t\2\2~\177"+
		"\7e\2\2\177\u0080\7j\2\2\u0080\u0081\7c\2\2\u0081\u0083\7t\2\2\u0082v"+
		"\3\2\2\2\u0082z\3\2\2\2\u0082~\3\2\2\2\u0083\30\3\2\2\2\u0084\u0085\7"+
		"K\2\2\u0085\u0086\7P\2\2\u0086\u0087\7V\2\2\u0087\u0088\7G\2\2\u0088\u0089"+
		"\7I\2\2\u0089\u008a\7G\2\2\u008a\u00a0\7T\2\2\u008b\u008c\7K\2\2\u008c"+
		"\u008d\7p\2\2\u008d\u008e\7v\2\2\u008e\u008f\7g\2\2\u008f\u0090\7i\2\2"+
		"\u0090\u0091\7g\2\2\u0091\u00a0\7t\2\2\u0092\u0093\7k\2\2\u0093\u0094"+
		"\7p\2\2\u0094\u0095\7v\2\2\u0095\u0096\7g\2\2\u0096\u0097\7i\2\2\u0097"+
		"\u0098\7g\2\2\u0098\u00a0\7t\2\2\u0099\u009a\7K\2\2\u009a\u009b\7P\2\2"+
		"\u009b\u00a0\7V\2\2\u009c\u009d\7k\2\2\u009d\u009e\7p\2\2\u009e\u00a0"+
		"\7v\2\2\u009f\u0084\3\2\2\2\u009f\u008b\3\2\2\2\u009f\u0092\3\2\2\2\u009f"+
		"\u0099\3\2\2\2\u009f\u009c\3\2\2\2\u00a0\32\3\2\2\2\u00a1\u00a2\7H\2\2"+
		"\u00a2\u00a3\7N\2\2\u00a3\u00a4\7Q\2\2\u00a4\u00a5\7C\2\2\u00a5\u00b1"+
		"\7V\2\2\u00a6\u00a7\7H\2\2\u00a7\u00a8\7n\2\2\u00a8\u00a9\7q\2\2\u00a9"+
		"\u00aa\7c\2\2\u00aa\u00b1\7v\2\2\u00ab\u00ac\7h\2\2\u00ac\u00ad\7n\2\2"+
		"\u00ad\u00ae\7q\2\2\u00ae\u00af\7c\2\2\u00af\u00b1\7v\2\2\u00b0\u00a1"+
		"\3\2\2\2\u00b0\u00a6\3\2\2\2\u00b0\u00ab\3\2\2\2\u00b1\34\3\2\2\2\u00b2"+
		"\u00b3\7F\2\2\u00b3\u00b4\7C\2\2\u00b4\u00b5\7V\2\2\u00b5\u00bf\7G\2\2"+
		"\u00b6\u00b7\7F\2\2\u00b7\u00b8\7c\2\2\u00b8\u00b9\7v\2\2\u00b9\u00bf"+
		"\7g\2\2\u00ba\u00bb\7f\2\2\u00bb\u00bc\7c\2\2\u00bc\u00bd\7v\2\2\u00bd"+
		"\u00bf\7g\2\2\u00be\u00b2\3\2\2\2\u00be\u00b6\3\2\2\2\u00be\u00ba\3\2"+
		"\2\2\u00bf\36\3\2\2\2\u00c0\u00c1\7R\2\2\u00c1\u00d0\7M\2\2\u00c2\u00c3"+
		"\7r\2\2\u00c3\u00d0\7m\2\2\u00c4\u00c5\7R\2\2\u00c5\u00c6\7t\2\2\u00c6"+
		"\u00c7\7k\2\2\u00c7\u00c8\7o\2\2\u00c8\u00c9\7c\2\2\u00c9\u00ca\7t\2\2"+
		"\u00ca\u00cb\7{\2\2\u00cb\u00cc\7\"\2\2\u00cc\u00cd\7M\2\2\u00cd\u00ce"+
		"\7g\2\2\u00ce\u00d0\7{\2\2\u00cf\u00c0\3\2\2\2\u00cf\u00c2\3\2\2\2\u00cf"+
		"\u00c4\3\2\2\2\u00d0 \3\2\2\2\u00d1\u00d3\t\2\2\2\u00d2\u00d1\3\2\2\2"+
		"\u00d3\u00d4\3\2\2\2\u00d4\u00d2\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5\u00d9"+
		"\3\2\2\2\u00d6\u00d8\t\3\2\2\u00d7\u00d6\3\2\2\2\u00d8\u00db\3\2\2\2\u00d9"+
		"\u00d7\3\2\2\2\u00d9\u00da\3\2\2\2\u00da\"\3\2\2\2\u00db\u00d9\3\2\2\2"+
		"\u00dc\u00de\t\4\2\2\u00dd\u00dc\3\2\2\2\u00de\u00df\3\2\2\2\u00df\u00dd"+
		"\3\2\2\2\u00df\u00e0\3\2\2\2\u00e0$\3\2\2\2\u00e1\u00e3\t\5\2\2\u00e2"+
		"\u00e1\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4\u00e2\3\2\2\2\u00e4\u00e5\3\2"+
		"\2\2\u00e5\u00e6\3\2\2\2\u00e6\u00e7\b\23\2\2\u00e7&\3\2\2\2\20\2O`t\u0082"+
		"\u009f\u00b0\u00be\u00cf\u00d4\u00d7\u00d9\u00df\u00e4\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}