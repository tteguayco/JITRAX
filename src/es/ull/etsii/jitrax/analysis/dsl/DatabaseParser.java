package es.ull.etsii.jitrax.analysis.dsl;

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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, DATABASE=7, TABLE=8, STRING=9, 
		CHAR=10, INT=11, FLOAT=12, DATE=13, STRING_VAL=14, NUMBER=15, ID=16, WHITESPACES=17;
	public static final int
		RULE_start = 0, RULE_database = 1, RULE_table = 2, RULE_attrlist = 3, 
		RULE_datalist = 4, RULE_attribute = 5, RULE_datum = 6, RULE_datatype = 7;
	public static final String[] ruleNames = {
		"start", "database", "table", "attrlist", "datalist", "attribute", "datum", 
		"datatype"
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(16);
			database();
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
		public TerminalNode ID() { return getToken(DatabaseParser.ID, 0); }
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
		enterRule(_localctx, 2, RULE_database);
		int _la;
		try {
			_localctx = new DatabaseCreationContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(18);
			match(DATABASE);
			setState(19);
			match(ID);
			setState(20);
			match(T__0);
			setState(22); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(21);
				table();
				}
				}
				setState(24); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==TABLE );
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
		public TerminalNode ID() { return getToken(DatabaseParser.ID, 0); }
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
		enterRule(_localctx, 4, RULE_table);
		int _la;
		try {
			_localctx = new TableCreationContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(26);
			match(TABLE);
			setState(27);
			match(ID);
			setState(28);
			match(T__1);
			setState(29);
			attrlist();
			setState(30);
			match(T__2);
			setState(41);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(31);
				match(T__3);
				setState(37); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(32);
					match(T__1);
					setState(33);
					datalist();
					setState(34);
					match(T__2);
					setState(35);
					match(T__0);
					}
					}
					setState(39); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__1 );
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
		enterRule(_localctx, 6, RULE_attrlist);
		try {
			setState(48);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				_localctx = new SingleAttributeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(43);
				attribute();
				}
				break;
			case 2:
				_localctx = new AttributeListContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(44);
				attribute();
				setState(45);
				match(T__4);
				setState(46);
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
		enterRule(_localctx, 8, RULE_datalist);
		try {
			setState(55);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				_localctx = new SingleDatumContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(50);
				datum();
				}
				break;
			case 2:
				_localctx = new DataListContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(51);
				datum();
				setState(52);
				match(T__4);
				setState(53);
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
		public TerminalNode ID() { return getToken(DatabaseParser.ID, 0); }
		public DatatypeContext datatype() {
			return getRuleContext(DatatypeContext.class,0);
		}
		public AttributeValueContext(AttributeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DatabaseVisitor ) return ((DatabaseVisitor<? extends T>)visitor).visitAttributeValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributeContext attribute() throws RecognitionException {
		AttributeContext _localctx = new AttributeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_attribute);
		try {
			_localctx = new AttributeValueContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			match(ID);
			setState(58);
			match(T__5);
			setState(59);
			datatype();
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
	public static class NumberDatumContext extends DatumContext {
		public TerminalNode NUMBER() { return getToken(DatabaseParser.NUMBER, 0); }
		public NumberDatumContext(DatumContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DatabaseVisitor ) return ((DatabaseVisitor<? extends T>)visitor).visitNumberDatum(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StringDatumContext extends DatumContext {
		public TerminalNode STRING_VAL() { return getToken(DatabaseParser.STRING_VAL, 0); }
		public StringDatumContext(DatumContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DatabaseVisitor ) return ((DatabaseVisitor<? extends T>)visitor).visitStringDatum(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DatumContext datum() throws RecognitionException {
		DatumContext _localctx = new DatumContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_datum);
		try {
			setState(63);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING_VAL:
				_localctx = new StringDatumContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(61);
				match(STRING_VAL);
				}
				break;
			case NUMBER:
				_localctx = new NumberDatumContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(62);
				match(NUMBER);
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
		enterRule(_localctx, 14, RULE_datatype);
		try {
			setState(70);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
				_localctx = new StringValueContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(65);
				match(STRING);
				}
				break;
			case CHAR:
				_localctx = new CharValueContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(66);
				match(CHAR);
				}
				break;
			case INT:
				_localctx = new IntegerValueContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(67);
				match(INT);
				}
				break;
			case FLOAT:
				_localctx = new FloatValueContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(68);
				match(FLOAT);
				}
				break;
			case DATE:
				_localctx = new DateValueContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(69);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\23K\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\3\2\3\3\3\3\3\3"+
		"\3\3\6\3\31\n\3\r\3\16\3\32\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\6\4(\n\4\r\4\16\4)\5\4,\n\4\3\5\3\5\3\5\3\5\3\5\5\5\63\n\5\3\6\3\6"+
		"\3\6\3\6\3\6\5\6:\n\6\3\7\3\7\3\7\3\7\3\b\3\b\5\bB\n\b\3\t\3\t\3\t\3\t"+
		"\3\t\5\tI\n\t\3\t\2\2\n\2\4\6\b\n\f\16\20\2\2L\2\22\3\2\2\2\4\24\3\2\2"+
		"\2\6\34\3\2\2\2\b\62\3\2\2\2\n9\3\2\2\2\f;\3\2\2\2\16A\3\2\2\2\20H\3\2"+
		"\2\2\22\23\5\4\3\2\23\3\3\2\2\2\24\25\7\t\2\2\25\26\7\22\2\2\26\30\7\3"+
		"\2\2\27\31\5\6\4\2\30\27\3\2\2\2\31\32\3\2\2\2\32\30\3\2\2\2\32\33\3\2"+
		"\2\2\33\5\3\2\2\2\34\35\7\n\2\2\35\36\7\22\2\2\36\37\7\4\2\2\37 \5\b\5"+
		"\2 +\7\5\2\2!\'\7\6\2\2\"#\7\4\2\2#$\5\n\6\2$%\7\5\2\2%&\7\3\2\2&(\3\2"+
		"\2\2\'\"\3\2\2\2()\3\2\2\2)\'\3\2\2\2)*\3\2\2\2*,\3\2\2\2+!\3\2\2\2+,"+
		"\3\2\2\2,\7\3\2\2\2-\63\5\f\7\2./\5\f\7\2/\60\7\7\2\2\60\61\5\b\5\2\61"+
		"\63\3\2\2\2\62-\3\2\2\2\62.\3\2\2\2\63\t\3\2\2\2\64:\5\16\b\2\65\66\5"+
		"\16\b\2\66\67\7\7\2\2\678\5\n\6\28:\3\2\2\29\64\3\2\2\29\65\3\2\2\2:\13"+
		"\3\2\2\2;<\7\22\2\2<=\7\b\2\2=>\5\20\t\2>\r\3\2\2\2?B\7\20\2\2@B\7\21"+
		"\2\2A?\3\2\2\2A@\3\2\2\2B\17\3\2\2\2CI\7\13\2\2DI\7\f\2\2EI\7\r\2\2FI"+
		"\7\16\2\2GI\7\17\2\2HC\3\2\2\2HD\3\2\2\2HE\3\2\2\2HF\3\2\2\2HG\3\2\2\2"+
		"I\21\3\2\2\2\t\32)+\629AH";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}