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
		STRING=10, CHAR=11, INT=12, FLOAT=13, DATE=14, PK=15, DATUM=16, WHITESPACES=17;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "DATABASE", "TABLE", 
		"STRING", "CHAR", "INT", "FLOAT", "DATE", "PK", "DATUM", "WHITESPACES"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'//'", "';'", "'('", "')'", "'=>'", "','", "':'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, "DATABASE", "TABLE", "STRING", 
		"CHAR", "INT", "FLOAT", "DATE", "PK", "DATUM", "WHITESPACES"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\23\u00db\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\b\3\b"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\5\tN\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n_\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13s\n\13\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u0081\n\f\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u009e\n\r\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u00af\n\16\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00bd\n\17\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\5\20\u00ce\n\20\3\21\6\21\u00d1\n\21\r\21\16\21\u00d2\3\22\6\22\u00d6"+
		"\n\22\r\22\16\22\u00d7\3\22\3\22\2\2\23\3\3\5\4\7\5\t\6\13\7\r\b\17\t"+
		"\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23\3\2\4\7\2,-/;B\\"+
		"aac|\5\2\13\f\17\17\"\"\u00ee\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t"+
		"\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2"+
		"\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2"+
		"\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\3%\3\2\2\2\5(\3\2\2\2\7*\3\2\2\2\t,"+
		"\3\2\2\2\13.\3\2\2\2\r\61\3\2\2\2\17\63\3\2\2\2\21M\3\2\2\2\23^\3\2\2"+
		"\2\25r\3\2\2\2\27\u0080\3\2\2\2\31\u009d\3\2\2\2\33\u00ae\3\2\2\2\35\u00bc"+
		"\3\2\2\2\37\u00cd\3\2\2\2!\u00d0\3\2\2\2#\u00d5\3\2\2\2%&\7\61\2\2&\'"+
		"\7\61\2\2\'\4\3\2\2\2()\7=\2\2)\6\3\2\2\2*+\7*\2\2+\b\3\2\2\2,-\7+\2\2"+
		"-\n\3\2\2\2./\7?\2\2/\60\7@\2\2\60\f\3\2\2\2\61\62\7.\2\2\62\16\3\2\2"+
		"\2\63\64\7<\2\2\64\20\3\2\2\2\65\66\7F\2\2\66\67\7C\2\2\678\7V\2\289\7"+
		"C\2\29:\7D\2\2:;\7C\2\2;<\7U\2\2<N\7G\2\2=>\7F\2\2>?\7c\2\2?@\7v\2\2@"+
		"A\7c\2\2AB\7d\2\2BC\7c\2\2CD\7u\2\2DN\7g\2\2EF\7f\2\2FG\7c\2\2GH\7v\2"+
		"\2HI\7c\2\2IJ\7d\2\2JK\7c\2\2KL\7u\2\2LN\7g\2\2M\65\3\2\2\2M=\3\2\2\2"+
		"ME\3\2\2\2N\22\3\2\2\2OP\7V\2\2PQ\7C\2\2QR\7D\2\2RS\7N\2\2S_\7G\2\2TU"+
		"\7V\2\2UV\7c\2\2VW\7d\2\2WX\7n\2\2X_\7g\2\2YZ\7v\2\2Z[\7c\2\2[\\\7d\2"+
		"\2\\]\7n\2\2]_\7g\2\2^O\3\2\2\2^T\3\2\2\2^Y\3\2\2\2_\24\3\2\2\2`a\7U\2"+
		"\2ab\7V\2\2bc\7T\2\2cd\7K\2\2de\7P\2\2es\7I\2\2fg\7U\2\2gh\7v\2\2hi\7"+
		"t\2\2ij\7k\2\2jk\7p\2\2ks\7i\2\2lm\7u\2\2mn\7v\2\2no\7t\2\2op\7k\2\2p"+
		"q\7p\2\2qs\7i\2\2r`\3\2\2\2rf\3\2\2\2rl\3\2\2\2s\26\3\2\2\2tu\7E\2\2u"+
		"v\7J\2\2vw\7C\2\2w\u0081\7T\2\2xy\7E\2\2yz\7j\2\2z{\7c\2\2{\u0081\7t\2"+
		"\2|}\7e\2\2}~\7j\2\2~\177\7c\2\2\177\u0081\7t\2\2\u0080t\3\2\2\2\u0080"+
		"x\3\2\2\2\u0080|\3\2\2\2\u0081\30\3\2\2\2\u0082\u0083\7K\2\2\u0083\u0084"+
		"\7P\2\2\u0084\u0085\7V\2\2\u0085\u0086\7G\2\2\u0086\u0087\7I\2\2\u0087"+
		"\u0088\7G\2\2\u0088\u009e\7T\2\2\u0089\u008a\7K\2\2\u008a\u008b\7p\2\2"+
		"\u008b\u008c\7v\2\2\u008c\u008d\7g\2\2\u008d\u008e\7i\2\2\u008e\u008f"+
		"\7g\2\2\u008f\u009e\7t\2\2\u0090\u0091\7k\2\2\u0091\u0092\7p\2\2\u0092"+
		"\u0093\7v\2\2\u0093\u0094\7g\2\2\u0094\u0095\7i\2\2\u0095\u0096\7g\2\2"+
		"\u0096\u009e\7t\2\2\u0097\u0098\7K\2\2\u0098\u0099\7P\2\2\u0099\u009e"+
		"\7V\2\2\u009a\u009b\7k\2\2\u009b\u009c\7p\2\2\u009c\u009e\7v\2\2\u009d"+
		"\u0082\3\2\2\2\u009d\u0089\3\2\2\2\u009d\u0090\3\2\2\2\u009d\u0097\3\2"+
		"\2\2\u009d\u009a\3\2\2\2\u009e\32\3\2\2\2\u009f\u00a0\7H\2\2\u00a0\u00a1"+
		"\7N\2\2\u00a1\u00a2\7Q\2\2\u00a2\u00a3\7C\2\2\u00a3\u00af\7V\2\2\u00a4"+
		"\u00a5\7H\2\2\u00a5\u00a6\7n\2\2\u00a6\u00a7\7q\2\2\u00a7\u00a8\7c\2\2"+
		"\u00a8\u00af\7v\2\2\u00a9\u00aa\7h\2\2\u00aa\u00ab\7n\2\2\u00ab\u00ac"+
		"\7q\2\2\u00ac\u00ad\7c\2\2\u00ad\u00af\7v\2\2\u00ae\u009f\3\2\2\2\u00ae"+
		"\u00a4\3\2\2\2\u00ae\u00a9\3\2\2\2\u00af\34\3\2\2\2\u00b0\u00b1\7F\2\2"+
		"\u00b1\u00b2\7C\2\2\u00b2\u00b3\7V\2\2\u00b3\u00bd\7G\2\2\u00b4\u00b5"+
		"\7F\2\2\u00b5\u00b6\7c\2\2\u00b6\u00b7\7v\2\2\u00b7\u00bd\7g\2\2\u00b8"+
		"\u00b9\7f\2\2\u00b9\u00ba\7c\2\2\u00ba\u00bb\7v\2\2\u00bb\u00bd\7g\2\2"+
		"\u00bc\u00b0\3\2\2\2\u00bc\u00b4\3\2\2\2\u00bc\u00b8\3\2\2\2\u00bd\36"+
		"\3\2\2\2\u00be\u00bf\7R\2\2\u00bf\u00ce\7M\2\2\u00c0\u00c1\7r\2\2\u00c1"+
		"\u00ce\7m\2\2\u00c2\u00c3\7R\2\2\u00c3\u00c4\7t\2\2\u00c4\u00c5\7k\2\2"+
		"\u00c5\u00c6\7o\2\2\u00c6\u00c7\7c\2\2\u00c7\u00c8\7t\2\2\u00c8\u00c9"+
		"\7{\2\2\u00c9\u00ca\7\"\2\2\u00ca\u00cb\7M\2\2\u00cb\u00cc\7g\2\2\u00cc"+
		"\u00ce\7{\2\2\u00cd\u00be\3\2\2\2\u00cd\u00c0\3\2\2\2\u00cd\u00c2\3\2"+
		"\2\2\u00ce \3\2\2\2\u00cf\u00d1\t\2\2\2\u00d0\u00cf\3\2\2\2\u00d1\u00d2"+
		"\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3\"\3\2\2\2\u00d4"+
		"\u00d6\t\3\2\2\u00d5\u00d4\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7\u00d5\3\2"+
		"\2\2\u00d7\u00d8\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9\u00da\b\22\2\2\u00da"+
		"$\3\2\2\2\16\2M^r\u0080\u009d\u00ae\u00bc\u00cd\u00d0\u00d2\u00d7\3\b"+
		"\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}