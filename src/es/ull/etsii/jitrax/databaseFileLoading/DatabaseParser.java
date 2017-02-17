package es.ull.etsii.jitrax.databaseFileLoading;

// Generated from Database.g4 by ANTLR 4.6
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class DatabaseParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.6", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		DATATYPE=10, DATABASE=11, TABLE=12, STRING=13, CHAR=14, INT=15, FLOAT=16, 
		DATE=17, IDENTIFIER=18, NUMBER=19, WHITESPACES=20;
	public static final int
		RULE_start = 0, RULE_inline_comment = 1, RULE_multiline_comment = 2, RULE_table = 3, 
		RULE_attrlist = 4, RULE_datalist = 5, RULE_attribute = 6, RULE_datum = 7;
	public static final String[] ruleNames = {
		"start", "inline_comment", "multiline_comment", "table", "attrlist", "datalist", 
		"attribute", "datum"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';'", "'//'", "'/*'", "'*/'", "'('", "')'", "'=>'", "','", "':'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, "DATATYPE", 
		"DATABASE", "TABLE", "STRING", "CHAR", "INT", "FLOAT", "DATE", "IDENTIFIER", 
		"NUMBER", "WHITESPACES"
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

	@Override
	public String getGrammarFileName() { return "Database.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public DatabaseParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class StartContext extends ParserRuleContext {
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
	 
		public StartContext() { }
		public void copyFrom(StartContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DatabaseCreationContext extends StartContext {
		public TerminalNode DATABASE() { return getToken(DatabaseParser.DATABASE, 0); }
		public TerminalNode IDENTIFIER() { return getToken(DatabaseParser.IDENTIFIER, 0); }
		public List<TableContext> table() {
			return getRuleContexts(TableContext.class);
		}
		public TableContext table(int i) {
			return getRuleContext(TableContext.class,i);
		}
		public DatabaseCreationContext(StartContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DatabaseVisitor ) return ((DatabaseVisitor<? extends T>)visitor).visitDatabaseCreation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		int _la;
		try {
			_localctx = new DatabaseCreationContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(16);
			match(DATABASE);
			setState(17);
			match(IDENTIFIER);
			setState(18);
			match(T__0);
			setState(22);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TABLE) {
				{
				{
				setState(19);
				table();
				}
				}
				setState(24);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Inline_commentContext extends ParserRuleContext {
		public Inline_commentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inline_comment; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DatabaseVisitor ) return ((DatabaseVisitor<? extends T>)visitor).visitInline_comment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Inline_commentContext inline_comment() throws RecognitionException {
		Inline_commentContext _localctx = new Inline_commentContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_inline_comment);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(25);
			match(T__1);
			setState(29);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(26);
					matchWildcard();
					}
					} 
				}
				setState(31);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Multiline_commentContext extends ParserRuleContext {
		public Multiline_commentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiline_comment; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DatabaseVisitor ) return ((DatabaseVisitor<? extends T>)visitor).visitMultiline_comment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Multiline_commentContext multiline_comment() throws RecognitionException {
		Multiline_commentContext _localctx = new Multiline_commentContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_multiline_comment);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			match(T__2);
			setState(36);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(33);
					matchWildcard();
					}
					} 
				}
				setState(38);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			setState(39);
			match(T__3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TableContext extends ParserRuleContext {
		public TableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table; }
	 
		public TableContext() { }
		public void copyFrom(TableContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class TableCreationContext extends TableContext {
		public TerminalNode TABLE() { return getToken(DatabaseParser.TABLE, 0); }
		public TerminalNode IDENTIFIER() { return getToken(DatabaseParser.IDENTIFIER, 0); }
		public AttrlistContext attrlist() {
			return getRuleContext(AttrlistContext.class,0);
		}
		public List<DatalistContext> datalist() {
			return getRuleContexts(DatalistContext.class);
		}
		public DatalistContext datalist(int i) {
			return getRuleContext(DatalistContext.class,i);
		}
		public TableCreationContext(TableContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DatabaseVisitor ) return ((DatabaseVisitor<? extends T>)visitor).visitTableCreation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TableContext table() throws RecognitionException {
		TableContext _localctx = new TableContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_table);
		int _la;
		try {
			_localctx = new TableCreationContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			match(TABLE);
			setState(42);
			match(IDENTIFIER);
			setState(43);
			match(T__4);
			setState(44);
			attrlist();
			setState(45);
			match(T__5);
			setState(56);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(46);
				match(T__6);
				setState(52); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(47);
					match(T__4);
					setState(48);
					datalist();
					setState(49);
					match(T__5);
					setState(50);
					match(T__0);
					}
					}
					setState(54); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__4 );
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AttrlistContext extends ParserRuleContext {
		public AttrlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attrlist; }
	 
		public AttrlistContext() { }
		public void copyFrom(AttrlistContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AttributeListContext extends AttrlistContext {
		public AttributeContext attribute() {
			return getRuleContext(AttributeContext.class,0);
		}
		public AttrlistContext attrlist() {
			return getRuleContext(AttrlistContext.class,0);
		}
		public AttributeListContext(AttrlistContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DatabaseVisitor ) return ((DatabaseVisitor<? extends T>)visitor).visitAttributeList(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SingleAttributeContext extends AttrlistContext {
		public AttributeContext attribute() {
			return getRuleContext(AttributeContext.class,0);
		}
		public SingleAttributeContext(AttrlistContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DatabaseVisitor ) return ((DatabaseVisitor<? extends T>)visitor).visitSingleAttribute(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttrlistContext attrlist() throws RecognitionException {
		AttrlistContext _localctx = new AttrlistContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_attrlist);
		try {
			setState(63);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				_localctx = new SingleAttributeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(58);
				attribute();
				}
				break;
			case 2:
				_localctx = new AttributeListContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(59);
				attribute();
				setState(60);
				match(T__7);
				setState(61);
				attrlist();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DatalistContext extends ParserRuleContext {
		public DatalistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_datalist; }
	 
		public DatalistContext() { }
		public void copyFrom(DatalistContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SingleDatumContext extends DatalistContext {
		public DatumContext datum() {
			return getRuleContext(DatumContext.class,0);
		}
		public SingleDatumContext(DatalistContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DatabaseVisitor ) return ((DatabaseVisitor<? extends T>)visitor).visitSingleDatum(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DataListContext extends DatalistContext {
		public DatumContext datum() {
			return getRuleContext(DatumContext.class,0);
		}
		public DatalistContext datalist() {
			return getRuleContext(DatalistContext.class,0);
		}
		public DataListContext(DatalistContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DatabaseVisitor ) return ((DatabaseVisitor<? extends T>)visitor).visitDataList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DatalistContext datalist() throws RecognitionException {
		DatalistContext _localctx = new DatalistContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_datalist);
		try {
			setState(70);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				_localctx = new SingleDatumContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(65);
				datum();
				}
				break;
			case 2:
				_localctx = new DataListContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(66);
				datum();
				setState(67);
				match(T__7);
				setState(68);
				datalist();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AttributeContext extends ParserRuleContext {
		public AttributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attribute; }
	 
		public AttributeContext() { }
		public void copyFrom(AttributeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AttributeValueContext extends AttributeContext {
		public TerminalNode IDENTIFIER() { return getToken(DatabaseParser.IDENTIFIER, 0); }
		public TerminalNode DATATYPE() { return getToken(DatabaseParser.DATATYPE, 0); }
		public AttributeValueContext(AttributeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DatabaseVisitor ) return ((DatabaseVisitor<? extends T>)visitor).visitAttributeValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributeContext attribute() throws RecognitionException {
		AttributeContext _localctx = new AttributeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_attribute);
		try {
			_localctx = new AttributeValueContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			match(IDENTIFIER);
			setState(73);
			match(T__8);
			setState(74);
			match(DATATYPE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DatumContext extends ParserRuleContext {
		public DatumContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_datum; }
	 
		public DatumContext() { }
		public void copyFrom(DatumContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DatumValueContext extends DatumContext {
		public DatumValueContext(DatumContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DatabaseVisitor ) return ((DatabaseVisitor<? extends T>)visitor).visitDatumValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DatumContext datum() throws RecognitionException {
		DatumContext _localctx = new DatumContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_datum);
		try {
			int _alt;
			_localctx = new DatumValueContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(77); 
			_errHandler.sync(this);
			_alt = 1+1;
			do {
				switch (_alt) {
				case 1+1:
					{
					{
					setState(76);
					matchWildcard();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(79); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			} while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\26T\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\3\2\3\2\3\2\7\2"+
		"\27\n\2\f\2\16\2\32\13\2\3\3\3\3\7\3\36\n\3\f\3\16\3!\13\3\3\4\3\4\7\4"+
		"%\n\4\f\4\16\4(\13\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\6\5\67\n\5\r\5\16\58\5\5;\n\5\3\6\3\6\3\6\3\6\3\6\5\6B\n\6\3\7\3\7"+
		"\3\7\3\7\3\7\5\7I\n\7\3\b\3\b\3\b\3\b\3\t\6\tP\n\t\r\t\16\tQ\3\t\5\37"+
		"&Q\2\n\2\4\6\b\n\f\16\20\2\2S\2\22\3\2\2\2\4\33\3\2\2\2\6\"\3\2\2\2\b"+
		"+\3\2\2\2\nA\3\2\2\2\fH\3\2\2\2\16J\3\2\2\2\20O\3\2\2\2\22\23\7\r\2\2"+
		"\23\24\7\24\2\2\24\30\7\3\2\2\25\27\5\b\5\2\26\25\3\2\2\2\27\32\3\2\2"+
		"\2\30\26\3\2\2\2\30\31\3\2\2\2\31\3\3\2\2\2\32\30\3\2\2\2\33\37\7\4\2"+
		"\2\34\36\13\2\2\2\35\34\3\2\2\2\36!\3\2\2\2\37 \3\2\2\2\37\35\3\2\2\2"+
		" \5\3\2\2\2!\37\3\2\2\2\"&\7\5\2\2#%\13\2\2\2$#\3\2\2\2%(\3\2\2\2&\'\3"+
		"\2\2\2&$\3\2\2\2\')\3\2\2\2(&\3\2\2\2)*\7\6\2\2*\7\3\2\2\2+,\7\16\2\2"+
		",-\7\24\2\2-.\7\7\2\2./\5\n\6\2/:\7\b\2\2\60\66\7\t\2\2\61\62\7\7\2\2"+
		"\62\63\5\f\7\2\63\64\7\b\2\2\64\65\7\3\2\2\65\67\3\2\2\2\66\61\3\2\2\2"+
		"\678\3\2\2\28\66\3\2\2\289\3\2\2\29;\3\2\2\2:\60\3\2\2\2:;\3\2\2\2;\t"+
		"\3\2\2\2<B\5\16\b\2=>\5\16\b\2>?\7\n\2\2?@\5\n\6\2@B\3\2\2\2A<\3\2\2\2"+
		"A=\3\2\2\2B\13\3\2\2\2CI\5\20\t\2DE\5\20\t\2EF\7\n\2\2FG\5\f\7\2GI\3\2"+
		"\2\2HC\3\2\2\2HD\3\2\2\2I\r\3\2\2\2JK\7\24\2\2KL\7\13\2\2LM\7\f\2\2M\17"+
		"\3\2\2\2NP\13\2\2\2ON\3\2\2\2PQ\3\2\2\2QR\3\2\2\2QO\3\2\2\2R\21\3\2\2"+
		"\2\n\30\37&8:AHQ";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}