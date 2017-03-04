package es.ull.etsii.jitrax.analysis.dsl;

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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, DATABASE=7, TABLE=8, STRING=9, 
		CHAR=10, INT=11, FLOAT=12, DATE=13, PK=14, STRING_VAL=15, NUMBER=16, ID=17, 
		WHITESPACES=18;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "DATABASE", "TABLE", "STRING", 
		"CHAR", "INT", "FLOAT", "DATE", "PK", "STRING_VAL", "NUMBER", "ID", "WHITESPACES"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';'", "'('", "')'", "'=>'", "','", "':'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, "DATABASE", "TABLE", "STRING", 
		"CHAR", "INT", "FLOAT", "DATE", "PK", "STRING_VAL", "NUMBER", "ID", "WHITESPACES"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\24\u00f4\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\5\bM\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\5\t^\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\nr\n\n\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u0080\n\13\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\5\f\u009d\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00ae\n\r\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\5\16\u00bc\n\16\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00cd\n\17\3\20"+
		"\3\20\7\20\u00d1\n\20\f\20\16\20\u00d4\13\20\3\20\3\20\3\21\6\21\u00d9"+
		"\n\21\r\21\16\21\u00da\3\21\7\21\u00de\n\21\f\21\16\21\u00e1\13\21\3\22"+
		"\6\22\u00e4\n\22\r\22\16\22\u00e5\3\22\7\22\u00e9\n\22\f\22\16\22\u00ec"+
		"\13\22\3\23\6\23\u00ef\n\23\r\23\16\23\u00f0\3\23\3\23\2\2\24\3\3\5\4"+
		"\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22"+
		"#\23%\24\3\2\7\7\2,-/;B\\aac|\3\2\62;\4\2\60\60\62;\4\2C\\c|\5\2\13\f"+
		"\17\17\"\"\u010b\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13"+
		"\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2"+
		"\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2"+
		"!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\3\'\3\2\2\2\5)\3\2\2\2\7+\3\2\2\2\t-\3"+
		"\2\2\2\13\60\3\2\2\2\r\62\3\2\2\2\17L\3\2\2\2\21]\3\2\2\2\23q\3\2\2\2"+
		"\25\177\3\2\2\2\27\u009c\3\2\2\2\31\u00ad\3\2\2\2\33\u00bb\3\2\2\2\35"+
		"\u00cc\3\2\2\2\37\u00ce\3\2\2\2!\u00d8\3\2\2\2#\u00e3\3\2\2\2%\u00ee\3"+
		"\2\2\2\'(\7=\2\2(\4\3\2\2\2)*\7*\2\2*\6\3\2\2\2+,\7+\2\2,\b\3\2\2\2-."+
		"\7?\2\2./\7@\2\2/\n\3\2\2\2\60\61\7.\2\2\61\f\3\2\2\2\62\63\7<\2\2\63"+
		"\16\3\2\2\2\64\65\7F\2\2\65\66\7C\2\2\66\67\7V\2\2\678\7C\2\289\7D\2\2"+
		"9:\7C\2\2:;\7U\2\2;M\7G\2\2<=\7F\2\2=>\7c\2\2>?\7v\2\2?@\7c\2\2@A\7d\2"+
		"\2AB\7c\2\2BC\7u\2\2CM\7g\2\2DE\7f\2\2EF\7c\2\2FG\7v\2\2GH\7c\2\2HI\7"+
		"d\2\2IJ\7c\2\2JK\7u\2\2KM\7g\2\2L\64\3\2\2\2L<\3\2\2\2LD\3\2\2\2M\20\3"+
		"\2\2\2NO\7V\2\2OP\7C\2\2PQ\7D\2\2QR\7N\2\2R^\7G\2\2ST\7V\2\2TU\7c\2\2"+
		"UV\7d\2\2VW\7n\2\2W^\7g\2\2XY\7v\2\2YZ\7c\2\2Z[\7d\2\2[\\\7n\2\2\\^\7"+
		"g\2\2]N\3\2\2\2]S\3\2\2\2]X\3\2\2\2^\22\3\2\2\2_`\7U\2\2`a\7V\2\2ab\7"+
		"T\2\2bc\7K\2\2cd\7P\2\2dr\7I\2\2ef\7U\2\2fg\7v\2\2gh\7t\2\2hi\7k\2\2i"+
		"j\7p\2\2jr\7i\2\2kl\7u\2\2lm\7v\2\2mn\7t\2\2no\7k\2\2op\7p\2\2pr\7i\2"+
		"\2q_\3\2\2\2qe\3\2\2\2qk\3\2\2\2r\24\3\2\2\2st\7E\2\2tu\7J\2\2uv\7C\2"+
		"\2v\u0080\7T\2\2wx\7E\2\2xy\7j\2\2yz\7c\2\2z\u0080\7t\2\2{|\7e\2\2|}\7"+
		"j\2\2}~\7c\2\2~\u0080\7t\2\2\177s\3\2\2\2\177w\3\2\2\2\177{\3\2\2\2\u0080"+
		"\26\3\2\2\2\u0081\u0082\7K\2\2\u0082\u0083\7P\2\2\u0083\u0084\7V\2\2\u0084"+
		"\u0085\7G\2\2\u0085\u0086\7I\2\2\u0086\u0087\7G\2\2\u0087\u009d\7T\2\2"+
		"\u0088\u0089\7K\2\2\u0089\u008a\7p\2\2\u008a\u008b\7v\2\2\u008b\u008c"+
		"\7g\2\2\u008c\u008d\7i\2\2\u008d\u008e\7g\2\2\u008e\u009d\7t\2\2\u008f"+
		"\u0090\7k\2\2\u0090\u0091\7p\2\2\u0091\u0092\7v\2\2\u0092\u0093\7g\2\2"+
		"\u0093\u0094\7i\2\2\u0094\u0095\7g\2\2\u0095\u009d\7t\2\2\u0096\u0097"+
		"\7K\2\2\u0097\u0098\7P\2\2\u0098\u009d\7V\2\2\u0099\u009a\7k\2\2\u009a"+
		"\u009b\7p\2\2\u009b\u009d\7v\2\2\u009c\u0081\3\2\2\2\u009c\u0088\3\2\2"+
		"\2\u009c\u008f\3\2\2\2\u009c\u0096\3\2\2\2\u009c\u0099\3\2\2\2\u009d\30"+
		"\3\2\2\2\u009e\u009f\7H\2\2\u009f\u00a0\7N\2\2\u00a0\u00a1\7Q\2\2\u00a1"+
		"\u00a2\7C\2\2\u00a2\u00ae\7V\2\2\u00a3\u00a4\7H\2\2\u00a4\u00a5\7n\2\2"+
		"\u00a5\u00a6\7q\2\2\u00a6\u00a7\7c\2\2\u00a7\u00ae\7v\2\2\u00a8\u00a9"+
		"\7h\2\2\u00a9\u00aa\7n\2\2\u00aa\u00ab\7q\2\2\u00ab\u00ac\7c\2\2\u00ac"+
		"\u00ae\7v\2\2\u00ad\u009e\3\2\2\2\u00ad\u00a3\3\2\2\2\u00ad\u00a8\3\2"+
		"\2\2\u00ae\32\3\2\2\2\u00af\u00b0\7F\2\2\u00b0\u00b1\7C\2\2\u00b1\u00b2"+
		"\7V\2\2\u00b2\u00bc\7G\2\2\u00b3\u00b4\7F\2\2\u00b4\u00b5\7c\2\2\u00b5"+
		"\u00b6\7v\2\2\u00b6\u00bc\7g\2\2\u00b7\u00b8\7f\2\2\u00b8\u00b9\7c\2\2"+
		"\u00b9\u00ba\7v\2\2\u00ba\u00bc\7g\2\2\u00bb\u00af\3\2\2\2\u00bb\u00b3"+
		"\3\2\2\2\u00bb\u00b7\3\2\2\2\u00bc\34\3\2\2\2\u00bd\u00be\7R\2\2\u00be"+
		"\u00cd\7M\2\2\u00bf\u00c0\7r\2\2\u00c0\u00cd\7m\2\2\u00c1\u00c2\7R\2\2"+
		"\u00c2\u00c3\7t\2\2\u00c3\u00c4\7k\2\2\u00c4\u00c5\7o\2\2\u00c5\u00c6"+
		"\7c\2\2\u00c6\u00c7\7t\2\2\u00c7\u00c8\7{\2\2\u00c8\u00c9\7\"\2\2\u00c9"+
		"\u00ca\7M\2\2\u00ca\u00cb\7g\2\2\u00cb\u00cd\7{\2\2\u00cc\u00bd\3\2\2"+
		"\2\u00cc\u00bf\3\2\2\2\u00cc\u00c1\3\2\2\2\u00cd\36\3\2\2\2\u00ce\u00d2"+
		"\7)\2\2\u00cf\u00d1\t\2\2\2\u00d0\u00cf\3\2\2\2\u00d1\u00d4\3\2\2\2\u00d2"+
		"\u00d0\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3\u00d5\3\2\2\2\u00d4\u00d2\3\2"+
		"\2\2\u00d5\u00d6\7)\2\2\u00d6 \3\2\2\2\u00d7\u00d9\t\3\2\2\u00d8\u00d7"+
		"\3\2\2\2\u00d9\u00da\3\2\2\2\u00da\u00d8\3\2\2\2\u00da\u00db\3\2\2\2\u00db"+
		"\u00df\3\2\2\2\u00dc\u00de\t\4\2\2\u00dd\u00dc\3\2\2\2\u00de\u00e1\3\2"+
		"\2\2\u00df\u00dd\3\2\2\2\u00df\u00e0\3\2\2\2\u00e0\"\3\2\2\2\u00e1\u00df"+
		"\3\2\2\2\u00e2\u00e4\t\5\2\2\u00e3\u00e2\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5"+
		"\u00e3\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6\u00ea\3\2\2\2\u00e7\u00e9\t\2"+
		"\2\2\u00e8\u00e7\3\2\2\2\u00e9\u00ec\3\2\2\2\u00ea\u00e8\3\2\2\2\u00ea"+
		"\u00eb\3\2\2\2\u00eb$\3\2\2\2\u00ec\u00ea\3\2\2\2\u00ed\u00ef\t\6\2\2"+
		"\u00ee\u00ed\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0\u00ee\3\2\2\2\u00f0\u00f1"+
		"\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2\u00f3\b\23\2\2\u00f3&\3\2\2\2\24\2"+
		"L]q\177\u009c\u00ad\u00bb\u00cc\u00d0\u00d2\u00da\u00dd\u00df\u00e5\u00e8"+
		"\u00ea\u00f0\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}