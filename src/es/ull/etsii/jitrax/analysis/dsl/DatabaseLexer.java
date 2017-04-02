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
		CHAR=10, INT=11, FLOAT=12, DATE=13, STRING_VAL=14, NUMBER=15, ID=16, WHITESPACES=17;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "DATABASE", "TABLE", "STRING", 
		"CHAR", "INT", "FLOAT", "DATE", "STRING_VAL", "NUMBER", "ID", "WHITESPACES"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';'", "'('", "')'", "'=>'", "','", "':'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, "DATABASE", "TABLE", "STRING", 
		"CHAR", "INT", "FLOAT", "DATE", "STRING_VAL", "NUMBER", "ID", "WHITESPACES"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\23\u00e1\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\5\bK\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\5\t\\\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\5\np\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\5\13~\n\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\5\f\u009b\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\5\r\u00ac\n\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\5\16\u00ba\n\16\3\17\3\17\7\17\u00be\n\17\f\17\16\17\u00c1"+
		"\13\17\3\17\3\17\3\20\6\20\u00c6\n\20\r\20\16\20\u00c7\3\20\7\20\u00cb"+
		"\n\20\f\20\16\20\u00ce\13\20\3\21\6\21\u00d1\n\21\r\21\16\21\u00d2\3\21"+
		"\7\21\u00d6\n\21\f\21\16\21\u00d9\13\21\3\22\6\22\u00dc\n\22\r\22\16\22"+
		"\u00dd\3\22\3\22\2\2\23\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f"+
		"\27\r\31\16\33\17\35\20\37\21!\22#\23\3\2\7\7\2,-/;B\\aac|\3\2\62;\4\2"+
		"\60\60\62;\4\2C\\c|\5\2\13\f\17\17\"\"\u00f6\2\3\3\2\2\2\2\5\3\2\2\2\2"+
		"\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2"+
		"\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2"+
		"\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\3%\3\2\2\2\5\'\3\2\2"+
		"\2\7)\3\2\2\2\t+\3\2\2\2\13.\3\2\2\2\r\60\3\2\2\2\17J\3\2\2\2\21[\3\2"+
		"\2\2\23o\3\2\2\2\25}\3\2\2\2\27\u009a\3\2\2\2\31\u00ab\3\2\2\2\33\u00b9"+
		"\3\2\2\2\35\u00bb\3\2\2\2\37\u00c5\3\2\2\2!\u00d0\3\2\2\2#\u00db\3\2\2"+
		"\2%&\7=\2\2&\4\3\2\2\2\'(\7*\2\2(\6\3\2\2\2)*\7+\2\2*\b\3\2\2\2+,\7?\2"+
		"\2,-\7@\2\2-\n\3\2\2\2./\7.\2\2/\f\3\2\2\2\60\61\7<\2\2\61\16\3\2\2\2"+
		"\62\63\7F\2\2\63\64\7C\2\2\64\65\7V\2\2\65\66\7C\2\2\66\67\7D\2\2\678"+
		"\7C\2\289\7U\2\29K\7G\2\2:;\7F\2\2;<\7c\2\2<=\7v\2\2=>\7c\2\2>?\7d\2\2"+
		"?@\7c\2\2@A\7u\2\2AK\7g\2\2BC\7f\2\2CD\7c\2\2DE\7v\2\2EF\7c\2\2FG\7d\2"+
		"\2GH\7c\2\2HI\7u\2\2IK\7g\2\2J\62\3\2\2\2J:\3\2\2\2JB\3\2\2\2K\20\3\2"+
		"\2\2LM\7V\2\2MN\7C\2\2NO\7D\2\2OP\7N\2\2P\\\7G\2\2QR\7V\2\2RS\7c\2\2S"+
		"T\7d\2\2TU\7n\2\2U\\\7g\2\2VW\7v\2\2WX\7c\2\2XY\7d\2\2YZ\7n\2\2Z\\\7g"+
		"\2\2[L\3\2\2\2[Q\3\2\2\2[V\3\2\2\2\\\22\3\2\2\2]^\7U\2\2^_\7V\2\2_`\7"+
		"T\2\2`a\7K\2\2ab\7P\2\2bp\7I\2\2cd\7U\2\2de\7v\2\2ef\7t\2\2fg\7k\2\2g"+
		"h\7p\2\2hp\7i\2\2ij\7u\2\2jk\7v\2\2kl\7t\2\2lm\7k\2\2mn\7p\2\2np\7i\2"+
		"\2o]\3\2\2\2oc\3\2\2\2oi\3\2\2\2p\24\3\2\2\2qr\7E\2\2rs\7J\2\2st\7C\2"+
		"\2t~\7T\2\2uv\7E\2\2vw\7j\2\2wx\7c\2\2x~\7t\2\2yz\7e\2\2z{\7j\2\2{|\7"+
		"c\2\2|~\7t\2\2}q\3\2\2\2}u\3\2\2\2}y\3\2\2\2~\26\3\2\2\2\177\u0080\7K"+
		"\2\2\u0080\u0081\7P\2\2\u0081\u0082\7V\2\2\u0082\u0083\7G\2\2\u0083\u0084"+
		"\7I\2\2\u0084\u0085\7G\2\2\u0085\u009b\7T\2\2\u0086\u0087\7K\2\2\u0087"+
		"\u0088\7p\2\2\u0088\u0089\7v\2\2\u0089\u008a\7g\2\2\u008a\u008b\7i\2\2"+
		"\u008b\u008c\7g\2\2\u008c\u009b\7t\2\2\u008d\u008e\7k\2\2\u008e\u008f"+
		"\7p\2\2\u008f\u0090\7v\2\2\u0090\u0091\7g\2\2\u0091\u0092\7i\2\2\u0092"+
		"\u0093\7g\2\2\u0093\u009b\7t\2\2\u0094\u0095\7K\2\2\u0095\u0096\7P\2\2"+
		"\u0096\u009b\7V\2\2\u0097\u0098\7k\2\2\u0098\u0099\7p\2\2\u0099\u009b"+
		"\7v\2\2\u009a\177\3\2\2\2\u009a\u0086\3\2\2\2\u009a\u008d\3\2\2\2\u009a"+
		"\u0094\3\2\2\2\u009a\u0097\3\2\2\2\u009b\30\3\2\2\2\u009c\u009d\7H\2\2"+
		"\u009d\u009e\7N\2\2\u009e\u009f\7Q\2\2\u009f\u00a0\7C\2\2\u00a0\u00ac"+
		"\7V\2\2\u00a1\u00a2\7H\2\2\u00a2\u00a3\7n\2\2\u00a3\u00a4\7q\2\2\u00a4"+
		"\u00a5\7c\2\2\u00a5\u00ac\7v\2\2\u00a6\u00a7\7h\2\2\u00a7\u00a8\7n\2\2"+
		"\u00a8\u00a9\7q\2\2\u00a9\u00aa\7c\2\2\u00aa\u00ac\7v\2\2\u00ab\u009c"+
		"\3\2\2\2\u00ab\u00a1\3\2\2\2\u00ab\u00a6\3\2\2\2\u00ac\32\3\2\2\2\u00ad"+
		"\u00ae\7F\2\2\u00ae\u00af\7C\2\2\u00af\u00b0\7V\2\2\u00b0\u00ba\7G\2\2"+
		"\u00b1\u00b2\7F\2\2\u00b2\u00b3\7c\2\2\u00b3\u00b4\7v\2\2\u00b4\u00ba"+
		"\7g\2\2\u00b5\u00b6\7f\2\2\u00b6\u00b7\7c\2\2\u00b7\u00b8\7v\2\2\u00b8"+
		"\u00ba\7g\2\2\u00b9\u00ad\3\2\2\2\u00b9\u00b1\3\2\2\2\u00b9\u00b5\3\2"+
		"\2\2\u00ba\34\3\2\2\2\u00bb\u00bf\7)\2\2\u00bc\u00be\t\2\2\2\u00bd\u00bc"+
		"\3\2\2\2\u00be\u00c1\3\2\2\2\u00bf\u00bd\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0"+
		"\u00c2\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c2\u00c3\7)\2\2\u00c3\36\3\2\2\2"+
		"\u00c4\u00c6\t\3\2\2\u00c5\u00c4\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7\u00c5"+
		"\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8\u00cc\3\2\2\2\u00c9\u00cb\t\4\2\2\u00ca"+
		"\u00c9\3\2\2\2\u00cb\u00ce\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cc\u00cd\3\2"+
		"\2\2\u00cd \3\2\2\2\u00ce\u00cc\3\2\2\2\u00cf\u00d1\t\5\2\2\u00d0\u00cf"+
		"\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3"+
		"\u00d7\3\2\2\2\u00d4\u00d6\t\2\2\2\u00d5\u00d4\3\2\2\2\u00d6\u00d9\3\2"+
		"\2\2\u00d7\u00d5\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8\"\3\2\2\2\u00d9\u00d7"+
		"\3\2\2\2\u00da\u00dc\t\6\2\2\u00db\u00da\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd"+
		"\u00db\3\2\2\2\u00dd\u00de\3\2\2\2\u00de\u00df\3\2\2\2\u00df\u00e0\b\22"+
		"\2\2\u00e0$\3\2\2\2\23\2J[o}\u009a\u00ab\u00b9\u00bd\u00bf\u00c7\u00ca"+
		"\u00cc\u00d2\u00d5\u00d7\u00dd\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}