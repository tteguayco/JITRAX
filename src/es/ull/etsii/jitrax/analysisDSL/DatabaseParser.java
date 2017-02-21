package es.ull.etsii.jitrax.analysisDSL;

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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, DATABASE=8, TABLE=9, 
		STRING=10, CHAR=11, INT=12, FLOAT=13, DATE=14, PK=15, DATUM=16, WHITESPACES=17;
	public static final int
		RULE_start = 0, RULE_comment = 1, RULE_database = 2, RULE_table = 3, RULE_attrlist = 4, 
		RULE_datalist = 5, RULE_attribute = 6, RULE_datum = 7, RULE_datatype = 8;
	public static final String[] ruleNames = {
		"start", "comment", "database", "table", "attrlist", "datalist", "attribute", 
		"datum", "datatype"
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
		public DatabaseContext database() {
			return getRuleContext(DatabaseContext.class,0);
		}
		public List<CommentContext> comment() {
			return getRuleContexts(CommentContext.class);
		}
		public CommentContext comment(int i) {
			return getRuleContext(CommentContext.class,i);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DatabaseVisitor ) return ((DatabaseVisitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(21);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(18);
				comment();
				}
				}
				setState(23);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(24);
			database();
			setState(28);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(25);
				comment();
				}
				}
				setState(30);
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

	public static class CommentContext extends ParserRuleContext {
		public CommentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comment; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DatabaseVisitor ) return ((DatabaseVisitor<? extends T>)visitor).visitComment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CommentContext comment() throws RecognitionException {
		CommentContext _localctx = new CommentContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_comment);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(31);
			match(T__0);
			setState(35);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(32);
					matchWildcard();
					}
					} 
				}
				setState(37);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
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

	public static class DatabaseContext extends ParserRuleContext {
		public DatabaseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_database; }
	 
		public DatabaseContext() { }
		public void copyFrom(DatabaseContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DatabaseCreationContext extends DatabaseContext {
		public TerminalNode DATABASE() { return getToken(DatabaseParser.DATABASE, 0); }
		public TerminalNode DATUM() { return getToken(DatabaseParser.DATUM, 0); }
		public List<TableContext> table() {
			return getRuleContexts(TableContext.class);
		}
		public TableContext table(int i) {
			return getRuleContext(TableContext.class,i);
		}
		public DatabaseCreationContext(DatabaseContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DatabaseVisitor ) return ((DatabaseVisitor<? extends T>)visitor).visitDatabaseCreation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DatabaseContext database() throws RecognitionException {
		DatabaseContext _localctx = new DatabaseContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_database);
		try {
			int _alt;
			_localctx = new DatabaseCreationContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(38);
			match(DATABASE);
			setState(39);
			match(DATUM);
			setState(40);
			match(T__1);
			setState(42); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(41);
					table();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(44); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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
		public TerminalNode DATUM() { return getToken(DatabaseParser.DATUM, 0); }
		public AttrlistContext attrlist() {
			return getRuleContext(AttrlistContext.class,0);
		}
		public List<CommentContext> comment() {
			return getRuleContexts(CommentContext.class);
		}
		public CommentContext comment(int i) {
			return getRuleContext(CommentContext.class,i);
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
			setState(49);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(46);
				comment();
				}
				}
				setState(51);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(52);
			match(TABLE);
			setState(53);
			match(DATUM);
			setState(54);
			match(T__2);
			setState(55);
			attrlist();
			setState(56);
			match(T__3);
			setState(67);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(57);
				match(T__4);
				setState(63); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(58);
					match(T__2);
					setState(59);
					datalist();
					setState(60);
					match(T__3);
					setState(61);
					match(T__1);
					}
					}
					setState(65); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__2 );
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
			setState(74);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				_localctx = new SingleAttributeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(69);
				attribute();
				}
				break;
			case 2:
				_localctx = new AttributeListContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(70);
				attribute();
				setState(71);
				match(T__1);
				setState(72);
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
			setState(81);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				_localctx = new SingleDatumContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(76);
				datum();
				}
				break;
			case 2:
				_localctx = new DataListContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(77);
				datum();
				setState(78);
				match(T__5);
				setState(79);
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
		public TerminalNode DATUM() { return getToken(DatabaseParser.DATUM, 0); }
		public DatatypeContext datatype() {
			return getRuleContext(DatatypeContext.class,0);
		}
		public TerminalNode PK() { return getToken(DatabaseParser.PK, 0); }
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
		int _la;
		try {
			_localctx = new AttributeValueContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			match(DATUM);
			setState(84);
			match(T__6);
			setState(85);
			datatype();
			setState(88);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(86);
				match(T__5);
				setState(87);
				match(PK);
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
		public TerminalNode DATUM() { return getToken(DatabaseParser.DATUM, 0); }
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
			_localctx = new DatumValueContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			match(DATUM);
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

	public static class DatatypeContext extends ParserRuleContext {
		public DatatypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_datatype; }
	 
		public DatatypeContext() { }
		public void copyFrom(DatatypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DateValueContext extends DatatypeContext {
		public TerminalNode DATE() { return getToken(DatabaseParser.DATE, 0); }
		public DateValueContext(DatatypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DatabaseVisitor ) return ((DatabaseVisitor<? extends T>)visitor).visitDateValue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StringValueContext extends DatatypeContext {
		public TerminalNode STRING() { return getToken(DatabaseParser.STRING, 0); }
		public StringValueContext(DatatypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DatabaseVisitor ) return ((DatabaseVisitor<? extends T>)visitor).visitStringValue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CharValueContext extends DatatypeContext {
		public TerminalNode CHAR() { return getToken(DatabaseParser.CHAR, 0); }
		public CharValueContext(DatatypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DatabaseVisitor ) return ((DatabaseVisitor<? extends T>)visitor).visitCharValue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntegerValueContext extends DatatypeContext {
		public TerminalNode INT() { return getToken(DatabaseParser.INT, 0); }
		public IntegerValueContext(DatatypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DatabaseVisitor ) return ((DatabaseVisitor<? extends T>)visitor).visitIntegerValue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FloatValueContext extends DatatypeContext {
		public TerminalNode FLOAT() { return getToken(DatabaseParser.FLOAT, 0); }
		public FloatValueContext(DatatypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DatabaseVisitor ) return ((DatabaseVisitor<? extends T>)visitor).visitFloatValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DatatypeContext datatype() throws RecognitionException {
		DatatypeContext _localctx = new DatatypeContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_datatype);
		try {
			setState(97);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
				_localctx = new StringValueContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(92);
				match(STRING);
				}
				break;
			case CHAR:
				_localctx = new CharValueContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(93);
				match(CHAR);
				}
				break;
			case INT:
				_localctx = new IntegerValueContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(94);
				match(INT);
				}
				break;
			case FLOAT:
				_localctx = new FloatValueContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(95);
				match(FLOAT);
				}
				break;
			case DATE:
				_localctx = new DateValueContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(96);
				match(DATE);
				}
				break;
			default:
				throw new NoViableAltException(this);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\23f\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\7\2\26"+
		"\n\2\f\2\16\2\31\13\2\3\2\3\2\7\2\35\n\2\f\2\16\2 \13\2\3\3\3\3\7\3$\n"+
		"\3\f\3\16\3\'\13\3\3\4\3\4\3\4\3\4\6\4-\n\4\r\4\16\4.\3\5\7\5\62\n\5\f"+
		"\5\16\5\65\13\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\6\5B\n\5\r"+
		"\5\16\5C\5\5F\n\5\3\6\3\6\3\6\3\6\3\6\5\6M\n\6\3\7\3\7\3\7\3\7\3\7\5\7"+
		"T\n\7\3\b\3\b\3\b\3\b\3\b\5\b[\n\b\3\t\3\t\3\n\3\n\3\n\3\n\3\n\5\nd\n"+
		"\n\3\n\3%\2\13\2\4\6\b\n\f\16\20\22\2\2j\2\27\3\2\2\2\4!\3\2\2\2\6(\3"+
		"\2\2\2\b\63\3\2\2\2\nL\3\2\2\2\fS\3\2\2\2\16U\3\2\2\2\20\\\3\2\2\2\22"+
		"c\3\2\2\2\24\26\5\4\3\2\25\24\3\2\2\2\26\31\3\2\2\2\27\25\3\2\2\2\27\30"+
		"\3\2\2\2\30\32\3\2\2\2\31\27\3\2\2\2\32\36\5\6\4\2\33\35\5\4\3\2\34\33"+
		"\3\2\2\2\35 \3\2\2\2\36\34\3\2\2\2\36\37\3\2\2\2\37\3\3\2\2\2 \36\3\2"+
		"\2\2!%\7\3\2\2\"$\13\2\2\2#\"\3\2\2\2$\'\3\2\2\2%&\3\2\2\2%#\3\2\2\2&"+
		"\5\3\2\2\2\'%\3\2\2\2()\7\n\2\2)*\7\22\2\2*,\7\4\2\2+-\5\b\5\2,+\3\2\2"+
		"\2-.\3\2\2\2.,\3\2\2\2./\3\2\2\2/\7\3\2\2\2\60\62\5\4\3\2\61\60\3\2\2"+
		"\2\62\65\3\2\2\2\63\61\3\2\2\2\63\64\3\2\2\2\64\66\3\2\2\2\65\63\3\2\2"+
		"\2\66\67\7\13\2\2\678\7\22\2\289\7\5\2\29:\5\n\6\2:E\7\6\2\2;A\7\7\2\2"+
		"<=\7\5\2\2=>\5\f\7\2>?\7\6\2\2?@\7\4\2\2@B\3\2\2\2A<\3\2\2\2BC\3\2\2\2"+
		"CA\3\2\2\2CD\3\2\2\2DF\3\2\2\2E;\3\2\2\2EF\3\2\2\2F\t\3\2\2\2GM\5\16\b"+
		"\2HI\5\16\b\2IJ\7\4\2\2JK\5\n\6\2KM\3\2\2\2LG\3\2\2\2LH\3\2\2\2M\13\3"+
		"\2\2\2NT\5\20\t\2OP\5\20\t\2PQ\7\b\2\2QR\5\f\7\2RT\3\2\2\2SN\3\2\2\2S"+
		"O\3\2\2\2T\r\3\2\2\2UV\7\22\2\2VW\7\t\2\2WZ\5\22\n\2XY\7\b\2\2Y[\7\21"+
		"\2\2ZX\3\2\2\2Z[\3\2\2\2[\17\3\2\2\2\\]\7\22\2\2]\21\3\2\2\2^d\7\f\2\2"+
		"_d\7\r\2\2`d\7\16\2\2ad\7\17\2\2bd\7\20\2\2c^\3\2\2\2c_\3\2\2\2c`\3\2"+
		"\2\2ca\3\2\2\2cb\3\2\2\2d\23\3\2\2\2\r\27\36%.\63CELSZc";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}