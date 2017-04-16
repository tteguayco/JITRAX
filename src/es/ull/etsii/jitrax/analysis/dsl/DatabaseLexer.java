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
		CHAR=10, INT=11, FLOAT=12, DATE=13, STRING_VAL=14, NUMBER=15, ID=16, WHITESPACES=17, 
		COMMENT=18, LINE_COMMENT=19;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "DATABASE", "TABLE", "STRING", 
		"CHAR", "INT", "FLOAT", "DATE", "STRING_VAL", "NUMBER", "ID", "WHITESPACES", 
		"COMMENT", "LINE_COMMENT"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';'", "'('", "')'", "'=>'", "','", "':'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, "DATABASE", "TABLE", "STRING", 
		"CHAR", "INT", "FLOAT", "DATE", "STRING_VAL", "NUMBER", "ID", "WHITESPACES", 
		"COMMENT", "LINE_COMMENT"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\25\u00fe\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\6\3\6"+
		"\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\bO\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t`\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\nt\n\n\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u0082\n\13\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u009f\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00b0\n\r\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u00be\n\16\3\17\3\17\7\17"+
		"\u00c2\n\17\f\17\16\17\u00c5\13\17\3\17\3\17\3\20\6\20\u00ca\n\20\r\20"+
		"\16\20\u00cb\3\20\7\20\u00cf\n\20\f\20\16\20\u00d2\13\20\3\21\6\21\u00d5"+
		"\n\21\r\21\16\21\u00d6\3\21\7\21\u00da\n\21\f\21\16\21\u00dd\13\21\3\22"+
		"\6\22\u00e0\n\22\r\22\16\22\u00e1\3\22\3\22\3\23\3\23\3\23\3\23\7\23\u00ea"+
		"\n\23\f\23\16\23\u00ed\13\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3"+
		"\24\7\24\u00f8\n\24\f\24\16\24\u00fb\13\24\3\24\3\24\3\u00eb\2\25\3\3"+
		"\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21"+
		"!\22#\23%\24\'\25\3\2\b\7\2,-/;B\\aac|\3\2\62;\4\2\60\60\62;\4\2C\\c|"+
		"\5\2\13\f\17\17\"\"\4\2\f\f\17\17\u0115\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3"+
		"\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2"+
		"\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35"+
		"\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\3)"+
		"\3\2\2\2\5+\3\2\2\2\7-\3\2\2\2\t/\3\2\2\2\13\62\3\2\2\2\r\64\3\2\2\2\17"+
		"N\3\2\2\2\21_\3\2\2\2\23s\3\2\2\2\25\u0081\3\2\2\2\27\u009e\3\2\2\2\31"+
		"\u00af\3\2\2\2\33\u00bd\3\2\2\2\35\u00bf\3\2\2\2\37\u00c9\3\2\2\2!\u00d4"+
		"\3\2\2\2#\u00df\3\2\2\2%\u00e5\3\2\2\2\'\u00f3\3\2\2\2)*\7=\2\2*\4\3\2"+
		"\2\2+,\7*\2\2,\6\3\2\2\2-.\7+\2\2.\b\3\2\2\2/\60\7?\2\2\60\61\7@\2\2\61"+
		"\n\3\2\2\2\62\63\7.\2\2\63\f\3\2\2\2\64\65\7<\2\2\65\16\3\2\2\2\66\67"+
		"\7F\2\2\678\7C\2\289\7V\2\29:\7C\2\2:;\7D\2\2;<\7C\2\2<=\7U\2\2=O\7G\2"+
		"\2>?\7F\2\2?@\7c\2\2@A\7v\2\2AB\7c\2\2BC\7d\2\2CD\7c\2\2DE\7u\2\2EO\7"+
		"g\2\2FG\7f\2\2GH\7c\2\2HI\7v\2\2IJ\7c\2\2JK\7d\2\2KL\7c\2\2LM\7u\2\2M"+
		"O\7g\2\2N\66\3\2\2\2N>\3\2\2\2NF\3\2\2\2O\20\3\2\2\2PQ\7V\2\2QR\7C\2\2"+
		"RS\7D\2\2ST\7N\2\2T`\7G\2\2UV\7V\2\2VW\7c\2\2WX\7d\2\2XY\7n\2\2Y`\7g\2"+
		"\2Z[\7v\2\2[\\\7c\2\2\\]\7d\2\2]^\7n\2\2^`\7g\2\2_P\3\2\2\2_U\3\2\2\2"+
		"_Z\3\2\2\2`\22\3\2\2\2ab\7U\2\2bc\7V\2\2cd\7T\2\2de\7K\2\2ef\7P\2\2ft"+
		"\7I\2\2gh\7U\2\2hi\7v\2\2ij\7t\2\2jk\7k\2\2kl\7p\2\2lt\7i\2\2mn\7u\2\2"+
		"no\7v\2\2op\7t\2\2pq\7k\2\2qr\7p\2\2rt\7i\2\2sa\3\2\2\2sg\3\2\2\2sm\3"+
		"\2\2\2t\24\3\2\2\2uv\7E\2\2vw\7J\2\2wx\7C\2\2x\u0082\7T\2\2yz\7E\2\2z"+
		"{\7j\2\2{|\7c\2\2|\u0082\7t\2\2}~\7e\2\2~\177\7j\2\2\177\u0080\7c\2\2"+
		"\u0080\u0082\7t\2\2\u0081u\3\2\2\2\u0081y\3\2\2\2\u0081}\3\2\2\2\u0082"+
		"\26\3\2\2\2\u0083\u0084\7K\2\2\u0084\u0085\7P\2\2\u0085\u0086\7V\2\2\u0086"+
		"\u0087\7G\2\2\u0087\u0088\7I\2\2\u0088\u0089\7G\2\2\u0089\u009f\7T\2\2"+
		"\u008a\u008b\7K\2\2\u008b\u008c\7p\2\2\u008c\u008d\7v\2\2\u008d\u008e"+
		"\7g\2\2\u008e\u008f\7i\2\2\u008f\u0090\7g\2\2\u0090\u009f\7t\2\2\u0091"+
		"\u0092\7k\2\2\u0092\u0093\7p\2\2\u0093\u0094\7v\2\2\u0094\u0095\7g\2\2"+
		"\u0095\u0096\7i\2\2\u0096\u0097\7g\2\2\u0097\u009f\7t\2\2\u0098\u0099"+
		"\7K\2\2\u0099\u009a\7P\2\2\u009a\u009f\7V\2\2\u009b\u009c\7k\2\2\u009c"+
		"\u009d\7p\2\2\u009d\u009f\7v\2\2\u009e\u0083\3\2\2\2\u009e\u008a\3\2\2"+
		"\2\u009e\u0091\3\2\2\2\u009e\u0098\3\2\2\2\u009e\u009b\3\2\2\2\u009f\30"+
		"\3\2\2\2\u00a0\u00a1\7H\2\2\u00a1\u00a2\7N\2\2\u00a2\u00a3\7Q\2\2\u00a3"+
		"\u00a4\7C\2\2\u00a4\u00b0\7V\2\2\u00a5\u00a6\7H\2\2\u00a6\u00a7\7n\2\2"+
		"\u00a7\u00a8\7q\2\2\u00a8\u00a9\7c\2\2\u00a9\u00b0\7v\2\2\u00aa\u00ab"+
		"\7h\2\2\u00ab\u00ac\7n\2\2\u00ac\u00ad\7q\2\2\u00ad\u00ae\7c\2\2\u00ae"+
		"\u00b0\7v\2\2\u00af\u00a0\3\2\2\2\u00af\u00a5\3\2\2\2\u00af\u00aa\3\2"+
		"\2\2\u00b0\32\3\2\2\2\u00b1\u00b2\7F\2\2\u00b2\u00b3\7C\2\2\u00b3\u00b4"+
		"\7V\2\2\u00b4\u00be\7G\2\2\u00b5\u00b6\7F\2\2\u00b6\u00b7\7c\2\2\u00b7"+
		"\u00b8\7v\2\2\u00b8\u00be\7g\2\2\u00b9\u00ba\7f\2\2\u00ba\u00bb\7c\2\2"+
		"\u00bb\u00bc\7v\2\2\u00bc\u00be\7g\2\2\u00bd\u00b1\3\2\2\2\u00bd\u00b5"+
		"\3\2\2\2\u00bd\u00b9\3\2\2\2\u00be\34\3\2\2\2\u00bf\u00c3\7)\2\2\u00c0"+
		"\u00c2\t\2\2\2\u00c1\u00c0\3\2\2\2\u00c2\u00c5\3\2\2\2\u00c3\u00c1\3\2"+
		"\2\2\u00c3\u00c4\3\2\2\2\u00c4\u00c6\3\2\2\2\u00c5\u00c3\3\2\2\2\u00c6"+
		"\u00c7\7)\2\2\u00c7\36\3\2\2\2\u00c8\u00ca\t\3\2\2\u00c9\u00c8\3\2\2\2"+
		"\u00ca\u00cb\3\2\2\2\u00cb\u00c9\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc\u00d0"+
		"\3\2\2\2\u00cd\u00cf\t\4\2\2\u00ce\u00cd\3\2\2\2\u00cf\u00d2\3\2\2\2\u00d0"+
		"\u00ce\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1 \3\2\2\2\u00d2\u00d0\3\2\2\2"+
		"\u00d3\u00d5\t\5\2\2\u00d4\u00d3\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6\u00d4"+
		"\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7\u00db\3\2\2\2\u00d8\u00da\t\2\2\2\u00d9"+
		"\u00d8\3\2\2\2\u00da\u00dd\3\2\2\2\u00db\u00d9\3\2\2\2\u00db\u00dc\3\2"+
		"\2\2\u00dc\"\3\2\2\2\u00dd\u00db\3\2\2\2\u00de\u00e0\t\6\2\2\u00df\u00de"+
		"\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1\u00df\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2"+
		"\u00e3\3\2\2\2\u00e3\u00e4\b\22\2\2\u00e4$\3\2\2\2\u00e5\u00e6\7\61\2"+
		"\2\u00e6\u00e7\7,\2\2\u00e7\u00eb\3\2\2\2\u00e8\u00ea\13\2\2\2\u00e9\u00e8"+
		"\3\2\2\2\u00ea\u00ed\3\2\2\2\u00eb\u00ec\3\2\2\2\u00eb\u00e9\3\2\2\2\u00ec"+
		"\u00ee\3\2\2\2\u00ed\u00eb\3\2\2\2\u00ee\u00ef\7,\2\2\u00ef\u00f0\7\61"+
		"\2\2\u00f0\u00f1\3\2\2\2\u00f1\u00f2\b\23\3\2\u00f2&\3\2\2\2\u00f3\u00f4"+
		"\7\61\2\2\u00f4\u00f5\7\61\2\2\u00f5\u00f9\3\2\2\2\u00f6\u00f8\n\7\2\2"+
		"\u00f7\u00f6\3\2\2\2\u00f8\u00fb\3\2\2\2\u00f9\u00f7\3\2\2\2\u00f9\u00fa"+
		"\3\2\2\2\u00fa\u00fc\3\2\2\2\u00fb\u00f9\3\2\2\2\u00fc\u00fd\b\24\3\2"+
		"\u00fd(\3\2\2\2\25\2N_s\u0081\u009e\u00af\u00bd\u00c1\u00c3\u00cb\u00ce"+
		"\u00d0\u00d6\u00d9\u00db\u00e1\u00eb\u00f9\4\b\2\2\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}