package es.ull.etsii.jitrax.analysisDSL;

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
		STRING=10, CHAR=11, INT=12, FLOAT=13, DATE=14, PK=15, IDENTIFIER=16, DATUM=17, 
		NUMBER=18, WHITESPACES=19;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "DATABASE", "TABLE", 
		"STRING", "CHAR", "INT", "FLOAT", "DATE", "PK", "IDENTIFIER", "DATUM", 
		"NUMBER", "WHITESPACES"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'//'", "';'", "'('", "')'", "'=>'", "','", "':'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, "DATABASE", "TABLE", "STRING", 
		"CHAR", "INT", "FLOAT", "DATE", "PK", "IDENTIFIER", "DATUM", "NUMBER", 
		"WHITESPACES"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\25\u00ef\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6"+
		"\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\tR\n\t\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\nc\n\n\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\5\13w\n\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u0085"+
		"\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00a2\n\r\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u00b3"+
		"\n\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17"+
		"\u00c1\n\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\5\20\u00d2\n\20\3\21\6\21\u00d5\n\21\r\21\16\21\u00d6"+
		"\3\21\7\21\u00da\n\21\f\21\16\21\u00dd\13\21\3\22\6\22\u00e0\n\22\r\22"+
		"\16\22\u00e1\3\23\6\23\u00e5\n\23\r\23\16\23\u00e6\3\24\6\24\u00ea\n\24"+
		"\r\24\16\24\u00eb\3\24\3\24\2\2\25\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n"+
		"\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25\3\2\7\4\2C\\"+
		"c|\6\2\62;C\\aac|\6\2,-/;B\\c|\3\2\62;\5\2\13\f\17\17\"\"\u0105\2\3\3"+
		"\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2"+
		"\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3"+
		"\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2"+
		"%\3\2\2\2\2\'\3\2\2\2\3)\3\2\2\2\5,\3\2\2\2\7.\3\2\2\2\t\60\3\2\2\2\13"+
		"\62\3\2\2\2\r\65\3\2\2\2\17\67\3\2\2\2\21Q\3\2\2\2\23b\3\2\2\2\25v\3\2"+
		"\2\2\27\u0084\3\2\2\2\31\u00a1\3\2\2\2\33\u00b2\3\2\2\2\35\u00c0\3\2\2"+
		"\2\37\u00d1\3\2\2\2!\u00d4\3\2\2\2#\u00df\3\2\2\2%\u00e4\3\2\2\2\'\u00e9"+
		"\3\2\2\2)*\7\61\2\2*+\7\61\2\2+\4\3\2\2\2,-\7=\2\2-\6\3\2\2\2./\7*\2\2"+
		"/\b\3\2\2\2\60\61\7+\2\2\61\n\3\2\2\2\62\63\7?\2\2\63\64\7@\2\2\64\f\3"+
		"\2\2\2\65\66\7.\2\2\66\16\3\2\2\2\678\7<\2\28\20\3\2\2\29:\7F\2\2:;\7"+
		"C\2\2;<\7V\2\2<=\7C\2\2=>\7D\2\2>?\7C\2\2?@\7U\2\2@R\7G\2\2AB\7F\2\2B"+
		"C\7c\2\2CD\7v\2\2DE\7c\2\2EF\7d\2\2FG\7c\2\2GH\7u\2\2HR\7g\2\2IJ\7f\2"+
		"\2JK\7c\2\2KL\7v\2\2LM\7c\2\2MN\7d\2\2NO\7c\2\2OP\7u\2\2PR\7g\2\2Q9\3"+
		"\2\2\2QA\3\2\2\2QI\3\2\2\2R\22\3\2\2\2ST\7V\2\2TU\7C\2\2UV\7D\2\2VW\7"+
		"N\2\2Wc\7G\2\2XY\7V\2\2YZ\7c\2\2Z[\7d\2\2[\\\7n\2\2\\c\7g\2\2]^\7v\2\2"+
		"^_\7c\2\2_`\7d\2\2`a\7n\2\2ac\7g\2\2bS\3\2\2\2bX\3\2\2\2b]\3\2\2\2c\24"+
		"\3\2\2\2de\7U\2\2ef\7V\2\2fg\7T\2\2gh\7K\2\2hi\7P\2\2iw\7I\2\2jk\7U\2"+
		"\2kl\7v\2\2lm\7t\2\2mn\7k\2\2no\7p\2\2ow\7i\2\2pq\7u\2\2qr\7v\2\2rs\7"+
		"t\2\2st\7k\2\2tu\7p\2\2uw\7i\2\2vd\3\2\2\2vj\3\2\2\2vp\3\2\2\2w\26\3\2"+
		"\2\2xy\7E\2\2yz\7J\2\2z{\7C\2\2{\u0085\7T\2\2|}\7E\2\2}~\7j\2\2~\177\7"+
		"c\2\2\177\u0085\7t\2\2\u0080\u0081\7e\2\2\u0081\u0082\7j\2\2\u0082\u0083"+
		"\7c\2\2\u0083\u0085\7t\2\2\u0084x\3\2\2\2\u0084|\3\2\2\2\u0084\u0080\3"+
		"\2\2\2\u0085\30\3\2\2\2\u0086\u0087\7K\2\2\u0087\u0088\7P\2\2\u0088\u0089"+
		"\7V\2\2\u0089\u008a\7G\2\2\u008a\u008b\7I\2\2\u008b\u008c\7G\2\2\u008c"+
		"\u00a2\7T\2\2\u008d\u008e\7K\2\2\u008e\u008f\7p\2\2\u008f\u0090\7v\2\2"+
		"\u0090\u0091\7g\2\2\u0091\u0092\7i\2\2\u0092\u0093\7g\2\2\u0093\u00a2"+
		"\7t\2\2\u0094\u0095\7k\2\2\u0095\u0096\7p\2\2\u0096\u0097\7v\2\2\u0097"+
		"\u0098\7g\2\2\u0098\u0099\7i\2\2\u0099\u009a\7g\2\2\u009a\u00a2\7t\2\2"+
		"\u009b\u009c\7K\2\2\u009c\u009d\7P\2\2\u009d\u00a2\7V\2\2\u009e\u009f"+
		"\7k\2\2\u009f\u00a0\7p\2\2\u00a0\u00a2\7v\2\2\u00a1\u0086\3\2\2\2\u00a1"+
		"\u008d\3\2\2\2\u00a1\u0094\3\2\2\2\u00a1\u009b\3\2\2\2\u00a1\u009e\3\2"+
		"\2\2\u00a2\32\3\2\2\2\u00a3\u00a4\7H\2\2\u00a4\u00a5\7N\2\2\u00a5\u00a6"+
		"\7Q\2\2\u00a6\u00a7\7C\2\2\u00a7\u00b3\7V\2\2\u00a8\u00a9\7H\2\2\u00a9"+
		"\u00aa\7n\2\2\u00aa\u00ab\7q\2\2\u00ab\u00ac\7c\2\2\u00ac\u00b3\7v\2\2"+
		"\u00ad\u00ae\7h\2\2\u00ae\u00af\7n\2\2\u00af\u00b0\7q\2\2\u00b0\u00b1"+
		"\7c\2\2\u00b1\u00b3\7v\2\2\u00b2\u00a3\3\2\2\2\u00b2\u00a8\3\2\2\2\u00b2"+
		"\u00ad\3\2\2\2\u00b3\34\3\2\2\2\u00b4\u00b5\7F\2\2\u00b5\u00b6\7C\2\2"+
		"\u00b6\u00b7\7V\2\2\u00b7\u00c1\7G\2\2\u00b8\u00b9\7F\2\2\u00b9\u00ba"+
		"\7c\2\2\u00ba\u00bb\7v\2\2\u00bb\u00c1\7g\2\2\u00bc\u00bd\7f\2\2\u00bd"+
		"\u00be\7c\2\2\u00be\u00bf\7v\2\2\u00bf\u00c1\7g\2\2\u00c0\u00b4\3\2\2"+
		"\2\u00c0\u00b8\3\2\2\2\u00c0\u00bc\3\2\2\2\u00c1\36\3\2\2\2\u00c2\u00c3"+
		"\7R\2\2\u00c3\u00d2\7M\2\2\u00c4\u00c5\7r\2\2\u00c5\u00d2\7m\2\2\u00c6"+
		"\u00c7\7R\2\2\u00c7\u00c8\7t\2\2\u00c8\u00c9\7k\2\2\u00c9\u00ca\7o\2\2"+
		"\u00ca\u00cb\7c\2\2\u00cb\u00cc\7t\2\2\u00cc\u00cd\7{\2\2\u00cd\u00ce"+
		"\7\"\2\2\u00ce\u00cf\7M\2\2\u00cf\u00d0\7g\2\2\u00d0\u00d2\7{\2\2\u00d1"+
		"\u00c2\3\2\2\2\u00d1\u00c4\3\2\2\2\u00d1\u00c6\3\2\2\2\u00d2 \3\2\2\2"+
		"\u00d3\u00d5\t\2\2\2\u00d4\u00d3\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6\u00d4"+
		"\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7\u00db\3\2\2\2\u00d8\u00da\t\3\2\2\u00d9"+
		"\u00d8\3\2\2\2\u00da\u00dd\3\2\2\2\u00db\u00d9\3\2\2\2\u00db\u00dc\3\2"+
		"\2\2\u00dc\"\3\2\2\2\u00dd\u00db\3\2\2\2\u00de\u00e0\t\4\2\2\u00df\u00de"+
		"\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1\u00df\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2"+
		"$\3\2\2\2\u00e3\u00e5\t\5\2\2\u00e4\u00e3\3\2\2\2\u00e5\u00e6\3\2\2\2"+
		"\u00e6\u00e4\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7&\3\2\2\2\u00e8\u00ea\t"+
		"\6\2\2\u00e9\u00e8\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb\u00e9\3\2\2\2\u00eb"+
		"\u00ec\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed\u00ee\b\24\2\2\u00ee(\3\2\2\2"+
		"\22\2Qbv\u0084\u00a1\u00b2\u00c0\u00d1\u00d6\u00d9\u00db\u00df\u00e1\u00e6"+
		"\u00eb\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}